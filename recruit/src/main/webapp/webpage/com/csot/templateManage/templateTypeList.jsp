<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<%@ include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>模板类型管理</title>
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
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a
          class="path-item a-decoration">系统管理</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">模板类型管理</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">模板类型管理</div>
        <div class="account-content">
          <div class="blue radius">
            <div class="table-operate">
              <input type="button" class="button radius btn" id="create" value="新增"
                onclick="create()" /> <input type="button" class="button radius btn" id="edit"
                value="修改" onclick="edit()" /> <input type="button" class="button radius btn"
                id="remove" value="删除" onclick="removeTypeList()" /> <input id="key" class="mini-textbox"
                emptyText="请输入模板类型" style="width: 150px;" onenter="search()" /> <a
                class="mini-button" onclick="search()">查询</a>
              </td>
            </div>

            <div id="datagrid1" class="mini-datagrid"
              url="${webRoot}/templateType/datagrid?showPager=true" idField="id" sizeList="[10,20,50,100]"
              pageSize="15" allowResize="true" >
              <div property="columns">
                <div type="checkcolumn" width="50"></div>                
                <div field="typeName" allowSort="true" width="150">类型名称</div>
                <div field="typt" width="100" allowSort="true" renderer="onTypeRenderer">类型</div>
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
      grid.load();
      removeLoad();
      var webRoot = "${webRoot}";
    
    </script>
    <script type="text/javascript" src="${webRoot}/resources/js/templateManage/templateTypeList.js"></script>
</body>
</html>