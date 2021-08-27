<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webProject</title>

<%@ include file="/inc/asset.jsp" %>

<style>
   
   .register-box{
	border: 1px solid #e1e2e3;
   	width: 55%;
   	margin: 80px auto;
   	height: auto;
   	background-color: #fff;
	
   }
   
   .register-box .register-content .title{
    border-bottom: 1px solid #e1e2e3;
   	padding: 20px;
   	font-size: 20px;
   	font-weight: bold;
   	background-color: #548CA8;
   	text-align: center;
   	color: #fff;
   }
   
   .register-tbl{
   	margin-top: 5px;
   	width: 100%;
	font-size: 18px;
	padding: 10px;
   }
   
   
    .register-tbl tr td{
    	padding: 12px;
    	padding-left: 90px;
    }
   
   .register-tbl td input {
   	border: 1px solid #e1e2e3;
   	border-radius: 5px;
   	width: 250px;
   	height: 50px;
   	padding: 5px;
   	margin-left: 17px;
   
   }
   .register-tbl td select {
   	border: 1px solid #e1e2e3;
   	width: 230px;
   	height: 50px;
   	padding: 5px;
   }
   
   .register-tbl .date input{
   	width: 170px;
   	font-size: 16px;
   }
   
   .register-tbl .date span{
   	margin: 5px;
   }
 
   
   #detail-address #search{
   	width: 60px;
   	height: 48px;
   	font-size: 13px;
   	border: 0px;
   }
   
   .postContent {
    border: 1px solid #e1e2e3;
   	width: 500px;
   	height: 400px;
   	font-size: 20px;
   	padding: 5px;
   	}
   	
   	.register-tbl .attachedFile{
   		width: 300px;
   		margin-left: 0px;
   		margint-top: 5px;
   	}
   	
   	.register-tbl #map-box input{
   		width: 140px;
   		font-size:16px;
   	}
   
   .coltd{
   	text-align: center;
   }
   
   .register-tbl .registerBtn{
   	border: 1px solid #548CA8;
   	background-color: #fff;
   	color: #548CA8;
   	width: 150px;   
   	border-radius: 100px;	
   	font-weight: bold;
   }
   
   
</style>

</head>
<body>
   <!-- jobregister.jsp -->
   <%@ include file="/inc/header.jsp" %>
   
   <section class="main-section">
      
      <div class="register-box">
      	<div class="register-content">
      		<div class="title">${dto.name}_${dto.postName}</div>
      		
      	<form method="POST" action="/webproject/main/member/job/jobenrollok.do?jobPostSeq=${dto.jobPostSeq}" enctype="multipart/form-data">
      		<table class="register-tbl">
      			
      			
      			<tr>
      				<td>이름<input type="text" value="${name}" readonly></td>
      			</tr>
      			<tr>
      				<td class="date">
      					날짜<input type="date" id="today" readonly>
      				</td>
      			</tr>
      			<tr>
      				<td>직군<input type="text" value="${dto.jobGroup}" readonly></td>
      			</tr>
      			<tr>
      				<td>학력<input type="text" value="${dto.educationLevel }" readonly></td>
      			</tr>
      			<tr>
      				<td>경력<input type="text" value="${dto.career}" readonly></td>
      			</tr>
      			
      			<tr>
      				<td>
      					첨부파일<br><input type="file" name ="attachedFile" class="attachedFile" required>
      				</td>
      			</tr>      			
      			<tr>
      				<td style="padding-left: 150px;">
						<input type="submit" value="등록" class="registerBtn">
					</td>
      			</tr>
            
      		</table>
      		<input type="hidden" name="jobPostSeq" value="${dto.jobPostSeq}">
	      	<input type="hidden" name="memberSeq" value="${memberSeq}">
      		</form>
      	</div>
      </div>

      
      
   </section>   
   
   <%@ include file="/inc/footer.jsp"%>
   <%@ include file="/inc/init.jsp" %>
	
   <script>
	   window.onload = function() {
			today = new Date();
			console.log("today.toISOString() >>>" + today.toISOString());
			today = today.toISOString().slice(0, 10);
			console.log("today >>>> " + today);
			bir = document.getElementById("today");
			bir.value = today;
		}
   </script>
</body>
</html>



