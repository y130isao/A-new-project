<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>目標設定</title>
	</head>
	<body>
		<h1>目標設定</h1>
		<form action="/Sakaguchi/GoalServret" method="post">
			<div class="contact-formbox">
				<dt>
					<p>運動</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="目標を記入してください">
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p>食事</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="目標を記入してください">
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p>睡眠</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="目標を記入してください">
				</dd>
			</div>
			<input type="button" onclick="location.href='/Aproject3/GoalconfirmSevlet'"  value="送信">
		</form>
		<a href="/Aproject3/TopServlet">TOPへ</a>
	</body>
</html>