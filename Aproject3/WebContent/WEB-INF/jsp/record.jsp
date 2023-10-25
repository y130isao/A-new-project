<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.Goal" %>

<%
Goal goal = (Goal) session.getAttribute("goal");
String goalgenre1 = goal != null ? goal.getGoalgenre1() : "";
String goalgenre2 = goal != null ? goal.getGoalgenre2() : "";
String goalgenre3 = goal != null ? goal.getGoalgenre3() : "";
String goal1 = goal != null ? goal.getGoal1() : "";
String goal2 = goal != null ? goal.getGoal2() : "";
String goal3 = goal != null ? goal.getGoal3() : "";
%> 

<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>


<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YY年MM月dd日");
String today = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本日の記録</title>
</head>
<body>
<h1>本日の記録</h1>
<h2><%= sdf.format(date) %></h2>
<form action="/Aproject3/RecordCheck" method="post">
<%-- ☆修正必要☆ --%>
<h3>あなたの選択項目1</h3>
<p><%= recordServlet.getGoalgenre1() %></p>
 <%= recordServlet.getGoal1() %>

<%-- radioの値を渡す --%>
<div class result>
<input type="radio" name="do_result1" value="出来た" required>出来た<br>
<input type="radio" name="do_result1" value="出来なかった" required>出来なかった<br>
</div>
<%-- textboxの値を渡す --%>
<div class memo>
メモ<br>
<input type="text" name="memo_list1" placeholder="10文字以上"  minlength="10" value="" required><br>
</div>

<%-- ☆修正必要☆ --%>
<h3>あなたの選択項目2</h3>
<p><%= goal.getGoalgenre2() %></p>
 <%= goal.getGoal2() %>
<%-- radioの値を渡す --%>
<div class result>
<input type="radio" name="do_result2" value="出来た" required>出来た<br>
<input type="radio" name="do_result2" value="出来なかった" required>出来なかった<br>
</div>
<%-- textboxの値を渡す --%>
<div class memo>
メモ<br>
<input type="text" name="memo_list2" placeholder="10文字以上"  minlength="10" value="" required><br>
</div>

<%-- ☆修正必要☆ --%>
<h3>あなたの選択項目3</h3>
<p><%= goa.getGoalgenre3() %></p>
 <%= goal.getGoal3() %>
<%-- radioの値を渡す --%>
<div class result>
<input type="radio" name="do_result3" value="出来た" required>出来た<br>
<input type="radio" name="do_result3" value="出来なかった" required>出来なかった<br>
</div>
<%-- textboxの値を渡す --%>
<div class memo>
メモ<br>
<input type="text" name="memo_list3"  placeholder="10文字以上" minlength="10" value="" required><br>
</div>
<input type="submit" value="記録確認・登録画面へ"/><br>
</form>
<a href="/Aproject3/TopServlet">TOPへ</a>
</body>
</html>
