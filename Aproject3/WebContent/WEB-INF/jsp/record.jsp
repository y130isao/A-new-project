<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Record"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Goal"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>

<%
List<model.Goal> goalList = (List<model.Goal>) session.getAttribute("goalList");
%>

<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YY年MM月dd日");
String today = sdf.format(date);
%>

<%
Record record = (Record) session.getAttribute("record");
boolean do_result1 = record != null && record.getDo_result1();
boolean do_result2 = record != null && record.getDo_result2();
boolean do_result3 = record != null && record.getDo_result3();
String memo_list1 = record == null ? "" : record.getMemo_list1();
String memo_list2 = record == null ? "" : record.getMemo_list2();
String memo_list3 = record == null ? "" : record.getMemo_list3();
%>

<link rel="stylesheet" type="text/css" href="/Aproject3/css/record.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=BIZ+UDGothic&display=swap')
	;
</style>
<title>本日の記録</title>
</head>
<body>
	<header> 健康管理アプリ </header>
	<h1>本日の記録</h1>
	<h2>
		<%=sdf.format(date)%>
	</h2>
	<form action="/Aproject3/RecordCheck" method="post">

		<div class="kiroku1">
			<h3>あなたの選択項目1</h3>
			【<%=goalList.get(0).getGoalgenre1()%>】</br>
			<%=goalList.get(0).getGoal1()%></br> <input type="radio"
				name="do_result1" value="1" <%=do_result1 ? "checked" : ""%>>出来た
			<input type="radio" name="do_result1" value="0"
				<%=!do_result1 ? "checked" : ""%>>出来てない


			<div>
				メモ<br> <input type="text" name="memo_list1"
					placeholder="10文字以上" minlength="10" value="<%=memo_list1%>"
					required><br>
			</div>
		</div>

		<div class="kiroku2">
			<h3>あなたの選択項目2</h3>
			【<%=goalList.get(0).getGoalgenre2()%>】</br>
			<%=goalList.get(0).getGoal2()%></br> <input type="radio"
				name="do_result2" value="1" <%=do_result2 ? "checked" : ""%>>出来た
			<input type="radio" name="do_result2" value="0"
				<%=!do_result2 ? "checked" : ""%>>出来てない

			<div>
				メモ<br> <input type="text" name="memo_list2"
					placeholder="10文字以上" minlength="10" value="<%=memo_list2%>"
					required><br>
			</div>
		</div>
		<div class="kiroku3">

			<h3>あなたの選択項目3</h3>
			【<%=goalList.get(0).getGoalgenre3()%>】</br>
			<%=goalList.get(0).getGoal3()%></br> <input type="radio"
				name="do_result3" value="1" <%=do_result3 ? "checked" : ""%>>出来た
			<input type="radio" name="do_result3" value="0"
				<%=!do_result3 ? "checked" : ""%>>出来てない

			<div>
				メモ<br> <input type="text" name="memo_list3"
					placeholder="10文字以上" minlength="10" value="<%=memo_list3%>"
					required><br>
			</div>
		</div>
		<div class="btn">
			<input type="submit" value="送信" />
		</div>
	</form>
	<footer>
		<a href="/Aproject3/TopServlet">TOPへ</a>
	</footer>
</body>
</html>