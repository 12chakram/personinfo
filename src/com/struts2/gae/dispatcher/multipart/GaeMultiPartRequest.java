package com.struts2.gae.dispatcher.multipart;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.apache.struts2.StrutsConstants;
import org.apache.struts2.dispatcher.multipart.MultiPartRequest;

import com.opensymphony.xwork2.inject.Inject;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * Multipart form data request adapter for Jakarta Commons Fileupload package.This class does not implement  {@link MultiPartRequest} as it
 * provide some additional functionality which are required for doing file upload on google app engine.
 * This class should be specifically used for Google App Engine.
 *
 * @author whyjava7@gmail.com
 * @version 0.1
 *
 */
public class GaeMultiPartRequest {

        static final Logger LOG = LoggerFactory.getLogger(GaeMultiPartRequest.class);

    // maps parameter name -> List of FileItemStream objects
    private final Map<String,List<FileItemStream>> files = new HashMap<String,List<FileItemStream>>();

    // maps parameter name -> List of String which contains encoded file contents
    private final Map<String, List<String>> fileContents = new HashMap<String, List<String>>();

    // maps parameter name -> List of param values
    private final Map<String,List<String>> params = new HashMap<String,List<String>>();

    // any errors while processing this request
    private final List<String> errors = new ArrayList<String>();

    private long maxSize;

    @Inject(StrutsConstants.STRUTS_MULTIPART_MAXSIZE)
    public void setMaxSize(String maxSize) {
        this.maxSize = Long.parseLong(maxSize);
    }

    /**
     * Creates a new request wrapper to handle multi-part data using methods adapted from Jason Pell's
     * multipart classes (see class description).
     *
     * @param request the request containing the multipart
     * @throws java.io.IOException  is thrown if encoding fails.
     */
    public void parse(HttpServletRequest request)
            throws IOException {

        // Parse the request
        try {
            ServletFileUpload upload = new ServletFileUpload();
            upload.setSizeMax(1073741824);

            FileItemIterator iterator = upload.getItemIterator(request);

            while (iterator.hasNext()) {
                FileItemStream itemStream = iterator.next();
                        InputStream in = itemStream.openStream();

                if (LOG.isDebugEnabled()) LOG.debug("Found item " + itemStream.getFieldName());
                if (itemStream.isFormField()) {
                    LOG.debug("Item is a normal form field");
                    List<String> values;
                    if (params.get(itemStream.getFieldName()) != null) {
                        values = params.get(itemStream.getFieldName());
                    } else {
                        values = new ArrayList<String>();
                    }

                    values.add(IOUtils.toString(in,"ISO-8859-1"));
                    params.put(itemStream.getFieldName(), values);
                } else {
                    LOG.debug("Item is a file upload");

                    // Skip file uploads that don't have a file name - meaning that no file was selected.
                    if (itemStream.getName() == null || itemStream.getName().trim().length() < 1) {
                        LOG.debug("No file has been uploaded for the field: " + itemStream.getFieldName());
                        continue;
                    }

                    List<FileItemStream> values;
                    List<String> fileValues;
                    if (files.get(itemStream.getFieldName()) != null) {
                        values = files.get(itemStream.getFieldName());
                        fileValues = fileContents.get(itemStream.getFieldName());
                    } else {
                        values = new ArrayList<FileItemStream>();
                        fileValues = new ArrayList<String>();
                    }

                    values.add(itemStream);
                    fileValues.add(IOUtils.toString(itemStream.openStream(),"ISO-8859-1"));
                    files.put(itemStream.getFieldName(), values);
                    fileContents.put(itemStream.getFieldName(), fileValues);
                }
            }
        } catch (FileUploadException e) {
            LOG.error("Unable to parse request", e);
            errors.add(e.getMessage());
        }
    }

    public Enumeration<String> getFileParameterNames() {
        return Collections.enumeration(files.keySet());
    }

    public String[] getContentType(String fieldName) {
        List<FileItemStream> items = files.get(fieldName);

        if (items == null) {
            return null;
        }

        List<String> contentTypes = new ArrayList<String>(items.size());
        for (FileItemStream fileItem : items) {
            contentTypes.add(fileItem.getContentType());
        }

        return contentTypes.toArray(new String[contentTypes.size()]);
    }

    public String[] getFileContents(String fieldName) {
        List<String> items = fileContents.get(fieldName);

        if (items == null) {
            return null;
        }

        return items.toArray(new String[items.size()]);
    }

    public String[] getFileNames(String fieldName) {
        List<FileItemStream> items = files.get(fieldName);

        if (items == null) {
            return null;
        }

        List<String> fileNames = new ArrayList<String>(items.size());
        for (FileItemStream fileItem : items) {
            fileNames.add(getCanonicalName(fileItem.getName()));
        }

        return fileNames.toArray(new String[fileNames.size()]);
    }

    public String[] getFilesystemName(String fieldName) {
        return null;
    }

    public String getParameter(String name) {
        List<String> v = params.get(name);
        if (v != null && v.size() > 0) {
            return v.get(0);
        }

        return null;
    }

    public Enumeration<String> getParameterNames() {
        return Collections.enumeration(params.keySet());
    }

    public String[] getParameterValues(String name) {
        List<String> v = params.get(name);
        if (v != null && v.size() > 0) {
            return v.toArray(new String[v.size()]);
        }

        return null;
    }

    public List<String> getErrors() {
        return errors;
    }

    /**
     * Returns the canonical name of the given file.
     *
     * @param filename  the given file
     * @return the canonical name of the given file
     */
    private String getCanonicalName(String filename) {
        int forwardSlash = filename.lastIndexOf("/");
        int backwardSlash = filename.lastIndexOf("\\");
        if (forwardSlash != -1 && forwardSlash > backwardSlash) {
            filename = filename.substring(forwardSlash + 1, filename.length());
        } else if (backwardSlash != -1 && backwardSlash >= forwardSlash) {
            filename = filename.substring(backwardSlash + 1, filename.length());
        }

        return filename;
    }

}