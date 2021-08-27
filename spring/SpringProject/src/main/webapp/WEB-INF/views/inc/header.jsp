<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
	window.onload = function() {

		var path = location.pathname;
		var menu = document.getElementsByClassName('mainbtn');

		for (var i = 0; i < path.length; i++) {
			if(menu[i] != null) {
				if (path == menu[i].id) {
					menu[i].style.color = "#FDD100";
				}
			}
		}
	}
</script>
<header class="main-header">
	<section>
		<span id="main_logo" onclick="location.href='/spring/main.action';">
			<img src="" style="cursor: pointer;">
		</span>
		
		<nav>
			<ul>
				<li class="mainbtn" title="study" id="/spring/study/studylist.action"
					onclick="location.href='/spring/study/studylist.action';">스터디</li>
				<li class="mainbtn" title="repo" id="/spring/repo/repolist.action"
					onclick="location.href='/spring/repo/repolist.action';">저장소</li>
				<li class="mainbtn" title="skill" id="/spring/skill/skilltree.action"
					onclick="location.href='/spring/skill/skilltree.action';">스킬트리</li>
				<li class="mainbtn" title="code" id="/spring/code/codelist.action"
					onclick="location.href='/spring/code/codelist.action';" >코드리뷰</li>

			</ul>

		</nav>
		<div class="auth">

			<c:if test="${not empty id}">

				<div class="btn-auth" title="로그아웃"
				onclick="location.href='/spring/signout.action';"> 로그아웃</div>
				
			</c:if>
				
			
		</div>
	</section>
</header>

