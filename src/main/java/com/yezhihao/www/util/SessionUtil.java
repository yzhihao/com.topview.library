package com.yezhihao.www.util;

import java.util.ArrayList;

import com.yezhihao.www.po.Listener_UserPo;



public class SessionUtil {

	public static Object getUserBySessionId(ArrayList<Listener_UserPo> userList, String sessionIdString) {
		for (int i = 0; i < userList.size(); i++) {
			Listener_UserPo user = userList.get(i);
			if (user.getSessionIdString().equals(sessionIdString)) {
				return user;
			}
		}
		return null;
	}
}
