package com.struts2.gae.dispatcher;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.Dispatcher;
import org.apache.struts2.dispatcher.StrutsRequestWrapper;

import com.struts2.gae.dispatcher.multipart.GaeMultiPartRequest;
import com.struts2.gae.dispatcher.multipart.GaeMultiPartRequestWrapper;

/**
 * {@link GaeDispatcher} is an {@link Dispatcher} specific to Google App Engine.
 * This dispatcher overrides wrapRequest method of {@link Dispatcher} so that
 * multipart request can be handled in google app engine specific way.
 *
 * @author whyjava7@gmail.com
 * @version 0.1
 */
public class GaeDispatcher extends Dispatcher {

        public GaeDispatcher(ServletContext servletContext,
                        Map<String, String> initParams) {
                super(servletContext, initParams);
        }

        @Override
        public HttpServletRequest wrapRequest(HttpServletRequest request,
                        ServletContext servletContext) throws IOException {
        if (request instanceof StrutsRequestWrapper) {
            return request;
        }

        String content_type = request.getContentType();
        if (content_type != null && content_type.indexOf("multipart/form-data") != -1) {
                GaeMultiPartRequest multi = getContainer().inject(GaeMultiPartRequest.class);
            request = new GaeMultiPartRequestWrapper(multi, request);
        } else {
            request = new StrutsRequestWrapper(request);
        }

        return request;
        }
}