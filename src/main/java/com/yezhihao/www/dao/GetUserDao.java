package com.yezhihao.www.dao;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.UserPo;


public class GetUserDao {
	
	/*获取所有的用户*/
	public ArrayList<UserPo> getUser() throws Exception{
		List<UserPo>  userlist=new ArrayList<UserPo>();
//		Connection con= DriveUtil.getcon(); 
//		String sql="select * from user";
//    	PreparedStatement stmt=con.prepareStatement(sql); 
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	int id=se.getInt("id");
//	    	String userName=se.getString("usre_name");
//	    	String password=se.getString("password");
//	    	String type=se.getString("type");
//	    	UserPo user=new UserPo(id,userName,password,type);
//	    	userlist.add(user);
//	    }
//	    DriveUtil.close(con, stmt);
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.User.getUser";
			userlist= sqlSession.selectList(statements);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
		return (ArrayList<UserPo>) userlist;
	}
	
	public ArrayList<UserPo> getgeneralUser() throws Exception{
		List<UserPo>  userlist=new ArrayList<UserPo>();
//		Connection con= DriveUtil.getcon(); 
//		String sql="select * from user where type=?";
//    	PreparedStatement stmt=con.prepareStatement(sql); 
//    	stmt.setString(1,"普通用户");
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	int id=se.getInt("id");
//	    	String userName=se.getString("usre_name");
//	    	String password=se.getString("password");
//	    	String type=se.getString("type");
//	    	String user_amg=se.getString("user_amg");
//	    	UserPo user=new UserPo(id,userName,password,type,user_amg);
//	    	userlist.add(user);
//	    }
//	    DriveUtil.close(con, stmt);
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.User.getgeneralUser";
			userlist= sqlSession.selectList(statements,"普通用户");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
		return (ArrayList<UserPo>) userlist;
	}
	
	
	public UserPo getuserbyusername( String username ) throws Exception{
//		Connection con= DriveUtil.getcon(); 
		UserPo user = null;
//		String sql="select * from user where usre_name=?";
//    	PreparedStatement stmt=con.prepareStatement(sql); 
//    	stmt.setString(1,username);
//    	ResultSet se=stmt.executeQuery();
//	    while(se.next()){
//	    	int id=se.getInt("id");
//	    	String userName=se.getString("usre_name");
//	    	String password=se.getString("password");
//	    	String type=se.getString("type");
//	    	String user_amg=se.getString("user_amg");
//	    	String possword_request=se.getString("possword_request");
//	    	String possword_right=se.getString("possword_right");
//	    	user=new UserPo(id,userName,password,type,user_amg);
//	    	user.setPossword_request(possword_request);
//	    	user.setPossword_right(possword_right);
//	    }
//	    DriveUtil.close(con, stmt);
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.User.getuserbyusername";
			user= sqlSession.selectOne(statements,username);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
		
		return user ;
	}
}