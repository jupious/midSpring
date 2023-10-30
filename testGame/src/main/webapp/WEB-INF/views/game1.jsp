<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>랜덤한 위치에 나오는 버튼을 총 5번 누르면 됩니다</p>
<span></span>
<button id ="start">여기를 눌러 시작!</button>
<div id = "tbldiv">	
	<table>
		
	</table>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
	var count = 0;
	var stime;
	$(function (){
		list("");
	})
	
	function getButton(){
		var tblStr = "";
		var here = "  ";
		
		$.ajax({
			url:"/getPosition",
			type:"post",
			success: function(result){
				
				var rPos = result[0];
				var cPos = result[1];
				console.log("데이터 제대로받아옴",rPos,cPos);
				
				for(let i = 0; i < 20; i++){
					tblStr += "<tr id =" + i + "  height='25' >";
					for(let j = 0; j < 20; j++){
					if(i == rPos && j == cPos){
						here = "<button id = 'catch'>눌러!</button>";
					}else{
						here = "  ";
					}
					tblStr += "<td id =" + j + " width='25'>"+here+"</td>" 
					}
					tblStr += "</tr>";
				}
				$('table').html(tblStr);
				
			}
		})
	}
	$('table').on("click", '#catch', function(){
		console.log("잡았다",count);
		count += 1;
		if(count == 5){
			record();
		}else{			
			getButton();
		}
	})
	$('#start').on("click", function(){
		stime = new Date();
		getButton();
	})
	function record(){
		var etime = new Date();
		var rec = etime - stime;
		count = 0;
		$('table').empty();
		alert(rec/1000+"초 만에 버튼 5개를 누르셨습니다!");
		list(rec);
	}
	function list(rec){
		if(rec == ""){
			rec = -1;
		}
		$.ajax({
			url:"/getRecords/"+rec,
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
					recStr += "<p>"+Number(k+1)+"등 "+result[k]/1000+"ms</p>";
				}
				$('span').html(recStr);
			}
		})
	}
</script>
</body>
</html>