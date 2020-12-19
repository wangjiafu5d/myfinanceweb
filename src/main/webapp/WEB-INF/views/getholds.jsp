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
if (session != null && session.getAttribute("userName") != null) {
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
        	//var date =  $("input")[0].value;
    		var productid =  $("input")[2].value;
    		var delivermonth =  $("input")[3].value;
        	$.ajax({
				url:"${APP_PATH}/holds",
				type:"GET",
				dataType: "json",
				data: "date="+window.choose_date+"&"+"productid="+window.choose_productid+"&"+"delivermonth="+delivermonth,
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
		</el-col> </el-row>
		<el-row type="flex" justify="end"> <el-col :span="6">
		<p id="user_account"><%=userAccout%></p>
		</el-col> </el-row>

		<div id="form-div" align="center">
			<div>
				<p style="font-size: 30px; font-weight: bold; margin: 20px">持仓分析</p>
			</div>
			<form id="form1" style="margin: 0px; display: inline;"
				onsubmit="return false" action="##" method="post">
				<el-row :gutter="20">
				<template>
					<el-col :span="3" :offset="5">
					<div class="block">
						<el-date-picker v-model="value1" type="date" placeholder="选择日期"  @change="get_delivermonth" 
							value-format="yyyy-MM-dd" :picker-options="pickerOptions">
						</el-date-picker>
					</div>
					</el-col>
					<el-col :span="3">
					<el-select v-model="value2" filterable placeholder="请选择"
						id="comp_select1" @change="choose_website"> <el-option
						v-for="item in options" :key="item.value" :label="item.label"
						:value="item.value"> </el-option> </el-select></el-col>
					<el-col :span="3">
					<el-select v-model="value3" filterable placeholder="请选择"
						id="comp_select2" @change="choose_product"> <el-option
						v-for="item in options2" :key="item.value" :label="item.label"
						:value="item.value"> </el-option> </el-select></el-col>
					<el-col :span="3">
					<el-select v-model="value4" filterable placeholder="请选择"
						id="comp_select3" @change="choose_delivermonth"> <el-option
						v-for="item in options3" :key="item.value" :label="item.label"
						:value="item.value"> </el-option> </el-select></el-col>
				</template>
				<el-col :span="2">
				<input class="btn btn-primary" type="button" value="获取数据"
					onclick="getholds()"> <input class="btn btn-primary"
					type="reset" value="重置"></el-col>
				</p>
				</el-row>
			</form>
		</div>
	</div>
</body>
<script>
var choose_date = '';
var choose_productid = '';
  var Company = {
      data() {
        return {
          options: [{
            value: '上交所',
            label: '上交所'
          }, {
            value: '大商所',
            label: '大商所'
          }, {
            value: '郑商所',
            label: '郑商所'
          }],
          value2: '上交所',  		
        }      
  	  
      },
  	
  	 methods: {
          // 调用方法：Vue.set( target, key, value )

          // target：要更改的数据源(可以是对象或者数组)

          // key：要更改的具体数据

          // value ：重新赋的值
          choose_website: function(opts) {
              //Vue methods中的this 指向的是Vue的实例，这里可以直接在this中找到items
              
              console.log(opts);
              if(opts=='上交所'){
              	for(var i=0; i<shef.length;i++){
              		console.log(i);
  	    			this.$set(this.options2, i, shef[i]);
  	    			};
              }
              if(opts=='大商所'){
            	  for(var i=0; i<dce.length;i++){
                		console.log(i);
    	    			this.$set(this.options2, i, dce[i]);
    	    			};
              }
              if(opts=='郑商所'){
            	  for(var i=0; i<czce.length;i++){
                		//console.log(czce[i]);
    	    			this.$set(this.options2, i, czce[i]);
    	    			};
              }
  			
          },
      }
    };
  var Main = {
      data() {
        return {
          pickerOptions: {
            disabledDate(time) {
              return time.getTime() > Date.now();
            },         
          },
          value1: '',  
        };
      },
        methods: {
        	get_delivermonth: function(date){
        		console.log(date);
        		choose_date = date;   
        		window.choose_date = date;
        		if(choose_productid!=""){
        			
        		var website =  $("input")[2].value;
                $.ajax({
    				url:"${APP_PATH}/delivermonth",
    				type:"GET",
    				dataType: "json",
    				data: "date="+choose_date+"&"+"website="+website+"&"+"productid="+choose_productid,
    				success:function(response){	    					
    					response.sort(function(a, b){return a - b});
    					 for(var i=0; i<response.length;i++){	    						 
    							//this.$set(this.options3, i, response[i]);
    							var item = {};
    							item['value'] = response[i];
    							item['label'] = response[i];
    							console.log(item);
    							window.vm.$set(window.vm.options3, i, item);
    							};
    					
    				}
    				});
        		}
        	}
        }
  	
    };
  var product = {
	      data() {
	          return {
	            options2: [{
	            }],	          		
	    	  value3: '',
	          }      
	        },
	        methods: {
	        	choose_product: function(productid) {	              
	               // console.log(opts); 
	            	  choose_productid = productid;
	            	  window.choose_productid = productid;
	              if(choose_date!=''){
	               var website =  $("input")[2].value;
	                $.ajax({
	    				url:"${APP_PATH}/delivermonth",
	    				type:"GET",
	    				dataType: "json",
	    				data: "date="+choose_date+"&"+"website="+website+"&"+"productid="+choose_productid,
	    				success:function(response){	    					
	    					response.sort(function(a, b){return a - b});
	    					 for(var i=0; i<response.length;i++){	    						 
	    							//this.$set(this.options3, i, response[i]);
	    							var item = {};
	    							item['value'] = response[i];
	    							item['label'] = response[i];
	    							console.log(item);
	    							window.vm.$set(window.vm.options3, i, item);
	    							};
	    					
	    				}
	    				});
	              }
	    			
	            },
	        }
  	};
  var deliver_month = {
	      data() {
	          return {
	            options3: [{
	            }],	          		
	    	  value4: '',
	          }      
	        },
  };
  var Ctor = Vue.extend(Main).extend(Company).extend(product).extend(deliver_month);
  //new Ctor().$mount('#app')
  window.vm = new Ctor().$mount('#app');
  
  
  var shef = 
      [{ 
    	  value: 'ss', 
    	  label: '不锈钢'
    	 },{ 
    	  value: 'ru', 
    	  label: '天然橡胶'
    	 },{ 
    	  value: 'nr', 
    	  label: '20号胶'
    	 },{ 
    	  value: 'ag', 
    	  label: '白银'
    	 },{ 
    	  value: 'lu', 
    	  label: '低硫燃料油'
    	 },{ 
    	  value: 'al', 
    	  label: '铝'
    	 },{ 
    	  value: 'fu', 
    	  label: '燃料油'
    	 },{ 
    	  value: 'rb', 
    	  label: '螺纹钢'
    	 },{ 
    	  value: 'sc', 
    	  label: '原油'
    	 },{ 
    	  value: 'cu', 
    	  label: '铜'
    	 },{ 
    	  value: 'pb', 
    	  label: '铅'
    	 },{ 
    	  value: 'bu', 
    	  label: '石油沥青'
    	 },{ 
    	  value: 'zn', 
    	  label: '锌'
    	 },{ 
    	  value: 'au', 
    	  label: '黄金'
    	 },{ 
    	  value: 'ni', 
    	  label: '镍'
    	 },{ 
    	  value: 'sn', 
    	  label: '锡'
    	 },{ 
    	  value: 'wr', 
    	  label: '线材'
    	 },{ 
    	  value: 'hc', 
    	  label: '热轧卷板'
    	 },{ 
    	  value: 'sp', 
    	  label: '纸浆'
    	 }];
  var dce = [
	  { 
		  value: 'rr', 
		  label: '粳米'
		 },{ 
		  value: 'bb', 
		  label: '胶合板'
		 },{ 
		  value: 'pp', 
		  label: '聚丙烯'
		 },{ 
		  value: 'a', 
		  label: '豆一'
		 },{ 
		  value: 'b', 
		  label: '豆二'
		 },{ 
		  value: 'eg', 
		  label: '乙二醇'
		 },{ 
		  value: 'c', 
		  label: '玉米'
		 },{ 
		  value: 'jm', 
		  label: '焦煤'
		 },{ 
		  value: 'i', 
		  label: '铁矿石'
		 },{ 
		  value: 'j', 
		  label: '焦炭'
		 },{ 
		  value: 'l', 
		  label: '聚乙烯'
		 },{ 
		  value: 'm', 
		  label: '豆粕'
		 },{ 
		  value: 'cs', 
		  label: '玉米淀粉'
		 },{ 
		  value: 'p', 
		  label: '棕榈油'
		 },{ 
		  value: 'v', 
		  label: '聚氯乙烯'
		 },{ 
		  value: 'pg', 
		  label: '液化石油气'
		 },{ 
		  value: 'y', 
		  label: '豆油'
		 },{ 
		  value: 'jd', 
		  label: '鸡蛋'
		 },{ 
		  value: 'fb', 
		  label: '纤维板'
		 },{ 
		  value: 'eb', 
		  label: '苯乙烯'
		 }
  ];
  var czce = [
	  { 
		  value: 'fg', 
		  label: '玻璃'
		 },{ 
		  value: 'rs', 
		  label: '油菜籽'
		 },{ 
		  value: 'lr', 
		  label: '晚籼'
		 },{ 
		  value: 'jr', 
		  label: '粳稻'
		 },{ 
		  value: 'sa', 
		  label: '纯碱'
		 },{ 
		  value: 'wh', 
		  label: '强麦'
		 },{ 
		  value: 'sf', 
		  label: '硅铁'
		 },{ 
		  value: 'ma', 
		  label: '甲醇'
		 },{ 
		  value: 'me', 
		  label: '甲醇'
		 },{ 
		  value: 'oi', 
		  label: '菜油'
		 },{ 
		  value: 'sm', 
		  label: '锰硅'
		 },{ 
		  value: 'ws', 
		  label: '强麦'
		 },{ 
		  value: 'wt', 
		  label: '硬麦'
		 },{ 
		  value: 'ur', 
		  label: '尿素'
		 },{ 
		  value: 'sr', 
		  label: '白糖'
		 },{ 
		  value: 'cf', 
		  label: '棉花'
		 },{ 
		  value: 'cj', 
		  label: '红枣'
		 },{ 
		  value: 'zc', 
		  label: '动力煤'
		 },{ 
		  value: 'ta', 
		  label: 'pta'
		 },{ 
		  value: 'er', 
		  label: '早籼'
		 },{ 
		  value: 'ap', 
		  label: '苹果'
		 },{ 
		  value: 'cy', 
		  label: '棉纱'
		 },{ 
		  value: 'ri', 
		  label: '早籼'
		 },{ 
		  value: 'rm', 
		  label: '菜籽粕'
		 },{ 
		  value: 'ro', 
		  label: '菜油'
		 },{ 
		  value: 'pm', 
		  label: '普麦'
		 }
  ];
  for(var i=0; i<shef.length;i++){
		window.vm.$set(window.vm.options2, i, shef[i]);
		
		};
</script>


</html>
