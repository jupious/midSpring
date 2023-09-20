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
                                       <a href = "list?pageNum=${cri.pageNum}&amount=${cri.amount}"><button class="btn btn-outline btn-primary">목록</button></a>
                                		</div>
                                </div>
                                
                                <!-- /.col-lg-6 (nested) -->
                              
                                <!-- /.col-lg-6 (nested) -->
                            </div>
                            
                            <!-- /.row (nested) -->
                        </div>
                        <div class="panel-heading">
                        댓?글    
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <c:forEach items = "${commentList}" var = "comm">
                               		<div class = "panel panel-default" style="width:50%;">
                               			<div class = "panel-heading">
                               				${comm.writer} | <fmt:formatDate value="${comm.commdate}" pattern = "yyyy-MM-dd HH:mm"/>
                               			</div>
                               			<div class = "panel-body" >
                                			<pre><c:out value = "${comm.text}" /></pre>
	                                	</div>
	                                	<div class = " panel-footer">
	                                		<form action = "delComm" method ="post">
	                                			<input type="hidden" value = "${comm.cno}" name = "cno" />
	                                			<input type="hidden" value = "${board.bno}" name = "bno"/>
	                         
	                                			<input type="submit" class="btn btn-outline btn-warning btn-xs delComm"  value = "삭제" />
	                                		</form>
	                                	</div>
                               		</div>
                                	
                                </c:forEach>                          
                                <div class="col-lg-6">
                               		 <form role="form" action = "regComm" method = "post" >
                                        <div class="form-group">
                                            <label>작성자</label>
                                            <input class="form-control" placeholder="누구세요?" name = "writer"  required/>
                                        </div>
                                        <div class="form-group">
                                            <label>댓글 내용</label>
                                            <textarea class="form-control" rows="3" style = " resize: none;" name = "text" required ></textarea>
                                        </div>
                                        <input type = "hidden" name = "bno" value = "${board.bno}">
                                        <div class = "pull-right">
                                       		<button class="btn btn-outline btn-primary">입력</button>
                                       		
                                      	</div>
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

         <!-- footer 파일 넣기 -->
<%@ include file = "../includes/footer.jsp" %>
</body>

</html>
