<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("ret").equals("0")) {%>
<h1>申请失败，该书库存已为零</h1>
<%}else{ %>
<h1>您已经申请过了，请耐心等待管理员审核</h1>
<% }%>
<table  align="center" width="500" height="450">
  <tr><td colspan="4" align="center"><img src ="http://www.cncz360.com/file/upload/201508/29/15-23-21-34-3.jpg"height="300"></td></tr>
  </table>
</body>
</html>