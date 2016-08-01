<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.SelectBookDao" %>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
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
	   div dd.writer
	   {
	      color:#000;
	   }
	    div dd.delete
	   {
	      color:#000;
	   }
	</style>
</head>
<body>
   <h1>查询条件：<%=request.getParameter("select")%></h1>
    <hr>
    <center>
	<div id="center">
	
    <%--       <% 
          	SelectBookDao bookDao = new SelectBookDao(); 
               ArrayList<BookPo> list =bookDao.getBookByselect(request.getParameter("select"));
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	            	   BookPo book = list.get(i);
           %>  --%>  
           <c:if test="${list!=null}">
          <c:forEach items="${list}" var="book">
          <div id="onebook">
             <dl>
               <dt>
                <a href="BookDetails?id=${book.id} "><img src="<%=request.getContextPath()%>/amg_lib/${book.book_amg}" width="120" height="130" /></a>
               </dt>
               <dd class="name">书名：${book.book_name}</dd> 
               <dd class="writer">作者:${book.book_writer}</dd> 
               <c:if test="${ret==0}">
               <dd class="delete"><a href="servlet/DeleteDookServlet?book_id=${book.id}&a=false">图书下架</a></dd> 
               </c:if>
             </dl>
          </div>
          </c:forEach>
          </c:if>
         
	</div>
    </center>
</body>
</html>