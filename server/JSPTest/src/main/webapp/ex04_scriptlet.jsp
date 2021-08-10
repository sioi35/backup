<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.Random"%>
<%@page import="com.test.jsp.Ex05"%>

<%

	Random rnd = new Random();

	int dan = rnd.nextInt(9) + 1;

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex04_scriptlet.jsp -->
	
	<h1>구구단 <small><%= dan %>단</small></h1>


	<!-- 
		서로 다른 언어(구문)이 뒤섞여 있는 상태
		- 스파게티 코드, Spaghetti Code
		- 좋은 상태는 아니다!(가독성 저하)
		
		JSP에서는 흔하게 볼 수 있는 상태
		
		Servlet+JSP -> 스파게티 최소화!
		
	 -->
	<% for(int i=1; i<=9; i++){%>
	<div><%= dan %> x <%= i %> = <%=dan * i %></div>
	<% } %>
	
	
	<%-- JSP 주석 
		The method sum(int, int) is undefined
	--%>
	<%-- <div><%= sum(100, 200) %></div> --%>
	
	<% 
		Ex05 ex05 = new Ex05();
	%>
	
	<%= ex05.sum(100,200) %>
	
	
	
</body>
</html>