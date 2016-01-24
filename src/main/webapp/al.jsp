<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add link here</title>
</head>
<body>
<h1>添加链接</h1>
	<form method="post" action="linkadd">
		<label>标题</label>
		<input name="title">
		<br>
		<label>网址</label>
		<input name="url">
		<br>
		<label>分类id</label>
		<input type="number" name="topic">
		从下方的分类中找到对应的数字id
		<br>
		<input type="submit" value="提交">
	</form>
<h1>添加分类</h1>
	待完成
<h1>显示分类</h1>
<jsp:include page="/showtopic" />
</body>
</html>