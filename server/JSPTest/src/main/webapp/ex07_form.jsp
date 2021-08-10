<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>
	
	.btns { 
		margin: 20px 0;
	}
	
	.btn {
		background-color: rgb(83, 187, 97);
		color: white;
	}
	.table { 
		width: 600px; 
	}
	
	.table tr, .table th, .table td{
		border: 1px solid #ddd;
	}
	
	.table th{
		width: 100px;
		text-align: center;
	}
	
	.table td{
		width: 300px;
	}
	
	.form-width1{
		width: 150px;
	}
	
	
	.form-width2{
		width: 250px;
	}
	
	.form-width3{
		width: 80px;
	}
	
</style>

</head>
<body>
	<!-- ex07_form.jsp -->
	<div class="container">
	
		<h1 class="page-header">버튼 만들기</h1>
		
		<form method="GET" action="ex07_ok.jsp">
		
			<table class="table table-border">
				<tr>
					<th>너비(px)</th>
					<td><input type="number" name="width" class="form-control form-width1"></td>
				</tr>
				<tr>
					<th>높이(px)</th>
					<td><input type="number" name="height" class="form-control form-width1"></td>
				</tr>
				<tr>
					<th>텍스트</th>
					<td><input type="text" name="text" class="form-control form-width2"></td>
				</tr>
				<tr>
					<th>배경색</th>
					<td><input type="color" name="bgcolor" class="form-control form-width3"></td>
				</tr>
				<tr>
					<th>글자색</th>
					<td><input type="color" name="fontcolor" class="form-control form-width3"></td>
				</tr>
				<tr>
					<th>글자 크기(px)</th>
					<td><input type="number" name="size" class="form-control form-width1" ></td>
				</tr>
				<tr>
					<th>버튼 개수(ea)</th>
					<td><input type="number" name="btnnum" class="form-control form-width1"></td>
				</tr>
				<tr>
					<th>버튼 간격</th>
					<td>
					좌우 간격: </br>
						<input type="range" name="range1" >
					상하 간격: </br>
						<input type="range" name="range2">
					</td>
				</tr>
<!-- 				<tr>
					<th>아이콘</th>
					<td></td>
				</tr>
				<tr>
					<th>테두리</th>
					<td></td>
				</tr> -->
			
			</table>
			
			<div class="btns">
            	<input type="submit" value="만들기" class="btn btn-default">
         	</div>
		
		</form>
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>