<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>目標設定</title>
	</head>
	<body>
		<h1>目標設定</h1>
		<form action="/Aproject3/GoalServret" method="post">
			<select name="goal">
				<option value="">▼選択してください</option>
				<option>運動</option>
				<option>食事</option>
				<option>睡眠</option>
			</select>
			<input type="button"  value="確認する">
		</form>
		<a href="/Aproject3/TopServlet">TOPへ</a>
	</body>
</html>