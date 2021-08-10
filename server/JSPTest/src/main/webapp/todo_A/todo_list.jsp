<%@page import="com.test.jsp.jdbc.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%

	//DB 작업
	Connection conn = null;
	Statement stat = null;
	ResultSet rs = null;
	
	try {
		
		String sql = "select seq, todo, complete, to_char(regdate, 'yyyy.mm.dd') as regdate from tblTodo order by seq";
		
		conn = DBUtil.open();
		stat = conn.createStatement();
		
		rs = stat.executeQuery(sql);
		
	} catch (Exception e) {
		System.out.println(e);
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%@ include file="/inc/asset.jsp" %>

<style>
	.container {
		width: 500px;
		box-shadow: 0px 0px 5px #777;
		height: 100vh;
	}
	.container .page-header {
		font-variant: small-caps;
		letter-spacing: -1px;
	}
	
	.container .table th {
		text-align: center;
		vertical-align: middle;
		font-variant: small-caps;
	}
	
	.container .table th:nth-child(1) {
		width: 50px;
	}
	.container .table th:nth-child(3) {
		width: 70px;
	}
	
	.container .table td {
		text-align: center;
		vertical-align: middle;
	}
	.container .table td:nth-child(2) {
		text-align: left;
	}
	
	td .glyphicon {
		font-size: 12px;
		display: flex;
		padding: 3px;
	}
	
	td:nth-child(2) {
		cursor: pointer;
	}
	
	td:nth-child(2):hover {
		background-color: #EEE;
	}
	
	td small {
		font-size: 10px;
		color: #AAA;
	}
	
	.btns {
		display: flex;
		justify-content: space-between;
	}
	
	.complete {
		text-decoration: line-through;
		opacity: .7;
	}
	
	#sel1 {
		width: 100px;
		margin-left: auto;
		margin-right: 0px;
		margin-bottom: 10px;
	}
	
</style>

</head>
<body>
	<!-- todo_list.jsp -->
	<div class="container">
		<h1 class="page-header">Todo List <small>List</small></h1>	
		
		<div class="header">
			<select id="sel1" class="form-control">
				<option value="2">모두</option>
				<option value="0">미완료</option>
				<option value="1">완료</option>
			</select>
		</div>	
		
		<table class="table table-bordered">
			<tr>
				<th><input type="checkbox" name="cbAll" id="cbAll"></th>
				<th>Todo</th>
				<th></th>
			</tr>
			<%
				while (rs.next()) {
			%>
			<tr>
				<td>
					<input type="checkbox" name="cbItem" class="cbItem" value="<%= rs.getString("seq") %>">
				</td>
				<td>
					<span 
						data-seq="<%= rs.getString("seq") %>" 
						data-complete="<%= rs.getString("complete") %>" 
						<% if (rs.getString("complete").equals("1")) { out.print("class='complete'"); } %>
					>
						<%= rs.getString("todo") %>
					</span>
					<small><%= rs.getString("regdate") %></small></td>
				<td>
					<button type="button" 
						class="btn btn-success btn-xs" 
						data-toggle="tooltip" 
						title="할일을 수정합니다." 
						onclick="edit(<%= rs.getString("seq") %>);"
					>
						<span class="glyphicon glyphicon-edit"></span>
					</button>
				</td>
			</tr>
			<%
				}
			%>
		</table>
		<div class="btns">
			<input type="button" value="삭제하기" class="btn btn-danger" data-toggle="tooltip" title="체크된 할일을 삭제합니다." onclick="del();">
			<button type="button" class="btn btn-primary" data-toggle="tooltip" title="할일을 추가합니다." onclick="add();">추가하기</button>
		</div>
		
		
	</div>	
	
	<script>
	  
		$('[data-toggle="tooltip"]').tooltip();	
		
	
	  	function add() {
	  		location.href = 'todo_add.jsp';
	  	}
	  	
	  	function edit(seq) {
	  		location.href = 'todo_edit.jsp?seq=' + seq;
	  	}
	  	
	  	function del() {
	  		
	  		if ($('.cbItem:checked').length > 0) {
		  		if (confirm('선택한 할일을 삭제하겠습니까?')) {
		  			let temp = "";
		  			$('.cbItem:checked').each(function(index, item) {
		  				temp += $(item).val() + ",";
		  			});
		  			location.href = 'todo_delok.jsp?seq=' + temp;
		  		}
	  		} else {
	  			alert('삭제할 항목을 선택하세요.');
	  		}
	  	}
	  	
	  	$('#cbAll').click(function() {
	  		$('.cbItem').prop('checked', $('#cbAll').prop('checked'));
	  	});
	  	
	  	$('td > span').click(function() {
	  		
	  		let seq = $(this).data('seq');
	  		let complete = $(this).data('complete');
	  		
	  		location.href = 'todo_complete.jsp?seq=' + seq + '&complete=' + complete;
	  		
	  	});
		
	  	$('#sel1').change(function() {
	  		
	  		/*
	  		if ($(this).val() == 2) {
	  			$('tr').show();
	  		} else if ($(this).val() == 1) {
		  		$('td > span').each(function(index, item) {
					if ($(item).data('complete') == '1') {
						$(item).parents('tr').show();
					} else {
						$(item).parents('tr').hide();
					}
		  		});
	  		} else {
	  			$('td > span').each(function(index, item) {
					if ($(item).data('complete') == '0') {
						$(item).parents('tr').show();
					} else {
						$(item).parents('tr').hide();
					}
		  		});
	  		}
	  		*/
	  		
	  		
	  		$('tr').show();
	  		
	  		if ($(this).val() == 1) {
		  		$('td > span').each(function(index, item) {
					if ($(item).data('complete') == '0') {
						$(item).parents('tr').hide();
					}
		  		});
	  		} else if ($(this).val() == 0) {
	  			$('td > span').each(function(index, item) {
					if ($(item).data('complete') == '1') {
						$(item).parents('tr').hide();
					}
		  		});
	  		}
	  		
	  	});
	  	
	</script>
</body>
</html>


<%
	rs.close();
	stat.close();
	conn.close();
%>












