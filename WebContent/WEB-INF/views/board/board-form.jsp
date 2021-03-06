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
   align-items: center;
   
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


.title {
	margin-left: 1.5vw;
	margin-top : 1.5vw;

}


#board-write-table-title {
   font-size: 1.2rem;
   font-family: 'han_sans_kr_Medium';
   font-weight: bold; /*추가*/
   margin-bottom: 1.0vw;
   padding: 10px;
   margin-bottom: 1.0vw; 
   padding: 10px;
   margin-top: 50px;
}


.file {
   margin-bottom: 1.0vw; 
   margin-top : 1.5vw;
   margin-left: 1.5vw;
}

.content_board {
   width: 98%;
}




#post_input_page_link {
   display: flex;
   justify-content: flex-end;
    margin-right: 5%;
    display: block; /*추가*/
    width:300px; /*추가*/
    margin:auto;/*추가*/
}




#content_input_editor {
   resize: none;
   height: 500px;
   width: 700px;
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
 		
 			<form action=
 				<c:if test="${empty datas}">
 							<c:choose>
 								<c:when test="${not empty alert}">
 								"/board/board-upload?bd-section=alert"
 								</c:when>
 								<c:when test="${not empty hot}">
 								"/board/board-upload?bd-section=hot"
 								</c:when>
	 							<c:when test="${not empty free}">
								"/board/board-upload?bd-section=free"
								</c:when>
							</c:choose>
				</c:if>
 				<c:if test="${not empty datas}">
							"/board/board-update?bdIdx=${datas.board.bdIdx}&section=${datas.board.bdSection}"
				</c:if> 
				method="post" enctype="multipart/form-data">
 				<div class='title'>
 					제목 : <input type="text" name="title" id="title"
 					<c:if test="${not empty datas}">
						value= ${datas.board.title}
					</c:if>
 					required="required">
 					
 				</div>
 				
 				<div class='file'>
 					파일 : <input type="file" name="files" id="contract_file" multiple/>
 				</div>
 				
	 			<div class='content_board'>
					<textarea name="content" id="content" rows="10" cols="100"><c:if test="${not empty datas}">${datas.board.content}</c:if></textarea>
	 			</div>
	 			
	 			<div class="btn_section">
	 				<button id="post_input_page_link">게시글 작성하기</button>
	 			</div>
	 			
 			</form>
 			
 		</div>
 	</div>
 	
 	
 	
	<div class="footer">Copyright © 1998-2021 KH Information Educational Institute All Right Reserved</div>
	
	
	
	


	
</body>
</html>





