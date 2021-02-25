package com.cognixia.jump.library.controller;

import java.io.IOException;

import com.cognixia.jump.library.dao.PatronDAO;
import com.cognixia.jump.library.dao.PatronDAOClass;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class PatronLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatronDAO db;


	@Override
	public void init() throws ServletException {
		db = new PatronDAOClass();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//I don't believe there should be anything here.
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect info from jsp
		
		
		//create temporary object.
		
		
		//send to class that helps check login info.
		
		
		//update jsp with feedback OR send to new page.
		
	}

}
