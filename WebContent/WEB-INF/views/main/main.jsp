<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" type="text/css" rel="stylesheet">
</head>
  <style>
    html,body{
      width : 100%;
      height : 100%;
    }

    /* 헤더 */
    header{
      height : 10%;
      text-align : center;
      display: flex;
      flex-direction: row;
      justify-content : space-between;
    }

    header>div>p{
      font-size: 4em;
      font-weight: bold;
      color :rgba(255, 157, 0, 0.5);   
      padding-left : 30%;   
    }

    #exclamation{
      padding-top : 10px;
      padding-right : 10px;
    }

    /* 메인 */
    main{
      min-height : 75%;
      background-color: bisque;
    }

    section{
      display: flex;
      padding-top : 2%;
    }

    /* secion_1 부분 */

    .hello {
      color:white;
      font-size: 20px;
      font-weight: bolder;
      align-items: center;
      justify-content: center;
      text-align: center;
      width : 30%;
      line-height: 200%;
      background-color: white;
    }

    .hello>p{
      color:lightgray;
    }
    #hello_first{
      color:gray;
    }
    

    a:link{
      color:white;
      font-size:20px;
    }

    .nav{
      background-color: rgba(255, 157, 0, 0.3);
      font-weight: bolder;
      width : 70%;
      display : flex;
      flex-direction: column;
      justify-content: center;
      
    }
   
    .nav_1, .nav_2{
      display: flex;
      justify-content: space-around;
      padding-top : 2%;
      padding-bottom : 2%;
    }

    /* .nav_1>div, .nav_2>div{
      float:left; 
    } */

    
    /* section_2부분 */
 
    .cal{
      width :30%;
    }

    .main_show{
      width : 70%;
      background-color: lightgray;
      margin : 1%;
    }

    .list>li{
      margin-left: 5%;
      font-size : 20px;
      list-style-type: disc;
      color:lightsalmon;
      margin-top : 2%;
      margin-bottom:2%;
    }

    .list>div{
      margin-left:2%;
      margin-bottom : 1%;
    }
    
    .list>li>span{
      color:white;
      font-weight: bold;
    }

    hr{
      background-color: lightyellow;
    }

    /* section_3부분 */
    .section_3{
      margin : 1%;
      background-color: gray;
    }

    .game_news{
     width : 100%;
    }

    .game_news_list{
      display : flex;
      flex-direction: column;
    }

    .game_news_list>li{
      margin-left: 5%;
      font-size : 20px;
      list-style-type: square;
      color:lightsalmon;
      margin-bottom:2%;
      
    }

    .game_news_list>li>span{
      color:white;
      font-weight: bold;
    }

    .game_news_list>div{
     
      margin-left:1%;
      margin-right : 1%;
      margin-bottom : 1%;
      position:relative;
      display : flex;
      justify-content: space-between;
    }

    .game_news_list>div>div{
      width : 30%;
      display:flex;
      float:left;
      align-items: center;
      background-color: lightcoral;
      padding-bottom:25%;
    }


    /* footer 부분 */
    footer{
      min-height : 25%;
      background-color: cornflowerblue;
    }

    .section_4{
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    .visited{
      padding-left : 3%;
    }

    .qrcode{
      padding-right : 3%;
      vertical-align: center;
    }

    .copyright{
      margin-top : 5%;
      text-align: center;
    }
  </style>
</head>

<body>
  <header>
  <div></div>
   <div><p>KHS</p></div>
   <div id="exclamation"><i class="fas fa-exclamation-circle fa-2x"></i></div>
  </header>

  <main>
    <section class="section_1">
      <div class="hello"> 
        <p id="hello_first">반갑습니다.</p>
        <p>퇴실체크 <br> 했나요?</p>
      </div>
      
      <div class="nav">
        <div class="nav_1">
          <div id="mypage"><a href="/myPage/myPageMain">마이페이지</a></div>
          <div id="board"><a href="/board">게시판</a></div>
          <div id="restaurant"><a href="/restaurant">맛집 정보</a></div>
         </div>
         <div class="nav_2">
           <div id="study"><a href="/study">학습 자료실</a></div>
           <div id="question"><a href="/question">문의사항</a></div>
         </div>
      </div> 

    </section>
    

    <section class="section_2">
      <div class="cal">
        캘린더 api 들어갈 곳
      </div>
      <div class="main_show">
        <ol class="list">
          <li> <span>공지사항</span></li>
          <div>여기에 공지사항 리스트 들어갈거고</div>
          <hr>
          <li> <span>BEST 게시판</span></li>
          <div>여기에는 추천수 대로 best게시판 넣어볼까?</div>
          <div>여기에 계속 div가 추가되게 for문</div>
          <div>지금은 볼려고 이렇게</div>
        </ol>
      </div>
    </section>
  
    <section class="section_3">
      <div class="game_news">
       <ol class="game_news_list">
        <li> <span>게임</span></li>
         <div>
           <div>coming soon</div>
           <div>coming soon</div>
           <div>coming soon</div>
        </div>
        <br>
        <li> <span>관련 뉴스</span></li>
         <div>
           <div>coming soon</div>
           <div>coming soon</div>
           <div>coming soon</div>
        </div>
      </ol>
     </div>
    </section>

  </main>

  <footer>
    <section class="section_4">
      <div class="visited"> 
        <div>현재 방문자 수 : ㅇㅇ명</div>
        <div>누적 방문자 수 : ㅇㅇ명</div>
      </div>
      <div class="slide"> slick으로 슬라이드</div>
      <div class="qrcode">
        <div>[개발자에게 기부하기]</div>
        <div>
          여긴 qr코드
        </div>
      </div>
    </section>
    <div class="copyright"> @copyright 1s4j 2021-</div>
  </footer>

</body>
</html>