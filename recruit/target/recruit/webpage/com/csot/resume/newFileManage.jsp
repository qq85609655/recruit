<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/webpage/common.jsp"%>
<html>
<head>
<title>招聘管理-文档管理</title>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/fileManager.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/position/positionEdit.css" />
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a
          class="path-item a-decoration">招聘支持</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">文档管理</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">文档管理</div>
        <div class="account-content">
          <div class="account-search">
            <table class="tblQuery2">
              <tbody>
                <tr>
                  <th>&nbsp;文档类型：</th>
                  <td><input style="width: 60px" class="mini-textbox" name="fileType" id="fileType"></td>
                  <th>&nbsp;文档名称:</th>
                  <td><input style="width: 80px" class="mini-textbox" name="fileName" id="fileName"></td>
                  <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                    class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                  </td>
                </tr>
              </tbody>
            </table>
          </div> 
          <div class="blue radius">
            <div class="table-operate" style="padding: 10px">
              <input type="button" class="button radius btn" id="uploadButton" value="上传" />
              <input type="button" class="button radius btn" id="remove" value="删除"
                onclick="remove()" />

            </div>
            <div id="datagrid1" class="mini-datagrid"
              url="/recruit/resume/fileDatagrid" idField="id"
              sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true"
              style="height: 350px;">
              <div property="columns">
                <div type="indexcolumn"></div>
                <div name="fileType" field="fileType" width="80" allowSort="true">文档类型</div>
                <div name="fileName" field="fileName" width="80" align="center" headerAlign="center"
                  allowSort="true" allowSort="false">文档名称</div>
                <div name="uploadTime" field="uploadTime" width="80" allowSort="true" align="center"
                  headerAlign="center" renderer="onDateRenderer">最后修订时间</div>
                <div name="uploader" field="uploader" width="60" allowSort="true" align="center"
                  headerAlign="center">修订者</div>
              </div>
            </div>
          </div>
          </div>

          <div>
            <div id="file-win" class="mini-window"
              style="width: 520px; height: 260px; display: none;" title="上传标准文档" showFooter="true">
              <form id="fileForm" method="post" enctype="multipart/form-data">
              <input class="mini-hidden" value="" name="fileType" id="fileTypeV" />
                <table>
                  <tr>
                    <td><span class="red">*</span><span>文档类型:&nbsp;</span></td>                 
                    <td>
                      <t:dictSelect type="select" dictField="file-type" id="file-type" field="file-type" domClass="recruit-select" typeGroupCode="file-type" defaultVal="1" hasLabel="false"></t:dictSelect> 
                      <c:if test="${not empty u_datadictGroupController_config}">
                        &nbsp;<a href="${webRoot}/datadictGroupController/config/file-type" target="_blank" class="path-item a-decoration sys-data-config">配置文档类别</a>
                      </c:if>
                    </td>
                  </tr>
                  <tr>
                    <td><span class="red">*</span><span>文档名称:&nbsp;</span></td>
                    <td><input type="text" name="fileName" class="w150" id="fileName"></td>
                  </tr>
                  <tr>
                    <td><span class="red">*</span><span>选择上传文档:&nbsp;</span></td>
                    <td><input id="file" name="file" type="file" value="浏览" size="220"
                      width="200" style="width: 218px;" onchange="ajaxFileUpload()" /></td>
                  </tr>
                  <tr>
                    <td></td>
                    <td><span class="grays">请上传html,htm,word,excel,rar,zip,jpg,png,gif格式，单<br>个文档不超过4M。
                    </span></td>
                  </tr>
                </table>
                <div class="tipMessage">
                  <span class="tipContent" style="font-size: 15px;"></span>
                </div>
                <div property="footer" class="win-footer">
                  <input type="button" id="submitBtn1" class="win-footer-btn" value="确定上传" /> <input
                    type="button" class="win-footer-btn" value="取消" id="cancelBtn">
                </div>
              </form>
            </div>
          </div>
      </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
  <script>
      mini.parse();
      var filedatagrid = mini.get("datagrid1");
      filedatagrid.load();
      
      function search() {
        var fileName = mini.get("fileName").getValue();
        var fileType = mini.get("fileType").getValue();
        filedatagrid.load({
          fileName : fileName,
          fileType : fileType
        });
      }
      
      $("#uploadButton").click(function() {
        var win = mini.get("file-win");
        var lt = $(this).offset();
        win.showAtPos(lt.left + 160, lt.top + 150);

      })
      
      //提交表单
      $("#submitBtn1").click(function() {
        //form的验证
        var fileType = getSelectValue("#file-type");
        mini.get("fileTypeV").setValue(fileType);
        var fileName = $("#fileName").val();
        if ($.trim(fileName) == '') {
          $(".tipMessage").show();
          $(".tipContent").html("<b>文档名称不能为空</b>");
          $(".tipMessage").delay(3000).hide(1);
          return;
        }
        var name = $("#textFile").val();
        if ($.trim(name) == "上传文件类型不匹配") {
          $(".tipMessage").show();
          $(".tipContent").html("<b>请选择文件上传</b>");
          $(".tipMessage").delay(3000).hide(1);
          return;
        }

        $.ajax({
          url : "/recruit/resume/validateFileName",
          async : false,
          data : {
            fileName : $.trim(fileName)
          },
          dataType : "json",
          success : function(data) {
            if (data.success == true) {
              $("#fileForm").ajaxSubmit({
                type : "POST",
                dataType : "json",
                url : "/recruit/resume/addFile",
                success : function(msg) {
                  removeLoad();
                  opResult(msg);
                  filedatagrid.reload();
                },
                error : function(e) {
                  removeLoad();
                  ShowErrorTip("上传出现异常！");
                }
              });
              hideWindow("file-win");
            } else {
              $(".tipMessage").show();
              $(".tipContent").html("<b>文件名称已存在</b>");
              $(".tipMessage").delay(3000).hide(1);
              return;
            }
          }
        });
      })

      filedatagrid
          .on(
              "drawcell",
              function(e) {
                var row = e.row, field = e.field;
                //超链接任务
                if (field == "fileName") {
                  e.cellHtml = "";
                  e.cellHtml += '<a class="report-link" href="' + row.filePath + '" target="_blank" style="text-decoration:underline;">'
                      + row.fileName + '</a>';

                  /* if(row.fileType != null){
                    e.cellHtml += '     <a class="report-link" href="uploadFileController/browseFile?pid=${pid}&id=' + row.uploadId 
                    + '" target="_blank" >[预览]</a>';
                  } */
                }
              });

      function onDateRenderer(e) {
        var value = e.value;
        if (value)
          return new Date(value).format("yyyy-MM-dd hh:mm:ss");
        return "";
      }

      function remove() {
        var row = filedatagrid.getSelected();
        if (row) {
          var id = row.id;
          mini.confirm("确定删除记录？<br>", "删除", function(action) {
            if (action == "ok") {
              SaveData("/recruit/resume/remove/" + id, "", function(e) {
                ShowActionTip(e);
                filedatagrid.reload();
              });
            }
          });
        } else {
          ShowWarnTip("请选择一条记录");
        }
      }
      
   	  // 获取select选中的值
      function getSelectValue(Id) {
      	return $(Id).find("option[value='" + $(Id).val() + "']").attr("id");
      }
   
    </script>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/jquery.form.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/resume/fileManager.js"></script>
</html>








