package com.yezhihao.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezhihao.www.dao.BorrowBook;
import com.yezhihao.www.dao.GetBookDao;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.BorrowBookPo;


@Service
public class AllowApplyService {
	
	@Autowired
	private BorrowBook BorrowBook;
	
	@Autowired
	private com.yezhihao.www.dao.Book Book;
	
	public Boolean brrowBook(BorrowBookPo borrowBook) throws Exception{
		 GetBookDao bookDao = new GetBookDao(); 
         BookPo book = bookDao.getBookById(borrowBook.getBook_id());
         BorrowBook.allowApply(borrowBook);
         BookPo book1=new BookPo();
         book1.setId(borrowBook.getBook_id());
         book1.setBook_margin(book.getBook_margin()-1);
         if(borrowBook.getAllow_borrow()==1){
        	 Book.changeMargin(book1);
         }
		
			return true;
	}
}
