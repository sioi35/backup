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
   <!-- result.jsp -->
   <div class="container">
      <h1 class="page-header">결과</h1>      
      
      <div>m1: ${result}</div>
      <div>m2: ${result}</div>
      
      <div>m3.count: ${count}</div>
      
      <div>m4.memo: ${memo}</div>
      
      <div>m5.dto: ${dto}</div>
      
      <div>m6.list</div>
      
      <c:forEach items="${list}" var="dto">
	      <div>${dto.seq}. ${dto.memo}</div>
      
      </c:forEach>
      
      
   </div>   
   
   <script>
      
   </script>
</body>
</html>
