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
	<!-- user4.jsp -->
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
			
			//$(선택).함수();
			//- $(document).ready();
			//- $('#btn').click();
			
			//독립 함수
			$.ajax({
				type: 'GET', 
				url: '/ajax/user/count.action',
				success: function(result){
					$('#output').text(result);
				}
			});
			
		});
	
	
		
   </script>
</body>
</html>









