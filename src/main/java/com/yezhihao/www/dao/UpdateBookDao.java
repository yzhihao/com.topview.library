package com.yezhihao.www.dao;


import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;

public class UpdateBookDao {
	/*更新图书*/
	public boolean updateBookDao( BookPo book) throws Exception{
//		Connection con= DriveUtil.getcon(); 
		GetBookDao GetBookDao=new GetBookDao();
		BookPo book1=GetBookDao.getBookById(book.getId());
//		String sql="update  book  set book_name=?, book_amg=?,book_writer=?,book_samem=?,book_margin=?  where id=?";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setString(1,book.getBook_name());
//		stmt.setString(2,book.getBook_amg());
//		stmt.setString(3,book.getBook_writer());
//		stmt.setInt(4,book1.getBook_samem()+book.getBook_samem());
//		stmt.setInt(5,book.getBook_samem()+book1.getBook_margin());
//		stmt.setInt(6,book.getId());
//    	stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
		
		book.setBook_samem(book1.getBook_samem()+book.getBook_samem());
		book.setBook_margin(book.getBook_samem()+book1.getBook_margin());
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.Book.updateBookDao";
			sqlSession.update(statements,book);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	    return true;
	}
}
