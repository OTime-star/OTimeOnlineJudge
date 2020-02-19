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
			<form action="user/uploadProblem" method="post">
				<p>题目名称: <input type="text" value="A + B" name="title" /></p>
				题目描述：<textarea rows="10" cols="180" name="description">Calculate a+b
				</textarea><br>
				输入格式：<textarea rows="4" cols="180" name="inputFormat">Two integer a,b (0&lt;=a,b&lt;=10)
				</textarea><br>
				输出格式：<textarea rows="4" cols="180" name="outputFormat">Output a+b
				</textarea><br>
				<p>时间限制: <input type="text" value="1000" name="timeLimit" /></p>
				<p>空间限制: <input type="text" value="64" name="memoryLimit" /></p>
		
				样例数据1:<br>
				输入：<br><textarea rows="4" cols="90" name="sampleJudgeData1In">1 2</textarea><br>
				输出：<br><textarea rows="4" cols="90" name="sampleJudgeData1Out">3</textarea><br>
		
				样例数据2:<br>
				输入：<br><textarea rows="4" cols="90" name="sampleJudgeData2In">5555 4444</textarea><br>
				输出：<br><textarea rows="4" cols="90" name="sampleJudgeData2Out">9999</textarea><br>
		
				测试数据点1:<br>
				输入：<br><textarea rows="4" cols="90" name="actualJudgeData1In">1 2</textarea><br>
				输出：<br><textarea rows="4" cols="90" name="actualJudgeData1Out">3</textarea><br>
		
				测试数据点2:<br>
				输入：<br><textarea rows="4" cols="90" name="actualJudgeData2In">90 100</textarea><br>
				输出：<br><textarea rows="4" cols="90" name="actualJudgeData2Out">190</textarea><br>
		
				测试数据点3:<br>
				输入：<br><textarea rows="4" cols="90" name="actualJudgeData3In">5555 4444</textarea><br>
				输出：<br><textarea rows="4" cols="90" name="actualJudgeData3Out">9999</textarea><br>
		
				测试数据点4:<br>
				输入：<br><textarea rows="4" cols="90" name="actualJudgeData4In"></textarea><br>
				输出：<br><textarea rows="4" cols="90" name="actualJudgeData4Out"></textarea><br>
		
				测试数据点5:<br>
				输入：<br><textarea rows="4" cols="90" name="actualJudgeData5In"></textarea><br>
				输出：<br><textarea rows="4" cols="90" name="actualJudgeData5Out"></textarea><br>
		
				测试数据点6:<br>
				输入：<br><textarea rows="4" cols="90" name="actualJudgeData6In"></textarea><br>
				输出：<br><textarea rows="4" cols="90" name="actualJudgeData6Out"></textarea><br>
		
				<input type="submit" value="Submit" />
			</form>
		</div>
	</body>
</html>