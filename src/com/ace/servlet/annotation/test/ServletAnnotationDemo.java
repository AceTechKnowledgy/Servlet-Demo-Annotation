package com.ace.servlet.annotation.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
			name="Sample Servlet", //Name of the servlet <servlet-name> in web.xml file
			urlPatterns = {"/getMethod", "/submitRequest"}, //url patters <url-pattern> in web.xml file
			loadOnStartup = 1, //Load on startup option <load-on-startup> in web.xml file
			initParams = {@WebInitParam(name = "Author", value = "Sivakumar")} //<init-param> in web.xml file
		   )
public class ServletAnnotationDemo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Set the response type as html
		resp.setContentType("text/html");
		
		//Getting the init parameter data
		String authorName = getInitParameter("Author");
		
		resp.getWriter().println("<h1> Welcome to Servlet With Demo and the author is " + authorName + "</h1>");
		resp.getWriter().close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Set the response type as html
		resp.setContentType("text/html");
		
		//Get the input values from the page or form
		String userName = req.getParameter("userName");
		@SuppressWarnings("unused")
		String password = req.getParameter("password");
		
		resp.getWriter().println("<h1> Welcome User...! "+ userName + "</h1>");
		resp.getWriter().close();
	}
	
	
}
