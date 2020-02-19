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
	<h1>提交记录</h1>
	<table class="table" >
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
		</tr>
		<tr>
			<td>${submitRecord.id }</td>
			<td>${submitRecord.user.id }</td>
			<td>${submitRecord.user.nickname }</td>
			<td>${submitRecord.problem.id }</td>
			<td>${submitRecord.problem.title }</td>
			<td>${submitRecord.contentType }</td>
			<td>${submitRecord.executionTime }ms<td>
			<td>${submitRecord.memoryCost }kb<td>
			<td>${submitRecord.score }<td>
			<td>${submitRecord.result }<td>
			<td style="width: 10%">${submitRecord.date }<td>
		</tr>
	</table>
	
	<h1>评测记录</h1>
	<table class="table">
		<tr>
			<th>测试点</th>
			<th>评测Id</th>
			<th>提交Id</th>
			<th>执行时间</th>
			<th>内存占用</th>
			<th>评测结果</th>
		</tr>
		<c:forEach items="${submitRecord.judgeRecordList }" var="judgeRecord" varStatus="status">
			<tr>
				<td>测试点 ${status.index + 1 }</td>
				<td>${judgeRecord.id }</td>
				<td>${judgeRecord.submitRecordId }</td>
				<td>${judgeRecord.executionTime }ms</td>
				<td>${judgeRecord.memoryCost }kb</td>
				<td>${judgeRecord.result }</td>
			</tr>
		</c:forEach>
	</table>
	
	<h1>代码</h1>
	
	<pre><script type='text/plain' style='display:block'>${submitRecord.content }</script></pre>

	</div>
	
</body>
</html>