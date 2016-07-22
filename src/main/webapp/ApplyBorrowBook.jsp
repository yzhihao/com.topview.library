<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table  align="center" width="500" height="450">
<%if(request.getParameter("a").equals("ture"))
	{
%>
  <tr><td><h1>申请成功，请耐心等待管理员审核</h1></td></tr>
  <tr><td><img src ="http://img.xiaogushi.com/d/file/201507/80f4c5aa4a80652211fb149b22a34eae.jpg"height="300"></td></tr>
<% 
}
%>
  </table>
</body>
</html>