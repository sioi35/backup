<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="com.test.jsp.jdbc.DBUtil"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%
	//할일
	//1. 데이터 가져오기(request.getParameter())
	//2. DB 작업 -> insert
	//3. 페이지 이동하기 -> todo_list.jsp
	
	request.setCharacterEncoding("UTF-8");
	String todo = request.getParameter("todo");
	
	//System.out.println(todo);
	
	String complete = "0";
	
	//regdate
	Calendar regdate = Calendar.getInstance();
	
	
	Connection conn = null;
	Statement stat = null;
	int result = -1;
	
	try{
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
		String sql = String.format("insert into tblTodo (seq, todo, complete, regdate) values (seqTodo.nextVal, '%s', '%s', to_char(sysdate, 'yyyy-mm-dd'))", todo, complete);

		result = stat.executeUpdate(sql); //1(성공), 0(실패)
		
		//System.out.println(todo + " " + complete);
		
		stat.close();
		conn.close();
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	
	if(result == 1){
		response.sendRedirect("/jsp/todo/todo_list.jsp");
	}else {
		response.sendRedirect("/jsp/todo/todo_add.jsp");
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
	<!-- todo_addok.jsp -->
	

</body>
</html>


