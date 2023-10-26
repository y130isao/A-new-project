<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/Aproject3/css/login.css">
<title>ログイン画面</title>
</head>
<body>
    <form action="/Aproject3/AccountSearch" method="post">
        <h1>Welcome!</h1>
        <!--<input placeholder="Username" type="text"/>
        <input placeholder="Password" type="password"/>-->

        <input type="text" name="loginId" placeholder="ユーザーID" required>
        <input type="password" name="pass" placeholder="パスワード" required>
        <button class="btn">ログイン</button>
        <!--<input type="submit" value="ログイン">-->

    </form>

    <footer>
        <h5>アカウント登録がお済みでない方はこちらへ: <a href="/Aproject3/AccountRegister"><button>新規登録</button></a></h5>
    </footer>

    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script id="rendered-js">
        $(document).ready(function (e) {
            $('h6').on('click', function () {
                $('.social').stop().slideToggle();
            });
        });

    </script>
</body>
</html>