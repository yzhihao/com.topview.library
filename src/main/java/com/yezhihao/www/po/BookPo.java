package com.yezhihao.www.po;

public class BookPo {
	
	private String book_name;
	private String book_writer;
	private String book_amg;
	private Integer book_samem;
	private Integer book_margin;
	private Integer id;
	
	public BookPo() {
		super();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBook_margin() {
		return book_margin;
	}

	public void setBook_margin(Integer book_margin) {
		this.book_margin = book_margin;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_writer() {
		return book_writer;
	}

	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}

	public String getBook_amg() {
		return book_amg;
	}

	public void setBook_amg(String book_amg) {
		this.book_amg = book_amg;
	}

	public Integer getBook_samem() {
		return book_samem;
	}

	public void setBook_samem(Integer book_samem) {
		this.book_samem = book_samem;
	}

	public BookPo(Integer id,String book_name, String book_writer, String book_amg, Integer book_samem,Integer book_margin) {
		super();
		this.book_name = book_name;
		this.book_writer = book_writer;
		this.book_amg = book_amg;
		this.book_samem = book_samem;
		this.book_margin = book_margin;
		this.id=id;
	}
	
	

}

