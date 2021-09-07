<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.main-section {
	width: 700px;
}

.main-section .table th {
	width: 120px;
}
.main-section .table td {
	width: 280px;
	text-align: left;
}

</style>

<section class="main-section">
	<h1 class="page-header">${mdto.name}님의 회원정보</h1>
	
	<table class="table table-bordered">
		<tr>
			<td rowspan="8">${mdto.image}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${mdto.name}</td>
		</tr>
		<tr>
			<th>아이디</th>
			<td>${id}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${mdto.phone}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${mdto.birth}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${mdto.email}</td>
		</tr>
		<tr>
			<th>성별</th>
			<td>${mdto.gender}</td>
		</tr>
		<tr>
			<th>사용언어</th>
			<td>${mdto.languagename}</td>
		</tr>
	</table>

</section>
