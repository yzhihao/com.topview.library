<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.UserPo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
 <form action="ChangePassword" name="regForm" method="post">
  <table  align="center" width="500" height="450">
  <tr><td colspan="2" align="center"><img src ="http://src.house.sina.com.cn/imp/imp/deal/91/1e/d/edeb32ced44028a2c8c5715f910_p1_mk1.jpg"height="300"></td></tr>
  <tr><td  align="center">问题：</td><td><input type="text" name="request" value="${user.possword_request}" id="request"/></td>  
  <tr><td  align="center">请输入答案：</td><td><input type="text" name="answer"  id="answer"/></td></tr>  
  <tr><td><input type="hidden"  name="a1" value="${user.possword_right}"></td></tr>
  <tr><td><input type="hidden"  name="username" value="${user.usre_name}"></td></tr>
  <tr><td  align="right"><input name="regForm" type="submit" value="提交"></td></tr>
  </table>
  <h6><a href="setmail">发送密码到我的邮箱</a></h6>
</form>
</body>
</html>