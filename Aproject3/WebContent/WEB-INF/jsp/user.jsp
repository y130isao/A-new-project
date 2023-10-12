<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー情報</title>
</head>
<body>
ここはユーザーページです。<br>
<c:choose>
<c:when test="${account.roleId == 2 }">
登録内容の確認
<p>ログインID：<c:out value="${account.loginId }"></c:out></p>
<p>パスワード：<c:out value="${account.pass }"></c:out></p>
<p>　　　名前：<c:out value="${account.name }"></c:out></p>
<p>　　ロール：ユーザー</p>
<p><a href="/Aproject3/Logout"><button type="button" >ログアウト</button></a></p>
<a href="admin.jsp"><button type="button" >管理者ページへ</button></a>
</c:when>
<c:when test="${account.roleId == 1 }">
<a href="/Aproject3/AccountSearch">管理者ページへ</a>
</c:when>
<c:otherwise>
<a href="/Aproject3/AccountSearch">ログインページへ</a>
</c:otherwise>
</c:choose>

</body>
</html>
