<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.po.BookPo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>成功上架</title>
</head>
<body>

	<h1>您上架的图书如下：</h1>
	<table align="center" width="500" height="300">
	<tr><td><img src="${ pageContext.request.contextPath }/amg_lib/${book.book_amg}" width="200" height="200"/></td></tr>
	<tr><td>书名：${book.book_name}</td> </tr>
	<tr><td>作者：${book.book_writer}</td></tr>
	<tr><td>上架总数：${book.book_samem}本</td></tr> 
	<tr><td>库存剩余总数：${book.book_margin}本</td></tr> 
	<tr><td><a href="${ pageContext.request.contextPath }/Administrator.jsp">确定</a></td></tr> 
	</table>
</body>
</html>