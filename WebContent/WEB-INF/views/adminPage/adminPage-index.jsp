<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/adminPage/adminPageCSS.css"/>
<style type="text/css">


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
#wrap_hotplace, #wrap_myStatus{
	position: relative;
}
.hotplace, .myStatus{
	display: flex;
	position: absolute;
	justify-content: space-around;
	flex-direction: column;
	transform:translateY(-100%);
	width: 100%;
	height: 100%;
	background-color: #fecf92;
	border-radius: 20px 20px 20px 0;
	z-index: -1;
}
.hotplace>a{
	text-align: center;
	font-size: 1.3vw;
	color: #fecf92;
}
.myStatus>a{
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

#wrap_myStatus:hover {
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
#wrap_myStatus:hover .myStatus>a{
	transition-duration: 0.25s;
	text-align: center;
	color: white;
}

.footer{
	display: flex;
	justify-content: center;
	align-items: center;
	height: 15%;
	background-color: white;
	color: gray;
}
</style>
</head>






<body>
<!-- [BaseCode]header 영역 -->
 	<div class="header">
 		<div class = "wrap_header">
 			<div class='site_tit'><a href = "/main" style="color: #f29d2a">K H S</a></div>
 			<div class='logout'><button class="ap_button01"><a href="/adminPage/logout">로그아웃</a></button></div>
 		</div>
 	</div>
 	
<!-- [BaseCode]nav 영역 --> 	
 	<div class="nav">
 	</div>
 	
<!-- [BaseCode]section 영역 -->
 	<div class="section">
 		<div class='sidemenu'>
 			
 			<div><a href="/studyPage/index">학습 자료실</a></div>
 			
			<div><a a href="/food/food">맛집 정보</a>
 			</div>
 			
 			<div><a href="/board/free-board-main">게시판</a></div>
 			
		 	<div id="wrap_myStatus"><a href="/adminPage/index" target="_self">관리현황</a>
	 			<div class="myStatus">
	 				<a href="/adminPage/accountInfo" target="_self">회원 정보 조회</a>
	 				<a href="/adminPage/memberBlock" target="_self">차단된 회원 관리</a>
	 				<a href="/adminPage/freeChart" target="_self">자유게시판 관리</a>
	 			</div>
 			</div>	 
 			
 			
 			
 		</div>
 
 <!-- 경계선 -->
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
<!-- [배석진]관리자게시판 메인페이지 수정영역 -->
 		<div class= 'main_banner'>
 		
 		
<div class="ap_All">

	<img class="ad_Logo" src="/resources/image/adminPage/adminLogo.JPG">
	
	<div class="ap_Tit">Admin Main Page</div>
	
	<hr class="ap_hr">
	
	<div class="ap_indexTit">회원 정보 조회</div>
	<div class="ap_indexText">KHS 사이트에  가입되어 있는 회원들의 정보를 볼 수 있습니다.</div>
	<div class="ap_indexText">조회 가능한 정보는 이름/닉네임/ID/생년월일/E-mail/등급/학원지점/등록일/상태가 있습니다.</div>
	<button id="ap_indexBtn" class="ap_button01" type="button" onclick="location.href='/adminPage/accountInfo';">바로가기</button>
	
	<hr class="ap_indexHr">
	
	<div class="ap_indexTit">차단된 회원 관리</div>
	<div class="ap_indexText">KHS 회원들의 차단 유무를 확인할 수 있는 페이지입니다.</div>
	<div class="ap_indexText">관리자는 선택한 회원을 차단할 수 있으며 차단일은 1일/7일/영구 차단이 가능합니다.</div>
	<div class="ap_indexText">또한 차단된 회원을 해제하는 것도 이 페이지에서 할 수 있습니다.</div>
	<button id="ap_indexBtn" class="ap_button01" type="button" onclick="location.href='/adminPage/memberBlock';">바로가기</button>
	
	<hr class="ap_indexHr">
		
	<div class="ap_indexTit">자유게시판 관리</div>
	<div class="ap_indexText">KHS 회원들이 이용하는 자유게시판 페이지를 관리할 수 있습니다.</div>
	<div class="ap_indexText">게시글을 선택하면, 선택된 게시글을 회원들이 볼 수 없도록 관리가 가능합니다.</div>
	<button id="ap_indexBtn" class="ap_button01" type="button" onclick="location.href='/adminPage/freeChart';">바로가기</button>

</div>


 		</div>

<!-- 
*** 관리자페이지 화면별 기능 ***

✔ 메인 화면
	- 관리자 번호가 부여된 회원이 '나의현황'을 클릭하면 관리자페이지 메인화면이 뜬다
	- 메인화면은 '회원정보조회/차단된 회원 관리/자유게시판 관리' 3가지 기능을 수행할 수 있는 상세페이지로 이동할 수 있다
	- 또한 hover 효과로 옆에서도 상세페이지를 클릭할 수 있다
	- 단, 일반 회원은 관리자페이지가 아닌 myPage가 떠야 하며, 호버 효과 또한 않아야 한다

✔회원정보조회
	  접속시 바로 조회 가능 : 이름/닉네임/ID/생년월일/E-mail/등급/학원지점/등록일/상태  
              
✔차단된회원관리
	  조회 목록 : 선택/아이디/상태
	   기능 : 1일정지/7일정지/영구정지/정지해제

✔자유게시판 관리
	  조회 목록 : 선택/게시글번호/글제목/상태
	   기능 : 게시글 삭제(안보이게 표시)

	*공통사항*
		+ 데이터 갯수가 10개 이상시 페이지 이동 기능
		+ 게시판 번호 역순으로 설정
-->
 	</div>
 	
<!-- [BaseCode]footer 영역 -->
	<div class="footer">Copyright © 1998-2021 KH Information Educational Institute All Right Reserved</div>
	
<!-- [BaseCode]스크립트 코드  -->
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
	
	
	(function hotplaceSlide() {
		document.querySelector("#wrap_myStatus").addEventListener('mouseover',()=>{
			document.querySelector(".myStatus").style.transitionDuration = '0.1s';
			document.querySelector(".myStatus").style.transform=`translate(99.7% , -100.2%)`;
			document.querySelector(".myStatus").style.backgroundColor = "#FFAF7A";
		})
		document.querySelector("#wrap_myStatus").addEventListener('mouseleave',()=>{	
			document.querySelector(".myStatus").style.transitionDuration = "0.1s";
			document.querySelector(".myStatus").style.transform=`translateY(-100%)`;
			document.querySelector(".myStatus").style.backgroundColor = "#fecf92";	
		})
	})();
	
	
	</script>
</body>
</html>









