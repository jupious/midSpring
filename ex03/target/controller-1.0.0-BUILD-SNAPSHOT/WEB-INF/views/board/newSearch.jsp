<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>newSearch</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" ></script>
</head>
<body>

	페이지 번호 : <input type="number"  id = "pageNum" /><br/>
	보여줄 개수 : <input type = "number"  id = "amount" /><br/>
	검색할 종류 : <select name = "type" id = "type" class ="form-control input-sm" style="width:20%;">
                           			<option value = "T">제목</option>
                           			<option value = "C">내용</option>
                           			<option value = "W">작성자</option>
                           			<option value = "TC">제목+내용</option>
                           			<option value = "TW">제목+작성자</option>
                           			<option value = "CW">내용+작성자</option>
                           			<option value = "TCW">제목+내용+작성자</option>
                  </select><br/>
    검색할 내용 : <input type = "text" name = "keyword" id = "keyword" required/><br/>
    <input type = "button" value = "확인" id = "search" /><br/>
    제목 <br/>

    <ol id = "result">
    </ol>



<script>
	$(function(){
		var pageNum;
		var amount ;
		$('#search').on("click", function(e){
			e.preventDefault;
			console.log("검색버튼 클릭됨");
			pageNum = $('#pageNum').val();
			amount = $('#amount').val();
	
			var data = {type:$('#type').val() ,keyword:$('#keyword').val()};
			console.log(data);
			$.ajax({
				type: "post",
				url: "/myapi/board/"+pageNum+"/"+amount,
				data:JSON.stringify(data),
				contentType:"application/json;charset=UTF-8",
				success:function(result){
					console.log("결과 가져오기 성공");
					var resStr = "";
					for(var i = 0; i < result.length; i++){
						resStr += "<li>"+result[i].title+"</li>";
					}
					$('#result').html(resStr);
				},
				error:function(){
					console.log("결과 가져오기 오류");
					
				}
			})
		})
	})
</script>
</body>
</html>