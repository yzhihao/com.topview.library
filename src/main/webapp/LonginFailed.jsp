<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <%if(request.getParameter("a").equals("ture")){ %> --%>
	<c:if test="${a=='ture'}">
		<h1>登录失败,请检查账号密码</h1>
	</c:if>
	<%-- <% }else{%> --%>
	<c:if test="${a=='false'}">
	<h1>登录失败,请检查参数是否输入错误</h1>	
	</c:if>
	<%-- <% }%> --%>
	<h1>登录失败</h1>	
	<a href="http://localhost:8080/yezhihao.toptiew.booksystem/Login.jsp">返回登录界面</a><br>
</body>
</html>