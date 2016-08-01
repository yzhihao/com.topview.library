<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收藏成功</title>
</head>
<body>
<table  align="center" width="500" height="400">
	<c:if  test="${a==ture}">
		<tr><td colspan="2" align="center"><h1>收藏成功</h1></td></tr>
		<tr><td colspan="2" align="center"><img src ="http://img2.imgtn.bdimg.com/it/u=2950404534,428330732&fm=21&gp=0.jpg"height="300"></td></tr>
	</c:if>

	<c:if  test="${a!=ture}">
		<tr><td colspan="2" align="center"><h1>收藏失败，该书已在您的收藏夹中</h1></td></tr>
		<tr><td colspan="2" align="center"><img src ="http://img3.imgtn.bdimg.com/it/u=497949684,4081026349&fm=21&gp=0.jpg"height="300"></td></tr>
	</c:if>
  
	<tr><td  ><a href="ShowCollectBook.jsp">查看收藏夹</a></td></tr>
	<tr><td  ><a href="GeneralUser.jsp">返回主界面</a></td></tr>
</table>
</body>
</html>