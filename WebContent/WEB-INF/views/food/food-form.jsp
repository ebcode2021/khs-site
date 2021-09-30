<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 공통헤더, EL-JSTL과  all.css, reset.css 있음 -->
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!DOCTYPE html>
<html>
<head>
<!--kakaoMap  -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=63cb0ea3f8a404fbd7be7a34d1fcff14"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=63cb0ea3f8a404fbd7be7a34d1fcff14&libraries=LIBRARY"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=63cb0ea3f8a404fbd7be7a34d1fcff14&libraries=services,clusterer,drawing"></script>
<!-- CSS -->
<link href="/resources/css/food/food-form.css"  rel="stylesheet" type="text/css">
<link href="/resources/slick/slick-theme.css"  rel="stylesheet" type="text/css">
<link href="/resources/slick/slick.css"  rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<!-- JS -->
<script type="text/javascript" src="/resources/slick/slick.min.js"></script>
<script type="text/css" ></script>
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
	 		<div class= "titleDiv" id= "titleDiv">
	 			<div class="title_wrap"><span>강남 지원</span></div>
	 		</div>
	 		<div class="visualDiv" id="visualDiv">
				<div id = 'map'></div>
				<div class='foodImgDiv' id = 'foodImgDiv'>
					<img class='foodImg' id = 'foodImg' src="/resources/image/foodPage/foodExample.png">
				</div>
	 		</div>
	 		<div class="slideDiv" id="slideDiv">
	 			<div class="bigSlide" id ="bigSlide">
	 				<span></span>
	 				<span></span>
	 				<span></span>		
	 			</div>
	 			<div class="bigSlide">
	 				<span></span>
	 				<span></span>
	 				<span></span>	
	 			</div>
	 			<div class="bigSlide">
	 				<span></span>
	 				<span></span>
	 				<span></span>	
	 			</div>
	 		</div>
	 		<div class="buttonDiv" id="buttonDiv">
	 			<span><i class="far fa-caret-square-left" id="prev"></i></span><span><i class="far fa-caret-square-right" id="next"></i></span>
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
		  slidesToShow: 1,
		  prevArrow: $('#prev'), 
		  nextArrow: $('#next')
	});
	</script>
</body>
</html>