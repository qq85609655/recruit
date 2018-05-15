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
  var showAsMenuEnum = [ {
    id : 1,
    text : '显示'
  }, {
    id : 0,
    text : '不显示'
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
      <input name="id" class="mini-hidden" value="${sysResourceVo.id}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">资源名称:</td>
          <td class="formContent"><input name="name" class="mini-textbox" required="true"
            value="${sysResourceVo.name}" vtype="maxLength:80" emptyText="请输入资源名称"
            onvalidation="ValidErrorText" /><label id="name_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">权限标识符:</td>
          <td class="formContent"><input name="identifer" class="mini-textbox" required="true"
            value="${sysResourceVo.identifer}" vtype="maxLength:100" emptyText="请输入权限标识符"
            onvalidation="ValidErrorText" /><label id="identifer_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">上级资源:</td>
          <td class="formContent"><input id="parentId" name="parentId" class="mini-buttonedit"
            value="${sysResourceVo.parentId}" text="${sysResourceVo.parentName}" allowInput="false"
            onbuttonclick="onParentEdit" /> <a class="mini-button " plain="true"
            iconCls="icon-upload" onclick="onClearParent">升为顶级资源</a> <label id="parentId_error"
            class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">是否显示为菜单:</td>
          <td class="formContent"><div id="showAsMenu" name="showAsMenu"
              class="mini-radiobuttonlist" repeatItems="1" repeatLayout="table"
              repeatDirection="vertical" textField="text" valueField="id"
              value="<c:choose><c:when test="${!empty sysResourceVo.showAsMenu}">${sysResourceVo.showAsMenu}</c:when><c:otherwise>1</c:otherwise></c:choose>"
              data=showAsMenuEnum></div> <label id="showAsMenu_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">菜单显示名称:</td>
          <td class="formContent"><input name="menuName" class="mini-textbox" required="true"
            value="${sysResourceVo.menuName}" vtype="maxLength:100" emptyText="请输入菜单显示名称"
            onvalidation="ValidErrorText" /><label id="menuName_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">菜单访问地址:</td>
          <td class="formContent"><input name="url" class="mini-textbox"
            value="${sysResourceVo.url}" vtype="maxLength:200" emptyText="请输入菜单访问地址"
            onvalidation="ValidErrorText" /><label id="url_error" class="errorText"></label></td>
        </tr>
        <tr>
          <td class="formLabel">菜单排序号:</td>
          <td class="formContent"><input name="weight" changeOnMousewheel="false" value="${sysResourceVo.weight}"
            class="mini-spinner" minValue="0" maxValue="255" /></td>
        </tr>
        <tr>
          <td class="formLabel">菜单图标:</td>
          <td class="formContent"><input name=icon class="mini-textbox"
            value="${sysResourceVo.icon}" vtype="maxLength:100" emptyText="请输入菜单图标"
            onvalidation="ValidErrorText" /><label id="icon_error" class="errorText"></label></td>
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

        SaveData("/recruit/auth/resource/sysResource/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }

      function onParentEdit(e) {
        var parentEdit = this;
        OpenDialog("/recruit/auth/resource/sysResource/singleSelectResourceTreeWindow", "选择上级资源",
            null, 350, 350, function(action) {
              if (action == "ok") {
                var iframe = this.getIFrameEl();
                var data = iframe.contentWindow.GetData();
                data = mini.clone(data);
                if (data) {
                  if (data.id == "${sysResourceVo.id}") {
                    mini.alert("上级资源不能是自身");
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
        parentEdit.setText("顶级资源");
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>