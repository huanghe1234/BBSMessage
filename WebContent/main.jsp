<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />

</head>
<body>
	
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@include file="head.jspf" %>
			<!--错误信息  -->
			<div id="error"></div>
			<!--短消息列表  -->
			<div class="content messageList"></div>
		</div>
	</div>
</body>
</html>
