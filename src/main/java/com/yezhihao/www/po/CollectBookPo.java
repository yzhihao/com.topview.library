package com.yezhihao.www.po;

public class CollectBookPo {

	private int book_id;
	private String user_name;
	
	public CollectBookPo() {
		super();
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public CollectBookPo(int book_id, String user_name) {
		super();
		this.book_id = book_id;
		this.user_name = user_name;
	}
}
