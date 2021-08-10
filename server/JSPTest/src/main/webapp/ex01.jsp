<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.util.Scanner, java.util.Calendar" %>
<%@ page import="java.util.*" %>
<%@ page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex01.jsp -->
	
	<div><%@ include file="inc/menu.jsp" %></div>

	<%
		Random rnd = new Random();
	%>

	숫자: <%= 100 / rnd.nextInt(3) %>
	
	<div><%@ include file="inc/copyright.html" %></div>
</body>
</html>