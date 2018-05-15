<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>黑名单</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
<style type="text/css">
.tblQuery2 th {
  font-size: 13px !important;
}
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
    <div class="co-right">
      <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a
          class="path-item a-decoration">招聘流程</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">黑名单</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">黑名单</div>
        <div class="main">
          <div class="position-import-main blue radius">
            <div class="account-content">
              <div class="account-search">
                <table class="tblQuery2">
                  <tbody>
                    <tr style="font-size: 15px">
                      <th>&nbsp;候选人名称:</th>
                      <td><input id="candidateName" class="mini-text" name="candidateName"
                        style="width: 120px;" onenter="search()"></td>
                      <th>&nbsp;是否生效:</th>
                      <td><input id="state" class="mini-combobox" name="state"
                        valueField="typeId" onenter="search()" textField="typeName"
                        showNullItem="true" nullItemText="全部"
                        data="[{typeId:1,typeName:'生效'},{typeId:2,typeName:'未生效'}]" /></td>
                        <th>&nbsp;列入黑名单原因:</th>
                      <td><input id="inReasonStr" class="mini-text" name="inReasonStr"
                        style="width: 120px;" onenter="search()"></td>
                    </tr>
                     <tr style="font-size: 15px">
                      
                      <th>&nbsp;撤销黑名单原因:</th>
                      <td><input id="outReasonStr" class="mini-text" name="outReasonStr"
                        style="width: 120px;" onenter="search()"></td>
                      <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                        class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="blue radius">
                <div class="table-operate">
                  <input type="button" class="button radius btn" id="addRecruitDemand" value="撤销黑名单"
                    onclick="outBlacklist()" />
                </div>
                <div id="datagrid1" class="mini-datagrid" oncellclick="cellclick" showPager="true"
                  url="/recruit/employBlacklistController/datagrid?showPager=true&stage=1"
                  ondrawcell="ondrawcell" idField="id" sizeList="[1,2,50,100]" pageSize="10"
                  allowResize="false" multiSelect="true" style="height: 350px;">
                  <div property="columns">
                    <div type="checkcolumn"></div>
                    <div name="candidateName" field="candidateName" width="80" allowSort="true">候选人</div>
                    <div name="inReason" field="inReason" width="80" align="center"
                      headerAlign="center" allowSort="true" allowSort="false">列入黑名单原因</div>
                    <div name="outReason" field="outReason" width="80" align="center"
                      headerAlign="center" allowSort="true" allowSort="false">撤销黑名单原因</div>
                    <div name="state" field="state" width="80" align="center" headerAlign="center"
                      allowSort="true" allowSort="false">是否生效</div>
                  </div>
                </div>
              </div>

            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  grid.load();
</script>
<script type="text/javascript" src="${webRoot}/resources/js/flow/employ/employBlackList.js?v=2"></script>
</html>









