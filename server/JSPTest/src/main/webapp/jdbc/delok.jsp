<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.test.jsp.jdbc.DBUtil"%>
<%
	
	//delok.jsp
	
	//할일
	//1. 삭제될 글번호 가져오기
	//2. DB -> delete
	//3. 페이지 이동하기 -> list.jsp
	
	String seq = request.getParameter("seq");
	
	Connection conn = null;
	Statement stat = null;
	int result = -1;
	
	try{
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
		
		String sql = "delete from tblAddress where seq = " + seq;
		
		
		result = stat.executeUpdate(sql);
	
		stat.close();
		conn.close();

	}catch(Exception e){
		System.out.println(e);
	}
	
	if(result == 1){
		response.sendRedirect("/jsp/jdbc/list.jsp");
	}else{
		response.sendRedirect("/jsp/jdbc/del.jsp");
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
	<!-- delok.jsp -->
	<div class="container">
		<h1 class="page-header"></h1>
	</div>
	
	<script>
	
	</script>		
</body>
</html>