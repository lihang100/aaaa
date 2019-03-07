
<%@page import="link.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String ID = request.getParameter("id");
		DataBase ba = new DataBase();
		int i = ba.deletee(Integer.parseInt(ID));
		if (i > 0) {
			out.print("<script>alert('删除成功');location.href='test.jsp'</script>");
		} else {
			out.print("<script>alert('删除失败');location.href='test.jsp'</script>");
		}
	%>>
</body>
</html>