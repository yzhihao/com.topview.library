<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetBorrowBookDao" %>
<%@page import="com.yezhihao.www.po.BorrowBookPo" %>
<%@page import="java.util.ArrayList" %>    
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.UserPo" %>
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
	   div dd.return
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
          <% 
          GetBorrowBookDao bookDao = new GetBorrowBookDao();
               ArrayList<BorrowBookPo> list =bookDao.getBorrowBookByUsername(1,request.getParameter("username"));
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	            	   BorrowBookPo applybook = list.get(i);
	            	   if(applybook.getAllow_borrow()==1){
           %>   
          <div id="onebook">
             <dl>
               <dt>
                 <img src="/upload/<%=applybook.getBook_amg()%>" width="120" height="130" />
               </dt>
               <dd class="name">书名：<%=applybook.getBook_name() %></dd> 
               <dd class="username">借书用户:<%=applybook.getUser_name()%></dd>
               <dd class="date">审核时间:<%=applybook.getBorrow_date()%></dd>
               <dd class="date">应还时间:<%=applybook.getReturn_date()%></dd>
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
               if(ret==1){
          %>
			 <dd class="return"><a href="servlet/ReturnBookServlet?book_id=<%=applybook.getBook_id()%>&username=<%=applybook.getUser_name()%>&borrowbookid=<%=applybook.getBorrow_bookid() %>">还书</a></dd>
		  <% 
		  		}
		  %>
             </dl>
          </div>
          <%
	        }
            }
           	} 
          %>
           
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
               if(ret==1){
           %>
                <a href="GeneralUser.jsp">返回主界面</a><br>
			<%
				}else{
			%>
          		<a href="Administrator.jsp">返回主界面</a><br>
		   <% 
		  		 }
		   %>
	</div>
    </center>


</body>
</html>