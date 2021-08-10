<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>

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
   <!-- ex17_file_ok.jsp -->
   <div class="container">
      <h1 class="page-header">결과</h1>
      
      <div>제목: ${subject }</div>
      <div>이름:  ${name }</div>
      <div>첨부파일명: ${filename }</div>
      <div>첨부파일명: ${orgfilename }</div>
      
      <h2>다운로드</h2>

	  <!-- 가장 완벽한 방법 -->      
      <div><a href="/jsp/download.jsp?filename=${filename}&orgfilename= ${orgfilename}"> ${orgfilename }</a></div>
      
      
   </div>


   <script>
   
   
   
   </script>   
</body>
</html>