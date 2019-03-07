<%@page import="encapsulation.News"%>
<%@page import="java.util.List"%>
<%@page import="link.DataBase"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<style>
<!--
-->
</style>
<body>
	<table border="1">
		<tr>
			<td style="width: 100px; height: 50px; display: inline-block;">ID</td>
			<td style="width: 100px; height: 50px; display: inline-block;">标题</td>
			<td style="width: 1000px; height: 50px; overflow: hidden; display: inline-block;">内容</td>
		</tr>

		<%
			DataBase test = new DataBase();
			List<News> list = test.selectAll();
			for (News n : list) {
		%>
		<tr>
			<td style="width:100px; height: 20px; display: inline-block;"><%=n.getNid()%></td>
			<td style="width: 100px; height: 20px; display: inline-block;overflow: hidden;"><%=n.getNtitle()%></td>
			<td style="width: 1000px; height: 20px; overflow: hidden; display: inline-block;"><%=n.getNconcent()%></td>

		</tr>
		<%}%>
		
	</table>
	<button style="margin-left: 0px" onclick="did()">删除</button>
	<script>
		function did() {
			var id = prompt("请输入要删除的id：");
			location.href = "dele.jsp?id=" + id;
		}
	</script>
</body>
</html>