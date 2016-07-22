package com.yezhihao.www.dao;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.UserPo;

public class RegisterUserDao {

	public boolean adduser(UserPo user) throws Exception{
//		Connection con= DriveUtil.getcon(); 
//		String sql="insert into user values (null,?,?,?,?,?,?)";    	
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setString(1,user.getUsre_name());
//		stmt.setString(2,user.getPassword());
//		stmt.setString(3,user.getType());
//		stmt.setString(4,user.getUser_amg());
//		stmt.setString(5,user.getPossword_request());
//		stmt.setString(6,user.getPossword_right());
//    	int result=stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
//	    if(result==1){
//	    	return true;
//	    }
//		return false;
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		int result=0;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.User.addUser";
			result=sqlSession.insert(statements,user);
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
