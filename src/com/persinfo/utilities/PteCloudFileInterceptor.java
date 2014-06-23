/**
 * 
 */
package com.persinfo.utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.FileUploadInterceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.util.LocalizedTextUtil;
import com.opensymphony.xwork2.util.TextParseUtil;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.struts2.gae.dispatcher.multipart.GaeMultiPartRequestWrapper;
import com.struts2.gae.interceptor.GaeFileUploadInterceptor;

/**
 * @author deva
 *
 */
public class PteCloudFileInterceptor extends GaeFileUploadInterceptor {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8135436662198447380L;
     protected static final Logger LOG = LoggerFactory.getLogger(FileUploadInterceptor.class);
 private static final String DEFAULT_MESSAGE = "no.message.found";

 protected boolean useActionMessageBundle;

 protected Long maximumSize;
 protected Set<String> allowedTypesSet = Collections.emptySet();
 protected Set<String> allowedExtensionsSet = Collections.emptySet();

 public void setUseActionMessageBundle(String value) {
     this.useActionMessageBundle = Boolean.valueOf(value);
 }

 /**
  * Sets the allowed extensions
  *
  * @param allowedExtensions A comma-delimited list of extensions
  */
 public void setAllowedExtensions(String allowedExtensions) {
     allowedExtensionsSet = TextParseUtil.commaDelimitedStringToSet(allowedExtensions);
 }

 /**
  * Sets the allowed mimetypes
  *
  * @param allowedTypes A comma-delimited list of types
  */
 public void setAllowedTypes(String allowedTypes) {
     allowedTypesSet = TextParseUtil.commaDelimitedStringToSet(allowedTypes);
 }

 /**
  * Sets the maximum size of an uploaded file
  *
  * @param maximumSize The maximum size in bytes
  */
 public void setMaximumSize(Long maximumSize) {
     this.maximumSize = maximumSize;
 }

 /* (non-Javadoc)
  * @see com.opensymphony.xwork2.interceptor.Interceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
  */
 public String intercept(ActionInvocation invocation) throws Exception {
     ActionContext ac = invocation.getInvocationContext();

     HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);

     if (!(request instanceof GaeMultiPartRequestWrapper)) {
         if (LOG.isDebugEnabled()) {
             ActionProxy proxy = invocation.getProxy();
             LOG.debug(getTextMessage("struts.messages.bypass.request", new Object[]{proxy.getNamespace(), proxy.getActionName()}, ac.getLocale()));
         }

         return invocation.invoke();
     }

     ValidationAware validation = null;

     Object action = invocation.getAction();

     if (action instanceof ValidationAware) {
         validation = (ValidationAware) action;
     }

     GaeMultiPartRequestWrapper multiWrapper = (GaeMultiPartRequestWrapper) request;

     if (multiWrapper.hasErrors()) {
         for (String error : multiWrapper.getErrors()) {
             if (validation != null) {
                 validation.addActionError(error);
             }

             LOG.error(error);
         }
     }

     // bind allowed Files
     Enumeration<String> fileParameterNames = multiWrapper.getFileParameterNames();
     while (fileParameterNames != null && fileParameterNames.hasMoreElements()) {
         // get the value of this input tag
         String inputName = fileParameterNames.nextElement();

         // get the content type
         String[] contentType = multiWrapper.getContentTypes(inputName);

         if (isNonEmpty(contentType)) {
             // get the name of the file from the input tag
             String[] fileName = multiWrapper.getFileNames(inputName);

             if (isNonEmpty(fileName)) {

                     String[] fileItemStreams = multiWrapper.getFileContents(inputName);
                     // get a File object for the uploaded File
                 if (fileItemStreams != null && fileItemStreams.length > 0) {
                     List<String> acceptedFiles = new ArrayList<String>(fileItemStreams.length);
                     List<String> acceptedContentTypes = new ArrayList<String>(fileItemStreams.length);
                     List<String> acceptedFileNames = new ArrayList<String>(fileItemStreams.length);
                     String contentTypeName = inputName + "ContentType";
                     String fileNameName = inputName + "FileName";

                     for (int index = 0; index < fileItemStreams.length; index++) {
                         if (acceptFile(action, fileItemStreams[index], fileName[index], contentType[index], inputName, validation, ac.getLocale())) {
                             acceptedFiles.add((fileItemStreams[index]));
                             acceptedContentTypes.add(contentType[index]);
                             acceptedFileNames.add(fileName[index]);
                         }
                     }

                     if (!acceptedFiles.isEmpty()) {
                         Map<String, Object> params = ac.getParameters();

                         params.put(inputName, acceptedFiles.toArray(new String[acceptedFiles.size()]));
                         params.put(contentTypeName, acceptedContentTypes.toArray(new String[acceptedContentTypes.size()]));
                         params.put(fileNameName, acceptedFileNames.toArray(new String[acceptedFileNames.size()]));
                     }
                 }
             } else {
                 LOG.error(getTextMessage(action, "struts.messages.invalid.file", new Object[]{inputName}, ac.getLocale()));
             }
         } else {
             LOG.error(getTextMessage(action, "struts.messages.invalid.content.type", new Object[]{inputName}, ac.getLocale()));
         }
     }

     // invoke action
     String result = invocation.invoke();

     // cleanup

     return result;
 }

 /**
  * Override for added functionality. Checks if the proposed file is acceptable based on contentType and size.
  *
  * @param action      - uploading action for message retrieval.
  * @param file        - proposed upload file.
  * @param contentType - contentType of the file.
  * @param inputName   - inputName of the file.
  * @param validation  - Non-null ValidationAware if the action implements ValidationAware, allowing for better
  *                    logging.
  * @param locale
  * @return true if the proposed file is acceptable by contentType and size.
  * @throws IOException
  */
 protected boolean acceptFile(Object action, String file, String filename, String contentType, String inputName, ValidationAware validation, Locale locale) throws IOException {
     boolean fileIsAcceptable = false;

     // If it's null the upload failed
     if (file == null) {
         String errMsg = getTextMessage(action, "struts.messages.error.uploading", new Object[]{inputName}, locale);
         if (validation != null) {
             validation.addFieldError(inputName, errMsg);
         }

         LOG.error(errMsg);
     } else if (maximumSize != null && maximumSize < file.getBytes().length) {
         String errMsg = getTextMessage(action, "struts.messages.error.file.too.large", new Object[]{inputName, filename, "" + file.getBytes().length}, locale);
         if (validation != null) {
             validation.addFieldError(inputName, errMsg);
         }

         LOG.error(errMsg);
     } else if ((!allowedTypesSet.isEmpty()) && (!containsItem(allowedTypesSet, contentType))) {
         String errMsg = getTextMessage(action, "struts.messages.error.content.type.not.allowed", new Object[]{inputName, filename,  contentType}, locale);
         if (validation != null) {
             validation.addFieldError(inputName, errMsg);
         }

         LOG.error(errMsg);
     } else if ((! allowedExtensionsSet.isEmpty()) && (!hasAllowedExtension(allowedExtensionsSet, filename))) {
         String errMsg = getTextMessage(action, "struts.messages.error.file.extension.not.allowed", new Object[]{inputName, filename,  contentType}, locale);
         if (validation != null) {
             validation.addFieldError(inputName, errMsg);
         }

         LOG.error(errMsg);
     } else {
         fileIsAcceptable = true;
     }

     return fileIsAcceptable;
 }

 /**
  * @param extensionCollection - Collection of extensions (all lowercase).
  * @param filename            - filename to check.
  * @return true if the filename has an allowed extension, false otherwise.
  */
 private static boolean hasAllowedExtension(Collection<String> extensionCollection, String filename) {
     if (filename == null) {
         return false;
     }

     String lowercaseFilename = filename.toLowerCase();
     for (String extension : extensionCollection) {
         if (lowercaseFilename.endsWith(extension)) {
             return true;
         }
     }

     return false;
 }

 /**
  * @param itemCollection - Collection of string items (all lowercase).
  * @param item           - Item to search for.
  * @return true if itemCollection contains the item, false otherwise.
  */
 private static boolean containsItem(Collection<String> itemCollection, String item) {
     return itemCollection.contains(item.toLowerCase());
 }

 private static boolean isNonEmpty(Object[] objArray) {
     boolean result = false;
     for (int index = 0; index < objArray.length && !result; index++) {
         if (objArray[index] != null) {
             result = true;
         }
     }
     return result;
 }

 private String getTextMessage(String messageKey, Object[] args, Locale locale) {
     return getTextMessage(null, messageKey, args, locale);
 }

 private String getTextMessage(Object action, String messageKey, Object[] args, Locale locale) {
     if (args == null || args.length == 0) {
         if ( action != null && useActionMessageBundle) {
             return LocalizedTextUtil.findText(action.getClass(), messageKey, locale);
         }
         return LocalizedTextUtil.findText(this.getClass(), messageKey, locale);
     } else {
         if ( action != null && useActionMessageBundle) {
             return LocalizedTextUtil.findText(action.getClass(), messageKey, locale, DEFAULT_MESSAGE, args);
         }
         return LocalizedTextUtil.findText(this.getClass(), messageKey, locale, DEFAULT_MESSAGE, args);
     }
 }

	
}
