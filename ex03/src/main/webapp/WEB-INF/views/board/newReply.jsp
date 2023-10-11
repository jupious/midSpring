<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>newReply</title>
</head>
<body>
	오늘의 리플 개수 : <span id = "today"></span><br/>
	이 페이지에서 <span id = "seconds"></span> 초 동안 머물고 계십니다.. <br/>
	<button id = "check">확인</button><br/>
	<ol id = "list">
	</ol>
	
	<script src="https://code.jquery.com/jquery-3.7.1.js" ></script>
	<script>
		$(function(){
			var sec = 0;
		
			setInterval(function(){
				$.ajax({
					type:"get",
					url:"/myapi/commentsTodayCount",
					success:function(res){
						console.log("갯수"+res);
						sec+=1;
					
						$('#seconds').text(sec);
						$('#today').text(res);
					},
					error:function(er){
						console.log("에러발생");
						console.log(er);
					}
				})
			}, 1000);
		})
		$('#check').on("click", function(){
				console.log("확인버튼 클릭됨");
				$.ajax({
					type:"get",
					url:"/myapi/commentsToday",
					success:function(result){
						console.log(result);
						var resStr = "";
						for(var i = 0; i < result.length; i++){
							resStr += "<li>"+result[i].text+"("+result[i].writer+")</li>"
						}
						$('#list').html(resStr);
					},
					error:function(er){
						console.log("에러발생");
						console.log(er);
					}
				})
				
			})
	</script>
</body>
</html>