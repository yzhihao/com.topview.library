package com.yezhihao.www.db;

import java.util.ArrayList;

import org.junit.Test;

import com.yezhihao.www.dao.GetBookDao;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.Page;

public class testpage {
	@Test
	public void itest() throws Exception{
		GetBookDao GetBookDao=new GetBookDao();
		Page page =new Page();
		page.setDbIndex(0);
		page.setDbNumber(5);
		ArrayList<BookPo> booklist=GetBookDao.getBookbypage(page);
		for (BookPo bookPo : booklist) {
			System.out.println(bookPo.getBook_name());
		}
		System.out.println(page.getTotalNumber());
		
	}
}
