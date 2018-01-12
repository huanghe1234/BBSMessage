<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
</head>
<body>
	
	<form action="doSend" method="post">
		<div id="main">
			<div class="mainbox">
				<%@include file="head.jspf" %>
				<div class="content">
					<div class="message">

						<div class="tmenu">
							<ul class="clearfix">
								<li>发送给： <select name="toUser">
										<c:forEach items="${list}" var="temp">			
											<option value=${temp.name}>${temp.name}</option>
										</c:forEach>						
								</select>
								</li>
								<li>标题：<input type="text" name="title" id="title" /></li>
							</ul>
						</div>
						<div class="view">
							<textarea name="content" id="content"></textarea>
							<div class="send">
								<input type="submit" name="submit" value=" " />
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>
