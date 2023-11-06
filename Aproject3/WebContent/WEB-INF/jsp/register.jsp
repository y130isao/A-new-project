<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/Aproject3/css/register.css">
        <style>
        @import url('https://fonts.googleapis.com/css2?family=BIZ+UDGothic&display=swap');
    </style>
<title>新規登録</title>
</head>
<body>
       <header>
        健康管理アプリ
    </header>

    <p>すべて入力してください</p>
    <form action="/Aproject3/AccountRegister" method="post">

        

        <table>
            <tr>
                <td><input type="radio" name="roleId" value="1">管理者で登録する</td>
                <td><input type="radio" name="roleId" value="2" checked>ユーザーで登録する</td>
            </tr>
        </table>

        名前 : <input type="text" name="name" required maxlength="15" placeholder="15字以内">
        ユーザーID : <input type="text" name="loginId" required maxlength="15" placeholder="15字以内">
        パスワード : <input type="password" name="pass" required maxlength="8" pattern="^[a-zA-Z0-9]+$"
            placeholder="半角英数字8文字以内"><br>

        <table>
            <tr>
                <td><input type="radio" name="genId" value="1">男性</td>
                <td><input type="radio" name="genId" value="2" checked>女性</td>
            </tr>
        </table>

        <button class="btn">登録</button>

    </form>

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