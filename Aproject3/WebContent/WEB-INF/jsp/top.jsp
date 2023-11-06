<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/Aproject3/css/top.css">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=BIZ+UDGothic&display=swap');
    </style>
    <title>TOP</title>
</head>

<body>
    <h1>健康管理アプリ</h1>
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/PastdataServlet">過去のデータ</a></li>
            <li><a href="${pageContext.request.contextPath}/GoalServlet">目標設定</a></li>
            <li><a href="${pageContext.request.contextPath}/RecordServlet">記録</a></li>
            <li class="slider"></li>
        </ul>
    </nav>
    <div>
        <h2><a href="${pageContext.request.contextPath}/RoomServlet">モブルームへ</a></h2>
    </div>

    <div class="point">
        <p>現在のレベル: <b>${charaLevel}</b></p>
        <p>所有ポイント: <b>${charaPoint}</b> point</p>
        <p>次のレベルアップまで: <b>${nextLevelUpPoints}</b> point</p>
    </div>
</body>

</html>