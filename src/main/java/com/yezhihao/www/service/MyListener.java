package com.yezhihao.www.service;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
@WebListener
public class MyListener implements HttpSessionListener {
	private static int allusernum;
	private static int usernum;
	public void sessionCreated(HttpSessionEvent arg0) {
		usernum++;
		arg0.getSession().getServletContext().setAttribute("usernum", usernum);
		allusernum++;
		arg0.getSession().getServletContext().setAttribute("allusernum", allusernum);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		usernum--;
		arg0.getSession().getServletContext().setAttribute("usernum", usernum);
	}
}
