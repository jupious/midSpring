<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.7.1.js" ></script>
</head>
<body>
    ajax test
    <script>
        $.ajax({
            url:"/ajax.test", //필수
            type:"put",
            data:JSON.stringify({num1:3, num2:4}), //보내는 데이터(언제나 파라미터 형태 - a=3&b=4) 원하는 형태로 보내기위해서는 그 형태로 만들어야함
            //dataType: //받는 데이터타입(자동으로 처리됨-보통은 굳이 적을 필요없음)
            contentType:"application/json;charset=UTF-8",	//기본값은 application/x-www-form-urlencoded; charset=UTF-8
            												//스프링에서는 파라미터전송 메소드의 파라미터로 선언해서 수집가능
            												//스프링에서 json데이터 전송은 파라미터에 @RequestBOdy어노테이션을 이용
            												//(ex> @RequestBody NumVO vo)
            success:function(result){ //필수(없어도 동작은 되지만 성공해도 아무것도 안함)
                console.log("ajax요청 성공 ");
            },//function
            error:function(er){
                console.log("ajax요청실패");
            }
        })//ajax
    </script>
</body>
</html>