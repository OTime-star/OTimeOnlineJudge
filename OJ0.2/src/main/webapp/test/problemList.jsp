<%@ page import="com.otime.bean.*" %>
<%@ page import="com.otime.dao.*"%>
<%@ page import="com.otime.dao.impl.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 测试代码 -->
<% 
	ProblemDao problemDao = new ProblemDaoImpl();
	List<Problem> problemList = problemDao.getProblems();
	request.setAttribute("problemList", problemList); 
%>

<!DOCTYPE html>		
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>题库</title>
	</head>
	<body>
		
		<h1>你好，欢迎访问题库页面</h1>
		
		<table style="width: 100%">
			<tr>
				<th>Id</th>
				<th>题目</th>
				<th>已通过</th>
				<th>提交次数</th>
				<th>通过率</th>
				<th>状态<th>
			</tr>
			<c:forEach items="${problemList }" var="problem">
				<tr align="center">
					<td>Q${problem.id } </td>
					<td><a href='problem.jsp?problemId=${problem.id }'>${problem.title }</a></td>
					<td>${problem.acceptSubmissions }次 </td>
					<td>${problem.totalSubmissions }次 </td>
					<td>---</td>
					<td>未提交<td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>