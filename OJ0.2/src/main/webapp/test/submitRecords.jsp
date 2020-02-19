<%@ page import="com.otime.bean.*" %>
<%@ page import="com.otime.dao.*"%>
<%@ page import="com.otime.dao.impl.*"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	SubmitRecordDao submitRecordDao = new SubmitRecordDaoImpl();
	List<SubmitRecord> submitRecords =submitRecordDao.getSubmitRecords();
	request.setAttribute("submitRecords", submitRecords);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提交记录</title>
</head>
<body>
	<h1>你好，欢迎访问提交记录页面</h1>
	<table style="width: 100%">
		<!-- 
		private Integer id;
		private User user;
		private Problem problem;
		private String contentType;
		private String content;
		private Integer executionTime;
		private Integer memoryCost;
		private Integer score;
		private String result;
		private Date date;
		private List<JudgeRecord> judgeRecordList; 
		-->
		<tr>
			<th>提交Id</th>
			<th>用户Id</th>
			<th>用户昵称</th>
			<th>题目Id</th>
			<th>题目名称</th>
			<th>语言</th>
			<th>代码<th>
			<th>执行时间<th>
			<th>内存占用<th>
			<th>分数<th>
			<th>结果<th>
			<th>日期<th>
			<th>评测记录<th>
		</tr>
		<c:forEach items="${submitRecords }" var="submitRecord">
			<tr align="center">
				<td>${submitRecord.id }提交Id</td>
				<td>${submitRecord.user.id }用户Id</td>
				<td>${submitRecord.user.nickname }用户昵称</td>
				<td>${submitRecord.problem.id }题目Id</td>
				<td>${submitRecord.problem.title }题目名称</td>
				<td>${submitRecord.contentType }语言</td>
				<td>${submitRecord.content }代码<td>
				<td>${submitRecord.executionTime }执行时间<td>
				<td>${submitRecord.memoryCost }内存占用<td>
				<td>${submitRecord.score }分数<td>
				<td>${submitRecord.result }结果<td>
				<td>${submitRecord.date }日期<td>
				<td><a href="/onlineJudge/test/judgeRecords.jsp?submitRecordId='${submitRecord.id }'">评测记录</a><td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>