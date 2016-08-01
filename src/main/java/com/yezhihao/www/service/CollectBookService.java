package com.yezhihao.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezhihao.www.dao.CollectBook;
import com.yezhihao.www.po.CollectBookPo;

@Service
public class CollectBookService {
	@Autowired
	private CollectBook CollectBook;
	
	public Boolean collectBook(CollectBookPo collectBook) {
		try{
			CollectBook.collectBook(collectBook);
			}catch(Exception e){
				return false;
			}
		return true;
	}
}
