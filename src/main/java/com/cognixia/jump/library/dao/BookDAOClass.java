package com.cognixia.jump.library.dao;

import java.sql.Connection;
import java.util.List;

import com.cognixia.jump.library.connection.ConnectionManager;
import com.cognixia.jump.library.model.Book;

public class BookDAOClass implements BookDAO {

	private Connection conn = ConnectionManager.getConnection();
	
	private final String ADD = "INSERT INTO book(isbn,title,descr,rented,added_to_library) values (?,?,?,?,?)";
	private final String SELECT_ALL = "SELECT * FROM book";
	private final String SELECT_BY_ID = "SELECT * FROM book WHERE id=?";
	private final String UPDATE = "UPDATE book set title=?, descr=?, rented=?, added_to_library=? WHERE isbn=?";
	private final String DELETE = "DELETE FROM book WHERE id=?";
	
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
