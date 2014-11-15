package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	private String message;

	public void init() throws ServletException {
		// Do required initialization
		message = "Hello World";
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

//		// Actual logic goes here.
//		PrintWriter out = response.getWriter();
//		out.println("<h1>" + message + "</h1>");
//		
//		
		
		
		request.setAttribute("msg", "Hello");		
		request.setAttribute("name", "John");
		
		String nextJSP = "/test01.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request,response);
	}

	public void destroy() {
		// do nothing.
	}
}
