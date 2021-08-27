<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>


<tiles:insertAttribute name="asset"></tiles:insertAttribute>
<tiles:insertAttribute name="asset_member"></tiles:insertAttribute>

<style>
	
</style>

</head>
<body>
	<!-- member/info.jsp > layout/member.jsp -->
	
	<main>
	
		<!-- Tiles 장점: 현재 페이지(레이아웃 페이지, 템플릿 페이지) > 레이아웃만 구성하는 전문 페이지 -->
		
		<tiles:insertAttribute name="mainmenu"></tiles:insertAttribute>
				
		<tiles:insertAttribute name="submenu"></tiles:insertAttribute>

		<tiles:insertAttribute name="content"></tiles:insertAttribute>
		
	</main>

	<script>
      
   </script>
</body>
</html>
