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
	<c:if test="${a==ture}">
		<h1>下架成功</h1>
	</c:if>
	<c:if test="${a!=ture}">
		<h1>下架成功，但由于已借出${m}本无法下架。</h1>
	</c:if>
	<a href="Administrator.jsp">返回主界面</a><br>
</body>
</html>