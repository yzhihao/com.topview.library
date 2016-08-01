package com.yezhihao.www.dao;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yezhihao.www.po.UserPo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring_mybatis.xml")

public class UserTest {
	
	@Autowired
	private User user;
	
	@Test
	public void testAdd() {
		List<UserPo> a= user.getUser();
		System.out.println(a.get(1).getUsre_name());
	}
}	

