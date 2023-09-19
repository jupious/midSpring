<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>차트</title>

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

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);


      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['시간', '작성된 게시글 숫자'],
          <c:forEach items = "${list}" var = "pat">
          	["${pat.time}시", ${pat.count}],
          </c:forEach>

        ]);

        var options = {
      
       	  hAxis: {title: '시간'},
          vAxis: {minValue: 0}
          
        };

        var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
        	['작성자', '게시글 수'],
        	<c:forEach items = "${rankAll}" var = "all">
        		["${all.writer}", ${all.counter}],
        	</c:forEach>
        	]);

        var options = {
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);

      function drawVisualization() {

        var data = google.visualization.arrayToDataTable([
        	['작성자', '게시글 수', '평균 작성 글 수'],
        	<c:forEach items = "${rank}" var = "rank">
    			["${rank.writer}", ${rank.counter}, ${avg}],
    		</c:forEach>
        ]);

        var options = {

          seriesType: 'bars',
          series: {1: {type: 'line'}}
        };

        var chart = new google.visualization.ComboChart(document.getElementById('chart_div2'));
        chart.draw(data, options);
      }
    </script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          	['요일', '게시글 수'],
          	<c:forEach items = "${dayList}" var = "postday">
				["${postday.day}", ${postday.count}],
			</c:forEach>
        ]);

        var options = {
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
    </script>
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
                <a class="navbar-brand" href="list">스프링 게시판 프로젝트</a>
            </div>
            <!-- /.navbar-header -->
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="/resources/pages/index.html"><i class="fa fa-dashboard fa-fw"></i> 대쉬보드</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 차트<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="charts">Google Charts</a>
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
							<a href = "">여백의 미</a>
						</li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>
        
    
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
                            요일별 작성글 수 통계
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                   	    <div id="donutchart" style="width: 900px; height: 500px;"></div>
                        </div>
                        <div class="panel-heading">
                            시간별 작성된 게시글 수
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                   	    <div id="chart_div" style="width: 100%; height: 500px;"></div>
                        </div>
                         <div class="panel-heading">
                            작성자별 게시글 작성 수
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                   	     <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
                        </div>
                         <div class="panel-heading">
                            작성글수 랭킹 5위까지
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                   	     <div id="chart_div2" style="width: 100%; height: 500px;"></div>
                        </div>
                        
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
 
        </div>
        </div>
              <!-- footer 파일 넣기 -->
<%@ include file = "../includes/footer.jsp" %>
  </body>
</html>