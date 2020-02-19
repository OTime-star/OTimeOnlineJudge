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
			<!-- <script type="text/javascript">alert(errorMsg)</script> -->
		</c:if>
		<form class="form-signin" method="post" action="userLogin">
			<h2 class="form-signin-heading">请登录</h2>
			<label for="inputEmail" class="sr-only">邮箱</label> 
			<input type="email" id="inputEmail" class="form-control" name="email" placeholder="邮箱" required autofocus> 
			
			<label for="inputPassword" class="sr-only">密码</label> 
			<input type="password" id="inputPassword" class="form-control" name="password" placeholder="密码" required>

			<button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
		</form>
		</div>
	</body>
</html>