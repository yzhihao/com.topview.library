<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetBorrowBookDao" %>
<%@page import="com.yezhihao.www.po.BorrowBookPo" %>
<%@page import="java.util.ArrayList" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审核</title>

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

    <h1>申请图书展示</h1>
    <hr>
    <center>
	<div id="center">
          <% 
          GetBorrowBookDao bookDao = new GetBorrowBookDao(); 
               ArrayList<BorrowBookPo> list =bookDao.getApplyBook();
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	            	   BorrowBookPo applybook = list.get(i);
           %>   
          <div id="onebook">
             <dl>
               <dt>
                 <a href="AllowBookDetails.jsp?id=<%=applybook.getBook_id()%>&user_name=<%=applybook.getUser_name()%>"><img src="<%=request.getContextPath()%>/amg_lib/<%=applybook.getBook_amg()%>" width="120" height="130" /></a>
               </dt>
               <dd class="name">书名：<%=applybook.getBook_name() %></dd> 
               <dd class="username">申请人：<%=applybook.getUser_name() %></dd>
               <dd class="date">申请时间:<%=applybook.getBorrow_date()%></dd>
             </dl>
          </div>
          <%
            }
           	} 
          %>
          <a href="Administrator.jsp">返回主界面</a><br>
	</div>
    </center>

</body>
</html>