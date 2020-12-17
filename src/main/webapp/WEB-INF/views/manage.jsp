<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 引入样式 -->
<link rel="stylesheet"
	href="https://unpkg.com/element-ui@2.13.2/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<script src="https://unpkg.com/element-ui@2.13.2/lib/index.js"></script>
<script
	src="https://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>
<%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="shortcut icon" href="${APP_PATH}/static/img/favicon.ico"
	type="image/x-icon" />
<script>
function checkdate(d1,d2){
	let date1 = new Date(Date.parse(d1))
	let date2 = new Date(Date.parse(d2))
	return date1<=date2;
}
        function insert() {
		var start_date =  $("input")[0].value;
		var end_date =  $("input")[1].value;
		var website =  $("input")[2].value;
		if(checkdate(start_date,end_date)){
        	$.ajax({
				url:"${APP_PATH}/manage",
				type:"POST",
				dataType: "json",
				data: "start_date="+start_date+"&&end_date="+end_date+"&&website="+website,
				success:function(response){
					console.log(response);
					alert("操作成功");
				}
				});
        }
        else{
        	alert("时间范围错误");
        }
        }
        function update1() {
    		var start_date =  $("input")[0].value;
    		var end_date =  $("input")[1].value;
    		var website =  $("input")[2].value;
    		if(checkdate(start_date,end_date)){
            	$.ajax({
    				url:"${APP_PATH}/manage",
    				type:"POST",
    				dataType: "json",
    				data: "_method=PUT"+"&&start_date="+start_date+"&&end_date="+end_date+"&&website="+website,
    				success:function(response){
    					console.log(response);	
    					alert("操作成功");
    				}
    				});
            }
    		else{
            	alert("时间范围错误");
            }
        }
        function delete1() {
    		var start_date =  $("input")[0].value;
    		var end_date =  $("input")[1].value;
    		var website =  $("input")[2].value;    		
    		if(checkdate(start_date,end_date)){
            	$.ajax({
    				url:"${APP_PATH}/manage",
    				type:"POST",
    				dataType: "json",
    				data: "_method=DELETE"+"&&start_date="+start_date+"&&end_date="+end_date+"&&website="+website,
    				success:function(response){
    					console.log(response);	
    					alert("操作成功");
    				}
    				});
            	
            }else{
            	alert("时间范围错误");
            }
    		}
       
</script>
<style>
body {
	margin: 5% 10% 0% 10%;
	
}
</style>
</head>
<body background="${APP_PATH}/static/img/manage_background.jpg">
	<div id="app" align="center">	
		<p>数据管理</p>
		<el-row> <el-col :span="24">
		<template>
			<div class="block">
				<span class="demonstration">起始日期</span>
				<el-date-picker v-model="value1" type="date" align="center"
					placeholder="选择日期" value-format="yyyyMMdd"
					:picker-options="pickerOptions"> </el-date-picker>
			</div>
			<div class="block">
				<span class="demonstration">结束日期</span>
				<el-date-picker v-model="value2" type="date" align="center"
					placeholder="选择日期" value-format="yyyyMMdd"
					:picker-options="pickerOptions"> </el-date-picker>
			</div>
		</template>
		</el-col> <el-col :span="24">
		<template>
			<span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</span>
			<el-select v-model="value3" filterable placeholder="请选择"
				id="comp_select"> <el-option v-for="item in options"
				:key="item.value" :label="item.label" :value="item.value">
			</el-option> </el-select>
		</template>
		</el-col> </el-row>
		<el-row> <el-col :span="24">
		<div>
			<el-button type="primary" onclick="insert()">新增</el-button>
			<el-button type="primary" onclick="update1()">覆盖</el-button>
			<el-button type="primary" onclick="delete1()">删除</el-button>
		</div>
		</el-col> </el-row>

	</div>



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
	<script>
function sub(){
	console.log("submit");
	console.log(Date.now());
	console.log($("input")[0].value);
	console.log($("input")[1].value);
	console.log($("input")[2].value);
	var new_comp = 
        [{
          value: '选1',
          label: '黄金'
        }, {
          value: '选项2',
          label: '双皮'
        }, {
          value: '选项3',
          label: '蚵仔'
        }, {
          value: '选项4',
          label: '龙须'
        }, {
          value: '选项5',
          label: '北京'
        }];   
    
  	console.log(new_comp[0].label);
	console.log(window.vm.options[0].label);
	//window.vm.handClick(new_comp);
		for(var i=0; i<new_comp.length;i++){
			window.vm.$set(window.vm.options, i, new_comp[i]);
			
			};
            
			
    
}

</script>
</body>
</html>