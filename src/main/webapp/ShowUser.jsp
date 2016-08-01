<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.UserPo" %>
<%@page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
 <h1>user</h1>
    <hr>
    <center>
	<div id="center">
          
          <c:if  test="${list!=null}">
		<c:forEach items="${list}" var="user">
          <div id="onebook">
             <dl>
               <dt>
                 <a href="OneUserBorrowCondition.jsp?username=${user.usre_name}"><img src="${ pageContext.request.contextPath }/amg_lib/${user.user_amg}" width="120" height="130" /></a>
               </dt>
               <dd class="name">用户名：${user.usre_name}</dd> 
              <dd class="name"> <a href="OneOldBorrowCondition.jsp?username=${user.usre_name}">借阅历史</a></dd>
             </dl>
          </div>
          </c:forEach>
          </c:if>
	</div>
    </center>
</body>
</html>