<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>

<table align="center" width="500" height="400">
<tbody>
<tr><td colspan="4" align="center">欢迎您，管理员${user1.usre_name}</td><td ><a href="Login.jsp">退出登录</a></td></tr>
<tr><td colspan="5"><img src ="http://pic.58pic.com/58pic/17/78/26/12N58PICKcf_1024.jpg"height="400"></td></tr>
<tr><td><a href="ShowBook?curPage=1">查看所有书籍</a></td><td height="25"><a href="${ pageContext.request.contextPath }/AddBook.jsp">增加图书</a></td><td height="25"><a href="AllowBorrow">审核申请图书</a></td>
<td><a href="ShowAllBorrowedBook">借阅详情</a></td><td><a href="ShowUser">用户详情</a></td></tr>
<tr><td colspan="3" align="center">我就是我，为自己代言，不一样的烟火</td></tr>
</tbody>
</table>
</body>
</html>