<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Goal" %>

<%
List<model.Goal> goalList = (List<model.Goal>) request.getAttribute("goalList");
if (goalList != null && !goalList.isEmpty()) {
%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>

<%
List<model.Goal> goalList = (List<model.Goal>) request.getAttribute("goalList");
%> 


<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YY年MM月dd日");
Date date = sdf.format(date);
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
<p><%= goalList.get(0).getGoalgenre1() %></p>
 <%= goalList.get(0).getGoal1() %>

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
<p><%= goalList.get(0).getGoalgenre2() %></p>
 <%= goalList.get(0).getGoal2() %>
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
<p><%= goalList.get(0).getGoalgenre3() %></p>
 <%= goalList.get(0).getGoal3() %>
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