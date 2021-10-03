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
	font-family: 'SDSamliphopangche_Outline';
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
 			
 			<div id="wrap_hotplace"><a a href="/food/food">맛집 정보</a>
	 			<div class="hotplace">
	 				<a>강남지원</a>
	 				<a>종로지원</a>
	 				<a>당산지원</a>
	 			</div>
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
<!-- [배석진]관리자게시판 회원정보조회 수정영역 -->
 		<div class= 'main_banner'>
 		
 		
<div class="ap_All">

	<img class="ad_Logo" src="/resources/image/adminPage/adminLogo.JPG">
	
	<div class="ap_Tit">차단된 회원 관리</div>

	<br><br>
	
	<div class="ap_indexText">KHS 회원들의 차단 유무를 확인할 수 있는 페이지입니다.</div>
	<div class="ap_indexText">관리자는 선택한 회원을 차단할 수 있으며 차단일은 1일/7일/영구 차단이 가능합니다.</div>
	<div class="ap_indexText">또한 차단된 회원을 해제하는 것도 이 페이지에서 할 수 있습니다.</div>
	<br>
	<div class="ap_indexText" style="font-weight: bold">** B01은 차단해제, B02는 1일차단, B03는 7일차단, B04는 영구차단 상태입니다.**</div>
	
	<hr class="ap_hr">
	
	<table class="ap_session_base" id="ap_banTable">
		<tr>
			<th>아이디</th>
			<th>상태</th>
			<th colspan='4'>차단 관리 버튼</th> 
		</tr>
		<c:forEach items="${adminPageList}" var="list" varStatus="i"> 
			<tr>
				<td>${list.userId}</td>
				<td>${list.banGrade}</td>
				
				<form action="/adminPage/memberBanGrade01?userId01=${list.userId}" method="post" >
				<td><button class="ap_button04">1일정지</button></td>
				</form>
				
				<form action="/adminPage/memberBanGrade02?userId02=${list.userId}" method="post" >
				<td><button class="ap_button03">7일정지</button></td>
				</form>
				
				<form action="/adminPage/memberBanGrade03?userId03=${list.userId}" method="post" >
				<td><button class="ap_button02">영구정지</button></td>
				</form>
				
				<form action="/adminPage/memberBanGrade04?userId04=${list.userId}" method="post" >
				<td><button class="ap_button01">정지해제</button></td>
				</form>
			</tr>
		</c:forEach>
	</table>
	
	
</div>
</div>

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









