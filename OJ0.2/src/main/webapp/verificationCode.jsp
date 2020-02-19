<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@ include file="head.jsp" %>
		<link href="css/signin.css" rel="stylesheet">
	</head>
	<body>
		<%@ include file="nav.jsp" %>
		<div class="container">
		<c:if test="${! empty errorMsg }">
			<h2>${errorMsg }</h2>
		</c:if>
		<h2>请输入邮箱中收到的验证码</h2>
		<form action="verificationCodeConfirm" method="post">
			<input type="text" name="verificationCode">
			<input type="submit" value="确认">
		</form>
		</div>
	</body>
</html>