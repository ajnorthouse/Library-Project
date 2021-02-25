package com.cognixia.jump.library.dao;

import java.util.List;

import com.cognixia.jump.library.model.Book;

public interface BookDAO  {
	String addBook(Book b);
	
	List<Book> getAllBooks();
	Book getBookByID(String id);
	
	boolean updateBook(Book b);
	
	boolean deleteBook(String id);
}
