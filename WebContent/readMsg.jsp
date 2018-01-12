<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>读短消息</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />

</head>
<body>
	
	<div id="main">
		<div class="mainbox">
			<div class="title readMessage png"></div>
			<%@include file="head.jspf" %>
			<div class="content">
				<div class="message">
					<div class="tmenu">
						<ul class="clearfix">
							<li>题目：</li>
							<li>来自：</li>
							<li>时间</li>
						</ul>
					</div>
					<div class="view">
						<p>短消息内容</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
