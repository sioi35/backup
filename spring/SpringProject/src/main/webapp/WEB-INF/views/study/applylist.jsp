<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<style>
#container {
	width: 1100px;
	height: 700px;
	margin: 0px auto 50px auto;
}

#content {
	width: 900px;
	margin: 20px auto;
	position: relative;
	left: -100px;
	top: 0px;
}

.table {
	text-align: center;
}

.table tr:first-child th:nth-child(1) {
	width: 60px;
}

.table tr:first-child th:nth-child(2) {
	text-align: center;
	width: 100px;
}

.table tr:first-child th:nth-child(3) {
	width: auto;
}

.table tr:first-child th:nth-child(4) {
	width: 170px;
}

.table tr:first-child th:nth-child(5) {
	width: 170px;
}

.table tr:first-child th:nth-child(6) {
	width: 70px;
}

.table tr:first-child th:nth-child(7) {
	width: 150px;
}

.table tr td:nth-child(2) {
	text-align: left;
}

#isnew {
	display: inline-block;
	width: 13px;
	height: 13px;
	background-color: red;
	color: white;
	border-radius: 6.5px;
	text-align: center;
}

.searchbox {
	display: flex;
	justify-content: space-between;
	text-align: center;
	margin-bottom: 20px;
}

.searchbox .form-control {
	display: inline-block;
	width: auto;
}

.searchbox #search {
	width: 300px;
}

.searchBar {
	margin: 10px;
	text-align: center;
}

.pagebar {

	text-align: center;	

	display: flex;
	 justify-content: center; 
}

input[type=checkbox] {
	zoom: 1.5;
}

.pagination {
	margin-left: 300px;
	margin-top: 100px;
}

#okbutton {
	float: right;
}

tr {
	cursor: pointer;
}

tr.off {background:#fff}
tr.on {background:#EEE}

</style>

	<script language="javascript">
	
		function showPopup(id) {
			window.open("/spring/study/applypopup.action?id=" + id, "a", "width=800, height=400, left=400, top=50");
		}
		
		function ok(applySeq) {
			/* var checkValue = $("#yon").val();

			checkValue="OK!!" */
			
			alert('합격 처리 되었습니다.');
			
			/* ${adto.field} */
			
		}
		
		function no(applySeq) {
			alert('불합격 처리 되었습니다. ');
			
		}
		
		

	</script>

	

	<section class="main-section">
			<h1>
				스터디 지원자 목록
			</h1>
			<div id="content">
				<c:if test="${map.isSearch == 'y'}">
					<div class="searchBar">'${map.search}'으로 검색한 결과
						${list.size()}개의 게시물이 있습니다.</div>
				</c:if>
				<table class="table">
					<tr class="active off" onmouseover="this.className='on'" onmouseout="this.className='off'">
						<th>글번호</th>
						<th>이름</th>
						<th>사용언어</th>
						<th>전화번호</th>
						<th>신청날짜</th>
						<th>합격여부</th>
						<th>합격체크</th>
					</tr>
					<c:if test="${empty list}">
						<tr>
							<td colspan="5">신청자가 없습니다.</td>
						</tr>
					</c:if>
					<c:if test="${not empty list}">
						<c:forEach items="${list}" var="adto">
							<tr class="off" onmouseover="this.className='on'" onmouseout="this.className='off'">
									<td onclick="showPopup('${adto.id}');">${adto.applySeq}</td>
									<td onclick="showPopup('${adto.id}');">${adto.name}</td>
									<td onclick="showPopup('${adto.id}');">${adto.languagename}</td>
									<td onclick="showPopup('${adto.id}');">${adto.phone}</td>
									<td onclick="showPopup('${adto.id}');">${adto.regdate}</td>
									<td id="field" onclick="showPopup('${adto.id}');">${adto.field}</td>
								<td>
									<%-- <div class="form-check">
										<input class="form-check-input" type="checkbox" 
											 name="check" value="${adto.field}">
									</div> --%>
									<%-- <c:if test=""> --%>
										<button type="button" class="btn btn-success" name="okbutton" onclick="ok('${adto.applySeq}');">합격</button>
										<button type="button" class="btn btn-danger" name="nobutton" onclick="no('${adto.applySeq}');">불합격</button>
									<%-- </c:if> --%>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
				
				<!-- <div>
					<button type="button" class="btn btn-success" id="okbutton" >합격승인</button>
				</div> -->
				
				<div class="pagebar">${pagebar}</div>

			</div>
	</section>



	<script>
		
	
	
		<c:if test="${map.isSearch == 'y'}">

		//상태 복원
		$('#column').val('${map.column}');
		$('#search').val('${map.search}');

		</c:if>
		$('#selPage').change(function() {
			location.href = '/SIST2_Travel/community/freeboard/list.do?page=' + $(this).val();
		});

		$('#selPage').val('${nowPage}');
	</script>

