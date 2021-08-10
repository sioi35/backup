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
	<!-- loginok -->
	<div class="container">
		<h1 class="page-header"></h1>
		<!--  
			이 페이지에서 할 일
			1. 로그인 성공 > 리스트 보여주기
			2. 로그인 실패 > 로그인 창
		-->
		
		
	</div>
	
	<script>
		
		<c:if test="${not empty id}">
			alert('로그인 성공');
			location.href = '/jsp/practice/list.do';
		</c:if>
		
		<c:if test="${empty id}">
			alert('로그인 실패');
			history.back();
			</c:if>
		
		
	
	</script>		
</body>
</html>