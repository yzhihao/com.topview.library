<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.yezhihao.www.dao.GetBookDao" %>
<%@page import="com.yezhihao.www.po.BookPo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书上架</title>
<script type="text/javascript">
     function judge(){
       var reg = new RegExp("^.{1,15}$");
       var reg1 = new RegExp("^[0-9]{1,10}$");
       var reg2 = new RegExp("^.*(\.jpg|\.gif|\.png)$");
       var reg4 = new RegExp("^[0-9]{1,10}$");
       var obj = document.getElementById("book_name");
	    if(!reg.test(obj.value)){
	        alert("书名长度必须在1到15个字符间!");
	        return false;
	    }
	    else {
	   		var obj1 = document.getElementById("book_writer");
	    	if(!reg.test(obj1.value)){
	    	alert("作者长度必须在1到15个字符间!");
	    	return false;
	    	}else {
		   		var obj2 = document.getElementById("book_num");
		    	if(!reg4.test(obj2.value)){
		    	alert("书的增加数量一定为1到10的正整数或0!");
		    	return false;
		    	}
	    	else{
		    		var obj3 = document.getElementById("book_amg");
			    	if(!reg2.test(obj3.value)){
			    	alert("图片格式只能是.jpg或.gif或.png");
			    	return false;
		    		}
		    	}
	    	}
	    	
	    }
	}
  </script>
</head>
<body>
  <%  	  GetBookDao bookDao = new GetBookDao(); 
          BookPo book = bookDao.getBookById(Integer.parseInt(request.getParameter("book_id")));
             if(book!=null)
             {
          %>
<form action="servlet/UpdateBookServlet" name="regForm" method="post" enctype="multipart/form-data"  onsubmit="return judge()" >
 <table align="center" width="500" height="300">
 <tr><td><img src="<%=request.getContextPath()%>/amg_lib/<%=book.getBook_amg()%>" width="200" height="200"/></td></tr>
  <tr><td><input type="hidden"  name="ID" value="<%=book.getId()%>"></td></tr>
  <tr><td  align="right">书名</td><td><input type="text" value="<%=book.getBook_name() %>" name="book_name" id="book_name"/></td></tr>
  <tr><td  align="right">作者</td><td><input type="text" name="book_writer"  value="<%=book.getBook_writer()%>" id="book_writer" /></td></tr>
  <tr><td  align="right">增加书本数量</td><td><input type="text" name="book_num" id="book_num" /></td></tr>
  <tr><td  align="right">上传图片</td><td><input type="file" name="book_amg" id="book_amg" /></td></tr>
  <tr><td  align="right" ><input name="regForm" type="submit" value="提交"></td></tr>
  </table>
</form>
<% }%>
</body>
</html>