<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" type="text/css" rel="stylesheet">
<title>404</title>
</head>
<style>
  html,body{
    height : 100%;
  }

  header{
    height : 20%;
  }

  header>div{
    display:flex;
    justify-content: center;

  }
  header>div>a{
    font-size: 4em;
    font-weight: bold;
    color :rgba(255, 157, 0, 0.5); 
    padding-top : 3%;
    
  }

 main{
   height : 65%;
   text-align: center;
   font-size: 30px;
   font-weight: bolder;
   background-color: rgba(255, 157, 0, 0.5);
   margin-left : 10%;
   margin-right : 10%;
   line-height : 150%;
   border-radius : 80px 40px;
 }

 #emotion{
   padding-top : 5%;
   padding-bottom : 2.5%;
   color:white;
 }

 #literal{
   color : white;
 }

 footer{
   height : 15%;
   text-align: center;
  
 }
</style>
<body>

  <header><div><a href="/login/login">KHS</a></div></header>
  <main>
    <div id="emotion">
      <i class="far fa-sad-tear fa-6x"></i>
    </div>
    <div id="literal">
      <div>404</div>
      <div>Page Not Found</div>
      <div>잘못된 경로입니다.</div>
    </div>
  </main>
  <footer>
    
  </footer>
  

  
</body>
</html>