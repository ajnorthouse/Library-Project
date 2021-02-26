package com.cognixia.jump.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.library.dao.LibrarianDAO;
import com.cognixia.jump.library.dao.PatronDAOClass;
import com.cognixia.jump.library.model.Librarian;
import com.cognixia.jump.library.model.Patron;

import jakarta.servlet.RequestDispatcher;


public class LibrarianApprovesPatron extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LibrarianApprovesPatron() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private PatronDAOClass db;
    
    @Override
	public void init() throws ServletException {
		this.db = new PatronDAOClass();
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("first_name");
		String lastname = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean accountFrozen = false; //Librarian is unfreezing this patron when 'Unfreeze Patron' is hit
		
		
		db.updatePatron(new Patron(0, firstname, lastname, username, password, accountFrozen)); 
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
	}

}
