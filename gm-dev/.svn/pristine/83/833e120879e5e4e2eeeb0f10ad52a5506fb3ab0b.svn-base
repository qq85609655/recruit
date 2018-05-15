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
<div class="mini-fit">  
  <div id="layout1" class="mini-layout" style="width: 100%; height: 100%; margin: 0px">
      <div title="center" region="center">
      <div id="treeToolbar" class="mini-toolbar" style="padding:2px">
        <table style="width: 100%;">
          <tr>
            <td>
              <input id="uid" class="mini-hidden" value="${uid}" />
              <input id="partType" class="mini-hidden" value="${partType}" />
              <input id="userCode" class="mini-hidden" value="${userCode}" />
              <!-- 
              <span style="padding-left:10px; padding-right:10px">${partType}:</span>
               -->
              <input id="key" class="mini-textbox" emptyText="请输入过滤条件" onenter="onKeyEnter" />
              <a class="mini-button" iconCls="icon-search" plain="true" onclick="search()"></a> 
              <a class="mini-button" iconCls="icon-reload" plain="true" onclick="reset()"></a>  
            </td>
          </tr>
        </table>
      </div>
      <div class="mini-fit">
      <!--Tree-->
      <ul id="rawTree" class="mini-tree" url="rawMaterial/partClassTree?partType=${partType}" expandOnNodeClick="true"
        style="width:690px; height:410px; padding:5px;"  showTreeIcon="true" textField="name" idField="id"
        parentField="parentId" resultAsTree="false" onnodeselect="onNodeSelect">
      </ul>
      </div>
      </div>
  </div>
  </div>

  <script type="text/javascript">
    mini.parse();
    
    var base = document.getElementsByTagName("base")[0].getAttribute("href"); //IE下base标签不兼容
    var tree = mini.get("rawTree");
    var uid = mini.get("uid").getValue();
    var partType = mini.get("partType").getValue();
    var userCode = mini.get("userCode").getValue();
    
    function showTab(node) {
      
        var partId = node.id;
        var lv2Id = tree.getParentNode(node).id;
        if (lv2Id) {
          var lv1Id = tree.getParentNode(tree.getParentNode(node)).id;
          window.location.href = base + node.url + "/partId/" + partId + "/uid/" + uid + "/partType/" + partType + "/userCode/" + userCode + "/ppId/" + lv1Id + "," + lv2Id;
        } else {
          window.location.href = base + node.url + "/partId/" + partId + "/uid/" + uid + "/partType/" + partType + "/userCode/" + userCode + "/ppId/" + ",";
        }
    }

    function onNodeSelect(e) {
    	
        var node = e.node;
        var isLeaf = e.isLeaf;

        if (isLeaf) {
            showTab(node);
        }
    }

    function search() {
      var key = mini.get("key").getValue();
      if (key == "") {
        tree.clearFilter();
      } else {
        key = key.toLowerCase();
        tree.filter(function(node) {
          var text = node.name ? node.name.toLowerCase() : "";
          if (text.indexOf(key) != -1) {
            return true;
          }
        });
        tree.expandAll();
      }
    }

    function reset() {
      tree.clearFilter();
      tree.load("rawMaterial/partClassTree?partType=${partType}");
      // tree.collapseAll();
      // tree.expandLevel(0);
    }

    function onKeyEnter(e) {
      search();
    }
        
  </script>

  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>