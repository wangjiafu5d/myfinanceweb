<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
<meta name="generator"
	content="HTML Tidy for HTML5 for Windows version 5.2.0" />
<meta charset="utf-8" />
<title>MyFinaceWeb</title>
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
function login() {
	var isChecked = $(".checkbox input").prop("checked");
	var rememberMe = "";
	if(!isChecked){
		rememberMe = "&rememberMe=no";
	}
	$.ajax({
		url:"${APP_PATH}/loginContr",
		type:"GET",		
		data: $('#form1').serialize()+rememberMe,
		success:function(response){
			console.log(response);
			if(response=="login"){
				reset();
				alert("User Name or Password is wrong")
			}else{
			window.location.replace(response);				
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
	margin: 5% 40% 40% 40%;
	width: 20%;
}

button {
	margin: 0 10px 0 0;
}
</style>
</head>
<body>
	<form id="form1">
		<div class="form-group">
			<label for="exampleInputEmail1">User Name</label> <input type="text"
				class="form-control" name="userName" placeholder="User Name">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" name="password"
				placeholder="Password">
		</div>
		<div class="checkbox">
			<label> 
			<input type="checkbox" checked="true" name="rememberMe" value="yes">			
			 Keep me signed in five days.
			</label>
		</div>
		<button type="button" class="btn btn-info" onclick="reset()">Cancle</button>
		<button type="button" class="btn btn-primary" onclick="login()">Submit</button>
	</form>
	<a href="${APP_PATH}/register">sign up</a>
</body>
</html>
