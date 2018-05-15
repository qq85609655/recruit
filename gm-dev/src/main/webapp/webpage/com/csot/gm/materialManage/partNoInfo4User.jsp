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
      <div class="mini-fit">
        <ul id="rawTree" class="mini-tree" url="rawMaterial/partClassTree?partType=C4_SparePart"
          style="width: 100%;" showTreeIcon="true" textField="name" idField="id"
          parentField="parentId" resultAsTree="false">
        </ul>
      </div>
    </div>
    <div showCollapseButton="true">
      <div id="handlerMainLayout" class="mini-layout" style="width: 100%; height: 100%;">
        <div title="center" region="center" bodyStyle="overflow:hidden;">
          <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
            <table style="width: 100%;">
              <tr>
                <td style="width: 100%;"><a class="mini-button" iconCls="icon-node"
                  onclick="detail" plain="true">详细信息</a> <a class="mini-menubutton" plain="true"
                  menu="#popupMenu">查询结果导出</a> <a class="mini-menubutton" plain="true"
                  menu="#popupMenuHelp" style="float: right" iconCls="icon-tip">操作手册</a></td>
              </tr>
              <tr>
                <td style="white-space: nowrap; padding-right: 8px;">创建日期：<input id="dateBegin"
                  emptyText="开始日期" class="mini-datepicker" allowInput="false"
                  showTodayButton="false" ondrawdate="onDrawDateBegin" /> 至<input id="dateEnd"
                  emptyText="结束日期" class="mini-datepicker" allowInput="false"
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
                           allowInput="true" onbuttonclick="selectPartNo(this)" />
                  <a class="mini-button" iconCls="icon-search" plain="true" onclick="anySearch">多料号查询</a></td>
              </tr>
            </table>
          </div>

          <!--menu-->
          <ul id="popupMenu" class="mini-menu" style="display: none;">
            <li iconCls="icon-download" onclick="downloadExcel()" plain="true">批量创建模板导出</li>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoByClass('template')" plain="true">导出选中分类</li>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoById('template')" plain="true">选中料号导出信息</li>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoByProperty" plain="true">按照品牌/规格查询结果导出信息</li>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoByGroup" plain="true">按照日期/名称/料号/创建人/部门查询结果导出信息</li>
<%--            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoByTemplate" plain="true">按照模板导出品牌规格查询料号信息</li>--%>
            <span class="separator"></span>
            <li iconCls="icon-download" onclick="exportPartNoByAnySearch" plain="true">多料号查询结果导出</li>
          </ul>

          <ul id="popupMenuHelp" class="mini-menu" style="display: none;">
            <!-- <li iconCls="icon-tip" onclick="downloadOpHelp('bom')" plain="true">BOM材</li>
            <span class="separator"></span> -->
            <li iconCls="icon-tip" onclick="downloadOpHelp('spare')" plain="true">备品耗材</li>
          </ul>

          <div class="mini-fit">
            <div id="partNoGrid" class="mini-datagrid" style="width: 100%; height: 100%"
              sizeList="[20,50,100]" pageSize="20" url="partNo/userDatagrid?showPager=true"
              idField="id" allowResize="true" multiSelect="true">
              <div property="columns">
                <div type="checkcolumn" width="5"></div>
                <div field="partNo" width="25" headerAlign="center" allowSort="true">料号</div>
                <div field="partName" width="25" headerAlign="center" allowSort="true">物料名称</div>
                <div field="partNoStatus" width="15" headerAlign="center" allowSort="true">状态</div>
                <div field="createCode" width="20" headerAlign="center" allowSort="true">创建人工号</div>
                <div field="createName" width="20" headerAlign="center" allowSort="true">创建人姓名</div>
                <div field="department" width="25" headerAlign="center" allowSort="true">创建人部门</div>
                <div field="createTime" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" width="20"
                  allowSort="true">创建时间</div>
                <div field="telephone" width="20" headerAlign="center" allowSort="true">联系方式</div>
              </div>
            </div>
          </div>
        </div>
        <div showHeader="false" region="east" width="320" maxWidth="500" minWidth="300"
          bodyStyle="overflow:hidden;">
          <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
            <table style="width: 100%;">
              <tr>
                <td colSpan="2"><input style="width: 300px;" id="level" class="mini-textbox"
                  emptyText="料号分类" allowInput="false" /></td>
              </tr>
              <tr>
                <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKeyBrand"
                  class="mini-textbox" onenter="searchPro()" emptyText="请输入品牌" selectOnFocus="true" />
                  <input id="searchKeySpec" class="mini-textbox" onenter="searchPro()"
                  emptyText="请输入规格" selectOnFocus="true" /> <a class="mini-button"
                  iconCls="icon-search" plain="true" onclick="searchPro">查询</a></td>
              </tr>
            </table>
          </div>
          <div id="propertyGrid" class="mini-datagrid" style="width: 98%; height: 93%"
            allowCellSelect="true" idField="id" url="propertyValue/proValuedatagrid"
            allowResize="true" showPager="false" allowCellWrap="true">
            <div property="columns">
              <div field="propertyDisName" width="30" headerAlign="center" allowSort="true">属性名</div>
              <div field="propertyValue" width="40" headerAlign="center" allowSort="true">真实值</div>
              <div field="propertyValueText" width="40" headerAlign="center" allowSort="true">显示值</div>
              <div field="propertyType" width="20" headerAlign="center" allowSort="true">唯一性</div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();

      var hostPath = "${basePath}";
      var partNoGrid = mini.get("partNoGrid");
      var rawTree = mini.get("rawTree");
      var propertyGrid = mini.get("propertyGrid");

      var searchKeyObj = mini.get("searchKey");
      var ownerNameObj = mini.get("ownerName");
      var partNameObj = mini.get("partName");
      var dateBeginObj = mini.get("dateBegin");
      var dateEndObj = mini.get("dateEnd");
      var searchKeyBrandObj = mini.get("searchKeyBrand");
      var searchKeySpecObj = mini.get("searchKeySpec");
      var departmentObj = mini.get("department");

      partNoGrid.load({
        partType : "C4_SparePart,C4_Consumptive,C4_WXLH",
      });
      partNoGrid.sortBy("createTime", "desc");

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

      function detail() {
        var row = partNoGrid.getSelected();
        if (row) {
          OpenDialog("partNo/modify/" + row.id, "详细信息", partNoGrid, 650, 400);
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function search() {
        searchKeyBrandObj.setValue("");
        searchKeySpecObj.setValue("");
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
        //partType : "C4_SparePart,C4_Consumptive,C4_WXLH"
        });
      }

      function searchPro() {
        searchKeyObj.setValue("");
        ownerNameObj.setValue("");
        partNameObj.setValue("");
        dateBeginObj.setValue("");
        dateEndObj.setValue("");
        departmentObj.setValue("");
        var searchKeyBrand = searchKeyBrandObj.getValue();
        var searchKeySpec = searchKeySpecObj.getValue();
        partNoGrid.load({
          searchKeyBrand : searchKeyBrand,
          searchKeySpec : searchKeySpec,
        //partType : "C4_SparePart,C4_Consumptive,C4_WXLH"
        });
      }

      //导出批量新增模版
      function downloadExcel() {
        window.location.href = hostPath + "materialManage/downloadExcel";

      }
      function onKeyEnter(e) {
        search();
      }

      partNoGrid.on("selectionchanged", function(e) {
        var partNoData = e.sender;
        var record = partNoData.getSelected();
        propertyGrid.load({
          partNoId : record.id
        });

        // 显示料号所在分类
        var level = mini.get("level");
        $.ajax({
          url : "partNo/getlevelByPartNoId/" + record.id,
          type : "post",
          dataType : 'json',
          success : function(data) {
            level.setValue(data.msg);
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      });

      function exportPartNoById(type) {
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
          url : hostPath + "partNo/exportPartNoById?partNoId=" + partNoId + "&type=" + type,
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

      function exportPartNoByClass(type) {
        var partClass = rawTree.getSelected();
        if (partClass) {
          var partClassId = partClass.id;
          var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
          $.ajax({
            url : hostPath + "partNo/exportPartNoByClass?type=" + type + "&partClassId=" + partClassId,
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

      function exportPartNoByGroup() {
        var partNo = searchKeyObj.getValue();
        var ownerName = ownerNameObj.getValue();
        ownerName = encodeURIComponent(ownerName); // url传参非asc码必须先转码再传，否则会出现乱码
        var partName = partNameObj.getValue();
        partName = encodeURIComponent(partName);
        var dateBegin = dateBeginObj.getValue();
        var dateEnd = dateEndObj.getValue();
        var department = departmentObj.getValue();
        department = encodeURIComponent(department);
        if (dateBegin != "") {
          dateBegin = dateBegin.Format("yyyy-MM-dd HH:mm:ss");
        }
        if (dateEnd != "") {
          dateEnd = dateEnd.Format("yyyy-MM-dd HH:mm:ss");
        }

        if (partNo == "" && ownerName == "" && partName == "" && dateBegin == "" && dateEnd == ""
            && department == "") {
          mini.alert("请输入查询条件");
        } else {
          var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
          $.ajax({
            url : hostPath + "partNo/exportPartNoByGroup",
            type : "post",
            data : {
              partNo : partNo,
              ownerName : ownerName,
              partName : partName,
              beginDate : dateBegin,
              endDate : dateEnd,
              department : department,
              // type : "template"
            },
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
      }

      function exportPartNoByProperty() {
        var brand = searchKeyBrandObj.getValue();
        brand = encodeURIComponent(brand);
        var spec = searchKeySpecObj.getValue();
        spec = encodeURIComponent(spec);
        if (brand == "" && spec == "") {
          mini.alert("请输入查询条件");
        } else {
          var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
          $.ajax({
            url : hostPath + "partNo/exportPartNoByProperty",
            type : "post",
            data : {
              brand : brand,
              spec : spec,
              type : "template"
            },
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
      }

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

      function downloadOpHelp(type) {
        window.location.href = hostPath + "materialManage/exportHelpOp/" + type;
      }
      
      function exportPartNoByTemplate() {
        var brand = searchKeyBrandObj.getValue();
        brand = encodeURIComponent(brand);
        var spec = searchKeySpecObj.getValue();
        spec = encodeURIComponent(spec);
        if (brand == "" && spec == "") {
          mini.alert("请输入查询条件");
        } else {
          //var messageid = mini.loading("DownLoading, Please wait ...", "DownLoading");
          window.location.href = hostPath + "partNo/exportPartNoByTemplate?brand=" + brand + "&spec=" + spec;
        }
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
        departmentObj.setValue("");
        searchKeyBrandObj.setValue("");
        searchKeySpecObj.setValue("");
        var partNos = mini.get("partNoInput").getText();
        partNoGrid.load({
          partNos : partNos
        });
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
            partNos : partNos,
            type : "template"
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
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>
