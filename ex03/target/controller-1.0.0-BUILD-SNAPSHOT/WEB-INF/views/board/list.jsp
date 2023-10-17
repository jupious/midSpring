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
                            게시글 목록     
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                 			<p class = "text-right">(댓글이 있는 게시글 숫자 : <span id = "postCount"></span>)</p>
                 			<P class = "text-right">(가장 많은 댓글이 있는 게시글 번호 : <span id = "commRank"></span>)</p>
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
                                        <td><a href = "get?bno=${board.bno}&pageNum=${pageMaker.cri.pageNum}&amount=${pageMaker.cri.amount}"><c:out value="${board.title} [${board.commcount}]"/></a></td>
                                        <td><c:out value="${board.writer}"/></td>
                                        <td class="center"><fmt:formatDate value="${board.regdate}" pattern = "yyyy-MM-dd HH:mm"/></td>
                                        <td class="center"><fmt:formatDate value="${board.updatedate}" pattern = "yyyy-MM-dd HH:mm"/></td>
                                	</tr>
                                </c:forEach>                                  
                                </tbody>
                            </table>
                     
                            <%-- 페이지바 시작 --%>
                            <div class = "pull-right">
                            	<ul class = "pagination">
		                            <c:if test = "${pageMaker.prev}" >
		                            	<li class = "paginate_button">
		                            		<a href = "list?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">이전</a>
		                            	</li>
		                            </c:if>
		                            <c:forEach begin = "${pageMaker.startPage}" end = "${pageMaker.endPage}" var = "num">
		                            	<li class = "paginate_button">
		                            		<a href = "list?pageNum=${num}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}" class = "pButton" id = "${num}">${num}</a>
		                            	</li>
		                            </c:forEach>
		                            <c:if test = "${pageMaker.next}" >
		                            	<li class = "paginate_button">
		                            		<a href = "list?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">다음</a>
		                            	</li>
		                            </c:if>
	                            </ul>
                            </div>
                            <%-- 페이지바 끝 --%>
                            <%-- 검색바 시작 --%>
                           	<form action = "list" method = "get" >
                           		<select name = "type" id = "type" class ="form-control input-sm" style="width:20%;">
                           			<option value = "T">제목</option>
                           			<option value = "C">내용</option>
                           			<option value = "W">작성자</option>
                           			<option value = "TC">제목+내용</option>
                           			<option value = "TW">제목+작성자</option>
                           			<option value = "CW">내용+작성자</option>
                           			<option value = "TCW">제목+내용+작성자</option>
                           		</select>
                           		 <div class = "input-group custom-search-form" style="width:20%;" >
                            		<input class = "form-control" type = "text" name = "keyword" id = "keyword" value = "${pageMaker.cri.keyword}"/>
                            		<span class = "input-group-btn">
	                            		<button type="submit" class="btn btn-default" type="button" id = "search"><i class="fa fa-search"></i></button>
                            		</span>
                           		</div>
                           	</form>
            				<%-- 검색바 끝 --%>
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
	<script>
		$(function(){
			var type = "${pageMaker.cri.type}";
			if(type == ""){
				type = "T";
			}
			$('#type option[value ='+type+']').prop('selected','selected').change();
		})
	</script>
	<script>
		$(function(){
			$('#search').click(function(e){
				e.preventDefault;
				if(!$('#keyword').val())
					alert('검색어를 입력해주세요!');
			})
		})
	</script>

	<script>
		$(function (){
			$.ajax({
				type: "get",
				url: "/myapi/replybnocount",
				success:function(result){
					console.log("갯수 가져오기 성공");
					$('#postCount').html(result);
				},
				error:function(){
					console.log("갯수 가져오기 오류");
					
				}
			})
		})
	</script>
	
		<script>
		$(function (){
			$.ajax({
				type: "put",
				url: "/myapi/bestbno",
				success:function(result){
					console.log("글번호 가져오기 성공");
					console.log("bestbno 응답:",result);
					$('#commRank').html(result.bno);
				},
				error:function(){
					console.log("글번호 가져오기 오류");
					
				}
			})
		})
	</script>
	
	<script>
		var pageNum = "${param.pageNum}";
		var amount = "${param.amount}";
		if(pageNum === "")
			pageNum = 1;
		if(amount === "")
			amount = 10;
		$(function (){
			
			$.ajax({
				type:"get",
				url: "/myapi/board/"+pageNum+"/"+amount,
				success:function(result){
					console.log("글목록 가져오기 성공");
					console.log("가져온 데이터 : ",result);
					
				},
				error:function(){
					console.log("글목록 가져오기 오류");
				}
			})
		})
	</script>



</body>

</html>
