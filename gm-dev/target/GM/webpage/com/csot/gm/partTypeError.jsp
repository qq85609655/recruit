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
</style>
</head>
<body style="width: 600px; height: 450px" align="center">
  <input name="uid" id="uid" class="mini-hidden" value="${uid}" />
  <input name="partType" id="partType" class="mini-hidden" value="${partType}" />
  <div id="form1">
    <table style="width: 400px; height: 300px; font-size: 20px; font-family: 微软雅黑" align="center">
      <tr>
        <td><span id="info" align="center">您所创建的零件类型不对，</br> </br> </br>请至PLM系统零件创建页面选择[${partTypeDisName}]
        </span></td>
      </tr>
    </table>
  </div>
  <div style="text-align: center; padding: 10px;">
    <a id="rtnBtn" class="mini-button" onclick="onRtn()" style="width: 60px; margin-right: 20px;">返回</a>
    <a class="mini-button" onclick="closeW()" style="width: 80px;">关闭</a>
  </div>
  <script type="text/javascript">
      mini.parse();
      var base = document.getElementsByTagName("base")[0].getAttribute("href"); //IE下base标签不兼容
      var uid = mini.get("uid").getValue();
      var partType = mini.get("partType").getValue();

      function onRtn() {
        window.location.href = base + "rawMaterial/rawMaterial?uid=" + uid + "&partType="
            + partType;
      }

      function closeW() {

        window.location.href = base + "rawMaterial/finishFail";

        /* if (window.CloseOwnerWindow()) {
          window.CloseOwnerWindow();
        } else {
          window.close();
        }  */
      }

      function CloseWebPage() {
        if (navigator.userAgent.indexOf("MSIE") > 0) {
          if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
            window.opener = null;
            window.close();
          } else {
            window.open('', '_top');
            window.top.close();
          }
        } else if (navigator.userAgent.indexOf("Firefox") > 0) {
          window.location.href = 'about:blank ';
        } else {
          window.opener = null;
          window.open('', '_self', '');
          window.close();
        }
      }

      function closeChrome() {
        var browserName = navigator.appName;
        alert(browserName);
        if (browserName == "Netscape") {
          window.open('', '_self', '');
          window.close();
        } else {
          window.close();
        }
      }
    </script>
</body>
</html>