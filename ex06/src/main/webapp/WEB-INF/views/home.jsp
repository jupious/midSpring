<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
인증된 사용자 일 경우에만 아이디 출력<br/>
<sec:authorize access="isAuthenticated()">
	<p><sec:authentication property="principal.username"/>님 환영합니다.</p>
</sec:authorize>
<P>  The time on the server is ${serverTime}. </P>
<a href = "/sample/all">all</a>
<a href = "/sample/member">member</a>
<a href = "/sample/admin">admin</a>
<a href = "/customLogout">로그아웃</a>
</body>
</html>
