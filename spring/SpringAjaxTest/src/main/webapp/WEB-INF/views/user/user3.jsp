<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>

<style>
</style>

</head>
<body>
	<!-- user3.jsp -->
	<div class="container">
		<h1 class="page-header">Ajax</h1>

		<div id="output" class="alert alert-warning"></div>

		<div>
			<input type="button" id="btn" value="데이터 가져오기">
		</div>
		
		<hr>
		<h2>다른 업무</h2>

		<input type="text" class="form-control">

	</div>

	<script>
      
		$('#btn').click(function(){
			
			//1. XMLHttpRequest 객체를 생성한다.
			let ajax = new XMLHttpRequest();
			
			//2. 이벤트 매핑을 한다.
			ajax.onreadystatechange = function(){
				
				//ajax.status
				//	- 서버 응답 코드
				//	- 200: OK
				//	- 404: Page not found
				//	- 500: 서버측 에러
				
				$('#output').text('');
				if(ajax.readyState == 4 && ajax.status == 200){ //4. 데이터를 응답받으며 호출된다.
					//5. 서버로부터 응답받은 데이터
					$('#output').text(ajax.responseText);
					//document.title = ajax.status;
				}
				
			};
			
			//3. 연결 + 요청
			ajax.open('GET', '/ajax/user/count.action', true);
			//ajax.send("name=hong&age=20");
			
		});  
   
   </script>
</body>
</html>
















