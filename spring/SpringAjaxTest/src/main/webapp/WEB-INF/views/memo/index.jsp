<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"%>
<link rel="stylesheet" href="/ajax/resources/css/jquery-ui.css">
<script src="/ajax/resources/js/jquery-ui.js"></script>

<style>

.page-header{
	margin: 30px;
}

.memo {
	background-size: 100% 100%;
	width: 200px;
	height: 200px;
}

.memo .btnClose {
	width: 10px;
	color: white;
	cursor: pointer;
	float: right;
	margin-top: 5px;
	margin-right: 20px;
}

.memo .txtMemo{
	margin-left: 5px;
	margin-top: 10px;
	width: 180px;
	height: 147px;
	resize: none;
	border: 0;
	outline: none;
	background-color:transparent;
}

.memo .txtMemo::-webkit-scrollbar{
	width: 10px;
}

.memo .txtMemo::-webkit-scrollbar-thumb {
   background-color: #FFF;
   border-radius: 10px;
   background-clip: padding-box;
   border: 2px solid transparent;
}

.memo .txtMemo::-webkit-scrollbar-track {
   background-color: transparent;
   border-radius: 10px;
   box-shadow: inset 0px 0px 5px white;
}



</style>

</head>
<body>
	<!-- memo > index.jsp -->
	<h1 class="page-header">Memo <button type="button" id="addMemo" class="btn btn-default"><span class="glyphicon glyphicon-plus"> memo</span></button></h1>

<!-- 
	<div class="memo" id="m3" style="background-image: url(/ajax/resources/images/03.png);">
		<div class="btnClose">&times;</div>
		<textarea class="txtMemo"></textarea>
	</div>
 -->
	<script>
		
			
		//아래의 2개 이벤트를 실행할 시점에는 .memo라는 태그가 화면에 존재하지 않음
		/* $('.memo').draggable().css('position', 'absolute');
	
		$('.memo .btnClose').click(function() {
			$(this).parent().remove();
		}); */
		
		
		let no = ${no +1}; //id
		let back = ${back+1};
		let zindex = ${zindex+1};
		
		//새 메모 추가하기
		$('#addMemo').click(function(){
			
			if(back > 6) back = 1;
			
			//메모지의 위치를 화면내에 무작위로 배치
			let left = Math.random() * $(document).width()-250;
			if(left < 100) left = 100;
			
			let top = Math.random() * $(document).height()-250;
			if(top < 100) top = 100;
			
			//화면에 메모지 1개 추가하기
			$('body').append('<div class="memo" id="m'+ no +'" style="background-image: url(/ajax/resources/images/0'+ back +'.png);" data-back="0'+ back +'"><div class="btnClose">&times;</div><textarea class="txtMemo"></textarea></div>')
					 .children()
					 .last()
					 .draggable() //메모객체
					 .css('position', 'absolute') //메모객체
					 .css('left', left + 'px')
					 .css('top', top +'px')
					 .mousedown(function(){ //메모객체
						 $(this).css('z-index', zindex);
						 zindex++;
					 })
					 .find('.btnClose').click(function(){ //메모객체 닫기 버튼
						 $(this).parent().remove();
					 });
			
			//새로 추가된 메모의 정보를 DB에 전송 + Ajax 사용
			$.ajax({
				type: 'POST',
				url: '/ajax/memo/add.action',
				data: 'id=m'+ no +'&background=0'+ back +'&left='+left+'&top='+top,
				dataType: 'json',
				success: function(result){
					//메모 추가 성공 유무 확인용
					if(result == 1){
					}else{
						
					}
				},
				error: function(a,b,c){
					console(a,b,c);
				}
			});
			
			
			no++;
			back++;
			
		});
		
		<c:forEach items="${list}" var="dto">
		$('body').append('<div class="memo" id="${dto.id}" style="background-image: url(/ajax/resources/images/${dto.background}.png); z-index:${dto.zindex};" data-back="${dto.background}"><div class="btnClose">&times;</div><textarea class="txtMemo"></textarea></div>')
			 .children()
			 .last()
			 .draggable() //메모객체
			 .css('position', 'absolute') //메모객체
			 .css('left', '${dto.left}px')
			 .css('top', '${dto.top}px')
			 .mousedown(function(){ //메모객체
				 $(this).css('z-index', zindex);
				 zindex++;
			 })
			 .find('.btnClose').click(function(){ //메모객체 닫기 버튼
				 $(this).parent().remove();
			 });
		</c:forEach>
		
	</script>
</body>
</html>















