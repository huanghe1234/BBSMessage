<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>海文 在线短信平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script type="text/javascript" src="scripts/jquery.js"></script>
</head>

<body>
	<div id="regTitle" class="png"></div>
	<div id="regForm" class="userForm png">

		<form action="doRegister">
			<dl>
				<!--错误信息  -->
				<div id="error"></div>
				<dt>用 户 名：</dt>
				<dd>
					<input type="text" name="username" id="name"/>
				</dd>
				<dt>密 码：</dt>
				<dd>
					<input type="password" name="password" id="pwd"/>
				</dd>
				<dt>确认密码：</dt>
				<dd>
					<input type="password" name="affirm" id="affirm"/>
				</dd>
				<dt>邮 箱：</dt>
				<dd>
					<input type="text" name="email" />
				</dd>
			</dl>
			<div class="buttons">
				<input class="btn-reg png" type="submit" name="register" value=" " id="register"/>
				<input	class="btn-reset png" type="reset" name="reset" value=" " />
			</div>
			<div class="goback">
				<a href="index.jsp" class="png">返回登录页</a>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	$(function(){
		  $("#name").blur(function(){
			var $content = $("#name").val();
			  $.ajax({
					type:"POST",
					url:"doCheck",
					data:"name="+$content,
					success:function(msg){
						$("#error").text(msg);
						if(msg=="可以注册"){
							$("#register").prop('type','submit');
						}else{
							alert(msg);
							$("#register").prop('type','button');
						}
					}
				});
		  });
		});
	
	$(function(){
		$("#affirm").blur(function(){
			var $pwd=$("#pwd").val();
			var $affirm=$("#affirm").val();
			if($pwd!=$affirm){
				$("#error").text("两次输入的密码不一致");
				$("#register").prop('type','button');
			}else{
				$("#error").text("");
				$("#register").prop('type','submit');
			}
		});
	});
	</script>
	
	
</body>
</html>
