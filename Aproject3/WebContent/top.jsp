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
	<li><a href="${pageContext.request.contextPath}/Aproject3/PastdataServlet">過去のデータ</a></li>
	<li><a href="${pageContext.request.contextPath}/Aproject3/GoalServlet">目標設定</a></li>
	<li><a href="${pageContext.request.contextPath}/Aproject3/AccountServlet">アカウント設定</a></li>
</ul>
<div>
<h2><a href="${pageContext.request.contextPath}/Aproject3/RoomServlet">モブルームへ</a></h2>
</div>
<div>
<h2><a href="${pageContext.request.contextPath}/Aproject3/RecordServlet">記録</a></h2>
</div>
</body>
</html>