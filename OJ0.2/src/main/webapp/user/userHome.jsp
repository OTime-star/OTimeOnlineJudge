<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="../head.jsp" %>
	</head>
		
	<body>
		<%@ include file="../nav.jsp" %>
		<div class="container">
			<h2>通过的题目</h2>
			<table class="table" >
				<thead>
					<tr>
						<th>Id</th>
						<th>题目</th>
						<th>提交记录</th>
						<th>日期</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${passProblemSovleStateList }" var="problemSolveState">
					<tr>
						<td>Q${problemSolveState.problem.id } </td>
						<td><a href='user/problem?problemId=${problemSolveState.problem.id }'>${problemSolveState.problem.title }</a></td>
						<td><a href='user/submitRecord?submitRecordId=${problemSolveState.submitRecordId }'>提交记录</a></td>
						<td>${problemSolveState.date }</td>
						<td>${problemSolveState.state }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<h2>尝试过的题目</h2>
			<table class="table" >
				<thead>
					<tr>
						<th>Id</th>
						<th>题目</th>
						<th>提交记录</th>
						<th>日期</th>
						<th>状态</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${notpassProblemSovleStateList }" var="problemSolveState">
					<tr>
						<td>Q${problemSolveState.problem.id } </td>
						<td><a href='user/problem?problemId=${problemSolveState.problem.id }'>${problemSolveState.problem.title }</a></td>
						<td><a href='user/submitRecord?submitRecordId=${problemSolveState.submitRecordId }'>提交记录</a></td>
						<td>${problemSolveState.date }</td>
						<td>${problemSolveState.state }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>