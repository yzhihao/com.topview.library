package com.yezhihao.www.service;

import com.yezhihao.www.dao.RegisterUserDao;
import com.yezhihao.www.po.UserPo;

public class RegisterUserService {

	public static boolean adduser(UserPo user) throws Exception {
		RegisterUserDao registerUserDao=new RegisterUserDao();
		Boolean a=registerUserDao.adduser(user);
		return a;
	}
	
}
