package com.yezhihao.www.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yezhihao.www.po.UserPo;

@Service
public interface User {
	/*增加用户*/
    public void addUser(UserPo userPo);
    
    /*获取所有的用户*/
	 public List<UserPo> getUser();
	 
	 /*获取普通用户*/ 
	 public List<UserPo> getgeneralUser(String String);
	 
	 /*通过用户名来获取用户*/
	 public List<UserPo> getuserbyusername(String String);
	 
	/* 更新用户的信息*/ 
	 public void updateuserdao(UserPo userPo);

}
