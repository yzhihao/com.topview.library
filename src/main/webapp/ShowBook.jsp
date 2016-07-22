<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@page import="com.yezhihao.www.dao.GetBookDao" %>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
<%@page import="com.yezhihao.www.po.BookPagePo" %>
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
	 <form action="ShowSelectBook.jsp" name="regForm" method="post" onsubmit="return judge()">
	 	查询：<input type="text" name="select" id="select"/><input name="regForm" type="submit" value="提交">
	</form>
          <% 
          BookPagePo page1=new BookPagePo();
          page1.setPageBean();
          String curPage=request.getParameter("curPage");
          page1.setCurPage(Integer.valueOf(curPage));
          	   GetBookDao bookDao = new GetBookDao(); 
               ArrayList<BookPo> list =bookDao.getPageBook(curPage);
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
                <dd class="update"><a href="UdateBook.jsp?book_id=<%= book.getId()%>">修改图书信息</a></dd> 
               <% }
               %>
             </dl>
          </div>
           <%
           		}
           		}
          		%>
         <div id="button">
          	每页<%=page1.rowsPerPage%>行；共<%=page1.getMaxRowCount()%>行； 第<%=page1.getCurPage()%>页；共<%=page1.getMaxPage()%>页
         <%
         if(page1.getMaxPage()==0||page1.getMaxPage()==1){
         %>
         <%}
         else{
         if (page1.getCurPage() == 1) {
        	%> 
        	<a HREF="ShowBook.jsp?curPage=<%=page1.getCurPage()+1%>">下一页</A>
        	<a HREF="ShowBook.jsp?curPage=<%=page1.getMaxPage()%>">末页</A>
         <%}
 		 else if(page1.getCurPage() == page1.getMaxPage()) {
		%>
<a HREF="ShowBook.jsp?curPage=1">首页</A>
<a HREF="ShowBook.jsp?curPage=<%=page1.getCurPage()-1%>">上一页</A>
<%}
else{%>
<a HREF="ShowBook.jsp?curPage=1">首页</A>
<a HREF="ShowBook.jsp?curPage=<%=page1.getCurPage()-1%>">上一页</A>
<a HREF="ShowBook.jsp?curPage=<%=page1.getCurPage()+1%>">下一页</A>
<a HREF="ShowBook.jsp?curPage=<%=page1.getMaxPage()%>">末页</A>
<% }
}%>
         </div>
		 </div>
    </center>
</body>
</html>