package com.yezhihao.www.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yezhihao.www.po.BorrowBookPo;
@Repository
public interface BorrowBook {
	/*增加申请借阅书籍*/
	public void addBorrowBook(BorrowBookPo BorrowBookPo);
	
	/*修改是否同意借阅的状态*/
	 public void allowApply(BorrowBookPo BorrowBookPo);
	 	
	 /*还书*/
	 public void returnbook(BorrowBookPo BorrowBookPo);
	 
	 /*删除借书记录*/
	 public void deleteBorrowBook(BorrowBookPo BorrowBookPo);
	 
	 /*删除不同意借出的记录*/
	 public void deleteFailApply(BorrowBookPo BorrowBookPo);
	 
	 /*通过审核状态来获取申请借阅记录*/
	 public List<BorrowBookPo> getApplyBook(int allow_borrow);
	 
	 /*通过借阅者名字来取得借阅申请记录*/
	 public List<BorrowBookPo> getBorrowBookByUsername(String user_name);
	 
	 /*通过借阅者名字和状态来取得借阅申请记录||得到已失效记录*/
	 public List<BorrowBookPo> getBorrowBookByUsername1(BorrowBookPo BorrowBookPo);
	 

}
