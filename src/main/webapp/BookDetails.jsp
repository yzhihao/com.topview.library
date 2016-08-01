<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetBookDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.UserPo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>图书详情</h1>
    <hr>
    <center>
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <td width="70%" valign="top">
             <table><tr><td rowspan="5"><img src="${ pageContext.request.contextPath }/amg_lib/${book.book_amg}" width="120" height="130" border="1"/></td></tr>
               <tr><td>书名：<B>${book.book_name}</B></td> </tr>
               <tr><td>作者：${book.book_writer}</td></tr>
               <tr><td>库存量：${book.book_samem}本</td></tr> 
               <tr><td> 可供借出:${book.book_margin}本</td></tr> 
               
               <c:if test="${ret==1}">
				<tr><td><a href="ApplyBorrowBook?id=${book.id}&Book_name=${book.book_name}&book_margin=${book.book_margin}">申请借阅</a></td></tr> 
                <tr><td><a href="CollectBookServlet?id=${book.id}">加入收藏夹</a></td></tr>               
               </c:if>
             </table>
          </td>
          
          <!-- 浏览过的商品 -->
          <td width="30%" bgcolor="#EEE" align="center">
             <br>
             <b><font color="#FF7F00">您浏览过的书籍</font></b><br>
             <!-- 循环开始 -->
             
             <c:if  test="${list!=null}">
			<c:forEach items="${list}" var="book">
             <div>
             <dl>
               <dt>
				<a href="BookDetails?id=${book.id}"><img src="${ pageContext.request.contextPath }/amg_lib/${book.book_amg}" width="120" height="130" /></a>               </dt>
               <dd class="dd_name">书名：${book.book_name}</dd> 
               <dd class="dd_seller">作者:${book.book_writer}&nbsp;&nbsp;余量:${book.book_margin} 本</dd> 
             </dl>
             </div>
             </c:forEach>
             </c:if>
             
             <!-- 循环结束 -->
          </td>
        </tr>
      </table>
    </center>
</body>
</html>