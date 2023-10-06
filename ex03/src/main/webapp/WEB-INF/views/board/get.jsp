<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!-- 헤더 파일 넣기 -->
<%@ include file = "../includes/header.jsp" %>

<!--     Bootstrap Core CSS -->
<!--     <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet"> -->

<!--     MetisMenu CSS -->
<!--     <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet"> -->

<!--     Custom CSS -->
<!--     <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet"> -->

<!--     Custom Fonts -->
<!--     <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> -->

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">게시판</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            게시글 읽기
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name = "title" required value="${board.title}" readonly/>
                                            
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" placeholder="누구세요?" name = "writer" value="${board.writer}" readonly/>
                                        </div>
              
                                        <div class="form-group">
                                            <label>내용 작성</label>
                                            <textarea class="form-control" rows="3" style = " resize: none;" name = "content" required readonly>${board.content}</textarea>
                                        </div>
                                        <div class = "pull-right">
                                       <a href = "modify?bno=${board.bno}&pageNum=${cri.pageNum}&amount=${cri.amount}"><button class="btn btn-outline btn-warning">수정</button></a>
                                		</div>
                                </div>
                                
                                <!-- /.col-lg-6 (nested) -->
                              
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            
                            <!-- /.row (nested) -->
                        </div>
                        <div class="panel-heading">
                        댓글
                        </div>
                        <div class="panel-body">
                            <div class="row" id = "commentContainer">
                                
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            <div class="col-lg-6">
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" placeholder="누구세요?" name = "writer"  id = "writer" required/>
                                        </div>
                                        <div class="form-group">
                                            <label>댓글 내용</label>
                                            <textarea class="form-control" rows="3" style = " resize: none;" name = "text" id = "text" required ></textarea>
                                        </div>
                                        <input type = "hidden" name = "bno" value = "${board.bno}">
                                        <div class = "pull-right">
                                       		<button class="btn btn-outline btn-primary" id = "input">입력</button>
                                      	</div>
                                </div>
                                <a href = "#top" id = "toTop"><button class="btn btn-primary btn-circle btn-lg"><i class ="fa fa-arrow-up"></i></button></a>
                          		<a href = "list?pageNum=${cri.pageNum}&amount=${cri.amount}" id = "toList"><button class="btn btn-primary btn-circle btn-xl"><i class="fa fa-list"></i></button></a>
                              	<a href = "#input" id = "toBottom"><button class="btn btn-primary btn-circle btn-lg"><i class ="fa fa-arrow-down"></i></button></a>
                            <!-- /.row (nested) -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

         <!-- footer 파일 넣기 -->
<%@ include file = "../includes/footer.jsp" %>

	<%--댓글처리 자바 스크립트 --%>
	<script src="/resources/js/comment.js?ver=2"></script>
	<script>
		
// 		comment={text:"자바스크립트로 테스트",writer:"테스트43", bno:2457651  };
// 		commentService.add(comment);
// 		commentService.getList(2457651, function(a){console.log(a)} );
// 		commentService.del(2);
// 		commentService.modify(6,text);
//		commentService.get(6,function(a){console.log(a)});
	</script>
	
	<script>
	var ogText;
	
	function getComment(){
		console.log("목록 갱신");
		var bno = ${board.bno};
		commentService.getList(bno, function(comment){
			console.log(comment)
			var commStr="";
			for(var i = 0; i < comment.length; i++){
				var commText = comment[i].text;
				
				commStr += '<div class = "panel panel-default" style="width:50%;"><div class = "panel-heading commentHead">'+ comment[i].writer + '&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;'+commentService.time(comment[i].commdate, comment[i].timenow)+'<button class="pull-right btn btn-outline btn-primary btn-xs thumbs"><i class="fa fa-thumbs-o-up"></i>+'+comment[i].thumbsup+'</button></div><div class = "panel-body commentBody" ><pre>'+commText+'</pre></div><div class = " panel-footer commentFoot"><span hidden class = "cno">'+comment[i].cno+'</span> <input type="button" class="btn btn-outline btn-warning btn-xs modify" value = "수정" /> <input type="button" class="btn btn-outline btn-danger btn-xs delete"  value = "삭제" /> </div></div>';
				console.log("추천수",comment[i].thumbsup);
			}
			$('#commentContainer').html(commStr);
		});
	}
	
	$(function(){
		getComment();
		
		
		
	});
	
	$('#input').on("click", function(){
			var bno = ${board.bno};
			var writer = $('#writer').val();
			var text = $('#text').val();
			var comment = {text:text, writer:writer, bno:bno};
			$('#writer').val("");
			$('#text').val("");
			commentService.add(comment, getComment);
	});
	
	$('#commentContainer').on("click", ".delete", function(){
		var cno = $(this).prev().prev("span").text();
		console.log("cno =",cno);
		var pw = prompt("삭제하시려면 비밀번호를 입력해주세요.");
		if(pw == 1234){
			commentService.del(cno, getComment);
		}else{
			alert("비밀번호가 잘못되었습니다!");
		}
		
	});
	
	$('#commentContainer').on("click", ".modify", function(){
		var cno = $(this).prev("span").text();
		console.log("cno =",cno);
		var text = $(this).parent().prev(".commentBody").children();
		ogText = text.text();
		text.parent().html('<input class="form-control" id = "modifing" value = "'+ogText+'" />').children().focus();
		$(this).hide();
		$(this).next().hide();
		$(this).parent().append('<button class="btn btn-outline btn-primary btn-xs modConfirm" onclick="mod('+cno+')" id="'+cno+'">수정완료</button>');
	}); ///abc
	
	function mod(cno) {
		var id = $('#'+cno);
		var modText = id.parent().prev().children().val();
		console.log(modText);
		console.log(cno);
		if(ogText == modText){
			getComment();
			console.log("수정안했지롱");
		}else{
			var text = {text:modText};
			console.log(text);
			commentService.modify(cno,text,getComment);
		}
		
		
	}
	
	$('#commentContainer').on("click", ".thumbs", function(){
		console.log("추천눌림");
		var cno = $(this).parent().next().next().children("span").text();
		console.log(cno);
		commentService.like(cno,getComment);
	})
		
	</script>
</body>

</html>
