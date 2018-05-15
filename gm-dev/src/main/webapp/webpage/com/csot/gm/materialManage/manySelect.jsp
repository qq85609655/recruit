<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
  String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>
<c:set var="basePath" value="<%=basePath%>" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<base href="${basePath}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>多值添加</title>
<%@ include file="/resources/context/headResource.jsp"%>
<style type="text/css">
html, body {
  padding: 0;
  margin: 0;
  border: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
}

.tableHeadTD1 {
  width: 80px;
}

.tableHeadTD2 {
  width: 260px;
}

.tableHeadTD3 {
  width: 100px;
}

.tableRowTD2 {
  width: 165px;
}

.tableRowTD3 {
  width: 70px;
}
</style>
</head>
<body>
  <div style="height: 300px; margin: 10px 20px 0 20px">
    <div style="font-size: 11px; color: #686666">
      方式一：手动输入，单个或者多个料号，输入多个请以<span style="color: red">英文分号“;”</span>或者<span style="color: red">空格“
        ”</span>隔开，点击“添加”<br /> 方式二：从Excel粘贴，请复制<span style="color: red">单列</span>Excel数据粘贴到输入框，点击“添加”
    </div>
    <fieldset id="idField"
      style="float: left; width: 475px; height: 340px; margin: 5px 10px 0 0; padding: 10px; border: solid 1px #aaa; position: relative;">
      <legend>
        <span id="inputName"></span><span style="color: red; font-size: 15px">*</span>
      </legend>
      <div>
        <input type="text" id="idInput" style="width: 300px" onbeforepaste="checkBeforePaste(this)" />
        <a class="mini-button" iconCls='icon-add' onclick="add('idInput', 'idTable', 1)">添加</a>
      </div>
      <div>
        <table>
          <tr>
            <td class="tableHeadTD1">序号</td>
            <td class="tableHeadTD2">料号</td>
            <td class="tableHeadTD3">操作&nbsp;<a class='mini-button' plain='true'
              onclick="clear()"><u>全部删除</u></a></td>
          </tr>
        </table>
        <div style="overflow-x: hidden; overflow-y: auto; height: 240px">
          <table id="idTable">

          </table>
        </div>
      </div>
    </fieldset>
  </div>
  <div
    style="position: absolute; text-align: center; bottom: 0; width: 100%; height: 32px; background: #E7EBEF url(/resources/plugins/miniui/miniui/themes/default/images/grid/header.png) repeat-x 0 0">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>
</body>
</html>
<script type="text/javascript">
  mini.parse();
  var idMax = 0;

  function SetData(inputName, selected) {
    if (selected.length > 0) {
      var ids = selected.split(";");
      addRows(ids);
    }
    $("#inputName").text(inputName);
  }

  function add(inputID, tableID, type) {
    var text = $("#" + inputID).val();
    if (text == "") {
      return;
    }
    var items = [];
    if (text.indexOf(";") != -1) {
      // 分号间隔
      text = removeAllSpace(text);
      items = text.split(";");
    } else {
      // 方式2 从Excel粘贴
      items = text.split(" ");
    }
    addRows(items, tableID, type);
    $("#" + inputID).val("");
  }

  function addRows(items) {
    for (var i = 0; i < items.length; i++) {
      var trID = idMax + items[i];
      $("#idTable")
          .append(
              "<tr id='" + trID + "'><td width='80px' id='" + trID + "index'>"
                  + (idMax + 1)
                  + "</td><td width='290px'>"
                  + items[i]
                  + "</td><td class='tableRowTD3'><a class='mini-button' plain='true' iconCls='icon-remove' onclick=\"deleteRow(\'"
                  + trID + "\', " + idMax + ")\"></a></td></tr>");
      idMax++;
    }
    mini.parse();
  }

  // 在粘贴之前处理粘贴的内容 以空格区分
  function checkBeforePaste(obj) {
    var s = "" + window.clipboardData.getData('text');
    var target = "";
    for (var i = 0; i < s.length; i++) {
      if ((s[i] >= '0' && s[i] <= '9') || (s[i] >= 'A' && s[i] <= 'Z')
          || (s[i] >= 'a' && s[i] <= 'z')) {
        target += s[i];
      } else {
        if ((s[i - 1] >= '0' && s[i - 1] <= '9') || (s[i - 1] >= 'A' && s[i - 1] <= 'Z')
            || (s[i - 1] >= 'a' && s[i - 1] <= 'z')) {
          target += " ";
        }
      }
    }
    if (target[target.length - 1] == " ") {
      target = target.substring(0, target.length - 1);
    }
    window.clipboardData.setData('text', target);
  }

  function clear() {
    $("#idTable tr").each(function() {
      $(this).remove();
    });
    // 更新Index
    idMax = 0;
  }

  function deleteRow(trId, index) {
    $("#" + trId).remove();
    idMax--;
    // 更新删除行下面行的序号
    var count = 0;
    $("#idTable tr").each(function() {
      $("#" + $(this).attr("id") + "index").html("" + (count + 1));
      count++;
    });
  }

  function GetData() {
    var ids = [];
    $("#idTable tr").each(function() {
      ids.push($(this).children("td").eq(1).text());
    });
    var data = {};
    data.id = "";
    var result = "";
    if (ids.length > 0) {
      result = ids.join(";");
    }
    data.result = result;
    return data;
  }

  function CloseWindow(action) {
    if (window.CloseOwnerWindow)
      return window.CloseOwnerWindow(action);
    else
      window.close();
  }

  function onOk() {
    CloseWindow("ok");
  }
  function onCancel() {
    CloseWindow("cancel");
  }

  function removeAllSpace(text) {
    return text.replace(' ', ';')
  }
</script>
