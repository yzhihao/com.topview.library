<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.SelectBookDao" %>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
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
	
          <% 
          	SelectBookDao bookDao = new SelectBookDao(); 
               ArrayList<BookPo> list =bookDao.getBookByselect(request.getParameter("select"));
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	            	   BookPo book = list.get(i);
           %>   
          <div id="onebook">
             <dl>
               <dt>
                 <a href="BookDetails.jsp?id=<%=book.getId()%>"><img src="<%=request.getContextPath()%>/amg_lib/<%=book.getBook_amg()%>" width="120" height="130" /></a>
               </dt>
               <dd class="name">书名：<%=book.getBook_name() %></dd> 
               <dd class="writer">作者:<%=book.getBook_writer()%></dd> 
               <%
               GetUserDao GetUserDao=new GetUserDao();
               ArrayList<UserPo> list1=GetUserDao.getgeneralUser();
               int ret=0;
               for(UserPo User:list1){
            	   if(((String)session.getAttribute("username")).equals(User.getUsre_name())){
            		   ret=1;
            		   break;
            	   }
               }
               if(ret==0){
               %>
               <dd class="delete"><a href="servlet/DeleteDookServlet?book_id=<%= book.getId()%>&a=false">图书下架</a></dd> 
               <% }%>
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