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
	<!-- two.jsp -->
	<div class="container">
		<h1 class="page-header">두번째 페이지</h1>
		
		<input type="button" value="첫번째 페이지" onclick="location.href='one.jsp';">
		<input type="button" value="첫번째 페이지" onclick="history.back();">
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>