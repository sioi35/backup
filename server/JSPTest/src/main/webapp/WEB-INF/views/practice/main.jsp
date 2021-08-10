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
	<!-- main.jsp -->
	<div class="container">
		<h1 class="page-header">메인화면(로그인/회원가입)</h1>
		<div>
			<input type="button" class="btn btn-default" value="로그인" onclick="location.href='/jsp/practice/login.do';">
			<input type="button" class="btn btn-default" value="회원가입" onclick="location.href='/jsp/practice/join.do';">
		</div>
		
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>