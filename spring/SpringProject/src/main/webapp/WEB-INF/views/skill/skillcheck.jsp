<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

	<h2>${fdto.name}</h2>

	<div id="timer">
		제한시간: <span>${fdto.time}</span>분
	</div>
	
	<div class="problem-list">
		<c:forEach items="${slist}" var="sdto">
			<div class="subject" data-subject="{sdto.name}">
				<h3>${sdto.name}</h3>
				<hr>
				<c:forEach items="${sdto.qlist}" var="pdto">
					<div class="problem" data-answer="${pdto.answer}">
						<textarea rows="" cols="" class="content" disabled>${pdto.content}</textarea>
						<hr>
						<input type="text" class="uanswer">
						<hr>
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div>
	
	<button type="button" id="submit" class="btn btn-default">제출</button>

</div>

<script>

	let time = ${fdto.time};
	
	$('#timer > span').text(time);

	let timer = setInterval(function() {
		time--;
		$('#timer > span').text(time);
		if (time == 5) {
			alert('제한시간이 5분 남았습니다.');
		}
		if (time < 0) {
			clearInterval(timer);
			alert('시험이 종료되었습니다.');
			submit();
		}
	}, 60000);
	
	$('#submit').click(function() {
		if (confirm('시험을 종료하시겠습니까?')) {
			submit();
		}
	});
	
	function submit() {
		let slist = [];
		
		$('.subject').each(function(index, subject) {
			let name = $(subject).data('subject');
			let answers = [];
			let uanswers = [];
			
			$(subject).children('.problem').each(function(index, problem) {
				answers.push($(problem).data('answer'));
				uanswers.push($(problem).children('.uanswer'));
			});
			
			let sbj = {
				name: name,
				answers: answers,
				uanswers: uanswers
			};
			
			slist.push(sbj);
		});
		
		for (var i=0; i<slist.length; i++) {
			alert(slist[i].name);
		}
	}

</script>