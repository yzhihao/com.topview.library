<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
	    	}
	    	else{
	    		var obj2 = document.getElementById("book_samem");
		    	if(!reg1.test(obj2.value)){
		    	alert("书的数量必须为1到10位整数!");
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
<form action="servlet/AddBookServlet" name="regForm" method="post" enctype="multipart/form-data"  onsubmit="return judge()" >
  <table  align="center" width="500" height="400">
  <tr><td colspan="2" align="center"><img src ="http://f1.diyitui.com/cf/01/c8/7b/74/66/0d/4a/d3/a3/86/3e/74/0b/ef/58.jpg"height="300"></td></tr>
  <tr><td  align="right">书名</td><td><input type="text" name="book_name" id="book_name"/></td></tr>
  <tr><td  align="right">作者</td><td><input type="text" name="book_writer" id="book_writer" /></td></tr>
  <tr><td  align="right">书的数量</td><td><input type="text" name="book_samem" id="book_samem"/></td></tr>
  <tr><td  align="right">上传图片</td><td><input type="file" name="book_amg" id="book_amg" /></td></tr>
  <tr><td  align="right" ><input name="regForm" type="submit" value="提交"></td></tr>
  </table>
</form>
</body>
</html>