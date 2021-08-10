<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.test.jsp.jdbc.DBUtil"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement"%>

<%
	//이 페이지가 할 일!!
	//1. 데이터 가져오기
	//2. DB -> update 실행
	//3. 페이지 이동하기 -> list.jsp
	
	//1.
	request.setCharacterEncoding("UTF-8");

	String seq = request.getParameter("seq");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String gender = request.getParameter("gender");
	String address = request.getParameter("address");
	
	
	//2. 
	Connection conn = null;
	Statement stat = null;
	int result = -1;
	
	try{
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
		String sql = String.format("update tblAddress set name = '%s', age = %s, gender = '%s', address = '%s' where seq = %s ", name, age, gender, address, seq);
		
		result = stat.executeUpdate(sql); //1(성공), 0(실패)
		
		
		stat.close();
		conn.close();
		
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	/*
	if(result == 1){
		response.sendRedirect("/jsp/jdbc/list.jsp");
	}else {
		response.sendRedirect("/jsp/jdbc/add.jsp");
	}
	*/
	
	
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
	<!-- edit.jsp -->
	<div class="container">
		<h1 class="page-header">Address Book</h1>
	</div>
	
	<script>
	
		<% if(result == 1) {%>
			//성공
			alert('수정 성공!!');
			location.href='/jsp/jdbc/list.jsp';
		<% } else {%>
			//실패
			alert('수정 실패;;');
			history.back();
		<% }%>
	
	</script>		
</body>
</html>