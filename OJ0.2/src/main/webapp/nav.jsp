<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Fixed navbar -->
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
  <!--     <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button> -->
      <a class="navbar-brand" href="#">OTime OJ</a>
    </div>
    
    <div id="navbar" class="navbar-collapse collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="problemList">题库</a></li>
        <li><a href="user/submitRecords">提交记录</a></li>
		<li><a href="#contact">平台使用说明</a></li>
      	<li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">更多 <span class="caret"></span></a>
          <ul class="dropdown-menu">
			<c:choose>
		      	<c:when test="${not empty user }">
		            <li><a href="user/problemSet">已加入的题目集</a></li>
		            <li><a href="user/joinProblemSet">加入题目集</a></li>
			        <li><a href="user/createProblemSet">创建题目集</a></li>
		            <li><a href="user/uploadProblem.jsp">上传题目</a></li>
		        </c:when>
		      	<c:otherwise>  
			        <li class="dropdown-header">请登录后查看</li>
		        </c:otherwise>
        	</c:choose>
          </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<c:choose>
	      	<c:when test="${not empty user }">
		      	<li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${user.nickname } <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="user/userHome">个人中心</a></li>
		            <li><a href="#">账号设置</a></li>
		            <li role="separator" class="divider"></li>
		            <li><a href="user/logout">注销</a></li>
		          </ul>
		        </li>
	        </c:when>
	      	<c:otherwise>  
		        <li><a href="signin.jsp">注册</a></li>
		        <li class="active"><a href="login.jsp">登录</a></li>
	        </c:otherwise>
        </c:choose>
      </ul>
    </div><!--/.nav-collapse -->
  </div>
</nav>