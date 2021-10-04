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



.history_post{
   margin-left: 20px;
   margin-right: 20px;
}

#history_table_title{
   padding-top : 
   font-size: 1.2rem;
   font-family: 'han_sans_kr_Medium';
   font-weight: bold; /*추가*/
   margin-bottom: 0.8vw;
}

.history_post_table {
  table-layout: fixed; /*추가*/
   width: 100%;
   font-size: 0.8vw;
   text-align: center;
   background-color: #fff5ee;
   margin-bottom: 0.8vw;/*추가*/
   border-collapse: separate; /*추가*/
   border-spacing: 0px; /*추가*/
    border-top: 1px solid #ccc; /*추가*/
    border-bottom: 1px solid #444444;

}

#post_table_header> th{
      padding: 10px; /*추가*/
   text-align: center; 
    font-size:20px;
    vertical-align: top; /*추가*/
    border-top: 0.5px;
    border-bottom: 1px solid #444444; /*추가*/    
    background-color: #dec3b1;/*추가*/
}


#post_table_list> td {
     padding: 10px; /*추가*/
   font-size:13.5px;
   margin-top: 30px;
   text-align: left;
   vertical-align: top; /*추가*/
     border-bottom: 1px solid #ccc; /*추가*/
}







#post_input_page_link {
	margin-right: 5%;
	text-align: right;
	width: 100%;
}



.page {
	width: 15vw;
	display: flex;
    justify-content: space-around;
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
             <table class='history_post_table'>
               <div id='history_table_title'>스터디 게시판</div>
               <tr id="post_table_header">
                  <th col width="20%">게시글번호</th>
                  <th col width="15%">작성자</th>
                  <th col width="45%">글 제목</th>
                  <th col width="20%">작성일자</th>
               </tr>
               <c:if test="${not empty boardList}">
                  <c:forEach items="${boardList}" var="board" varStatus="i">
                     <tr id="post_table_list" height = "25">
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
          
          <div id="post_input_page_link">
	          <form action="/board/board-form?section=hot" method="post">
	             	<button>작성하기</button>
	          </form>  
          </div>
          
          <div class="page">
			   
			   <c:if test="${pageValues.prevFlg==1}">
					    <a href="/board/hot-board-main?page=${pageValues.startPageNum-1}">이전</a>
					</c:if>
					<c:forEach begin="${pageValues.startPageNum}" end="${pageValues.endPageNum}" step="1" var="i">
					    <c:choose>
					        <c:when test="${pageValues.currentPage==index}">
					            ${i}
					        </c:when>
					        <c:otherwise>
					            <a href="/board/hot-board-main?page=${i}">${i}</a>
					        </c:otherwise>
					    </c:choose>
					</c:forEach>
					<c:if test="${pageValues.nextFlg==1}">
					    <a href="/board/hot-board-main?page=${pageValues.endPageNum+1}">다음</a>
					</c:if>

   			 </div>
          
       </div>
    </div>
    
    
   <div class="footer">Copyright © 1998-2021 KH Information Educational Institute All Right Reserved</div>
   
   
   
   
   
   
   <script type="text/javascript">
   

   
   

   
   </script>

   
   
</body>
</html>




