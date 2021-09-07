<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/inc/asset_repo.jsp"%>
</head>
<body>
	<section class="main-section">

		<div class="codeview-container">
			
			<div class="top-container">
				<div class="detail">
					<span class="filename">${filedto.name}/${filedto.fileName}</span>
					<span class="regdate">${filedto.regdate}</span>
					
				     <button type="button" class="editbtn" id="editbtn">Edit Code</button>
               		 <button type="button" class="editbtn" id="savebtn" style="display: none;">Save Code</button>
				</div>
			</div>
			<form id="editcode">
			<div class="code-container">
			<input type="hidden" value="${filedto.fileSeq}" name="fileSeq">
			<input type="hidden" value="${filedto.fileName}" name="fileName">
				<div class="code-box">
					<textarea readonly id="content" name="content">${content}</textarea>
				</div>
			</div>
			</form>
		</div>


	</section>

	<script>
      
      $('#editbtn').click(function(){
         $('#content').attr('readonly', false);
         $('#editbtn').hide();
         $('#savebtn').show();
      });
      
      $('#savebtn').click(function(){
         $.ajax({
            type:'POST',
            url: '/spring/repo/editcode.action',
            data: $('#editcode').serialize(),
            dataType: 'json',
            success: function(result){
               if(result==1){
                  $('#content').attr('readonly', true);
                  $('#savebtn').hide();
                  $('#editbtn').show();
               }else{
                  alert('실패');
               }
            },
            error: function(a,b,c){
               console.log(a,b,c);
            }
         });
      });
      
   </script>



</body>
</html>