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
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/update_patron.jsp");
		    dispatcher.forward(request, response);
		}
		else{    
			System.out.println("No ID");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//collect update data
		//pull data base
		
			
		doGet(request, response);
	}

}
