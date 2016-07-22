package com.yezhihao.www.dao;

import java.util.List;

import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.Page;

public interface Book {
	public List<BookPo> queryBookByPage(Page page);
	/*在getbookdao演示怎么向数据库查询*/
}
