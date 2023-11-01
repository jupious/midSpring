<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Avoid!</title>
</head>
<body>
<div id = "input">
	<input type="text" id = "id" />
	<button id ="getId">아이디 입력</button>
</div></br>
<div id = "gameContainer">
	<button id = "start">시작!</button>
	<div id = "container">
	<table id = "tbl">
	</table>
	<table id = "car">
		<tr height = '20'>
			<td id = '0' width = '5'>|</td>
			<td id = '1' width = '15'></td>
			<td id = '2' width = '5'>|</td>
			<td id = '3' width = '15'>A</td>
			<td id = '4' width = '5'>|</td>
			<td id = '5' width = '15'></td>
			<td id = '6' width = '5'>|</td>
		</tr>
	</table>
	<button id="left">◀</button>&nbsp;&nbsp;&nbsp;&nbsp;
	<button id="right">▶</button>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>
	var block = new Array();
	var count = -1;
	var nowPos = 3;
	var timer;
	var score = 0;
	var id;
	var regex = /^\s*$/;

	
	
	
	$(function(){
		$('#gameContainer').hide();
		$('#container').hide();
		getBlock();

	})
	
	$('#getId').on("click", function(){
		var input = $('#id').val();
		if(input.match(regex)){
			alert('아이디에는 공백을 제외하고 적어도 1개의 문자가 있어야합니다');
		}else{
			id = input;
			$('#gameContainer').show();
		}
	})
	
	$("#start").on("click", function(){
		interv();
		$('#container').show();
	})
	
	$('#left').on("click", function(){
		if(nowPos != 1){
			$('#'+nowPos).text("");
			nowPos -= 2;
			$('#'+nowPos).text("A");			
		}
	})
	$('#right').on("click", function(){
		if(nowPos != 5){
			$('#'+nowPos).text("");
			nowPos += 2;
			$('#'+nowPos).text("A");
		}
	})
	function interv(){
		
		timer = setInterval(function(){
				
					if(count > 6){
						if(nowPos == block[0] || nowPos == block[1]){
							console.log("으악");
							clearInterval(timer);
							$('#container').hide();
							var data = {id:id, score:score};
							sendResult(data);
							return;
						}else{						
							getBlock();
							count = -1;
							score += 100;
							console.log(score);
						}
						this;
					}
					var tblStr = "";
					for(let i = 0; i < 7; i++){
						tblStr+="<tr height = '20'>";
						for(let j = 0; j < 7; j++){
							if(j == 0 || j == 2 || j == 4 || j == 6){					
								tblStr+="<td width = '5'> | </td>";
							}else if((j == block[0] && i == count )|| (j == block[1] && i == count)){
								tblStr+="<td width = '15'>■</td>";
							}else{
								tblStr+="<td width = '15'></td>";
							}
						}
						tblStr+="</tr>";
					}
					count++;
					$('#tbl').html(tblStr);
		
		}, 80);
	}	
	
	function getBlock(){
		$.ajax({
			url:"/laser",
			type:"post",
			success: function(res){
				block = [];
				for(let k = 0; k < 2; k++){
					console.log("받은 값",res[k]);
					let b = res[k];
					if(b == 2){
						b+=3;
					}else if(b == 1){
						b+=2;
					}else{
						b+=1;
					}
					block.push(b);
				}
				
			}
			
		})
	}
	
	$(document).keydown(function(e){
		 switch (e.which) {
	      case 37:
	        console.log("왼쪽방향키 눌림");
	        $('#left').trigger("click");
	        break;
	      case 39:
		    console.log("오른쪽방향키 눌림");
	        $('#right').trigger("click");
	        break;
	    }
	})
	
	function sendResult(data){
		console.log("보낼 데이터", data);
		$.ajax({
			url:"/aaaa",
			type:"post",
			data: JSON.stringify(data),
			contentType:"application/json;charset=UTF-8",
			success: function(res){
				console.log("데이터 보내기 성공!!")
				location.reload();
			},
			error: function(){
				console.log("데이터 보내기 실패....")
				location.reload();
			}
		})
	}
	
</script>
</body>
</html>