<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model.RecordBeans" %>
<%
// リクエストスコープに保存されたHealthを取得
RecordBeans rb = (RecordBeans) request.getAttribute("recordbeans");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>本日の記録確認</title>
</head>
<body>
<h1>下記の記録で登録します。</h1>
<h2>
あなたの選択項目<br>
【<%= rb.getExample_list() %>】</br>

結果<br>
【<%= rb.getDo_result() %>】</br>

メモ<br>
【<%= rb.getMemo_list() %>】</br>
</h2>
<a href="/WEB-INF/jsp/record.jsp" >前の画面に戻る</a></p>

</body>
</html>