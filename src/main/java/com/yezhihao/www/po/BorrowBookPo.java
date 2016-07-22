package com.yezhihao.www.po;

public class BorrowBookPo {
	private int book_id;
	private int borrow_bookid;
	private String book_name;
	private String user_name;
	private int allow_borrow;
	private String book_amg;
	private String borrow_date;
	private String return_date;
	public BorrowBookPo() {
		super();
	}
	
	public int getBorrow_bookid() {
		return borrow_bookid;
	}

	public void setBorrow_bookid(int borrow_bookid) {
		this.borrow_bookid = borrow_bookid;
	}

	public String getBook_amg() {
		return book_amg;
	}

	public void setBook_amg(String book_amg) {
		this.book_amg = book_amg;
	}

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getAllow_borrow() {
		return allow_borrow;
	}
	public void setAllow_borrow(int allow_borrow) {
		this.allow_borrow = allow_borrow;
	}
	public String getBorrow_date() {
		return borrow_date;
	}
	public void setBorrow_date(String borrow_date) {
		this.borrow_date = borrow_date;
	}
	public String getReturn_date() {
		return return_date;
	}
	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}
	public BorrowBookPo(int book_id, String book_name, String user_name, int allow_borrow, String borrow_date,
			String return_date) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.user_name = user_name;
		this.allow_borrow = allow_borrow;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
	}
	public BorrowBookPo(int book_id, String book_name, String user_name, String borrow_date, String return_date) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.user_name = user_name;
		this.borrow_date = borrow_date;
		this.return_date = return_date;
	}

	
	
}
