<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/spring/resources/css/skilltree.css">

<div class="container">

	<!-- 스킬트리 분야별 버튼 -->
	<div class="fields">
		<!-- DB에서 받아오기 -->
		<c:forEach items="${flist}" var="fdto">
			<button type="button" data-seq="${fdto.fieldSeq}" class="field-btn btn btn-default">${fdto.name}</button>
		</c:forEach>
	</div>

	<!-- 스킬트리 이미지 -->
	<div class="skilltree">
		<img id="skilltreeImg" src="/spring/resources/img/skill/${userFdto.image}">
		
		<div class="side-content">
			<!-- 스킬체크 버튼 -->
			<button type="button" id="skillcheck" class="btn btn-default">스킬체크</button>
			
			<!-- 관련 자격증 -->
			<!-- 추가기능 - 클릭시 자격증 구글검색 -->
			<div class="license-list">
				<h3>관련 자격증</h3>
				<c:forEach items="${llist}" var="ldto">
					<div class="license"><a href="https://www.google.co.kr/search?q=${ldto.name}" target="_blank">${ldto.name}</a></div>
				</c:forEach>
			</div>
		</div>
	</div>

</div>

<script>

	$('.field-btn').each(function(index, item) {
		if ($(item).data('seq') == ${userFdto.fieldSeq}) {
			$(item).attr('disabled', true);
		}
	});
	
	$('#skillcheck').click(function() {
		if (confirm('${userFdto.name} 스킬체크를 시작하시겠습니까?\n제한시간: ${userFdto.time}분')) {
			location.href = '/spring/skill/skillcheck.action?seq=' + ${userFdto.fieldSeq};
		}
	});

	$('.field-btn').click(function() {
		$('.field-btn').attr('disabled', false);
		$(this).attr('disabled', true);
		
		$.ajax({
			type: 'GET',
			url: '/spring/skill/changeField.action',
			data: {'seq': $(this).data('seq')},
			dataType: 'json',
			success: function(map) {
				//이미지 변경
				$('#skilltreeImg').attr('src', '/spring/resources/img/skill/' + map.fdto.image);
				
				//스킬체크 버튼 url 수정
				$('#skillcheck').off('click');
				$('#skillcheck').click(function() {
					if (confirm(map.fdto.name + ' 스킬체크를 시작하시겠습니까?\n제한시간: ' + map.fdto.time)) {
						location.href = '/spring/skill/skillcheck.action?seq=' + map.fdto.fieldSeq;
					}
				});
				
				//자격증 리스트 수정
				$('.license').remove();
				$(map.llist).each(function(index, item) {
					$('.license-list').append('<div class="license"><a href="https://www.google.co.kr/search?q=' + item.name + '" target="_blank">' + item.name + '</a></div>');
				});
			},
			error: function(a,b,c) {
				console.log(a,b,c);
			}
		});
	});

</script>