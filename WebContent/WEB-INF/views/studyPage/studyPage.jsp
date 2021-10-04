<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link rel="stylesheet" href="/resources/css/studyPage/studyPageCSS.css"/>
<style type="text/css">


@font-face {
    font-family: 'SDSamliphopangche_Outline';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts-20-12@1.0/SDSamliphopangche_Outline.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}

@font-face {
      src : url("/resources/css/NotoSansCJKkr-hinted/NotoSansCJKkr-Regular.otf"); 
      font-family: "han_sans_kr_medium";
}

@font-face {
      src : url("/resources/css/NotoSansCJKkr-hinted/NotoSansCJKkr-Light.otf"); 
      font-family: "han_sans_kr_Light";
}


html, body{
	width: 100%;
	height: 100%;
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
 			<div class='logout'><button><a>로그아웃</a></button></div>
 		</div>
 	</div>
 	
<!-- [BaseCode]nav 영역 --> 	
 	<div class="nav">
 	</div>
 	
<!-- [BaseCode]section 영역 -->
 	<div class="section">
 		<div class='sidemenu'>
 		 	<div id="mypage"><a href="/myPage/myPageMain">나의 현황</a></div>
 			<div><a href="/studyPage/index">학습 자료실</a></div>
			<div id="mypage"><a a href="/food/food">맛집 정보</a>
 			</div>
 			<div><a href="/board/free-board-main">게시판</a></div>
 		</div>
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
<!-- [배석진]학습게시판 수정영역 -->
 		<div class= 'main_banner'>


<div class="sp_all">

	<div class="sp_section">
		<div class="sp_introduce01">Backend development site</div>
		<div class="sp_introduce02">수많은 선대 개발자들이 애용하는 사이트를 모아봤습니다.
		<br>개발자의 꿈을 꾸시는 당신에게 이 사이트들은 앞으로 자주 보게 될 사이트들이니 꼭 알아두세요!</div>
		
		<!-- 001번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy0.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/001.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy0.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy0.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 002번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy1.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/002.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy1.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy1.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 003번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy2.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/003.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy2.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy2.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 004번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy3.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/004.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy3.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy3.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 005번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy4.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/005.png">
			</a>
			<div class="sp_dataTitle" >${boardStudy4.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy4.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 006번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy5.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/006.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy5.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy5.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 007번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy6.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/007.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy6.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy6.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 008번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy7.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/008.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy7.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy7.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 009번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy8.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/009.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy8.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy8.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>

		<!-- 010번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy9.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/010.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy9.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy9.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 011번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy10.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/011.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy10.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy10.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 012번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy11.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/012.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy11.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy11.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 013번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy12.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/013.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy12.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy12.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 014번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy13.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/014.png">
			</a>
			<div class="sp_dataTitle" >${boardStudy13.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy13.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<hr>
	</div>
	
	<div class="sp_section">
		<div class="sp_introduce01">Algorithm and development technology</div>
		<div class="sp_introduce02">우리가 평소 코딩하면서 사용하는 기술 중, 중요한 기술을 모았습니다.
		<br>또한 고급 알고리즘 기술도 소개되었으니 우리의 코딩실력도 슝슝!</div>
		
		<!-- 015번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy14.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/015.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy14.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy14.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 016번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy15.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/016.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy15.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy15.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 017번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy16.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/017.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy16.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy16.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 018번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy17.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/018.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy17.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy17.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 019번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy18.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/019.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy18.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy18.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 020번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy19.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/020.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy19.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy19.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
			</div>
		</div>
		
		<!-- 021번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy20.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/021.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy20.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy20.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 022번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy21.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/022.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy21.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy21.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 023번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy22.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/023.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy22.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy22.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 024번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy23.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/024.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy23.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy23.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<!-- 025번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy24.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/025.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy24.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy24.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
			</div>
		</div>
		
		<!-- 026번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy25.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/026.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy25.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy25.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<!-- 027번 자료 -->
		<div class="sp_dataBox">
			<a href="${boardStudy26.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/027.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy26.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy26.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		</div>
		<hr>
	</div>
	
	<div class="sp_section">
		<div class="sp_introduce01">Development knowledge</div>
		<div class="sp_introduce02">웹을 개발하기 위해선 코딩 뿐만 아니라 웹에 대한 전반적인 지식이
		<br>요구되고 있습니다. 네트워크부터 시작해서 클라우드 등 우리의 웹 지식을 넓혀가 보아요!</div>
		
		<div class="sp_dataBox">
			<a href="${boardStudy27.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/028.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy27.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy27.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="${boardStudy28.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/029.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy28.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy28.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="${boardStudy29.stStieLink}" target="_blank">
				<img class="sp_dummyImage" src="/resources/image/studyPage/030.JPG">
			</a>
			<div class="sp_dataTitle" >${boardStudy29.stTitle}</div>
			<div class="sp_dataInstruction" >${boardStudy29.stDescription}</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<hr>
	</div>
	
	
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
	</script>
</body>
</html>