<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/Aproject3/css/top.css">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=BIZ+UDGothic&display=swap')
	;
</style>
<title>TOP</title>
</head>

<body>
    <c:choose>
        <c:when test="${goal == 0 }">
            <div class="mokuhyou">🌴 目標の登録がされていません。目標設定のリンクから登録しましょう。</div>
            <div class="kiroku">🌴 記録画面で今日の達成を記録しましょう。</div>
        </c:when>
    </c:choose>
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
		<h2>
			<a href="${pageContext.request.contextPath}/RoomServlet">モブルームへ</a>
		</h2>
	</div>

	<div class="point">
		<p>
			現在のレベル: <b>${account.charaLevel}</b>
		</p>
		<p>
			所有ポイント: <b>${account.charaPoint}</b> point
		</p>
		<p>
			次のレベルアップまで: <b> <c:choose>
					<c:when test="${account.charaLevel == 1 }">
						<!-- 男性のキャラクターLV1 -->${90-account.charaPoint}
				</c:when>
					<c:when test="${account.charaLevel == 2 }">
						<!-- 男性のキャラクターLV2 -->${180-account.charaPoint}
				</c:when>
					<c:when test="${account.charaLevel == 3 }">
						<!-- 男性のキャラクターLV3 -->${270-account.charaPoint}
				</c:when>
					<c:when test="${account.charaLevel == 4 }">
						<!-- 男性のキャラクターLV4 -->${360-account.charaPoint}
				</c:when>
					<c:when test="${account.charaLevel == 5 }">
						<!-- 男性のキャラクターLV5 -->${450-account.charaPoint}
				</c:when>
				</c:choose>
			</b> point
		</p>
	</div>
</body>

</html>