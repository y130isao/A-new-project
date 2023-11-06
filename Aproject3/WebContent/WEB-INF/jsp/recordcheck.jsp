<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Record"%>

<%
// セッションスコープに保存されたDo_result/Memo_listを取得
List<model.Record> recordList = (List<model.Record>) session.getAttribute("recordList");
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/Aproject3/css/recordcheck.css">
	    <style>
        @import url('https://fonts.googleapis.com/css2?family=BIZ+UDGothic&display=swap');
    </style>
<title>本日の記録確認</title>
</head>
<body>
<<<<<<< HEAD
    <header>健康管理アプリ</header>

 	<h1>下記の内容で登録します。</h1>
	<section>
		<div class="kiroku1">
			<div class result>
				<h2>あなたの選択項目1</h2>
				結果<br>
				<h2>あなたの選択項目1</h2>
				 <p>結果: <%= recordList.get(0).getDo_result1() %></p>
			</div>
			<div class memo>
				メモ<br> 【<%=recordList.get(0).getMemo_list1()%>】</br>
				</h2>
			</div>
		</div>
		<div class="kiroku2">
			<div class result>
				<h2>あなたの選択項目2</h2>
				 <p>結果: <%= recordList.get(0).getDo_result2 %></p>
			</div>
			<div class memo>
				メモ<br> 【<%=recordList.get(0).getMemo_list2()%>】</br>
			</div>
		</div>
		<div class="kiroku3">
			<div class result>
				<h2>あなたの選択項目3</h2>
				 <p>結果: <%= recordList.get(0).getDo_result3 %></p>
			</div>
			<div class memo>
				メモ<br> 【<%=recordList.get(0).getMemo_list3()%>】</br>
			</div>
		</div>
	</section>
	<div id="btBox">
		<a href="/Aproject3/RecordCheck?mode=back" class="button2">戻る</a> <a
			href="/Aproject3/RecordCheck?mode=send" class="button2">送信</a>
	</div>

</body>
</html>

