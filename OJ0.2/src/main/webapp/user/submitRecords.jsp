<%@ page import="com.otime.bean.*" %>
<%@ page import="com.otime.dao.*"%>
<%@ page import="com.otime.dao.impl.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
	<head>
		<%@ include file="../head.jsp" %>
	</head>

<body>
	<%@ include file="../nav.jsp" %>
	<div class="container" >
	<h1>你好，欢迎访问提交记录页面</h1>
	<table class="table">
		<tr>
			<th>提交Id</th>
			<th>用户Id</th>
			<th>用户昵称</th>
			<th>题目Id</th>
			<th>题目名称</th>
			<th>语言</th>
			<th>执行时间<th>
			<th>内存占用<th>
			<th>分数<th>
			<th>结果<th>
			<th style="width: 10%">日期<th>
			<th>评测详情<th>
		</tr>
		<c:forEach items="${submitRecords }" var="submitRecord">
			<tr>
				<td>${submitRecord.id }</td>
				<td>${submitRecord.user.id }</td>
				<td>${submitRecord.user.nickname }</td>
				<td>${submitRecord.problem.id }</td>
				<td>${submitRecord.problem.title }</td>
				<td>${submitRecord.contentType }</td>
				<td>${submitRecord.executionTime }ms<td>
				<td>${submitRecord.memoryCost }kb<td>
				<td>
					<font color='${submitRecord.score > 60 ? "green" : "red" }'>
						<b>${submitRecord.score }</b>
					</font>
				<td>
				<td>
					<font color='${submitRecord.score > 60 ? "green" : "red" }'>
						<b>${submitRecord.result }</b>
					</font>
				<td>
				<td style="width: 10%">${submitRecord.date }<td>
				<td><a href="user/submitRecord?submitRecordId=${submitRecord.id }">评测详情</a><td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>