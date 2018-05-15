<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>PartNo_Info</title>
<%@ include file="/resources/context/headResource.jsp"%>
<%@ include file="/resources/context/lazyResource.jsp"%>
<style>
.td1 {
  text-align: left;
  float:top;
}

.td2 {
  padding-left: 15px;
  font-size: 13px;
  font-family: Tahoma;
}
</style>
</head>
<body style="width: 450px; height: 300px">
  <div id="form1">
    <table style="padding-left: 20px; font-size: 10px; font-family: 微软雅黑" align="center">
      <tr>
        <td><span style="padding-right: 10px">料号：31302023550001${partNo.partNo }</span>
        </td>
      </tr>
      <tr>
        <td><span style="padding-right: 10px">名称：液晶0001${partNo.partName }</span>
        </td>
      </tr>
      <tr>
        <td class="td1" >物料描述(长度不超过40)：</td>
        <td><input class="mini-textarea" vtype="maxLength:40" required="true"
          value="hahahah${partNo.cnDesc }" /></td>
      </tr>
      <tr>
        <td><span id="info" style="padding-right: 10px">生成成功!${info }</span></td>
      </tr>
    </table>
  </div>
  <div style="text-align: center; padding: 10px;">
    <a class="mini-button" onclick="toFinish()" style="width: 60px;">确认生成</a>
  </div>


  <script type="text/javascript">
  	mini.parse();
  	
	function toFinish() {
	  
      var form = new mini.Form("form1");
      form.validate();
      if (form.isValid() == false) return;
      
      var data = $("#form1").serialize();
  
      $.ajax({
        url : "lc/checkLC",
        type : "post",
        data : data,
        dataType : 'json', //数据格式为json
        success : function(data) { 
        },
        error: function (msg) {
          mini.alert(msg,"error",CloseWindow);
        }
      });
	  
	  
	  var base = document.getElementsByTagName("base")[0].getAttribute("href"); //IE下base标签不兼容
	  
	  var info = $("#info").text();
	  if (info.indexOf("生成成功") == -1) {
	    window.location.href = base + "rawMaterial/finishFail";
	  } else {
	    window.location.href = base + "rawMaterial/finishSuccess";
	  }
	}
    </script>
</body>
</html>