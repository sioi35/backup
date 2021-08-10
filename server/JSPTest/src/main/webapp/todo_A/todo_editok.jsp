<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.test.jsp.jdbc.DBUtil"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%
	//할일
	//1. 데이터 가져오기(request.getParameter())
	//2. DB 작업 -> update
	//3. 페이지 이동하기 -> todo_list.jsp
	
	//인코딩
	request.setCharacterEncoding("UTF-8");
	
	//데이터 가져오기
	String seq = request.getParameter("seq");
	String todo = request.getParameter("todo");
	
	//DB 작업
	Connection conn = null;
	PreparedStatement stat = null;
	int result = -1;
	
	try {
		
		String sql = "update tblTodo set todo = ? where seq = ?";
		
		conn = DBUtil.open();
		stat = conn.prepareStatement(sql);
		
		stat.setString(1, todo);
		stat.setString(2, seq);
		
		result = stat.executeUpdate();
		
		stat.close();
		conn.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
	
	if (result == 1) {
		response.sendRedirect("todo_list.jsp");
	} else {
		response.sendRedirect("todo_add.jsp");
	}
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















