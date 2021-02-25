package com.cognixia.jump.library.dao;

import java.sql.Connection;
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
	public int addBook(Book p) {
		return 0;
	}

	@Override
	public List<Book> getAllBooks() {
		return null;
	}

	@Override
	public Book getBookByID(int id) {
		return null;
	}

	@Override
	public boolean updateBook(Book p) {
		return false;
	}

	@Override
	public boolean deleteBook(int id) {
		return false;
	}

}
