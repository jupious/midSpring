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
	<input type="number" id = "num2" /> =
	<input type="number" id = "add" readonly="readonly" /><br/><br/>
	
	<input type="number" id = "num3" /> -
	<input type="number" id = "num4" /> =
	<input type="number" id = "sub" readonly="readonly" /><br/><br/>
	
	<input type="number" id = "num5" /> ~
	<input type="number" id = "num6" /> =
	<input type="number" id = "sum" readonly="readonly" /><br/><br/>
	
	<button id = "btn">확인</button>
	
<script src="https://code.jquery.com/jquery-3.7.1.js" 
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
	crossorigin="anonymous"></script>
<script>
	$('#btn').on("click",function(){
		var num1 = $('#num1').val();
		var num2 = $('#num2').val();
		var num3 = $('#num3').val();
		var num4 = $('#num4').val();
		var num5 = $('#num5').val();
		var num6 = $('#num6').val();
		
		var add = 0;
		var sub = 0;
		var sum = 0;
		
		if(num1 != "" && num2 != ""){
			add = Number(num1)+Number(num2);
			$('#add').val(add);
		}else{
			$('#add').val("");
		}
		
		if(num3 != "" && num4 != ""){
			sub = Number(num3)-Number(num4);
			$('#sub').val(sub);
		}else{
			$('#sub').val("");
		}
		
		if(num5 != "" && num6 != ""){
			for(var i = num5; i <= num6; i++){
				sum += Number(i);
			}
			$('#sum').val(sum);
		}else{
			$('#sum').val("");
		}
		
	})
</script>

</body>
</html>