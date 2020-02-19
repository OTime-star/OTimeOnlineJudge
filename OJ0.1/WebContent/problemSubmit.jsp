<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

你好，欢迎访问题目提交页面
<form action="/OJ0.1/problemSubmit" method="post">
	<div style="width: 100%">
		<p>题目名称: <input type="text" value="A + B" name="title" /></p>
		题目描述：<textarea rows="10" cols="180" name="description">Calculate a+b
		</textarea><br>
		输入格式：<textarea rows="4" cols="180" name="inputFormat">Two integer a,b (0<=a,b<=10)
		</textarea><br>
		输出格式：<textarea rows="4" cols="180" name="outputFormat">Output a+b
		</textarea><br>
		<p>时间限制: <input type="text" value="1000" name="timeLimit" /></p>
		<p>空间限制: <input type="text" value="64" name="memoryLimit" /></p>

		样例数据1:<br>
		输入：<br><textarea rows="4" cols="90" name="sampleData1In">1 2</textarea><br>
		输出：<br><textarea rows="4" cols="90" name="sampleData1Out">3</textarea><br>

		样例数据2:<br>
		输入：<br><textarea rows="4" cols="90" name="sampleData2In">5555 4444</textarea><br>
		输出：<br><textarea rows="4" cols="90" name="sampleData2Out">9999</textarea><br>

		测试数据点1:<br>
		输入：<br><textarea rows="4" cols="90" name="testData1In">1 2</textarea><br>
		输出：<br><textarea rows="4" cols="90" name="testData1Out">3</textarea><br>

		测试数据点2:<br>
		输入：<br><textarea rows="4" cols="90" name="testData2In">90 100</textarea><br>
		输出：<br><textarea rows="4" cols="90" name="testData2Out">190</textarea><br>

		测试数据点3:<br>
		输入：<br><textarea rows="4" cols="90" name="testData3In">5555 4444</textarea><br>
		输出：<br><textarea rows="4" cols="90" name="testData3Out">9999</textarea><br>

		测试数据点4:<br>
		输入：<br><textarea rows="4" cols="90" name="testData4In"></textarea><br>
		输出：<br><textarea rows="4" cols="90" name="testData4Out"></textarea><br>

		测试数据点5:<br>
		输入：<br><textarea rows="4" cols="90" name="testData5In"></textarea><br>
		输出：<br><textarea rows="4" cols="90" name="testData5Out"></textarea><br>

		测试数据点6:<br>
		输入：<br><textarea rows="4" cols="90" name="testData6In"></textarea><br>
		输出：<br><textarea rows="4" cols="90" name="testData6Out"></textarea><br>

		<input type="submit" value="Submit" />
	</div>
</form>

</body>
</html>