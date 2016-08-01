package com.yezhihao.www.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yezhihao.www.po.CollectBookPo;

@Repository
public interface CollectBook {
	
	 /*增加收藏书籍*/
	 public void collectBook(CollectBookPo CollectBookPo);
	 
	 /*删除收藏书籍*/
	 public void deleteCollectBook(int book_id);

	 /*通过用户名来获取的书籍*/
	 public List<CollectBookPo> getCollectBook(String user_name);
	 
}
