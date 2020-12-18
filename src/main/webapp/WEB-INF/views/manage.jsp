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
	
<script
	src="https://lib.sinaapp.com/js/jquery/2.0.2/jquery-2.0.2.min.js"></script>
    <link rel="shortcut icon" href="${APP_PATH}/static/img/favicon.ico"
	type="image/x-icon" />
	<script>
		/*
			时间格式化工具
			把Long类型的yyyy-MM-dd日期还原yyyy-MM-dd格式日期 
		*/
		function dateFormatUtil(longTypeDate){
			var dateTypeDate = "";
			var date = new Date();
			date.setTime(longTypeDate);
			dateTypeDate += date.getFullYear();   //年
			dateTypeDate += "-" + getMonth(date); //月 
			dateTypeDate += "-" + getDay(date);   //日
			return dateTypeDate;
		}
		
		//返回 01-12 的月份值 
		function getMonth(date){
			var month = "";
			month = date.getMonth() + 1; //getMonth()得到的月份是0-11
			if(month<10){
				month = "0" + month;
			}
			return month;
		}
		
		//返回01-30的日期
		function getDay(date){
			var day = "";
			day = date.getDate();
			if(day<10){
				day = "0" + day;
			}
			return day;
		}
	</script>
	
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
	margin: 5% 0% 0% 0%;
	
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
	
	<div class="container">	
	<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary" id="emp_add_modal_btn">更新</button>
				<button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="emps_table">
					<thead>
						<tr>
							<th>
								<input type="checkbox" id="check_all"/>
							</th>
							<th>#</th>
							<th>数据日期</th>
							<th>更新时间</th>							
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
				</table>
			</div>
		</div>

		<!-- 显示分页信息 -->
		<div class="row">
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">				
			</div>			
		</div>		
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

<script type="text/javascript">
	
		var totalRecord,currentPage;
		//1、页面加载完成以后，直接去发送ajax请求,要到分页数据
		
		$(function(){
			//去首页
			
			to_page(1);
			
		});
		
		function to_page(pn){
			$.ajax({
				url:"${APP_PATH}/record",
				data:"pn="+pn,
				type:"GET",
				success:function(result){
					//console.log(result);
					//1、解析并显示员工数据
					build_emps_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);
				}
			});
		}
		
		function build_emps_table(result){
			//清空table表格
			$("#emps_table tbody").empty();
			var emps = result.extend.pageInfo.list;
			$.each(emps,function(index,item){
				var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
				var idTd = $("<td></td>").append(item.id);
			
				var dailyDataDate = $("<td></td>").append( dateFormatUtil(item.date));			
				var updateDate = $("<td></td>").append(item.flag);
				/**
				<button class="">
									<span class="" aria-hidden="true"></span>
									编辑
								</button>
				*/
				var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil")).append("更新");
				//为编辑按钮添加一个自定义的属性，来表示当前员工id
				editBtn.attr("edit-id",item.empId);
				var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn")
								.append($("<span></span>").addClass("glyphicon glyphicon-trash")).append("删除");
				//为删除按钮添加一个自定义的属性来表示当前删除的员工id
				delBtn.attr("del-id",item.empId);
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				//var delBtn = 
				//append方法执行完成以后还是返回原来的元素
				$("<tr></tr>").append(checkBoxTd)
					.append(idTd)
					.append(dailyDataDate)
					.append(updateDate)				
					.append(btnTd)
					.appendTo("#emps_table tbody");
			});
		}
		//解析显示分页信息
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
					result.extend.pageInfo.pages+"页,总"+
					result.extend.pageInfo.total+"条记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(result){
			//page_nav_area
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页的事件
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum -1);
				});
			}
			
			
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum +1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			
			
			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("page-item active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
			
			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
			$("a").addClass("page-link");
		}
		
		//清空表单样式及内容
		function reset_form(ele){
			$(ele)[0].reset();
			//清空表单样式
			$(ele).find("*").removeClass("has-error has-success");
			$(ele).find(".help-block").text("");
		}
		
		//点击新增按钮弹出模态框。
		$("#emp_add_modal_btn").click(function(){
			//清除表单数据（表单完整重置（表单的数据，表单的样式））
			reset_form("#empAddModal form");
			//s$("")[0].reset();
			//发送ajax请求，查出部门信息，显示在下拉列表中
			getDepts("#empAddModal select");
			//弹出模态框
			$("#empAddModal").modal({
				backdrop:"static"
			});
		});
		
	
		
		
		function getEmp(id){
			$.ajax({
				url:"${APP_PATH}/emp/"+id,
				type:"GET",
				success:function(result){
					//console.log(result);
					var empData = result.extend.emp;
					$("#empName_update_static").text(empData.empName);
					$("#email_update_input").val(empData.email);
					$("#empUpdateModal input[name=gender]").val([empData.gender]);
					$("#empUpdateModal select").val([empData.dId]);
				}
			});
		}
		
		//点击更新，更新员工信息
		$("#emp_update_btn").click(function(){
			//验证邮箱是否合法
			//1、校验邮箱信息
			var email = $("#email_update_input").val();
			var regEmail = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			if(!regEmail.test(email)){
				show_validate_msg("#email_update_input", "error", "邮箱格式不正确");
				return false;
			}else{
				show_validate_msg("#email_update_input", "success", "");
			}
			
			//2、发送ajax请求保存更新的员工数据
			$.ajax({
				url:"${APP_PATH}/emp/"+$(this).attr("edit-id"),
				type:"PUT",
				data:$("#empUpdateModal form").serialize(),
				success:function(result){
					//alert(result.msg);
					//1、关闭对话框
					$("#empUpdateModal").modal("hide");
					//2、回到本页面
					to_page(currentPage);
				}
			});
		});
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//1、弹出是否确认删除对话框
			var empName = $(this).parents("tr").find("td:eq(2)").text();
			var empId = $(this).attr("del-id");
			//alert($(this).parents("tr").find("td:eq(1)").text());
			if(confirm("确认删除【"+empName+"】吗？")){
				//确认，发送ajax请求删除即可
				$.ajax({
					url:"${APP_PATH}/emp/"+empId,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到本页
						to_page(currentPage);
					}
				});
			}
		});
		
		//完成全选/全不选功能
		$("#check_all").click(function(){
			//attr获取checked是undefined;
			//我们这些dom原生的属性；attr获取自定义属性的值；
			//prop修改和读取dom原生属性的值
			$(".check_item").prop("checked",$(this).prop("checked"));
		});
		
		//check_item
		$(document).on("click",".check_item",function(){
			//判断当前选择中的元素是否5个
			var flag = $(".check_item:checked").length==$(".check_item").length;
			$("#check_all").prop("checked",flag);
		});
		
		//点击全部删除，就批量删除
		$("#emp_delete_all_btn").click(function(){
			//
			var empNames = "";
			var del_idstr = "";
			$.each($(".check_item:checked"),function(){
				//this
				empNames += $(this).parents("tr").find("td:eq(2)").text()+",";
				//组装员工id字符串
				del_idstr += $(this).parents("tr").find("td:eq(1)").text()+"-";
			});
			//去除empNames多余的,
			empNames = empNames.substring(0, empNames.length-1);
			//去除删除的id多余的-
			del_idstr = del_idstr.substring(0, del_idstr.length-1);
			if(confirm("确认删除【"+empNames+"】吗？")){
				//发送ajax请求删除
				$.ajax({
					url:"${APP_PATH}/manage/"+del_idstr,
					type:"DELETE",
					success:function(result){
						alert(result.msg);
						//回到当前页面
						to_page(currentPage);
					}
				});
			}
		});
	</script>
<style>
</style>
</body>
</html>