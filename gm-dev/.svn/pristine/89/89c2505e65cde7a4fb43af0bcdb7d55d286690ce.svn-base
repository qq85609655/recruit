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
  <div class="mini-splitter" style="width: 100%; height: 100%;">

    <div size="200" showCollapseButton="true">
      <div class="mini-toolbar"
        style="padding: 2px; border-top: 0; border-left: 0; border-right: 0;">
        <input id="key" class="mini-textbox" onenter="onKeyEnter" /> <a class="mini-button"
          iconCls="icon-search" plain="true" onclick="searchRaw()">查找</a>
      </div>
      <div class="mini-fit">
        <ul id="rawTree" class="mini-tree" url="rawMaterial/partClassTree" style="width: 100%;"
          showTreeIcon="true" textField="name" idField="id" parentField="parentId"
          resultAsTree="false">
        </ul>
      </div>
    </div>
    <div showCollapseButton="true">
      <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
        <div title="center" region="center" bodyStyle="overflow:hidden;">
          <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
            <table style="width: 100%;">
              <tr>
                <td style="width: 100%;"><a class="mini-menubutton" plain="true"
                  menu="#popupMenu">操作</a> <a class="mini-menubutton" plain="true"
                  menu="#popupMenuExport">导出</a> <a class="mini-button" iconCls="icon-upload"
                  onclick="uploadPart('2')" plain="true">level 2导入</a> <a class="mini-button"
                  iconCls="icon-upload" onclick="uploadPart('3')" plain="true">level 3导入</a> <input
                  id="excelDoc" name="excelDoc" type="file" /></td>
              </tr>
              <tr>
                <td>
                  <!-- 
              <a class="mini-button" iconCls="icon-download" onclick="downloadTemplate('2')" plain="true">level 2模版导出</a>
              <a class="mini-button" iconCls="icon-upload" onclick="downloadTemplate('3')" plain="true">level 3模版导出</a>-->
                  创建日期：<input id="dateBegin" emptyText="开始日期" class="mini-datepicker"
                  allowInput="false" showTodayButton="false" ondrawdate="onDrawDateBegin" /> 至<input
                  id="dateEnd" emptyText="结束日期" class="mini-datepicker" allowInput="false"
                  showTodayButton="false" ondrawdate="onDrawDateEnd" />
                </td>
              </tr>
              <tr>
                <td><input id="partName" class="mini-textbox" onenter="onKeyEnter"
                  emptyText="物料名称" selectOnFocus="true" /> <input id="searchKey"
                  class="mini-textbox" onenter="onKeyEnter" emptyText="料号" selectOnFocus="true" />
                  <input id="ownerName" class="mini-textbox" style="width: 70px"
                  onenter="onKeyEnter" emptyText="创建人姓名" selectOnFocus="true" /> <input
                  id="department" class="mini-textbox" style="width: 70px" onenter="onKeyEnter"
                  emptyText="创建人部门" selectOnFocus="true" /> <a class="mini-button"
                  iconCls="icon-search" plain="true" onclick="search">查询</a></td>
              </tr>
              <tr>
                <td><input id="partNoInput" class="mini-buttonedit" style="width: 402px"
                  allowInput="true" onbuttonclick="selectPartNo(this)" /> <a class="mini-button"
                  iconCls="icon-search" plain="true" onclick="anySearch">多料号查询</a></td>
              </tr>
            </table>
          </div>

          <!--menu-->
          <ul id="popupMenu" class="mini-menu" style="display: none;">
            <li iconCls="icon-find" onclick="showPieChart" plain="true">物料分布</li>
            <span class="separator"></span>
            <li iconCls="icon-add" onclick="create" plain="true">新增level 1</li>
            <span class="separator"></span>
            <li iconCls="icon-add" onclick="createLevel2" plain="true">新增level 2</li>
            <span class="separator"></span>
            <li iconCls="icon-add" onclick="createLevel3" plain="true">新增level 3</li>
            <span class="separator"></span>
            <li iconCls="icon-edit" onclick="modify" plain="true">编辑分类</li>
            <span class="separator"></span>
            <li iconCls="icon-remove" onclick="remove" plain="true">删除分类</li>
          </ul>
          <ul id="popupMenuExport" class="mini-menu" style="display: none;">
            <li iconCls="icon-download" onclick="export6171" plain="true">导出全部备品耗材</li>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoByClass" plain="true">选中分类导出料号</li>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoById" plain="true">选中料号导出</li>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoByAnySearch" plain="true">多料号查询结果导出</li>
          </ul>

          <div class="mini-fit">
            <div id="partNoGrid" class="mini-datagrid" style="width: 100%; height: 100%"
              sizeList="[25,50,100]" pageSize="25" url="partNo/datagrid?showPager=true" idField="id"
              allowResize="true" multiSelect="true">
              <div property="columns">
                <div type="checkcolumn" width="5"></div>
                <div field="partNo" width="25" headerAlign="center" allowSort="true">料号</div>
                <div field="partName" width="25" headerAlign="center" allowSort="true">物料名称</div>
                <div field="partNoStatus" width="10" headerAlign="center" allowSort="true">状态</div>
                <div field="createCode" width="20" headerAlign="center" allowSort="true">创建人工号</div>
                <div field="createName" width="20" headerAlign="center" allowSort="true">创建人姓名</div>
                <div field="department" width="30" headerAlign="center" allowSort="true">创建人部门</div>
                <div field="createTime" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" width="20"
                  allowSort="true">创建时间</div>
                <div field="telephone" width="20" headerAlign="center" allowSort="true">联系方式</div>
              </div>
            </div>
          </div>
        </div>
        <div showHeader="false" region="east" width="320" maxWidth="350" minWidth="200"
          bodyStyle="overflow:hidden;">
          <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
            <table style="width: 100%;">
              <tr>
                <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKeyPro"
                  class="mini-textbox" onenter="onKeyEnter" emptyText="请输入属性值" selectOnFocus="true" />
                  <a class="mini-button" iconCls="icon-search" plain="true" onclick="searchPro">查询</a></td>
              </tr>
            </table>
          </div>
          <div id="propertyGrid" class="mini-datagrid" style="width: 98%; height: 93%"
            allowCellSelect="true" idField="id" url="propertyValue/proValuedatagrid"
            allowResize="true" showPager="false" allowCellWrap="true">
            <div property="columns">
              <div field="propertyDisName" width="25" headerAlign="center" allowSort="true">属性名</div>
              <div field="propertyValue" width="30" headerAlign="center" allowSort="true">
                真实值<input property="editor" class="mini-textbox" style="width: 100%;" minWidth="200" />
              </div>
              <div field="propertyValueText" width="30" headerAlign="center" allowSort="true">显示值</div>
              <div field="propertyType" width="15" headerAlign="center" allowSort="true">唯一性</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <script>
      mini.parse();

      var hostPath = "${basePath}";
      var propertyGrid = mini.get("propertyGrid");
      var rawTree = mini.get("rawTree");
      var partNoGrid = mini.get("partNoGrid");
      partNoGrid.load();

      var searchKeyObj = mini.get("searchKey");
      var ownerNameObj = mini.get("ownerName");
      var partNameObj = mini.get("partName");
      var dateBeginObj = mini.get("dateBegin");
      var dateEndObj = mini.get("dateEnd");
      var searchKeyProObj = mini.get("searchKeyPro");
      var departmentObj = mini.get("department");

      rawTree.on("nodeselect", function(e) {
        if (e.isLeaf) {
          partNoGrid.load({
            partId : e.node.id
          });
        } else {
          partNoGrid.load({
            partClassId : e.node.id
          });
        }
      });

      function create() {
        OpenDialog("partClass/create/", "新建", rawTree);
      }
      //新增level2
      function createLevel2() {
        var node = rawTree.getSelectedNode();
        if (node) {
          if (rawTree.getLevel(node) == 0) {
            OpenDialog("partClass/createLevel2/" + node.id, "新建Level2", rawTree);
          } else {
            ShowWarnTip("请选择Level 1");
          }
        } else {
          ShowWarnTip("请选择Level 1");
        }
      }
      //新增level3
      function createLevel3() {
        var node = rawTree.getSelectedNode();
        if (node) {
          if (rawTree.getLevel(node) == 1) {
            OpenDialog("partClass/createLevel3/" + node.id, "新建Level3", rawTree);
          } else {
            ShowWarnTip("请选择Level 2");
          }
        } else {
          ShowWarnTip("请选择Level 2");
        }
      }
      function modify() {
        var node = rawTree.getSelectedNode();

        if (node) {
          if (rawTree.isLeaf(node)) {
            // 编辑level3;
            OpenDialog("part/modify/" + node.id, "编辑", null);
          } else {
            // 编辑level1/2;
            OpenDialog("partClass/modify/" + node.id, "编辑", null);
          }
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function remove() {
        var data = rawTree.getSelected();
        if (data) {
          var id = data.id;
          mini.confirm("确定删除记录？<br>", "删除", function(action) {
            if (action == "ok") {
              SaveData("partClass/remove/" + id, "", function(e) {
                ShowActionTip(e);
                rawTree.reload();
              });
              SaveData("part/remove/" + id, "", function(e) {
                ShowActionTip(e);
                rawTree.reload();
              });
            }
          });
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function searchRaw() {
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

      function search() {
        searchKeyProObj.setValue("");
        var searchKey = searchKeyObj.getValue();
        var ownerName = ownerNameObj.getValue();
        var partName = partNameObj.getValue();
        var dateBegin = dateBeginObj.getValue();
        var dateEnd = dateEndObj.getValue();
        var department = departmentObj.getValue();
        if (dateBegin != "") {
          dateBegin = dateBegin.Format("yyyy-MM-dd HH:mm:ss");
        }
        if (dateEnd != "") {
          dateEnd = dateEnd.Format("yyyy-MM-dd HH:mm:ss");
        }
        partNoGrid.load({
          searchKey : searchKey,
          ownerName : ownerName,
          partName : partName,
          beginDate : dateBegin,
          endDate : dateEnd,
          department : department
        });
      }

      function onKeyEnter(e) {
        search();
      }

      function downloadTemplate(level) {
        window.location.href = hostPath + "materialManage/downloadPartTemplate/" + level;
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
              rawTree.reload();
              mini.alert(data.msg, "提示");
            },
            error : function(data) {
              mini.alert(data.msg, "提示");
            }
          });
        }
      }

      function exportPartNoById() {
        var rows = partNoGrid.getSelecteds();
        var partNoId = "";
        if (rows.length < 1) {
          mini.alert("请先选中一条或多条数据");
          return;
        }
        for (var i = 0; i < rows.length; i++) {
          partNoId = partNoId + rows[i].id + ",";
        }
        var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
        $.ajax({
          url : hostPath + "partNo/exportPartNoById/partNoId/" + partNoId,
          type : "post",
          dataType : 'json', //数据格式为json
          success : function(data) {
            mini.hideMessageBox(messageid);
            if (data.success == false) {
              mini.alert(data.msg);
            } else {
              window.location.href = hostPath + "partNo/exportFile?filePath=" + data.msg;
            }
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function exportPartNoByClass() {
        var partClass = rawTree.getSelected();
        if (partClass) {
          var partClassId = partClass.id;
          var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
          $.ajax({
            url : hostPath + "partNo/exportPartNoByClass/partClassId/" + partClassId,
            type : "post",
            dataType : 'json', //数据格式为json
            success : function(data) {
              mini.hideMessageBox(messageid);
              if (data.success == false) {
                mini.alert(data.msg);
              } else {
                window.location.href = hostPath + "partNo/exportFile?filePath=" + data.msg;
              }
            },
            error : function(msg) {
              mini.alert(msg, "error", CloseWindow);
            }
          });
        } else {
          mini.alert("请先选择一个物料分类");
          return;
        }
      }

      function exportPartNoByAnySearch() {
        var partNos = mini.get("partNoInput").getText();
        if (partNos == "") {
          mini.alert("请先在查询框输入一个或多个料号");
          return;
        }

        var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
        $.ajax({
          url : hostPath + "partNo/exportPartNoByAnySearch",
          type : "post",
          data : {
            partNos : partNos
          },
          dataType : 'json',
          success : function(data) {
            mini.hideMessageBox(messageid);
            if (data.success == false) {
              mini.alert(data.msg);
            } else {
              window.location.href = hostPath + "partNo/exportFile?filePath=" + data.msg;
            }
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function export6171() {
        var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
        $.ajax({
          url : hostPath + "partNo/export6171",
          type : "post",
          dataType : 'json',
          success : function(data) {
            mini.hideMessageBox(messageid);
            if (data.success == false) {
              mini.alert(data.msg);
            } else {
              window.location.href = hostPath + "partNo/exportFile?filePath=" + data.msg;
            }
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function searchPro() {
        searchKeyObj.setValue("");
        ownerNameObj.setValue("");
        partNameObj.setValue("");
        dateBeginObj.setValue("");
        dateEndObj.setValue("");
        var searchKeyPro = searchKeyProObj.getValue();
        partNoGrid.load({
          searchKeyPro : searchKeyPro
        });
      }

      partNoGrid.on("selectionchanged", function(e) {
        var partNoData = e.sender;
        var record = partNoData.getSelected();
        propertyGrid.load({
          partNoId : record.id,
          sortField : "propertyName",
          sortOrder : "asc"
        });
      });

      function onDrawDateBegin(e) {
        var date = e.date;
        var d = mini.get("dateEnd").getValue();

        if (d != "" && date.getTime() > d) {
          e.allowSelect = false;
        }
      }

      function onDrawDateEnd(e) {
        var date = e.date;
        var d = mini.get("dateBegin").getValue();

        if (d != "" && date.getTime() < d) {
          e.allowSelect = false;
        }
      }

      Date.prototype.Format = function(fmt) {
        var o = {
          "M+" : this.getMonth() + 1, //月份 
          "d+" : this.getDate(), //日 
          "H+" : this.getHours(), //小时 
          "m+" : this.getMinutes(), //分 
          "s+" : this.getSeconds(), //秒 
          "q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
          "S" : this.getMilliseconds()
        //毫秒 
        };
        if (/(y+)/.test(fmt))
          fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for ( var k in o)
          if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k])
                .substr(("" + o[k]).length)));
        return fmt;
      }

      function selectPartNo(ob) {
        mini.open({
          url : "webpage/com/csot/gm/materialManage/manySelect.jsp",
          title : "选择列表",
          width : 540,
          height : 500,
          onload : function() {
            var iframe = this.getIFrameEl();
            // 已经选择的条件
            var selected = ob.getText();
            iframe.contentWindow.SetData("料号", selected);
          },
          ondestroy : function(action) {
            if (action == "ok") {
              var iframe = this.getIFrameEl();
              var data = iframe.contentWindow.GetData();
              data = mini.clone(data); // 必须
              if (data) {
                ob.setText(data.result);
              }
            }
          }
        });
      }

      function anySearch() {
        searchKeyObj.setValue("");
        ownerNameObj.setValue("");
        partNameObj.setValue("");
        dateBeginObj.setValue("");
        dateEndObj.setValue("");
        searchKeyProObj.setValue("");
        var partNos = mini.get("partNoInput").getText();
        partNoGrid.load({
          partNos : partNos
        });
      }

      function showPieChart() {
        mini.open({
          url : "webpage/com/csot/gm/materialManage/partPieChart.jsp",
          title : "PieChart",
          width : 580,
          height : 450,
        });
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>