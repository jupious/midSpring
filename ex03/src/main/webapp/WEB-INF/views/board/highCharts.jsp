<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>highCharts</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/series-label.js"></script>

  
</head>
<body>
<div id="container" style="width:100%; height:400px;"></div>
<script src="https://code.jquery.com/jquery-3.7.1.js" ></script>
 <figure>
      <div class="container-fluid">
          <div class="row">
              <div class="container-fluid" id="container"></div>
          </div>
      </div>
 </figure>
<script>
	var chart;
	
	

	
	$(function(){
		Highcharts.setOptions({
			 global: {
		        	useUTC:false,
		        }
		})
		chart = new Highcharts.Chart({
	        chart: {
	            renderTo: 'container',
	            defaultSeriesType: 'spline',
	            events: {
	                load: getData
	            }
	        },
	        title: {
	            text: '실시간 작성 댓글수(아직은 누적댓글)'
	        },
	        xAxis: {
	            type: 'datetime',
	            tickPixelInterval: 150,
	            maxZoom: 20 * 1000,
	            labels:{
	            	style:{
		            	fontsize: '20px'
		            }	
	            }
	            
	        },
	        yAxis: {
	            minPadding: 0.2,
	            maxPadding: 0.2,
	            title: {
	                text: '단위(개)',
	                margin: 80
	            }
	        },
	        series: [{
	            name: '댓글 수',
	            data: []
	        }],
	        accessibility: {
	            enabled: false
	         }
	        
	    });
		
	})
	
	function getData(){
			setInterval(function(){
				$.ajax({
					type:"get",
					url:"/myapi/commentsTodayCount",
					success:function(res){
						console.log("갯수, 시간"+res.data+res.dateTime);
						var series = chart.series[0],
							shift = series.data.length > 20;
// 						var time = res.dateTime+(1000*60*60*9);
// 						time = new Date(time);
// 						time=time.toISOString();
						time = new Date(res.dateTime).toISOString;
						timetest = res.dateTime/1000;
						console.log("시간테스트",timetest)
						console.log(time);
						chart.series[0].addPoint([res.dateTime,res.data], true, shift);
						
						
					},
					error:function(er){
						console.log("에러발생");
						console.log(er);
					},
					cache: false
				});
			},1000);
		}
	
</script>
<script>

</script>
</body>
</html>