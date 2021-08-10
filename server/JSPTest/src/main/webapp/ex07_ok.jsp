<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

	String width = request.getParameter("width");
	String height = request.getParameter("height");
	String text = request.getParameter("text");
	String bgcolor = request.getParameter("bgcolor");
	String fontcolor = request.getParameter("fontcolor");
	String size = request.getParameter("size");
	String btnnum = request.getParameter("btnnum");
	int num = Integer.parseInt(btnnum);
	String range1 = request.getParameter("range1");
	String range2 = request.getParameter("range2");

	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>
	.table{ width: 600px; text-align: center;}
	
	.table tr, .table td{
		border: 1px solid #ddd;
	}
	
	.btns {
		width: <%= width %>px;
		height: <%= height %>px;
		background-color: <%= bgcolor%>;
		color: <%= fontcolor%>;
		font-size: <%= size %>px;
		margin: <%= range1%>px <%= range2%>px;
	}
</style>

</head>
<body>
	<!-- ex07_ok.jsp -->
	<div class="container">
		<h1 class="page-header">결과</h1>
		
		<table class="table table-border">
			<tr>
				<td>버튼</td>
			</tr>
			<tr>
				<td>
					<% for(int i=0; i<num; i++){ %>
						<input type="button" value="<%= text %>" class="btns">
					<%} %>
				</td>
			</tr>
		
		</table>
		
		
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>