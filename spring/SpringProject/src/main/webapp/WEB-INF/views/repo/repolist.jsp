<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset_repo.jsp"%>

</head>
<body>

	<section class="main-section">

		<div class="repo-container">

			<div class="profile-container">
				<div class="profile-img" ><img src="/spring/resources/img/${member.image}"></div>
				<div class="profile-name">
					<div class="name">${member.name}</div>
					<input type="button" value="Edit profile" class="profile">
				</div>
			</div>

			<div class="repolist-container">

				<div class="search-container">
					<input type="text" class="search" placeholder="검색어를 입력하세요.">
					<input type="button" class="searchbtn" value="검색🔍">
				</div>
				
				<hr>

				<button type="button" class="addbtn" id="addbtn">New</button>

				<div class="repolist">
					<c:forEach items="${list}" var="dto">
						<div class="repo">
							<div class="title" onclick="location.href='/spring/repo/repoview.action?reposeq=${dto.repoSeq}';">${dto.name}</div>
							<div class="sub">${dto.description}</div>
							<c:if test="${dto.lockflag=='y' }">
								<div class="lock">공개🔓</div>
							</c:if>
							<c:if test="${dto.lockflag=='n' }">
								<div class="lock">비공개🔒</div>
							</c:if>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

		<div id="addModal" class="modal">

			<div class="modal-content">
				<span class="close" id="closebtn">&times;</span>
				<h4>저장소 추가</h4>
				<hr>
				<form id="addForm">
					<table>
						<tr>
							<td>Repository name<sapn class="required">*</sapn></td>
							<td><input type="text" id="name" name="name" required></td>
						</tr>
						<tr>
							<td>Description<span class="option">(optional)</span></td>
							<td><input type="text" id="description" name="description"></td>
						</tr>
						<tr>
							<td>public <input type="radio" name="lockflag" value="y" checked></td>
							<td>private <input type="radio" name="lockflag" value="n"></td>
						</tr>
					</table>
					<input type="hidden" value="${id}" id="id" name="id"> <input type="submit" id="repoAdd" class="repoAdd" value="추가">
				</form>
			</div>
		</div>

	</section>

	<script>
	
	$('#addbtn').click(function(){
		$('#addModal').show();
	});
	
	$('#closebtn').click(function(){
		$('#addModal').hide();
	});
	
	$('#repoAdd').click(function(){

		$.ajax({
			type: 'POST', 
			url: '/spring/repo/repoadd.action',
			data: $('#addForm').serialize(),
			dataType: 'json',
			success: function(result){
				if(result==1){
					$('#addModal').hide();
					$('.repolist').append('<div class="repo"><div class="title">'+ $('#name').val() +'</div><div class="sub">'+$('#description').val()+'</div></div>');					
				}else{
					alert('문제가 발생하였습니다. 다시 시도해주세요');
				}
			},
			error: function(a,b,c){
				console.log(a,b,c);
			}
		});
		
	});
	
	

</script>

</body>
</html>