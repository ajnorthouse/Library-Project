package com.cognixia.jump.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public int addLibrarian(Librarian l) {
try(PreparedStatement pst = conn.prepareStatement(ADD)) {
			
			pst.setString(1, l.getUsername());
			pst.setString(2, l.getPassword());
			
			boolean success = pst.execute();
			
			if(success) return l.getLibrarian_id();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public List<Librarian> getAllLibrarians() {
		List<Librarian> librarians = new ArrayList<Librarian>();
		
		try(PreparedStatement pst = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery()) {
			
			while(rs.next())
			{
				librarians.add(new Librarian(rs.getInt("librarian_id"), rs.getString("username"), rs.getString("password")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return librarians;
	}

	@Override
	public Librarian getLibrarianByID(int id) {
		Librarian librarian = null;
		
		try(PreparedStatement pst = conn.prepareStatement(SELECT_BY_ID)) {
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				librarian = new Librarian(rs.getInt("librarian_id"), rs.getString("username"), rs.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return librarian;
	}

	@Override
	public boolean updateLibrarian(Librarian l) {
		try(PreparedStatement pst = conn.prepareStatement(UPDATE)) {
			
			pst.setString(1, l.getUsername());
			pst.setString(2, l.getPassword());
			pst.setInt(3, l.getLibrarian_id());
			
			return pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteLibrarian(int id) {
		
		try(PreparedStatement pst = conn.prepareStatement(DELETE)) {
			
			pst.setInt(1, id);
			
			return pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
