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
            <td style="width: 100%;"><a class="mini-menubutton" plain="true" menu="#popupMenu">操作</a>
              <a class="mini-button" iconCls="icon-upload" onclick="uploadPart('wxNo')" plain="true">维修导入</a>
              <a class="mini-button" iconCls="icon-upload" onclick="uploadPart('partNo')"
              plain="true">料号导入</a> <a class="mini-button" iconCls="icon-upload"
              onclick="uploadPart('partProValue')" plain="true">料号属性值导入</a> <input id="excelDoc"
              name="excelDoc" type="file" /></td>
          </tr>
          <tr>
            <td style="white-space: nowrap; padding-right: 8px;">创建日期：<input id="dateBegin"
              emptyText="开始日期" class="mini-datepicker" allowInput="false" showTodayButton="false"
              ondrawdate="onDrawDateBegin" /> 至<input id="dateEnd" emptyText="结束日期"
              class="mini-datepicker" allowInput="false" showTodayButton="false"
              ondrawdate="onDrawDateEnd" />
            </td>
          </tr>
          <tr>
            <td><input id="partName" class="mini-textbox" onenter="onKeyEnter" emptyText="物料名称"
              selectOnFocus="true" /> <input id="searchKey" class="mini-textbox"
              onenter="onKeyEnter" emptyText="料号" selectOnFocus="true" /> <input id="ownerName"
              class="mini-textbox" style="width: 70px" onenter="onKeyEnter" emptyText="创建人姓名"
              selectOnFocus="true" /> <input id="department" class="mini-textbox"
              style="width: 70px" onenter="onKeyEnter" emptyText="创建人部门" selectOnFocus="true" /> <a
              class="mini-button" iconCls="icon-search" plain="true" onclick="search">查询</a></td>
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
        <li iconCls="icon-node" onclick="detail" plain="true">详细信息</li>
        <span class="separator"></span>
        <li iconCls="icon-edit" onclick="modifyLevel3" plain="true">修改料号分类</li>
        <span class="separator"></span>
        <li iconCls="icon-print" onclick="updateHashCode()" plain="true">HashCode更新</li>
        <span class="separator"></span>
        <li iconCls="icon-remove" onclick="remove" plain="true">删除</li>
      </ul>

      <div class="mini-fit">
        <div id="partNoGrid" class="mini-datagrid" style="width: 100%; height: 100%"
          sizeList="[20,50,100]" pageSize="20" url="partNo/datagrid?showPager=true" idField="id"
          allowResize="true">
          <div property="columns">
            <div type="indexcolumn" width="5"></div>
            <div field="partNo" width="25" headerAlign="center" allowSort="true">料号</div>
            <div field="partName" width="25" headerAlign="center" allowSort="true">物料名称</div>
            <div field="partNoStatus" width="10" headerAlign="center" allowSort="true">状态</div>
            <div field="createCode" width="20" headerAlign="center" allowSort="true">创建人工号</div>
            <div field="createName" width="20" headerAlign="center" allowSort="true">创建人姓名</div>
            <div field="department" width="30" headerAlign="center" allowSort="true">创建人部门</div>
            <div field="createTime" dataType="date" dateFormat="yyyy-MM-dd HH:mm:ss" width="23"
              allowSort="true">创建时间</div>
            <div field="telephone" width="20" headerAlign="center" allowSort="true">联系方式</div>
          </div>
        </div>
      </div>
    </div>
    <div showHeader="false" region="east" width="400" maxWidth="500" minWidth="300"
      bodyStyle="overflow:hidden;">
      <div class="mini-toolbar" style="padding: 2px; border-bottom: 0; width: 100%">
        <table style="width: 100%;">
          <tr>
            <td colSpan="2"><input style="width: 375px;" id="level" class="mini-textbox"
              emptyText="料号分类" allowInput="false" /></td>
          </tr>
          <tr>
            <td style="width: 100%;"><a class="mini-button" iconCls="icon-save"
              onclick="saveData()" plain="true">保存</a></td>
            <td style="white-space: nowrap; padding-right: 8px;"><input id="searchKeyBrand"
              class="mini-textbox" onenter="searchPro()" emptyText="请输入品牌" selectOnFocus="true" />
              <input id="searchKeySpec" class="mini-textbox" onenter="searchPro()" emptyText="请输入规格"
              selectOnFocus="true" /> <a class="mini-button" iconCls="icon-search" plain="true"
              onclick="searchPro">查询</a></td>
          </tr>
        </table>
      </div>
      <div id="propertyGrid" class="mini-datagrid" style="width: 98%; height: 93%"
        allowCellEdit="true" allowCellSelect="true" idField="id" allowCellWrap="true"
        url="propertyValue/proValuedatagrid" allowResize="true" showPager="false">
        <div property="columns">
          <div field="propertyDisName" width="40" headerAlign="center" allowSort="true">属性名</div>
          <div field="propertyValue" width="40" headerAlign="center" allowSort="true">
            真实值<input property="editor" class="mini-textbox" style="width: 100%;" minWidth="200" />
          </div>
          <div field="propertyValueText" width="40" headerAlign="center" allowSort="true">显示值</div>
          <div field="propertyType" width="20" headerAlign="center" allowSort="true">唯一性</div>
        </div>
      </div>
    </div>
  </div>
  <script>
      mini.parse();
      var partNoGrid = mini.get("partNoGrid");
      partNoGrid.load();
      partNoGrid.sortBy("createTime", "desc");

      var propertyGrid = mini.get("propertyGrid");

      var searchKeyObj = mini.get("searchKey");
      var ownerNameObj = mini.get("ownerName");
      var partNameObj = mini.get("partName");
      var dateBeginObj = mini.get("dateBegin");
      var dateEndObj = mini.get("dateEnd");
      var searchKeyBrandObj = mini.get("searchKeyBrand");
      var searchKeySpecObj = mini.get("searchKeySpec");
      var departmentObj = mini.get("department");

      function detail() {
        var row = partNoGrid.getSelected();
        if (row) {
          OpenDialog("partNo/modify/" + row.id, "详细信息", partNoGrid, 650, 400);
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }

      function remove() {
        var row = partNoGrid.getSelected();
        if (row) {
          var id = row.id;
          mini.confirm("确定删除记录？<br>", "删除", function(action) {
            if (action == "ok") {
              SaveData("partNo/remove/" + id, "", function(e) {
                ShowActionTip(e);
                partNoGrid.reload();
              });
            }
          });
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
        });
      }

      function searchPro() {
        searchKeyObj.setValue("");
        ownerNameObj.setValue("");
        partNameObj.setValue("");
        dateBeginObj.setValue("");
        dateEndObj.setValue("");
        var searchKeyBrand = searchKeyBrandObj.getValue();
        var searchKeySpec = searchKeySpecObj.getValue();
        partNoGrid.load({
          searchKeyBrand : searchKeyBrand,
          searchKeySpec : searchKeySpec
        });
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

      function updateHashCode() {
        var messageId = mini.loading("正在更新中!");
        $.ajax({
          url : "partNo/updateHashCode",
          type : "post",
          dataType : 'json', //数据格式为json
          success : function(data) {
            mini.hideMessageBox(messageId);
            mini.alert(data.msg, "提示");
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function saveData() {

        var data = propertyGrid.getChanges();
        var json = mini.encode(data);
        $.ajax({
          url : "propertyValue/update",
          dataType : 'json',
          contentType : 'application/json',
          data : json,
          type : "post",
          success : function(text) {
            mini.alert(text.msg, "提示");
            propertyGrid.reload();
          },
          error : function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.responseText);
          }
        });
      }

      function modifyLevel3() {
        var row = partNoGrid.getSelected();
        if (row) {
          mini.open({
            url : "part/toSparePartConTree?partNoId=" + row.id,
            title : "修改料号分类",
            width : 700,
            height : 500
          });
        } else {
          ShowWarnTip("请选择一条记录");
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
        searchKeyBrandObj.setValue("");
        searchKeySpecObj.setValue("");
        var partNos = mini.get("partNoInput").getText();
        partNoGrid.load({
          partNos : partNos
        });
      }
    </script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>