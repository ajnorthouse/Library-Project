package com.cognixia.jump.library.dao;

import java.util.List;

import com.cognixia.jump.library.model.Patron;

public interface PatronDAO 
{
	int addPatron(Patron p);
	
	List<Patron> getAllPatrons();
	Patron getPatronByID(int id);
	
	boolean updatePatron(Patron p);
	
	boolean deletePatron(int id);
}
