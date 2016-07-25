package com.yezhihao.www.dao;

import java.util.List;


import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.Page;


public interface Book {
	
	/*这里是分页查询 */
	public List<BookPo> queryBookByPage(Page page);
	
	/*增加书籍 */ 
    public void addBook(BookPo bookPo);
   
    /* 修改书的仓库余量*/
	 public void changeMargin(BookPo bookPo);
	 
	/* 删除图书*/ 
	 public void deleteFailApply(int a);
	 
	/* 删除图书（有的书还没有还） */
	 public void deleteFailApply1(BookPo bookPo);
	 
	 /*更新图书*/
	 public void updateBookDao(BookPo bookPo);
	 
	 /*获取所有的书籍 */
	 public List<BookPo> getBook();
	 
	/* 查找书籍，通过作者或者书名 */
	 public List<BookPo> getBookByselect(BookPo bookPo);
	 
	 /*通过id来获取的书籍*/
	 public BookPo getBookById(BookPo bookPo);
	 
	 

}
