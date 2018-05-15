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
<script src="${basePath}resources/js/ajaxfileupload.js"></script>
</head>
<body>
  <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
    <div title="center" region="center" bodyStyle="overflow:hidden;">
      <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
        <table style="width: 100%;">
          <tr>
            <td style="width: 100%;">
              <a class="mini-button" iconCls="icon-remove" onclick="test" plain="true">test</a>
            <a class="mini-button" iconCls="icon-remove" onclick="remove" plain="true">删除</a>
              <a class="mini-button" iconCls="icon-upload" onclick="uploadPart('massRemove')" plain="true">批量删除</a>
              <a class="mini-button" iconCls="icon-download" onclick="exportClean" plain="true">导出</a>
              </td>
            <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKey"
              class="mini-textbox" onenter="onKeyEnter" emptyText="请输入料号" selectOnFocus="true" />
               
              <a class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a>
              <!-- <a class="mini-button" iconCls="icon-upload" onclick="uploadPart('spec')" plain="true">规格清洗</a> -->
              <a class="mini-button" iconCls="icon-upload" onclick="uploadPart('brandSpec')" plain="true">品牌&规格清洗</a>
              <input id="excelDoc" name="excelDoc" type="file" /></td>
          </tr>
        </table>
      </div>
      <div class="mini-fit">
        <div id="cleanGrid" class="mini-datagrid" style="width: 100%; height: 100%"
          sizeList="[25,50,100]" pageSize="25" url="clean/datagrid?showPager=true" idField="id"
          allowResize="true" multiSelect="true">
          <div property="columns">
            <div type="checkcolumn" width="10"></div>
            <div field="status" width="10" headerAlign="center" allowSort="true">状态</div>
            <div field="partNo" width="25" headerAlign="center" allowSort="true">料号</div>
            <div field="brand" width="50" headerAlign="center" allowSort="true">品牌</div>
            <div field="spec" width="50" headerAlign="center" allowSort="true">规格</div>
            <div field="info" width="80" headerAlign="center" allowSort="true">备注</div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();
      var cleanGrid = mini.get("cleanGrid");
      cleanGrid.load();
      cleanGrid.sortBy("status", "asc");

      function test()
      {
        var objShell = new ActiveXObject("WScript.Shell");
        //objShell.Run("C:/Siemens/Teamcenter/OTWSIT/rac/portal.bat",0,true);
        objShell.Run("C:/PLM/Teamcenter/OTW8/rac/portal.bat",0,true);
      }

      function remove() {
        var rows = cleanGrid.getSelecteds();
        if (rows.length > 0) {
            if (confirm("确定删除选中记录？")) {
                var ids = [];
                for (var i = 0, l = rows.length; i < l; i++) {
                    var r = rows[i];
                    ids.push(r.id);
                }
                var id = ids.join(',');
                cleanGrid.loading("操作中，请稍后......");
                SaveData("clean/remove/" + id, "", function(e) {
                  ShowActionTip(e);
                  cleanGrid.reload();
                });
            }
        } else {
            alert("请选中一条记录");
        }
    }

      function search() {
        var searchKey = mini.get("searchKey").getValue();
        cleanGrid.load({
          searchKey : searchKey
        });
      }

      function onKeyEnter(e) {
        search();
      }
      
      function uploadPart(level) {
        var file = $("#excelDoc").val();
        if (!file) {
          mini.alert("请选择需上传的文件!");
        } else {
          var messageId = mini.loading("正在导入中!");
          $.ajaxFileUpload({
            url : "materialManage/upload/" + level,
            secureuri : false,
            fileElementId : 'excelDoc',
            dataType : "json",
            data : null,
            success : function(data) {
              mini.hideMessageBox(messageId);
              mini.alert(data.msg, "提示");
            },
            error : function(data) {
              mini.alert(data.msg, "提示");
            }
          });
        }
      }
      
      function exportClean() {
        var hostPath = "${basePath}";
        window.location.href = hostPath + "clean/exportClean";
      }
      
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>