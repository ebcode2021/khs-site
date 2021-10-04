<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resources/css/common/all.css" rel="stylesheet">
<link rel="stylesheet" href="../resources/css/search/search_ui.css">
<title>K H S</title>
</head>
<body>
<header class = 'header'>
	<div class = 'headerName'>K H S</div>
</header>
<div class = 'wrapper'>
	<div class = 'test' id = 'wrapImg'>
		<i class="fas fa-user-circle"></i>
	</div>
	
<form action="${context}/search/searchId-Method" enctype="x-www-form-urlencoded" method="GET" autocomplete="off">
		<div class = "test" style="min-height: 50px;">
			<h1 id = "search_tit" >KHS 회원  아이디 찾기 </h1>
		</div>
		<div class = 'test'>


			<h2>01. 가입 시의 이름과 생년월일을 입력하세요</h2>
			<input type="text" name='name' id='name' placeholder="이름(2-4자의 한글이름)"><br>
				<div class = "validCheckPassed" id = "namePassed"></div>
				<div class = "validCheckFailed" id = "nameFailed"></div>
			<input type="text" name='birth' id='birth' placeholder="생년월일" onfocus="(this.type='date')" onblur="(this.type='text')">
			<div class = "validCheckPassed" id = "birthPassed"></div>
			<br>
		</div>
		<div class = 'test' id ="emailTestDiv" >
			<h2>02. 가입 시 인증하신 이메일을 입력하세요</h2>
			<input type="text" name='email' id='email' placeholder="이메일(가입 시 사용하셨던 이메일을 작성하세요)"><br>
				<div class = "validCheckPassed" id = "emailPassed"></div>
				<div class = "validCheckFailed" id = "emailFailed"></div>
			<h2 style="color:lightgray;"> *공백 없이 입력을 완료하셔야 아이디 찾기를 이용하실 수 있습니다.</h2>
			<h2 style="color:lightgray;"> *비밀번호 재설정은 발송된 이메일의 링크를 통해 설정하실 수 있습니다</h2>
		</div>
		<button class = "commitButton" id = 'backButton' type="button">뒤로</button><button class = "commitButton" id='joinButton' type="submit" style="pointer-events: none;">아이디 찾기</button>
</form>
</div> 
<footer></footer>
<script type="text/javascript">
	
	let confirmEmail = false;  
	let confirmName = false; 
	let confirmBirth = false; 
	 
	//****3. Front 이메일 정규표현식 검증 ****
	document.querySelector("#email").addEventListener('input', e => {
		
		let dom = document.querySelector('#email');
		let passed = document.querySelector('#emailPassed');
		let failed = document.querySelector('#emailFailed');
		// 1. 정규표현식 검증
		
		// 정규표현식 검증을 위한 객체 생성
		// 공백 / 특수문자 / 제외한 첫 글자가 알파벳인 3에서 12자리 이내의 영문+숫자 조합 아이디 
		/* ?=.의 검색의 경우 RegExp 객체로 생성하면 올바르게 작동하지 않음  */
		let testExpr = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		let whiteSpaceExpr = new RegExp('\\s');
		
		//빈 칸으로 되돌아갔을 시 원상복귀 
		if(dom.value == "") {
			dom.style.border = "3px solid #D5D5D5";
			passed.style.display = "none";
			failed.style.display = "none";
			confirmEmail = false;
			return;
		}
		if(whiteSpaceExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이메일에 공백을 포함할 수 없습니다';
			confirmEmail = false;
			return;
		}
		//이메일 조건 검증
		if(!testExpr.test(dom.value)) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp올바르지 않은 이메일 주소입니다';
			confirmEmail = false;
			return;
		} 
		//일치 시 태두리 green 
		if(testExpr.test(dom.value)) {
			dom.style.border = "3px solid #6ED000";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp올바른 이메일 양식입니다.';
			confirmEmail = true;
		}
		
	})
	
	//****6. Front 이름 정규표현식 검증 ****
	document.querySelector("#name").addEventListener('input', e => {
		
		let dom = document.querySelector('#name');
		let passed = document.querySelector('#namePassed');
		let failed = document.querySelector('#nameFailed');
		// 1. 정규표현식 검증
		
		// 정규표현식 검증을 위한 객체 생성
		// 공백 / 특수문자 / 제외한 첫 글자가 알파벳인 3에서 12자리 이내의 영문+숫자 조합 아이디 
		/* ?=.의 검색의 경우 RegExp 객체로 생성하면 올바르게 작동하지 않음  */
		let testExpr = new RegExp('^[가-힣]{2,4}$');
		let whiteSpaceExpr = new RegExp('\\s');
		let specialExpr = new RegExp('\[~!@#$%^&*()_+|<>?:{}]');
		
		//빈 칸으로 되돌아갔을 시 원상복귀 
		if(dom.value == "") {
			dom.style.border = "3px solid #D5D5D5";
			passed.style.display = "none";
			failed.style.display = "none";
			confirmName = false;
			return;
		}
		if(whiteSpaceExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이름에 공백을 포함할 수 없습니다';
			confirmName = false;
			return;
		}
		//특수문자 검증
		if(specialExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이름에 특수문자를 사용하실 수 없습니다';
			confirmName = false;
			return;
		}
		//이름 조건 검증
		if(!testExpr.test(dom.value)) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp올바르지 않은 이름입니다';
			confirmName = false;
			return;
		} 
		//일치 시 태두리 green 
		if(testExpr.test(dom.value)) {
			dom.style.border = "3px solid #6ED000";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp올바른 이름입니다';			
			confirmName = true;
		}
		
	})
	
	//****7. Front 달력 검증 ****
	document.querySelector('#birth').addEventListener('input', e => {
		let dom = document.querySelector('#birth');
		let passed = document.querySelector('#birthPassed');
		passed.style.display = "block";
		dom.style.border = "3px solid #6ED000";
		passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp생년월일이 확인되었습니다';
		confirmBirth = true;
	})
	

	
	let allInput = document.querySelectorAll('input');
	//****8. 최종, 회원가입 버튼 활성화  ****
	allInput.forEach( item => {
		
		let dom = document.querySelector('#joinButton');
		item.addEventListener('input', event => {
			if(
			confirmEmail&
			confirmName&
			confirmBirth
			){
				// 모든 조건들이 올바르게 input 되었을 시 pointer-events 해제 
				dom.style.setProperty('background-color', 'white');
				dom.style.setProperty("pointer-events", "auto");
			} else {
				// 조건 중 하나가 미흡하게 변경되었을 시 다시 backgroundColor 되돌리고 event none 변경
				dom.style.backgroundColor = 'lightgray';
				dom.style.setProperty("pointer-events", "none");
			}
		})
	});
	
	// ***** 로그인 페이지로 redirect 
	document.querySelector('#backButton').addEventListener('click', e => {
		location.href = '/login';
	})
</script>
</body>
</html>