<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!-- 헤더 파일 넣기 -->
<%@ include file = "../includes/header.jsp" %>

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
                            게시글 목록	(<a href = "register" >게시글 쓰기</a>)
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>글 번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items = "${list}" var = "board">
                               		<tr>
                                		<td>${board.bno}</td>
                                        <td><a href = "get?bno=${board.bno}"><c:out value="${board.title}"/></a></td>
                                        <td><c:out value="${board.writer}"/></td>
                                        <td class="center"><fmt:formatDate value="${board.regdate}" pattern = "yyyy-MM-dd HH:mm"/></td>
                                        <td class="center"><fmt:formatDate value="${board.updatedate}" pattern = "yyyy-MM-dd HH:mm"/></td>
                                	</tr>
                                </c:forEach>                                  
                                </tbody>
                            </table>
                            <div class = "pull-right">
                            	<ul class = "pagination">
		                            <c:if test = "${pageMaker.prev}" >
		                            	<li class = "paginate_button">
		                            		<a href = "list?pageNum=${pageMaker.startPage-1}">이전</a>
		                            	</li>
		                            </c:if>
		                            <c:forEach begin = "${pageMaker.startPage}" end = "${pageMaker.endPage}" var = "num">
		                            	<li class = "paginate_button">
		                            		<a href = "list?pageNum=${num}&amount=${pageMaker.cri.amount}" class = "pButton" id = "${num}">${num}</a>
		                            	</li>
		                            </c:forEach>
		                            <c:if test = "${pageMaker.next}" >
		                            	<li class = "paginate_button">
		                            		<a href = "list?pageNum=${pageMaker.endPage+1}">다음</a>
		                            	</li>
		                            </c:if>
	                            </ul>
                            </div>
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
    
    <!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    	<div class="modal-dialog">
        	<div class="modal-content">
            	<div class="modal-header">
                 	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    	<h4 class="modal-title" id="myModalLabel">게시글 등록완료</h4>
                        	</div>
                            	<div class="modal-body" id = "modal-text">
                                </div>
                           	<div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
                     </div>
                 </div>
              <!-- /.modal-content -->
        	</div>
    	<!-- /.modal-dialog -->
	</div>
                            <!-- /.modal -->

      <!-- footer 파일 넣기 -->
<%@ include file = "../includes/footer.jsp" %>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
	    var status = "${status}";
	    var bno = "${result}";
	    var mText = $('#modal-text');
	    console.log(status);
	    if(status != ""){
	    	if(status === "modify success"){
	    		mText.html(bno + "번 게시글이 수정되었습니다.");
	    	}else if(status === "remove success"){
	    		mText.html(bno + "번 게시글이 삭제되었습니다.")
	    	}else if(status === "register success"){
	    		mText.html(bno+"번 게시글이 등록되었습니다.")
	    	}else{
	    		mText.html("몬가.. 잘못됐음..")
	    	}
	    	
	    	$('#myModal').modal('show');	    
	    }
	</script>
	<script>
		$(function(){
			var pnum = "${param.pageNum}";
			if(pnum == ""){
				pnum = 1;
			}
			$('#'+pnum).parent().attr("class", "active").change();			
		})
	</script>




</body>

</html>
