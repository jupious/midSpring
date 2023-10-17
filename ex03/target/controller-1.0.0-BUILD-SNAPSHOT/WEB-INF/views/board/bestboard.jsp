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
		rankDiff();
	})
	
	function rankDiff(){
		var diff = [];
		
		$.ajax({
			url:"/myapi/getPopular",
			type:"get",
			success:function(res){
				console.log("가져온 값",res);
				console.log("이전결과",preResult);
				if(preResult){
					for(var rank = 0; rank <res.length; rank++){
						for(var i=0; i<preResult.length;i++){
							if(res[rank].bno == preResult[i].bno){
								break;
							}
						} //이부분 수정해야함
						if(rank == i){//순위 유지
							console.log("순위유지");
							diff.push("0");
						}else if(i < 11){//순위 변경
							console.log("순위변동",res[rank].bno,"가 바뀜");
							console.log("현재순위",rank);
							console.log("순위변동 수치", preResult[i].rank - res[rank].rank);
							var rankDiff = preResult[i].rank - res[rank].rank;
							if(rankDiff > 0){
								rankDiff = "▲"+rankDiff;
							}else if(rankDiff < 0){
								rankDiff = "▼"+(rankDiff*-1);
							}
							diff.push(rankDiff);
						}
					}
					
				}
				console.log("diff배열",diff);
				var resStr = "";
				for(var i = 0; i < res.length; i++){
					var change="-";
					if(diff.length != 0){
						if(diff[i] != "0"){
							change=diff[i];
						}
					}
					
					resStr+=(i+1)+"등 "+res[i].title+"(+"+res[i].commcount+") ("+change+")<br/>";
				}
				preResult = res;
				$('#result').html(resStr);
			}
		})
	}
	setInterval(rankDiff, 10000);
</script>	
</body>
</html>