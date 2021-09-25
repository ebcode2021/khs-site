<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<style type="text/css">


@font-face {
      src : url("/resources/css/NotoSansCJKkr-hinted/NotoSansCJKkr-Regular.otf"); 
      font-family: "han_sans_kr_medium";
}

@font-face {
      src : url("/resources/css/NotoSansCJKkr-hinted/NotoSansCJKkr-Light.otf"); 
      font-family: "han_sans_kr_Light";
}

@font-face {
    font-family: 'SDSamliphopangche_Outline';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/SDSamliphopangche_Outline.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

html, body{
	width: 100%;
	height: 100%;.
}
.header{
	display: flex;
	justify-content: space-around;
	height: 10%;
}

.wrap_header{
	display: flex;
	justify-content: space-between;
	width: 100%;
	height: 100%;
	margin-left: 13%;
	margin-right: 13%;
}

.site_tit{
	display: flex;
	align-items: flex-end;
	margin-left: 2%;
	margin-bottom: 0.5%;
	font-weight: bolder;
	font-size: 3.2vw;
	color: #f29d2a;
}

.logout{
	display: flex;
	align-items: flex-end;
	margin-right: 2%;
	margin-bottom: 0.5%;
	right: 25%;
}




/*네비게이션바? 더미로 놔뒀습니다 나중에 뭐 추가할 때 쓰면 될듯*/
.nav{

}



.section{
	position: relative;
	display: flex;
	min-height:75%;
	margin-left: 13%;
	margin-right:13%;
	border-radius: 20px 20px 20px 20px;
}
.main_banner{
	position: relative;
	margin-left: 16.5%;
	width: 100%;
	background-color: #F0F8FF;
	border-radius: 20px 20px 20px 20px;
	min-width: 600px;
}
.sidemenu{
	position: absolute;
	min-height:100%;
	width: 15.5%;
	min-width: 15.5%;
	background-color: #fecf92;
	border-radius: 20px 20px 20px 20px;
	z-index: 999;
	font-family: 'han_sans_kr_Medium';
}
#mypage{
	border-radius: 20px 20px 0 0;
}
.sidemenu>div{
	font-weight: bolder;
	font-size: 1.7vw;
	transition:all 0.3s;
}
.sidemenu>div>a {
	display: flex;
	justify-content : center;
	align-items : center;
	height: 100px;
	color: white;
}





#wrap_hotplace{
	position: relative;
}
.hotplace{
	display: flex;
	position: absolute;
	justify-content: space-around;
	flex-direction: column;
	transform:translateY(-100%);
	width: 100%;
	height: 100%;
	background-color: #fecf92;
	border-radius: 0 20px 20px 0;
	z-index: -1;
}
.hotplace>a{
	text-align: center;
	font-size: 1.3vw;
	color: #fecf92;
}






#mypage:hover{
	transition-duration: 0.25s;
	border-radius: 20px 20px 20px 20px;
	background-color: #FFAF7A;
}
#wrap_hotplace:hover {
	transition-duration: 0.1s;
	border-radius: 20px 0 0 20px;
	background-color: #FFAF7A;
}
.sidemenu>div:hover {
	transition-duration: 0.25s;
	border-radius: 20px 20px 20px 20px;
	background-color: #FFAF7A;
}

#wrap_hotplace:hover .hotplace>a{
	transition-duration: 0.25s;
	text-align: center;
	color: white;
}







.main_banner>  div{
	margin-bottom: 15px;
}


.userInfo {
	height: 200px;
	min-height: 200px;
	position: relative;
	display: flex;
}

.profile_image {
	border-style: solid;
	position: absolute;
	height: 155px;
	width: 155px;
	left: 3%;
	top: 20px;
}


.profile_table {
	margin-left: 220px;
	position: relative;
	top: 20px;
	height: 155px;
	width: 400px;
	display: flex;
	align-items: flex-start;
	justify-content: space-around;
	flex-direction: column;
}

.profile_table> div{
	font-size : 20px;
	font-family: "han_sans_kr_medium";
	color: gray;
}



.mypage_wrapper{
	
	position: relative;
	width: 97%;
	left: 1%;
	background-color: #FFF5EE;
	border-radius: 20px;
}


#mypage_detail>div {
	height: 98%;
	width: 90%;
	padding: 7px 0 7px 0;
	width: 70%;
	margin-left: 6%;
	display: block;
}


#detail_submit {
	position: relative;
	width: 70px;
	right: 20px;
	margin-top: 5px;
	float: right;
	
}


.password_wrapper {
	position: relative;
	width: 97%;
	left: 1%;
	top: 25px;
	background-color: #FFF5EE;
	border-radius: 20px;
}

#change_password>div {
	height: 98%;
	width: 90%;
	padding: 7px 0 7px 0;
	margin-left: 6%;
	display: block;
}

#password_submit {
	position: relative;
	width: 70px;
	right: 20px;
	margin-top: 5px;
	float: right;
}

.valid-msg {
	font-size : 15px;
	color: #B22222;
}


.footer{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 15%;
	background-color: white;
	color: gray;
}



tr,td{
	padding: 15px;
}

td, td> div{
	font-size : 17px;
	font-family: "han_sans_kr_medium";
	color: gray;
}	

.inputParam {
	font-size : 15px;
	font-family: "han_sans_kr_medium";
	color: gray;
}






</style>


</head>
<body>

 	<div class="header">
 		<div class = "wrap_header">
 			<div class='site_tit'>K H S</div>
 			<div class='logout'><button><a href = "/myPage/logout">로그아웃</a></button></div>
 		</div>
 		
 	</div>
 	
 	
 	<div class="nav">
 	</div>
 	
 	
 	<div class="section">
 		<div class='sidemenu'>
 		 	<div id="mypage"><a>나의 현황</a></div>
 			<div><a>학습 자료실</a></div>
 			<div id="wrap_hotplace"><a>맛집 정보</a>
	 			<div class="hotplace">
	 				<a>강남지원</a>
	 				<a>종로지원</a>
	 				<a>당산지원</a>
	 			</div>
 			</div>
 			<div><a>게시판</a></div>
 			<div><a>문의하기</a></div>
 		</div>
 		<div class= 'main_banner'>
 			<div class='userInfo'>
				
				<div class="profile_image">
					image
				</div>
				
				<div class="profile_table" border="solid">
					<div>${authentication.name}</div>
					<div>${authentication.khCenter}</div>
					<div>${authentication.instrName} 강사</div>
				</div>
				
				
 			</div>
 			<div class='mypage_wrapper'>
 				<form id='mypage_detail' action="/myPage/updateDetail">
 				
			 		<table>
						<tr>
							<td>닉네임 : </td>
							<td>
							<div>
			 					<input type="text" name="newNickname" id="newNicknameInput"class="inputParam" placeholder="${authentication.nickName}" 
			 					<c:if test="${not empty changeMypageFailed.Duplicated}">
			           	  			value = "${changeMypageFailed.Duplicated}"
			           	 		</c:if>
			 					required/>
			 					<span id = "nickNameCheck" class = "valid-msg">
			           	 		 	<c:if test="${not empty changeMypageFailed.DuplicatedMsg}">
			           	  				${changeMypageFailed.DuplicatedMsg}
			           				</c:if>
			           	 		</span>
		 					</div>
		 				</td>
					</tr>
					
					
					<tr>
						<td>
						이메일 : 
						</td>
						
						<td>
							<div>
		 					<input type = "text" class="inputParam" multiple name = "newEmail" placeholder="${authentication.email}"
		 					<c:if test="${not empty changeMypageFailed.invalidEmail}">
		           	  			value = "${changeMypageFailed.invalidEmail}"
		           	 		</c:if>
		 					required/>
		 					<span id = "emailCheck" class = "valid-msg">
		           	 		 	<c:if test="${not empty changeMypageFailed.invalidEmailMsg}">
		           	  				${changeMypageFailed.invalidEmailMsg}
		           				</c:if>
		           	 		</span>
		 					</div>
						</td>
					</tr>
					
					
					
					<tr>
						<td>회원등급 : </td>
						<td>
							<div>
	 							${authentication.grade}
	 						</div>
	 					</td>
					</tr>
					
					
					<tr>
						<td>학원지점 : </td>
						<td>
							<div>
	 							${authentication.khCenter}
	 						</div>
						</td>
					</tr>
					
					
					<tr>
						<td>가입한 날짜 : </td>
						<td>
							<div>
	 							${authentication.regDate}
	 						</div>
						</td>
					</tr>
					
					
					<tr>
						<td>생년월일 : </td>
						<td>
							<div>
	 							${authentication.birthDate}
	 						</div>
						</td>
					</tr>
					
					
					<tr>
						<td>수업이름 : </td>
						<td>
							<div>
	 							${authentication.className}
	 						</div>
						</td>
					</tr>
					
					<tr>
						<td>강사이름 : </td>
						<td>
							<div>
	 							${authentication.instrName}
	 						</div>
						</td>
					</tr>
					
					<tr>
						<td>개강날짜 : </td>
						<td>
							<div>
	 							${authentication.startDate}
	 						</div>
						</td>
					</tr>
					
					<tr>
						<td>종강날짜 : </td>
						<td>
							<div>
	 							${authentication.finalDate}
	 						</div>
	 					</td>
					</tr>
					
				</table>
				
	 				<button id='detail_submit'>저장하기</button>
 				</form>
 			</div>
 			
 			
 			<div class='password_wrapper'>
 				<form id='change_password' action="/myPage/changePassword">
 				<table>
 				<tr>
 				
 					<td>
 						<div>
	 					비밀번호 변경 
	 					</div>
 					</td>
 					
 					<td>
 					
 					</td>
 					
 				</tr>
 				
 				<tr>
 				
 					<td>
 					현재 비밀번호 : 
 					</td>
 					
 					<td>
	 					<div>
		 					<input type = "password" class="inputParam" name = "password"
		 					<c:if test="${not empty changePasswordFailed.password}">
		           	  			value = "${changePasswordForm.password}"
		           	 		 </c:if>
		           	 	required/>
		           	 		<span id = "pwcheck" class = "valid-msg">
		           	 		 	<c:if test="${not empty changePasswordFailed.errorMsg1}">
		           	  				${changePasswordFailed.errorMsg1}
		           				</c:if>
		           	 		 </span>
		 				</div>
 					</td>
 					
 				</tr>
 				
 				<tr>
 				
 					<td>
 						변경할 비밀번호 : 
 					</td>
 					
 					<td>
	 					<div>
		 					<input type = "password" class="inputParam" name = "newPassword"  
		 					<c:if test="${not empty changePasswordFailed.password}">
		           	  			value = "${changePasswordForm.newPassword}"
		           	 		 </c:if>
		           	 		 required/>
		 				</div>
 					</td>
 					
 				</tr>
 				
 				<tr>
 				
 					<td>
 						변경할 비밀번호  재입력 : 
 					</td>
 					
 					<td>
	 					<div>
		 					<input type = "password" class="inputParam" name = "newPassword2" 
		 					<c:if test="${not empty changePasswordFailed.newPassword2}">
		           	  			value = "${changePasswordForm.newPassword2}"
		           	 		 </c:if>
		           	 		  required/>
		 				</div>
		 				 	<span id = "pwcheck" class = "valid-msg">
		           	 		 	<c:if test="${not empty changePasswordFailed.errorMsg2}">
		           	  				${changePasswordFailed.errorMsg2}
		           				</c:if>
		           	 		 </span>
		           	 		 <br>
		           			<span id = "pwcheck" class = "valid-msg">
		           	 		 	<c:if test="${not empty changePasswordFailed.errorMsg3}">
		           	  				${changePasswordFailed.errorMsg3}
		           				</c:if>
		           	 		 </span>
		           	 		 <br>
		           			<span id = "pwcheck" class = "valid-msg">
		           	 		 	<c:if test="${not empty changePasswordFailed.errorMsg4}">
		           	  				${changePasswordFailed.errorMsg4}
		           				</c:if>
		           	 		</span>
 					</td>
 					
 				</tr>
 				
 				</table>
	 				
	 				
 					<button id='password_submit'>변경하기</button>
 				</form>
 			</div>

 			
 			
 			
 			
 			
 			

 		</div>
 	</div>
 	
 	
	<div class="footer">Copyright © 1998-2021 KH Information Educational Institute All Right Reserved</div>
	
	
	
	
	
	
	
	<script type="text/javascript">
	
	(function hotplaceSlide() {
		document.querySelector("#wrap_hotplace").addEventListener('mouseover',()=>{
			document.querySelector(".hotplace").style.transitionDuration = '0.1s';
			document.querySelector(".hotplace").style.transform=`translate(99.7% , -100.2%)`;
			document.querySelector(".hotplace").style.backgroundColor = "#FFAF7A";
		})
		document.querySelector("#wrap_hotplace").addEventListener('mouseleave',()=>{	
			document.querySelector(".hotplace").style.transitionDuration = "0.1s";
			document.querySelector(".hotplace").style.transform=`translateY(-100%)`;
			document.querySelector(".hotplace").style.backgroundColor = "#fecf92";	
		})
	})();
	
/* 	
	let confirmNickname = '';	
	document.querySelector("#detail_submit").addEventListener('click', e=>{
		let newNickname = document.querySelector("#newNicknameInput").value;
		if(newNickname){
			fetch('/myPage/check-nickname?newNickname=' + newNickname)
			.then(response => response.text())
			.then(text => {
				if(text == 'available'){
					document.querySelector('#nickNameCheck').innerHTML = '사용 가능한 닉네임 입니다.';
					confirmNickname = newNickname;
				}else{
					document.querySelector('#idCheck').innerHTML = '사용 불가능한 닉네임 입니다.';
				}
			})
		}
	})
	
	document.querySelector('#detail_submit').addEventListener('submit', e=>{
		if(confirmNickname != document.querySelector("#newNicknameInput").value){
			e.preventDefault();
			document.querySelector('#nickNameCheck').innerHTML = "중복검사를 진행하지 않았습니다."
		}
	})
	
	 */
		
	</script>

	
	
</body>
</html>



