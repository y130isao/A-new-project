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
選択項目
<select name="example">
<option></option>
</select><br>
出来た
<input type="radio" name="do" value="0">
出来なかった
<input type="radio" name="do" value="1"><br>

メモ<br>
<input type="text" neme="memo"><br>

<input type="submit" onclick="location.href='./recordcheck.jsp'"value="記録確認・登録画面へ">
<div>
<h2><a href="top.jsp">TOP画面へ</a></h2>
</div>
</body>
</html>