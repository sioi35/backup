<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	/* CSS 영역 */
</style>
<script>
	//JavaScript 영역
</script>
</head>
<body>
	<h1>JSP 페이지</h1>
	<p>안녕하세요.</p>
	
	<%
		//Java 영역
		Calendar now = Calendar.getInstance();
		
	%>
	
	<p>현재 시각: <%= now.get(Calendar.HOUR) %>시</p>
	
		
	
	
</body>
</html>