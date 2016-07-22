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
<%
if(request.getParameter("a").equals("ture")){
	BookPo book=(BookPo)session.getAttribute("book");
	%>
	<h1>您上架的图书如下：</h1>
	<table align="center" width="500" height="300">
	<tr><td><img src="<%=request.getContextPath()%>/amg_lib/<%=book.getBook_amg()%>" width="200" height="200"/></td></tr>
	<tr><td>书名：<%=book.getBook_name()%></td> </tr>
	<tr><td>作者：<%=book.getBook_writer()%></td></tr>
	<tr><td>上架总数：<%=book.getBook_samem()%>本</td></tr> 
	<tr><td>库存剩余总数：<%=book.getBook_margin()%>本</td></tr> 
	<tr><td><a href="Administrator.jsp">确定</a></td></tr> 
	</table>
<% }
else{%>
	<h1>添加失败，图书已存在</h1>
<% }%>
</body>
</html>