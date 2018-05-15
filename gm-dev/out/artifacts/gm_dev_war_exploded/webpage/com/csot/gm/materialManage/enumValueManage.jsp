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
<script src="${basePath}resources/js/pagertree.js"></script>
</head>
<body>
  <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
    <div title="center" region="center" bodyStyle="overflow:hidden;">
      <div class="mini-toolbar" style="border-bottom: 0; padding: 0px;">
        <table style="width: 100%;">
          <tr>
            <td style="width: 100%;"><a class="mini-button" iconCls="icon-add"
              onclick="addEnumType()" plain="true" tooltip="新增枚举类">新增枚举类</a> <a class="mini-button"
              iconCls="icon-add" onclick="addEnumValue()" plain="true" tooltip="新增枚举值">新增枚举值</a> <a
              class="mini-button" iconCls="icon-remove" onclick="removeRow()" plain="true">删除</a> <a
              class="mini-button" iconCls="icon-edit" onclick="modify()" plain="true">编辑</a> <span
              class="separator"></span> <!-- <a class="mini-button" iconCls="icon-node" onclick="checkMember()" plain="true">查看成员</a>  -->
              <a class="mini-button" iconCls="icon-upload" onclick="uploadEnum('enum')" plain="true">枚举值导入</a>
              <!-- <a class="mini-button" iconCls="icon-edit" onclick="mapEnum()" plain="true">增加下拉联动</a>  -->
              <input id="excelDoc" name="excelDoc" type="file" />
              <a class="mini-button" iconCls="icon-download" onclick="exportEnumByTemplate" plain="true">导出枚举值</a></td>
            <td style="white-space: nowrap;"><input id="key" class="mini-textbox" emptyText=""
              style="width: 150px;" onenter="onKeyEnter" /> <a class="mini-button"
              onclick="search()">查询</a></td>
          </tr>
        </table>
      </div>
      <div class="mini-fit">
        <div id="enumTypeGrid" class="mini-datagrid" style="width: 100%; height: 100%"
          sizeList="[25,50,100]" pageSize="25" url="enumType/datagrid?showPager=true" idField="id"
          allowResize="true">
          <div property="columns">
            <div type="indexcolumn" width="2"></div>
            <div field="enumName" width="25" headerAlign="center" allowSort="true">枚举类名</div>
          </div>
        </div>
      </div>
    </div>
    <div showHeader="false" region="east" width="400" maxWidth="500" minWidth="300"
      bodyStyle="overflow:hidden;">
      <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
        <table style="width: 100%;">
          <tr>
            <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKeyPro"
              class="mini-textbox" emptyText="请输入下拉值" onenter="searchPro()" selectOnFocus="true" /> <a
              class="mini-button" iconCls="icon-search" plain="true" onclick="searchPro()">查询</a></td>
          </tr>
        </table>
      </div>
      <div id="enumValueGrid" class="mini-datagrid" style="width: 96%; height: 93%" idField="id"
        url="enumValue/enumValuedatagrid" allowResize="true" showPager="false" allowCellWrap="true">
        <div property="columns">
          <div field="enumValue" width="40" headerAlign="center" allowSort="true">真实值</div>
          <div field="enumText" width="40" headerAlign="center" allowSort="true">显示值</div>
        </div>
      </div>
    </div>
  </div>

  <script>
      mini.parse();
      var hostPath = "${basePath}";
      var enumTypeGrid = mini.get("enumTypeGrid");
      var enumValueGrid = mini.get("enumValueGrid");

      enumTypeGrid.load();

      function searchPro() {
        var enumValue = mini.get("searchKeyPro").getValue();
        var enumTypeRow = enumTypeGrid.getSelected();
        if (enumTypeRow) {
          enumValueGrid.load({
            enumTypeId : enumTypeRow.id,
            enumValue : enumValue,
            sortField : "enumValue",
            sortOrder : "asc"
          });
        } else {
          ShowWarnTip("请选择一条枚举类");
        }
      }

      function search() {
        var key = mini.get("key").getValue();
        enumTypeGrid.load({
          searchKey : key
        });
      }

      function onKeyEnter(e) {
        search();
      }

      enumTypeGrid.on("selectionchanged", function(e) {
        var enumTypeData = e.sender;
        var record = enumTypeData.getSelected();
        enumValueGrid.load({
          enumTypeId : record.id,
          sortField : "enumValue",
          sortOrder : "asc"
        });
      });

      function addEnumType() {
        OpenDialog("enumType/create", "新建", enumTypeGrid);
      }
    
      function addEnumValue() {
        var row = enumTypeGrid.getSelected();
        if (row) {
          mini.open({
            url : "enumValue/create/" + row.id,
            title : "新增下拉值",
            width : 540,
            height : 500,
            ondestroy : function(action) {
              if (action.success) {
                mini.alert(action.msg);
                var iframe = this.getIFrameEl();
                var data = iframe.contentWindow.GetData();
                data = mini.clone(data); //必须。克隆数据。
                var enumTypeRow = enumTypeGrid.getSelected();
                enumValueGrid.load({
                  enumTypeId : enumTypeRow.id,
                  sortField : "enumValue",
                  sortOrder : "asc"
                }, function(e) {
                  // 滚动到刚添加的值得地方
                  var row = enumValueGrid.findRow(function(row) {
                    if (row.enumText == data) {
                      return true;
                    }
                  });
                  enumValueGrid.select(row, true);
                  enumValueGrid.scrollIntoView(row);
                });
              }
            }
          });
        } else {
          ShowWarnTip("请选择一条枚举类");
        }
      }

      function removeRow() {
        var enumTypeRow = enumTypeGrid.getSelected();
        var enumValueRow = enumValueGrid.getSelected();
        if (enumValueRow || enumTypeRow) {
          // 删除枚举属性值;
          if (enumValueRow) {
            mini.confirm("确定删除记录？<br>", "删除", function(action) {
              if (action == "ok") {
                SaveData("enumValue/remove/" + enumValueRow.id, "", function(e) {
                  ShowActionTip(e);
                  enumValueGrid.reload();
                });
              }
            });
            // 删除枚举类及以下的枚举值(检查该枚举类被是否有被用到?)
          } else {
            mini.confirm("确定删除记录？<br><span style='color:red;'>删除会将所有该类的所有属性值一起删除！</span>", "删除",
                function(action) {
                  if (action == "ok") {
                    SaveData("enumType/remove/" + enumTypeRow.id, "", function(e) {
                      ShowActionTip(e);
                      enumTypeGrid.reload();
                    });
                  }
                });
          }

        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function modify() {
        var enumTypeRow = enumTypeGrid.getSelected();
        var enumValueRow = enumValueGrid.getSelected();
        if (enumValueRow || enumTypeRow) {
          if (enumValueRow) {
            // 编辑属性值;
            OpenDialog("enumValue/modify/" + enumValueRow.id, "编辑", enumValueGrid);
          } else {
            // 编辑属性类名;
            OpenDialog("enumType/modify/" + enumTypeRow.id, "编辑", enumTypeGrid);
          }
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function mapEnum() {
        var node = enumValueTree.getSelectedNode();
        if (node) {
          if (enumValueTree.isLeaf(node)) {
            OpenDialog("valueEnumM/valueEnumMEdit/" + node.id, "编辑", enumValueTree);
          } else {
            ShowWarnTip("请选择枚举值进行联动配置");
          }
        } else {
          ShowWarnTip("请选择枚举值进行联动配置");
        }
      }

      function checkMember() {
        var row = enumValueTree.getSelected();
        if (row) {
          if (!row.enumValue) {
            memberDatagrid.load({
              enumTypeId : row.enumTypeId
            });
          } else {
            ShowWarnTip("请选择一条枚举类");
          }
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function uploadEnum(level) {
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
              if (data.success) {
                mini.alert(data.msg + ",请查看日志管理!", "提示");
              } else if (data.msg == "上传出错") {
                mini.alert(data.msg + ",请查看日志管理!", "提示");
              } else {
                mini.alert(data.msg, "提示");
              }
            },
            error : function(data) {
              mini.alert(data.msg, "提示");
            }
          });
        }
      }
      
      function exportEnumByTemplate() {
        var enumTypeRow = enumTypeGrid.getSelected();
        if (enumTypeRow) {
          window.location.href = hostPath + "enumValue/exportEnumValueByTemplate/" + enumTypeRow.id;
        } else {
          mini.alert("请选择一条枚举类");
        }
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>