package com.yezhihao.www.dao;


import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BorrowBookPo;

public class DeleteFailApplyDao {

	public boolean deleteFailApply(int state,String user_name,int book_id) throws Exception{
		int result=0;
//		Connection con= DriveUtil.getcon(); 
//		String sql="delete from book_borrow where book_id=? and user_name=?  and allow_borrow=?";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setInt(1,book_id);
//		stmt.setString(2,user_name);
//		stmt.setInt(3,state);
//    	int result=stmt.executeUpdate();
//        DriveUtil.close(con, stmt);
		
		BorrowBookPo BookPo=new  BorrowBookPo();
		BookPo.setBook_id(book_id);
		BookPo.setUser_name(user_name);
		BookPo.setAllow_borrow(state);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.CollectBook.deleteFailApply";
			sqlSession.delete(statements, BookPo);
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
