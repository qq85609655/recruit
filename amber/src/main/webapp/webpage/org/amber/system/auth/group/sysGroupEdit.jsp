<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/resources/context/jspBase.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<%@ include file="/resources/context/headResource.jsp"%>
<script>
  var enabledEnum = [ {
    id : 1,
    text : '启用'
  }, {
    id : 0,
    text : '停用'
  } ];
</script>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" method="post">
      <input name="id" class="mini-hidden" value="${sysGroupVo.id}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">组名称:</td>
          <td class="formContent"><input name="name" class="mini-textbox" required="true"
            value="${sysGroupVo.name}" vtype="maxLength:80" emptyText="请输入组名"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">是否启用:</td>
          <td class="formContent"><div id="enabled" name="enabled" class="mini-radiobuttonlist"
              repeatItems="1" repeatLayout="table" repeatDirection="vertical" textField="text"
              valueField="id"
              value="<c:choose><c:when test="${!empty sysGroupVo.enabled}">${sysGroupVo.enabled}</c:when><c:otherwise>1</c:otherwise></c:choose>"
              data="enabledEnum"></div> <label id="enabled_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">上级组:</td>
          <td class="formContent"><input id="parentId" name="parentId" class="mini-buttonedit"
            value="${sysGroupVo.parentId}" text="${sysGroupVo.parentName}" allowInput="false"
            onbuttonclick="onParentEdit" /> <a class="mini-button " plain="true" iconCls="icon-upload"
            onclick="onClearParent">升为顶级组</a> <label id="parentId_error" class="errorText"></label></td>
        </tr>
      </table>
    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 60px;" onclick="onOk()">确定</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 60px;" onclick="onCancel()">取消</a>
  </div>
  <script>
      mini.parse();
      var form = new mini.Form("#mainForm");

      function onOk(e) {
        form.validate();
        if (form.isValid() == false) {
          return;
        }

        SaveData("auth/group/sysGroup/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }

      function onParentEdit(e) {
        var parentEdit = this;
        OpenDialog("auth/group/sysGroup/singleSelectGroupTreeWindow", "选择上级组",
            null, 350, 350, function(action) {
              if (action == "ok") {
                var iframe = this.getIFrameEl();
                var data = iframe.contentWindow.GetData();
                data = mini.clone(data);
                if (data) {
                  if (data.id == "${sysGroupVo.id}") {
                    mini.alert("上级组不能是自身");
                    return;
                  }
                  parentEdit.setValue(data.id);
                  parentEdit.setText(data.name);
                }
              }
            });
      }
      
      function onClearParent(e) {
        var parentEdit = mini.get("parentId");
        parentEdit.setValue("");
        parentEdit.setText("顶级组");
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>