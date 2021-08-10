<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>

</style>

</head>
<body>
	<!-- ex16_jstl.jsp -->
	<div class="container">
		<h1 class="page-header">JSTL</h1>
		
		
		<%--
			JSTL 액션태그, JSP Standard Tag Library
			- <c:XXX> 형식
			- 프로그래밍 기능을 하는 태그
		
		--%>
		
		<h2>변수 선언</h2>
		<% 
			int a = 10; //지역 변수
			pageContext.setAttribute("b", 20); //내장객체 변수(속성)
		%>
		<c:set var="c" value="30" /> <!-- JSTL 변수: pageContext에 추가되는 변수(속성) -->
					
		<div>a: <%= a %></div>
		<div>b: <%= pageContext.getAttribute("b") %></div>
		<div>b: ${b}</div>
		<%-- <div>c: <%= c %></div> --%>
		<div>c: ${c }</div> <!-- 추측? > JSTL변수가 내장객체 변수가 아닌지?? -->
		<div><%= pageContext.getAttribute("c") %></div>
		<div><%= request.getAttribute("c") %></div>
		<div><%= session.getAttribute("c") %></div>
		<div><%= application.getAttribute("c") %></div>
		
		<!-- 
			JSTL: XML 문법을 준수. XML은 문법이 엄격하다.
		-->
		
		<h2>변수 수정(선언과 동일)</h2>
		<c:set var="c" value="300" />
		<div>c: ${c }</div>
		
		<h2>변수 삭제(맵 요소 삭제)</h2>
		<c:remove var="c" />
		<div>c: ${c }</div>
		<div>c: ${empty c }</div>

		<hr>
		
		<h2>조건문</h2>

		<%
			int num1 = 10;
		%>

		<% if (num1 > 0){ %>
		<div>숫자 <%= num1 %>은 양수입니다.</div>
		<%} else { %>
		<div>숫자 <%= num1 %>은 양수가 아닙니다.</div>
		<%} %>
		
		<c:set var="num2" value="10" />
		
		<!-- *******JSTL에서 내장객체 변수를 접근하려면 반드시(****) EL을 사용한다. -->
		
		<c:if test="${num2 > 0}">
		<div>숫자 ${num2}는 양수입니다.</div>
		</c:if>
	
		<!-- switch case문 + 다중 if문 -->
		<c:choose>
			<c:when test="${num2 > 0 }">양수입니다.</c:when>
			<c:when test="${num2 < 0 }">음수입니다.</c:when>
			<c:otherwise>0입니다.</c:otherwise>
		</c:choose>
		
		<hr>
		
		<h2>반복문<(for문 = 일반for문 + 향상된 for문)</h2>
		
		<% for(int i=0; i<=10; i++){ %>
		<div>항목 <%= i %></div>
		<%} %>
		
		<c:forEach var="i" begin="0" end="10" step="1">
		<div>item ${i}</div>
		</c:forEach>

		<hr>
		
		<% 
			String[] color={"빨강", "노랑", "파랑", "주황", "녹색", "갈색", "분홍"};
			pageContext.setAttribute("color", color);
		%>

		<ul>
			<%for (String c : color) { %>
			<li><%= c %></li>
			<%} %>
		</ul>
		
		<ol>
			<c:forEach var="c" items="${color}">
			<li>${c}</li>
			</c:forEach>
		</ol>

		
	</div>
	<script>
	
	</script>		
</body>
</html>