<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.test.jsp.jdbc.DBUtil"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement"%>
<%
	
	request.setCharacterEncoding("UTF-8");
	
	String seq = request.getParameter("seq");
	String todo = request.getParameter("todo");
	//String complete = request.getParameter("complete");
	
	
	//2. 
	Connection conn = null;
	Statement stat = null;
	int result = -1;
	
	try{
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
		String sql = String.format("update tblTodo set todo = '%s', complete= '0', regdate=to_char(sysdate, 'yy-mm-dd') where seq = %s", todo, seq);
		
		
		result = stat.executeUpdate(sql); //1(성공), 0(실패)
		
		
		stat.close();
		conn.close();
		
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	if(result == 1){
		response.sendRedirect("/jsp/todo/todo_list.jsp");
	}else {
		response.sendRedirect("/jsp/todo/todo_edit.jsp");
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
		
	<%-- 	<% if(result == 1) {%>
			//성공
			alert('수정 성공!!');
			location.href='/jsp/todo/todo_list.jsp';
		<% } else {%>
			//실패
			alert('수정 실패;;');
			history.back();
		<% }%> --%>
	
	</script>
</body>
</html>















