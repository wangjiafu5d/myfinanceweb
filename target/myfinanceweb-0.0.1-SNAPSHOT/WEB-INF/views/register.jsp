<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta name="generator"
	content="HTML Tidy for HTML5 for Windows version 5.2.0" />
<meta charset="utf-8" />
<title>注册</title>
<meta name="googlebot" content="noarchive" />
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<link rel="shortcut icon" href="${APP_PATH}/static/img/favicon.ico"
	type="image/x-icon" />
<link
	href="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/css/bootstrap.min.css"
	rel="stylesheet" />
<script
	src="https://cdn.bootcss.com/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script>
function register() {
	$.ajax({
		url:"${APP_PATH}/registerToServer",
		type:"GET",		
		data: $('#form1').serialize(),
		success:function(response){
			console.log(response.code);
			if(response.code==200){
			    window.location.replace("index");
			}else{
				alert(response.extend.response);
			}			
		}
		});
}
function reset() {
	$('#form1')[0].reset();
} 
    </script>
<style>
body {
	margin: 5% 40% 0% 40%;
}

button {
	margin: 0 10px 0 0;
}
</style>
</head>
<body background="${APP_PATH}/static/img/register_background.jpg">
	<form id="form1">
		<div class="form-group">
			<label for="exampleInputEmail1">用户名</label> <input type="text"
				class="form-control" name="userName" placeholder="用户名">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">密码</label> <input
				type="password" class="form-control" name="password"
				placeholder="密码">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">邮箱</label> <input
				type="text" class="form-control" name="email"
				placeholder="邮箱">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">手机号</label> <input
				type="text" class="form-control" name="phoneNum"
				placeholder="电话号码">
		</div>	
		<button type="button" class="btn btn-info" onclick="reset()">取消</button>
		<button type="button" class="btn btn-primary" onclick="register()">提交</button>
	</form>
</body>
</html>
