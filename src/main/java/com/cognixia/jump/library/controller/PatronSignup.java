package com.cognixia.jump.library.controller;

import java.io.IOException;

import com.cognixia.jump.library.dao.PatronDAO;
import com.cognixia.jump.library.dao.PatronDAOClass;
import com.cognixia.jump.library.model.Patron;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PatronSignup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatronDAO db;

    @Override
    public void init() throws ServletException {
    	this.db = new PatronDAOClass();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean accountFrozen = true;
		
		Patron patron = new Patron(0, firstname, lastname, username, password, accountFrozen);
		
		db.addPatron(patron);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

}
