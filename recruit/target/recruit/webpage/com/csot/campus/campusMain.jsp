<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp" %>
  <link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css"/>
  <title>校招首页</title>
  <style type="text/css">
    .tableTitle {
      background-color: #3299FF;
      color: white;
      heigth: 30px;
      font-weight: bold;
      font-size: 18px;
      line-height: 45px;
      font-family: 微软雅黑;
    }

    .border-right {
      border-right: 1px solid #8D8D8D;
      font-size: 18px;
    }
  </style>
  <script type="text/javascript" src="${webRoot}/resources/js/echarts/echarts.js"></script>
</head>
<body onload="removeLoad();">
<jsp:include page="/webpage/header.jsp"></jsp:include>
<div class="co">
  <div class="co-right">
    <div style="margin-left: 3%; margin-top: 30px;">
      <div style="float: right; margin-right:20px">
        <table>
          <tr>
            <th style="font-size:11px">&nbsp;数据更新年份：</th>
            <td><input class="mini-combobox" style="width: 80px;" textField="yearth" id="yearth" value="${cre.yearth}"
                       valueField="yearth" url="/recruit/campusTaskController/datagrid4Yearth"
                       showNullItem="false" allowInput="true" onitemclick="loadByYearth()"/></td>
          </tr>
        </table>
      </div>
      <h1 id="h1" style="font-size: 18px; font-family: 微软雅黑"></h1>
      <HR color="black" SIZE=10>
    </div>

    <div style="width:100%">
      <table style="width:94%;margin-left:3%;margin-right:3%;margin-top:20px">
        <tr>
          <td width="40%" class="tableTitle">&nbsp;&nbsp;整体达成情况展示</td>
          <td width="5%"></td>
          <td width="54%" class="tableTitle">&nbsp;&nbsp;具体达成情况展示</td>
        </tr>

        <tr>
          <td>
            <table width="100%" style="text-align:center;margin-top:20px; font-size: 18px; font-family: 微软雅黑">
              <tr>
                <td>${cre.achievementSum}</td>
                <td style="line-height:85px;"
                    class="border-right">${cre.trilTaskSum}</td>
                <td><a id="task" href="" target="_blank">${cre.taskSum}</a></td>
                <td><a id="offer" href="" target="_blank">${cre.offerSum}</a></td>
                <td><a id="tril" href="" target="_blank">${cre.trilateralSum}</a></td>
              </tr>
              <tr>
                <td title="offer/初版任务">offer率</td>
                <td heigth="30px" class="border-right" title="三方/初版任务">三方回收率</td>
                <td>招聘计划</td>
                <td>已发offer</td>
                <td>收到三方</td>
              </tr>
            </table>
          </td>
          <td width="5%"></td>
          <td>
            <table width="100%" style="text-align:center; font-size: 18px; font-family: 微软雅黑">
              <tr>
                <td width="50%">
                  <table width="100%" style="text-align:center;margin-top:20px">
                    <tr id="tr1">
                    </tr>
                    <tr id="tr2">
                    </tr>
                  </table>
                </td>
                <td>
                  <table width="100%" style="text-align:center;margin-top:20px">
                    <tr>
                      <td height="85px">${cre.achievementBa}</td>
                      <td>${cre.achievementMa}</td>
                      <td>${cre.achievementDo}</td>
                    </tr>
                    <tr>
                      <td height="30px">本科</td>
                      <td>硕士</td>
                      <td>博士</td>
                    </tr>
                  </table>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
    </div>
    <div id="echart1" style="width:100%; height:400px; margin-top:40px">
    </div>
  </div>
</div>
<jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script>
    mini.parse();
    var yearthValue = mini.get("yearth").getValue();
    if ("" == yearthValue) {
      mini.get("yearth").select(0);
      yearthValue = mini.get("yearth").getValue();
    }
    var yearth = encodeURI(encodeURI(yearthValue));
    // 初始化
    document.getElementById("task").href="/recruit/campusTaskFirstController/list?yearth=" + yearth;
    document.getElementById("offer").href="/recruit/campusStudentController/list?yearth=" + yearth + "&type=offer";
    document.getElementById("tril").href="/recruit/campusStudentController/list?yearth=" + yearth + "&type=tril";
    $("#h1").html(yearthValue + "校园招聘看板");

    $.ajax({
        url: "/recruit/campusReportController/getJobFamilyAchievement?yearth=" + yearth,
        dataType: 'json',
        contentType: 'application/json',
        type: "post",
        success: function (data) {
            var html1 = "";
            var html2 = "";
            for (var i = 0; i < data.length; i++) {
                var css = i == data.length - 1 ? " class='border-right'" : "";
                html1 += "<td height='85px'" + css + ">" + data[i].achievement + "</td>";
                html2 += "<td height='30px'" + css + ">" + data[i].jobFamily + "</td>";
            }
            $("#tr1").html(html1);
            $("#tr2").html(html2);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
        }
    });
    buildChart();

    function loadByYearth() {
      var y = mini.get("yearth").getValue();
      y = encodeURI(encodeURI(y));
      // 超链接参数更新
      document.getElementById("task").href="/recruit/campusTaskFirstController/list?yearth=" + y;
      document.getElementById("offer").href="/recruit/campusStudentController/list?yearth=" + y + "&type=offer";
      document.getElementById("tril").href="/recruit/campusStudentController/list?yearth=" + y + "&type=tril";
      window.location.href = '/recruit/campusReportController/campusMain?yearth=' + y;
    }

    function buildChart() {
        $.ajax({
            url: "/recruit/campusReportController/getChartData?yearth=" + yearth,
            dataType: 'json',
            contentType: 'application/json',
            type: "post",
            success: function (data) {
                var siteArr = new Array();
                var taskArr = new Array();
                var offerArr = new Array();
                var achievementArr = new Array();
                for (var i = 0; i < data.length; i++) {
                    siteArr[i] = data[i].siteName;
                    taskArr[i] = data[i].taskSum;
                    offerArr[i] = data[i].offerSum;
                    achievementArr[i] = data[i].achievementPercentSum;
                }
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
                        var myChart = ec.init(document.getElementById('echart1'));
                        var option = {		//动态发起请求加载图表时,根据返回数据动态生成option
                            tooltip: {
                                trigger: 'axis'
                            },
                            toolbox: {
                                show: true,
                                feature: {
                                    mark: {show: false},
                                    dataView: {show: false, readOnly: false},
                                    magicType: {show: false, type: ['line', 'bar']},
                                    restore: {show: false},
                                    saveAsImage: {show: false}
                                }
                            },
                            calculable: true,
                            legend: {
                                data: ['计划', '实际', '达成率']
                            },
                            xAxis: [
                                {
                                    type: 'category',
                                    data: siteArr
                                }
                            ],
                            yAxis: [
                                {
                                    type: 'value',
                                    name: '人数',
                                    axisLabel: {
                                        formatter: '{value} 个'
                                    }
                                },
                                {
                                    type: 'value',
                                    name: '百分数',
                                    show: false,
                                    axisLabel: {
                                        formatter: '{value} %'
                                    }
                                }
                            ],
                            series: [

                                {
                                    name: '计划',
                                    type: 'bar',
                                    data: taskArr,
                                    itemStyle: {
                                      normal: {
                                        color: '#06c'
                                      }
                                    }
                                },
                                {
                                    name: '实际',
                                    type: 'bar',
                                    data: offerArr,
                                    itemStyle: {
                                      normal: {
                                        color: 'orange'
                                      }
                                  }
                                },
                                {
                                    name: '达成率',
                                    type: 'line',
                                    yAxisIndex: 1,
                                    itemStyle: {
                                        normal: {
                                            color: 'gray',
                                            barBorderColor: 'tomato',
                                            barBorderWidth: 3,
                                            barBorderRadius: 0,
                                            label: {
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
                                    data: achievementArr
                                }
                            ]
                        };
                        myChart.setOption(option);
                    }
                );
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

</script>
</html>
