package com.yezhihao.www.service;

import com.yezhihao.www.dao.AlterBorrowBookDao;
import com.yezhihao.www.dao.GetBookDao;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.BorrowBookPo;

public class AllowApplyService {

	public Boolean brrowBook(BorrowBookPo borrowBook) throws Exception{
		AlterBorrowBookDao  borrowBookDao=new AlterBorrowBookDao();
		 GetBookDao bookDao = new GetBookDao(); 
         BookPo book = bookDao.getBookById(borrowBook.getBook_id());
         Boolean b=borrowBookDao.allowApply(borrowBook);
         Boolean a=true;
         if(borrowBook.getAllow_borrow()==1){
        	 a=borrowBookDao.changeMargin(borrowBook.getBook_id(),book.getBook_margin()-1);
         }
		if(a==true&&b==true){
			return true;
		}
		else{
			return false;
		}
	}
}
