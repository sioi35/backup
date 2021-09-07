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

		<div class="repoview-container">
			<h1>저장소 보기</h1>

			<div class="top-container">
				<button type="button" class="addfilebtn" id="addfilebtn">Add</button>
			</div>

			<div class="folder-container">
				<table class="folder-table">
					<thead>
						<tr>
							<th>파일</th>
							<th>이름</th>
							<th>설명</th>
							<th>시간</th>
						</tr>
					</thead>
					<tbody>
				 		<c:if test="${empty list}">
					 		<tr>
					 			<td colspan="4">아직 파일이 없습니다.</td>
					 		</tr>
				 		</c:if>
				 		<c:forEach items="${list}" var="dto">
						<tr>
							<td class="type"><span>📄</span></td>
							<td class="fileName" onclick="location.href='/spring/repo/codeview.action?fileseq=${dto.fileSeq}';">${dto.fileName}</td>
							<td class="content">${dto.content}</td>
							<td class="regdate">${dto.regdate}</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		
		<div id="addfileModal" class="modal">
			<div class="modal-content">
				<span class="close" id="closebtn">&times;</span>
				<h4>소스 추가</h4>
				<hr>
				<form id="addfileForm" action="/spring/repo/upload.action" method="POST" enctype="multipart/form-data">
					
					<div>설명: <input type="text" name="content"></div>
					<div><input type="file" name="uploadFile" ></div>
					
					<input type="hidden" name="repoSeq" value="${reposeq}">
					<input type="submit" id="fileAdd" class="fileAdd" value="추가">
				</form>
			</div>
		</div>
		
	</section>
	
	<script>
	
		$('#addfilebtn').click(function(){
			$('#addfileModal').show();
		});
		
		$('#closebtn').click(function(){
			$('#addfileModal').hide();
		});	
		
	
	</script>
	
	
	
</body>
</html>