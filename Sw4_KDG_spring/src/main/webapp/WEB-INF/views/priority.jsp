<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우선생산 제품</title>
	<link type="text/css" rel="stylesheet" href="/resources/stylesheet.css"/>
</head>
<body>
<h2>우선생산 제품</h2>
<fieldset id = "fs">
	<legend>조회결과</legend>
	<table border = "1">
		<tr><th>제품이름</th><th>생산해야할수량</th></tr>
		<c:forEach var = "priority" items = "${priorityList}">
			<tr>
				<td>${priority.pname}</td>
				<td>${priority.priority}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="mainMenu.mst">
  <input class="buttonss" type="button" value="메인화면"></a>
</fieldset>





</body>
</html>