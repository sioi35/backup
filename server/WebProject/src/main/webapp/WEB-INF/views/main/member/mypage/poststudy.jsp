<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp"  %>


<style>
	
	body { background: #eee;}

	.main-section{ background-color: #fff; padding: 20px; margin-bottom: 0;}
	
	.main-section .title td {border: 0;}
 	.main-section .title td:nth-child(1) { width: 150px; border-right: 1px solid #ddd; }
 	.main-section .title td:nth-child(2) { width: auto; border-right: 1px solid #ddd;}
 	.main-section .title td:nth-child(3) { width: 150px; }
	
 	.main-section .title .posttitle {display: inline-block; font-size: 24px; color: #777; border-bottom: 1px solid #ddd; margin-bottom: 3px;}
 	
 	.main-section .main-table { border-bottom: 1px solid #ddd;}
 	
	.nickname { color: #548CA8;}
	
	
	.main-section .main .content {white-space:pre-line;}
	
	.main-section .main td {border: 0; text-align: center}
	.main-section .main tr:nth-child(1) {border-bottom: 1px dashed #ccc; }
	.main-section .main td:nth-child(1) {text-align: left;}
	.main-section .main td:nth-child(2) { width: 170px; margin-bottom:3px;}
	.main td:nth-child(3) { width: 170px;}
	.main td:nth-child(4) { width: 170px;}
	
	
	
	.profile-table .border-0 {border: 0;}
	.seek-table { text-align: center;}
	.seek-table td:nth-child(1) { width: 200px;}
	.seek-table td:nth-child(2) { width: auto; text-align: center;}
	.seek-table td:nth-child(3) { width: auto;}
	
	.red { color: tomato;}
	.blue { color: cornflowerblue;}
	
	.center-div { text-align: center; margin-top: 20px;}
	.center-span { display: inline-block; font-size: 20px;}
  	
  	.starR1{
	    background: url('/webproject/asset/images/star.png') no-repeat -52px 0;
	    background-size: auto 100%;
	    width: 15px;
	    height: 30px;
	    float:left;
	    text-indent: -9999px;
	    cursor: pointer;
	}
	
	.starR2{
	    background: url('/webproject/asset/images/star.png') no-repeat right 0;
	    background-size: auto 100%;
	    width: 15px;
	    height: 30px;
	    float:left;
	    text-indent: -9999px;
	    cursor: pointer;
	}
	
	.starR1.on{background-position:0 0;}
	.starR2.on{background-position:-15px 0;}
  	
  	.starRev { width: 150px; display: inline-block;}
	
</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
</head>
<body>
	<%@ include file="/inc/header.jsp" %>
	<div class="container">
		<h1 class="page-header">?????? ?????? ????????? ??????</h1>
		<c:forEach items="${slist}" var="dto">
		
		<section class="main-section">		
		<div class="main-table">
			<table class="table title">
				<tr>
					<td class="nickname">${dto.nickName} ???</td>
					<td rowspan="2"><span class="posttitle">${dto.name}</span><br>${dto.postTitle}</td>
					<td rowspan="2">
						<i class="bi bi-hand-thumbs-up"></i> ${dto.recommendCount}
						<i class="bi bi-hand-thumbs-down"></i> ${dto.decommendCount}
						<i class="bi bi-eye"></i> ${dto.readCount}
					</td>
				</tr>
				<tr>
					<td>${dto.regdate}</td>
				</tr>
			
			</table>
		</div>
		<c:if test="${dto.close == 'n'}">
		<div class="profile-table">
			<h2 class="border-0">???????????????</h2>
			
			<table class="table seek-table">
				<c:set var="no" value="n" />
				<c:forEach items="${ilist}" var="idto">
					<c:if test="${idto.studyPostSeq eq dto.studyPostSeq}">
						<c:forEach  items="${plist}" var="pdto">
							<c:if test="${pdto.memberSeq eq idto.memberSeq}">
							<c:set var="no" value="y" />
								<tr>
									<td>
										${pdto.nickName}
									</td>
									<td>
										<c:if test="${pdto.score >= 1}">
										<div class="starRev">
											  <span class="starR1">???1_??????</span>
											  <span class="starR2">???1_?????????</span>
											  <span class="starR1">???2_??????</span>
											  <span class="starR2">???2_?????????</span>
											  <span class="starR1">???3_??????</span>
											  <span class="starR2">???3_?????????</span>
											  <span class="starR1">???4_??????</span>
											  <span class="starR2">???4_?????????</span>
											  <span class="starR1">???5_??????</span>
											  <span class="starR2">???5_?????????</span>
											  <span>???????????????.</span>
										</div>
									  	<div>
											<input type="hidden" name="evaluation"  class="evaluation" value="${pdto.score}">
										</div>	
										</c:if>
										<c:if test="${pdto.score == 0}">
										<span>?????? ????????? ????????????.</span>
										</c:if>
									</td>
									<c:if test="${idto.seekerCheck eq 'n'}">
										<td>
											<button type="button" class="btn btn-default profile" id="profile"  name="profile" value="${idto.memberSeq}">????????????????????????</button>
											<button type="button" class="btn btn-primary" name="passSeeker" onclick=" location.href='/webproject/main/member/mypage/mystudy/passseeker.do?passSeeker=p&seq=${idto.seekerInfoSeq}'">??????</button>
											
											<button type="button" name="npassSeeker" class="btn btn-danger"  onclick=" location.href='/webproject/main/member/mypage/mystudy/passseeker.do?passSeeker=np&seq=${idto.seekerInfoSeq}'">?????????</button>
										</td>
									</c:if>
									<c:if test="${idto.seekerCheck eq 'np'}">
										<td>
											<span class="red">???????????? ??????????????????.</span>
										</td>
									</c:if>
									<c:if test="${idto.seekerCheck eq 'p'}">
										<td>
											<span class="blue">????????? ??????????????????.</span>
										</td>
									</c:if>
								</tr>
								<c:if test="">
									<tr>
										<td>
										</td>
									</tr>
								</c:if>
							</c:if>
						</c:forEach>
					</c:if>
				</c:forEach>
					<c:if test="${no == 'n'}">
						<tr>
							<td colspan="2">???????????? ????????????.</td>
						</tr>
					</c:if>	
			</table>
		</div>
		
		<div>
			<button type="button" class="btn btn-danger" name="finish" 
			onclick="location.href='/webproject/main/member/mypage/mystudy/closestudy.do?seq=${dto.studyPostSeq}';">?????? ????????????</button>
		</div>
		</c:if>
		
		<c:if test="${dto.close == 'y'}">
			<div class="center-div">
				<span class="red center-span">????????? ???????????????.</span>
			</div>
		</c:if>
		
		
		
		</section>
		
		
		</c:forEach>
	

		
	</div>
	<%@ include file="/inc/footer.jsp"%>
   	<%@ include file="/inc/init.jsp"%>
	<script>
	
		//?????? ?????? alert???
		$("button[name=passSeeker]").click(function () {
			if(confirm('?????? ???????????? ?????????????????????????') == true){
	        	alert('?????????????????????.');
			} else {
				return ;
			}
	     });
		
		//?????? ????????? alert???
		$("button[name=npassSeeker]").click(function () {
			if(confirm('?????? ????????? ???????????????????') == true){
	        	alert('?????????????????????.');
			} else {
				return ;
			}
	     });
		
		//???????????? alert???
		$("button[name=finish]").click(function () {
			if(confirm('?????? ????????? ??????????????????????') == true){
				 
	        	alert('????????? ?????????????????????. ???????????? ????????? ???????????? ??????????????? ????????????.');
			} else {
				return ;
			}
	     });
		
		
		//?????? ??????		
		$('.starRev').click(function(){
			  for(let i=0; i< $(this).next().children().first().val(); i++){
				  $(this).children().eq(i).addClass("on");
				}
			  
		});
		
		//????????? ?????????
		$('.profile').click(function(){
	         
	         window.name = "parentForm";
	         
	         openWin = window.open("studyprofile.do?seq="+ $(this).val(), "childForm", "width=570, height=350, resizable = no, scrollbars = no");
	         
	      })


		
	</script>
</body>
</html>











