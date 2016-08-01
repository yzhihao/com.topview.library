<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
     function judge(){
       var reg = new RegExp("^[0-9a-zA-Z]{3,10}$");
       var reg1 = new RegExp("^[a-zA-Z]{1}[0-9a-zA-Z]{5,14}$");
       var reg2 = new RegExp("^.*(\.jpg|\.gif|\.png)$");
       var obj = document.getElementById("username");
	    if(!reg.test(obj.value)){
	        alert("用户名只能是3-10位数字或字母!");
	        return false;
	    }
	    else {
	   		var obj1 = document.getElementById("password");
	    	if(!reg1.test(obj1.value)){
	    	alert("密码只能是6-15位数字或字母且必须由字母开头");
	    	return false;
	    	}
	    	else{
	    		var obj2 = document.getElementById("user_amg");
		    	if(!reg2.test(obj2.value)){
		    	alert("图片格式只能是.jpg或.gif或.png");
		    	return false;
	    		}
		    	else{
		    		var obj3 = document.getElementById("request");
		    		if(obj3.value==""){
				    	alert("密保问题不能为空");
				    	return false;
		    		}
			    	else{
				    		var obj4 = document.getElementById("answer");
				    		if(obj4.value==""){
						    	alert("密保答案不能为空");
						    	return false;
				    	}
		  			}
  				}
			}
		}	
     }	    
  </script>
</head>
<body>
<form action="servlet/RegisterUserServlet" name="regForm" method="post"  enctype="multipart/form-data" onsubmit="return judge()">
  <table  align="center" width="500" height="400">
  <tr><td colspan="2" align="center"><img src ="http://img.pintu360.com/other/20150331/208d39dd-0f4d-4ee6-9a83-2e8e2c09786a.jpg"height="300"></td></tr>
  <tr><td  align="right">用户名</td><td><input type="text" name="usre_name" id="username"/></td></tr>
  <tr><td  align="right">密码</td><td><input type="text" name="password" id="password"/></td></tr>
    <tr><td  align="right">密保问题：</td><td><input type="text" name="possword_request" id="request"/></td>  
  <tr><td  align="right">请输入答案：</td><td><input type="text" name="possword_right"  id="answer"/></td></tr>  
  <tr><td  align="right">上传图片</td><td><input type="file" name="user_amg" id="user_amg"/></td></tr>
  <tr><td  align="right"><input type="radio" value="普通用户" name="type" checked="checked" />普通用户</td>
  <td><input type="radio" value="管理员" name="type" />管理员</td></tr>
  <tr><td  align="right" ><input name="regForm" type="submit" value="提交"></td></tr>
  </table>
</form>
</body>
</html>