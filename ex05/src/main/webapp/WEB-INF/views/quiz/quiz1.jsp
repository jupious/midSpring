<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="number" id = "num1" /> +
	<input type="number" id = "num2" /><br/>
	= <input type="number" id = "sum" readonly="readonly" />
	<button id = "btn">확인</button>
	
<script src="https://code.jquery.com/jquery-3.7.1.js" 
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
	crossorigin="anonymous"></script>
<script>
	$('#btn').on("click",function(){
		var num1 = $('#num1').val();
		var num2 = $('#num2').val();
		var sum = 0;
		for(var i = num1; i <= num2; i++){
			sum += Number(i);
		}
		$('#sum').val(sum);
	})
</script>	
</body>
</html>