<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetBorrowBookDao" %>
<%@page import="com.yezhihao.www.po.BorrowBookPo" %>
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
	   div dd.username
	   {
	      color:#000;
	   }
	   div dd.date
	   {
	      color:#000;
	   }
	</style>
</head>
<body>
 <h1>借出图书展示</h1>
    <hr>
    <center>
	<div id="center">
    <%--       <% 
          GetBorrowBookDao bookDao = new GetBorrowBookDao(); 
               ArrayList<BorrowBookPo> list =bookDao.getBorrowBook();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	            	   BorrowBookPo applybook = list.get(i);
           %>   
          <div id="onebook">
             <dl>
               <dt>
                 <img src="/upload/<%=applybook.getBook_amg()%>" width="120" height="130" />
               </dt>
               <dd class="name">书名：<%=applybook.getBook_name() %></dd> 
               <dd class="username">借书用户：<%=applybook.getUser_name() %></dd>
               <dd class="date">审核时间:<%=applybook.getBorrow_date()%></dd>
               <dd class="date">应还时间:<%=applybook.getReturn_date()%></dd>
             </dl>
          </div>
          <%
            }
           	} 
          %> --%>
          
          <c:if  test="${list!=null}">
			<c:forEach items="${list}" var="book">
          <div id="onebook">
             <dl>
               <dt>
                 <img src="${ pageContext.request.contextPath }/upload/${book.book_amg}" width="120" height="130" />
               </dt>
               <dd class="name">书名：${book.book_name}</dd> 
               <dd class="username">借书用户：${book.user_name}</dd>
               <dd class="date">审核时间:${book.borrow_date}</dd>
               <dd class="date">应还时间:${book.return_date}</dd>
             </dl>
          </div>
          </c:forEach>
          </c:if>
	</div>
    </center>

</body>
</html>