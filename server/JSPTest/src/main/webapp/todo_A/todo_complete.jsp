<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.test.jsp.jdbc.DBUtil"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%
	//할일
	//1. 데이터 가져오기(request.getParameter())
	//2. DB 작업 -> update
	//3. 페이지 이동하기 -> todo_list.jsp
		
	//데이터 가져오기
	String seq = request.getParameter("seq");
	String complete = request.getParameter("complete");
	complete = complete.equals("0") ? "1" : "0";
	
	//DB 작업
	Connection conn = null;
	PreparedStatement stat = null;
	
	try {
		
		String sql = "update tblTodo set complete = ? where seq = ?";
		
		conn = DBUtil.open();
		stat = conn.prepareStatement(sql);
		
		stat.setString(1, complete);
		stat.setString(2, seq);
		
		stat.executeUpdate();
		
		stat.close();
		conn.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
	response.sendRedirect("todo_list.jsp");
	
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
	<!-- todo_editok.jsp -->
	<div class="container">
		<h1 class="page-header"></h1>		
		
	</div>	
	
	<script>
		
	</script>
</body>
</html>















