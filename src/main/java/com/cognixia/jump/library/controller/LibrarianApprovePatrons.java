package com.cognixia.jump.library.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.library.dao.PatronDAOClass;
import com.cognixia.jump.library.model.Patron;



public class LibrarianApprovePatrons extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LibrarianApprovePatrons() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] ids = request.getParameterValues("patron");
		
		PatronDAOClass db = new PatronDAOClass();
		
		if (ids != null) {
			
			for(String id:ids) {
				
				Patron patron = db.getPatronByID(Integer.parseInt(id));
				patron.setAccount_frozen(!patron.isAccount_frozen());
				db.updatePatron(patron);
				
			}
			
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("librarian.jsp");
		dispatcher.forward(request, response);
	}

}
