<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${empty id }">
<form method="POST" action="/code/signin.action">
	<input type="password" name="pw" class="form-control" required autofocus placeholder="passoword">
</form>        
</c:if>

<c:if test="${not empty id }">
<div onclick="location.href='/code/list.action';" class="signed">signed. Code</div>

<div onclick="location.href='/code/signout.action';" class="signed">sign out.</div>
</c:if>





