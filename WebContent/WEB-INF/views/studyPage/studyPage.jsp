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
 			<div class='site_tit'>K H S</div>
 			<div class='logout'><button><a>로그아웃</a></button></div>
 		</div>
 	</div>
 	
<!-- [BaseCode]nav 영역 --> 	
 	<div class="nav">
 	</div>
 	
<!-- [BaseCode]section 영역 -->
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
<!-- [배석진]학습게시판 수정영역 -->
 		<div class= 'main_banner'>


<div class="sp_all">

	<div class="sp_section">
		<div class="sp_introduce01">Backend development site</div>
		<div class="sp_introduce02">수많은 선대 개발자들이 애용하는 사이트를 모아봤습니다.
		<br>개발자의 꿈을 꾸시는 당신에게 이 사이트들은 앞으로 자주 보게 될 사이트들이니 꼭 알아두세요!</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/005.png">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/005.png">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
			</div>
		</div>
	
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/005.png">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/005.png">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/005.png">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/005.png">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus01" >사이트</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		<hr>
	</div>
	
	<div class="sp_section">
		<div class="sp_introduce01">Algorithm and development technology</div>
		<div class="sp_introduce02">우리가 평소 코딩하면서 사용하는 기술 중, 중요한 기술을 모았습니다.
		<br>또한 고급 알고리즘 기술도 소개되었으니 우리의 코딩실력도 슝슝!</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/019.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/019.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
	
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/019.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/019.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus04" >기술</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		<hr>
	</div>
	
	<div class="sp_section">
		<div class="sp_introduce01">Development knowledge</div>
		<div class="sp_introduce02">웹을 개발하기 위해선 코딩 뿐만 아니라 웹에 대한 전반적인 지식이
		<br>요구되고 있습니다. 네트워크부터 시작해서 클라우드 등 우리의 웹 지식을 넓혀가 보아요!</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/029.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/029.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/029.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/029.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/029.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus02" >중요</div>
				<div class="sp_dataPlus03" >추천</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/029.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
			<div class="sp_dataPlus">
				<div class="sp_dataPlus05" >지식</div>
				<div class="sp_dataPlus02" >중요</div>
			</div>
		</div>
		
		<div class="sp_dataBox">
			<a href="https://www.naver.com/" target="_blank">
				<img class="sp_dummyImage" src="resources/studyPageImage/029.JPG">
			</a>
			<div class="sp_dataTitle" >DataName</div>
			<div class="sp_dataInstruction" >DataDescription01 DataDescription02 ...</div>
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