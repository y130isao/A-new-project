<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="model.Content" %>

<%
Content content=(Content)session.getAttribute("content");
String exercise=content==null? "":content.getExercise();
String eat=content==null? "":content.getEat();
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
					<input type="text" placeholder="目標を記入してください" name="exercise" value="<%=exercise%>">
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p>食事</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="目標を記入してください" name="eat" value="<%=eat%>">
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p>睡眠</p>
					<span>必須</span>
				</dt>
				<dd class="contact-1">
					<input type="text" placeholder="目標を記入してください" name="sleep" value="<%=sleep%>">
				</dd>
			</div>
			<input type="submit" class="button"  value="確認">

		</form>
		<a href="/Sakaguchi/TopServlet">TOPへ</a>
	</body>
</html>