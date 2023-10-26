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
        @import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
    </style>
<title>管理者ページ</title>
</head>
<body>
	ここは管理者用のページです。
	<br>
	<c:choose>
		<c:when test="${account.roleId == 1 }">
登録内容の確認。
<p>
				ログインID：
				<c:out value="${account.loginId }"></c:out>
			</p>
			<p>
				パスワード：
				<c:out value="${account.pass }"></c:out>
			</p>
			<p>
				名前：
				<c:out value="${account.name }"></c:out>
			</p>
			<p>
				性別：
				<c:out value="${account.genId }"></c:out>
			</p>
			<p>ロール：管理者</p>
			<p>
				<a href="/Aproject3/Logout"><button type="button">ログアウト</button></a>
			</p>
			<a href="user.jsp"><button type="button">ユーザーページへ</button></a>
		</c:when>
		<c:when test="${account.roleId == 2 }">
			<a href="user.jsp">ユーザーページへ</a>
		</c:when>
		<c:otherwise>
			<a href="login.jsp">ログインページへ</a>
		</c:otherwise>
	</c:choose>
</body>
</html>