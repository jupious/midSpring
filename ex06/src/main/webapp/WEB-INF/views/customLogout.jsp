<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그아웃 페이지<br/>
정의해둔 로그아웃 url로 post 요청하면 로그아웃
(csrf 토큰을 보내줘야한다)
<form action = "/customLogout" method = "post">
	<input type="hidden" name = "${_csrf.parameterName}" value="${_csrf.token}" />
	<input type="submit" value = "로그아웃" />
</form>
</body>
</html>