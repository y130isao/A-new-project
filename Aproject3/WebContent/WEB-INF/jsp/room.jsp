<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Shippori+Mincho+B1&display=swap')
	;
</style>
<style>
* {
	padding: 0%;
	margin: 0%;
	font-family: 'Shippori Mincho B1', serif;
}

body {
	text-align: center;
	background-color: gray;
}

header {
	color: #000055;
	font-size: 1.5rem;
	margin: 30px 0 30px 0;
}

footer {
	color: #691c23;
	font-size: 1.5rem;
	margin-top: 20px;
}

img {
	width: 100%;
}
</style>

<!-- <link rel="stylesheet" type="text/css" href="/Aproject3/css/room.css"> -->
<%-- <script src="${pageContext.request.contextPath}/room.js"></script> --%>
<title>ルーム</title>
</head>
<body>
	<header>
		<b>Welcome!</b>
	</header>
	<!--<header>Welcome to my room</header>-->
	<c:choose>
		<c:when test="${account.genId == 1 }">
			<c:choose>
				<c:when test="${account.charaLevel == 1 }">
					<!-- 男性のキャラクターLV1 -->
					<div>
						<img src="images/mobuman1.png">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 2 }">
					<!-- 男性のキャラクターLV2 -->
					<div>
						<img src="images/mobuman2.png">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 3 }">
					<!-- 男性のキャラクターLV3 -->
					<div>
						<img src="images/mobuman3.jpg">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 4 }">
					<!-- 男性のキャラクターLV4 -->
					<div class="card">
						<img src="images/mobuman4.jpg">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 5 }">
					<!-- 男性のキャラクターLV5 -->
					<div>
						<img src="images/mobuman5.jpg">
					</div>
				</c:when>
			</c:choose>
		</c:when>
		<c:when test="${account.genId == 2 }">
			<c:choose>
				<c:when test="${account.charaLevel == 1 }">
					<!-- 女性のキャラクターLV1 -->
					<div>
						<img src="images/mobugirl1.jpg">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 2 }">
					<!-- 女性のキャラクターLV2 -->
					<div>
						<img src="images/mobugirl2.jpg">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 3 }">
					<!-- 女性のキャラクターLV3 -->
					<div>
						<img src="images/mobugirl3.jpg">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 4 }">
					<!-- 女性のキャラクターLV4 -->
					<div>
						<img src="images/mobugirl4.png">
					</div>
				</c:when>
				<c:when test="${account.charaLevel == 5 }">
					<!-- 女性のキャラクターLV5 -->
					<div>
						<img src="images/mobugirl5.jpg">
					</div>
				</c:when>
			</c:choose>
		</c:when>
	</c:choose>
	<footer>
		<a href="${pageContext.request.contextPath}/TopServlet">topへ</a>
	</footer>
</body>
</html>
