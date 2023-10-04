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
                            게시글 쓰기
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-6">
                                    <form role="form" action = "register" method = "post" >
                                        <div class="form-group">
                                            <label>제목</label>
                                            <input class="form-control" name = "title" required>
                                            
                                        </div>
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" placeholder="누구세요?" name = "writer" required>
                                        </div>
              
                                        <div class="form-group">
                                            <label>내용 작성</label>
                                            <textarea class="form-control" rows="3" style = " resize: none;" name = "content" required></textarea>
                                        </div>
                                      
                                        <button type="submit" class="btn btn-default">작성</button>
                                        <button type ="button" class = "btn btn-default" id = "cancle">취소</button>
                                    </form>
                                    
                                </div>
                                <!-- /.col-lg-6 (nested) -->
                              
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
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
        	<div class="modal-content">
            	<div class="modal-header">
                 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    	<h4 class="modal-title" id="myModalLabel">취소 하시겠습니까?</h4>
                        	</div>
                            	<div class="modal-body" id = "modal-text">
                            		현재까지 작성한 내용은 저장되지 않습니다.
                                </div>
                           	<div class="modal-footer">
                        <button type="button" class="btn btn-default" id = "ok">확인</button>
                        <button type="button" class="btn btn-default" id = "mcancle">취소</button>
                     </div>
                 </div>
              <!-- /.modal-content -->
        	</div>
    	<!-- /.modal-dialog -->
	</div>

      <!-- footer 파일 넣기 -->
<%@ include file = "../includes/footer.jsp" %>
	
	<script>
		$(function (){
			$('#cancle').on("click",function(){
				$('#myModal').modal('show');	
			})
			$('#ok').on("click",function(){
				self.location = "list";
				return;
			})
			$('#mcancle').on("click",function(){
				$('#myModal').modal('hide');
				return;
			})
		})
	</script>
</body>

</html>
