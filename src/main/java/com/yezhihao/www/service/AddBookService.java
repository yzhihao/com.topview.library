package com.yezhihao.www.service;


import com.yezhihao.www.dao.AddBookDao;
import com.yezhihao.www.po.BookPo;


public class AddBookService {
	public boolean addBook(BookPo book) throws Exception {
		AddBookDao addBookDao=new AddBookDao();
		Boolean a=addBookDao.addBook(book);
		return a;
	}
	
}
