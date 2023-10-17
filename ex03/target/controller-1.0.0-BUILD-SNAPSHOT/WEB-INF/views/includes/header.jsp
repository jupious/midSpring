<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>게시판 공사중</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="/resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="/resources/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="/resources/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    	#toTop{
    		position:fixed;
    		top:65%;
    		right:48px;
    	}
    	#toBottom{
    		position:fixed;
    		top:77%;
    		right:48px;
    	}
    	 #toList {
           
            position:fixed;
            top:70%;
            right:40px;
        }
        
    </style>

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="list" id = "top">스프링 게시판 프로젝트</a>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse collapse">
                    <ul class="nav" id="side-menu">
<!--                         <li class="sidebar-search"> -->
<!--                             <div class="input-group custom-search-form"> -->
<!--                                 <input type="text" class="form-control" placeholder="Search..."> -->
<!--                                 <span class="input-group-btn"> -->
<!--                                 <button class="btn btn-default" type="button"> -->
<!--                                     <i class="fa fa-search"></i> -->
<!--                                 </button> -->
<!--                             </span> -->
<!--                             </div> -->
<!--                             /input-group -->
<!--                         </li> -->
                        <li>
                            <a href="dash-board"><i class="fa fa-dashboard fa-fw"></i> 대쉬보드</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 차트<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="charts">Interesting Data</a>
                                </li>
<!--                                 <li> -->
<!--                                     <a href="/resources/pages/morris.html">Morris.js Charts</a> -->
<!--                                 </li> -->
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="list"><i class="fa fa-table fa-fw"></i> 게시판</a>
                        </li>
<!--                         <li> -->
<!--                             <a href="/resources/pages/forms.html"><i class="fa fa-edit fa-fw"></i> Forms</a> -->
<!--                         </li> -->
<!--                         <li> -->
<!--                             <a href="/resources/pages/login.html"><i class="fa fa-files-o fa-fw"></i> Login Page</a> -->
                        
<!--                         </li> -->
						<li>
							<a href="register"><i class = "fa fa-pencil"></i>&nbsp;글쓰러가기</a>
						</li>
						<li>
							<a href="/resources/pages/index.html">여백의 미</a>
						</li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
