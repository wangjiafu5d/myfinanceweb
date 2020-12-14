<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="generator" content="HTML Tidy for HTML5 for Windows version 5.2.0" />
    <meta charset="UTF-8" />
    <title>首页</title><%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script>
	$(document).ready(function () {
		$("#reqbutton").click(function(){
			$.ajax({
				url:"${APP_PATH}/holds?date=2019-01-09&goods=hc&comp=%E6%B0%B8%E5%AE%89%E6%9C%9F%E8%B4%A7",
				type:"GET",
				dataType: "json",
				success:function(response){
					console.log(response[0]);				
					
					$("p").text(JSON.stringify(response));
				}
				});
		});
	});
	</script>
	<script>
        function getholds() {
        	$.ajax({
				url:"${APP_PATH}/holds",
				type:"GET",
				dataType: "json",
				data: $('#form1').serialize(),
				success:function(response){
					console.log(response[0]);				
					
					$("#p1").text(JSON.stringify(response));
				}
				});
        }
        function login(){
        	window.location.replace("login");
        }
        function manage(){
        	window.location.replace("manage");
        }
    </script>
  </head>
  <body>
    <button id="reqbutton1" class="btn btn-success" onclick="login()">登录</button>
    <button id="reqbutton2" class="btn btn-success" onclick="manage()">管理数据</button>
    <p id="p1">数据</p>
    <div id="form-div">
    <form id="form1" style="margin:0px;display:inline;" onsubmit="return false" action="##" method="post">
       <p style="margin:50px;display:inline;">日期：<input name="date" type="text" id="txtUserName" tabindex="1" size="15" value=""/></p>
       <p style="margin:50px;display:inline;">商品代码：<input name="goods" type="text" id="TextBox2" tabindex="2" size="15" value=""/></p>
         <p style="margin:50px;display:inline;">期货公司：<input name="comp" type="text" id="TextBox2" tabindex="3" size="15" value=""/></p>
        <p style="margin:50px;display:inline;"><input type="button" value="获取数据" onclick="getholds()">&nbsp;<input type="reset" value="重置"></p>
    </form>
</div>
  </body>
</html>
