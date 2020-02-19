<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.*"%>
<%@page import="entity.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Code Run Result</title>
</head>
<body>
	<h2>Run Result</h2>
	<% Vector<String> resultVec = (Vector<String>)request.getAttribute("resultVec"); %>

	<% for(int i = 0; i < resultVec.size(); i++) { %>
		测试点<%=i+1 %>: <%=resultVec.get(i) %> <br>
	<% } %>
</body>
</html>