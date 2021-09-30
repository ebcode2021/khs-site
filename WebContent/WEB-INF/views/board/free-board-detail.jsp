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



.board-detail-wrapper{
	height: 350px;
	margin-left: 20px;
	margin-right: 20px;
	
}

#board-detail-table-title{
	font-size: 1.2rem;
	font-family: 'han_sans_kr_Medium';
	margin-bottom: 0.8vw;

}

.board-detail-table {
	width: 100%;
	text-align: center;
	background-color: #FFF5EE;
	font-size: 0.8vw;
	border: 1px solid;
}

.board-detail-table> tr,td{
	border: 1px solid;
}

#board-content {
	text-align: left;
}

#board-comment-title{
	font-size: 1.2rem;
	font-family: 'han_sans_kr_Medium';
	margin-bottom: 0.8vw;
}

.comment-contnet {
	text-align: left;
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
 			
 			<div class='board-detail-wrapper'>
				 <table class="board-detail-table">
					<div id=board-detail-table-title>자 유 게 시 판</div>
					<tr id="post_table_header">
						<th>게시글번호</th><th>작성자</th><th>글 제목</th><th>작성일자</th>
					</tr>
					<tr>
						<td>
						<c:out value= '${board.bdIdx}'/>
						</td>
						<td>
						<c:out value='${board.nickName}'/>
						</td>
						<td>
						<c:out value= '${board.title}'/>
						</td>
						<td>
						<c:out value= '${board.regDate}'/>
						</td>
					</tr>

					<tr>
						<td colspan=4 id="board-content">
							<br>
							<br>
							<br>
							${board.content}
							<br>
							<br>
							<br>
						</td>
					</tr>


				</table>

 			</div>
 			
 			
 			<div class='board-detail-wrapper'>
				 <table class="board-detail-table">
					<div id="board-comment-title">댓 글</div>
					
					<c:if test="${not empty boardCommentList}">
						<c:forEach items="${boardCommentList}" var="board" varStatus="i">
							<tr id="post_table_header">
								<th>댓글번호</th>
								<th>작성자</th>
								<th>작성일자</th>
							</tr>	
							<tr height = "25">
								<td>${board.cmtIdx}</td>
								<td>${board.nickName}</td>
								<td>${board.cmtRegDate}</td>
							</tr>
							<tr>
								<td colspan = 3 class="comment-contnet">
									<br>
									<br>
									${board.cmtContent}
									<br>
									<br>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					
					
					<c:if test="${empty boardCommentList}">
					<tr>
						<td>작성된 댓글이 없습니다.<td>
					</tr>
					</c:if>
				</table>
 			</div>
 			
 			
 			
 			
 			
 			
 			<div class='board-detail-wrapper'>
 				<div id="board-comment-title">댓 글 작 성</div>
 				<form action="/board/board-detail-comment-input?bdIdx=${board.bdIdx}"  method="post">
				 <table class="board-detail-table">
					<div class="cmt_input">
						<textarea name="comment-content" required="required"></textarea>
					</div>
					<button>전송</button>
				</table>
				</form>
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





