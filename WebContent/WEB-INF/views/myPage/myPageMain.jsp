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



.history_post{
	height: 350px;
	margin-left: 20px;
	margin-right: 20px;
	
}

#history_table_title{
	font-size: 1.2vw;
	margin-bottom: 0.8vw;
}

.history_post_table {
	width: 100%;
	text-align: center;
	background-color: #FFF5EE;
	font-size: 0.8vw;
}


#post_table_header> th{
	height: 35px;
	text-align: center;
}


#history_post_delete_button {
	font-size: 1.0vw;
	margin-top: 0.8vw;
}



.history_comments {
	margin-left: 20px;
	margin-right: 20px;
	height : 300px;
	
}

.calendar {
	height : 200px;
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
					<div><a href="/myPage/myPageDetail">회원 상세정보 페이지로 이동</a></div>
				</div>
				
				
 			</div>
 			<div class='history_post'>
 				<form action="/myPage/delete-post" id="delete-post-submit">
				 <table class="history_post_table">
					<div id=history_table_title>작성한 게시글</div>
					<tr id="post_table_header">
						<th>선택</th>
						<th>게시글번호</th>
						<th>글제목</th>
						<th>작성일자</th>
						<th>게시판</th>
					</tr>
					<!-- https://zelkun.tistory.com/entry/JSTL%EB%AC%B8%EB%B2%95-cforEach-ctag%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%A6%AC%EC%8A%A4%ED%8A%B8-%EC%B6%9C%EB%A0%A5 -->
					<c:forEach items="${boardList}" var="board" varStatus="i">
						<tr height = "25">
							<td><input type="checkbox" class = "chk_num" name="chk_num" value="${board.bdIdx}"></td>
							<td>${board.bdIdx}</td>
							<td>${board.title}</td>
							<td>${board.regDate}</td>
							<td>${board.bdSection}</td>
							
						</tr>
					</c:forEach>
					
				</table>
				<button id="history_post_delete_button">체크한 게시글 삭제하기</button>
				<span id="check-error-msg"></span>
 				</form>
 			</div>
 			
 			

			<div class='history_comments'>
 			
				 <table class="history_post_table">
					<tr>
						<th>선택</th>
						<th>게시글번호</th>
						<th id="freeChart_title">글제목</th>
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>005</td>
						<td></td>
			
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>004</td>
						<td>해킹/보안 블로그 글업 스터디 모집합니다.</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>003</td>
						<td>신입 PHP 추천 책 있을까요?</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>002</td>
						<td>학부생 질문드리고 싶은게 있습니다!</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>001</td>
						<td>spring 웹 과외(강의) 추가 인원 모집 합니다.</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>001</td>
						<td>spring 웹 과외(강의) 추가 인원 모집 합니다.</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>001</td>
						<td>spring 웹 과외(강의) 추가 인원 모집 합니다.</td>
					</tr>
					<tr>
						<td><input type="checkbox" name="chk_info" value="공지글등록"></td>
						<td>001</td>
						<td>spring 웹 과외(강의) 추가 인원 모집 합니다.</td>
					</tr>
				</table>
 			
 			</div>
 			
 			
 			<div class='calendar'>캘린더</div>
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
	
	


	
	
	</script>

	
	
</body>
</html>





