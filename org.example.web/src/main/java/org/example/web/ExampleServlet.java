package org.example.web;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.http.whiteboard.HttpWhiteboardConstants;

@Component(property = {
		HttpWhiteboardConstants.HTTP_WHITEBOARD_SERVLET_PATTERN + "=/"
})
public class ExampleServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try (PrintStream stream = new PrintStream(resp.getOutputStream())) {
			stream.println("Hello World");
			stream.flush();
		}
	}
}
