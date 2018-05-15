<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="/resources/context/jspBase.jsp"%>

<title>显示字段选择</title>
<%@ include file="/resources/context/headResource.jsp"%>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" AutoScroll="true" method="post">
      <h2>显示字段选择</h2>
      <hr></hr>

      <table>
        <div id="selectType" class="mini-radiobuttonlist" repeatItems="2" repeatLayout="table"
          textField="text" valueField="id" onvaluechanged="onSelectChanged"
          data="[{id: 1, text: '全选'}, {id: 2, text: '取消全选'}]"></div>
      </table>
      <br>
      <div id="select" class="mini-checkboxlist" repeatItems="5" repeatLayout="table"
        textField="text" valueField="id" onvaluechanged="onDataChanged"
        url="/recruit/resources/data/stuSelectValue.txt"></div>

    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 100px;" onclick="onOk()">提交</a> <span
      style="display: inline-block; width: 25px;">
  </div>
</body>
<script>
  mini.parse();
  var form = new mini.Form("#mainForm");
  var checkBoxList = mini.get("select");
  var radioBoxList = mini.get("selectType");
  
  function onSelectChanged() {
	var data = radioBoxList.getValue();
	if("1"==data){
	  checkBoxList.selectAll();
	}else{
	  checkBoxList.deselectAll();
	}
  }
  //选择数据
  function getData() {
    var data = checkBoxList.getValue();
    return data;
  }

  function onOk() {
    CloseWindow("ok");

  }
</script>
<%@ include file="/resources/context/lazyResource.jsp"%>

</html>