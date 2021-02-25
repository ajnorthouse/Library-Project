package com.cognixia.jump.library.controller;

import java.io.IOException;

import com.cognixia.jump.library.dao.LibrarianDAO;
import com.cognixia.jump.library.dao.LibrarianDAOClass;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibrarianDAO db;
	

    @Override
    public void init() throws ServletException {
    	this.db = new LibrarianDAOClass();
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
