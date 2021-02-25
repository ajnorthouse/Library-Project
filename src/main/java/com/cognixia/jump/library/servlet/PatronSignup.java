package com.cognixia.jump.library.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PatronSignup
 */
public class PatronSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
    	super.init();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this is what's called when the webpage is loaded. :o
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//this is what's called when you send data
		doGet(request, response);
	}

}
