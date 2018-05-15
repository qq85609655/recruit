<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/webpage/common.jsp"%>

<html>
<head>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>邮件模板管理</title>
<style>
.mini-grid-rows-view {
  height: auto;
}

.mini-grid-emptyText {
  padding: 0px !important;
  font-size: 17px !important;
}

.tool-bar {
  margin-bottom: 10px;
}
</style>
</head>
<body>
  <div class="co">

    <div>
      <div class="co-right-main co-right-center">
        <div class="con-title">邮件模板管理</div>
        <div class="account-content">
          <div class="blue radius">
            <div class="table-operate">
              <input id="key" class="mini-textbox"
                emptyText="请输入模板名称" style="width: 150px;" onenter="onKeyEnter" /> <a
                class="mini-button" onclick="search()">查询</a> <input id="type" class="mini-hidden" />
              </td>
            </div>
             <div class="table-operate">
                  <input type="button" class="button radius btn" id="ok" onclick="onOk()" value="确定" />
                  <input type="button" class="button radius btn" id="cancel" value="取消" />
            </div>
               <div id="datagrid1" class="mini-datagrid" 
              url="${webRoot}/templateController/templateData?showPager=true" idField="id" sizeList="[10,20,50,100]"
              pageSize="15" allowResize="true">
              <div property="columns">
                <div type="checkcolumn" width="30"></div>               
                <div field="title" allowSort="true" width="150">邮件模板名称</div>
                <div field="type" width="100" allowSort="true" renderer="onTypeRenderer">模板类型</div>
                <div field="updateDate" width="150" allowSort="true" renderer="onDateRenderer">最后修订时间</div>
                <div field="creator" width="100" allowSort="true">修订者</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <%@ include file="/webpage/footer.jsp"%>
  <script type="text/javascript">
      mini.parse();
      var grid = mini.get("datagrid1");
      var webRoot = "${webRoot}";
      
    </script>
    <script type="text/javascript" src="${webRoot}/resources/js/flow/interview/chooseTemplateList.js"></script>
</body>
</html>