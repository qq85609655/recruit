<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<!DOCTYPE html>
<html>
<head>
  <%@ include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>站点管理</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">校园招聘</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">站点管理</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">站点管理</div>
        <div class="account-content">
          <div class="account-search">
            <table class="tblQuery2">
              <tbody>
                <tr>
                  <th>&nbsp;站点名称：</th>
                  <td><input class="mini-combobox" style="width: 120px;" textField="siteName"
                             name="siteName" valueField="siteId" id="siteName" allowInput="true"
                             nullItemText="全部" showNullItem="true" onenter="search()"
                             url="/recruit/campusAddressbookController/getSiteName" onitemclick="search()" /></td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="blue radius">
            <div class="table-operate" style="padding: 10px">
              <input type="button" class="button radius btn" id="create" value="新增" onclick="addRow()" />
              <input type="button" class="button radius btn" id="remove" value="删除" onclick="removeSite()" />
              <input type="button" class="button radius btn" id="save" value="保存" onclick="saveData()" />
            </div>
            <div id="datagrid1" class="mini-datagrid" url="/recruit/campusSiteController/datagrid?showPager=true"
              sizeList="[15,30,50,100]" pageSize="15" allowResize="true" idField="id"
              allowCellEdit="true" allowCellSelect="true" multiSelect="true" allowCellValid="true" oncellvalidation="onCellValidation">
              <div property="columns">
                <div type="checkcolumn"></div>
                <div name="siteName" field="siteName" width="80" allowSort="true" vtype="required;rangeChar:1,32">站点名称
                  <input property="editor" class="mini-textbox" style="width:100%;"/>
                </div>
                <div type="comboboxcolumn" autoShowPopup="true" name="status" vtype="required" field="status" width="30" allowSort="true">状态
                  <input property="editor" class="mini-combobox" style="width:100%;" data="Status"/>
                </div>
                <div name="remark" field="remark" width="80" allowSort="true">备注
                    <input property="editor" class="mini-textbox" style="width:100%;" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script>
  var Status = [{ id: 1, text: '启用' }, { id: 0, text: '停用'}];
  mini.parse();
  var datagrid = mini.get("datagrid1");
  datagrid.load();
  
  function search() {
    var siteName = mini.get("siteName").getText();
    datagrid.load({
      siteName : siteName
    });
  }
  
  function addRow() {
    var newRow = {
      name : "New Row"
    };
    datagrid.addRow(newRow, 0);
    datagrid.validateRow(newRow); //加入新行，马上验证新行
  }
  
  function saveData() {
    datagrid.validate();
    if (datagrid.isValid() == false) {
      var error = datagrid.getCellErrors()[0];
      mini.alert(error.errorText);
      datagrid.beginEditCell(error.record, error.column);
      return;
    }
    var data = datagrid.getChanges();
    var json = mini.encode(data);

    datagrid.loading("保存中，请稍后......");
    $.ajax({
      url : "/recruit/campusSiteController/saveData",
      dataType : 'json',
      contentType : 'application/json',
      data : json,
      type : "post",
      success : function(text) {
        mini.alert(text.msg);
        datagrid.reload();
      },
      error : function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.responseText);
      }
    });
  }
  
  function onCellValidation(e) {
    if (e.field == "siteName") {
      if (e.value == 0) {
        e.isValid = false;
        e.errorText = "不能为空";
      }
    }
  }

  function removeSite() {
    var rows = datagrid.getSelecteds();
    if (rows.length > 0) {
      var ids = "";
      for (var i=0; i < rows.length; i++) {
        ids = ids + rows[i].id + ",";
      }
      mini.confirm("确定删除记录？<br>", "删除", function(action) {
        if (action == "ok") {
          SaveData("/recruit/campusSiteController/remove/" + ids, "", function(e) {
            ShowActionTip(e);
            datagrid.reload();
          });
        }
      });
    } else {
      ShowWarnTip("请选择一条记录");
    }
  }

</script>
</html>
