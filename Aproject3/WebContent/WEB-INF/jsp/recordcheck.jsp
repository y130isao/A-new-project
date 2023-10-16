<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model.RecordBeans" %>
<%
// セッションスコープに保存されたHealthを取得
RecordBeans rb = (RecordBeans) session.getAttribute("recordbeans");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本日の記録確認</title>
</head>
<body>
<h1>下記の内容で登録します。</h1>
<h2>
あなたの選択項目<br>
【<%= rb.getExample_list() %>】</br>

結果<br>
【<%= rb.getDo_result() %>】</br>

メモ<br>
【<%= rb.getMemo_list() %>】</br>
</h2>
<form action="/Aproject3/RecordComplete" method="post">
<input type="submit" value="登録する"><br>
</form>
<a href="/Aproject3/RecordServlet" >前の画面に戻る</a>
</body>
</html>