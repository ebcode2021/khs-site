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
}
.site_tit> a{
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
	display: flex;
    flex-direction: column;
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
	font-family: 'han_sans_kr_Medium';
}



.history_post{
	height: 350px;
	margin-left: 20px;
	margin-right: 20px;
	
}

#history_table_title{
	font-size: 1.2rem;
	font-family: 'han_sans_kr_Medium';
	margin-bottom: 0.8vw;
}

.history_post_table {
	width: 100%;
	text-align: center;
	background-color: #FFF5EE;
	font-size: 0.8vw;
}

#history_comment_title{
	font-size: 1.2rem;
	font-family: 'han_sans_kr_Medium';
	margin-bottom: 0.8vw;
}

.history_comment_table{
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
	margin-top: 30px;
	margin-left: 20px;
	margin-right: 20px;
	height : 300px;
	
}



#delete-account {
	margin-top: 30px;
	height: 100px;
	margin-left: 20px;
	margin-right: 20px;
}

#delete-account-submit{
	width: 100%;
	height: 70%;
	text-align: center;
	background-color: #FFF5EE;
	font-size: 0.8vw;
	display: flex;
    flex-direction: column;
    justify-content: space-around;
}

#delete_account_title {
	font-size: 1.2rem;
	font-family: 'han_sans_kr_Medium';
	margin-bottom: 0.8vw;
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
 			<div class='site_tit'><a href="/main">K H S</a></div>
 			<div class='logout'><button><a href="/myPage/logout">로그아웃</a></button></div>
 		</div>
 		
 	</div>
 	
 	
 	<div class="nav">
 	</div>
 	
 	
 	<div class="section">
 		<div class='sidemenu'>
 		 	<div id="mypage"><a href="/myPage/myPageMain">나의 현황</a></div>
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
 			
 			<div class='history_post'>
				 <table class="history_post_table">
					<div id=history_table_title>자 유 게 시 판</div>
					<tr id="post_table_header">
						<th>게시글번호</th>
						<th>작성자</th>
						<th>글 제목</th>
						<th>작성일자</th>
					</tr>
					<c:if test="${not empty boardList}">
					<!-- https://zelkun.tistory.com/entry/JSTL%EB%AC%B8%EB%B2%95-cforEach-ctag%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%A6%AC%EC%8A%A4%ED%8A%B8-%EC%B6%9C%EB%A0%A5 -->
						<c:forEach items="${boardList}" var="board" varStatus="i">
							<tr height = "25">
								<td>${board.bdIdx}</td>
								<td>${board.nickName}</td>
								<td><a href="/board/free-board-detail?bd_idx=${board.bdIdx}">${board.title}</a></td>
								<td>${board.regDate}</td>
							</tr>
						</c:forEach>
					</c:if>
					
					<c:if test="${empty boardList}">
					<tr>
						<td>작성된 게시글이 없습니다.<td>
					</tr>
					</c:if>

				</table>
				<span id="check-error-msg"></span>
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
	
	

	
	</script>

	
	
</body>
</html>





