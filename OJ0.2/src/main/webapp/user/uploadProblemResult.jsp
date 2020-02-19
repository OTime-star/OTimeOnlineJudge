<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="../head.jsp" %>
	</head>
	
	<body>
		<%@ include file="../nav.jsp" %>
		<div class="container" >
			<h2>${msg }</h2>
			<h2><a href='#'>返回首页</a></h2>
			<h2><a href='user/uploadProblem.jsp'>继续上传</a></h2>
		</div>
	</body>
</html>