package com.yezhihao.www.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.CollectBookPo;


public class GetCollectBookDao {
	/*通过用户名来获取的书籍*/
	public ArrayList<BookPo> getCollectBook(String username) throws Exception{
		
		List<CollectBookPo>  booklist=new ArrayList<CollectBookPo>();
		ArrayList<BookPo>  collectBookList=new ArrayList<BookPo>();
//		Connection con= DriveUtil.getcon();
//		String sql="select * from book_colleck where user_name=?";
//    	PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setString(1, username);
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	String user_name=se.getString("user_name");
//	    	int book_id=se.getInt("book_id");
//	    	CollectBookPo collectBook=new CollectBookPo(book_id, user_name);
//	    	booklist.add(collectBook);
//	    }
//	    DriveUtil.close(con, stmt);
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.CollectBook.getCollectBook";
			booklist= sqlSession.selectList(statements,username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	    
	    
	    GetBookDao getBook=new GetBookDao();
	    for(CollectBookPo collectBook: booklist){
	    	BookPo book=getBook.getBookById(collectBook.getBook_id());
	    	collectBookList.add(book);
	    }
	    
		return collectBookList;
	}
}
