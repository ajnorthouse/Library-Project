package com.cognixia.jump.library.dao;

import java.util.List;

import com.cognixia.jump.library.model.Book;

public interface BookDAO  {
	int addBook(Book p);
	
	List<Book> getAllBooks();
	Book getBookByID(int id);
	
	boolean updateBook(Book p);
	
	boolean deleteBook(int id);
}
