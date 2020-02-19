<%@ page import="com.otime.bean.*" %>
<%@ page import="com.otime.dao.*"%>
<%@ page import="com.otime.dao.impl.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>		
<html>
	<head>
		<%@ include file="head.jsp" %>
	</head>
	
	<body>
	<%@ include file="nav.jsp" %>
	<div class="container">
		<h1>你好，欢迎访问题库页面</h1>
		
		<table class="table" >
			<thead>
				<tr>
					<th>Id</th>
					<th>题目</th>
					<th>已通过</th>
					<th>提交次数</th>
					<th>通过率</th>
					<th>状态<th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${problemSolveStateList }" var="problemSolveState">
				<tr>
					<td>Q${problemSolveState.problem.id } </td>
					<td><a href='user/problem?problemId=${problemSolveState.problem.id }'>${problemSolveState.problem.title }</a></td>
					<td>${problemSolveState.problem.acceptSubmissions }次 </td>
					<td>${problemSolveState.problem.totalSubmissions }次 </td>
					<td>${problemSolveState.problem.acceptRate }%</td>
					<td>${problemSolveState.state }<td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	</body>
</html>