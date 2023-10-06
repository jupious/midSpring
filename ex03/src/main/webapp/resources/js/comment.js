console.log("댓글처리하는 자바스크립트 작동");
var commentService = (function(){ 
	
	//댓글등록
	function add(comment,callback,error){
		console.log("댓글 등록.......");
		$.ajax({ 
			type: "post",
			url: "/comments/new",
			data: JSON.stringify(comment),     //json 형태로 리플데이터
			contentType:"application/json;charset=UTF-8",
			success:function(result,status,xhr){
				console.log("댓글등록 정상처리");
				if(callback)
					callback(result);
			},
			error:function(xhr,status,er){
				console.log("댓글등록 처리 실패");
				if(error)
					error(er);
			}
		 })
	}
	
	//댓글목록
	function getList(bno,callback,error){
	console.log("댓글 목록보기......");
/*		$.ajax({ 
			type: "get",
			url: "/comments/pages/"+bno+".json",
			success:function(result,status,xhr){
				console.log("댓글목록 가져오기 정상처리");
				if(callback)
					callback(result);
			},
			error:function(xhr,status,er){
				if(error)
					error(er);
			}
		 }) */
	//$.getJSON(요청주소,성공시처리할함수).fail(실패시처리할함수);	 
	$.getJSON("/comments/pages/"+bno+".json", function(result){
				console.log("댓글목록 가져오기 정상처리");
				if(callback)
					callback(result);
			}).fail(function(xhr,status,er){
				console.log("댓글목록 가져오기 오류발생");
				if(error)
					error(er);
			} ); //fail
		 
	}; //getList
	
	//댓글삭제
	function del(cno,callback,error){
		console.log("댓글 삭제.......");
		$.ajax({ 
			type: "delete",
			url: "/comments/"+cno,
			success:function(result,status,xhr){
				console.log("댓글삭제 성공");
				if(callback)
					callback(result);
			},
			error:function(xhr,status,er){
				console.log("댓글삭제 오류발생");
				if(error)
					error(er);
			}
		 })
	}


	//댓글수정
	function modify(cno,text,callback,error){
		console.log("댓글 수정.......");
		$.ajax({ 
			type: "put",
			url: "/comments/"+cno,
			data: JSON.stringify(text),     //json 형태로 리플데이터
			contentType:"application/json;charset=UTF-8",
			success:function(result,status,xhr){
				console.log("댓글수정 정상처리");
				if(callback)
					callback(result);
			},
			error:function(xhr,status,er){
				console.log("댓글수정 오류발생");
				if(error)
					error(er);
			}
		 })
	}
	//댓글1개가져오기
	function get(cno,callback,error){
		console.log("댓글 1개 가져오기......?.");
		$.ajax({ 
			type: "get",
			url: "/comments/"+cno+".json",
			success:function(result,status,xhr){
				console.log("댓글1개 가져오기 정상처리");
				if(callback)
					callback(result);
			},
			error:function(xhr,status,er){
				console.log("댓글1개 가져오기 오류발생");
				if(error)
					error(er);
			}
		 })
	}	

	//댓글 추천
	function like(cno,callback,error){
		console.log("댓글추천함..");
		$.ajax({
			type: "put",
			url: "/comments/like/"+cno,
			success:function(result,status,xhr){
				console.log("댓글 추천성공");
				if(callback)
					callback(result);
			},
			error:function(xhr,status,er){
				console.log("댓글 추천오류");
				if(error)
					error(er);
			}
		})
	}
	//날짜포맷 처리 함수
	function displayTime(timeValue, timenow){
		
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth()+1;
		var date = dateObj.getDate();
		var day = dateObj.getDay();
		var hour = dateObj.getHours();
		var minute = dateObj.getMinutes();
		var second = dateObj.getSeconds();
		var ms = dateObj.getMilliseconds();
		var nowDateObj = new Date(nowDateObj);
		var nowYear = nowDateObj.getFullYear();
		var nowMonth = nowDateObj.getMonth();
	
		var gap = timenow - timeValue;
		var secGap = gap/1000;
		var minGap = gap/(1000*60);
		var hourGap = gap/(1000*60*60);
		var dateGap = gap/(1000*60*60*24);
		var monthGap = nowMonth - month;
		var yearGap = nowYear - year;
		
		console.log(gap);
		console.log(hourGap);
		console.log("몇일차",dateGap);
		secGap = Math.floor(secGap);
		minGap = Math.floor(minGap);
		hourGap = Math.floor(hourGap);
		dateGap = Math.floor(dateGap);
		
		//return year+"-"+month+"-"+date+" "+hour+":"+minute+":"+second;
		//return hourGap + "시간 전";
		if(yearGap > 0){
			return yearGap + "년 전";
		}else if(monthGap > 0){
			return monthGap + "달 전";
		}else if(dateGap > 0){
			return dateGap + "일 전";
		}else if(hourGap > 0){
			return hourGap + "시간 전";
		}else if(minGap > 0){
			return minGap + "분 전";
		}else{
			return secGap + "초 전";
		}
		
	}

	//  이름 : 값(함수명)
	return {add:add, getList:getList,del:del,modify:modify, get:get, like:like, time:displayTime};
})();