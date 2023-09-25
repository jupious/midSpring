<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 제품목록</title>
<link type="text/css" rel="stylesheet" href="/resources/stylesheet.css"/>
</head>
<body>
<h2>전체 제품목록</h2>
<fieldset id = "fs">
	<legend>조회결과</legend>
	<table border = "1">
		<tr><th>제품코드</th><th>제품이름</th><th>제품원가</th><th>목표수량</th><th>재고수량</th><th>출고가</th><th>그룹명</th></tr>
		<c:forEach var = "data" items = "${productList}">
			<tr>
				<td>${data.code}</td>
				<td>${data.pname}</td>
				<td>${data.cost}</td>
				<td>${data.pnum}</td>
				<td>${data.jnum}</td>
				<td>${data.sale}</td>
				<td>${data.gname}</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<a href="mainMenu.mst">
  <input class="buttonss" type="button" value="메인화면"></a>
</fieldset>
</body>
</html>