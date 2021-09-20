<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../resources/css/all.css" rel="stylesheet">
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
	<form action="${context}/join/join-Method" enctype="multipart/form-data" method="post" >
		<div class = 'test'>
			<h2>01. 아이디와 비밀번호를 입력 해 주세요.</h2>
			<input type="text" name="userId" id='userId' placeholder="아이디 (6-12자 이내, 영문, 숫자 모두 사용 가능합니다.)"><br>
			<input type="text" name="password" id='password' placeholder="비밀번호 (8-12자 이내, 영문,숫자, 특수기호가 필요합니다.)"><br>
			<input type="text" name="passwordCheck" id='passwordCheck' placeholder="비밀번호 확인(8-12자 이내, 영문,숫자, 특수기호가 필요합니다.)"><br>
		</div>
		<div class = 'test'>
			<h2>02. 이메일을 입력하고 인증번호를 확인하세요.</h2>
			<input type="text" name='email' id='email' placeholder="이메일(인증 번호를 받을 수 있는 이메일을 입력하세요.)"><br>
			<button class = 'sendEmail' type="button">인증번호 전송</button>
			<div class = emailValiWrapper>
				<input type="text" name='emailVali' id='emailVali' class = "emailVali" placeholder="인증번호를 입력하세요."><span>00 : 00</span>
			</div>
			<button class = 'variEmail' type="button">인증하기</button>
		</div>
		<div class = 'test'>
			<h2>03. 이름과 생년월일, 별명을 입력 해 주세요.</h2>
			<h3>*별명은 커뮤니티 활동에서 ID와 이름 대신 사용합니다.</h3>
			<input type="text" name='name' id='name' placeholder="이름"><br>
			<input type="text" name='birth' id='birth' placeholder="생년월일(-을 제외한 8자리 숫자로 입력하세요.)"><br>
			<div class = "NickNameWrapper"> 
				<input type="text" name='nickName' id='nickName' class = "nickName" placeholder="별명(4-12자리 이내, 특수기호는 포함할 수 없습니다.)">
				<button class = 'checkNickName'>중복 검사</button>
			</div>
		</div>
			<div class='test'>
				<h2>
					04. 인증을 위해 KH 정보교육원 홈페이지에 들어가<br> 마이페이지 이미지를 캡쳐한 후 업로드 해 주세요.
				</h2>
				<div class = "selectKHWrapper">
				<select name='selectKH' id='selectKH' class="selectKH">
					<option disabled="disabled">지점 선택</option>
					<option value="gangnam">강남 지점</option>
					<option value="itewon">이태원 지점</option>
				</select><br>
					<div class="filebox">
	 				    <label for="file"><i class="fas fa-search-plus"></i></label>
					    <input class="upload-name" value="첨부파일" placeholder="첨부파일"> 
					    <input type="file" name="file" id="file"/>
					</div>
				</div>
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
		<button class = "commitButton">뒤로</button><button class = "commitButton" type="submit">회원가입</button>
</div> 
	<button>전송</button>
	</form>
</div>
<footer></footer>

<script type="text/javascript">
	
	let confirmEmail = "";

	document.querySelector(".sendEmail").addEventListener('click', e=> {
		let email = document.querySelector("#email").value;
		alert(email);
		fetch('/join/join-send-Vari-Email?userEmail=' + email)
		/* .then(response => response.text())
		.then(text => {
			if(text == 'available'){
				document.querySelector("#emailCheck").innerHTML = "이메일 인증이 완료되었습니다.";
				confirmEmail = email;
			} else if(text == 'disable'){
				document.querySelector("#emailCheck").innerHTML = "올바른 인증 코드가 아닙니다.";
			} else if(text == 'timeout'){
				document.querySelector("#emailCheck").innerHTML = "인증 시간이 만료되었습니다.";
			} else{
				document.querySelector('#emailCheck').innerHTML = "시스템 장애로 회원가입에 실패했습니다.";
			}
		}) */
	})
	
	document.querySelector(".variEmail").addEventListener('click', e=> {
		
		let variCode = document.querySelector("#emailVali").value;
		alert(variCode);
		fetch('/join/join-VariCode?variCode='+ variCode)
		/* .then(response => response.text())
		.then(text => {
			if(text == 'available'){
				document.querySelector("#emailCheck").innerHTML = "이메일 인증이 완료되었습니다.";
				confirmEmail = email;
			} else if(text == 'disable'){
				document.querySelector("#emailCheck").innerHTML = "올바른 인증 코드가 아닙니다.";
			} else if(text == 'timeout'){
				document.querySelector("#emailCheck").innerHTML = "인증 시간이 만료되었습니다.";
			} else{
				document.querySelector('#emailCheck').innerHTML = "시스템 장애로 회원가입에 실패했습니다.";
			}
		}) */
	})






</script>


</body>
</html>