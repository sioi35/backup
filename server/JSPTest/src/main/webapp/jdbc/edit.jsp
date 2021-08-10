<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="com.test.jsp.jdbc.DBUtil"%>
<%
	
	//할일!!
	//1. 수정할 번호 가져오기
	//2. DB -> select where seq = 수정할 번호
	//3. ResultSet -> 폼태그 기본값으로 설정
	
	String seq = request.getParameter("seq");
	
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	String name ="";
	String age = "";
	String gender = "";
	String address = "";
	
	try{
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
		String sql = "select * from tblAddress where seq = " + seq;
		
		rs = stat.executeQuery(sql);
		
		if(rs.next()){
			name = rs.getString("name");
			age = rs.getString("age");
			gender = rs.getString("gender");
			address = rs.getString("address");
		}
		
		rs.close();
		stat.close();
		conn.close();
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>
	.container{ width: 600px; }
	.container .table th, .table td { text-align: center; 
						   vertical-align: middle; }
	.table th { width: 120px; }
	.table input[name=name]{ width: 100px;}
	.table input[name=age]{ width: 80px;}
	.table select[name=gender]{ width: 80px;}
	
</style>

</head>
<body>
	<!-- edit.jsp -->
	<div class="container">
		<h1 class="page-header">Address Book</h1>
		
		<!-- 무조건 POST 선택!! -->
		<form method="POST" action="/jsp/jdbc/editok.jsp">
			<table class="table table-bordered">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" class="form-control" autocomplete="aaa" value="<%= name %>"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="number" name="age" min="19" max="100" class="form-control"></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<select name="gender" class="form-control">
							<option value="m">남자</option>
							<option value="f">여자</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" name="address" class="form-control" ></td>
				</tr>
			</table>
			
			<div class="btns">
				<input type="submit" value="수정하기" class="btn btn-default">
				<input type="button" value="목록보기" class="btn btn-default" onclick="history.back();">
			</div>
			
			<input type="hidden" name="seq" value="<%= seq %>">
		</form>
		
	</div>
	
	<script>
	
		$("input[name=age]").val("<%= age %>");
		$("select[name=gender]").val("<%= gender %>");
		$("input[name=address]").val("<%= address %>");
	
	
	</script>		
</body>
</html>