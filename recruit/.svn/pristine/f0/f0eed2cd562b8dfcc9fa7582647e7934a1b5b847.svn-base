var type = "1";
mini.parse();
var grid = mini.get("datagrid1");
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

function GetTemplateData() {
  var row = grid.getSelected();
  if(row){
    var data = {};
    data.id = row.id;
    data.text = row.title;
    data.context = row.context;
    return data ;
  }else{
    showWarnTip("请选择一条记录");
  }
  
  return null;
}

function onOk() {
  CloseWindow("ok");
}
function onCancel() {
  CloseWindow("cancel");
}