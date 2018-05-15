var type = "1";
grid.load({
  type : type
});
removeLoad();
grid.sortBy("updateDate", "desc");

// 日期格式渲染
function onDateRenderer(e) {
  var value = e.value;
  if (value)
    return new Date(value).format("yyyy-MM-dd hh:mm:ss");
  return "";
}

var types = [ {
  id : 1,
  text : '邮件模板'
}, {
  id : 2,
  text : '短信模板'
} ];

// 类型渲染
function onTypeRenderer(e) {
  for (var i = 0, l = types.length; i < l; i++) {
    var g = types[i];
    if (g.id == e.value)
      return g.text;
  }
  return "";
}
function search() {
  var searchKey = mini.get("key").getValue();

  grid.load({
    searchKey : searchKey
  });
}
function create() {
  OpenDialog(webRoot + "/templateController/toEditPage?type=" + "create" + "&id=" + "0", "新建邮件模板",
      grid, 850, 680);
}

function edit() {
  var row = grid.getSelected();
  if (row) {
    OpenDialog(webRoot + "/templateController/toEditPage?type=" + "view" + "&id=" + row.id,
        "编辑邮件模板", grid, 850, 680);
  } else {
    mini.alert("请选择一条记录!");
  }
}

function removeEmailTemplate() {
  var row = grid.getSelected();
  if (row) {
    $.ajax({
      url : webRoot + "/templateController/remove/" + row.id,
      type : "post",
      dataType : "json",
      contentType : "application/json",
      success : function(data) {
        if (data.success == true) {
          mini.alert("删除成功！");
        } else {
          mini.alert("删除失败！" + data.msg);
        }
        grid.reload();
      },
      error : function(jqXHR, textStatus, errorThrown) {
        alert(jqXHR.responseText);
      }
    });
  } else {
    mini.alert("请选择一条记录!");
  }
}