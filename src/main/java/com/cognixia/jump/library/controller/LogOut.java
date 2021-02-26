package com.cognixia.jump.library.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.RequestDispatcher;

public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("patron_id", null);
		session.setAttribute("librarian_id", null);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("patron_id", null);
		session.setAttribute("librarian_id", null);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

}
