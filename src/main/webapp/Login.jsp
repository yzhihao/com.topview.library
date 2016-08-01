<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.po.UserPo" %>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
<script type="text/javascript">
     function judge(){
       var reg = new RegExp("^[0-9a-zA-Z]{3,10}$");
       var reg1 = new RegExp("^[a-zA-Z]{1}[0-9a-zA-Z]{5,14}$");
       var obj = document.getElementById("username");
    if(!reg.test(obj.value)){
        alert("用户名只能是3-10位数字或字母!");
        return false;
    }
    else{
   		var obj1 = document.getElementById("password");
    	if(!reg1.test(obj1.value)){
    	alert("密码只能是6-15位数字或字母且必须由字母开头");
    	return false;
    }
  }
  }
     function reloadCode(){
			var time = new Date().getTime();
			document.getElementById("imagecode").src="<%=basePath%>servlet/ImageServlet?d="+time;
		}
  </script>
</head>
<body>
<% 
      request.setCharacterEncoding("utf-8");
      String username="";
      String password = "";
      Cookie[] cookies = request.getCookies();
      if(cookies!=null&&cookies.length>0)
      {
           for(Cookie c:cookies)
           {
              if(c.getName().equals("Username"))
              {
                   username =  URLDecoder.decode(c.getValue(),"utf-8");
              }
              if(c.getName().equals("Password"))
              {
                   password =  URLDecoder.decode(c.getValue(),"utf-8");
              }
           }
      }
     /*  	GetUserDao userDao=new GetUserDao();
		ArrayList<UserPo> Userlist=new ArrayList<UserPo>();
		Userlist=userDao.getUser();
		for(UserPo user1:Userlist){
			if(user1.getUsre_name().equals(username)&&user1.getPassword().equals(password)){
				session.setAttribute("username", username);
				if(user1.getType().equals("管理员")){
					response.sendRedirect(request.getContextPath()+"/Administrator.jsp");
				}
				if(user1.getType().equals("普通用户")){
					response.sendRedirect(request.getContextPath()+"/GeneralUser.jsp");
				}
				break;
			}
		} */
    %>
 <form action="servlet/LonginServlet" name="regForm" method="post" onsubmit="return judge()">
  <table  align="center" width="500" height="450">
  <tr><td  >当前在线人数：${usernum}</td><td>总访问量：${allusernum}</td><td><a href="Listener">查看登录数据</a></td><tr>
  <tr><td colspan="4" align="center"><img src ="http://src.house.sina.com.cn/imp/imp/deal/91/1e/d/edeb32ced44028a2c8c5715f910_p1_mk1.jpg"height="300"></td></tr>
  <tr><td  align="right">用户名</td><td><input type="text" name="usre_name" value="<%=username%>" id="username"/></td>  
  <tr><td  align="right">密码</td><td><input type="password" name="password"  value="<%=password %>" id="password"/></td></tr>
  <tr><td  align="right"><input type="radio" value="普通用户" name="type" checked="checked"/>普通用户</td>
  <td><input type="radio" value="管理员" name="type" />管理员</td></tr>
   <% if(username.equals("")){%>
  <tr><td  align="right">验证码：</td><td colspan="3"><input type="text" name="checkcode" id="checkcode"/>
      <img  src="<%=basePath%>servlet/ImageServlet" alt="验证码" id="imagecode"/>
      <a href="javascript: reloadCode();">看不清楚</a></td></tr>
      <%}%>
  <tr><td  colspan="2" align="center"><input type="checkbox" name="isUseCookie" checked="checked"/>十天内记住我的登录状态</td></tr>
  <tr><td  align="right"><input name="regForm" type="submit" value="提交"></td><td><a href="InputPossworld.jsp">忘记密码</a></td><td  colspan="2"><a href="RegisterUser.jsp">注册</a></td></tr>
  </table>
  </form>
</body>
</html>