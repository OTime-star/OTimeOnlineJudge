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
		<%@ include file="../head.jsp" %>
	</head>
	
	<body>
		<%@ include file="../nav.jsp" %>
		<div class="container">
		<h2>Q${problem.id}</h2>
		<h2>题目名称：${problem.title}</h2>
		<h4>题目描述：</h4>
			<p>${problem.description }</p>
		<h4>输入格式：</h4>
			<p>${problem.inputFormat }</p>
		<h4>输出格式：</h4>
			<p>${problem.outputFormat }</p>
			
		<c:forEach items="${problem.sampleJudgeDataList }" var="judgeData">
			<h4>样例输入：</h4>
				<p>${judgeData.inputData }</p>
			<h4>样例输出：</h4>
				<p>${judgeData.resultData }</p>
		</c:forEach>
		
		<form action="user/contentSubmit" method="post">
			<p>语言:
			<select name="contentType" class="form-control">
				<option value="JAVA">JAVA</option>
				<option value="C++">C++</option>
			</select>
		  	<input type="hidden" value="${problem.id }" name="problemId">
		  	
		  	<textarea rows="28" cols="180" name="content">
				请在此处输入代码...
			</textarea>
		  	
			<input type="submit" value="submit">
		</form>
		
		<br>
		</div>
	</body>
</html>