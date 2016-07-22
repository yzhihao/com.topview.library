package com.yezhihao.www.dao;

import org.apache.ibatis.session.SqlSession;

import com.yezhihao.www.db.DBAccess;
import com.yezhihao.www.po.UserPo;

public class UpdateUserDao {

	public boolean updateuserdao(String possword,String user_name) throws Exception{
//		Connection con= DriveUtil.getcon(); 
//		String sql="update  user  set password=? where usre_name=?";
//		PreparedStatement stmt=con.prepareStatement(sql); 
//		stmt.setString(1,possword);
//		stmt.setString(2,user_name);
//    	stmt.executeUpdate();
//	    DriveUtil.close(con, stmt);
		UserPo UserPo=new UserPo();
		UserPo.setPossword_request(possword);
		UserPo.setUsre_name(user_name);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			String statements="com.yezhihao.www.po.user.updateuserdao";
			sqlSession.update(statements,UserPo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBAccess.closeSqlSession(sqlSession);
		}
	    return true;
	}
}
