<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간인기글</title>
</head>
<body>
	<h1>실시간 인기글(1시간 안에 가장 많은 댓글이 달린 글)</h1>
	<span id = "result"></span>
	
<script src="https://code.jquery.com/jquery-3.7.1.js" ></script>
<script>
	var preResult;
	$(function(){
	})
	setInterval(function(){
			
			$.ajax({
				url:"/myapi/getPopular",
				type:"get",
				success:function(res){
					console.log("가져온 값",res);
					console.log("이전결과",preResult);
					if(preResult){
						for(var rank = 0; rank <preResult.length; rank++){
							for(var i=0; i<result.length;i++){
								if(preResult[rank].bno == result[i].bno){
									break;
								}
							} //이부분 수정해야함
							if(rank == i){//순위 유지
								console.log("순위유지");
							}else if(i < 4){//순위 변경
								console.log("순위변동")
							}
						}
						
					}
					
					var resStr = "";
					for(var i = 0; i < res.length; i++){
						resStr+=(i+1)+"등 "+res[i].title+"(+"+res[i].commcount+")<br/>";
					}
					preResult = res;
					$('#result').html(resStr);
				}
			})
		}, 3000);
</script>	
</body>
</html>