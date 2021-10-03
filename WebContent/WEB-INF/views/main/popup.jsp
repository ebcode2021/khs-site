<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/head.jsp" %>

<style>
	html,body{
      width : 100%;
      height : 100%;
    }
  .divpop {
      position: absolute; 
      z-index:999; 
      top:50px; 
      left:50px;
      width : 80%;
      height : 80%;
      border:1px solid black;
      background-image : url("../resources/image/main/QR.JPG");
      background-size : cover;
      background-repeat : no-repeat;
      background-position : center;
      display:none; 
  }
  .title_area {
  		font-weight:bold;
  		text-align:center;
  		width:100%
  	}
  	
  .button_area {
  		position:absolute;
  		bottom:0;
  		left:10px;
  		text-align:center;
  		transform : translate(-12px,30px);
  	} 
  .button_area>*{
 	 text-align:center;
  }
</style>
</head>

<body>
	<form name="notice_form">
		<div id="divpop1" class="divpop">
			<div class="title_area"></div>
			<div class="button_area">
				<input type='checkbox' name='chkbox' id='todaycloseyn' value='Y'>오늘
				하루 이 창을 열지 않음 <a href='#' onclick="javascript:closeWin(1);"><B>[닫기]</B></a>
			</div>
		</div>
	</form>

	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script>
	// 쿠키 가져오기
		var getCookie = function (cname) {
   		var name = cname + "=";
   	 	var ca = document.cookie.split(';');
   	 	for(var i=0; i<ca.length; i++) {
       		 var c = ca[i];
        		while (c.charAt(0)==' ') c = c.substring(1);
       			if (c.indexOf(name) != -1) return c.substring(name.length,c.length);
   		 }
    return "";
}

// 24시간 기준 쿠키 설정하기  
var setCookie = function (cname, cvalue, exdays) {
    var todayDate = new Date();
    todayDate.setTime(todayDate.getTime() + (exdays*24*60*60*1000));    
    var expires = "expires=" + todayDate.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

var couponClose = function(){
    if($("input[name='chkbox']").is(":checked") == true){
        setCookie("close","Y",1);  
    }
    $(".divpop").hide();
}

$(document).ready(function(){
    var cookiedata = document.cookie;
    console.log(cookiedata);
    if(cookiedata.indexOf("close=Y")<0){
        $(".divpop").show();
    }else{
        $(".divpop").hide();
    }
    $("#todaycloseyn").click(function(){
       close();
    });
});
    
</script>
</body>
</html>