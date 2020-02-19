<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>题目P${problem.id}</title>
</head>
<body>

<h2>P${problem.id}</h2>
<h2>题目名称：${problem.title}</h2>
<%Problem problem = (Problem)request.getAttribute("problem"); %>
<h4>题目描述：</h4>
	<p><%=problem.getDescription() %></p>
<h4>输入格式：</h4>
	<p><%=problem.getInputFormat() %></p>
<h4>输出格式：</h4>
	<p><%=problem.getOutputFormat() %></p>
	
<%for(JudgeData data : problem.getSampleData()){ %>
	<h4>样例输入：</h4>
		<p><%=data.getInputData() %></p>
	<h4>样例输出：</h4>
		<p><%=data.getOuputData() %></p>
<% } %>

<form action="/OJ0.1/codeSubmit" method="post" id="codeform">
  	<p>题目Id: <input type="text" value="${problem.id }" name="problemId" /></p>
  	<textarea rows="28" cols="180" name="code">
		请在此处输入代码...
	</textarea>
  	
	<input type="submit" value="submit">
</form>

<br>

</body>
</html>