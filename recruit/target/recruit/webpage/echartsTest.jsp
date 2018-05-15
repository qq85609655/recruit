<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>echarts</title>
<jsp:include page="/webpage/header.jsp"></jsp:include>
<style>
</style>
<script type="text/javascript" src="${webRoot}/resources/js/echarts/echarts.js"></script>
</head>
<body>
  <div id="main" style="height:400px;"></div>

  <jsp:include page="/webpage/footer.jsp"></jsp:include>
  
  <script type="text/javascript">
    require.config({
        paths: {
            echarts: basePath + '/resources/js/echarts'
        }
    });
    
    require(
        [
            'echarts',
            'echarts/chart/line',   // 按需加载所需图表，如需动态类型切换功能，别忘了同时加载相应图表
            'echarts/chart/bar'
        ],
        function (ec) {
            var myChart = ec.init(document.getElementById('main'));
            var option = {		//动态发起请求加载图表时,根据返回数据动态生成option
                tooltip : {
                  trigger: 'axis'
              },
              toolbox: {
                  show : true,
                  feature : {
                      mark : {show: true},
                      dataView : {show: true, readOnly: false},
                      magicType: {show: true, type: ['line', 'bar']},
                      restore : {show: true},
                      saveAsImage : {show: true}
                  }
              },
              calculable : true,
              legend: {
                  data:['计划','实际','达成率']
              },
              xAxis : [
                  {
                      type : 'category',
                      data : ['北京','哈尔滨','广州','武汉','成都','合肥','重庆','西安','站点1','站点2','站点3','站点4']
                  }
              ],
              yAxis : [
                  {
                      type : 'value',
                      name : '人数',
                      axisLabel : {
                          formatter: '{value} 人'
                      }
                  },
                  {
                      type : 'value',
                      show : false,
                      name : '百分数',
                      axisLabel : {
                          formatter: '{value} %'
                      }
                  }
              ],
              series : [

                  {
                      name:'计划',
                      type:'bar',
                      data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
                  },
                  {
                      name:'实际',
                      type:'bar',
                      data:[2.6, 5.9, 9.0, 26.4, 28.7, 70.7, 175.6, 182.2, 48.7, 18.8, 6.0, 2.3]
                  },
                  {
                      name:'达成率',
                      type:'line',
                      yAxisIndex: 1,
                      itemStyle: {
                        normal: {
                            color: 'orange',
                            barBorderColor: 'tomato',
                            barBorderWidth: 3,
                            barBorderRadius:0,
                            label : {
                                show: true, 
                                position: 'top',
                                formatter: function (params) {
                                    return params.value + '%';
                                },
                                textStyle: {
                                    color: 'tomato'
                                }
                            }
                        }
                      },
                      data:[2.0, 2.2, 3.3, 4.5, 6.3, 10.2, 20.3, 23.4, 23.0, 16.5, 12.0, 6.2]
                  }
              ]
          };
          myChart.setOption(option);
        }
    );
    
  </script>
  
</body>
</html>