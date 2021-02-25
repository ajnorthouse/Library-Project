package com.cognixia.jump.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.library.model.Patron;

import jakarta.servlet.RequestDispatcher;


public class LibrarianApprovePatrons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LibrarianApprovePatrons() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean accountFrozen = true;
		
		Patron patron = new Patron(0, firstname, lastname, username, password, accountFrozen);
		
		//yet to update the code here to approve patron pending activations and to decide whether they need a separate jsp file for this activity
		
		//RequestDispatcher dispatcher = (RequestDispatcher) request.getRequestDispatcher("/");
		//dispatcher.forward(request, response);
	}

}
