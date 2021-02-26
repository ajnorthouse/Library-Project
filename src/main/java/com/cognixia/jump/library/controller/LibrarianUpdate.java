package com.cognixia.jump.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.library.dao.LibrarianDAO;
import com.cognixia.jump.library.dao.LibrarianDAOClass;
import com.cognixia.jump.library.model.Librarian;



public class LibrarianUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LibrarianDAO db;
	
    public LibrarianUpdate() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	this.db = new LibrarianDAOClass();
    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ID must be passed to this servlet
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		db.updateLibrarian(new Librarian(id,username,password)); 
		
		javax.servlet.RequestDispatcher dispatcher = request.getRequestDispatcher("/");
		dispatcher.forward(request, response);
		
		
	}

}
