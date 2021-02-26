package com.cognixia.jump.library.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.cognixia.jump.library.dao.LibrarianDAO;
import com.cognixia.jump.library.dao.LibrarianDAOClass;
import com.cognixia.jump.library.model.Librarian;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;



public class LibrarianUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	HttpSession session;
	private LibrarianDAO db;
	
    public LibrarianUpdate() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	this.db = new LibrarianDAOClass();
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		
		if(session.getAttribute("librarian_id")!=null){
		    int id = ((int)session.getAttribute("librarian_id"));
		    Librarian librarian = db.getLibrarianByID(id);
		    request.setAttribute("username", librarian.getUsername());
		    request.setAttribute("password", librarian.getPassword());
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/update_librarian.jsp");
		    dispatcher.forward(request, response);
		}
		else{    
			System.out.println("No ID");
		}
	}

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ID must be passed to this servlet
		int id = (int) session.getAttribute("librarian_id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		session.setAttribute("username", username);
		
		db.updateLibrarian(new Librarian(id,username,password)); 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/librarian.jsp");
		dispatcher.forward(request, response);
		
		
	}
}
