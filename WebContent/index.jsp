<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>学士后 短消息平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
</head>
<body>
	<div id="loginTitle" class="png"></div>
	<div id="loginForm" class="userForm png">
		<form action="doLogin" method="post">
			<dl>
				<div id="error"></div>
				<dt>用户名：</dt>
				<dd>
					<input type="text" name="name" id="name"/>
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="pwd" id="pwd" />
				</dd>
			</dl>
			<div class="buttons">
				<input class="btn-login png" type= button name="login" value=" "  onclick="myLogin()"/>
				<a href="register.jsp"><input class="btn-reg png" type="button" name="register" value=" " /></a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	
		function myLogin(){
		
			$.ajax({
				type:"post",
				url:"doLogin",
				data:$("form").serialize(),
				async:false,
				dataType:"text",
				success:function(msg){
					if(msg=="error"){
						alert("用户名或密码错误!");
					}else if(msg=="ok"){
						alert("恭喜您,登陆成功")	
						location.href="doReceive";
					}
				}
			})
		}
	
		
	
	
	</script>
</body>
</html>

