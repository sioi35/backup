<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myapp</title>

<%@ include file="/inc/asset.jsp" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b45f8a2df1911e3150bc76d38f8e4d13"></script>
<style>
	
</style>

</head>
<body>
	<!-- ex01.jsp -->
	<%@ include file="/inc/header.jsp" %>
	
	<section class="main-section">
		
		<h1>Map API <small>기본 지도</small></h1>


		<div id="map" style="width:100%; height:400px;"></div>



		
	</section>	
	
	
	<%@ include file="/inc/init.jsp" %>
	<script>
		
		var container = document.getElementById('map'); // 지도 태그 선택
		
		var options = {
			center: new daum.maps.LatLng(37.499331, 127.033181), //지도의 중앙 좌표
			level: 3 //지도의 레벨(확대, 축소)
		};
		
		var map = new daum.maps.Map(container, options);
	
	
	
	
	
	
	</script>
</body>
</html>
