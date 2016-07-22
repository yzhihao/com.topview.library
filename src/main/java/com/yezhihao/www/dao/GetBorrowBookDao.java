package com.yezhihao.www.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.BorrowBookPo;

public class GetBorrowBookDao {
	/*通过审核状态来获取申请借阅记录*/
	public ArrayList<BorrowBookPo> getApplyBook() throws Exception{
		List<BorrowBookPo>  borrowbooklist=new ArrayList<BorrowBookPo>();
//		Connection con= DriveUtil.getcon();
//		String sql="select * from book_borrow where allow_borrow=? ";
//    	PreparedStatement stmt=con.prepareStatement(sql);
//    	stmt.setInt(1,2);
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	String book_name=se.getString("book_name");
//	    	int book_id=se.getInt("book_id");
//	    	int borrow_bookid=se.getInt("borrow_bookid");
//	    	String return_date=se.getString("return_date");
//	    	String borrow_date=se.getString("borrow_date");
//	    	String user_name=se.getString("user_name");
//	    	BorrowBookPo applyBook=new BorrowBookPo(book_id, book_name, user_name, borrow_date, return_date);
//	    	applyBook.setBorrow_bookid(borrow_bookid);
//	    	borrowbooklist.add(applyBook);
//	    }
//	    DriveUtil.close(con, stmt);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.BorrowBook.getApplyBook";
			borrowbooklist= sqlSession.selectList(statements,2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	    
	    GetBookDao getBook=new GetBookDao();
	    if(borrowbooklist!=null){
		    for(BorrowBookPo applyBook: borrowbooklist){
		    	BookPo book=getBook.getBookById(applyBook.getBook_id());
		    	applyBook.setBook_amg(book.getBook_amg());
		    }
	    }
		return (ArrayList<BorrowBookPo>) borrowbooklist;
	}
	
	
	/*通过审核状态来获取申请借阅记录*/
	public ArrayList<BorrowBookPo> getBorrowBook() throws Exception{
		List<BorrowBookPo>  borrowbooklist=new ArrayList<BorrowBookPo>();
//		Connection con= DriveUtil.getcon();
//		String sql="select * from book_borrow where allow_borrow=? ";
//    	PreparedStatement stmt=con.prepareStatement(sql);
//    	stmt.setInt(1,1);
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	String book_name=se.getString("book_name");
//	    	int book_id=se.getInt("book_id");
//	    	String return_date=se.getString("return_date");
//	    	String borrow_date=se.getString("borrow_date");
//	    	String user_name=se.getString("user_name");
//	    	BorrowBookPo applyBook=new BorrowBookPo(book_id, book_name, user_name, borrow_date, return_date);
//	    	borrowbooklist.add(applyBook);
//	    }
//	    DriveUtil.close(con, stmt);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.BorrowBook.getApplyBook";
			borrowbooklist= sqlSession.selectList(statements,1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	    
	    GetBookDao getBook=new GetBookDao();
	    for(BorrowBookPo applyBook: borrowbooklist){
	    	BookPo book=getBook.getBookById(applyBook.getBook_id());
	    	applyBook.setBook_amg(book.getBook_amg());
	    }
		return (ArrayList<BorrowBookPo>) borrowbooklist;
	}
	
	
	
	public ArrayList<BorrowBookPo> getBorrowBookByUsername(int state, String Username ) throws Exception{
		List<BorrowBookPo>  borrowbooklist=new ArrayList<BorrowBookPo>();
//		Connection con= DriveUtil.getcon();
//		String sql;
//		PreparedStatement stmt;
//		if(state==3){//表示申请状态
//			sql="select * from book_borrow where user_name=? ";
//	    	stmt=con.prepareStatement(sql);
//	    	stmt.setString(1,Username);
//		}
//		else{
//			sql="select * from book_borrow where user_name=? and allow_borrow=?  ";
//	    	stmt=con.prepareStatement(sql);
//	    	stmt.setString(1,Username);
//	    	stmt.setInt(2,1);
//		}
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	String book_name=se.getString("book_name");
//	    	int book_id=se.getInt("book_id");
//	    	String return_date=se.getString("return_date");
//	    	String borrow_date=se.getString("borrow_date");
//	    	String user_name=se.getString("user_name");
//	    	int allow_borrow=se.getInt("allow_borrow");
//	    	BorrowBookPo applyBook=new BorrowBookPo(book_id, book_name, user_name, allow_borrow,borrow_date, return_date);
//	    	int borrow_bookid=se.getInt("borrow_bookid");
//	    	applyBook.setBorrow_bookid(borrow_bookid);
//	    	borrowbooklist.add(applyBook);
//	    }
//	    DriveUtil.close(con, stmt);
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			if(state==3){
				String statements="com.yezhihao.www.po.BorrowBook.getBorrowBookByUsername";
				borrowbooklist= sqlSession.selectList(statements,Username);
			}
			else{
				BorrowBookPo BorrowBookPo=new BorrowBookPo();
				BorrowBookPo.setAllow_borrow(1);
				BorrowBookPo.setUser_name(Username);
				String statements="com.yezhihao.www.po.BorrowBook.getBorrowBookByUsername1";
				borrowbooklist= sqlSession.selectList(statements,BorrowBookPo);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	    
	    GetBookDao getBook=new GetBookDao();
	    for(BorrowBookPo applyBook: borrowbooklist){
	    	BookPo book=getBook.getBookById(applyBook.getBook_id());
	    	applyBook.setBook_amg(book.getBook_amg());
	    }
		return (ArrayList<BorrowBookPo>) borrowbooklist;
	}
	
	
	public ArrayList<BorrowBookPo> getoldBorrowBook( String Username ) throws Exception{
		List<BorrowBookPo>  borrowbooklist=new ArrayList<BorrowBookPo>();
//		Connection con= DriveUtil.getcon();
//		String sql="select * from book_borrow where user_name=? and allow_borrow=? ";
//    	PreparedStatement stmt=con.prepareStatement(sql);
//    	stmt.setString(1,Username);
//    	stmt.setInt(2,-1);//-1表示已还书
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	String book_name=se.getString("book_name");
//	    	int book_id=se.getInt("book_id");
//	    	String return_date=se.getString("return_date");
//	    	String borrow_date=se.getString("borrow_date");
//	    	String user_name=se.getString("user_name");
//	    	int allow_borrow=se.getInt("allow_borrow");
//	    	BorrowBookPo applyBook=new BorrowBookPo(book_id, book_name, user_name, allow_borrow,borrow_date, return_date);
//	    	borrowbooklist.add(applyBook);
//	    }
//	    DriveUtil.close(con, stmt);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			BorrowBookPo BorrowBookPo=new BorrowBookPo();
			BorrowBookPo.setAllow_borrow(-1);
			BorrowBookPo.setUser_name(Username);
			String statements="com.yezhihao.www.po.BorrowBook.getBorrowBookByUsername1";
			borrowbooklist= sqlSession.selectList(statements,BorrowBookPo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
		
		
	    GetBookDao getBook=new GetBookDao();
	    for(BorrowBookPo applyBook: borrowbooklist){
	    	BookPo book=getBook.getBookById(applyBook.getBook_id());
	    	applyBook.setBook_amg(book.getBook_amg());
	    }
		return (ArrayList<BorrowBookPo>) borrowbooklist;
	}
}
