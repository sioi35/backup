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

</style>

</head>
<body>
	<!-- ex11_out.jsp -->
	<div class="container">
		<h1 class="page-header">구구단</h1>
		
		<%
			int dan = 5;
		%>
		
		<% for(int i=1; i<=9; i++){ %>
		<div><%= dan %> x <%= i %> = <%= dan * i %></div>
		<% } %>
		
		<hr>
		
		<%
			for( int i=1; i<=9; i++){
				out.println(String.format("<div>%d x %d = %d</div>", dan, i, dan*i));
			}
		%>
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>