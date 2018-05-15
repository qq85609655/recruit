<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>料号分布</title>
<%@ include file="/resources/context/headResource.jsp"%>
<script src="${basePath}/resources/js/highcharts.js"></script>
<script src="${basePath}/resources/js/exporting.js"></script>
<script src="${basePath}/resources/js/grouped-categories.js"></script>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div id="container" style="min-width: 310px; height: 400px; max-width: 600px; margin: 0 auto"></div>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>

<script type="text/javascript">
  mini.parse();
  buildChart();
  function buildChart() {
    $.ajax({
      url : "materialManage/getPieChartsData4PartNo",
      dataType : 'json',
      contentType : 'application/json',
      type : "post",
      success : function(data) {
        Highcharts.chart('container', {
          chart : {
            plotBackgroundColor : null,
            plotBorderWidth : null,
            plotShadow : false,
            type : 'pie'
          },
          credits : {
            enabled : false
          },
          exporting : {
            enabled : false,
            filename : '',
            sourceWidth : 1920,
            sourceHeight : 810
          },
          title : {
            text : '物料分布图'
          },
          tooltip : {
            pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
          },
          plotOptions : {
            pie : {
              allowPointSelect : true,
              cursor : 'pointer',
              dataLabels : {
                enabled : true,
                format : '<b>{point.name}</b>: {point.percentage:.1f} %',
                style : {
                  color : (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
              }
            }
          },
          series : [ {
            name : 'Proportion',
            colorByPoint : true,
            data : data
          } ]
        });
      },
      error : function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.responseText);
      }
    });

  }
</script>