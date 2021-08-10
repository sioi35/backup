<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<h1 class="page-header">Edit</h1>
	
		<form method="POST" action="/jsp/editok.do">
			<table class="table table-bordered">
			
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" class="form-control" autocomplete="aaa"></td>
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
				<input type="hidden" name="seq">
			
		</form>
	
	</div>
	
	
	<script>
		<c:forEach items="${list}" var="map">
	 		$("input[name=seq]").val('${map.seq}');
	 		$("input[name=name]").val('${map.name}');
			$("input[name=age]").val('${map.age}');
			$("select[name=gender]").val('${map.gender}');
	    	$("input[name=address]").val('${map.address}');	
    	</c:forEach>
	</script>		
</body>
</html>