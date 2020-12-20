<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>按时间段分析</title>
    <!-- 引入 echarts.js -->
    <script src="https://cdn.staticfile.org/echarts/4.3.0/echarts.min.js"></script>
    
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
    <%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
   <link rel="shortcut icon" href="${APP_PATH}/static/img/favicon.ico"
	type="image/x-icon" />
	
</head>
<body>
<div id="app">

		<el-row type="flex" justify="end" style="margin: 20px 0px 0px 0px">
		<el-col :span="6">		
		</el-col> </el-row>		

		<div id="form-div" align="center">			
			<form id="form1" style="margin: 10px; display: inline;"
				onsubmit="return false" action="##" method="post">
				<el-row :gutter="20">
				<template>
					<el-col :span="3" :offset="2">
					<div class="block">
						<el-date-picker v-model="value1" type="date" placeholder="开始日期"  @change="get_delivermonth" 
							value-format="yyyy-MM-dd" :picker-options="pickerOptions">
						</el-date-picker>
					</div>
					</el-col>
					<el-col :span="3"><div class="block">
						<el-date-picker v-model="value5" type="date" placeholder="开始日期"  @change="get_end_date" 
							value-format="yyyy-MM-dd" :picker-options="pickerOptions2">
						</el-date-picker>
					</div>
					</el-col>
					<el-col :span="3">
					<el-select v-model="value2" filterable placeholder="交易所"
						id="end_date" @change="choose_website"> <el-option
						v-for="item in options" :key="item.value" :label="item.label"
						:value="item.value"> </el-option> </el-select></el-col>
							
					<el-col :span="3">
					<el-select v-model="value3" filterable placeholder="品种"
						id="comp_select2" @change="choose_product"> <el-option
						v-for="item in options2" :key="item.value" :label="item.label"
						:value="item.value"> </el-option> </el-select></el-col>
					<el-col :span="3">
					<el-select v-model="value4" filterable placeholder="交割月"
						id="comp_select3" @change="choose_delivermonth"> <el-option
						v-for="item in options3" :key="item.value" :label="item.label"
						:value="item.value"> </el-option> </el-select></el-col>
				</template>		
				<el-col :span="2">
				<input class="btn btn-primary" type="button" value="获取数据"
					onclick="analyse()"> <input class="btn btn-primary" 
					type="reset" value="重置"> </el-col>						
				</el-row>
			</form>
		</div>		
	</div>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1500px;height:800px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        window.myChart = myChart;
 const colorList = ["#9E87FF", '#73DDFF', '#fe9a8b', '#F56948', '#9E87FF']
        // 指定图表的配置项和数据
  var option = {
    backgroundColor: '#fff',
    title: {
        text: '总持仓分析',
        textStyle: {
            fontSize: 12,
            fontWeight: 400
        },
        left: 'center',
        top: '5%'
    },
    legend: {
        icon: 'circle',
        top: '5%',
        right: '5%',
        itemWidth: 6,
        itemGap: 20,
        textStyle: {
            color: '#556677'
        }
    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            label: {
                show: true,
                backgroundColor: '#fff',
                color: '#556677',
                borderColor: 'rgba(0,0,0,0)',
                shadowColor: 'rgba(0,0,0,0)',
                shadowOffsetY: 0
            },
            lineStyle: {
                width: 0
            }
        },
        backgroundColor: '#fff',
        textStyle: {
            color: '#5c6c7c'
        },
        padding: [10, 10],
        extraCssText: 'box-shadow: 1px 0 2px 0 rgba(163,163,163,0.5)'
    },
    grid: {
        top: '15%'
    },
    xAxis: [{
        type: 'category',
        data: [],
        axisLine: {
            lineStyle: {
                color: '#DCE2E8'
            }
        },
        axisTick: {
            show: false
        },
        axisLabel: {
            interval: 0,
            textStyle: {
                color: '#556677'
            },
            // 默认x轴字体大小
            fontSize: 12,
            // margin:文字到x轴的距离
            margin: 15
        },
        axisPointer: {
            label: {
                // padding: [11, 5, 7],
                padding: [0, 0, 10, 0],
                /*
    除了padding[0]建议必须是0之外，其他三项可随意设置
    
    和CSSpadding相同，[上，右，下，左]
    
    如果需要下边线超出文字，设左右padding即可，注：左右padding最好相同
    
    padding[2]的10:
    
    10 = 文字距下边线的距离 + 下边线的宽度
                
    如：UI图中文字距下边线距离为7 下边线宽度为2
    
    则padding: [0, 0, 9, 0]
                
                */
                // 这里的margin和axisLabel的margin要一致!
                margin: 15,
                // 移入时的字体大小
                fontSize: 12,
                backgroundColor: {
                    type: 'linear',
                    x: 0,
                    y: 0,
                    x2: 0,
                    y2: 1,
                    colorStops: [{
                        offset: 0,
                        color: '#fff' // 0% 处的颜色
                    }, {
                        // offset: 0.9,
                        offset: 0.86,
                        /*
0.86 = （文字 + 文字距下边线的距离）/（文字 + 文字距下边线的距离 + 下边线的宽度）
                        
                        */
                        color: '#fff' // 0% 处的颜色
                    }, {
                        offset: 0.86,
                        color: '#33c0cd' // 0% 处的颜色
                    }, {
                        offset: 1,
                        color: '#33c0cd' // 100% 处的颜色
                    }],
                    global: false // 缺省为 false
                }
            }
        },
        boundaryGap: false
    }],
    yAxis: [{
        type: 'value',
        axisTick: {
            show: false
        },
        axisLine: {
            show: true,
            lineStyle: {
                color: '#DCE2E8'
            }
        },
        axisLabel: {
            textStyle: {
                color: '#556677'
            }
        },
        splitLine: {
            show: false
        }
    }, {
        type: 'value',
        position: 'right',
        axisTick: {
            show: false
        },
        axisLabel: {
            textStyle: {
                color: '#556677'
            },
            formatter: '{value}'
        },
        axisLine: {
            show: true,
            lineStyle: {
                color: '#DCE2E8'
            }
        },
        splitLine: {
            show: false
        }
    }],
    series: [{
            name: '成交量',
            type: 'line',
            data: [],
            symbolSize: 1,
            symbol: 'circle',
            smooth: true,
            yAxisIndex: 1,
            showSymbol: false,
            lineStyle: {
                width: 5,
                color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                        offset: 0,
                        color: '#9effff'
                    },
                    {
                        offset: 1,
                        color: '#9E87FF'
                    }
                ]),
                shadowColor: 'rgba(158,135,255, 0.3)',
                shadowBlur: 10,
                shadowOffsetY: 20
            },
            itemStyle: {
                normal: {
                    color: colorList[0],
                    borderColor: colorList[0]
                }
            }
        }, {
            name: '多仓',
            type: 'line',
            data: [],
            symbolSize: 1,
            symbol: 'circle',
            smooth: true,
            yAxisIndex: 0,
            showSymbol: false,
            lineStyle: {
                width: 5,
                color: new echarts.graphic.LinearGradient(1, 1, 0, 0, [{
                        offset: 0,
                        color: '#73DD39'
                    },
                    {
                        offset: 1,
                        color: '#73DDFF'
                    }
                ]),
                shadowColor: 'rgba(115,221,255, 0.3)',
                shadowBlur: 10,
                shadowOffsetY: 20
            },
            itemStyle: {
                normal: {
                    color: colorList[1],
                    borderColor: colorList[1]
                }
            }
        },
        {
            name: '空仓',
            type: 'line',
            data: [],
            symbolSize: 1,
            yAxisIndex: 0,
            symbol: 'circle',
            smooth: true,
            showSymbol: false,
            lineStyle: {
                width: 5,
                color: new echarts.graphic.LinearGradient(0, 0, 1, 0, [{
                        offset: 0,
                        color: '#fe9a'
                    },
                    {
                        offset: 1,
                        color: '#fe9a8b'
                    }
                ]),
                shadowColor: 'rgba(254,154,139, 0.3)',
                shadowBlur: 10,
                shadowOffsetY: 20
            },
            itemStyle: {
                normal: {
                    color: colorList[2],
                    borderColor: colorList[2]
                }
            }
        }
    ]

            };
 
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
    </script>
    <script>
    function refresh_echart(data){
        //刷新数据
         var option = window.myChart.getOption();
         option.xAxis[0].data = data[0];
         option.series[0].data = data[1];
         option.series[1].data = data[2];
         option.series[2].data = data[3];
         myChart.setOption(option);    
   }
    </script>
    <script>
var choose_date = '';
var end_date = '';
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
        			window.vm.options3 = {};
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
    							//console.log(item);
    							window.vm.$set(window.vm.options3, i, item);
    							};
    					
    				}
    				});
        		}
        	}
        }
  	
    };
  var Main2 = {
	      data() {
	        return {
	          pickerOptions2: {
	            disabledDate(time) {
	              return time.getTime() > Date.now();
	            },         
	          },
	          value5: '',  
	        };
	      },
	        methods: {
	        	get_end_date: function(date){
	        		
	        		window.end_date = date;
	        		
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
	            	  
	            	window.vm.options3 = {};
	            	  //$('.comp_select3')[0].reset();
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
	        methods: {
	        	choose_delivermonth: function(delivermonth) {
	            	  window.delivermonth = delivermonth;             
	    			
	            },
	        }
  };
 
  var Ctor = Vue.extend(Main).extend(Main2).extend(Company).extend(product).extend(deliver_month);
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
<script>
function checkdate(d1,d2){
	let date1 = new Date(Date.parse(d1))
	let date2 = new Date(Date.parse(d2))
	return date1<=date2;
}

function analyse(){
	if(checkdate(window.choose_date,window.end_date)){
		$.ajax({
			url:"${APP_PATH}/analyse",
			type:"GET",
			dataType: "json",
			data: "start_date="+window.choose_date+"&end_date="+window.end_date+"&productid="+window.choose_productid+"&delivermonth="+ window.delivermonth,
			success:function(response){
				console.log(response);
				refresh_echart(response);
			}
			});
    }
    else{
    	alert("时间范围错误");
    }
	
}
</script>
</body>
</html>