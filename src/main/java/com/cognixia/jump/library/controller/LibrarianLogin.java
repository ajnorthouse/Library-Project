package com.cognixia.jump.library.controller;

import java.io.IOException;

import com.cognixia.jump.library.dao.LibrarianDAO;
import com.cognixia.jump.library.dao.LibrarianDAOClass;
import com.cognixia.jump.library.helper.LoginHelper;
import com.cognixia.jump.library.model.Librarian;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;

public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibrarianDAO db;
	private Librarian librarian;
	

    @Override
    public void init() throws ServletException {
    	this.db = new LibrarianDAOClass();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//I don't believe there should be anything here.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect info from jsp
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//create temporary object.
		if (librarian == null) {
			librarian = new Librarian();
		}
		librarian.setUsername(username);
		librarian.setPassword(password);
		
		//uses helper class to check login
		int result = LoginHelper.checkLogin(librarian, db);
		
		//create dispatcher for use in the switch case statement
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login_librarian.jsp");
		
		switch (result){
		//bad password result
		case -1:
			request.setAttribute("error", "Bad password match, please try again.");
			dispatcher.forward(request, response);
			break;
			
		//bad username result
		case 0:
			request.setAttribute("error", "No matching username in database, please try again.");
			dispatcher.forward(request, response);
			break;
		
		//successful login result
		default:
			dispatcher = request.getRequestDispatcher("/");
			request.setAttribute("librarian_id", result);
			dispatcher.forward(request, response);
			break;
		}
	}
	
}
