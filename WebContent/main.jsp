<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />

<script type="text/javascript" src="scripts/jquery.js"></script>
</head>
<body>
	
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@include file="head.jspf" %>
			<!--错误信息  -->
			<div id="error"></div>
			<!--短消息列表  -->
			<div class="content messageList">
				<ul>
					<c:forEach items="${mList}" var="temp">			
						<li class="${temp.state=='未读'?'unReaded':''}">
							<a href="doOne?id=${temp.id}">
								标题:${temp.title}-------来自:${temp.fromUser} 
							</a>
						<%-- <em><a href="doDelete?id=${temp.id}" style="color:#ff0000" >删除邮件</a></em> --%>
							<em><a href="javascript:myDelete(${temp.id})" style="color:#ff0000" >删除邮件</a></em>
						</li>
					</c:forEach>
				</ul>
				<div class="page-spliter">
					<a href="doReceive?page=${pager.prevPage}">上一页</a>
						<c:forEach items="${pager.groupList}" var="i">
							<c:if test="${i==pager.currentPage}">
								${i}
							</c:if>
							<c:if test="${i!=pager.currentPage}">
								<a href="doReceive?page=${i}">${i}</a>
							</c:if>
						</c:forEach>
					<a href="doReceive?page=${pager.nextPage}">下一页</a>						
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		function myDelete(ele){
		
			$.ajax({
				type:"post",
				url:"doDelete",
				data:"id="+ ele,
				async:false,
				dataType:"text", 
				success:function(msg){
					if(msg=="error"){
						alert("删除失败!");			
					}else if(msg=="ok"){
						alert("恭喜您,删除成功")
						location.href="doReceive";
					}
				},
				error:function(){
					alert("删除失败!")	
				}
			})
		}
	</script>
	
	
	
</body>
</html>
