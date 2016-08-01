package com.yezhihao.www.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yezhihao.www.dao.User;
import com.yezhihao.www.po.UserPo;
import com.yezhihao.www.view.RegisterUserServlet;


@Service("LonginService")
public class LonginService {
			
	@Autowired
	private User user;
	
	public boolean login(UserPo a_user) throws Exception{
		//GetUserDao userDao=new GetUserDao();
		ArrayList<UserPo> Userlist=new ArrayList<UserPo>();
		//Userlist=userDao.getUser();
		Userlist=(ArrayList<UserPo>) user.getUser();
		UserPo user=new UserPo();
		for(UserPo user1:Userlist){
			user=user1;
			if(user.getUsre_name().equals(a_user.getUsre_name())&&user.getType().equals(a_user.getType())){
				boolean a= check(user.getPassword(),a_user.getPassword());
				if(a==true){
				return true;
				}
			}
		}
		return false;
	}
	
	public boolean check(String SQLpass,String password) { 
		String mdpass=RegisterUserServlet.getMD5(password);
		if(SQLpass.equals(mdpass)){
		return true;
		} else{
		return false;
		    }  
		}
}	