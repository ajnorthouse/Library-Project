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
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PatronUpdate
 */
public class PatronUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatronDAO db;
	private Patron patron;
	HttpSession session;
	
	@Override
	public void init() throws ServletException {
		db = new PatronDAOClass();
	}
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		
		if(session.getAttribute("patron_id")!=null){
		    int id = ((int)session.getAttribute("patron_id"));
		    patron = db.getPatronByID(id);
		    request.setAttribute("patron_id", patron.getPatron_id());
		    request.setAttribute("first_name", patron.getFirst_name());
		    request.setAttribute("last_name", patron.getLast_name());
		    request.setAttribute("username", patron.getUsername());
		    request.setAttribute("password", patron.getPassword());
		    request.setAttribute("account_frozen", patron.isAccount_frozen());
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/update_patron.jsp");
		    dispatcher.forward(request, response);
		}
		else{    
			System.out.println("No ID");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean account_frozen = Boolean.valueOf(request.getParameter("account_frozen"));
		int id = Integer.parseInt(request.getParameter("patron_id"));
		patron = new Patron(id,first_name,last_name,username,password,account_frozen);
		db.updatePatron(patron);
		doGet(request, response);
	}
}

