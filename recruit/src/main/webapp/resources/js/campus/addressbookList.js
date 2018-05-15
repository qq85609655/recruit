function search() {
  var key = mini.get("key").getValue();
  datagrid.load({
    searchKey : key
  });
}

function create() {
  OpenDialog("/recruit/campusAddressbookController/create/", "新建人员信息", datagrid, 380, 350);
}

function modify() {
  var row = datagrid.getSelected();
  if (row) {
    OpenDialog("/recruit/campusAddressbookController/modify/" + row.id, "编辑人员信息", datagrid, 380,
        350);
  } else {
    ShowWarnTip("请选择一条记录");
  }
}

function removeAddressbook() {
  var data = datagrid.getSelected();
  if (data) {
    var id = data.id;
    mini.confirm("确定删除记录？<br>", "删除", function(action) {
      if (action == "ok") {
        SaveData("/recruit/campusAddressbookController/remove/" + id, "", function(e) {
          ShowActionTip(e);
          datagrid.reload();
        });
      }
    });
  } else {
    ShowWarnTip("请选择一条记录");
  }
}

// 导入校招通讯录模板
function onImport() {
  mini.open({
    url : "/recruit/campusAddressbookController/importAddressbook",
    title : "导入校招通讯录模板",
    width : 400,
    height : 100,
    allowResize : false
  });
}

// 下载导入模板
function downloadTemplate() {

  window.location.href = "/recruit/campusAddressbookController/campusTemplete";
}

// 导出校招通讯录信息
function onExport() {

  var realName = mini.get("key").getValue();
  realName = encodeURI(encodeURI(realName)); // url传参非asc码必须先转码再传，否则会出现乱码
  window.location.href = "/recruit/campusAddressbookController/exportCampusTemplete?realName="
      + realName;
}