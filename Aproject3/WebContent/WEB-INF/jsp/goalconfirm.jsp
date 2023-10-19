<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="model.Goal" %>

<%
Goal goal=(Goal)session.getAttribute("goal");
%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>確認画面</title>
	</head>
	<body>
		<h1>以下の内容で目標を設定しますか？</h1>
	
		<div class="contact-formbox">
				<dt>
					<p><%=goal.getGoalgenre1()%></p>
				</dt>
				<dd class="contact-1">
					<%=goal.getGoal1() %>
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p><%=goal.getGoalgenre2()%></p>
				</dt>
				<dd class="contact-1">
					<%=goal.getGoal2() %>
				</dd>
			</div>
			<div class="contact-formbox">
				<dt>
					<p><%=goal.getGoalgenre3()%></p>
				</dt>
				<dd class="contact-1">
					<%=goal.getGoal3() %>
				</dd>
			</div>
			<div id="btBox">
				<a href="/Aproject3/GoalconfirmServlet?mode=back" class="button2">戻る</a>
				<a href="/Aproject3/GoalconfirmServlet?mode=send" class="button2">送信</a>
			</div>
			<a href="/Aproject3/TopServlet">TOPへ</a>
	</body>
</html>