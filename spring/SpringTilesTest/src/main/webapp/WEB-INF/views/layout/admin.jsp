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
<tiles:insertAttribute name="asset_admin"></tiles:insertAttribute>

<style>
	
</style>

</head>
<body>
	<!-- layout/admin.jsp -->
	
	<main>
		
		<tiles:insertAttribute name="mainmenu"></tiles:insertAttribute>
				
		<tiles:insertAttribute name="content"></tiles:insertAttribute>

		<tiles:insertAttribute name="submenu"></tiles:insertAttribute>
		
	</main>

	<script>
      
   </script>
</body>
</html>
