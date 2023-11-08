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
	<%-- 	<header>健康管理アプリ</header>
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
			href="?year=<c:out value=" ${mc.year}" />&amp;month=<c:out value="${mc.month - 1}">前月</c:out>">前月</a>
		<a
			href="?year=<c:out value=" ${mc.year}" />&amp;month=<c:out value="${mc.month + 1}">翌月</c:out>">翌月</a>
	</p>
	<table border="1">
		<tbody>
			<tr>
				<th>日</th>
				<th>月</th>
				<th>火</th>
				<th>水</th>
				<th>木</th>
				<th>金</th>
				<th>土</th>
			</tr>
			<tr>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=1">1</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=2">2</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=3">3</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=4">4</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=5">5</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=6">6</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=7">7</a></td>
			</tr>
			<tr>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=8">8</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=9">9</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=10">10</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=11">11</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=12">12</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=13">13</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=14">14</a></td>
			</tr>
			<tr>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=15">15</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=16">16</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=17">17</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=18">18</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=19">19</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=20">20</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=21">21</a></td>
			</tr>

			<tr>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=22">22</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=23">23</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=24">24</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=25">25</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=26">26</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=27">27</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=28">28</a></td>
			</tr>
			<tr>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=29">29</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=30">30</a></td>
				<td><a href="PastdataServlet?year=2023&amp;month=10&amp;day=31">31</a></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	<a href="${pageContext.request.contextPath}/TopServlet">TOPへ</a> --%>





	<header>
		<h1>過去の記録の確認</h1>
		<h2>
			<c:out value="${mc.gengou}" />
			年
			<c:out value="${mc.month}" />
			月カレンダー
		</h2>
	</header>
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


	<c:forEach var="str" items="${list}">
		<p>
			<c:out value="${str.do_result1 ? 'できた' : 'できなかった'}" />
			：
			<c:out value="${str.memo_list1}" />
		</p>

		<p>
			<c:out value="${str.do_result2 ? 'できた' : 'できなかった'}" />
			：
			<c:out value="${str.memo_list2}" />
		</p>

		<p>
			<c:out value="${str.do_result3 ? 'できた' : 'できなかった'}" />
			：
			<c:out value="${str.memo_list3}" />
		</p>
	</c:forEach>


	<footer>
		<a href="${pageContext.request.contextPath}/TopServlet">TOPへ</a>
	</footer>
</body>
</html>
