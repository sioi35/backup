<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<style>

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
	width: 550px;
	display: inline-block;
	text-align: left;
	vertical-align: middle;
	font-size: 17px;
}

.sform-control {
	margin-right: 50px;
}

.aform-control {
	margin-bottom: 15px;
}

input[type=date] {
	width: 49.4%;
	display: inline;
}

#container {
	width: 800px;
	margin: 0px auto 50px auto;
}

#category {
	width: 120px;
	text-align: center;
}

.list {
	width: 800px;
/* 	margin: 20px auto; */
	align: center;
}

#search {
	margin-left: 340px;
}

#search {
	margin-top: 8px;
	position: relative;
	left: -300px;
	top: 0;
}

#search button[type="submit"] {
	float: right;
}

#thumbBox {
	/* width: 900px; */
	width: 800px;
	display: flex;
	flex-wrap: wrap;
}

.main-section {
	margin-bottom: 100px;
}

.img {
	cursor: pointer;
}

.thumbnail {
	height: 280px;
}

.searchbtn {
	float: right;
	margin-right: 25px;
	margin-bottom: 5px;
}

.form-group {
	margin-top: 20px;
}

#sbtn {
	width: 110px;
	height: 40px;
	margin-left: auto;
}

.pagebar {
	text-align: center;
	margin-top: -15px;
}

.nonSearch {
	width: 100%;
	text-align: center;
	margin-bottom: 30px;
}

.search-control {
	display: flex;
}

#sword {
	width: 420px;
}

p:hover {
	color: #ffc045;
}

#studyName {
	font-size: 15px;
	font-weight: bold;
	text-align: center; /* 가운데정렬되게 수정하기! */
}

</style>

	<section class="main-section">
		<div id="container">
			<h1>스터디 모집 목록</h1>
			
			<div class="list">
            	<nav class="navbar navbar-default">
					<!-- Search -->
					<form class="form-horizontal" method="get">
						<div class="form-group">
							<label for="sword" class="col-sm-2 control-label">검색어로 검색</label>
							<div class="col-sm-10">
								<input type="text" class="form-control sform-control" name="sword" id="sword" placeholder="검색어를 입력하세요.">
							</div>
						</div>
						<div class="form-group">
							<label for="sfield" class="col-sm-2 control-label">분야로 검색</label>
							<div class="col-sm-10 search-control"> 
								<select name="sfield" id="sfield" class="form-control sform-control">
									<option value="">분야 선택</option>
									<c:forEach items="${flist}" var="fdto">
									<option value="${fdto.fieldSeq}">${fdto.name}</option>
									</c:forEach>
								</select>
								<button type="button" class="btn btn-info searchbtn" onClick="location.href='/spring/study/studylist.action';">Reset</button>
								<button type="submit" class="btn btn-success searchbtn">Search</button>
							</div>
							
						</div>
		
						
					</form>
            	</nav>
            	
            	<div id="thumbBox">
            	
				<c:if test="${empty list}">
					<div class="nonSearch">검색결과가 없습니다.</div>
				</c:if>
				
				<c:if test="${not empty list}">
					<div id="" class="row">
						<c:forEach items="${list}" var="stdto">
						<div class="col-sm-6 col-md-3">
							<a style="text-decoration: none;" href="studyview.action?seq=${stdto.studySeq}&page=${page}&sword=${smap.sword}&sfield=${smap.sfield}">
								<div class="thumbnail">
									<img class="img" src="https://d1vcqlflm6aitx.cloudfront.net/images/800x100p/1557364192-work_while_you_study_banner.webp" />
									<div class="caption">

	                                 <p>
										<span id="studyName">${stdto.name}</span><br> ▷모집 인원 : ${stdto.limitNumber}명<br>
	                                    ▷분야 : ${stdto.fieldName}<br> ▷기간 : ${stdto.startDate} ~
	                                    ${stdto.endDate}<br> ▷장소 : ${stdto.area}<br>
	                                 </p>
	                              	</div>
								</div>
							</a>
						</div>
						</c:forEach>
					</div>
				</c:if>

					<button type="button" class="btn btn-primary btn-sm" id="sbtn" data-toggle="modal" data-target="#addModal">스터디 등록하기</button>

					

				</div>
			</div>
			<div class="pagebar">${pagebar}</div>
		</div>

	</section>
	
	<!-- Modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	
		<form name="frm" id="frm">
            <div class="modal-content">
               <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                     <span aria-hidden="true">&times;</span>
                  </button>
                  <h4 class="modal-title" id="myModalLabel">스터디 등록</h4>
               </div>
               <div class="modal-body">
                  <div class="modal-body-form">
                     <span>스터디명</span>
                     <input type="text" name="name" id="name" class="form-control aform-control" 
                        placeholder="스터디명을 입력하세요." autocomplete="off" required>
                        
                     <span>상세내용</span>
                     <textarea name="content" id="content" class="form-control aform-control" 
                        placeholder="상세내용을 입력하세요." required></textarea>
                        
                     <span>모집인원</span>
                     <input type="number" name="limitNumber" id="limitNumber" class="form-control aform-control"
                        placeholder="모집인원을 입력하세요." min="1" max="50" required>
                        
                     <span>장소</span>
                     <input type="text" name="area" id="area" onclick="findAddr();" class="form-control aform-control"
                        placeholder="선택하여 주소를 검색하세요." readonly required>
                                       
                     <span>교재</span>
                     <input type="text" name="book" id="book" class="form-control aform-control" 
                        placeholder="교재명을 입력하세요." autocomplete="off" required>
                        
                     <span>분야</span>
                     <select name="fieldSeq" id="fieldSeq" class="form-control aform-control" required>
                        <option value="">분야 선택</option>
                        <c:forEach items="${flist}" var="fdto">
                        <option value="${fdto.fieldSeq}">${fdto.name}</option>
                        </c:forEach>
                     </select>
                     
                     <span>기간</span><br>
                     <input type="date" name="startDate" id="startDate" class="form-control aform-control" required>
                     <input type="date" name="endDate" id="endDate" class="form-control aform-control" required>
                     
                  </div>
                  
               </div>
               <div class="modal-footer">
                  <button type="submit" id="addStudy" class="btn btn-primary">등록</button>
               </div>
            </div>
         </form>
      </div>
	</div>
	<!-- Modal End -->
   
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/4.3.0/jquery.form.min.js" integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" crossorigin="anonymous"></script>

	<script>
   
		$('#sword').val('${smap.sword}');
		$('#sfield').val('${smap.sfield}');
		
		//주소 api
		function findAddr() {
			new daum.Postcode({
				oncomplete : function(data) {
					//console.log(data);
	
					// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
					// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
					// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
					var roadAddr = data.roadAddress; // 도로명 주소 변수
					var jibunAddr = data.jibunAddress; // 지번 주소 변수
					// 주소 정보를 해당 필드에 넣는다.
					if (roadAddr !== '') {
						document.getElementById("area").value = roadAddr;
					} else if (jibunAddr !== '') {
						document.getElementById("area").value = jibunAddr;
					}
				}
			}).open();
		}

		var option = {
			beforeSubmit : applyBefore,
			type : 'POST',
			url : '/spring/study/studyAdd.action',
			data : $('#frm').serialize(),
			success : function(data) {
            	if (data == '1') {
					alert("등록되었습니다.");
					location.reload();
				} else {
					alert('등록 실패');
				}
			},
         	error : function(request, status, error) {
            	alert("code: " + request.status + "\n message: "
                	  + request.responseText);
			}
		}

		$('#frm').submit(function() { //submit이 발생하면
			$(this).ajaxSubmit(option); //옵션값대로 ajax비동기 동작을 시키고
			return false; //기본 동작인 submit의 동작을 막아 페이지 reload를 막는다.
		});

		// ajaxSubmit 전 처리 작업 영역
		function applyBefore(formData, jqForm, options) {

			var stDate = $('#startDate').val();
			var edDate = $('#endDate').val();

			if (Number(stDate.replace(/-/gi, "")) > Number(edDate.replace(/-/gi, ""))) {
            	alert("시작일이 종료일보다 클 수 없습니다.");
            	$('#endDate').focus();
            	return false;
			}

			if ($('#area').val() == '') {
				alert("주소 입력칸을 선택하여 주소를 입력해주세요.");
				$('#area').focus();
				return false;
			}

			return true;
		}
      
	</script>
