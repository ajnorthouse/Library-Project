package com.cognixia.jump.library.dao;

import java.sql.Connection;
import java.util.List;

import com.cognixia.jump.library.connection.ConnectionManager;
import com.cognixia.jump.library.model.Librarian;

public class LibrarianDAOClass implements LibrarianDAO {
	
private Connection conn = ConnectionManager.getConnection();
	
	private static final String ADD = "INSERT INTO librarian(username, password) values (?,?)";
	private static final String SELECT_ALL = "SELECT * FROM librarian";
	private static final String SELECT_BY_ID = "SELECT * FROM librarian WHERE librarian_id=?";
	private static final String UPDATE = "UPDATE librarian set username=?, password=? WHERE librarian_id=?";
	private static final String DELETE = "DELETE FROM librarian WHERE librarian_id=?";
	
	@Override
	public int addLibrarian(Librarian p) {
		return 0;
	}

	@Override
	public List<Librarian> getAllLibrarians() {
		return null;
	}

	@Override
	public Librarian getLibrarianByID(int id) {
		return null;
	}

	@Override
	public boolean updateLibrarian(Librarian p) {
		return false;
	}

	@Override
	public boolean deleteLibrarian(int id) {
		return false;
	}

}
