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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
<!-- [배석진]관리자게시판 회원정보조회 수정영역 -->
 		<div class= 'main_banner'>
 		
 		
<div class="ap_All">

	<img class="ad_Logo" src="/resources/image/adminPage/adminLogo.JPG">
	
	<div class="ap_Tit">회원 정보 조회</div>

	<br><br>
	
	<div class="ap_indexText">KHS 사이트에  가입되어 있는 회원들의 정보를 볼 수 있습니다.</div>
	<div class="ap_indexText">조회 가능한 정보는 이름/닉네임/ID/생년월일/E-mail/등급/학원지점/등록일/상태가 있습니다.</div><br>
	<div class="ap_indexText" style="font-weight: bold">** 또한 버튼을 클릭할 시 LV01와 LV02를 자유롭게 변경할 수 있습니다. **</div>
	
	<hr class="ap_hr">
		
	<table class="ap_session_base">
		<tr>
			<th style="width: 10%">이름</th> <!-- MEMBER.NAME -->
			<th style="width: 10%">닉네임</th> <!-- MEMBER.NICKNAME -->
			<th style="width: 10%">ID</th> <!-- MEMBER.USER_ID -->
			<th style="width: 10%">생년월일</th> <!-- MEMBER.BIRTH_DATE -->
			<th style="width: 10%">E-mail</th> <!-- MEMBER.EMAIL -->
			<th style="width: 10%">등급</th> <!-- MEMBER.GRADE -->
			<th colspan='2' style="width: 10%">등급버튼</th> 
			<th style="width: 10%">등록일</th> <!-- MEMBER.REG_DATE -->
		</tr>
		<c:forEach items="${adminPageList}" var="list" varStatus="i"> 
		<tr>
			<td>${list.name}</td> 
			<td>${list.nickname}</td>
			<td>${list.userId}</td>
			<td>${list.birthDate}</td>
			<td>${list.email}</td>
			<td>${list.grade}</td>
			<form action="/adminPage/userGradeLV01?userGradeLV01=${list.userId}" method="post" >
				<td><button class="ap_button03" style="padding: 2px; background-color: #e9be2a8a; color: black;">LV01</button></td>
			</form>
			<form action="/adminPage/userGradeLV02?userGradeLV02=${list.userId}" method="post" >
				<td><button class="ap_button03" style="padding: 2px; background-color: #0097c74a; color: black;">LV02</button></td>
			</form>
			<td>${list.regDate}</td>
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