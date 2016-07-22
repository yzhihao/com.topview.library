package com.yezhihao.www.service;

import com.yezhihao.www.dao.AlterBorrowBookDao;
import com.yezhihao.www.po.BorrowBookPo;

public class BrrowBookService {
	public Boolean brrowBook(BorrowBookPo borrowBook) throws Exception{
		AlterBorrowBookDao  borrowBookDao=new AlterBorrowBookDao();
		Boolean a=borrowBookDao.borrowBook(borrowBook);
		return a;
	}
}
