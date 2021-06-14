<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- webapp > ex19ok.jsp -->
	
	<h1>결과</h1>


	<%
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data");
	%>
	
	<div>데이터: <%= data %></div>


</body>
</html>