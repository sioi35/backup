<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
   <!-- ex17_file_form.jsp  -->
   <div class="container">
      <h1 class="page-header">파일 업로드</h1>
      
      
      <!-- 
      
         택스트 7000자 전송 -> 에러 -> 7000B -> 7KB
         파일 업로드 규칙
         1. <form>의 method를 반드시 "POST"를 사용한다.
         2. <input type="file">을 사용한다.'
         3. <form> 태그에 enctype = "multipart/form-data" 속성을 추가한다.
            - enctype(인코딩 타입: 폼태그가 서버로 데이터를 전송할 때 사용할 인코딩 방식을 지정)
            a. application/x-www-form-urlencoded: 기본값, 문자열만 전송
            b. multipart/form-data: 비문자열까지 같이 전송(첨부 파일 전송)
       -->
       
       
         <!-- <form method="POST" action="ex17_file_ok.jsp">
         <textarea name="txt"></textarea>
         <input type="submit" value="전송하기">
         </form> -->
         
         
         <form method="POST" action="ex17_file_ok.jsp" enctype="multipart/form-data">
            <div>제목: <input type="text" name = "subject"></div>
            <div>이름: <input type="text" name = "name"></div>
            <div>파일: <input type="file" name = "attach"></div>
            <div><input type="submit" value="보내기"></div>
            
         </form>
         

   </div>

   <script>
   
   
   </script>   
</body>
</html>