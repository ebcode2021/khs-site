<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<!--폰트어썸  -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" type="text/css" rel="stylesheet">

<!--slick -->
<link href="/resources/slick/slick-theme.css"  rel="stylesheet" type="text/css">
<link href="/resources/slick/slick.css"  rel="stylesheet" type="text/css">
<link href="/resources/js/common/jquery.js" rel="stylesheet" type="text/css"> 
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- <script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js" type="text/javascript"></script> -->

<!-- 카카오페이 결제 시스템 -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

<script type="text/javascript">
      $.noConflict();
</script>
<!--여기 경로만 잡으면 끝 slick완성-->
<!-- <link href="/resources/js/common/jquery.js" rel="stylesheet" type="text/css"> -->



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

    header>div>a:link, header>div>a:visited{
      font-size: 4em;
      font-weight: bold;
      color :rgba(255, 157, 0, 0.5);   
      padding-left : 30%;   
    }
    
    #exclamation{
      padding-top : 10px;
      padding-right : 30px;
      display: flex;
     
    }

    #logout{
      font-size: 1em;
      padding-top : 10px;
      padding-right : 15px;

    }
    /* 메인 */
    main{
      min-height : 75%;
      /* background-color: bisque; */
    }

    section{
      display: flex;
      padding-top : 2%;
    }

    /* secion_1 부분 */

    .hello {
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
    
 	a:link, a:visited{
      color: white;
      font-size:20px;
    }
   

    .nav{
      background-color: rgba(255, 157, 0, 0.5);
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
      font-size: 30px;
      font-weight: bolder;
      align-items: center;
      justify-content: center;
      text-align: center;
      width : 30%;
      line-height: 300%;
      padding-top:30px;
      color:gray;
    }
    
    .cal>.countdown{
    	font-size: 40px;
    }

    .main_show{
      width : 70%;
      background-color: lightgray;
      margin : 1%;
    }

    .list>li{
      margin-left: 7%;
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
      background-color : rgba(255, 157, 0, 0.3);
    
    }

	.section_3>.game {
	  
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
      border-radius: 80%;
      overflow: hidden;
      padding-bottom:25%;
    }
    
    .game>.game1{
      background-image : url("../resources/image/main/dino.png");
      background-size : contain;
      background-position : center;
      cursor:pointer;
    }
    .game>.game2,.game3{
      background-image : url("../resources/image/main/ready.png");
      background-size : cover;
      background-position : center;
     
    }
    
    .news>.news1,.news2,.news3{
    	cursor : pointer;
    }
    
    .news>.news1{
      background-image : url("../resources/image/main/news1.jpg");
      background-size : cover;
      background-position : 80% center;
    }
    
    .news>.news2{
      background-image : url("../resources/image/main/news5.png");
      background-size : cover;
      background-repeat : no-repeat;
      background-position : center;
      overflow : hidden;
    }
    
    .news>.news3{
     background-image : url("../resources/image/main/news6.jpg");
      background-size : cover;
      background-repeat : no-repeat;
      background-position : center;
    }
    

    /* footer 부분 */
    footer{
      min-height : 25%;
    }

    .section_4{
      display: flex;
      justify-content: space-between;
      align-items: center;
      position:relative;
      background-color:rgba(255, 157, 0, 0.5); 
      padding-bottom : 20px;
      font-weight : bolder;
    }

    .visited{
      padding-left : 5%;
    }

    .slide{
       background-color:rgba(255, 157, 0, 0.5); 
       position:relative;
       width:50vw;
    }
    
    .slide img{
    	display : block;
    	width : 50vw;
    	height : 25vw;
    }
    
    .qrcode{
      padding-right : 5%; 
      vertical-align: center;
      margin-top : 1vw;
      font-size : 1.5em;
    }
	
	.qrcode>div{
	  text-align : center;
      display : flex;
      flex-direction: column;
      align-items:center;
      overflow: hidden;
	}
	.qrcode>#literal{
		background-color:rgba(255, 157, 0, 0.5); 
	}
	#kakaopay{
		background-image : url('../resources/image/main/kakaopay.png');
		background-repeat: no-repeat; 
		background-size : contain;
		height : 4vw;
		margin-top : 2vw;
		background-color: none;
		cursor:pointer;
    
	}
    .copyright{
      margin-top : 5%;
      padding-bottom : 15px;
      text-align: center;
    }
    
    
    
  </style>
</head>

<body>
  <header>
  <div></div>
   <div><a href='/main'>KHS</a></div>
   <div id="exclamation"><a id="logout" href="/main/logout">logout</a><i class="fas fa-exclamation-circle fa-2x"></i></div>
  </header>

  <main>
    <section class="section_1">
      <div class="hello"> 
        <p id="hello_first">반갑습니다..</p>
        <p id="hello_second">퇴실체크 <br> 했나요?</p>
      </div>
      
      <div class="nav">
        <div class="nav_1">
          <div id="mypage"><a href="/myPage/myPageMain">마이페이지</a></div>
          <div id="board"><a href="/board/free-board-main">게시판</a></div>
          <div id="restaurant"><a href="/restaurant">맛집 정보</a></div>
         </div>
         <div class="nav_2">
           <div id="study"><a href="/studyPage/index">학습 자료실</a></div>
           <div id="question"><a href="/question">문의사항</a></div>
           <div id="admin"><a href="/adminPage/index">관리자</a></div>
         </div>
      </div> 

    </section>
    

    <section class="section_2">
      <div class="cal">
        <div class='checkout'>퇴실까지 남은 시간</div>
        <div class="countdown">05:00:00</div>
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
         <div class="game">
           <div class="game1" onclick="window.open('#')"></div>
           <div class="game2"></div>
           <div class="game3"></div>
        </div>
        <br>
        <li> <span>관련 사이트</span></li>
         <div class="news">
           <div class="news1" onclick ="window.open('https://www.iei.or.kr/main/main.kh')"></div>
           <div class="news2" onclick ="window.open('https://www.hrd.go.kr/hrdp/ma/pmmao/indexNew.do')"></div>
           <div class="news3" onclick ="window.open('https://www.work.go.kr/kua/index.do')"></div>
        </div>
      </ol>
     </div>
    </section>

  </main>

  <footer>
    <section class="section_4">
      <div class="visited"> 
        <div>오늘 방문자 수 : ${todayCnt}</div>
        <div>누적 방문자 수 : ${totalCnt}</div>
      </div>
      <div class="slide" id="slide_slick">
        <div><img src="../resources/image/main/slide/slide01.jpg"/></div>
        <div><img src="../resources/image/main/slide/slide03.png"/></div>
        <div><img src="../resources/image/main/slide/slide04.jpg"/></div>
        <div><img src="../resources/image/main/slide/slide05.png"/></div>
      </div>
      <div class="qrcode">
        <div id="literal">개발자에게 <br> 돈 보내기 <br></div>
        	<div id="kakaopay" onclick="kakaoPay()"></div>
      </div>
    </section>
    <div class="copyright"> Copyright © 2021 - KH Students All Right Reserved-</div>
  </footer>
  
<script src="/resources/js/main/slick.js"  type="text/javascript"></script>
<script type="text/javascript">
   let click_count=0;
    document.querySelector('.hello').addEventListener('click', ()=>{
      click_count++;
      const element1 = document.getElementById('hello_first');
      const element2 = document.getElementById('hello_second');

      if(click_count%2!=0){
        element1.innerHTML =  "${authentication.name} 님의";
        element2.innerHTML =  "종강까지" + "<br>" + "${remainder}일" + "<br>"+  "남았네요!";
        
      }else{
        element1.innerHTML ="반갑습니다";
        element2.innerHTML = "퇴실체크" + "<br>"+"했나요?";
      }

    })

    let renderTime = () => {
    	//수업 시작시간과 종료시간 추출
    	let classStartTime = ${authentication.startTime};
    	let classEndTime = ${authentication.endTime};
    	
    	//현재 시간를 추출
    	let now = new Date();
    	let nowHour = now.getHours();
    	let nowMin = now.getMinutes();
    	let nowSec = now.getSeconds();
    	
    	let nowTime = nowHour*60*60 + nowMin*60 + nowSec;
    	
 
    	
    	if(!(nowTime>classStartTime && nowTime<classEndTime)){
    		document.querySelector('.countdown').innerHTML = "00 : 00 : 00";
    	}else{
    		let remainTime = classEndTime - nowTime;
    		remainTime = secToClock(remainTime);
    	
    		document.querySelector('.countdown').innerHTML = remainTime;
    	}
    	
    }
    
    (()=>{
    	setInterval(renderTime,1000);
    })()
    
    function secToClock(sec){
    	let hour = parseInt(sec/3600) <10? '0'+parseInt(sec/3600) : parseInt(sec/3600);
    	let min = parseInt((sec%3600)/60) < 10 ? '0'+ parseInt((sec%3600)/60) : parseInt((sec%3600)/60);
    	sec = sec%60 < 10? '0'+sec%60 : sec%60;
    	
    	return hour + ":" +min+ ":" + sec;
    }
    
    	
    
     jQuery(document).ready(function(){
    	 jQuery('#slide_slick').slick({
    		dots : false,
    		arrows: false,
    		infinite : true,
    		autoplay : true,
    		autoplaySpeed : 4000,
    	
    	});
    }); 


    jQuery('#kakaopay').click(function(){
    	var IMP = window.IMP;
    	IMP.init('imp28553074');
    	
    	IMP.request_pay({
    		pg : 'kakao',
    		pay_method : 'card',
    		merchant_uid : 'merchant_' + new Date().getTime(),
    		name : 'KHS 개발자를 위해 까까 사주기',
    		amount : '100',
    		buyer_email :'',
    		buyer_tell :'',
    		buyer_addr : '',
    		buyer_postcode :'123-456',
    	},function(rsp){
    		console.log(rsp);
    		if(rsp.success){
    			var msg = '결제가 성공적으로 완료되었습니다.';
    			msg += '결제 금액 : ' + rsp.paid_amount;
    		}else{
    			var msg = '결제에 실패하였습니다.';
    			msg += '에러내용 :' + rsp.error_msg;
    		}
    		alert(msg);
    	});
    });
    
    
    
  </script>
</body>
</html>