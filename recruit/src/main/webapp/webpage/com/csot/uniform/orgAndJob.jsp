<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>组角色列表</title>
<style>

.mini-treegrid {
border: 0px;
}
</style>
</head>
<body onload="removeLoad();">
  <div >
      <div class="co-right-main co-right-center">
        <div class="blue radius">
          <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 360px;">
            <div title="center" region="center" bodyStyle="overflow:hidden;">
              <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
                <table style="width: 100%;">
                  <tr>
                    <td style="width: 100%;font-size: 12px;">组织架构</td>
                    <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
                      class="mini-textbox" onenter="search" emptyText="请输入部门名称" selectOnFocus="true" />
                      <a class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
                  </tr>
                </table>
              </div>
              <div class="mini-fit">
                <div id="mainTreeGrid" class="mini-treegrid" style="width: 100%;"
                  url="/recruit/organizationController/datagrid" treeColumn="cOrgname" idField="cOrgcode" 
                  parentField="cOrgparentcode" 
                  resultAsTree="false" allowResize="false" expandOnLoad="0" selectOnLoad="true">
                  <div property="columns">
                    <div name="cOrgname" field="cOrgname" width="65" headerAlign="center">部门组织名称</div>
                  </div>
                </div>
              </div>
            </div>
            <div showHeader="false" region="east" width="360" maxWidth="500" minWidth="200"
              bodyStyle="overflow:hidden;">
              <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
                <table style="width: 100%;">
                  <tr>
                    <td style="width: 100%;font-size: 12px;">岗位信息</td>
                    <td style="white-space: nowrap; padding-right: 8px;"><input id="searchJobKey"
                      class="mini-textbox" onenter="searchJob" emptyText="请输入岗位名称" selectOnFocus="true" />
                      <a class="mini-button" iconCls="icon-search" plain="true" onclick="searchJob">查询</a></td>
                  </tr>
                </table>
              </div>
              <div class="mini-fit">
              <div id="jobGird" class="mini-datagrid" style="width: 100%;" 
                idField="id" url="/recruit/jobController/datagrid" allowResize="false" showPager="false">
                <div property="columns">
                  <div type="checkcolumn" width="10"></div>
                  <div field="cOrgname" width="80" headerAlign="center" >部门</div>
                  <div field="cJobname" width="80" headerAlign="center" >岗位名称</div>
                </div>
              </div>
              </div>
            </div>
          </div>
        </div>
        <div style="text-align: center; padding: 20px;">
          <a id="rtnBtn" class="mini-button" onclick="onCancel()"
            style="width: 80px; margin-right: 40px;">取消</a> <a class="mini-button"
            onclick="onOk()" style="width: 80px;">确定</a>
        </div>
      </div>
  </div>

  <script>
      mini.parse();
      var tree = mini.get("mainTreeGrid");
      tree.load();

      var jobGird = mini.get("jobGird");

      function search() {
        var searchKey = mini.get("searchKey").getValue();
        tree.load({
          searchKey : searchKey
        });
      }
      
      function searchJob(){
        var searchJobKey = mini.get("searchJobKey").getValue();
        if(searchJobKey){
          jobGird.load({
            searchKey : searchJobKey
          });
        }
      }

      tree.on("selectionchanged", function(e) {
        var groupGrid = e.sender;
        var record = groupGrid.getSelected();
        jobGird.load({
          orgCode : record.cOrgcode
        });
      });
      
      function CloseWindow(action) {
        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
        else window.close();
      }
      
      function onCancel(e) {
        CloseWindow("close");
      }
      
      function onOk() {
        CloseWindow("ok");
      }
      
      //跨页面调用,获取当前选择的岗位
      function GetData() {
        var row = jobGird.getSelected();
        return row;
      }

      
    </script>
</body>
</html>