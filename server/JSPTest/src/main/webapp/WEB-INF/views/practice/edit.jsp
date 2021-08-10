<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>

</style>

</head>
<body>
	<!-- edit.jsp -->
	<div class="container">
		<h1 class="page-header">정보 수정</h1>
		
		<form method="POST" action="/jsp/practice/editok.do">
			<table class="table table-bordered" style="width:300px;">
				
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" class="form-control" value="${result.name}"></td>
				</tr>
				<tr>
					<th>TEL</th>
					<td><input type="text" name="tel" class="form-control" value="${result.tel}"></td>
				</tr>
				<tr>
					<th>Birth</th>
					<td><input type="text" name="birth" class="form-control" value="${result.birth}"></td>
				</tr>
			</table>
			
			<input type="hidden" name="id" value="${result.id}">
			<div>
				<input type="submit" value="Edit" class="btn btn-default">
				<input type="button" value="Main" class="btn btn-default" onclick="history.back();">
			</div>
			
		</form>
		
		
		
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>