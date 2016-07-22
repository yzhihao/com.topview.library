package com.yezhihao.www.dao;


import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;



public class AddBookDao {
//增加图书
	public boolean addBook(BookPo book) {
//		Connection con;
//		int result = 0;
//		try {
//			con = DriveUtil.getcon();
//		String sql="insert into book values (null,?,?,?,?,?)";    	
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setString(1,book.getBook_name());
//		stmt.setString(2,book.getBook_writer());
//		stmt.setInt(3,book.getBook_samem());
//		stmt.setString(4,book.getBook_amg());
//		stmt.setInt(5,book.getBook_samem());
//    	result=stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
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
			String statements="com.yezhihao.www.po.Book.addBook";
			result=sqlSession.insert(statements,book);
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
