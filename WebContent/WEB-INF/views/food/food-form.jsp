<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 공통헤더, EL-JSTL과  all.css, reset.css 있음 -->
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<%@page import="khs.food.model.dto.Food"%>
<!DOCTYPE html>
<html>
<head>
<!--kakaoMap  -->
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
 			<div class='site_tit'><a href="/main" style="color:#f29d2a;">K H S</div>
 			<div class='logout'><button><a>로그아웃</a></button></div>
 		</div>
 	</div>
 	<div class="section">
 		<div class='sidemenu'>
 		 	<div id="mypage"><a href="/myPage/myPageMain">나의 현황</a></div>
 			<div><a href="/studyPage/index">학습 자료실</a></div>
 			<div id="wrap_hotplace"><a href="/food">맛집 정보</a></div>
 			<div><a href="/board/free-board-main">게시판</a></div>
 		</div>
 		<div class= 'main_banner'>
 		<div class= 'mainDiv' id = 'mainDiv'>
	 		<div class= "titleDiv" id= "titleDiv" style="padding-top:30px;">
	 			<div class="title_wrap"><span class = "title_food" >강남 지원 맛집 게시판</span></div>
	 		</div>
	 		<div class="visualDiv" id="visualDiv">
					<div class="map_wrap">
						<div id="map"
							style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
						<div id="menu_wrap" class="bg_white">
							<ul id="placesList"></ul>
							<div id="pagination"></div>
						</div>
					</div>
				</div>
	 		<div class="slideDiv" id="slideDiv">
	 			<div class="bigSlide" id ="bigSlide">
	 				<span class="smallSlide" id= "smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F01.jpg">
	 					<span>
	 					${foodArr[0].storeName}<br>
	 					${foodArr[0].storeMenu}<br>
	 					${foodArr[0].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F02.jpg">
	 					<span>
	 					${foodArr[1].storeName}<br>
	 					${foodArr[1].storeMenu}<br>
	 					${foodArr[1].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F03.jpg">
	 					<span>
	 					${foodArr[2].storeName}<br>
	 					${foodArr[2].storeMenu}<br>
	 					${foodArr[2].storeDescription}<br> 
	 					</span>
	 				</span>		
	 			</div>
	 			<div class="bigSlide" id ="bigSlide">
	 				<span class="smallSlide" id= "smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F04.jpg">
	 					<span>
	 					${foodArr[3].storeName}<br>
	 					${foodArr[3].storeMenu}<br>
	 					${foodArr[3].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F05.jpg">
	 					<span>
	 					${foodArr[4].storeName}<br>
	 					${foodArr[4].storeMenu}<br>
	 					${foodArr[4].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F06.jpg">
	 					<span>
	 					${foodArr[5].storeName}<br>
	 					${foodArr[5].storeMenu}<br>
	 					${foodArr[5].storeDescription}<br> 
	 					</span>
	 				</span>		
	 			</div>
	 			<div class="bigSlide" id ="bigSlide">
	 				<span class="smallSlide" id= "smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F07.jpg">
	 					<span>
	 					${foodArr[6].storeName}<br>
	 					${foodArr[6].storeMenu}<br>
	 					${foodArr[6].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F08.jpg">
	 					<span>
	 					${foodArr[7].storeName}<br>
	 					${foodArr[7].storeMenu}<br>
	 					${foodArr[7].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F09.jpg">
	 					<span>
	 					${foodArr[8].storeName}<br>
	 					${foodArr[8].storeMenu}<br>
	 					${foodArr[8].storeDescription}<br> 
	 					</span>
	 				</span>		
	 			</div>
	 			<div class="bigSlide" id ="bigSlide">
	 				<span class="smallSlide" id= "smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F10.jpg">
	 					<span>
	 					${foodArr[9].storeName}<br>
	 					${foodArr[9].storeMenu}<br>
	 					${foodArr[9].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F11.jpg">
	 					<span>
	 					${foodArr[10].storeName}<br>
	 					${foodArr[10].storeMenu}<br>
	 					${foodArr[10].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F12.jpg">
	 					<span>
	 					${foodArr[11].storeName}<br>
	 					${foodArr[11].storeMenu}<br>
	 					${foodArr[11].storeDescription}<br> 
	 					</span>
	 				</span>		
	 			</div>
	 			<div class="bigSlide" id ="bigSlide">
	 				<span class="smallSlide" id= "smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F13.jpg">
	 					<span>
	 					${foodArr[12].storeName}<br>
	 					${foodArr[12].storeMenu}<br>
	 					${foodArr[12].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F14.jpg">
	 					<span>
	 					${foodArr[13].storeName}<br>
	 					${foodArr[13].storeMenu}<br>
	 					${foodArr[13].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F15.jpg">
	 					<span>
	 					${foodArr[14].storeName}<br>
	 					${foodArr[14].storeMenu}<br>
	 					${foodArr[14].storeDescription}<br> 
	 					</span>
	 				</span>		
	 			</div>
	 			<div class="bigSlide" id ="bigSlide">
	 				<span class="smallSlide" id= "smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F16.jpg">
	 					<span>
	 					${foodArr[15].storeName}<br>
	 					${foodArr[15].storeMenu}<br>
	 					${foodArr[15].storeDescription}<br> 
	 					</span>
	 				</span>
	 				<span class="smallSlide">
	 					<img id = "hpImg" src="/resources/image/foodPage/F17.jpg">
	 					<span>
	 					${foodArr[16].storeName}<br>
	 					${foodArr[16].storeMenu}<br>
	 					${foodArr[16].storeDescription}<br> 
	 					</span>
	 				</span>
	 					
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
	
	/* 1. slideHover 코드 */


	/* 2. KAKAO_API 코드 */
	var container = document.getElementById('map');
	var options = { //지도를 생성할 때 필요한 기본 옵션
			center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
			level: 3 //지도의 레벨(확대, 축소 정도)
		};
	
	/* ***KAKAO 15SHOP 인포 배치 코드  */
	var markers = [];
	// 지도 생성 
	var map = new kakao.maps.Map(container, options);
	// 장소 검색 객체를 생성합니다
	var ps = new kakao.maps.services.Places();  
	// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
	var infowindow = new kakao.maps.InfoWindow({zIndex:1});
	// 장소 검색결과를 담을 배열 생성 
	const storeInfoArr = [];
	// 장소 검색 
	searchPlaces();
	
	// 검색 함수 
		function searchPlaces() {
		
			let food = "<c:out value='${foodArr[0].storeName}'/>";
			let food2 = "<c:out value='${foodArr[1].storeName}'/>";
			let food3 = "<c:out value='${foodArr[2].storeName}'/>";
			let food4 = "<c:out value='${foodArr[3].storeName}'/>";
			let food5 = "<c:out value='${foodArr[4].storeName}'/>";
			let food6 = "<c:out value='${foodArr[5].storeName}'/>";
			let food7 = "<c:out value='${foodArr[6].storeName}'/>";
			let food8 = "<c:out value='${foodArr[7].storeName}'/>";
			let food9 = "<c:out value='${foodArr[8].storeName}'/>";
			let food10 = "<c:out value='${foodArr[9].storeName}'/>";
			let food11 = "<c:out value='${foodArr[10].storeName}'/>";
			let food12 = "<c:out value='${foodArr[11].storeName}'/>";
			//let food13 = "<c:out value='${foodArr[12].storeName}'/>";
			let food14 = "<c:out value='${foodArr[13].storeName}'/>";

			
	    	ps.keywordSearch("테헤란로" + food , placesSearchCB);
	    	ps.keywordSearch("테헤란로" + food2, placesSearchCB);
	    	ps.keywordSearch("테헤란로" + food3, placesSearchCB);
	    	ps.keywordSearch("테헤란로" + food4, placesSearchCB);
	    	ps.keywordSearch("테헤란로" + food5, placesSearchCB);
	    	ps.keywordSearch("테헤란로" + food6, placesSearchCB);
	    	ps.keywordSearch(food7, placesSearchCB);
	    	ps.keywordSearch(food8, placesSearchCB);
	    	ps.keywordSearch(food9, placesSearchCB);
	    	ps.keywordSearch(food10, placesSearchCB);
	    	ps.keywordSearch(food11, placesSearchCB);
	    	ps.keywordSearch(food12, placesSearchCB);
	    	//ps.keywordSearch(food13, placesSearchCB);
	    	ps.keywordSearch(food14, placesSearchCB);

	    	
		
		ps.keywordSearch("none", placesDrawCB); 
	}
	
	// 장소검색 콜백함수 
	 	function placesSearchCB(data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {
			// 검색결과의 첫 번째 값을 배열에 추가 
	        storeInfoArr.push(data[0]);
			console.log('진입확인');
			return;
	    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
			console.log('가게 이름 검색 결과 존재하지 않음'); 
	        return;
	    } else if (status === kakao.maps.services.Status.ERROR) {
	    	console.log('검색 결과 중 오류발생');
	        return;
	    }
	}
	
	// 장소검색이 완료됐을 때 호출되는 콜백함수
	function placesDrawCB(data, status, pagination) {
	    if (status === kakao.maps.services.Status.OK) {
	    	//마커 생성 및 배포 함수 호출  
	    	displayPlaces(storeInfoArr);
	    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
	    	console.log('가게 이름 검색 결과 존재하지 않음'); 
	        return;
	    } else if (status === kakao.maps.services.Status.ERROR) {
	    	console.log('검색 결과 중 오류발생');
	        return;
	    }
	}
	
	// 마커 제거 및 새로 생성하는 함수 
	function displayPlaces(places) {
	    var listEl = document.getElementById('placesList'), 
	    menuEl = document.getElementById('menu_wrap'),
	    fragment = document.createDocumentFragment(), 
	    bounds = new kakao.maps.LatLngBounds(), 
	    listStr = '';
	    // 마커 및 검색결과 제거 
	    removeAllChildNods(listEl);
	    removeMarker();
	    // 마커생성 
	    for ( var i=0; i<10; i++ ) {
	    		var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
	            marker = addMarker(placePosition, i), 
	            itemEl = getListItem(i, places[i]); 
		        // 지도범위 재설정 위해 LatLngBounds 객체에 좌표를 추가합니다
		        bounds.extend(placePosition);
		        fragment.appendChild(itemEl);
	    }
	    var khPosition = new kakao.maps.LatLng( '37.498962679913234' ,'127.03280684486985');
	    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가
	    listEl.appendChild(fragment);
	    menuEl.scrollTop = 0;
	    // 검색된 장소 위치를 기준으로 지도 범위를 재설정
	    //map.setBounds(bounds);
	    
	    setCenter(); 
	}
	
	function setCenter() { 
		let khPosition = new kakao.maps.LatLng( '37.498962679913234' ,'127.03280684486985');
	    // 이동할 위도 경도 위치를 생성합니다 
	    // 지도 중심을 이동 시킵니다
	    map.setCenter(khPosition);
	}
	// kh학원 마커 
	var khPosition = new kakao.maps.LatLng( '37.498962679913234' ,'127.03280684486985');
	var marker = new kakao.maps.Marker({
	    position: khPosition
	});
	marker.setMap(map);

	// 검색결과 항목을 Element로 반환하는 함수 
	function getListItem(index, places) {
	    var el = document.createElement('li'),
	    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
	                '<div class="info">' +
	                '   <h5>' + places.place_name + '</h5>';
	    if (places.road_address_name) {
	        itemStr += '    <span>' + places.road_address_name + '</span>' +
	                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
	    } else {
	        itemStr += '    <span>' +  places.address_name  + '</span>'; 
	    }
	                 
	      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
	                '</div>';           
	
	    el.innerHTML = itemStr;
	    el.className = 'item';
	    return el;
	}
	// 마커를 생성하고 지도 위에 마커를 표시하는 함수
	function addMarker(position, idx){
	    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 사용 
	        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
	        imgOptions =  {
	            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
	            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
	            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
	        },
	        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
	            marker = new kakao.maps.Marker({
	            position: position, // 마커의 위치
	            image: markerImage 
	        });
	
	    marker.setMap(map); // 지도 위에 마커를 표출합니다
	    markers.push(marker);  // 배열에 생성된 마커를 추가
	    
	    return marker;
	}
	// 지도 위에 표시되고 있는 마커를 모두 제거하는 함수 
	function removeMarker() {
	    for ( var i = 0; i < markers.length; i++ ) {
	        markers[i].setMap(null);
	    }  
	   
	    markers = [];
	}
	 // 검색결과 목록의 자식 Element를 제거하는 함수
	function removeAllChildNods(el) {   
	    while (el.hasChildNodes()) {
	        el.removeChild (el.lastChild);
	    }
	}
	/* 3. SlickDiv생성 코드 */
	
	
	// bigSlide 가 몇개? 
	// bigSlide 는 foodArr의 갯수를 3으로 나눈 값을 저장,
	// 만일 몫이 1이상이고 나머지가 0 이상이라면 3+1 
	// 그 외애는 나눈 값 그대로 그림 
	
	/* 4. Slick적용 코드 */
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