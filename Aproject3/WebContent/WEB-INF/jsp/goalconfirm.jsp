<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Goal"%>

<%-- "goalList" 属性が存在するかチェック --%>
<%
List<model.Goal> goalList = (List<model.Goal>) request.getAttribute("goalList");
%>
<!-- 目標情報を表示するコード -->
<!DOCTYPE html>

<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/Aproject3/css/goalconfirm.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=BIZ+UDGothic&display=swap');
    </style>
<title>確認画面</title>
</head>

<body>
    <header>健康管理アプリ</header>
    <h1>以下の内容で目標を設定しますか？</h1>
    <div class="container">
        <div class="contact-formbox">
            <dt>
                <p>
                    <%=goalList.get(0).getGoalgenre1()%>
                </p>
            </dt>
            <dd class="contact-1">
                <%=goal.getGoal1() %>
            </dd>
        </div>
        <div class="contact-formbox">
            <dt>
                <p>
                    <%=goal.getGoalgenre2()%>
                </p>
            </dt>
            <dd class="contact-1">
                <%=goal.getGoal2()%>
            </dd>
        </div>
        <div class="contact-formbox">
            <dt>
                <p>
                    <%=goal.getGoalgenre3()%>
                </p>
            </dt>
            <dd class="contact-1">
                <%=goal.getGoal3() %>
            </dd>
        </div>
    </div>

    <div id="btBox">
        <a href="/Aproject3/GoalconfirmServlet?mode=back" class="button2">戻る</a>
        <span>        </span>
        <a href="/Aproject3/GoalconfirmServlet?mode=send" class="button2">送信</a>
    </div>
    <a href="/Aproject3/TopServlet">TOPへ</a>
</body>

</html>