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
<input type="radio" name="roleId" value="1">管理者で登録する
<input type="radio" name="roleId" value="2" checked>ユーザーで登録する
</p>
　　　名前：<input type="text" name="name" required maxlength="15" placeholder="15字以内"><br>
ユーザーID：<input type="text" name="loginId" required maxlength="15" placeholder="15字以内"><br>
パスワード：<input type="password" name="pass" required maxlength="8" pattern="^[a-zA-Z0-9]+$" placeholder="半角英数字8文字以内"><br>
<input type="radio" name="genId" value="1">男性
<input type="radio" name="genId" value="2" checked>女性
<input type="submit" value="登録"><br>
</form>
</body>
</html>
