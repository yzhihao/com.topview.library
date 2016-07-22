<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%if(request.getParameter("a").equals("ture")){ %>
	<h1>登录失败,请检查账号密码</h1>
	<% }else{%>
		<h1>登录失败,请检查参数是否输入错误</h1>
	<% }%>
	<a href="Login.jsp">返回登录界面</a><br>
</body>
</html>