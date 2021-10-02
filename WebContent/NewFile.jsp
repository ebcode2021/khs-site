<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/include/head.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%! int i = 7; %>
</head>
<body>
	<c:set var = "money" scope = "session" value = "${5000}"/>
    <c:choose>
	<c:when test="${ money > 4000 }"><h5>성공</h5></c:when>
	<c:otherwise><h5>실패</h5></c:otherwise>
	</c:choose>
	
	<c:set var = "money" scope = "session" value = "${5000}"/>
    <c:choose>
	<c:when test="${ money > 4 }"><h5>성공</h5></c:when>
	<c:otherwise><h5>실패</h5></c:otherwise>
	</c:choose>
	
</body>
</html>