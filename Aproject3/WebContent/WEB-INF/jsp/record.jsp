<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Goal"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>

<%
List<model.Goal> goalList = (List<model.Goal>) session.getAttribute("goalList");
%>

<%@ page import="java.util.Date, java.text.SimpleDateFormat"%>

<%
Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("YY年MM月dd日");
String today = sdf.format(date);
%>

<%
Record record=(Record)session.getAttribute("record");
boolean goalgenre1=record==null? "":goal.getGoalgenre1();
boolean goalgenre2=record==null? "":goal.getGoalgenre2();
boolean goalgenre3=record==null? "":goal.getGoalgenre3();
String goal1=record==null? "":goal.getGoal1();
String goal2=record==null? "":goal.getGoal2();
String goal3=record==null? "":goal.getGoal3();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=BIZ+UDGothic&display=swap');
    </style>
<title>本日の記録</title>
</head>
<body>
    <header>
        健康管理アプリ
    </header>
    <h1>本日の記録</h1>
    <h2>
        <%= sdf.format(date) %>
    </h2>
    <form action="/Aproject3/RecordServlet" method="post">
        <div class="kiroku1">
            <h3>あなたの選択項目1</h3>
            <%-- radioの値を渡す --%>
                <div class result>
                    <input type="radio" name="do_result1" value="出来た" required>出来た<br>
                    <input type="radio" name="do_result1" value="出来なかった" required>出来なかった<br>
                </div>
                <%-- textboxの値を渡す --%>
                    <div class memo>
                        メモ<br>
                        <input type="text" name="memo_list1" placeholder="10文字以上" minlength="10" value="" required><br>
                    </div>
        </div>
        <div class="kiroku2">
            <h3>あなたの選択項目2</h3>
            <%-- radioの値を渡す --%>
                <div class result>
                    <input type="radio" name="do_result2" value="出来た" required>出来た<br>
                    <input type="radio" name="do_result2" value="出来なかった" required>出来なかった<br>
                </div>
                <%-- textboxの値を渡す --%>
                    <div class memo>
                        メモ<br>
                        <input type="text" name="memo_list2" placeholder="10文字以上" minlength="10" value="" required><br>
                    </div>
        </div>
        <div class="kiroku3">
            <h3>あなたの選択項目3</h3>
            <%-- radioの値を渡す --%>
                <div class result>
                    <input type="radio" name="do_result3" value="出来た" required>出来た<br>
                    <input type="radio" name="do_result3" value="出来なかった" required>出来なかった<br>
                </div>
                <%-- textboxの値を渡す --%>
                    <div class memo>
                        メモ<br>
                        <input type="text" name="memo_list3" placeholder="10文字以上" minlength="10" value="" required><br>
                    </div>
        </div>

    </form>
    <div class="btn">
        <input type="submit" value="記録確認・登録画面へ" />
    </div>

    <footer><a href="/Aproject3/TopServlet">TOPへ</a></footer>
</body>
</html>