package com.yezhihao.www.dao;


import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.BorrowBookPo;

public class AlterBorrowBookDao {
/* 下面是修改是否同意*/
	public boolean borrowBook(BorrowBookPo borrowBook) {
//		Connection con;
//		int result=0;
//		try {
//			con = DriveUtil.getcon();
//			String sql="insert into book_borrow (borrow_bookid,book_id,book_name,user_name,borrow_date,return_date,allow_borrow) values (null,?,?,?,?,?,?)";    	
//			PreparedStatement stmt=con.prepareStatement(sql); 
//			stmt.setInt(1,borrowBook.getBook_id());
//			stmt.setString(2,borrowBook.getBook_name());
//			stmt.setString(3,borrowBook.getUser_name());
//			stmt.setString(4,borrowBook.getBorrow_date());
//			stmt.setString(5,borrowBook.getReturn_date());
//			stmt.setInt(6,borrowBook.getAllow_borrow());
//	    	result=stmt.executeUpdate();
//		    DriveUtil.close(con, stmt);
//		} catch (Exception e) {
//			return false;
//		} 
//	    if(result==1){
//	    	return true;
//	    }
//		return false;
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result=0;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.BorrowBook.addBorrowBook";
			result=sqlSession.insert(statements,borrowBook);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	
		 if(result==1){
		    	return true;
		    }
			return false;
	}
	
	/*修改借阅图书余量*/
	public boolean changeMargin(int book_id,int book_margin) throws Exception{
		BookPo Book=new BookPo();
		Book.setId(book_id);
		Book.setBook_margin(book_margin);

//		Connection con= DriveUtil.getcon(); 
//		String sql="update book set book_margin=? where id=?";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setInt(1,book_margin);
//		stmt.setInt(2,book_id);
//    	int result=stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
//	    if(result==1){
//	    	return true;
//	    }
//		return false;
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result=0;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.Book.changeMargin";
			result=sqlSession.update(statements,Book);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	
		 if(result==1){
		    	return true;
		    }
			return false;
		
	}
	/*修改是否同意借阅的状态*/
	public boolean allowApply(BorrowBookPo borrowBookPo) throws Exception  {
//		Connection con;
//		int result = 0;
//		try {
//			con = DriveUtil.getcon();
//		String sql="update book_borrow set borrow_date=?,return_date=?,allow_borrow=?  where borrow_bookid=?";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setString(1,borrowBookPo.getBorrow_date());
//		stmt.setString(2,borrowBookPo.getReturn_date());
//		stmt.setInt(3,borrowBookPo.getAllow_borrow());
//		stmt.setInt(4,borrowBookPo.getBorrow_bookid());
//    	result=stmt.executeUpdate();	
//	    DriveUtil.close(con, stmt);
//		} catch (Exception e) {
//		} 
//	    if(result==1){
//	    	return true;
//	    }
//		return false;
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result=0;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.BorrowBook.allowApply";
			result=sqlSession.update(statements,borrowBookPo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	
		 if(result==1){
		    	return true;
		    }
			return false;
		
	}	
	
	public boolean returnbook(int borrow_id) throws Exception{
		BorrowBookPo BorrowBookPo=new BorrowBookPo();
		BorrowBookPo.setBorrow_bookid(borrow_id);
		BorrowBookPo.setAllow_borrow(-1);
//		Connection con= DriveUtil.getcon(); 
//		String sql="update book_borrow set allow_borrow=? where borrow_bookid=?";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setInt(1,-1);
//		stmt.setInt(2,borrow_id);
//    	int result=stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
//	    if(result==1){
//	    	return true;
//	    }
//		return false;
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result=0;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.BorrowBook.returnbook";
			result=sqlSession.update(statements,BorrowBookPo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	
		 if(result==1){
		    	return true;
		    }
			return false;
	}
}
