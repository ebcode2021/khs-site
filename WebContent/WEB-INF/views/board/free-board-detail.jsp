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








.board-detail-wrapper{
   
   margin-left: 20px;
   margin-right: 20px;
   
}

#board-detail-table-title{
   font-size: 1.2rem;
   font-family: 'han_sans_kr_Medium';
   font-weight: bold; /*추가*/
   margin-bottom: 0.8vw;
   margin-top: 0.8vw;
}

.board-detail-table {
   width: 100%;
   background-color: #FFF5EE;
   font-size: 0.8vw;
   border-top: 1px solid #444444;
   border-collapse: collapse;
   border: 1px solid;
   display : table; 
   margin-left : auto;
}



.board-detail-table> tr{
   border-top: 1px solid #444444;
    border-collapse: collapse;
    font-size: 1.0vw;
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
             <colgroup /*추가*/>
                <col width="100xp">
             </colgroup>
               <div id=board-detail-table-title>자 유 게 시 판</div>
               
               <tr id="post_table_header" /*추가*/style="background-color:#fecf92;">
       
                   <td /*추가*/style=" text-align:center; font-size:14px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray; ">
                  <c:out value= '${datas.board.bdIdx}'/>
                  </td>                 
                  <td /*추가*/colspan="3" style="text-align: left; font-size:20px; border-bottom: 1px solid #444444;; padding: 10px; border-bottom:1px solid lightgray;">
                  <c:out value= '${datas.board.title}'/>
                  </td>
               </tr>
               
               <tr /*추가*/style="background-color: #fecf92;">
               <th /*추가*/col width="10% style="text-align: left; font-size: 8px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">작성자</th>
               <td /*추가*/col width="10%  style="text-align: left; font-size: 8px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">
                  <c:out value='${datas.board.nickName}'/>
                  </td >              
               <th /*추가*/col width="10% style="text-align: left;  font-size: 8px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">작성일자</th>
               <td /*추가*/style="text-align: left; font-size:8px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">
                  <c:out value= '${datas.board.regDate}'/>
                  </td>
               </tr>


               <tr>
                  <td /*추가*/colspan="4" id="board-content" style="text-align: justify; margin-left: 13%; margin-right: 13%; padding : 1em;">
                     <br>
                     <c:if test="${not empty datas.files}">
                     <c:forEach items="${datas.files}" var="file" varStatus="i">
                        <img src="/file/${file.savePath}${file.renameFileName}?originFileName=${file.originFileName}" id="profile-image">
                     </c:forEach>
                     </c:if>
                     <br>
                     <br>
                     ${datas.board.content}
                     <br>
                     <br>
                     <br>
                  </td>
               </tr>


            </table>

          </div>
          
          <c:if test="${not empty myworks}">
          <div class="remove-and-upadte">
             <form action = "/board/board-update-form?bdIdx=${datas.board.bdIdx}" method="post">
                <button /*추가*/style="float: right;">수정하기</button>
             </form>
             
             <form action = "/board/board-delete?bdIdx=${datas.board.bdIdx}" method="post">
                <button /*추가*/style="float: right;">삭제하기</button>
             </form>
          </div>
          </c:if>
          
          <div class='board-detail-wrapper'  style="margin-top: 30px;">
             <div id="board-comment-title">댓 글 작 성</div>
             
             <table class="board-detail-table">
                <form action="/board/free-board-comment-input?bdIdx=${datas.board.bdIdx}"  method="post">
                  <div class="cmt_input">
                     <textarea name="comment-content" /*추가*/style="width:99%; height:80px; resize:none;" required="required"></textarea>
                  </div>
               <button /*추가*/style="float: right ;">전송</button>
               </form>
            </table>
          </div>
          
          
          <div class='board-detail-wrapper'>
             <div id="board-comment-title">댓 글</div>
             
             <c:if test="${not empty boardCommentList}">
                <table class="board-detail-table" /*추가*/style="width: 100; border-top: 1px solid #444444; border-collapse: collapse; display : table; margin-left : auto;">
                  <c:forEach items="${boardCommentList}" var="board" varStatus="i">
                     <tr id="post_table_header" /*추가*/style="background-color: #fecf92;">
                        <th /*추가*/col width="12% style="text-align: left; font-size: 8px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">댓글번호 :</th>
                        <td /*추가*/col width="11% style="text-align: left; font-size: 15px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">${board.cmtIdx}</td>
                        <th /*추가*/col width="11% style="text-align: left; font-size: 8px;  border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">작성자 :</th>
                        <td /*추가*/col width="11% style="text-align: left; font-size: 15px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">${board.nickName}</td>
                        <th /*추가*/col width="12% style="text-align: left; font-size: 8px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">작성일자 :</th>
                        <td /*추가*/style="text-align: left; font-size: 8px; border-bottom: 1px solid #444444; padding: 10px; border-bottom:1px solid lightgray;">${board.cmtRegDate}</td>
                     </tr>
                     
                     <tr>
                        <td colspan="5" class="comment-content"  /*추가*/style="vertical-align : middle; margin-left: 13%; margin-right: 13%; padding : 1em;">
                           ${board.cmtContent}
                        </td>
                        <td>
                           <c:if test="${board.userId eq myUserId}">
                               <div  align="right" class="remove-and-upadte" /*추가*/style="width: 90%; margin: 10px auto;">
                                  <form action = "/board/free-board-comment-update?cmtIdx=${board.cmtIdx}" method="post">
                                     <button /*추가*/style="width:30%; box-sizing: border-box;">수정</button>
                                  </form>
                                  <form action = "/board/free-board-comment-delete?cmtIdx=${board.cmtIdx}&bdIdx=${datas.board.bdIdx}" method="post">
                                     <button /*추가*/style="width:30%; box-sizing: border-box;">삭제</button>
                                  </form>
                               </div>
                               </c:if>
                        </td>
                     </tr>
                  </c:forEach>               
               </table>
            </c:if>
            
            <c:if test="${empty boardCommentList}">
               <table class="board-detail-table">
                  <tr>
                     <td style="font-size: 15px; text-align: center;"><br><br>작성된 댓글이 없습니다.<br><br><td>
                  </tr>
               </table>
            </c:if>
            
          </div>
          
          
          
        
 			
          
          
          
          
       </div>
    </div>
    
    
   <div class="footer">Copyright © 1998-2021 KH Information Educational Institute All Right Reserved</div>
   
   
   
   
   
   
   <script type="text/javascript">
   

   

   

   
   
   </script>

   
   
</body>
</html>



