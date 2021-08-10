<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myapp</title>

<%@ include file="/inc/asset.jsp" %>

<style>
	
	.table th:nth-child(1) { width: 60px; }
	.table th:nth-child(2) { width: auto; }
	.table th:nth-child(3) { width: 80px; }
	.table th:nth-child(4) { width: 120px; }
	.table th:nth-child(5) { width: 60px; }
	
	.table td:nth-child(2) { text-align: left; padding-left: 20px; }
	
	.searchbox {
		text-align: center;
		margin-bottom: 20px;
	}
	
	.searchbox .form-control{
		display: inline-block;
		width: auto;
	}
	
	.searchbox #search{
		width: 300px;
	}
	
	.searchBar { margin: 10px; text-align: center; }
	
	.pagebar { text-align: center; }
	
</style>

</head>
<body>
	<!-- board/list.jsp -->
	<%@ include file="/inc/header.jsp" %>
	
	<section class="main-section">
		
		<h1>Board <small>List</small></h1>
		
		<c:if test="${map.isSearch == 'y' }">
			<div class="searchBar">
				'${map.search}'으로 검색한 결과 ${list.size()}개의 게시물이 있습니다.
			</div>
		</c:if>
		
		<table class="table table-bordered">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>이름</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
			
			<c:if test="${list.size() == 0}">
				<tr>
					<td colspan="5">게시물이 없습니다.</td>
				</tr>
			</c:if>
			
				
			<c:forEach items="${list}" var="dto">
			<tr>
			<%-- 	
				<c:set var="no" value="${totalCount}" />
				 	<td>${no}</td>
				<c:set var="no" value="${no - 1}" /> 
			--%>
				<td>
					<c:if test="${dto.depth == 0 }">
					${dto.seq}
					</c:if>
				</td>
				<td>
					
					<c:if test="${dto.depth > 0}">
					<span style="color:cornflowerblue; margin-left: ${dto.depth * 20}px;">▶</span>
					</c:if>
				
					<a href="/myapp/board/view.do?seq=${dto.seq}&column=${map.column}&search=${map.search}">${dto.subject}</a>
					<c:if test="${dto.ccnt > 0}">
						<span class="badge">${dto.ccnt}</span>
					</c:if>
					<c:if test="${dto.isnew < ( 2 / 24 )}">
						<span class="label label-danger">new</span>
					</c:if>
				</td>
				<td>${dto.name}</td>
				<td>${dto.regdate}</td>
				<td>${dto.readcount}</td>
			</tr>
			</c:forEach>
		</table>
		
	
		<%-- 		
		<div>
			<form method="GET" action="/myapp/board/list.do">
				<input type="number" name="page" min="1" max="${totalPage}" value="${nowPage}">
				<input type="submit" value="페이지 보기">
			</form>
		</div>
	
		<hr>
		<div>
			<select id="selPage">
				<c:forEach var="i" begin="1" end="${totalPage}">
					<option value="${i}">${i}page</option>
				</c:forEach>
			</select>
		</div> 
		--%>
		
		<div class="pagebar">
			${pagebar}
		</div>
	
	
		<div class="searchbox">
			<!--  
				대부분(99%)의 <form은 method="POST"를 사용한다.
				예외로.. 전송 당시의 상태를 유지하고 싶을 대 method="GET"을 사용한다.(ex: 검색결과의 북마크)
			-->
			<form method="GET" action="/myapp/board/list.do">
				<select name="column" id="column" class="form-control">
					<option value="subject">제목</option>
					<option value="content">내용</option>
					
					<option value="name">이름</option>
					<option value="all">제목+내용</option>
				</select>
				<input type="text" name="search" id="search" class="form-control" required placeholder="검색어를 입력하세요.">
				<input type="submit" value="검색하기" class="btn btn-default">
			</form>
		</div>
		
		<div class="btns">
			
			<c:if test="${not empty id}">
			<!-- 새글 쓰기 -->
				<button type="button" class="btn btn-primary" 
					onclick="location.href='/myapp/board/add.do?reply=0';">글쓰기</button>
			</c:if>
			
			<button type="button" class="btn btn-default" 
				onclick="location.reload();">새로고침(F5)</button>
			<button type="button" class="btn btn-default" 
				onclick="location.href='/myapp/board/list.do';">새로고침</button>
		</div>
		
	</section>	
	
	<%@ include file="/inc/init.jsp" %>
	<script>
		
	<c:if test="${map.isSearch == 'y'}">
	
		//상태 복원
		$('#column').val('${map.column}');
		$('#search').val('${map.search}');

	</c:if>
	
	$('#selPage').change(function(){
		
		location.href='/myapp/board/list.do?page=' + $(this).val();
		
	});
	
	$('#selPage').val('${nowPage}');
	
	
	</script>
</body>
</html>















