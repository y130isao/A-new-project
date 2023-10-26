<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="model.RecordBeans" %>

<%
// セッションスコープに保存されたDo_result/Memo_listを取得
RecordBeans rb = (RecordBeans) session.getAttribute("recordbeans");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/Aproject3/css/recordcheck.css">
<title>本日の記録確認</title>
</head>
<body>
    <header>HealtCareApp!</header>
    <h1>下記の内容で登録します。</h1>
    <section>
        <div class="kiroku1">
            <div class result>
                <h2>あなたの選択項目1</h2>
                結果<br>
                【<%= rb.getDo_result1() %>】</br>
            </div>
            <div class memo>
                メモ<br>
                【<%= rb.getMemo_list1() %>】</br>
                    </h2>
            </div>
        </div>
        <div class="kiroku2">
            <div class result>
                <h2>あなたの選択項目2</h2>
                結果<br>
                【<%= rb.getDo_result2() %>】</br>
            </div>
            <div class memo>
                メモ<br>
                【<%= rb.getMemo_list2() %>】</br>
            </div>
        </div>
        <div class="kiroku3">
            <div class result>
                <h2>あなたの選択項目3</h2>
                結果<br>
                【<%= rb.getDo_result3() %>】</br>
            </div>
            <div class memo>
                メモ<br>
                【<%= rb.getMemo_list3() %>】</br>
            </div>
        </div>
    </section>
    <form action="/Aproject3/RecordComplete" method="post">
        <input type="submit" value="登録する"><br>
    </form>
    <a href="/Aproject3/RecordServlet">前の画面に戻る</a>
<%--<h1>下記の内容で登録します。</h1>

<h2>あなたの選択項目1</h2><br>

<div class result>
結果<br>
【<%= rb.getDo_result1() %>】</br>
</div>

<div class memo>
メモ<br>
【<%= rb.getMemo_list1() %>】</br>
</h2>
</div>

<h2>あなたの選択項目2</h2><br>

<div class result>
結果<br>
【<%= rb.getDo_result2() %>】</br>
</div>
<div class memo>
メモ<br>
【<%= rb.getMemo_list2() %>】</br>
</div>

<h2>あなたの選択項目3</h2><br>

<div class result>
結果<br>
【<%= rb.getDo_result3() %>】</br>
</div>
<div class memo>
メモ<br>
【<%= rb.getMemo_list3() %>】</br>
</div>

<form action="/Aproject3/RecordComplete" method="post">
<input type="submit" value="登録する"><br>
</form>
<a href="/Aproject3/RecordServlet" >前の画面に戻る</a> --%>
</body>
</html>
