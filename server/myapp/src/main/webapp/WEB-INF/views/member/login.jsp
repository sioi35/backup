<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myapp</title>

<%@ include file="/inc/asset.jsp" %>

<style>
	
</style>

</head>
<body>
	<!-- views> member> login.jsp -->
	<%@ include file="/inc/header.jsp" %>
	
	<section class="main-section">
		
		<h1>User</h1>
		
		<div class="user-list">
			<button type="button" class="btn btn-default" 
				onclick="location.href='/myapp/member/loginok.do?id=hong&pw=1111';">홍길동</button>
			<button type="button" class="btn btn-default" 
				onclick="location.href='/myapp/member/loginok.do?id=test&pw=1111';">테스트</button>
			<button type="button" class="btn btn-default" 
				onclick="location.href='/myapp/member/loginok.do?id=admin&pw=1111';">관리자</button>
		</div> 
		
		<!-- <form method="POST" action="/myapp/member/loginok.do">
			<table class="table table-bordered" style="width:300px;">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="id" class="form-control" required></td>
				</tr>
				<tr>
					<th>암호</th>
					<td><input type="password" name="pw" class="form-control" required></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="로그인" class="btn btn-default">
			</div>
		</form>
		 -->
	</section>	
	
	
	<%@ include file="/inc/init.jsp" %>
	<script>
		
	</script>
</body>
</html>















