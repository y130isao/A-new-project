<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YY年MM月dd日");
String today = sdf.format(date);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;  charset="UTF-8">
<title>本日の記録</title>
</head>
<body>
<h1>本日の記録</h1>
<h2><%= sdf.format(date) %></h2><br>

<form action="/Aproject3/RecordServlet" method="post">
<%-- プルダウンの値を渡す --%>
選択項目
<select id="example" name="example_list">
<option>あ</option>
<option>い</option>
<option>う</option>
</select><br>
<%-- radioの値を渡す --%>
<input type="radio" name="do_result" value="出来た">出来た<br>
<input type="radio" name="do_result" value="出来なかった">出来なかった<br>

<%-- textboxの値を渡す --%>
メモ<br>
<input id="memo"type="text" neme="memo_list"><br>

<input type="submit" value="記録確認・登録画面へ"/>

<div>
<h2><a href="top.jsp">TOP画面へ</a></h2>
</body>
</html>