<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                            게시글 수정
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action = "modify" method = "post" >
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name = "title" id = "mtitle" required value="${board.title}">
                                            
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" placeholder="누구세요?"  required value="${board.writer}" readonly />
                                        </div>
              
                                        <div class="form-group">
                                            <label>내용 작성</label>
                                            <textarea class="form-control" rows="20" style = " resize: none;" id = "mcontent" name = "content" required>${board.content}</textarea>
                                        </div>
                                      	<input type = "hidden" value = "${board.bno}" name = "bno"  />
                                      	<input type = "hidden" value = "${cri.pageNum}" name = "pageNum"  />
                                      	<input type = "hidden" value = "${cri.amount}" name = "amount"  />
                                        <button type="button" class="btn btn-default" data-oper = "modify">수정완료</button>
                                        <button class = "btn btn-default" data-oper = "remove">삭제하기</button>
                                      	
                                    </form>
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                              <a href = "list?pageNum=${cri.pageNum}&amount=${cri.amount}" id = "toList"><button class="btn btn-primary btn-circle btn-xl"><i class="fa fa-list" ></i></button></a>
                                <!-- /.col-lg-6 (nested) -->
                            </div>
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
    
    <script>
    	$(function(){
    		var formObj = $('form');
			var oTitle = `<c:out value = "${board.title}" />`
			var oContent = `<c:out value = "${board.content}" />`
    		
    		$('button').on("click",function(e){
    			e.preventDefault;
    			var operation = $(this).data("oper");		
    			if(operation === 'remove'){
    				formObj.attr("action", "remove");
    				formObj.submit();
    			}else if(operation === "modify"){
    				console.log("수정버튼누름")
    				if((oTitle == $('#mtitle').val()) && (oContent == $('#mcontent').val())){
    					alert('수정된 내용이 없습니다..');
    				}else{
    					formObj.submit();
    				}
    			}
    				
    		})
    		
    	})
    </script>

</body>

</html>
