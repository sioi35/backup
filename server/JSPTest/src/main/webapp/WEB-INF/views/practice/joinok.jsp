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
	<!-- joinok.jsp -->
	<div class="container">
		<h1 class="page-header">회원가입</h1>
		
	</div>
	
	<script>
		<c:if test="${result == 1}">
			alert('가입성공');
			location.href = '/jsp/practice/login.do';
		</c:if>
		
		<c:if test="${result != 1}">
			alert('가입 실패');
			location.href = '/jsp/practice/main.do';
		</c:if>
	</script>		
</body>
</html>