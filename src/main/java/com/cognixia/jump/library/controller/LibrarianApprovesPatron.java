package com.cognixia.jump.library.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.cognixia.jump.library.dao.PatronDAOClass;
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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("freeze"));
		int patron_id = Integer.parseInt(request.getParameter("freeze"));
		
		//we have two different buttons to freeze and unfreeze but the name of both these parameters is the same - "freeze" 
		List<Patron> patrons = new ArrayList<>();

		Patron patron = db.getPatronByID(patron_id);

		patron.setAccount_frozen(!patron.isAccount_frozen());

		db.updatePatron(patron);

		patrons = db.getAllPatrons();

		HttpSession session = request.getSession();
		session.setAttribute("patrons", patrons);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/librarian.jsp");
		dispatcher.forward(request, response);
	}

}
