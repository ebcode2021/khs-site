<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/index/index.css"/>
</head>

<body>
  <header>
   <p>KHS<span> 수강생 커뮤니티</span></p> 
  </header>

  <main>
    <div class="yellow_border">
      <form action="${contextPath}/login/login-check" method="post">
        <label for="user_name">
        <input type = "text" id="user_name" name="userId" placeholder="아이디" value="" autofocus><br></label>
      <label for="user_pw">
        <input type = "password" id="user_pw" name="password" value = "" placeholder="비밀번호"><br>
      </label>
      <button> 로그인 </button>
    </form>

    <div class="find">
      <div><a href="${ContextPath}/search/search-form">아이디/비밀번호 찾기</a></div>
      <form name="kakao">
      <div><a href="javascript:kakaoLogin()">카카오로 회원가입/로그인</a></div>
   	  </form>
    </div>
      <div id="icon">
      	<i class="far fa-question-circle fa-2x" style="cursor:pointer"></i> 
      </div>
    </div>
    
    <div class="last_question"> 
      <div>아직 회원이 아니신가요?</div>
      <div id = "join"><a href="${ContextPath}/join/join-form">회원가입</a></div>
    </div>
  </main>
  
  
  <script type="text/javascript" src="/resources/js/common/jquery.js"></script>
  <script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
  <script type="text/javascript">
  
	$('#icon').click(function(){
		  alert("본 사이트는 KH정보교육원 학생들을 위한 커뮤니티 입니다.\n방문하셔서 양질의 정보를 얻어가세요!\n\n문의 메일 : KHsemiPro04@gmail.com");
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
	      			  let code = response.id;
		        	  fetch('/login/kakaoLogin?code='+code)
		        	  .then(response=>response.text())
		        	  .then(text => {
		        		  if(text=="notContain"){
		        			  location.href="/join/join-form";
		        		  }else{
		        			  location.href="/main"
		        		  }
		        			  
		        	  })
		        	  /* $.ajax({
		        		  url : "login/kakaoLogin",
		        		  type : "POST",
		        		  data : {kakaoCode : JSON.stringify(response.id)},
		        		  
		        	  })	 */        	 
	             
	            }
	          });
	        }
	      });
	    };
	  
  </script>
</body>
</html>