package com.cognixia.jump.library.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.cognixia.jump.library.dao.BookDAO;
import com.cognixia.jump.library.dao.BookDAOClass;
import com.cognixia.jump.library.model.Book;


public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookDAO db;
    
    public BookServlet() {
		super();
	}
    
    @Override
    public void init() throws ServletException {
    	
    	db = new BookDAOClass();
    	
    }
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Book> books = new ArrayList<>();
		books = db.getAllBooks();
		
		request.setAttribute("books", books);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_books.jsp");
		dispatcher.forward(request, response);
	}


}
