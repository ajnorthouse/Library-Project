package com.cognixia.jump.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognixia.jump.library.connection.ConnectionManager;
import com.cognixia.jump.library.model.Book;

public class BookDAOClass implements BookDAO {

	private Connection conn = ConnectionManager.getConnection();
	
	private static final String ADD = "INSERT INTO book(isbn,title,descr,rented,added_to_library) values (?,?,?,?,?)";
	private static final String SELECT_ALL = "SELECT * FROM book";
	private static final String SELECT_BY_ID = "SELECT * FROM book WHERE isbn=?";
	private static final String UPDATE = "UPDATE book set title=?, descr=?, rented=?, added_to_library=? WHERE isbn=?";
	private static final String DELETE = "DELETE FROM book WHERE isbn=?";
	
	@Override
	public String addBook(Book b) {
		try(PreparedStatement pst = conn.prepareStatement(ADD)) {
			
			pst.setString(1, b.getIsbn());
			pst.setString(2,b.getTitle());
			pst.setString(3, b.getDescr());
			pst.setBoolean(4, false);
			pst.setDate(5, b.getAdded_to_library());
			
			boolean success = pst.execute();
			if(success) return b.getIsbn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "-1";
	}

	@Override
	public List<Book> getAllBooks() {
		
		List<Book> books = new ArrayList<>();
		
		try(PreparedStatement pst = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery()) {
			
			while(rs.next())
			{
				books.add(new Book(rs.getString("isbn"),
								   rs.getString("title"), 
								   rs.getString("descr"),
								   rs.getBoolean("rented"), 
								   rs.getDate("added_to_library")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public Book getBookByID(String id) {
		Book book = null;
		
		try(PreparedStatement pst = conn.prepareStatement(SELECT_BY_ID)) {
			pst.setString(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				book  = new Book(rs.getString("isbn"), 
								 rs.getString("title"), 
								 rs.getString("descr"),
								 rs.getBoolean("rented"), 
								 rs.getDate("added_to_library"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public boolean updateBook(Book b) {
		
		try(PreparedStatement pst = conn.prepareStatement(UPDATE)) {
			
			pst.setString(1,b.getTitle());
			pst.setString(2, b.getDescr());
			pst.setBoolean(3, false);
			pst.setDate(4, b.getAdded_to_library());
			pst.setString(5, b.getIsbn());
			
			return pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean deleteBook(String id) {
		try(PreparedStatement pst = conn.prepareStatement(DELETE)) {
			
			pst.setString(1, id);
			
			return pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
