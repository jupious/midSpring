<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>Avoid!</title>
<style>
	.cont{
		text-align: center;
	}
	.center{
		width: 200;
		margin: 0 auto;
	}
	
	.btn{
		width: 50px;
		height: 50px;
	}
	#start{
		width: 100px;
		height: 40px;
	}
	.borderSt{
		border-radius: 10px;
		background-color: rgba(0,0,0,0);
	}
	
</style>
</head>
<body>
<div id = "input" class = "cont">
	<p>아이디는 공백으로만 이뤄질 수 없습니다</p>
	<input type="text" id = "id" />
	<button id ="getId" class = "borderSt" >아이디 입력</button>
</div><br/>
<div id = "gameContainer" class = "cont">
	<div id = "msg"></div>
	<button id = "start" class = "borderSt">게임 시작</button>
	<div id = "container">
	<div id = "score"></div>
	<table id = "tbl" class = "center">
	</table>
	<table id = "car" class = "center">
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
	<p></p>
	<div id = "#btnContainer">
	<button id="left" class = "btn borderSt">◀</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<button id="right" class = "btn borderSt" >▶</button>
	</div>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<script>

	var block = new Array();
	var count = -1;
	var nowPos = 3;
	var timer;
	var score = 0;
	var scoreBefore = 0;
	var speed = 110;

	var id;
	var regex = /^\s*$/;
	
	
	
	//시작시 초기화면 구성
	$(function(){
		$('#gameContainer').hide();
		$('#container').hide();
		getBlock();

	})
	
	//입력받은 아이디를 검사
	$('#getId').on("click", function(){
		var input = $('#id').val();
		if(input.match(regex)){
			alert('아이디에는 공백을 제외하고 적어도 1개의 문자가 있어야합니다');
		}else{
			id = input;
			$('#input').hide();
			$('#msg').html("<p>시작버튼 클릭시 3초뒤 게임이 시작됩니다!</p> <p>각 방향의 화살표 또는 좌우 방향키를 눌러 </p> <p>내려오는 장애물을 피하세요</p> <p>500점마다 가속됩니다</p>");
			$('#gameContainer').show();
			
		}
	})
	
	//시작버튼 클릭시 동작
	$("#start").on("click", function(){
		$('#score').html("Id : "+ id + "<br/> Score : 0");
		let tblInit = "";
		for(let i = 0; i < 7; i++){
			tblInit += "<tr height = '20'><td width = '5'>|</td><td width = '15'></td><td width = '5'>|</td><td width = '15'></td><td width = '5'>|</td><td width = '15'></td><td width = '5'>|</td></tr>"
		}
		$('#tbl').html(tblInit);
		$(this).hide();
		$('#msg').html(" <p>각 방향의 화살표 또는 키보드의 좌우 방향키를 눌러 </p> <p>내려오는 장애물을 피하세요</p><p>500점마다 가속됩니다</p>");
		setTimeout(()=> interv(), 3000);
		$('#container').show();
	})
	
	//왼쪽 이동 버튼클릭시 동작
	$('#left').on("click", function(){
		if(nowPos != 1){
			$('#'+nowPos).text("");
			nowPos -= 2;
			$('#'+nowPos).text("A");			
		}
	})
	
	//오른쪽 이동 버튼클릭시 동작
	$('#right').on("click", function(){
		if(nowPos != 5){
			$('#'+nowPos).text("");
			nowPos += 2;
			$('#'+nowPos).text("A");
		}
	})
	
	//장애물이동 등등
	function interv(){
		
		timer = setInterval(function(){

					$('#score').html("Id : "+ id + "<br/> Score : "+score);
					if(count > 6){
						if(nowPos == block[0] || nowPos == block[1]){
							console.log("으악");
							clearInterval(timer);
							$('#container').hide();
							alert("게임이 종료되었습니다! \n점수는 "+score +"점입니다");
							var data = {id:id, score:score};
							sendResult(data);
							return;
						}else{						
							getBlock();
							count = -1;
							score += 100;
														
							
						}
						this;
					}
					if(((score - scoreBefore) == 500) && speed > 60){
						scoreBefore = score;

						speed -= 10;
						console.log("현재속도 : ",speed, "현재점수 : ",score,"기록된 이전 점수 : ",scoreBefore );
						clearInterval(timer);
						interv();
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
		
		}, speed);
	}	
	
	//랜덤숫자(장애물의 위치) 비동기로 요청
	function getBlock(){
		$.ajax({
			url:"/laser",
			type:"post",
			success: function(res){
				block = [];
				for(let k = 0; k < 2; k++){
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
	
	//방향키바인딩
	$(document).keydown(function(e){
		 switch (e.which) {
	      case 37:
	        $('#left').trigger("click");
	        break;
	      case 39:
	        $('#right').trigger("click");
	        break;
	    }
	})
	
	
	//게임종료시 데이터전송
	function sendResult(data){
		console.log("보낼 데이터", data);
		$.ajax({
			url:"/rank",
			type:"post",
			data: JSON.stringify(data),
			contentType:"application/json;charset=UTF-8",
			success: function(res){
				location.reload();
			},
			error: function(){
				location.href = "/error";
			}
		})
	}
	
</script>
</body>
</html>