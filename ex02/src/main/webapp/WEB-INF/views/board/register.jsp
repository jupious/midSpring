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

    <!-- jQuery -->
    <script src="/resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>

</body>

</html>
