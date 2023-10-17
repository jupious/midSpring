<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>
<style>
	.over{
		z-index: 0;
	}
	.origin{
		position:absolute;
		z-index: 1;
	}
</style>
</head>
<body>
<div class = "uploadDiv">
	<input type="file" name="uploadfile" multiple /><br/>
</div>
<button type="button" id = "btn">업로드</button>
<ul class = "uploadResult">
</ul>

<script>
	//파일 용량제한 및 확장자 제한
						  //모든문자.exe/sh/zip/alz (.을 문자로 인식시키기 위해 \사용)
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 1024*1024*5; //5MB
	
	
	function checkExtension(fileName, fileSize){
		if(fileSize >= maxSize){
			alert("파일 용량제한 초과(파일 1개당 5MB)");
			return false;
		}
		if(regex.test(fileName)){
			alert("파일 종류 오류");
			return false;
		}
		return true;
	}

	$(function(){
		//초기화를 위해 최초 파일선택부분 복사
		var cloneObj = $('.uploadDiv').clone();
		
		$('#btn').on("click", function(){
			console.log("버튼 눌림");
			var formData = new FormData(); //가상폼
			var inputFiles = $('input[name="uploadfile"]');
			var file = inputFiles[0].files;
			console.log("업로드할 파일 정보",file);	
			console.log("inputFiles",inputFiles);
			//가상 폼에 전송데이터 추가
			var totalSize = 0;
			var fileCount = file.length;
			if(fileCount > 5){
				alert("파일은 한번에 최대 5개까지만 업로드 가능합니다! (현재"+fileCount+"개)");
				return false;
			}
			for(var i = 0; i < fileCount; i++){
				if(!checkExtension(file[i].name, file[i].size)){
					return false;
				}
				totalSize += file[i].size;
				formData.append("uploadfile", file[i]);
			}
			if(totalSize > (1024*1024*20)){
				var sizeNow = (totalSize/(1024*1024)).toFixed(1);
				alert("최대로 올릴수 있는 파일크기의 총합은 20MB입니다! (현재 " + sizeNow +"MB)");
				return false;
			}
			$.ajax({
				url:"uploadAjaxAction",
				type:"post",
				data:formData,
				processData:false, //파일전송을 위해
				contentType:false, //파일전송을 위해2
				success:function(result){
					console.log("전송성공",result);
					$('.uploadDiv').html(cloneObj.html());
					alert("파일 업로드 성공!");
					var resStr = "";
					for(let i = 0; i < result.length; i++){
						resStr+="<li>클릭시 원본이미지<br/><img src = ";
						if(result[i].isImg){
							resStr+= '/display?fileName='+ result[i].uploadPath + "/s_" + result[i].uuid + "_" + result[i].fileName;
						}else{
							resStr+='../resources/sfile.png';
						}
						resStr += " class ='over'></img><div class = 'origin'></div><br/><a href = '/download?fileName="+result[i].uploadPath + "/" + result[i].uuid + "_" + result[i].fileName+"'>" + result[i].fileName + "</a> <span data-path='"+result[i].uploadPath + "/' data-name='"+ result[i].uuid + "_" + result[i].fileName+"' data-type='"+result[i].isImg+"'>X</span></li>";
					}
					$(".uploadResult").append(resStr);
					
				},
				error:function(e){
					console.log("업로드 실패",e);
				}
			});
		});
		
	})
	$('.uploadResult').on("click", ".over", function(){
		var url = $(this).attr("src");
		url = url.replace("s_","");
		console.log("url맞음??",url);
		if($(this).next().next().next().next().data("type")){
			console.log("이미지");
			$(this).next().html("<img src = "+url+"></img>");
		}
		
		
		
	})
	
	$('.uploadResult').on("click",".origin", function(){
		console.log("사라져라");
		$(this).children().remove();
	})
	
	$('.uploadResult').on("click","span", function(){
		var filePath = $(this).data("path");
		var type = $(this).data("type");
		var fileName = $(this).data("name");
		console.log("파일경로 : ",filePath);
		$.ajax({
			url:"/deleteFile",
			type:"post",
			data:{filePath:filePath, fileName:fileName, type:type},
			context:this,
			success:function(result){
				console.log("정상작동"+result);
				$(this).parent('li').remove();
				
			},
			error: function(er){
				console.log("에러발생",er);
			}
			
		})
	})
</script>
</body>
</html>