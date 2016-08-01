<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetCollectBookDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
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
	   	  hight:350px;
	   	  float:left;
	      margin: 0px;
	      padding:0px;
	   }
	   div dd{
	      margin:0px;
	      font-size:15pt;
	   }
	   div dd.name
	   {
	      color:blue;
	   }
	   div dd.writer
	   {
	      color:#000;
	   }
	    div dd.samem
	   {
	      color:#000;
	   }
	    div dd.margin
	   {
	      color:#000;
	   }
	   div dd.apply
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
<h1>收藏夹</h1>
<center>
<div id="center">
       
		<c:if  test="${list!=null}">
		<c:forEach items="${list}" var="book">
          <div id="onebook">
             <dl>
               <dt>
               <img src="${ pageContext.request.contextPath }/amg_lib/${book.book_amg}" width="120" height="130" />
               </dt>
               <dd class="name">书名：${book.book_name}</dd> 
               <dd class="writer">作者:${book.book_writer}</dd> 
               <dd class="samem">库存量：${book.book_samem}</dd> 
               <dd class="margin">可供借出:${book.book_margin}</dd> 
               <dd class="apply"><a href="servlet/ApplyBorrowBook?id=${book.id}&Book_name=${book.book_name}&book_margin=${book.book_margin}">申请借阅</a></dd> 
             <dd class="delete"><a href="servlet/DeleteDookServlet?a=ture&book_id=${book.id}">移出收藏夹</a></dd> 
             </dl>
          </div>
          </c:forEach>
          </c:if>
     
      </div>
     
    </center>
</body>
</html>