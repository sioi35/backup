
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.util.ArrayList"%>

<%
	
	//1. 파일 업로드 처리
	//2. ex18_view.jsp로 이동하기(목록보기)

	//1. 경로
	String path = application.getRealPath("/files");

	//2. 
	int size = 1024 * 1024 * 100;
	
	//3. 첨부 파일의 갯수??
	// - filename: 실제 파일명
	// - orgfilename: 원본 파일명
	ArrayList<String> filename = new ArrayList<String>();
	
	try{
		
		//단일 파일 업로드 == 다중 파일 업로드
		MultipartRequest multi = new MultipartRequest(
									request,
									path,
									size,
									"UTF-8",
									new DefaultFileRenamePolicy()
								);
		// 올린 업로드 파일들의 파일명 ??
		//String[] temp = multi.getParameterValues("attach");
		//System.out.println(Arrays.toString(temp));
		
		//multi.getFilesystemName("attach");
		
		Enumeration e = multi.getFileNames();
		
		while(e.hasMoreElements()){
			//System.out.println(e.nextElement());
			
			filename.add(multi.getFilesystemName(e.nextElement().toString()));
		}
		
	}catch(Exception e){
		System.out.println(e);
	}
	
	response.sendRedirect("ex18_view.jsp");
	
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
	<!-- ex18_file_ok.jsp -->
	<div class="container">
		<h1 class="page-header"></h1>
		
		<%= filename %>
		
	</div>
	
	<script>
	
	</script>		
</body>
</html>