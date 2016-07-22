package com.yezhihao.www.service;

import com.yezhihao.www.dao.CollectBookDao;
import com.yezhihao.www.po.CollectBookPo;

public class CollectBookService {
	public Boolean collectBook(CollectBookPo collectBook) throws Exception{
		CollectBookDao  collectBookDao=new CollectBookDao();
		Boolean a=collectBookDao.collectBook(collectBook);
		return a;
	}
}
