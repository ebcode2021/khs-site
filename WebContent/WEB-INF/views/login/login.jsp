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
        <input type = "text" id="user_name" name="userId" placeholder="아이디" value="PCLASSTEST" autofocus><br></label>
      <label for="user_pw">
        <input type = "password" id="user_pw" name="password" placeholder="비밀번호" value="asdf1234!@#$"><br>
      </label>
      <button> 로그인 </button>
    </form>

    <div class="find">
      <div><a href="${ContextPath}/join/find">아이디/비밀번호 찾기</a></div>
      <div><a href="${ContextPath}/sns/naver">네이버로 로그인</a></div>
      <div><a href="${ContextPath}/sns/kakao">카카오로 로그인</a></div>
    </div>
      <div id="icon"><i class="far fa-question-circle fa-2x"></i> </div>
    </div>
    
    <div class="last_question"> 
      <div>아직 회원이 아니신가요?</div>
      <div id = "join"><a href="${ContextPath}/join/join-form">회원가입</a></div>
    </div>
  </main>
  
</body>
</html>