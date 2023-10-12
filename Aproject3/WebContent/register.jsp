<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規登録</title>
</head>
<body>
<form action="/Aproject3/AccountRegister" method="post">
<p>すべて入力してください</p>
<p>
<input type="radio" name="roleId" value="1">管理者で登録
<input type="radio" name="roleId" value="2" checked>ユーザーで登録
</p>
　　　名前：<input type="text" name="name" required><br>
ユーザーID：<input type="text" name="loginId" required><br>
パスワード：<input type="password" name="pass" required><br>
<input type="submit" value="登録"><br>
</form>
</body>
</html>
