package com.cognixia.jump.library.dao;

import java.util.List;

import com.cognixia.jump.library.model.Librarian;

public interface LibrarianDAO 
{
	int addLibrarian(Librarian p);
	
	List<Librarian> getAllLibrarians();
	Librarian getLibrarianByID(int id);
	
	boolean updateLibrarian(Librarian p);
	
	boolean deleteLibrarian(int id);
}
