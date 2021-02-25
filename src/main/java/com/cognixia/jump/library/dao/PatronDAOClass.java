package com.cognixia.jump.library.dao;

import java.util.List;

import com.cognixia.jump.library.model.Patron;

public class PatronDAOClass implements PatronDAO {

	private static final String ADD = "INSERT INTO patron(first_name, last_name, username, password, account_frozen) values (?,?,?,?,?)";
	private static final String SELECT_ALL = "SELECT * FROM patron";
	private static final String SELECT_BY_ID = "SELECT * FROM patron WHERE patron_id=?";
	private static final String UPDATE = "UPDATE book set first_name=?, last_name=?, username=?, password=? WHERE patron_id=?";
	private static final String DELETE = "DELETE FROM patron WHERE patron_id=?";
	
	@Override
	public int addPatron(Patron p) {
		return 0;
	}

	@Override
	public List<Patron> getAllPatrons() {
		return null;
	}

	@Override
	public Patron getPatronByID(int id) {
		return null;
	}

	@Override
	public boolean updatePatron(Patron p) {
		return false;
	}

	@Override
	public boolean deletePatron(int id) {
		return false;
	}

}
