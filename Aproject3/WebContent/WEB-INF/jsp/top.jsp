<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康管理アプリ</title>
</head>
<body>
<h1>健康管理アプリ</h1>
<ul>
	<li><a href="${pageContext.request.contextPath}/PastdataServlet">過去のデータ</a></li>
	<li><a href="${pageContext.request.contextPath}/GoalServlet">目標設定</a></li>
</ul>
<div>
<h2><a href="${pageContext.request.contextPath}/RoomServlet">モブルームへ</a></h2>
</div>
<div>
<h2><a href="${pageContext.request.contextPath}/RecordServlet">記録</a></h2>
</div>

<div>
<p>現在のレベル: ${charaLevel}</p>
<p>所有ポイント: ${charaPoint} point</p>
<p>次のレベルアップまで: ${nextLevelUpPoints} point</p>
</div>
</body>
</html>