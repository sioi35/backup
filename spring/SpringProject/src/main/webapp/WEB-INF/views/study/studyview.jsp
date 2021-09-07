<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<style>

.main-section .table th {
	width: 120px;
}
.main-section .table td {
	width: 280px;
	text-align: left;
}
.main-section .table tr:nth-child(6) th {height: 350px;}

.btns {
	text-align: right;
}

.modal {
    text-align: center;
}

@media screen and (min-width: 768px) { 
	.modal:before {
	    display: inline-block;
	    vertical-align: middle;
	    content: " ";
	    height: 100%;
	}
}

.modal-dialog {
	width: 500px;
	display: inline-block;
    text-align: left;
    vertical-align: middle;
    font-size: 17px;
}


</style>

<section class="main-section">
	<h1 class="page-header">${dto.name}</h1>
	
	<table class="table table-bordered">
		<tr>
			<th>번호</th>
			<td>${dto.studySeq}</td>
			<th>등록자</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>모집인원</th>
			<td>${dto.limitNumber}명</td>
			<th>등록일</th>
			<td>${dto.regdate}</td>
		</tr>
		<tr>
			<th>기간</th>
			<td>${dto.startDate} ~ ${dto.endDate} </td>
			<th>분야</th>
			<td>${dto.fieldName}</td>
		</tr>
		<tr>
			<th>교재</th>
			<td colspan="3">${dto.book}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">${dto.content}</td>
		</tr>
		<tr>
			<th>장소</th>
			<td colspan="3"><div id="map" style="width:100%; height:350px;"></div></td>
		</tr>
		
	</table>
	
	<div class="btns">
		<c:if test="${not empty id}">
			<%-- 로그인한 아이디와 작성자 아이디가 같으면 신청현황 버튼 출력--%>
			<c:if test="${id == dto.id}">
			<button type="button" class="btn btn-primary" onClick="location.href='applylist.action?seq=${dto.studySeq}'">신청현황</button>
			</c:if>

			<c:if test="${dto.id != id}">				
				<c:choose>
					<%-- 이미 신청을 한 사용자는 신청 취소 버튼 출력 --%>
					<c:when test="${not empty dto.applySeq}">
					<button type="button" class="btn btn-warning" data-toggle="modal" data-target="#cancelModal">신청 취소</button>
					</c:when>
					<c:otherwise>
					<%-- 모집인원이 합격인원 보다 많아야 신청하기 버튼 출력(정원이 다 찼으면 정원초과 버튼 출력) --%>
					<c:if test="${dto.limitNumber > dto.passcnt}">
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#registModal">신청하기</button>
					</c:if>
					<c:if test="${dto.limitNumber <= dto.passcnt}">
					<button type="button" class="btn btn-primary" disabled>정원초과</button>
					</c:if>
					</c:otherwise>
				</c:choose>
			</c:if>

		</c:if>
		<button type="button" class="btn btn-default" onclick="location.href='/spring/study/studylist.action?page=${page}&sword=${sword}&sfield=${sfield}';">돌아가기</button>
	</div>
	
	<!-- Modal(신청하기) -->
	<div class="modal fade" id="registModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">신청하기</h4>
				</div>
				<div class="modal-body">
					<div class="modal-body-text">
						- 스터디명: ${dto.name} <br>
						- 모집 인원: ${dto.limitNumber}명 <br>
						- 신청 인원: ${dto.cnt}명 <br>
						- 합격 인원: ${dto.passcnt}명 <br>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onclick="fnRegist()">신청하기</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal End(신청하기) -->

	<!-- Modal(신청 취소) -->
	<div class="modal fade" id="cancelModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">신청 취소</h4>
				</div>
				<div class="modal-body">
					<p>해당 스터디의 신청을 취소하시겠습니까?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-warning" onclick="fnCancel()">신청 취소</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal End(신청 취소) -->

</section>


<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8d87b4602164a2ddba70d4cf4b290c37&libraries=services"></script>

<script>

	function fnRegist() {
		location.href='/spring/study/studyRegist.action?seq=${dto.studySeq}';
		alert("신청이 완료되었습니다.");
	}
	
	function fnCancel() {
		location.href='/spring/study/studyCancel.action?seq=${dto.studySeq}';
		alert("취소되었습니다.");
	}
	

	
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
	    mapOption = {
	        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };  

	// 지도를 생성합니다    
	var map = new kakao.maps.Map(mapContainer, mapOption); 

	// 주소-좌표 변환 객체를 생성합니다
	var geocoder = new kakao.maps.services.Geocoder();

	// 주소로 좌표를 검색합니다
	geocoder.addressSearch('${dto.area}', function(result, status) {

	    // 정상적으로 검색이 완료됐으면 
	     if (status === kakao.maps.services.Status.OK) {

	        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

	        // 결과값으로 받은 위치를 마커로 표시합니다
	        var marker = new kakao.maps.Marker({
	            map: map,
	            position: coords
	        });

	        // 인포윈도우로 장소에 대한 설명을 표시합니다
	        var infowindow = new kakao.maps.InfoWindow({
	            content: '<div style="width:150px;text-align:center;padding:6px 0;">${dto.area}</div>'
	        });
	        infowindow.open(map, marker);

	        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
	        map.setCenter(coords);
	    } 
	});    

</script>
