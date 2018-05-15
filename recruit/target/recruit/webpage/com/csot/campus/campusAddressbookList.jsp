<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>

<html>
<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>校招通讯录</title>
<style type="text/css">
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">招聘支持</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">校招通讯录</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">校招通讯录管理</div>
        <div class="account-content">
          <div class="account-search">
            <table class="tblQuery2">
              <tbody>
                <tr>
                  <td><input emptyText="请输入姓名" style="width: 150px" class="mini-textbox"
                    id="key" onenter="search()"></td>
                  <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                    class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <div class="blue radius">
            <div class="table-operate">
              <shiro:hasPermission name="campus:addressbook:importExcel">
                <input type="button" class="button radius btn" id="uploadButton" value="导入"
                  onclick="onImport()" />
              </shiro:hasPermission>
              <shiro:hasPermission name="campus:addressbook:newAdd">
                <input type="button" class="button radius btn" id="create" value="新增"
                  onclick="create()" />
              </shiro:hasPermission>
              <shiro:hasPermission name="campus:addressbook:edit">
                <input type="button" class="button radius btn" id="modify" value="修改"
                  onclick="modify()" />
              </shiro:hasPermission>
              <input type="button" class="button radius btn" id="remove" value="删除"
                onclick="removeAddressbook()" /> <input type="button" class="button radius btn"
                id="create" value="导出" onclick="onExport()" /> <input type="button"
                class="button radius btn" id="downloadTemplate" value="模板下载"
                onclick="downloadTemplate()" />
            </div>
            <div id="datagrid1" class="mini-datagrid"
              url="/recruit/campusAddressbookController/datagrid?showPager=true" idField="id" 
              sizeList="[10,20,50,100]" pageSize="15" allowResize="false" >
              <div property="columns">
                <div type="checkcolumn" width="30"></div>
                <div name="workNo" field="workNo" width="80" allowSort="true">工号</div>
                <div name="realname" field="realname" width="80" allowSort="true">姓名</div>
                <div name="siteName" field="siteName" width="80" allowSort="true">站点</div>
                <div name="siteId" field="siteId" width="80" allowSort="true">站点ID</div>
                <div name="campusRole" field="campusRole" width="80" allowSort="true">校招角色</div>
                <div name="phoneno" field="phoneno" width="80" allowSort="false">联系电话</div>
                <div name="邮箱" field="email" width="80" allowSort="false">邮箱</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script>
  mini.parse();
  var datagrid = mini.get("datagrid1");
  datagrid.load();

  //datagrid.sortBy(siteId, "desc");
</script>
<script type="text/javascript" src="${webRoot }/resources/js/campus/addressbookList.js"></script>
</html>