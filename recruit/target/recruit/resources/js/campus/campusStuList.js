var siteIdKey = mini.get("siteKey");
var postIdKey = mini.get("postKey");
var stuNameKey = mini.get("nameKey");
var schoolKey = mini.get("schoolKey");
var orgKey = mini.get("org");
var centerKey = mini.get("centerKey");
var yearthKey = mini.get("yearthKey");
var showTypeKey = mini.get("show");
var radioButtom1 = mini.get("radioButtom1");
var radioButtom2 = mini.get("radioButtom2");
var radioButtom3 = mini.get("radioButtom3");
var radioButtom4 = mini.get("radioButtom4");
var radioButtom5 = mini.get("radioButtom5");
var radioButtom6 = mini.get("radioButtom6");
var radioButtom7 = mini.get("radioButtom7");
var radioButtom8 = mini.get("radioButtom8");

search();
// 日期格式渲染
function onDateRenderer(e) {
  var value = e.value;
  if (value)
    return new Date(value).format("yyyy-MM-dd");
  return "";
}

function search() {

  var siteId = siteIdKey.getValue();
  var postId = postIdKey.getValue();
  var stuName = stuNameKey.getValue();
  var school = schoolKey.getValue();
  var org = orgKey.getValue();
  var center = centerKey.getValue();
  var yearth = yearthKey.getValue();
  var showType = showTypeKey.setValue("");
  var radioValue1 = radioButtom1.getValue();
  var radioValue2 = radioButtom2.getValue();
  var radioValue3 = radioButtom3.getValue();
  var radioValue4 = radioButtom4.getValue();
  var radioValue5 = radioButtom5.getValue();
  var radioValue6 = radioButtom6.getValue();
  var radioValue7 = radioButtom7.getValue();
  var radioValue8 = radioButtom8.getValue();

  datagrid.load({
    siteId : siteId,
    postId : postId,
    stuName : stuName,
    school : school,
    org : org,
    center : center,
    yearth : yearth,
    radioValue1 : radioValue1,
    radioValue2 : radioValue2,
    radioValue3 : radioValue3,
    radioValue4 : radioValue4,
    radioValue5 : radioValue5,
    radioValue6 : radioValue6,
    radioValue7 : radioValue7,
    radioValue8 : radioValue8
  });
}

function dataChange() {
  var showType = showTypeKey.getValue();
  var siteId = siteIdKey.setValue("");
  var postId = postIdKey.setValue("");
  var stuName = stuNameKey.setValue("");
  var school = schoolKey.setValue("");
  var org = orgKey.setValue("");
  var center = centerKey.setValue("");
  var yearth = yearthKey.setValue("");
  var radioValue1 = radioButtom1.setValue("");
  var radioValue2 = radioButtom2.setValue("");
  var radioValue3 = radioButtom3.setValue("");
  var radioValue4 = radioButtom4.setValue("");
  var radioValue5 = radioButtom5.setValue("");
  var radioValue6 = radioButtom6.setValue("");
  var radioValue7 = radioButtom7.setValue("");
  var radioValue8 = radioButtom8.setValue("");

  datagrid.load({
    siteId : siteId,
    postId : postId,
    stuName : stuName,
    school : school,
    org : org,
    center : center,
    yearth : yearth,
    showType : showType
  });

}

function onKeyEnter(e) {
  search();
}

function create() {

  OpenDialog("/recruit/campusStudentController/create/", "新建人员信息", datagrid, 780, 650);
}

function modify() {

  var row = datagrid.getSelected();
  var rows = datagrid.getSelecteds();
  if (rows.length > 1) {
    ShowWarnTip("请逐条进行操作！");
  } else if (rows.length == 0) {
    ShowWarnTip("请选择一条记录！");
  } else {
    OpenDialog("/recruit/campusStudentController/modify/" + row.id, "编辑人员信息", datagrid, 780, 650);
  }

}

function removeStu() {

  var data = datagrid.getSelecteds();
  if (data.length > 0) {

    mini.confirm("确定删除记录？<br>", "删除", function(action) {
      if (action == "ok") {
        var ids = [];
        for (var i = 0, l = data.length; i < l; i++) {
          var r = data[i];
          ids.push(r.id);
        }
        var id = ids.join(',');
        SaveData("/recruit/campusStudentController/remove/" + id, "", function(e) {
          mini.alert(e.msg);
          datagrid.reload();
        });
      }
    });
  } else {
    ShowWarnTip("请选择一条记录");
  }
}

// 导入学生信息模板表
function onImport() {
  mini.open({
    url : "/recruit/campusStudentController/importStudentInfo",
    title : "导入学生信息模板表",
    width : 400,
    height : 180,
    allowResize : false
  });
}

// 导出学生详细信息
function onExport() {
  var siteId = siteIdKey.getValue();
  var postId = postIdKey.getValue();
  var stuName = stuNameKey.getValue();
  var school = schoolKey.getValue();
  var org = orgKey.getValue();
  var center = centerKey.getValue();
  var yearth = yearthKey.getValue();
  var showType = showTypeKey.getValue();
  var radioValue1 = radioButtom1.getValue();
  var radioValue2 = radioButtom2.getValue();
  var radioValue3 = radioButtom3.getValue();
  var radioValue4 = radioButtom4.getValue();
  var radioValue5 = radioButtom5.getValue();
  var radioValue6 = radioButtom6.getValue();
  var radioValue7 = radioButtom7.getValue();
  var radioValue8 = radioButtom8.getValue();
  // radioValue8 = encodeURI(encodeURI(radioValue8));

  window.location.href = "/recruit/campusStudentController/exportCampusStudentInfo?siteId="
      + siteId + "&postId=" + postId + "&stuName=" + stuName + "&school=" + school + "&org=" + org
      + "&center=" + center + "&yearth=" + yearth + "&showType=" + showType + "&radioValue1="
      + radioValue1 + "&radioValue2=" + radioValue2 + "&radioValue3=" + radioValue3
      + "&radioValue4=" + radioValue4 + "&radioValue5=" + radioValue5 + "&radioValue6="
      + radioValue6 + "&radioValue7=" + radioValue7 + "&radioValue8=" + radioValue8;
}

// 下载信息模板
function templateExport() {

  window.location.href = "/recruit/campusStudentController/campusStuInfoTemplete";
}

// 选人发送邮件
function sendEmail() {

  var rows = datagrid.getSelecteds();
  if (rows.length > 0) {
    var idStr = [];
    var ids = "";
    for (var i = 0, l = rows.length; i < l; i++) {
      var r = rows[i];
      idStr.push(r.id);
    }
    var ids = idStr.join(',');
    var type = "select";

    // var messageId = mini.loading("正在导入中!");
    OpenDialog("/recruit/campusStudentController/sendEmail?ids=" + ids + "&type=" + type, "发送邮件",
        datagrid, 780, 600);
    // mini.hideMessageBox(messageId);
  } else {
    ShowWarnTip("请选择至少一条记录！");
  }
}

// 全部发送邮件
function sendAll() {

  var type = "all";
  // var messageId = mini.loading("正在导入中!");
  OpenDialog("/recruit/campusStudentController/sendEmail?type=" + type, "全部发送邮件", datagrid, 780,
      600);
  // mini.hideMessageBox(messageId);
}

// 搜索结果发送
function sendSearch() {
  var type = "some";

  var siteId = siteIdKey.getValue();
  var postId = postIdKey.getValue();
  var stuName = stuNameKey.getValue();
  var school = schoolKey.getValue();
  var org = orgKey.getValue();
  var center = centerKey.getValue();
  var yearth = yearthKey.getValue();
  var showType = showTypeKey.getValue();
  var radioValue1 = radioButtom1.getValue();
  var radioValue2 = radioButtom2.getValue();
  var radioValue3 = radioButtom3.getValue();
  var radioValue4 = radioButtom4.getValue();
  var radioValue5 = radioButtom5.getValue();
  var radioValue6 = radioButtom6.getValue();
  var radioValue7 = radioButtom7.getValue();
  var radioValue8 = radioButtom8.getValue();
  var searchCondition = {
    siteId : siteId,
    postId : postId,
    stuName : stuName,
    school: school,
    org : org,
    center : center,
    yearth : yearth,
    showType : showType,
    radioValue1 : radioValue1,
    radioValue2 : radioValue2,
    radioValue3 : radioValue3,
    radioValue4 : radioValue4,
    radioValue5 : radioValue5,
    radioValue6 : radioValue6,
    radioValue7 : radioValue7,
    radioValue8 : radioValue8
  };

  mini.open({
    url : "/recruit/campusStudentController/sendEmail?type=" + type,
    title : "按搜索结果发送邮件",
    width : 780,
    height : 600,
    onload: function () {       //弹出页面加载完成
      var iframe = this.getIFrameEl();   
      //调用弹出页面方法进行初始化
      iframe.contentWindow.SetData(searchCondition); 
    },
    ondestroy : function(action) {
    }
  });
  
}

// 资料未齐全发送
function sendSome() {

  $.ajax({
    url : "/recruit/campusStudentController/sendEmailToSome",
    type : "post",
    dataType : "json",
    success : function(data) {
      mini.alert(data.msg);
      CloseWindow("close");
    }
  });

}

// 违约详细信息设置
function isBreakOff() {

  var rows = datagrid.getSelecteds();
  var row = datagrid.getSelected();
  if (rows.length > 1) {
    ShowWarnTip("请逐条进行操作!");
  } else if (rows.length == 0) {
    ShowWarnTip("请选择无offer有三方的记录！");
  } else {
    // 无offer 有三方
    if ("无" == row.offer || "有" == row.trilateral) {

      OpenDialog("/recruit/campusStudentController/doSetBreakOffReason?id=" + row.id, "编辑违约原因",
          datagrid, 350, 300);

    } else {
      ShowWarnTip("请选择无offer有三方的记录！");
    }
  }
}

// 设置显示的字段
function showColumn() {

  OpenDialog("/recruit/campusStudentController/showColumn", "设置显示字段", datagrid, 550, 450, function(
      action) {
    if (action == "ok") {
      var iframe = this.getIFrameEl();
      var data = iframe.contentWindow.getData();
      data = mini.clone(data);
      var showData = [];
      showData = data.split(",");
      // 先隐藏所有列后显示选择的行
      for (var i = 0; i <= 33; i++) {
        datagrid.hideColumn(datagrid.getColumn(i + 2));
      }
      for (var j = 0; j < showData.length; j++) {

        datagrid.showColumn(datagrid.getColumn(showData[j]));
      }
    }

  });
}
// 站长导入信息，且当期站长只能导入有且仅有一次
function masterImport() {

  mini.open({
    url : "/recruit/campusStudentController/importStuInfoByMaster",
    title : "站长导入学生信息模板表",
    width : 400,
    height : 110,
    allowResize : false
  });
}
// 站长编辑信息，这能编辑指定的字段
function masterEdit() {

  var row = datagrid.getSelected();
  var rows = datagrid.getSelecteds();
  if (rows.length > 1) {
    ShowWarnTip("请逐条进行操作！");
  } else if (rows.length == 0) {
    ShowWarnTip("请选择一条记录！");
  } else {
    OpenDialog("/recruit/campusStudentController/modifyByMaster/" + row.id, "站长编辑人员信息", datagrid,
        780, 650);
  }
}