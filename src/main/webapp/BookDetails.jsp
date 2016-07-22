<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetBookDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.yezhihao.www.dao.GetUserDao" %>
<%@page import="com.yezhihao.www.po.UserPo" %>
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
          <% 
          GetBookDao bookDao = new GetBookDao(); 
          BookPo book = bookDao.getBookById(Integer.parseInt(request.getParameter("id")));
             if(book!=null)
             {
          %>
          <td width="70%" valign="top">
             <table><tr><td rowspan="5"><img src="<%=request.getContextPath()%>/amg_lib/<%=book.getBook_amg()%>" width="120" height="130" border="1"/></td></tr>
               <tr><td>书名：<B><%=book.getBook_name() %></B></td> </tr>
               <tr><td>作者：<%=book.getBook_writer()%></td></tr>
               <tr><td>库存量：<%=book.getBook_samem()%>本</td></tr> 
               <tr><td> 可供借出:<%=book.getBook_margin() %>本</td></tr> 
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
				<tr><td><a href="servlet/ApplyBorrowBook?id=<%=book.getId()%>&Book_name=<%=book.getBook_name()%>&book_margin=<%=book.getBook_margin() %>">申请借阅</a></td></tr> 
                <tr><td><a href="servlet/CollectBookServlet?id=<%=book.getId()%>">加入收藏夹</a></td></tr>               
               <% }%>
             </table>
          </td>
          <% 
            }
          %>
                              <% 
              String list ="";
              //从客户端获得Cookies集合
              Cookie[] cookies = request.getCookies();
              //遍历这个Cookies集合
              if(cookies!=null&&cookies.length>0)
              {
	              for(Cookie c:cookies)
	              {
	                  if(c.getName().equals("ListViewCookie"))
	                  {
	                     list = c.getValue();
	                  }
	              }
	          }
              
              list+=request.getParameter("id")+",";
              //如果浏览记录超过1000条，清零.
              String[] arr = list.split(",");
              if(arr!=null&&arr.length>0)
              {
                  if(arr.length>=1000)
                  {
                      list="";
                  }
              }
              Cookie cookie = new Cookie("ListViewCookie",list);
              response.addCookie(cookie);
          
          %>
          <!-- 浏览过的商品 -->
          <td width="30%" bgcolor="#EEE" align="center">
             <br>
             <b><font color="#FF7F00">您浏览过的书籍</font></b><br>
             <!-- 循环开始 -->
             <% 
                ArrayList<BookPo> booklist = bookDao.getViewList(list);
                if(booklist!=null&&booklist.size()>0 )
                {
                   for(BookPo i:booklist)
                   {
                         
             %>
             <div>
             <dl>
               <dt>
				<a href="BookDetails.jsp?id=<%=i.getId()%>"><img src="<%=request.getContextPath()%>/amg_lib/<%=i.getBook_amg()%>" width="120" height="130" /></a>               </dt>
               <dd class="dd_name">书名：<%=i.getBook_name()%></dd> 
               <dd class="dd_seller">作者:<%=i.getBook_writer() %>&nbsp;&nbsp;余量:<%=i.getBook_margin() %> 本</dd> 
             </dl>
             </div>
             <% 
                   }
                }
             %>
             <!-- 循环结束 -->
          </td>
        </tr>
      </table>
    </center>
</body>
</html>