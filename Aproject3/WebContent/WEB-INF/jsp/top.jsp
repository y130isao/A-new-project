<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="/Aproject3/css/top.css">
=======
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/Aproject3/css/top.css">
>>>>>>> branch 'chi6ru' of https://github.com/y130isao/A-new-project.git
<title>健康管理アプリ</title>
</head>
<body>
<<<<<<< HEAD
 <style>
        @import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');
      </style>
    <title>TOP</title>
</head>
=======
    <h1>健康管理アプリ</h1>
>>>>>>> branch 'chi6ru' of https://github.com/y130isao/A-new-project.git

<<<<<<< HEAD
<body>
   <h1>Health Care APP !</h1>

    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/PastdataServlet">過去のデータ</a></li>
            <li><a href="${pageContext.request.contextPath}/GoalServlet">目標設定</a></li>
            <li><a href="${pageContext.request.contextPath}/RecordServlet">記録</a></li>
            <li class="slider"></li>
        </ul>
    </nav>
    <div>
        <h2><a href="${pageContext.request.contextPath}/RoomServlet">モブルームへ</a></h2>
    </div>

    <div>
        <p>現在のレベル: ${charaLevel}</p>
        <p>所有ポイント: ${charaPoint} point</p>
        <p>次のレベルアップまで: ${nextLevelUpPoints} point</p>
    </div>

=======
    <nav>
        <ul>
            <li><a href="${pageContext.request.contextPath}/PastdataServlet">過去のデータ</a></li>
            <li><a href="${pageContext.request.contextPath}/GoalServlet">目標設定</a></li>
            <li><a href="${pageContext.request.contextPath}/AccountServlet">アカウント設定</a></li>
            <li><a href="${pageContext.request.contextPath}/RecordServlet">記録</a></li>
            <li class="slider"></li>
        </ul>
    </nav>




    <div>
        <h2><a href="${pageContext.request.contextPath}/RoomServlet">モブルームへ</a></h2>
    </div>

    <div>
        <p>現在のレベル: ${charaLevel}</p>
        <p>所有ポイント: ${charaPoint} point</p>
        <p>次のレベルアップまで: ${nextLevelUpPoints} point</p>
    </div>
>>>>>>> branch 'chi6ru' of https://github.com/y130isao/A-new-project.git
</body>

</html>