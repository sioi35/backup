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
	<!-- ex02.jsp -->
	<%@ include file="/inc/header.jsp" %>
	
	<section class="main-section">
		
		<h1>Map API <small>좌표 이동 + 레벨 변경</small></h1>


		<div id="map" style="width:100%; height:400px;"></div>

		<hr>
		
		<div>
			<div class="btn-group" role="group">
				<input type="button" class="btn btn-default" id="btn1" value="서울역으로 이동하기">
				<input type="button" class="btn btn-default" id="btn2" value="역삼역으로 이동하기">
			</div>
			<hr>
			<div class="btn-group" role="group">
				<input type="button" class="btn btn-default" id="btn3" value="확대">
				<input type="button" class="btn btn-default" id="btn4" value="축소">
			</div>
			<hr>
			<div class="btn-group" role="group">
				<input type="button" class="btn btn-default" id="btn5" value="드래그 On/Off">
				<input type="button" class="btn btn-default" id="btn6" value="줌 On/Off">
			</div>
		</div>

		
	</section>	
	
	
	<%@ include file="/inc/init.jsp" %>
	<script>
		
		var container = document.getElementById('map'); // 지도 태그 선택
		
		var options = {
			center: new daum.maps.LatLng(37.499331, 127.033181), //지도의 중앙 좌표
			level: 3 //지도의 레벨(확대, 축소)
		};
		
		var map = new daum.maps.Map(container, options);
	
		
		//추가 설정
		var mapTypeControl = new daum.maps.MapTypeControl();
		map.addControl(mapTypeControl, daum.maps.ControlPosition.TOPRIGHT);
	
		var zoomControl = new daum.maps.ZoomControl();
		map.addControl(zoomControl, daum.maps.ControlPosition.RIGHT);
	
		
		//지도 드래그 유무
		map.setDraggable(false);
		
		//지도 확대/축소 유무
		map.setZoomable(false);
		
		
		//버튼 클릭 > 해당 위치로 이동하기
		
		//서울역
		$('#btn1').click(function(){
			
			//이동할 좌표?
			var seoulStation = new daum.maps.LatLng(37.556233, 126.972237);
			map.setCenter(seoulStation);
		});
		
		//역삼역
		$('#btn2').click(function(){
			
			//이동할 좌표?
			var yeoksamStation = new daum.maps.LatLng(37.500606, 127.036416);
			map.setCenter(yeoksamStation);
		});
		
		//지도 확대/축소 제어하기
		$('#btn3').click(function(){
			
			//확대: ZoomIn
			//map.setLevel(1);
			
			map.setLevel(map.getLevel() - 1);
		
		
		});
		
		$('#btn4').click(function(){
			
			//축소: ZoomOut
			//map.setLevel(14);
			map.setLevel(map.getLevel() + 1);
			
		});
		
		
		//드래그 On/Off
		$('#btn5').click(function(){
			
			//alert(map.getDraggable());
			
			if(map.getDraggable()){
				map.setDraggable(false);
				$(this).removeClass('btn-primary');
				$(this).addClass('btn-default');
				
			}else {
				map.setDraggable(true);
				$(this).removeClass('btn-default');
				$(this).addClass('btn-primary');
			}		
			
		});
		
		
		//줌 On/Off
		$('#btn6').click(function(){
			
			//줌
			if(map.getZoomable()){
				map.setZoomable(false);
				$(this).removeClass('btn-danger');
				$(this).addClass('btn-default');
				
			}else {
				map.setZoomable(true);
				$(this).removeClass('btn-default');
				$(this).addClass('btn-danger');
			}	
			
		});
		
	</script>
</body>
</html>
