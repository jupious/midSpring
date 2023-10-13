<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="uploadFormAction" method="post" enctype="multipart/form-data">
	<input type="file" name="uploadfile" multiple />
	<button>업로드</button>
</form>
<script src="https://code.jquery.com/jquery-3.7.1.js" 
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" 
	crossorigin="anonymous"></script>

<script>
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
		$("button").on("click", function(e){
			e.preventDefault;
			console.log("버튼 눌림");
			var inputFiles = $('input[name="uploadfile"]');
			var file = inputFiles[0].files;
			console.log("업로드할 파일 정보",file);	
			console.log("inputFiles",inputFiles);
			//가상 폼에 전송데이터 추가
			var totalSize = 0;
			for(var i = 0; i < file.length; i++){
				if(!checkExtension(file[i].name, file[i].size)){
					return false;
				}
				totalSize += file[i].size;
			}
			if(totalSize > (1024*1024*10)){
				var sizeNow = (totalSize/(1024*1024)).toFixed(1);
				alert("최대로 올릴수 있는 파일크기의 총합은 10MB입니다! (현재 " + sizeNow +"MB)");
				return false;
			}
			$("form").submit();
		})
	})
</script>
</body>
</html>