package com.yezhihao.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezhihao.www.dao.User;
import com.yezhihao.www.po.UserPo;

@Service("RegisterUserService")
public class RegisterUserService {

	@Autowired
	private User user;

	public  boolean adduser(UserPo user1) throws Exception {
		//RegisterUserDao registerUserDao=new RegisterUserDao();
		user.addUser(user1);
		//Boolean a=registerUserDao.adduser(user);
		return true;
	}
	
}
