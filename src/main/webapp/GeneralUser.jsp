<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<table align="center" width="500" height="400">
<tbody>
<tr><td colspan="4" align="center">欢迎您，<%=session.getAttribute("username")%></td><td ><a href="Login.jsp">退出登录</a></td></tr>
<tr><td colspan="5"><img src ="http://game.funshion.com/cms/uploads/allimg/111118/3_111118144925_1.jpg"height="300"></td></tr>
<tr height="50"><td><a href="ShowBook.jsp?curPage=1">查看所有书籍</a></td><td ><a href="ShowCollectBook.jsp">收藏夹</a></td>
<td><a href="OneUserBorrowCondition.jsp?username=<%=(String)session.getAttribute("username")%>">借阅情况</a></td>
<td><a href="OneOldBorrowCondition.jsp?username=<%=(String)session.getAttribute("username")%>">借阅历史</a></td>
<td><a href="ApplyStates.jsp?username=<%=(String)session.getAttribute("username")%>">审核情况</a></td></tr>
<tr><td colspan="5" align="center">我就是我，为自己代言，不一样的烟火</td></tr>
</tbody>
</table>

</body>
</html>