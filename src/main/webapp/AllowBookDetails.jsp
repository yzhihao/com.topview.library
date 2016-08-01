<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetBorrowBookDao" %>
<%@page import="com.yezhihao.www.po.BorrowBookPo" %>
<%@page import="java.util.ArrayList" %>     
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
     <form action="servlet/AllowApplyServlet" name="regForm" method="post">
      <table width="750" height="60" cellpadding="0" cellspacing="0" border="0">
        <tr>
          <td width="70%" valign="top">
             <table><tr><td rowspan="5"><img src="${ pageContext.request.contextPath }/amg_lib/${book.book_amg}" width="120"  /></td></tr>
               <tr><td>书名：<B>${book.book_name}</B></td> </tr>
               <tr><td>借书ID：${book.borrow_bookid}</td> </tr>
               <tr><td>申请人：${book.user_name}</td></tr>
               <tr><td>申请时间：${book.borrow_date}</td></tr> 
               <tr><td><input type="radio" value="1" name="agree"/>同意</td></tr>
	  		   <tr><td><input type="radio" value="0" name="agree" />不同意</td></tr>
	  		   <tr><td><input name="regForm" type="submit" value="提交"></td></tr>
             </table>
          </td>
        </tr>
      </table>
       </form>
    </center>
</body>
</html>