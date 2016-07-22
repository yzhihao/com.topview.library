package com.yezhihao.www.dao;


import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.CollectBookPo;

public class CollectBookDao {
	public boolean collectBook(CollectBookPo collectBook) {
//		Connection con;
//		int result = 0;
//		try {
//			con = DriveUtil.getcon();
//			String sql="insert into  book_colleck(user_name,book_id)values (?,?)";    	
//			PreparedStatement stmt=con.prepareStatement(sql); 
//			stmt.setString(1,collectBook.getUser_name());
//			stmt.setInt(2,collectBook.getBook_id());
//	    	result=stmt.executeUpdate();
//		    DriveUtil.close(con, stmt);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
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
			String statements="com.yezhihao.www.po.CollectBook.collectBook";
			result=sqlSession.insert(statements,collectBook);
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
	
	public boolean deleteCollectBook(int Book_id) throws Exception{
//		Connection con= DriveUtil.getcon(); 
//		String sql="delete from book_colleck where book_id=?";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setInt(1,Book_id);
//    	stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
//	    	return true;
	    	
	    	
	DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.CollectBook.deleteCollectBook";
			sqlSession.delete(statements, Book_id);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
		return true;
		
	}
}
