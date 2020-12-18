<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="generator"
	content="HTML Tidy for HTML5 for Windows version 5.2.0" />
<meta charset="UTF-8" />
<title>首页</title>
<%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
<%
   
    String userAccout = "未登录";
    if(session!=null&&session.getAttribute("userName")!=null){
    	userAccout = session.getAttribute("userName").toString(); 
    }   
    %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script
	src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<!-- 引入样式 -->
<link rel="stylesheet"
	href="https://unpkg.com/element-ui@2.13.2/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://unpkg.com/element-ui@2.13.2/lib/index.js"></script>
<script
	src="https://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>

<link rel="shortcut icon" href="${APP_PATH}/static/img/favicon.ico"
	type="image/x-icon" />
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
        	var date =  $("input")[0].value;
    		var productid =  $("input")[2].value;
    		var delivermonth =  $("input")[3].value;
        	$.ajax({
				url:"${APP_PATH}/holds",
				type:"GET",
				dataType: "json",
				data: "date="+date+"&"+"productid"+productid+"&"+"delivermonth"+delivermonth,
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
<body background="${APP_PATH}/static/img/getholds_background.jpg">
	<div id="app">

		<el-row type="flex" justify="end" style="margin: 20px 0px 0px 0px">
		<el-col :span="6">
		<div>
			<button id="reqbutton1" class="btn btn-success" onclick="login()">登录/注册</button>
			<button id="reqbutton2" class="btn btn-success" onclick="manage()">管理数据</button>
		</div>
		</el-col>
		</el-row>
		<el-row type="flex" justify="end"> <el-col :span="6">
		<p id="user_account"><%=userAccout%></p>
		</el-col> </el-row>
	
		<div id="form-div" align="center">
			<div>
				<p style="font-size: 30px; font-weight: bold;margin: 20px">持仓分析</p>
			</div>
			<form id="form1" style="margin:0px; display: inline;"
				onsubmit="return false" action="##" method="post">
				<el-row :gutter="20">
				<template>
					<el-col :span="3" :offset="5"><div class="block">						
						<el-date-picker v-model="value1" type="date" placeholder="选择日期"
							value-format="yyyyMMdd" :picker-options="pickerOptions">
						</el-date-picker>
					</div>
					</el-col>			
					<el-col :span="3"><el-select v-model="value2" filterable placeholder="请选择"
						id="comp_select1" @change="choose"> <el-option
						v-for="item in options" :key="item.value" :label="item.label"
						:value="item.value"> </el-option> </el-select></el-col>
					<el-col :span="3"><el-select v-model="value3" filterable placeholder="请选择"
						id="comp_select"> <el-option v-for="item in options2"
						:key="item.value" :label="item.label" :value="item.value">
					</el-option> </el-select></el-col>
					<el-col :span="3"><el-select v-model="value4" filterable placeholder="请选择"
						id="comp_select"> <el-option v-for="item in options2"
						:key="item.value" :label="item.label" :value="item.value">
					</el-option> </el-select></el-col>
				</template>
				<el-col :span="2"><input type="button" value="获取数据" onclick="getholds()">
				<input type="reset" value="重置"></el-col>
				</p>
				</el-row>
			</form>
		</div>
	</div>
</body>
<script>

  var Company = {
      data() {
        return {
          options: [{
            value: '选项1',
            label: '全部'
          }, {
            value: '选项2',
            label: '上交所'
          }, {
            value: '选项3',
            label: '大商所'
          }, {
            value: '选项4',
            label: '郑商所'
          }, {
            value: '选项5',
            label: '生意社'
          }],
          value3: '全部',
  		
        }
  	  
      },
  	
  	 methods: {
          // 调用方法：Vue.set( target, key, value )

          // target：要更改的数据源(可以是对象或者数组)

          // key：要更改的具体数据

          // value ：重新赋的值
          handClick: function(opts) {
              //Vue methods中的this 指向的是Vue的实例，这里可以直接在this中找到items
  			for(var i=0; i<opts.length;i++){
  			this.$set(this.options, i, opts[i]);
  			};
              
  			console.log(this.options[0].value);
  			
          },
      }
    }
  var Main = {
      data() {
        return {
          pickerOptions: {
            disabledDate(time) {
              return time.getTime() > Date.now();
            },         
          },
          value1: '',   
          value2: '',
        };
  	  
      },
  	
    };
  var Ctor = Vue.extend(Main).extend(Company);
  //new Ctor().$mount('#app')
  window.vm = new Ctor().$mount('#app');
  </script>
  
  
</html>
