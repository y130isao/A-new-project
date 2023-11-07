<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Goal"%>
<%@ page import="model.Record"%>
<%-- "goalList" を取得 --%>
<%
List<model.Goal> goalList = (List<model.Goal>) session.getAttribute("goalList");
%>
<%-- "recordList" を取得 --%>
<%
List<model.Record> recordList = (List<model.Record>) session.getAttribute("recordList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>過去の記録</title>
</head>
<body>
	<div class="calrecord1">
		<div class genre>	
			目標ジャンル1【<%= goalList.get(0).getGoalgenre1() %>】</br>
		</div>
		<div class="goal">
			目標【<%= goalList.get(0).getGoal1() %>】</br>
		</div>
		<div class="result">
			結果【<%=recordList.get(0).getDo_result1()%>】</br>
		</div>
		<div class="memo">
			メモ【<%=recordList.get(0).getMemo_list1()%>】</br>
		</div>
	</div>
	<div class="calrecord2">
		<div class genre>	
			目標ジャンル2【<%= goalList.get(0).getGoalgenre2() %>】</br>
		</div>
		<div class="goal">
			目標【<%= goalList.get(0).getGoal2() %>】</br>
		</div>
		<div class="result">
			結果【<%=recordList.get(0).getDo_result2()%>】</br>
		</div>
		<div class="memo">
			メモ【<%=recordList.get(0).getMemo_list2()%>】</br>
		</div>
	</div>
	<div class="calrecord3">
		<div class genre>	
			目標ジャンル3【<%= goalList.get(0).getGoalgenre3() %>】</br>
		</div>
		<div class="goal">
			目標【<%= goalList.get(0).getGoal3() %>】</br>
		</div>
		<div class="result">
			結果【<%=recordList.get(0).getDo_result3()%>】</br>
		</div>
		<div class="memo">
			メモ【<%=recordList.get(0).getMemo_list3()%>】</br>
		</div>
	</div>
</body>
</html>