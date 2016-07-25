package com.yezhihao.www.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezhihao.www.dao.Book;
import com.yezhihao.www.po.BookPo;

@Service
public class AddBookService {
	
	@Autowired
	private Book bookdao;
	
	public boolean addBook(BookPo book) throws Exception {
//		AddBookDao addBookDao=new AddBookDao();
//		Boolean a=addBookDao.addBook(book);
		bookdao.addBook(book);
		return true;
	}
}
