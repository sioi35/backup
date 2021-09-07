<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<section class="main-section">
	
	<h1>Login</h1>
	
	<div class="user-list">
		<button type="button" class="btn btn-default" 
		onclick="location.href='/spring/signin.action?loginId=hong';">홍길동</button>
		<button type="button" class="btn btn-default" 
		onclick="location.href='/spring/signin.action?loginId=hahaha';">하하하</button>
		<button type="button" class="btn btn-default" 
		onclick="location.href='/spring/signin.action?loginId=hohoho';">호호호</button>
	</div>
	
</section>


<script>
	
</script>