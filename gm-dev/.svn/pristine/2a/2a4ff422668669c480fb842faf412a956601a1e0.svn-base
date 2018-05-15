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
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div showCollapseButton="true">
    <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
      <table style="width: 100%;">
        <tr>
          <td style="width: 100%;"><a class="mini-button" iconCls="icon-add" onclick="update()"
            plain="true">确定修改</a></td>
          <td colSpan="2"><input style="width: 375px;" id="level" class="mini-textbox"
            emptyText="料号分类" allowInput="false" /></td>
          <td style="white-space: nowrap;"><input id="key" class="mini-textbox"
            emptyText="请输入level3名称" style="width: 150px;" onenter="onKeyEnter()" /> <a
            class="mini-button" iconCls="icon-search" onclick="search()">查询</a></td>
        </tr>
      </table>
    </div>
    <form id="mainForm" class="mainform" method="post">
      <div style="width: 100%; height: 100%;">
        <ul id="rawTree" class="mini-tree" url="part/sparePartConTree"
          style="width: 680px; height: 410px; padding: 5px;" showTreeIcon="true" textField="name"
          idField="id" parentField="parentId" expandOnNodeClick="true" resultAsTree="false">
        </ul>
      </div>
    </form>
  </div>
  <%@ include file="/resources/context/lazyResource.jsp"%>
  <script type="text/javascript">
      mini.parse();
      var form = new mini.Form("#mainForm");
      var rawTree = mini.get("rawTree");

      // 将选中的料号所在分类带到分类树界面显示
      var level = mini.get("level");
      $.ajax({
        url : "partNo/getlevelByPartNoId/" + "${partNoId}",
        type : "post",
        dataType : 'json',
        success : function(data) {
          level.setValue(data.msg);
          return;
        },
        error : function(msg) {
          mini.alert(msg, "error", CloseWindow);
        }
      });

      var base = document.getElementsByTagName("base")[0].getAttribute("href"); //IE下base标签不兼容

      //////更新料号level3的值
      function update() {
        var node = rawTree.getSelectedNode();
        if (rawTree.isLeaf(node)) {
          //物料管理界面传进的料号id
          var partNoId = "${partNoId}";
          //选中的level3分类id
          var partId = node.id;

          $.ajax({
            url : "part/updatePartNoLevel3?partNoId=" + partNoId + "&partId=" + partId,
            type : "post",
            dataType : 'json',
            success : function(data) {
              mini.confirm("修改成功，是否退出？", "提示", function(action) {
                if (action == "cancel")
                  return;
                else {
                  CloseWindow("close", form);
                }
              });

              level.setValue(data.attributes.level);
            },
            error : function(data) {
              mini.alert(data.msg);
            }
          });
        } else {
          alert("请选择相应的level3!");
        }
      }

      function search() {
        var key = mini.get("key").getValue();
        if (key == "") {
          rawTree.clearFilter();
        } else {
          key = key.toLowerCase();
          rawTree.filter(function(node) {
            var text = node.name ? node.name.toLowerCase() : "";
            if (text.indexOf(key) != -1) {
              return true;
            }
          });
          rawTree.expandAll();
        }
      }

      function onKeyEnter() {
        search();
      }
    </script>

</body>
</html>