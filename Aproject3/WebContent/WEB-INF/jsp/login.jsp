<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
<form action="/Aproject3/AccountSearch" method="post">
<input type="text" name="loginId" placeholder="ユーザーID" required><br>
<input type="password" name="pass" placeholder="パスワード" required><br>
<input type="submit" value="ログイン"><br>
</form>
<p>
アカウント登録がお済みでない方はこちらへ↓<br>
<a href="/Aproject3/AccountRegister"><button>新規登録</button></a>
</p>
</body>
</html>
