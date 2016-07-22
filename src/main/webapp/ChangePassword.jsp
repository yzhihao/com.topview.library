<%@page import="com.yezhihao.www.view.RegisterUserServlet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
     function judge(){
       var obj = document.getElementById("possword1");
   		var obj1 = document.getElementById("password");
        var reg1 = new RegExp("^[a-zA-Z]{1}[0-9a-zA-Z]{5,14}$");
     	if(!reg1.test(obj.value)){
     	alert("密码只能是6-15位数字或字母且必须由字母开头");
     	return false;
    	}else if(obj.value==obj1.value()){
    		return true;
    }else{
    	alert("两次输入的密码不一致");
    	return false;    }
  }
  </script>
</head>
<body>
	<%
	String answer=RegisterUserServlet.getMD5(request.getParameter("answer"));
	System.out.print(answer);
	if(answer.equals(request.getParameter("a1"))){%>
	<h1>回答正确</h1>
	<form action="servlet/ChangePosswordServlet" name="regForm" method="post" onsubmit="return judge()">
  	<table  align="center" width="500" height="450">
  	<tr><td colspan="2" align="center"><img src ="http://src.house.sina.com.cn/imp/imp/deal/91/1e/d/edeb32ced44028a2c8c5715f910_p1_mk1.jpg"height="300"></td></tr>
  	<tr><td  align="center">新的密码：</td><td><input type="text" name="possword1" id="possword1"/></td>  
  	<tr><td  align="center">再输入一次：</td><td><input type="text" name="possword" id="possword" /></td> 
  	<tr><td><input type="hidden"  name="username" value="<%=request.getParameter("username") %>"></td></tr> 
  	<tr><td  align="right"><input name="regForm" type="submit" value="提交"></td></tr>
  	</table>
	</form>
	<% }else{%>
		<h1>回答错误</h1>
	<% }%>
	<a href="Login.jsp">返回登录界面</a><br>
</body>
</html>