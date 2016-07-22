package com.yezhihao.www.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.yezhihao.www.po.Listener_UserPo;
import com.yezhihao.www.util.SessionUtil;

@WebListener
public class MyReqestListener implements ServletRequestListener {

	private ArrayList<Listener_UserPo> userList;//在线用户List
	
	public void requestDestroyed(ServletRequestEvent arg0) {

	}

	@SuppressWarnings("unchecked")
	public void requestInitialized(ServletRequestEvent arg0) {
		
		userList  = (ArrayList<Listener_UserPo>)arg0.getServletContext().getAttribute("userList");
		
		if(userList==null)
			userList = new ArrayList<Listener_UserPo>();
		
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
		String sessionIdString = request.getSession().getId();
		
		if(SessionUtil.getUserBySessionId(userList,sessionIdString)==null){
			Listener_UserPo user = new Listener_UserPo();
			user.setSessionIdString(sessionIdString);
			user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			user.setIpString(request.getRemoteAddr());
			userList.add(user);
		}
		arg0.getServletContext().setAttribute("userList", userList);
	}
}
