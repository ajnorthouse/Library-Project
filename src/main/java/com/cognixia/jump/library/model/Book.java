package com.cognixia.jump.library.model;

import java.sql.Date;

public class Book {
	private char isbn;
	private String title;
	private String descr;
	private boolean rented;
	private Date added_to_library;
	
	public char getIsbn() {
		return isbn;
	}

	public void setIsbn(char isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public Date getAdded_to_library() {
		return added_to_library;
	}

	public void setAdded_to_library(Date added_to_library) {
		this.added_to_library = added_to_library;
	}
	
	
	public Book(char isbn, String title, String descr, boolean rented, Date added_to_library) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.descr = descr;
		this.rented = rented;
		this.added_to_library = added_to_library;
	}

	public Book() {
		super();
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + ", descr=" + descr + ", rented=" + rented
				+ ", added_to_library=" + added_to_library + "]";
	}
	
	
}
