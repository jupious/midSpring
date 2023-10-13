<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>

</head>
<body>

<input type="file" name="uploadfile" multiple /><br/>
<button type="button" id = "btn">업로드</button>

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
					alert("파일 업로드 성공!");
				},
				error:function(e){
					console.log("업로드 실패",e);
				}
			});
		});
		
		//form으로 전송
	})
</script>
</body>
</html>