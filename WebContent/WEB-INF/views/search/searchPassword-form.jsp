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
	
<form action="${context}/search/confirm-password" enctype="x-www-form-urlencoded" method="GET" autocomplete="off">
		<div class = "test" style="min-height: 50px;">
			<h1 id = "search_tit" >KHS 회원 비밀번호 재설정 </h1>
		</div>
		<div class = 'test'>
			
			
			<h2>변경하실 비밀번호를 올바르게 입력하고 <br>
			       중복검사 후  확정버튼을 눌러주세요 </h2>
			<input type="password" name="password" id='password' placeholder="비밀번호 (8-12자 이내, 영문,숫자, 특수기호가 필요합니다.)"><br>
				<div class = "validCheckPassed" id = "userPwPassed" ></div>
				<div class = "validCheckFailed" id = "userPwFailed"></div>
			<input type="password" name="passwordCheck" id='passwordCheck' placeholder="비밀번호 확인(8-12자 이내, 영문,숫자, 특수기호가 필요합니다.)">
			<br>
				<div class = "validCheckPassed" id = "passwordAgainPassed"></div>
				<div class = "validCheckFailed" id = "passwordAgainFailed"></div>
			<button class = 'commitPassword' id='commitPassword'  type="button">비밀번호 확정</button>	
		</div>
		<button class = "commitButton" id = 'backButton' type="button">뒤로</button><button class = "commitButton" id='joinButton' type="submit" style="pointer-events: none;">비밀번호 변경</button>
</form>
</div> 
<footer></footer>
<script type="text/javascript">
	
	var pw = '<%=(String)session.getAttribute("checkPasswordIsUnique")%>';
	console.log(pw)
	let firstPw = false; 
	let confirmPasswordCheck = false;
	let finalPasswordCheck = false; 
	
	//****2. Front 비밀번호 정규표현식 검증 ****
	document.querySelector("#password").addEventListener('input', e => {
		
		let dom = document.querySelector('#password');
		let passed = document.querySelector('#userPwPassed');
		let failed = document.querySelector('#userPwFailed');
		
		// 비밀번호에 변경이 가해질 경우 중복검사를 초기화 
		let domCheckPw = document.querySelector('#passwordCheck');
		let passedCheckPw = document.querySelector('#passwordAgainPassed');
		let failedCheckPw = document.querySelector('#passwordAgainFailed');
		
		domCheckPw.style.border = "3px solid #D5D5D5";
		passedCheckPw.style.display = "none";
		failedCheckPw.style.display = "none";
		domCheckPw.value = "";
		
		// 1. 정규표현식 검증
		
		// 정규표현식 검증을 위한 객체 생성
		// 공백 / 특수문자 / 제외한 첫 글자가 알파벳인 3에서 12자리 이내의 영문+숫자 조합 아이디 
		/* ?=.의 검색의 경우 RegExp 객체로 생성하면 올바르게 작동하지 않음  */
		var pwExpr = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,12}$/;
		let whiteSpaceExpr = new RegExp('\\s');
		
		//빈 칸으로 되돌아갔을 시 원상복귀 
		if(dom.value == "") {
			dom.style.border = "3px solid #D5D5D5";
			passed.style.display = "none";
			failed.style.display = "none";
			
			confirmPasswordCheck = false;
			firstPw = null;
			return;
		}
		
		if(whiteSpaceExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp비밀번호에 공백을 포함할 수 없습니다';
			
			confirmPasswordCheck = false;
			firstPw = null;
			return;
		}
		//비밀번호 조건 검증
		if(!pwExpr.test(dom.value)) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp8-12자 이내, 영문,숫자, 특수기호가 필요합니다';
			
			confirmPasswordCheck = false;
			firstPw = null;
			return;
		} 
		//일치 시 태두리 green 
		if(pwExpr.test(dom.value)) {
			dom.style.border = "3px solid #D5D5D5";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp사용 가능한 비밀번호 입니다. 비밀번호 확인을 입력하세요';
			firstPw = true; 
			firstPw = dom.value;
		}
		
	})

	//****3. Front 비밀번호 중복 검증 ****
	document.querySelector("#passwordCheck").addEventListener('input', e => {
		
		let pwDom = document.querySelector('#password');
		let pwPassed = document.querySelector('#userPwPassed');
		let pwFailed = document.querySelector('#userPwFailed');

		let dom = document.querySelector('#passwordCheck');
		let passed = document.querySelector('#passwordAgainPassed');
		let failed = document.querySelector('#passwordAgainFailed');
		
		if(dom.value == "") {
			dom.style.border = "3px solid #D5D5D5";
			passed.style.display = "none";
			failed.style.display = "none";
			confirmPasswordCheck = false;
			return;
		}
		
		if(firstPw == null) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp첫 번째 비밀번호를 먼저 입력하세요';
			confirmPasswordCheck = false;
			return;
		}
		
		if(!(firstPw == dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp일치하지 않는 비밀번호입니다';
			confirmPasswordCheck = false;
			return;
		}
		
		if(firstPw == dom.value){
			dom.style.border = "3px solid #6ED000";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp비밀번호 중복 검사가 완료되었습니다';
			
			pwDom.style.border = "3px solid #D5D5D5";
			pwPassed.style.display = "block";
			failed.style.display = "none";
			pwPassed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp중복검사가 완료되었습니다. 비밀번호를 확정하세요';
			confirmPasswordCheck = true;
		}
		
	})

//****1-2. 패스워드 중복검사 버튼 기능 ****
document.querySelector('#commitPassword').addEventListener('click', e => {
	
	let dom = document.querySelector('#password');
	let passed = document.querySelector('#userPwPassed');
	let failed = document.querySelector('#userPwFailed');
	
	if(confirmPasswordCheck != true){
		dom.style.border = "3px solid #FF6161";
		failed.style.display = "block";
		passed.style.display = "none";
		failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp입력 조건에 맞는 비밀번호를 다시 입력하세요';
		confirmPasswordCheck = false; 
		return;
	}
	
	fetch('/search/checkPassword-Method?password='+ dom.value)
	.then(response => response.text())
	.then(text => {
		if(text == 'invalid'){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이전에 사용하신 비밀번호는 다시 사용하실 수 없습니다.';
			finalPasswordCheck = false;  
			dom.blur();
			return;
		}
		if(text == 'valid'){
			dom.style.border = "3px solid #6ED000";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp사용 가능한 비밀번호입니다.';
			document.querySelector('#joinButton').style.setProperty('background-color', 'white');
			document.querySelector('#joinButton').style.setProperty("pointer-events", "auto"); 
			finalPasswordCheck = true ; 
		}	
	})
})

	let allInput = document.querySelectorAll('input');
	//****8. 최종, 전송 버튼 활성화  ****
	allInput.forEach( item => {
		
		let dom = document.querySelector('#joinButton');
		item.addEventListener('input', event => {
			if(
					firstPw&
					confirmPasswordCheck&
					finalPasswordCheck
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
	
	allInput.forEach( item => {
			
			let dom = document.querySelector('#joinButton');
			item.addEventListener('blur', event => {
				if(
						firstPw&
						confirmPasswordCheck&
						finalPasswordCheck
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