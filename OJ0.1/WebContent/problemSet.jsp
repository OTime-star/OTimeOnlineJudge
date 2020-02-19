<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.*"%>
<%@page import="entity.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>题库</title>
</head>
<body>
你好，欢迎访问题库页面<br>

<% Vector<Problem> problemSet = (Vector<Problem>)request.getAttribute("problemSet"); %>
<% for(Problem problem : problemSet){ %>
	<%String a = "<a href=\"\\OJ0.1\\problemDetail?problemId=" + problem.getId() + "\">";%>
	<%=a %>
	<%=problem.getId() %> <%=problem.getTitle() %></a><br>
		
<% } %>
</body>
</html>