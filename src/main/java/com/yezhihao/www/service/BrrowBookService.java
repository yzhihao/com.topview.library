package com.yezhihao.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezhihao.www.dao.BorrowBook;
import com.yezhihao.www.po.BorrowBookPo;

@Service
public class BrrowBookService {
	
	@Autowired
	private BorrowBook BorrowBook;
	
	public Boolean brrowBook(BorrowBookPo borrowBook) throws Exception{
		BorrowBook.addBorrowBook(borrowBook);
		return true;
	}
}
