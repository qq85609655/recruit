<%--
  Created by IntelliJ IDEA.
  User: xiongyinchun
  Date: 2018/2/5
  Time: 20:05
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="el" uri="/eltag"%>
<!DOCTYPE HTML>
<html>
<head>
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=Edge">
  <title>report</title>
  <script type="text/javascript" src="resources/datepicker/dateRange.js"></script>
  <script type="text/javascript" src="resources/datepicker/jquery.min.js"></script>
  <script type="text/javascript" src="resources/datepicker/monthPicker.js"></script>
  <script type="text/javascript" src="resources/datepicker/cvi_busy_lib.js"></script>
  <script type="text/javascript" src="resources/jquery-pretty-radio-checkbox/js/jquery-1.8.3.min.js"></script>
  <script type="text/javascript" src="resources/jquery-pretty-radio-checkbox/js/jquery-labelauty.js"></script>
  <link rel="stylesheet" type="text/css" href="resources/datepicker/dateRange.css">
  <link rel="stylesheet" type="text/css" href="resources/datepicker/monthPicker.css">
  <link rel="stylesheet" type="text/css" href="resources/jquery-pretty-radio-checkbox/css/jquery-labelauty.css">
  <style type="text/css">
    #title {
      font-size: 23px;
      font-family: 微软雅黑;
      color: gray;
      text-align: center;
      padding-left: 50px;
    }

    .topBorder {
      border-top: 1px solid black;
    }

    .bottomBorder {
      border-bottom: 1px solid black;
    }

    .rightBorder {
      border-right: 1px solid black;
    }

    .leftBorder {
      border-left: 1px solid black;
    }
    .textRight {
      text-align: right;
    }
    .textLeft {
      text-align: left;
    }
    .tdPadding {
      padding: 3px;
    }

    ul { list-style-type: none;}
    li { display: inline-block;}
    li { margin: 10px 0;}
    input.labelauty + label { font: 12px "Microsoft Yahei";}
  </style>
</head>
<body>
  <div id="title">
    主数据管理系统报表
  </div>
  <div style="height: 30px;float: left;margin-left: 30px">
    <ul class="dowebok">
      <li><input value="0" type="radio" name="radio" data-labelauty="未提交数据"></li>
      <li><input value="1" type="radio" name="radio" data-labelauty="流程中数据"></li>
      <li><input value="2" type="radio" name="radio" data-labelauty="已生效数据" checked="true"></li>
    </ul>
  </div>

  <div style="height: 50px;float: right;margin-right: 30px">
  <div class="ta_date" id="div_date_demo3">
    <span class="date_title" id="date_demo3"></span>
    <a class="opt_sel" id="input_trigger_demo3" href="#">
    </a>
  </div>
    <input type="button" value="查询" onclick="query()">
    <input type="button" value="导出" onclick="exportExcel()">
  </div>
<div style="padding: 30px 30px 10px 30px;clear: both;">
  <table style="width: 100%;font-size: 13px;font-family:微软雅黑" cellpadding="0" cellspacing="0">
    <!-- 表头 -->
    <tr style="height: 20px; text-align: center;font-weight: bold">
      <c:forEach items="${titles}" var="item" varStatus="status">
        <c:set var="borderStyle" value="${status.index == 0 ? 'leftBorder' : ''}"></c:set>
        <c:set var="tdWidth" value="${status.index < 2 ? '13%' : status.index == 5 ? '10%' : '8%'}"></c:set>
        <td style="background: #C5D9F1; width: ${tdWidth}" class="${borderStyle} topBorder rightBorder bottomBorder tdPadding">${item}</td>
      </c:forEach>
    </tr>

    <!-- 内容 -->
    <c:forEach items="${data}" var="row" varStatus="status">
      <tr style="height: 20px">
        <c:if test="${status.index % 3 == 0 && !status.last}">
          <td rowspan="3" class="tdPadding leftBorder bottomBorder rightBorder textLeft">${company[status.index / 3]}</td>
        </c:if>
        <c:choose>
          <c:when test="${status.last}">
            <td style="background: yellow; text-align: center" colspan="2" class="leftBorder rightBorder bottomBorder">总计</td>
          </c:when>
          <c:otherwise>
            <td class="tdPadding rightBorder bottomBorder textLeft">${type[status.index % 3]}</td>
          </c:otherwise>
        </c:choose>
        <c:forEach items="${row}" var="row_item" varStatus="status1">
          <td id="data${status.count}${status1.count}" class="tdPadding textRight rightBorder bottomBorder">${el:toNumberString(row_item,",###","0") }</td>
        </c:forEach>
      </tr>
    </c:forEach>

  </table>
</div>
<script type="text/javascript">

  $(function(){
    $("input[name='radio']").labelauty();
  });

  var status = "2";

  var hostPath = "${basePath}";
  var sd = "2017:12:01";
  var ed = "2018:02:01";
  var dateRange = new pickerDateRange('date_demo3', {
    isTodayValid : true,
    startDate : '2017-12-01',
    endDate : '2018-02-01',
    defaultText : ' 至 ',
    inputTrigger : 'input_trigger_demo3',
    theme : 'ta',
    success : function(obj) {
      sd = $('#'+this.startDateId).val().replace(/-/g, ':');
      ed = $('#'+this.endDateId).val().replace(/-/g, ':');
    }
  });

  function query() {
    $("input[name='radio']").each(function() {
      if ($(this).attr('checked')) {
        status = $(this).attr('value');
      }
    });
    //遮罩层
    var xval=getBusyOverlay('viewport',
        {color:'gray', opacity:0.75, text:'viewport: loading...',
          style:'text-shadow: 0 0 3px black;font-weight:bold;font-size:16px;color:white'},
        {color:'#ff0', size:100, type:'o'});
    $.ajax({
      url : "reportController/getData?sd=" + sd + "&ed=" + ed + "&status=" + status,
      type : "post",
      dataType : 'json',
      beforeSend:function(){
        if(xval) {
          xval.settext("正在查询，请稍后......");
        }
      },
      success : function(data) {
        xval.remove();
        for (var i = 0; i < data.length; i++) {
          for (var j = 0; j < data[i].length; j++) {
            $("#data" + (i+1) + "" + (j+1)).text(formatNumber(data[i][j]));
          }
        }
      },
      error : function(msg) {
        alert("error");
      }
    });
  }

  function exportExcel() {
    window.location.href = hostPath + "reportController/exportSumReport?sd=" + sd + "&ed=" + ed + "&status=" + status;
  }

  /**
   * 格式化数字为千分位展示
   * @param num
   * @returns {string}
   */
  function formatNumber(num) {
    if (isNaN(num)) {
      throw new TypeError("num is not a number");
    }
    return ("" + num).replace(/(\d{1,3})(?=(\d{3})+(?:$|\.))/g, "$1,");
  }

</script>
</body>
</html>

