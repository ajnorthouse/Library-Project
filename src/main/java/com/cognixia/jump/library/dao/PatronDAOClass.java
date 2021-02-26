package com.cognixia.jump.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.library.connection.ConnectionManager;
import com.cognixia.jump.library.model.Patron;

public class PatronDAOClass implements PatronDAO {

	private Connection conn = ConnectionManager.getConnection();
	
	private static final String ADD = "INSERT INTO patron(first_name, last_name, username, password, account_frozen) values (?,?,?,?,?)";
	private static final String SELECT_ALL = "SELECT * FROM patron";
	private static final String SELECT_BY_ID = "SELECT * FROM patron WHERE patron_id=?";
	private static final String UPDATE = "UPDATE patron SET first_name=?, last_name=?, username=?, password=?, account_frozen=? WHERE patron_id=?";
	private static final String DELETE = "DELETE FROM patron WHERE patron_id=?";
	
	@Override
	public int addPatron(Patron p) {
		try(PreparedStatement pst = conn.prepareStatement(ADD)) {
			
			pst.setString(1, p.getFirst_name());
			pst.setString(2,p.getLast_name());
			pst.setString(3, p.getUsername());
			pst.setString(4, p.getPassword());
			pst.setBoolean(5, p.isAccount_frozen());
			
			boolean success = pst.execute();
			if(success) return p.getPatron_id();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Patron> getAllPatrons() {
		List<Patron> patrons = new ArrayList<Patron>();
		
		try(PreparedStatement pst = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery()) {
			
			while(rs.next())
			{
				patrons.add(new Patron(rs.getInt("patron_id"), 
									   rs.getString("first_name"), 
									   rs.getString("last_name"),
									   rs.getString("username"), 
									   rs.getString("password"), 
									   rs.getBoolean("account_frozen")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patrons;
	}

	@Override
	public Patron getPatronByID(int id) {
		Patron patron = null;
		
		try(PreparedStatement pst = conn.prepareStatement(SELECT_BY_ID);) {
			
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next())
			{
				patron = new Patron(rs.getInt("patron_id"), 
									rs.getString("first_name"), 
									rs.getString("last_name"),
									rs.getString("username"),
									rs.getString("password"), 
									rs.getBoolean("account_frozen"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return patron;
	}

	@Override
	public boolean updatePatron(Patron p) {
		try(PreparedStatement pst = conn.prepareStatement(UPDATE)) {
			
			pst.setString(1, p.getFirst_name());
			pst.setString(2,p.getLast_name());
			pst.setString(3, p.getUsername());
			pst.setString(4, p.getPassword());
			pst.setBoolean(5, p.isAccount_frozen());
			pst.setInt(6, p.getPatron_id());
			
			return pst.execute();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePatron(int id) {
		try(PreparedStatement pst = conn.prepareStatement(DELETE)) {
			
			pst.setInt(1, id);
			
			return pst.execute();		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
