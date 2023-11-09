<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
import="model.Goal" %>

<%
Goal goal=(Goal)session.getAttribute("goal");
String goalgenre1=goal==null? "":goal.getGoalgenre1();
String goalgenre2=goal==null? "":goal.getGoalgenre2();
String goalgenre3=goal==null? "":goal.getGoalgenre3();
String goal1=goal==null? "":goal.getGoal1();
String goal2=goal==null? "":goal.getGoal2();
String goal3=goal==null? "":goal.getGoal3();
%>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="stylesheet" type="text/css" href="/Aproject3/css/goal.css">
		<title>目標設定</title>
	</head>
	<body>
	    <header>健康管理アプリ</header>
    <h1>目標設定</h1>
    <form action="/Aproject3/GoalconfirmServlet" method="post">
        <div class="contact-formbox">
            <select name="goalgenre1" value="<%=goalgenre1%>" required>
                <option value="">選択してください</option>
                <option value="運動">運動</option>
                <option value="食事">食事</option>
                <option value="睡眠">睡眠</option>
            </select>
            <dd class="contact-1">
                <input type="text" placeholder="必須" 
                name="goal1" value="<%=goal1%>" required>
            </dd>
        </div>
        <div class="contact-formbox">
            <select name="goalgenre2" value="<%=goalgenre2%>" required>
                <option value="">選択してください</option>
                <option value="運動">運動</option>
                <option value="食事">食事</option>
                <option value="睡眠">睡眠</option>
            </select>
            <dd class="contact-1">
                <input type="text" placeholder="必須" 
                name="goal2" value="<%=goal2%>" required>
            </dd>
        </div>
        <div class="contact-formbox">
            <select name="goalgenre3" value="<%=goalgenre3%>" required>
                <option value="">選択してください</option>
                <option value="運動">運動</option>
                <option value="食事">食事</option>
                <option value="睡眠">睡眠</option>
            </select>
            <dd class="contact-1">
                <input type="text" placeholder="必須" 
                name="goal3" value="<%=goal3%>" required>
            </dd>
        </div>
        <div class="btn"><input type="submit" class="button"  value="送信"></div>
    </form>
    <footer><a href="/Aproject3/TopServlet">TOPへ</a></footer>
	</body>
</html>