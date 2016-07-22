package com.yezhihao.www.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;

public class SelectBookDao {
	/*查找书籍，通过作者或者书名*/
	public ArrayList<BookPo> getBookByselect(String select) throws Exception {
		List<BookPo>  booklist=new ArrayList<BookPo>();
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		Connection con= DriveUtil.getcon();
//		try {
//			String sql = "select * from book where book_name=? or book_writer=?"; // SQL语句
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, select);
//			stmt.setString(2, select);
//			rs = stmt.executeQuery();
//			if (rs.next()) {
//				BookPo book = new BookPo();
//				book.setId(rs.getInt("id"));
//				book.setBook_name(rs.getString("book_name"));
//				book.setBook_amg(rs.getString("book_amg"));
//				book.setBook_writer(rs.getString("book_writer"));
//				book.setBook_margin(rs.getInt("book_margin"));
//				book.setBook_samem(rs.getInt("book_samem"));
//				booklist.add(book);
//			} 
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		} 
//		    DriveUtil.close(con, stmt);
		
		BookPo BookPo=new BookPo();
		BookPo.setBook_writer(select);
		BookPo.setBook_name(select);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.Book.getBookByselect";
			booklist= sqlSession.selectList(statements,BookPo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}

		return (ArrayList<BookPo>) booklist;
	}
}
