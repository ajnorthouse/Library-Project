package com.cognixia.jump.library.dao;

import java.util.List;

import com.cognixia.jump.library.model.Book;

public interface BookDAO 
{
	int addLibrarian(Book p);
	
	List<Book> getAllLibrarians();
	Book getLibrarianByID(int id);
	
	boolean updateLibrarian(Book p);
	
	boolean deleteLibrarian(int id);
}
