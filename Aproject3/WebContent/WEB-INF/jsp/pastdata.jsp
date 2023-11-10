<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.MyCalendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="/Aproject3/css/pastdata.css">
<title>過去の記録の確認</title>
</head>
<body>
	<header>
		健康管理アプリ
	</header>
	
		<h1>過去の記録の確認</h1>
		<h2>
			<c:out value="${mc.gengou}" />
			年
			<c:out value="${mc.month}" />
			月カレンダー
		</h2>
	
	<p>過去の記録を確認したい日付をクリックしてください。</p>

	<p>
		<a
			href="?year=<c:out value="${mc.year}"/>&amp;month=<c:out value="${mc.month - 1}">前月</c:out>">前月</a>
		<a
			href="?year=<c:out value="${mc.year}"/>&amp;month=<c:out value="${mc.month + 1}">翌月</c:out>">翌月</a>

	</p>
	<table border="1">
		<tr>
			<th>日</th>
			<th>月</th>
			<th>火</th>
			<th>水</th>
			<th>木</th>
			<th>金</th>
			<th>土</th>
		</tr>
		<c:forEach var="row" items="${mc.data}">
			<tr>
				<c:forEach var="col" items="${row}">
					<c:choose>
						<c:when test="${not empty col}">
							<td><a
								href="PastdataServlet?year=<c:out value="${mc.year}"/>&month=<c:out value="${mc.month}"/>&day=<c:out value="${col}"/>"><c:out
										value="${col}" /></a></td>
						</c:when>
						<c:otherwise>
							<td></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

	<c:forEach var="listG" items="${listG}">
		<p>
			目標1の<c:out value="${listG.goalgenre1}" />
			：
			<c:out value="${listG.goal1}" />
			
			
		</p>

		<p>
			目標2の<c:out value="${listG.goalgenre2}" />
			：
			<c:out value="${listG.goal2}" />
		</p>
		
		<p>
			目標3の<c:out value="${listG.goalgenre3}" />
			：
			<c:out value="${listG.goal3}" />
		</p>
	</c:forEach>

	<c:forEach var="list" items="${listR}">
		<p>
			目標1
			：
			<c:out value="${list.do_result1 ? 'できた' : 'できなかった'}" />
			<c:out value="${list.memo_list1}" />
			
		</p>

		<p>
			目標2
			：
			<c:out value="${list.do_result2 ? 'できた' : 'できなかった'}" />
			<c:out value="${list.memo_list2}" />
		</p>

		<p>
			目標3
			：
			<c:out value="${list.do_result3 ? 'できた' : 'できなかった'}" />
			<c:out value="${list.memo_list3}" />
		</p>
	</c:forEach>
	<footer>
		<a href="${pageContext.request.contextPath}/TopServlet">TOPへ</a>
	</footer>
</body>
</html>
