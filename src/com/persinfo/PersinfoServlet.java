package com.persinfo;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.apache.struts2.ServletActionContext;

@SuppressWarnings("serial")
public class PersinfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//resp.setContentType("text/plain");
		//resp.getWriter().println("Hello, world");
		req.getRequestDispatcher(req.getRequestURI()).forward(ServletActionContext.getRequest(), ServletActionContext.getResponse());
	}
}
