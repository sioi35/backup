<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>
	.container{ width: 600px; }
</style>

</head>
<body>
	<!-- join.jsp -->
	<div class="container">
		<h1 class="page-header">회원가입</h1>
		<form method="POST" action="/jsp/practice/joinok.do">
			<table class="table table-bordered" style="width:300px;">
				<tr>
					<th>ID</th>
					<td><input type="text" name="id" class="form-control" required></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="pw" class="form-control" required></td>
				</tr>
				<tr>
					<th>Name</th>
					<td><input type="text" name="name" class="form-control" required></td>
				</tr>
				<tr>
					<th>TEL</th>
					<td><input type="password" name="tel" class="form-control" required></td>
				</tr>
				<tr>
					<th>Birth</th>
					<td><input type="password" name="birth" class="form-control" required></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="Join" class="btn btn-default">
				<input type="button" value="Main" class="btn btn-default" onclick="history.back();">
			</div>
		</form>
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>