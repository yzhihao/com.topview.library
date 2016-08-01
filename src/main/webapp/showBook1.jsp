<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@page import="com.yezhihao.www.dao.GetBookDao" %>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
<%@page import="com.yezhihao.www.po.BookPagePo" %>
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
	   div#button{
	   	  width:1020px;
	   	  hight:30px;
	  	  float:left;
	      margin: 0px;
	      padding:0px;
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
	    div dd.update
	   {
	      color:#000;
	   }
	</style>
</head>
<body>
   <h1>图书展示</h1>
    <hr>
    <center>
	<div id="center">
	 <form action="ShowSelectBook" name="regForm" method="post" onsubmit="return judge()">
	 	查询：<input type="text" name="select" id="select"/><input name="regForm" type="submit" value="提交">
	</form>
          <c:if test="${booklist!=null}">
          <c:forEach items="${booklist}" var="book">
          <div id="onebook">
             <dl>
               <dt>
                 <a href="BookDetails?id=${book.id} "><img src="${ pageContext.request.contextPath }/amg_lib/${book.book_amg}" width="120" height="130" /></a>
               </dt>
               <dd class="name">书名：${book.book_name}</dd> 
               <dd class="writer">作者:${book.book_writer}</dd> 
               
               <c:if test="${ret==0}">
				<dd class="delete"><a href="DeleteDookServlet?book_id=${book.id}&a=false">图书下架</a></dd> 
                <dd class="update"><a href="UdateBook?book_id=${book.id}">修改图书信息</a></dd> 
              	</c:if>
              	
             </dl>
          </div>
          </c:forEach>
          </c:if>
         <div id="button">
          	共${page.totalNumber}行； 第${page.currentPage}页；共${page.totalPage}页
	       <c:choose>
	   		<c:when test="${page.totalPage== 1 || page.totalPage== 0}">  
		   </c:when>
		   <c:otherwise> 
		   
		    <c:choose>
	   		<c:when test="${page.currentPage== 1 }">  
	   		<a HREF="ShowBook?curPage=${page.currentPage+1}">下一页</A>
        	<a HREF="ShowBook?curPage=${page.totalPage}">末页</A>
			</c:when>
			<c:when test="${page.currentPage==page.totalPage }">  
	   		<a HREF="ShowBook?curPage=1">首页</A>
			<a HREF="ShowBook?curPage=${page.currentPage-1}">上一页</A>
			</c:when>
			<c:otherwise>
			 <a HREF="ShowBook?curPage=1">首页</A>
			 <a HREF="ShowBook?curPage=${page.currentPage-1}">上一页</A>
			 <a HREF="ShowBook?curPage=${page.currentPage+1}">下一页</A>
			 <a HREF="ShowBook?curPage=${page.totalPage}">末页</A>
		   	</c:otherwise>
			</c:choose>
		
	   	</c:otherwise>
		</c:choose>
         </div>
		 </div>
    </center>
</body>
</html>