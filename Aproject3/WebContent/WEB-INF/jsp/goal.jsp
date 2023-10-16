<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="model.Content" %>

<%
Content content=(Content)session.getAttribute("content");
String exercise=content==null? "":content.getExercise();
String meal=content==null? "":content.getMeal();
String sleep=content==null? "":content.getSleep();
%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>目標設定</title>
	</head>
	<body>
		<h1>目標設定</h1>
		<form action="/Aproject3/GoalconfirmServlet" method="post">
			<div class="contact-formbox">
				<dt>
					<p>運動</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="10文字以上" 
					name="exercise" value="<%=exercise%>" minlength="10" required>
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p>食事</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="10文字以上" 
					name="meal" value="<%=meal%>" minlength="10" required>
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p>睡眠</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="10文字以上" 
					name="sleep" value="<%=sleep%>" minlength="10" required>
				</dd>
			</div>
			<input type="submit" class="button"  value="確認">
		</form>
		<a href="/Aproject3/TopServlet">TOPへ</a>
	</body>
</html>