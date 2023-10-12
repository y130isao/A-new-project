<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>確認画面</title>
	</head>
	<body>
		<h1>以下の内容で目標を設定しますか？</h1>
		
		<p><c:out ></p>
		
		<input type="submit" onclick="location.href='/Aproject3/GoalServlet'"  value="再選択">
		<input type="submit" onclick="location.href='/Aproject3/GoalServlet'"  value="OK">
		<a href="/Aproject3/TopServlet">TOPへ</a>
	</body>
</html>