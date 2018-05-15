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
      <div id="tree">
      <!--Tree-->
      <ul id="rawTree" class="mini-tree" url="rawMaterial/partClassTree?partType=${partType}" expandOnNodeClick="true"
        style="width:690px; height:400px; padding:2px;"  showTreeIcon="true" textField="name" idField="id"
        parentField="parentId" resultAsTree="false" onnodeselect="onNodeSelect">
      </ul>
      </div>

        <div>
          <table style="width: 100%; height: 100%;background-color: red">
            <tr>
              <td>
                <span style="font-size: 26px; font-family: 微软雅黑;font-weight: bold; color: white">Dear All：华星料号申请系统预计将于2017.10.31切换至网页版的外购MDM系统，
                  届时PLM系统以及自有MDM系统（即当前网页）将不再用于料号申请，敬请知悉。
                  料号管理中央单位将按期邀请各单位参加系统培训、进行系统测试。
                </span>
              </td>
            </tr>
          </table>

          <%--<table style="width: 100%; background-color: #9b9b9b">
            <tr>
              <td style="width: 50%; padding-left: 4px; padding-top: 2px">
                <span style="color: #047d65; font-family: 微软雅黑; font-size: 14px;">
                  <p>
                  &nbsp;&nbsp;All：华星料号申请系统将于2017.10.31切换至网页版的外购MDM系统，
                  届时PLM系统以及自有MDM系统（即当前网页）将不再用于料号申请，敬请知悉。
                  料号管理中央单位将按期邀请各单位参加系统培训、进行系统测试。
                </span>
              </td>
              <td style="width: 40%; padding-left: 70px">
                <div class="time" style="font-size: 40px; font-weight: bold; font-family: 'Calisto MT'; color: red; height: 65px">
                  <span id="t_d">00天</span>
                  <span id="t_h">00时</span>
                  <p>
                  <span id="t_m">00分</span>
                  <span id="t_s">00秒</span>
                </div>
              </td>
            </tr>
          </table>--%>
        </div>
      </div>
  </div>
  </div>

  <script type="text/javascript">
    mini.parse();

    /*function GetRTime(){
      var EndTime= new Date('2017/11/01 00:00:00');
      var NowTime = new Date();
      var t =EndTime.getTime() - NowTime.getTime();
      var d=0;
      var h=0;
      var m=0;
      var s=0;
      if(t>=0){
        d=Math.floor(t/1000/60/60/24);
        h=Math.floor(t/1000/60/60%24);
        m=Math.floor(t/1000/60%60);
        s=Math.floor(t/1000%60);
      }


      document.getElementById("t_d").innerHTML = d + "天";
      document.getElementById("t_h").innerHTML = h + "时";
      document.getElementById("t_m").innerHTML = m + "分";
      document.getElementById("t_s").innerHTML = s + "秒";
    }
    setInterval(GetRTime,0);*/
    
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