<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=63cb0ea3f8a404fbd7be7a34d1fcff14"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=63cb0ea3f8a404fbd7be7a34d1fcff14&libraries=LIBRARY"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=63cb0ea3f8a404fbd7be7a34d1fcff14&libraries=services,clusterer,drawing"></script>

<link href="/resources/slick/slick-theme.css"  rel="stylesheet" type="text/css">
<link href="/resources/slick/slick.css"  rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript" src="/resources/slick/slick.min.js"></script>
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
.section{
	position: relative;
	display: flex;
	height:110%;
	margin-left: 13%;
	margin-right:13%;
	border-radius: 20px 20px 20px 20px;
}
.main_banner{
	position: relative;
	margin-left: 16.5%;
	width: 100%;
	height:100%;
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

/* 임시 div 영역설정 태그 */
#mainDiv div{
	border : 1px solid gray;
	margin-bottom: 10px;
}

/* 최상단 navigation bar 높이설정 */
#top_navi{
	display:flex;
	justify-content:space-between;
	height: 60px;
}
	#top_navi button {
		background-color:#fecf92;
		height:100%;
		width :33%;
	}
/* 중간부분 visual담당 div 높이설정 및 분리 */	
#visualDiv{
	display:flex;
	justify-content:space-around;
	margin-top : 5%;
	margin-left : 2.5%;
	width : 95%;
	height:300px;
}
	#visualDiv div{
		border: 1px solid red;
		width: 50%;
		height:100%;
}	
/* 하단부분 slide담당 div 너비설정 */
	#slideDiv{
		display:flex;
		margin-top:5%;
		margin-left : 5%;
		justify-content:center;
		height:500px;
		width: 700px;
	}
		#slideDiv div{
			height: 100%;
			width: 100%;
		}
			#bigSlide span{
				display:block;
				background-color: blue;
			}
/* slick css  */			
	.slick-prev:before,
    .slick-next:before {
        color: orange;
    }
</style>
</head>
<body>
 	<div class="header">
 		<div class = "wrap_header">
 			<div class='site_tit'>K H S</div>
 			<div class='logout'><button><a>로그아웃</a></button></div>
 		</div>
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
 		<div class= 'mainDiv' id = 'mainDiv'>
	 		<div class= "top_navi" id= "top_navi">
	 			<button></button>
	 			<button></button>
	 			<button></button>
	 		</div>
	 		<div class="visualDiv" id="visualDiv">
				<div id = 'map'></div>
				<div></div>
	 		</div>
	 		<div class="slideDiv" id="slideDiv">
	 			<div class="bigSlide" id ="bigSlide">
	 				<span>a</span>
	 				<span>n</span>
	 				<span>c</span>		
	 			</div>
	 			<div></div>
	 			<div></div>
	 		</div>
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

	var container = document.getElementById('map');
	var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
	var map = new kakao.maps.Map(container, options);
	
	$('#slideDiv').slick({
		  infinite: true,
		  speed: 300,
		  slidesToShow: 1
	});
	</script>
	
</body>

</html>