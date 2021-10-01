//login.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/index/index.css"/>
<script type="text/javascript" src="/resources/js/common/jquery.js"></script>
</head>

<body>
  <header>
   <p>KHS<span> 수강생 커뮤니티</span></p>
  </header>

  <main>
    <div class="yellow_border">
      <form action="${contextPath}/login/login-check" method="post">
        <label for="user_name">
        <input type = "text" id="user_name" name="userId" placeholder="아이디" autofocus><br></label>
      <label for="user_pw">
        <input type = "password" id="user_pw" name="password" placeholder="비밀번호"><br>
      </label>
      <button> 로그인 </button>
    </form>

    <div class="find">
      <div><a href="${ContextPath}/join/find">아이디/비밀번호 찾기</a></div>
      <form name="kakao" action="${ContextPath}/login/kakaoLogin" method="post">
      <div><a href="javascript:kakaoLogin()">카카오로 회원가입/로그인</a></div>
   	  </form>
    </div>
      <div id="icon"><i class="far fa-question-circle fa-2x"></i> </div>
    </div>
    
    <div class="last_question"> 
      <div>아직 회원이 아니신가요?</div>
      <div id = "join"><a href="${ContextPath}/join/join-form">회원가입</a></div>
    </div>
  </main>
  
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <script type="text/javascript">
  //jQuery 작동하는지 유무판단
 	 if(typeof jQuery =='undefined'){
		  alert('없음');
  	}else{
		  alert("있다!");
  	}
  
	  $('#far fa-question-circle fa-2x').on('hover', ()=>{
		  $(this).append($("<div> 보이나요? </div>"));
		  
	  }, ()=>{
		  $(this).empty();
	  });
	  
	  window.Kakao.init("381fa90ea846cba4a5527f77c034f477");
	    console.log(Kakao.isInitialized()); //카카오가 잘 연동이 되었는지
	   
	    function kakaoLogin(){
	    
	      window.Kakao.Auth.login({ 
	        scope : 'profile_nickname, account_email, gender',
	        success: function(response){
	          window.Kakao.API.request({
	            url : '/v2/user/me',
	            success : function(response) {
	      			  let kakao = document.kakao;
		        	  
		        	  $.ajax({
		        		  url : "login/kakaoLogin",
		        		  type : "POST",
		        		  data : {kakaoCode : JSON.stringify(response.id)},
		        		  
		        	  })	        	 
	              //여기서 비동기통신으로 다시 컨트롤러 단으로? ajax사용..
	            }
	          });
	        }
	      });
	    };
	  
  </script>
</body>
</html>