<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.header{
 	 	display: flex;
 		align-items: center;
  		justify-content: center;
		/* border: 1px solid orange; */
		margin: 0px auto; 
		height: 400px; 
		width: 700px;
		color: orange;
	}
	.headerName{
			border : 0px;
			text-align: center;
			font-size: 100px;
		}

.wrapper{
			margin: 0px auto;
			height: 500px;
			width: 500px;
			border : 1px rgba(0, 0, 0, 0.2) solid;
			border-radius: 10px;
		}
		
		.CodeWrapper{
			display:flex;
			align-items:center;
			margin: 0px auto;
			height: 50px;
			width: 300px;
			background-color: orange;
			border : 1px rgba(0, 0, 0, 0.2) solid;
			border-radius: 10px;
		}
			.CodeWrapper2{
			margin: 0px auto;
			height: 40px;
			width: 290px;
			background-color: white;
			border : 1px rgba(0, 0, 0, 0.2) solid;
			border-radius: 10px;
		}
		
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header class = 'header'>
		<div class = 'headerName'>K H S</div>
	</header>

	<div class = 'wrapper'>
		<h1>이메일 인증 발송입니다.</h1>
		<h2>발송된 mail 번호는 다음과 같습니다.</h2>
		<div class = 'CodeWrapper'>
			<div class = 'CodeWrapper2'>
				<h3>dummy date(777777)</h3>
			</div>
		</div>
		<h2>인증 번호는 5분 뒤에 만료됩니다.</h2>
	</div>
<footer></footer>
</body>
</html>