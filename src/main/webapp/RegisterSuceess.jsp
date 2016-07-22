<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.po.UserPo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
UserPo user=(UserPo)session.getAttribute("user");
%>
<h1>注册成功，信息如下：</h1>
<table align="center" width="500" height="300">
<tr><td><img src="<%=request.getContextPath()%>/amg_lib/<%=user.getUser_amg()%>" width="200" height="200"/></td></tr>
<tr><td>用户名：<%=user.getUsre_name()%></td> </tr>
<tr><td>密码：<%=(String)session.getAttribute("password")%></td></tr>
<tr><td>用户类型：<%=user.getType()%></td></tr> 
<tr><td><a href="Login.jsp">确定</a></td></tr> 
</table>
</body>
</html>