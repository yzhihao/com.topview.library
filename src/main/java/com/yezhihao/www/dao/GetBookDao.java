package com.yezhihao.www.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.BookPo;
import com.yezhihao.www.po.Page;


public class GetBookDao {
	
	
		public ArrayList<BookPo> getBookbypage(Page page) throws Exception{
			List<BookPo>  booklist=new ArrayList<BookPo>();
				DBAccess dbAccess = new DBAccess();
				SqlSession sqlSession = null;
				try {
					sqlSession = dbAccess.getSqlSession();
					/*下面就是接口式编程*/
					Book ibook=sqlSession.getMapper(Book.class);
					booklist=ibook.queryBookByPage(page);
					/*String statements="com.yezhihao.www.po.Book.getBook";
					booklist= sqlSession.selectList(statements);*/
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBAccess.closeSqlSession(sqlSession);
				}

			return (ArrayList<BookPo>) booklist;
		}
		
	
	
	
	public ArrayList<BookPo> getBook() throws Exception{
		List<BookPo>  booklist=new ArrayList<BookPo>();
		
//		Connection con= DriveUtil.getcon(); 
//		String sql="select * from book";
//    	PreparedStatement stmt=con.prepareStatement(sql); 
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	String book_name=se.getString("book_name");
//	    	String book_writer=se.getString("book_writer");
//	    	String book_amg=se.getString("book_amg");
//	    	int book_samem=se.getInt("book_samem");
//	    	int book_margin=se.getInt("book_margin");
//	    	int id=se.getInt("id");
//	    	BookPo book=new BookPo(id,book_name,book_writer,book_amg,book_samem,book_margin);
//	    	booklist.add(book);
//	    }
//	    DriveUtil.close(con, stmt);
		
			DBAccess dbAccess = new DBAccess();
			SqlSession sqlSession = null;
			try {
				sqlSession = dbAccess.getSqlSession();
				/*下面就是接口式编程*/
				/*Book ibook=sqlSession.getMapper(Book.class);
				booklist=ibook.queryBookByPage();*/
				String statements="com.yezhihao.www.po.Book.getBook";
				booklist= sqlSession.selectList(statements);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBAccess.closeSqlSession(sqlSession);
			}

		return (ArrayList<BookPo>) booklist;
	}
	
	
	
	public ArrayList<BookPo> getPageBook(String curPage1) throws Exception{
		
//		ArrayList<BookPo>  booklist=new ArrayList<BookPo>();
//		Connection con= DriveUtil.getcon(); 
		int curPage=Integer.valueOf(curPage1)-1;
//		String sql="select  * from book ";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//    	ResultSet se=stmt.executeQuery();
    	int ret=0;
//	    while(se.next()){
//	    	String book_name=se.getString("book_name");
//	    	String book_writer=se.getString("book_writer");
//	    	String book_amg=se.getString("book_amg");
//	    	int book_samem=se.getInt("book_samem");
//	    	int book_margin=se.getInt("book_margin");
//	    	int id=se.getInt("id");
//	    	BookPo book=new BookPo(id,book_name,book_writer,book_amg,book_samem,book_margin);
//	    	if(curPage*8<=ret&&ret<8*(curPage+1)){
//	    	booklist.add(book);
//	    	}else if(ret>=8*(curPage+1)){
//	    		break;
//	    	}
//	    	ret++;
//	    }
//	    DriveUtil.close(con, stmt);
//		return booklist;
		
		List<BookPo>  booklist1=getBook();
		ArrayList<BookPo>  booklist=new ArrayList<BookPo>();
		for (BookPo book : booklist1) {
			if(curPage*8<=ret&&ret<8*(curPage+1)){
		    	booklist.add(book);
		    	}else if(ret>=8*(curPage+1)){
		    		break;
		    	}
			ret++;
		}
		return booklist;
	}
	
	public BookPo getBookById(int id) throws Exception {
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		Connection con= DriveUtil.getcon();
//		try {
//			String sql = "select * from book where id=?"; // SQL语句
//			stmt = con.prepareStatement(sql);
//			stmt.setInt(1, id);
//			rs = stmt.executeQuery();
//			if (rs.next()) {
//				BookPo book = new BookPo();
//				book.setId(rs.getInt("id"));
//				book.setBook_name(rs.getString("book_name"));
//				book.setBook_amg(rs.getString("book_amg"));
//				book.setBook_writer(rs.getString("book_writer"));
//				book.setBook_margin(rs.getInt("book_margin"));
//				book.setBook_samem(rs.getInt("book_samem"));
//				return book;
//			} else {
//				return null;
//			}
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			return null;
//		} 
//		finally {
//		    DriveUtil.close(con, stmt);
//		}
	
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		BookPo Book=null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.Book.getBookById";
			Book= sqlSession.selectOne(statements, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
		return Book;
	}
	
	
	public int getBooknum() throws Exception{
//		Connection con= DriveUtil.getcon(); 
//		String sql="select * from book";
//    	PreparedStatement stmt=con.prepareStatement(sql); 
//    	ResultSet se=stmt.executeQuery();
//    	int ret=0;
//	    while(se.next()){
//	    	ret++;
//	    }
//	    DriveUtil.close(con, stmt);
	    List<BookPo>  booklist=getBook();
	    int ret=booklist.size();
		return ret;
	}
	
	
	public ArrayList<BookPo> getViewList(String list) throws NumberFormatException, Exception
	{
		ArrayList<BookPo> booklist = new ArrayList<BookPo>();
		int iCount=5; //每次返回前五条记录
		if(list!=null&&list.length()>0)
		{
		    String[] arr = list.split(",");
		    //如果商品记录大于等于5条
		    if(arr.length>=5)
		    {
		       for(int i=arr.length-1;i>=arr.length-iCount;i--)
		       {
		    	   if(getBookById(Integer.parseInt(arr[i]))!=null){
		    		   booklist.add(getBookById(Integer.parseInt(arr[i])));  
		    	   }
		    	  }
		    }
		    else
		    {
		    	for(int i=arr.length-1;i>=0;i--)
		    	{
		    		booklist.add(getBookById(Integer.parseInt(arr[i])));
		    	}
		    }
		    return booklist;
		}
		else
		{
			return null;
		}
		
	}
}
