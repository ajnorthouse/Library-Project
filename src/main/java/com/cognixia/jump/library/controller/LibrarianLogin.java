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

public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibrarianDAO db;
	private Librarian librarian;
	private int result;
	

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
		
		//send to class that helps check login info.
		result = LoginHelper.checkLogin(librarian, db);
		
		//update jsp with feedback OR send to new page.
		switch (result){
		
		//bad password
		case -1:
			//code to update jsp
			request.setAttribute("error", "Bad password match, please try again.");
			break;
			
		//bad username
		case 0:
			//code to update jsp
			request.setAttribute("error", "No matching username in database, please try again.");
			break;
		
		//successful login
		default:
			request.setAttribute("librarian_id", result);
			break;
		}
	}
	
}
