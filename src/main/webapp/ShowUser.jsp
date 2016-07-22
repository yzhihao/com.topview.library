<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.UserPo" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
	   div#center{
	   width:1020px;
	   
	   }
	   div#onebook{
	   	  width:220px;
	   	  hight:130px;
	  	  float:left;
	      margin: 0px;
	      padding:0px;
	   }
	   div dd{
	      margin:0px;
	      font-size:13pt;
	   }
	   div dd.name
	   {
	      color:blue;
	   }
	  
	</style>
</head>
<body>
 <h1>图书展示</h1>
    <hr>
    <center>
	<div id="center">
          <% 
          	   GetUserDao userDao = new GetUserDao(); 
               ArrayList<UserPo> list =userDao.getgeneralUser();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	            	   UserPo user = list.get(i);
           %>   
          <div id="onebook">
             <dl>
               <dt>
                 <a href="OneUserBorrowCondition.jsp?username=<%=user.getUsre_name()%>"><img src="/upload/<%=user.getUser_amg()%>" width="120" height="130" /></a>
               </dt>
               <dd class="name">用户名：<%=user.getUsre_name() %></dd> 
              <dd class="name"> <a href="OneOldBorrowCondition.jsp?username=<%=user.getUsre_name()%>">借阅历史</a></dd>
             </dl>
          </div>
          <%
            }
           	} 
          %>
	</div>
    </center>
</body>
</html>