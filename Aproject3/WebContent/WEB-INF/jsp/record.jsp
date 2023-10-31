<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Goal"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<%
List<model.Goal> goalList = (List<model.Goal>) session.getAttribute("goalList");
%>

<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>

<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YY年MM月dd日");
String today = sdf.format(date);
%>

<%
Record record=(Record)session.getAttribute("record");
boolean goalgenre1=record==null? "":goal.getGoalgenre1();
boolean goalgenre2=record==null? "":goal.getGoalgenre2();
boolean goalgenre3=record==null? "":goal.getGoalgenre3();
String goal1=record==null? "":goal.getGoal1();
String goal2=record==null? "":goal.getGoal2();
String goal3=record==null? "":goal.getGoal3();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本日の記録</title>
</head>
<body>
	<h1>本日の記録</h1>
	<h2><%=sdf.format(date)%></h2>
	<form action="/Aproject3/RecordCheck" method="post">


		<%-- ☆修正必要☆ --%>
		<h3>あなたの選択項目1</h3>
		<p><%=goalList.get(0).getGoalgenre1()%></p>
		<%=goalList.get(0).getGoal1()%>

		<%-- radioの値を渡す --%>
		<select name="do_result1" value="<%=do_result1%>" required>
			<option value="">選択してください</option>
			<option value="出来た">出来た</option>
			<option value="出来なかった">出来なかった</option>
		</select>
		<%-- textboxの値を渡す --%>
		<div class memo>
			メモ<br> <input type="text" name="memo_list1" placeholder="10文字以上"
				minlength="10" value="<%=memo_list1%>" required><br>
		</div>

		<%-- ☆修正必要☆ --%>
		<h3>あなたの選択項目2</h3>
		<p><%=goalList.get(0).getGoalgenre2()%></p>
		<%=goalList.get(0).getGoal2()%>

		<%-- radioの値を渡す --%>
		<select name="do_result2" value="<%=do_result2%>" required>
			<option value="">選択してください</option>
			<option value="出来た">出来た</option>
			<option value="出来なかった">出来なかった</option>
		</select>

		<%-- textboxの値を渡す --%>
		<div class memo>
			メモ<br> <input type="text" name="memo_list2" placeholder="10文字以上"
				minlength="10" value="<%=memo_list2%>" required><br>
		</div>

		<%-- ☆修正必要☆ --%>
		<h3>あなたの選択項目3</h3>
		<p><%=goalList.get(0).getGoalgenre3()%></p>
		<%=goalList.get(0).getGoal3()%>

		<%-- radioの値を渡す --%>
		<select name="do_result3" value="<%=do_result3%>" required>
			<option value="">選択してください</option>
			<option value="出来た">出来た</option>
			<option value="出来なかった">出来なかった</option>
		</select>

		<%-- textboxの値を渡す --%>
		<div class memo>
			メモ<br> <input type="text" name="memo_list3" placeholder="10文字以上"
				minlength="10" value="<%=memo_list3%>" required><br>
		</div>

		<input type="submit" value="記録確認・登録画面へ" /><br>
	</form>

	<a href="/Aproject3/TopServlet">TOPへ</a>
</body>
</html>