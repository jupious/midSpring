<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h1{background-color: red;}
</style>
</head>
<body>
<h1>여기가 초록색으로 바뀌면 클릭!</h1>
<span></span>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
	var timer;
	var isGreen = false;
	$(function(){
		$.ajax({
			url:"/timer",
			type:"post",
			success:function(result){
				setTimeout(function(){
					$('h1').css("background-color","green");
					isGreen = true;
					timer = new Date();
				}, result);
			}
		})
		list("");
	})

	
	$('h1').on("click", function(){
		let etime = new Date();
		let rec = etime - timer;
		if(!isGreen){
			alert('초록색일때 클릭해주세요!');
		}else{
			$('h1').html("반응속도는"+(rec)/1000+"s");
			list(rec);
		}
	})
	
	function list(rec){
		if(rec == ""){
			rec = -1;
		}
		$.ajax({
			url:"/getRecords2/"+rec,
			type:"post",
			success: function(result){
				console.log("성공이야!");
				let repeat = 5;
				let recStr = "";
				if(result.length < 5){
					repeat = result.length;
				}
				for(let k = 0; k < repeat; k++){
					console.log("기록들",result[k]/1000);
					recStr += "<p>"+Number(k+1)+"등 "+result[k]/1000+"s</p>";
				}
				$('span').html(recStr);
			}
		})
	}
</script>
</body>
</html>