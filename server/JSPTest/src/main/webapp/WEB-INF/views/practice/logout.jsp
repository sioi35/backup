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
	<!-- logout.jsp -->
	<div class="container">
		<h1 class="page-header">로그아웃</h1>
		
	</div>
	
	<script>
		alert('로그아웃 성공!');
		location.href='/jsp/practice/main.do';
	</script>		
</body>
</html>