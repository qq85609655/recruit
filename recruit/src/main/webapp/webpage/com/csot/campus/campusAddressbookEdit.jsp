<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<%@ include file="/resources/context/jspBase.jsp"%>
<title>编辑校招通讯录</title>
<%@ include file="/resources/context/headResource.jsp"%>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" method="post">
      <input name="id" class="mini-hidden" value="${campusAddressbook.id}" />
      <table class="formTable" style="table-layout: fixed;">
        <tr>
          <td class="formLabel">站点</td>
          <td class="formContent"><input class="mini-combobox" style="width: 180px;"
            textField="siteName" name="siteId" valueField="siteId"
            value="${campusAddressbook.siteId}" required="true" requiredErrorText="站点不能为空"
            url="/recruit/campusSiteController/datagrid" /></td>
        </tr>
        <tr>
          <td class="formLabel">校招角色</td>
          <td class="formContent"><input name="campusRole" class="mini-textbox" required="true"
            value="${campusAddressbook.campusRole}" style="width: 180px" allowInput="true"
            requiredErrorText="校招角色不能为空" /></td>
        </tr>
        <tr>
          <td class="formLabel">工号</td>
          <td class="formContent"><input name="workNo" class="mini-textbox" required="true"
            value="${campusAddressbook.workNo}" style="width: 180px" allowInput="true"
            requiredErrorText="工号不能为空" vtype="maxLength:16" maxLengthErrorText="工号长度不能大于16个字符" /></td>
        </tr>
        <tr>
          <td class="formLabel">姓名</td>
          <td class="formContent"><input name="realname" class="mini-textbox" required="true"
            value="${campusAddressbook.realname}" style="width: 180px" allowInput="true"
            requiredErrorText="姓名不能为空" /></td>
        </tr>
        <tr>
          <td class="formLabel">联系电话</td>
          <td class="formContent"><input name="phoneno" class="mini-textbox" required="true"
            value="${campusAddressbook.phoneno}" style="width: 180px" allowInput="true"
            requiredErrorText="联系电话不能为空" vtype="minLength:11" vtype="maxLength:11" /></td>
        </tr>
        <tr>
          <td class="formLabel">邮箱</td>
          <td class="formContent"><input name="email" class="mini-textbox" required="true"
            value="${campusAddressbook.email}" style="width: 180px" allowInput="true"
            requiredErrorText="邮箱不能为空" vtype="email" /></td>
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
        var data = form.getData(true);//获取表单多个控件的数据
        form.validate();
        if (form.isValid() == false) {
          return;
        } else {
          $.ajax({
            url : "/recruit/campusAddressbookController/save",
            type : "post",
            data : data,
            dataType : "json",
            success : function(data) {
              if (data.success == true) {
                alert("保存成功！");
                CloseWindow("close", form);
              } else {
                mini.alert("保存失败！" + data.msg);
              }
            }
          });
        }
        //SaveData("/recruit/campusAddressbookController/save", $("#mainForm").serialize());
      }

      function onCancel(e) {
        CloseWindow("close", form);
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>