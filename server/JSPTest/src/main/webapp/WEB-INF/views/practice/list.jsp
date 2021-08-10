<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>
	.container{ width: 600px; }
</style>

</head>
<body>
	<!-- list.jsp -->
	<div class="container">
		<h1 class="page-header">리스트 목록</h1>
		
		<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<th>번호</th>
				<th>생년월일</th>
			</tr>
			
			<c:forEach items="${list}" var="dto">
			<c:if test="${!dto.name.equals('관리자')}">
			<tr>
				<td>${dto.name}</td>
				<td>${dto.tel}</td>
				<td>${dto.birth}
						<c:if test="${id.equals('admin')}">
							<span class="glyphicon glyphicon-edit" 
								onclick="location.href='/jsp/practice/edit.do?id=${dto.id}';">
							</span>
						</c:if>
				</td>
			</tr>
			</c:if>
			</c:forEach>
		
		</table>
		
      <div class="btns">
         <input type="button" value="Logout" class="btn btn-default" onclick="location.href='/jsp/practice/logout.do';">
         <input type="button" value="Main" class="btn btn-default" onclick="location.href='/jsp/practice/main.do';">
      </div>
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>