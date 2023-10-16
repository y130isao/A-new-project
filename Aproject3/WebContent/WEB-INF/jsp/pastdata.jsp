
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.MyCalendar"%>
<%
	MyCalendar mc=(MyCalendar)request.getAttribute("mc");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>過去の記録の確認</title>
</head>
<body>
	<h1>過去の記録の確認</h1>
	<h2><%=mc.getGengou() %>年<%=mc.getMonth() %>月カレンダー</h2>
	<p>過去の記録を確認したい日付をクリックしてください。</p>

    <p>
		　<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()-1%>">前月</a>
    	<a href="?year=<%=mc.getYear()%>&month=<%=mc.getMonth()+1%>">翌月</a>
    </p>
    <table>
      <tr>
        <th>日</th>
        <th>月</th>
        <th>火</th>
        <th>水</th>
        <th>木</th>
        <th>金</th>
        <th>土</th>
      </tr>
      <%for(String[] row: mc.getData()){ %>
      <tr>
      	<%for(String col:row) {%>
      		<%if (col.startsWith("*")){ %>
      			<td class="today"><%=col.substring(1)%></td>
      		<%}else{ %>
      			<td><%=col %></td>
      		<%} %>
      	<%} %>
      </tr>
      <%} %>
    </table>
  </div>
	<!-- end container--><a href="${pageContext.request.contextPath}/TopServlet">TOPへ</a>
</body>


</html>

