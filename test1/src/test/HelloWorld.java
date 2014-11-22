package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {
	// private String message;
	//
	// public void init() throws ServletException {
	// Do required initialization
	// message = "Hello World";
	// }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Set response content type
		response.setContentType("text/html");

		// // Actual logic goes here.
		// PrintWriter out = response.getWriter();
		// out.println("<h1>" + message + "</h1>");

		String newMessage = request.getParameter("message");// gets the message
															// submitted by the
															// url and stores in
															// variable
		request.setAttribute("msgNew", newMessage);// assigns message to a Key
													// for showing in the html

		String customMessage = CheckPost(newMessage);

		String teachName = "Thomas";
		request.setAttribute("mainMessage", "Hi I am " + teachName);
		request.setAttribute("msg", "Hello");
		request.setAttribute("name", "John");

		request.setAttribute("custMsg", customMessage);

		String nextJSP = "/test01.jsp";
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
	}

	public void destroy() {

		// do nothing.
	}

	private String CheckPost(String someValue) {
		String custMsg = "I'm sorry I dont know you";

		if ("John".equals(someValue)) {
			custMsg = "nice to see John keep working hard";
		}

		else if ("Thomas".equals(someValue)) {

			custMsg = "welcome to Canada, we are glad to have you here.";

		}

		return custMsg;
	}
}
