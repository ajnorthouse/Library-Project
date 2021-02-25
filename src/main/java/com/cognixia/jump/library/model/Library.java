package com.cognixia.jump.library.model;

import java.sql.Date;

public class Library {
	private int checkout_id;
	private int patron_id;
	private char isbn;
	private Date checkedout;
	private Date due_date;
	private Date returned;
	
	public int getCheckout_id() {
		return checkout_id;
	}
	public void setCheckout_id(int checkout_id) {
		this.checkout_id = checkout_id;
	}
	public int getPatron_id() {
		return patron_id;
	}
	public void setPatron_id(int patron_id) {
		this.patron_id = patron_id;
	}
	public char getIsbn() {
		return isbn;
	}
	public void setIsbn(char isbn) {
		this.isbn = isbn;
	}
	public Date getCheckedout() {
		return checkedout;
	}
	public void setCheckedout(Date checkedout) {
		this.checkedout = checkedout;
	}
	public Date getDue_date() {
		return due_date;
	}
	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}
	public Date getReturned() {
		return returned;
	}
	public void setReturned(Date returned) {
		this.returned = returned;
	}

	public Library() {
		super();
	}
	
	public Library(int checkout_id, int patron_id, char isbn, Date checkedout, Date due_date, Date returned) {
		super();
		this.checkout_id = checkout_id;
		this.patron_id = patron_id;
		this.isbn = isbn;
		this.checkedout = checkedout;
		this.due_date = due_date;
		this.returned = returned;
	}
	
	@Override
	public String toString() {
		return "Library [checkout_id=" + checkout_id + ", patron_id=" + patron_id + ", isbn=" + isbn + ", checkedout="
				+ checkedout + ", due_date=" + due_date + ", returned=" + returned + "]";
	}
	
	
}
