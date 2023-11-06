<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Record"%>

<%
// セッションスコープに保存されたDo_result/Memo_listを取得
List<model.Record> recordList = (List<model.Record>) session.getAttribute("recordList");

//リストからBoolean値を取得
boolean do_result1 = recordList.get(0).getDo_result1(); 
boolean do_result2 = recordList.get(0).getDo_result2();
boolean do_result3 = recordList.get(0).getDo_result3();

//リストからString値を取得
String memo_list1 = recordList.get(0).getMemo_list1(); 
String memo_list2 = recordList.get(0).getMemo_list2();
String memo_list3 = recordList.get(0).getMemo_list3();
%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/Aproject3/css/recordcheck.css">
<title>本日の記録確認</title>
</head>
<body>
	<header>HealtCareApp!</header>
	<h1>下記の内容で登録します。</h1>
	<section>
		<div class="kiroku1">
			<div>
				<h2>あなたの選択項目1</h2>
				結果<br>
				<h2>あなたの選択項目1</h2>
				 <p>結果: <%= do_result1 %></p>
			</div>
			<div>
				メモ<br> 【<%= memo_list1 %>】</br>
			</div>
		</div>
		<div class="kiroku2">
			<div>
				<h2>あなたの選択項目2</h2>
				 <p>結果: <%= recordList.get(0).getDo_result2() %></p>
			</div>
			<div>
				メモ<br> 【<%=recordList.get(0).getMemo_list2()%>】</br>
			</div>
		</div>
		<div class="kiroku3">
			<div>
				<h2>あなたの選択項目3</h2>
				 <p>結果: <%= recordList.get(0).getDo_result3() %></p>
			</div>
			<div>
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

