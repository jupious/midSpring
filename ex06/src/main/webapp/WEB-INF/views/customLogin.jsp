<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 처리를 위한 url, 메소드
id와 pw의 name값은 정해져있음
csrf관련 값을 전송해줘야 처리가능
<form action="/login" method="post">
	id: <input type="text" name = "username" /><br/>
	pw: <input type="text" name = "password" /><br/>
	<input type="checkbox" name = "remember-me" />자동로그인<br/>
	<input type="submit" value="login" />
	<input type="hidden" name = "${_csrf.parameterName}" value="${_csrf.token}" />
</form>
</body>
</html>