package com.yezhihao.www.dao;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.BorrowBookPo;

public class DeleteDookDao {
	/*下架图书方法*/
	public int deleteFailApply(int book_id) throws Exception{
//		Connection con= DriveUtil.getcon(); 
		GetBookDao GetBookDao=new GetBookDao();
		BookPo book=GetBookDao.getBookById(book_id);
//		String sql;
//		PreparedStatement stmt;
//		if(book.getBook_samem()==book.getBook_margin()){
//			sql="delete from book where id=?";
//			stmt=con.prepareStatement(sql); 
//			stmt.setInt(1,book_id);
//	    	stmt.executeUpdate();
//	    	DriveUtil.close(con, stmt);
//	    	deleteCollectBook(book_id);
//	    	deleteBorrowBook(book_id);
//	    	return -1;
//		}
//		else{
//			sql="update book set book_samem=?,book_margin=? where id=?";
//			stmt=con.prepareStatement(sql); 
//			stmt.setInt(1,book.getBook_samem()-book.getBook_margin());
//			stmt.setInt(2,0);
//			stmt.setInt(3,book_id);
//	    	stmt.executeUpdate();
//	    	DriveUtil.close(con, stmt);
//	    	deleteBorrowBook(book_id);
//	    	return book.getBook_samem()-book.getBook_margin();
//		}
		if(book.getBook_samem()==book.getBook_margin()){
		   	
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				String statements="com.yezhihao.www.po.Book.deleteFailApply";
				sqlSession.delete(statements, book_id);
				sqlSession.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBAccess.closeSqlSession(sqlSession);
			}
			return -1;
		}
		else{
			BookPo BookPo=new  BookPo();
			BookPo.setBook_margin(0);
			BookPo.setBook_samem(book.getBook_samem()-book.getBook_margin());
			BookPo.setId(book_id);
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				String statements="com.yezhihao.www.po.Book.deleteFailApply1";
				sqlSession.update(statements,BookPo);
				sqlSession.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBAccess.closeSqlSession(sqlSession);
			}
			return book.getBook_samem()-book.getBook_margin();
		}
		
	}
	
	
	
	
	public void deleteCollectBook(int book_id) throws Exception{
//		Connection con= DriveUtil.getcon(); 
//		String sql;
//		PreparedStatement stmt;
//		sql="delete from book_colleck where book_id=?";
//		stmt=con.prepareStatement(sql); 
//		stmt.setInt(1,book_id);
//		stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.CollectBook.deleteCollectBook";
			sqlSession.delete(statements, book_id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	}
	
	
	public void deleteBorrowBook(int book_id) throws Exception{
//		Connection con= DriveUtil.getcon(); 
//		String sql;
//		PreparedStatement stmt;
//		sql="delete from book_borrow where book_id=? and allow_borrow!=?";
//		stmt=con.prepareStatement(sql); 
//		stmt.setInt(1,book_id);
//		stmt.setInt(2,1);
//		stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
		BorrowBookPo BookPo=new  BorrowBookPo();
		BookPo.setBook_id(book_id);
		BookPo.setAllow_borrow(1);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.CollectBook.deleteBorrowBook";
			sqlSession.delete(statements, BookPo);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	}
}
