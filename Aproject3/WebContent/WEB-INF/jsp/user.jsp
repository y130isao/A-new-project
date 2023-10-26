<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/Aproject3/css/user.css">
<title>ユーザー情報</title>
</head>
<body>
    <header>HealthCareApp!</header>
    <div class="contener">
    <div class="top"><h2>ここはユーザーページです。</h2></div>
    <c:choose>
    <c:when test="${account.roleId == 2 }">
    登録内容の確認。
    <p>ログインID：<c:out value="${account.loginId }"></c:out></p>
    <p>パスワード：<c:out value="${account.pass }"></c:out></p>
    <p>　　　名前：<c:out value="${account.name }"></c:out></p>
    <p>　　　性別：<c:out value="${account.genId }"></c:out></p>
    <p>　　ロール：ユーザー</p>
    <p><a href="/Aproject3/Logout"><button type="button" >ログアウト</button></a></p>
    <a href="admin.jsp"><button type="button" >管理者ページへ</button></a>
    </c:when>
    <c:when test="${account.roleId == 1 }">
    <a href="admin.jsp">管理者ページへ</a>
    </c:when>
    <c:otherwise>
    <a href="/Aproject3/Login">ログインページへ</a>
    </c:otherwise>
    </c:choose>
</div>
<%--ここはユーザーページです。<br>
<c:choose>
<c:when test="${account.roleId == 2 }">
登録内容の確認。
<p>ログインID：<c:out value="${account.loginId }"></c:out></p>
<p>パスワード：<c:out value="${account.pass }"></c:out></p>
<p>　　　名前：<c:out value="${account.name }"></c:out></p>
<p>　　　性別：<c:out value="${account.genId }"></c:out></p>
<p>　　ロール：ユーザー</p>
<p><a href="/Aproject3/Logout"><button type="button" >ログアウト</button></a></p>
<a href="admin.jsp"><button type="button" >管理者ページへ</button></a>
</c:when>
<c:when test="${account.roleId == 1 }">
<a href="admin.jsp">管理者ページへ</a>
</c:when>
<c:otherwise>
<a href="/Aproject3/Login">ログインページへ</a>
</c:otherwise>
</c:choose> --%>

</body>
</html>