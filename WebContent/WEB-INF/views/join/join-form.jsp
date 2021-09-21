<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resources/css/common/all.css" rel="stylesheet">
<link rel="stylesheet" href="../resources/css/login_ui.css">
</head>
<body>
<header class = 'header'>
	<div class = 'headerName'>K H S</div>
</header>
<div class = 'wrapper'>
	<div class = 'test' id = 'wrapImg'>
		<i class="fas fa-user-circle"></i>
	</div>
	<form action="${context}/join/join-Method" enctype="multipart/form-data" method="post" autocomplete="off">
		<div class = 'test'>
			<h2>01. 아이디와 비밀번호를 입력 해 주세요.</h2>
			<input type="text" name="userId" id='userId' placeholder="아이디 (4-12자 이내, 영문, 숫자 모두 사용 가능합니다.)"><br>
				<div class = "validCheckPassed" id = "userIdPassed"></div>
				<div class = "validCheckFailed" id = "userIdFailed"></div>
			<input type="text" name="password" id='password' placeholder="비밀번호 (8-12자 이내, 영문,숫자, 특수기호가 필요합니다.)"><br>
				<div class = "validCheckPassed" id = "userPwPassed" ></div>
				<div class = "validCheckFailed" id = "userPwFailed"></div>
			<input type="text" name="passwordCheck" id='passwordCheck' placeholder="비밀번호 확인(8-12자 이내, 영문,숫자, 특수기호가 필요합니다.)"><br>
				<div class = "validCheckPassed" id = "passwordAgainPassed"></div>
				<div class = "validCheckFailed" id = "passwordAgainFailed"></div>
		</div>
		<div class = 'test'>
			<h2>02. 이메일을 입력하고 인증번호를 확인하세요.</h2>
			<input type="text" name='email' id='email' placeholder="이메일(인증 번호를 받을 수 있는 이메일을 입력하세요.)"><br>
				<div class = "validCheckPassed" id = "emailPassed"></div>
				<div class = "validCheckFailed" id = "emailFailed"></div>
			<button class = 'sendEmail' type="button">인증번호 전송</button>
		<div class = emailValiWrapper>
			<input type="text" name='emailVali' id='emailVali' class = "emailVali" placeholder="인증번호를 입력하세요."><span>00 : 00</span>
		</div>
			<div class = "validCheckPassed" id = "emailValiPassed"></div>
			<div class = "validCheckFailed" id = "emailValiFailed"></div>
			<button class = 'variEmail' type="button">인증하기</button>
		</div>
		<div class = 'test'>
			<h2>03. 이름과 생년월일, 별명을 입력 해 주세요.</h2>
			<h3>*별명은 커뮤니티 활동에서 ID와 이름 대신 사용합니다.</h3>
			<input type="text" name='name' id='name' placeholder="이름(2-4자의 한글이름)"><br>
				<div class = "validCheckPassed" id = "namePassed"></div>
				<div class = "validCheckFailed" id = "nameFailed"></div>
			<input type="text" name='birth' id='birth' placeholder="생년월일" onfocus="(this.type='date')" onblur="(this.type='text')">
			<div class = "validCheckPassed" id = "birthPassed"></div>
			<br>
			<div class = "NickNameWrapper"> 
				<input type="text" name='nickName' id='nickName' class = "nickName" placeholder="별명(4-8자리 이내 특수문자 제외한 한영숫자 조합)">
				<button class = 'checkNickName' id = 'checkNickName' type="button">중복 검사</button>
			</div>
			<div class = "validCheckPassed" id = "nickNamePassed"></div>
			<div class = "validCheckFailed" id = "nickNameFailed"></div>
		</div>
			<div class='test'>
				<h2>
					04. 인증을 위해 KH 정보교육원 홈페이지에 들어가<br> 마이페이지 이미지를 캡쳐한 후 업로드 해 주세요.
				</h2>
				<div class = "selectKHWrapper">
				<select name='selectKH' id='selectKH' class="selectKH">
					<option value="" disabled selected>현재 다니시는 학원 지점을 선택하세요</option>
					<option value="gangnam">강남 지점</option>
					<option value="itewon">이태원 지점</option>
				</select><br>
				<div class = "validCheckPassed" id = "centerPassed"></div>
					<div class="fileboxWrapper">
	 				    <label for="khFile"><i class="fas fa-file-image"></i></label>
					    <input class="upload-name" id = "upload-name" placeholder="첨부파일"> 
					    <input type="file" name="file" class = 'khFile' id="khFile" accept="image/*,.pdf"/>
					</div>
				</div>
				<div class = "validCheckPassed" id = "filePassed"></div>
			</div>
			<div class = 'test'>
			<h2>05. 모든 항목을 입력하셨다면 약관에 동의 후<br>회원가입 버튼을 눌러주세요.</h2>
			<h3>*회원가입 버튼은 모든 항목을 입력하셔야 활성화 할 수 있습니다.</h3>
<pre class = "agreePre">

본 서비스 약관에는 Google의 사업 운영 방식, Google에 적용되는 법률, 
Google이 항상 진실이라고 여기는 특정 내용이 반영되어 있습니다.
 따라서 귀하가 Google 서비스와 상호작용하면 본 서비스 약관을 근거로
Google과의 관계가 정의됩니다.
예를 들어, 약관에는 다음과 같은 제목의 주제들이 포함됩니다.
본 서비스 약관에는 Google의 사업 운영 방식, Google에 적용되는 법률, 
Google이 항상 진실이라고 여기는 특정 내용이 반영되어 있습니다.
 따라서 귀하가 Google 서비스와 상호작용하면 본 서비스 약관을 근거로
Google과의 관계가 정의됩니다.
예를 들어, 약관에는 다음과 같은 제목의 주제들이 포함됩니다.
본 서비스 약관에는 Google의 사업 운영 방식, Google에 적용되는 법률, 
Google이 항상 진실이라고 여기는 특정 내용이 반영되어 있습니다.
 따라서 귀하가 Google 서비스와 상호작용하면 본 서비스 약관을 근거로
Google과의 관계가 정의됩니다.
예를 들어, 약관에는 다음과 같은 제목의 주제들이 포함됩니다.
본 서비스 약관에는 Google의 사업 운영 방식, Google에 적용되는 법률, 
Google이 항상 진실이라고 여기는 특정 내용이 반영되어 있습니다.
 따라서 귀하가 Google 서비스와 상호작용하면 본 서비스 약관을 근거로
Google과의 관계가 정의됩니다.
예를 들어, 약관에는 다음과 같은 제목의 주제들이 포함됩니다.
본 서비스 약관에는 Google의 사업 운영 방식, Google에 적용되는 법률, 
Google이 항상 진실이라고 여기는 특정 내용이 반영되어 있습니다.
 따라서 귀하가 Google 서비스와 상호작용하면 본 서비스 약관을 근거로
Google과의 관계가 정의됩니다.
예를 들어, 약관에는 다음과 같은 제목의 주제들이 포함됩니다.

</pre>
		<h3 class = "agreeTitle">(필수)약관에 동의 하십니까?</h3>
		 	<input type="radio" name='agreeLogin' id="agreeLogin" class="agreeLogin" checked>
	  		<label class = "agreeLabel" for="agreeLogin">동의</label>
	  		<input type="radio" name='agreeLogin' id="disagreeLogin" class="agreeLogin">
	  		<label class = "agreeLabel" for="disagreeLogin">비동의</label>
		<button class = "commitButton">뒤로</button><button class = "commitButton" type="submit" disabled="disabled">회원가입</button>
</div> 
	</form>
</div>
<footer></footer>

<script type="text/javascript">
	
	let confirmId = false; 
	let confirmPasswordCheck = false;
	let confirmEmail = false; 
	let confirmCode = false; 
	let confirmName = false; 
	let confirmBirth = false; 
	let confirmNickname = false; 
	let confirmImgFile = false; 
	let confirmAgree = false; 
	
	/* 비밀번호 중복 확인용 객체 */
	let firstPw = null; 
	/* 별명 정규표현식 확인용 객체 */
	let nicNameCheck = null;
	
	//****1. Front 아이디 정규표현식 검증 ****
	document.querySelector("#userId").addEventListener('input', e => {
		
		let userIdInput = document.querySelector('#userId');
		let IdCheckPassed = document.querySelector('#userIdPassed');
		let IdCheckFailed = document.querySelector('#userIdFailed');
		// 1. 정규표현식 검증
		
		// 정규표현식 검증을 위한 객체 생성
		// 공백 / 특수문자 / 제외한 첫 글자가 알파벳인 3에서 12자리 이내의 영문+숫자 조합 아이디 
		let idExpr = new RegExp('\^[A-Za-z]{1}[A-Za-z0-9]{3,12}$');
		let whiteSpaceExpr = new RegExp('\\s');
		let specialExpr = new RegExp('\[~!@#$%^&*()_+|<>?:{}]');
		
		//빈 칸으로 되돌아갔을 시 원상복귀 
		if(userIdInput.value == "") {
			userIdInput.style.border = "3px solid #D5D5D5";
			IdCheckPassed.style.display = "none";
			IdCheckFailed.style.display = "none";
			return;
		}
		
		
		if(whiteSpaceExpr.test(userIdInput.value)){
			userIdInput.style.border = "3px solid #FF6161";
			IdCheckFailed.style.display = "block";
			IdCheckPassed.style.display = "none";
			IdCheckFailed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp아이디에 공백을 포함할 수 없습니다';
			return;
		}
		//특수문자 검증
		if(specialExpr.test(userIdInput.value)){
			userIdInput.style.border = "3px solid #FF6161";
			IdCheckFailed.style.display = "block";
			IdCheckPassed.style.display = "none";
			IdCheckFailed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp아이디에 특수문자를 사용하실 수 없습니다';
			return;
		}
		//아이디조건 검증
		if(!idExpr.test(userIdInput.value)) {
			userIdInput.style.border = "3px solid #FF6161";
			IdCheckFailed.style.display = "block";
			IdCheckPassed.style.display = "none";
			IdCheckFailed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp영문으로 시작하며 4-12글자의 영숫자 조합이어야 합니다';
			return;
		} 
		//일치 시 태두리 green 
		if(idExpr.test(userIdInput.value)) {
			userIdInput.style.border = "3px solid #6ED000";
			IdCheckPassed.style.display = "block";
			IdCheckFailed.style.display = "none";
			IdCheckPassed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp사용 가능한 아이디입니다';
			confirmId = true;
		}
		
	})
	
	//****2. Front 비밀번호 정규표현식 검증 ****
	document.querySelector("#password").addEventListener('input', e => {
		
		let dom = document.querySelector('#password');
		let passed = document.querySelector('#userPwPassed');
		let failed = document.querySelector('#userPwFailed');
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
			return;
		}
		
		if(whiteSpaceExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp비밀번호에 공백을 포함할 수 없습니다';
			return;
		}
		//비밀번호 조건 검증
		if(!pwExpr.test(dom.value)) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp8-12자 이내, 영문,숫자, 특수기호가 필요합니다';
			return;
		} 
		//일치 시 태두리 green 
		if(pwExpr.test(dom.value)) {
			dom.style.border = "3px solid #6ED000";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp사용 가능한 비밀번호 입니다';
			firstPw = dom.value;
		}
		
	})
	
	//****3. Front 비밀번호 중복 검증 ****
	document.querySelector("#passwordCheck").addEventListener('input', e => {
		
		let dom = document.querySelector('#passwordCheck');
		let passed = document.querySelector('#passwordAgainPassed');
		let failed = document.querySelector('#passwordAgainFailed');
		
		if(dom.value == "") {
			dom.style.border = "3px solid #D5D5D5";
			passed.style.display = "none";
			failed.style.display = "none";
			return;
		}
		
		if(firstPw == null) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp첫 번째 비밀번호를 먼저 입력하세요';
			return;
		}
		
		if(!(firstPw == dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp일치하지 않는 비밀번호입니다';
			return;
		}
		
		if(firstPw == dom.value){
			dom.style.border = "3px solid #6ED000";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp비밀번호 중복 검사가 완료되었습니다';
			confirmPasswordCheck = true;
		}
		
	})
	
	
	//****4. Front 이메일 정규표현식 검증 ****
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
			return;
		}
		if(whiteSpaceExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이메일에 공백을 포함할 수 없습니다';
			return;
		}
		//이메일 조건 검증
		if(!testExpr.test(dom.value)) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp올바르지 않은 이메일 주소입니다';
			return;
		} 
		//일치 시 태두리 green 
		if(testExpr.test(dom.value)) {
			dom.style.border = "3px solid #6ED000";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp올바른 이메일 주소입니다';
			confirmEmail = true;
		}
		
	})
	
	//****5. Front 이메일 발송 ****
	document.querySelector(".sendEmail").addEventListener('click', e=> {
		
		let dom = document.querySelector('#email');
		let passed = document.querySelector('#emailPassed');
		let failed = document.querySelector('#emailFailed');
		
		if(confirmEmail == true){
			alert(dom.value + "로 인증메일이 발송되었습니다.");
			fetch('/join/join-send-Vari-Email?userEmail=' + dom.value)
		} else {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp올바르지 않은 이메일 주소입니다';
		}
	})
	
	//****6. Front 이메일 인증 ****
	document.querySelector(".variEmail").addEventListener('click', e => {
		
		let dom = document.querySelector('#emailVali');
		let passed = document.querySelector('#emailValiPassed');
		let failed = document.querySelector('#emailValiFailed');
		
		alert(dom.value);
		fetch('/join/join-VariCode?variCode='+ dom.value)
		.then(response => response.text())
		.then(text => {
			if(text == 'valid'){
				document.querySelector("#emailCheck").innerHTML = "이메일 인증이 완료되었습니다.";
			} else if(text == 'invalid'){
				document.querySelector("#emailCheck").innerHTML = "올바른 인증 코드가 아닙니다.";
				document.querySelector("#email").style.border = "3px solid #FF6161";
				//border: 3px solid #D5D5D5;
				return;
			}
			if(text == 'timeout'){
				dom.style.border = "3px solid #FF6161";
				failed.style.display = "block";
				passed.style.display = "none";
				failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이메일 인증이 만료되었습니다. 다시 시도하세요';
				return;
			} 
			if(text == 'valid'){
				dom.style.border = "3px solid #6ED000";
				passed.style.display = "block";
				failed.style.display = "none";
				passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp이메일 인증이 완료되었습니다.';
				confirmCode = true; 
			}	
		})
			
	})


	//****7. Front 이름 정규표현식 검증 ****
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
			return;
		}
		if(whiteSpaceExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이름에 공백을 포함할 수 없습니다';
			return;
		}
		//특수문자 검증
		if(specialExpr.test(dom.value)){
			userIdInput.style.border = "3px solid #FF6161";
			IdCheckFailed.style.display = "block";
			IdCheckPassed.style.display = "none";
			IdCheckFailed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp이름에 특수문자를 사용하실 수 없습니다';
			return;
		}
		//이름 조건 검증
		if(!testExpr.test(dom.value)) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp올바르지 않은 이름입니다';
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
	
	//****8. Front 달력 정규표현식 검증 ****
	document.querySelector('#birth').addEventListener('input', e => {
		let dom = document.querySelector('#birth');
		let passed = document.querySelector('#birthPassed');
		passed.style.display = "block";
		dom.style.border = "3px solid #6ED000";
		passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp생년월일이 확인되었습니다';
		confirmBirth = true;
	})
	
	
	//****9. Front 별명 정규표현식 검증 ****
	document.querySelector("#nickName").addEventListener('input', e => {
		
		let dom = document.querySelector('#nickName');
		let passed = document.querySelector('#nickNamePassed');
		let failed = document.querySelector('#nickNameFailed');
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
			return;
		}
		if(whiteSpaceExpr.test(dom.value)){
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp별명에 공백을 포함할 수 없습니다';
			return;
		}
		if(specialExpr.test(dom.value)){
			userIdInput.style.border = "3px solid #FF6161";
			IdCheckFailed.style.display = "block";
			IdCheckPassed.style.display = "none";
			IdCheckFailed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp별명에 특수문자를 사용하실 수 없습니다';
			return;
		}
		//별명 조건 검증
		if(!testExpr.test(dom.value)) {
			dom.style.border = "3px solid #FF6161";
			failed.style.display = "block";
			passed.style.display = "none";
			failed.innerHTML = '<i class="fas fa-times-circle"></i>&nbsp사용 불가능한 별명입니다';
			return;
		} 
		//일치 시 태두리 green 
		if(testExpr.test(dom.value)) {
			/* 별명은 중복검사가 남아있으므로, 일단 green이 아닌 gray 처리 */
			dom.style.border = "3px solid #D5D5D5";
			passed.style.display = "block";
			failed.style.display = "none";
			passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp별명 중복검사를 진행하세요';
			confirmName = true;
		}
		
	})
	
	//****10. Front 별명 중복검사 ****
	document.querySelector('#checkNickName').addEventListener('click', e => {
		
		let dom = document.querySelector('#nickName');
		let passed = document.querySelector('#nickNamePassed');
		let failed = document.querySelector('#nickNameFailed');
		
		alert('버튼 작동');
		/* fetch를 통해 dom.value 전송, server 단에서 중복검사 실행, 결과값 param으로 다시전송 */
		
		
	})
	
	//****11. kh학원 지점 Select 검증 ****
	document.querySelector('#selectKH').addEventListener('input', e => {
		
		let dom = document.querySelector('#selectKH');
		let passed = document.querySelector('#centerPassed');
		
		dom.style.border = "3px solid #6ED000";
		passed.style.display = "block";
		passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp학원 지점이 정상적으로 선택되었습니다';
	}) 
	
	//****12. Front 파일 아이콘으로 이름 드러내기 기능****
	document.querySelector('#khFile').addEventListener('input', e => {
		
		let dom = document.querySelector('#khFile');
		let uploadName = document.querySelector('#upload-name');
		let passed = document.querySelector('#filePassed');
		
		uploadName.style.border = "3px solid #6ED000";
		passed.style.display = "block";
		passed.innerHTML = '<i class="fas fa-check-circle"></i>&nbsp이미지 파일이 정상적으로 첨부되었습니다';
		uploadName.value = dom.value; 
	})
	
	
	
	
</script>


</body>
</html>