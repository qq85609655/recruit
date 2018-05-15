<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/webpage/common.jsp"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>邮件模板管理</title>
<style>
.mini-grid-rows-view {
  height: auto;
}

.mini-grid-emptyText {
  padding: 0px !important;
  font-size: 17px !important;
}

.tool-bar {
  margin-bottom: 10px;
}
</style>
</head>
<body>
  <div>
    <div class="account-content">
      <div class="blue radius">
        <div class="table-operate">
          <input id="key" class="mini-textbox" emptyText="请输入模板名称" style="width: 150px;"
            onenter="search()" /> 
            <a class="mini-button" onclick="search()">查询</a> 
            <input id="type" class="mini-hidden" />
          </td>
        </div>
        <div class="table-operate">
          <input type="button" class="button radius btn" id="ok" onclick="onOk()" value="确定" /> 
          <input type="button" class="button radius btn" id="cancel" onclick="onCancle()" value="取消" />
        </div>
        <div id="datagrid1" class="mini-datagrid"
          url="${webRoot}/templateController/templateData?showPager=true" idField="id"
          sizeList="[5,10,20,50]" pageSize="10" allowResize="true">
          
          <div property="columns">
            <div type="checkcolumn" width="30"></div>
            <div field="title" allowSort="true" width="150">邮件模板名称</div>
            <div field="type" width="100" allowSort="true" renderer="onTypeRenderer">模板类型</div>
            <div field="updateDate" width="150" allowSort="true" renderer="onDateRenderer">最后修订时间</div>
            <div field="creator" width="100" allowSort="true">修订者</div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script type="text/javascript">
      mini.parse();
      var grid = mini.get("datagrid1");
      //只加载邮件模板
      grid.load({
        type : "1"
      });
      removeLoad();
      grid.sortBy("updateDate", "desc");
      var types = [ {
        id : 1,
        text : '邮件模板'
      }, {
        id : 2,
        text : '短信模板'
      } ];

      // 模板类型渲染
      function onTypeRenderer(e) {
        for (var i = 0, l = types.length; i < l; i++) {
          var g = types[i];
          if (g.id == e.value)
            return g.text;
        }
        return "";
      }
      //日期格式渲染
      function onDateRenderer(e) {
        var value = e.value;
        if (value)
          return new Date(value).format("yyyy-MM-dd hh:mm:ss");
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
        if (row) {
          var data = {};
          data.id = row.id;
          data.text = row.title;
          data.subject = row.subject;
          data.context = row.context;
          return data;
        } else {
          showWarnTip("请选择一条记录");
        }

        return null;
      }

      function onOk() {
        CloseWindow("ok");
      }

      function onCancle(e) {
        CloseWindow("close");
      }
    </script>
</body>
</html>