<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html>

<head>
<%@include file="/webpage/common.jsp"%>
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<title>学生资料</title>
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
          class="path-leaf">招聘支持</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">录用管理</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="con-title">录用管理</div>
        <div class="account-content">
          <div class="account-search">
            <table class="tblQuery2">
              <tbody>
                <tr>
                  <td>招聘时间&nbsp;&nbsp;</td>
                  <td><input class="mini-combobox" style="width: 120px;" textField="yearth"
                    id="yearthKey" nullItemText="全部" valueField="yearth" value="${yearth}"
                    url="/recruit/campusTaskController/datagrid4Yearth" showNullItem="true"
                    allowInput="true" onenter="search()" /></td>
                  <td>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;组织&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td><input name="orgId" class="mini-combobox" id="org" valueField="typeId"
                    textField="typeName" style="width: 120px" nullItemText="全部" showNullItem="true"
                     value="${campusStudent.orgId}" onenter="search()"
                    url="/recruit/datadictGroupTypeController/getDictsByCode/campus_company" /></td>
                    <!-- onvalidation="onOrganizationValidation" onvaluechanged="onOrgChanged" -->
                  <td>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;站点&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td><input class="mini-combobox" style="width: 120px;" textField="siteName"
                    name="siteId" valueField="siteId" id="siteKey" allowInput="true"
                    nullItemText="全部" showNullItem="true"
                    url="/recruit/campusAddressbookController/getSiteName" onenter="search()" /></td>
                  <td>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;中心 &nbsp;&nbsp;&nbsp;</td>
                  <td><input emptyText="请输入中心" style="width: 120px" class="mini-textbox"
                    id="centerKey" allowInput="true" onenter="search()"></td>
                </tr>
                <tr>
                  <td>岗位&nbsp;&nbsp;&nbsp;&nbsp;</td>
                  <td class="formContent"><input class="mini-combobox" style="width: 120px;"
                    textField="postName" name="postId" valueField="postId" id="postKey"
                    nullItemText="全部" showNullItem="true" allowInput="true"
                    url="/recruit/campusPostController/datagrid" onenter="search()" /></td>
                  <td>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;姓名&nbsp;&nbsp;&nbsp;</td>
                  <td><input emptyText="请输入姓名" style="width: 120px" class="mini-textbox"
                    id="nameKey" allowInput="true" onenter="search()"></td>
                  <td>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;学校&nbsp;&nbsp;&nbsp;</td>
                  <td><input emptyText="请输入学校" style="width: 120px" class="mini-textbox"
                    id="schoolKey" onenter="search()"></td>

                </tr>
              </tbody>
            </table>
            <br>
            <table>
              <tr>
                <td><div class="mini-panel" title="更多查询" style="width: 680px; height: 140px;"
                    showCollapseButton="true" bodyStyle="padding:0;" expanded="false">
                    <table class="form-table" border="0" align="left">
                      <br>
                      <tr>
                        <td>&nbsp;&nbsp;&nbsp;OFFER</td>
                        <td><input id="radioButtom1" name="offer" class="mini-combobox"
                          style="width: 120px; margin-left: 10px;" value="${offer}"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                        <td>&nbsp;&nbsp; &nbsp; 三方</td>
                        <td><input id="radioButtom2" name="trilateral" class="mini-combobox"
                          style="width: 120px; margin-left: 10px;" value="${tril}"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                        <td>&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;成绩单</td>
                        <td><input id="radioButtom3" name="transcript" class="mini-combobox"
                          style="width: 120px; margin-left: 10px;"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                      </tr>
                      <tr>

                        <td>&nbsp;&nbsp;&nbsp;就业推荐表</td>
                        <td><input id="radioButtom4" name="referenceForm" class="mini-combobox"
                          style="width: 120px; margin-top: 5px; margin-left: 10px;"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                        <td>&nbsp;&nbsp;&nbsp;身份证复印件</td>
                        <td><input id="radioButtom5" name="idcardCopy" class="mini-combobox"
                          style="width: 120px; margin-top: 5px; margin-left: 10px;"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                        <td>&nbsp;&nbsp; &nbsp;&nbsp; 四六级成绩单</td>
                        <td><input id="radioButtom6" name="cetTranscript" class="mini-combobox"
                          style="width: 120px; margin-top: 5px; margin-left: 10px;"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                      </tr>
                      <tr>
                        <td>&nbsp;&nbsp;&nbsp;照片</td>
                        <td><input id="radioButtom7" name="photo" class="mini-combobox"
                          style="width: 120px; margin-top: 5px; margin-left: 10px;"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                        <td>&nbsp;&nbsp;&nbsp;违约情况</td>
                        <td><input id="radioButtom8" name="breakOff" class="mini-combobox"
                          style="width: 120px; margin-left: 10px; margin-top: 5px;"
                          url="/recruit/resources/data/yesOrNo.txt" textField="text" valueField="id"
                          allowInput="true" onenter="search()" nullItemText="全部" showNullItem="true" /></td>
                      </tr>

                    </table>
                  </div></td>
                <td><div>
                    <shiro:hasPermission name="campus:student:search">&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                    <input type="submit" value="搜索" tabindex="5" onenter="onKeyEnter"
                        class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                    </shiro:hasPermission>
                  </div></td>
              </tr>
            </table>
          </div>
          <div class="blue radius">
            <div class="table-operate">

              <shiro:hasPermission name="campus:student:importManager">
                <input type="button" class="button radius btn" id="uploadButton" value="导入"
                  onclick="onImport()" />&nbsp;&nbsp;
                </shiro:hasPermission>
              <input type="button" class="button radius btn" id="create" value="新增"
                onclick="create()" />&nbsp;&nbsp; <input type="button" class="button radius btn"
                id="modify" value="修改" onclick="modify()" />&nbsp;&nbsp; <input type="button"
                class="button radius btn" id="removeStu" value="删除" onclick="removeStu()" />&nbsp;&nbsp;
              <shiro:hasPermission name="campus:student:downTemplateUser">
                <input type="button" class="button radius btn" id="call" value="下载模板"
                  onclick="templateExport()" />&nbsp;&nbsp;
                </shiro:hasPermission>
              <input type="button" class="button radius btn" id="export" value="导出"
                onclick="onExport()" />&nbsp;&nbsp;
              <shiro:hasPermission name="campus:student:importUser">
                <input type="button" class="button radius btn" id="masterImport" value="站长导入"
                  onclick="masterImport()" /> &nbsp;&nbsp; 
                </shiro:hasPermission>
              <input type="button" class="button radius btn" id="masterEdit" value="站长编辑"
                onclick="masterEdit()" />&nbsp;&nbsp; <input type="button"
                class="button radius btn" id="breakOff" value="违约" onclick="isBreakOff()" />&nbsp;&nbsp;&nbsp;
              <a vlink="#46a3ff" href="javascript:showColumn();">显示设置</a> &nbsp;&nbsp;&nbsp; <a
                class="mini-menubutton" plain="true" menu="#popupMenu">邮件发送</a> <input id="show"
                class="mini-radiobuttonlist" repeatLayout="table" repeatDirection="vertical"
                textField="typeName" valueField="typeId" onvaluechanged="dataChange()"
                url="/recruit/datadictGroupTypeController/getDictsByCode/showStuInfo" />
            </div>
            <!--menu-->
            <ul id="popupMenu" class="mini-menu" style="display: none;">
              <li iconCls="icon-downgrade" onclick="sendEmail()" plain="true">选人发送</li>
              <span class="separator"></span>
              <li iconCls="icon-downgrade" onclick="sendAll()" plain="true">全部发送</li>
              <span class="separator"></span>
              <li iconCls="icon-downgrade" onclick="sendSome()" plain="true">资料未齐全</li>
              <span class="separator"></span>
              <li iconCls="icon-downgrade" onclick="sendSearch()" plain="true">搜索发送</li>

            </ul>
            <br> <br>
            <div id="datagrid1" class="mini-datagrid"
              url="/recruit/campusStudentController/datagrid?showPager=true" idField="id"
              sizeList="[10,20,50,100]" pageSize="15" allowResize="false" multiSelect="true">
              <div property="columns">
                <div type="indexcolumn"></div>
                <div type="checkcolumn"></div>
                <div name="siteName" field="siteName" width="40" allowSort="true">站点</div>
                <div name="workingPlace" field="workingPlace" width="60" headerAlign="center"
                  allowSort="true">工作地点</div>
                <div name="organization" field="organization" width="80" allowSort="false">组织</div>
                <div name="bigCenter" field="bigCenter" width="65" allowSort="false">大中心</div>
                <div name="smallCenter" field="smallCenter" width="65" allowSort="false">厂/小中心</div>
                <div name="department" field="department" width="60" allowSort="false">部门</div>
                <div name="offices" field="offices" width="60" allowSort="false">科室</div>
                <div name="postName" field="postName" width="60" allowSort="false">岗位</div>
                <div name="realname" field="realname" width="50" allowSort="true">姓名</div>
                <div name="sex" field="sex" width="40" allowSort="false" renderer="onSexRenderer">性别</div>
                <div name="education" field="education" width="40" allowSort="false">学历</div>
                <div name="nativePlace" field="nativePlace" width="40" allowSort="false">籍贯</div>
                <div name="school" field="school" width="110" allowSort="false">学校</div>
                <div name="major" field="major" width="110" allowSort="false">专业</div>
                <div name="phoneNo" field="phoneNo" width="90" allowSort="false">联系方式</div>
                <div name="email" field="email" width="150" allowSort="false">邮箱</div>
                <div name="evaluation" field="evaluation" width="60" allowSort="true">测评成绩</div>
                <div name="moraleRisk" field="moraleRisk" width="60" allowSort="true">心理风险</div>
                <div name="competency" field="competency" width="60" allowSort="true">胜任力</div>
                <div name="resultFirst" field="resultFirst" width="60" allowSort="true">一面得分</div>
                <div name="resultSecond" field="resultSecond" width="60" allowSort="false">二面得分</div>
                <div name="offer" field="offer" width="40" allowSort="false">Offer</div>
                <div name="idcardCopy" field="idcardCopy" width="85" allowSort="false">身份证复印件</div>
                <div name="trilateral" field="trilateral" width="60" allowSort="false">三方协议</div>
                <div name="referenceForm" field="referenceForm" width="70" allowSort="false">就业推荐表</div>
                <div name="transcript" field="transcript" width="45" allowSort="false">成绩单</div>
                <div name="cetTranscript" field="cetTranscript" width="80" allowSort="false">四六级成绩单</div>
                <div name="photo" field="photo" width="40" allowSort="false">照片</div>
                <div name="breakOff" field="breakOff" width="60" allowSort="false">违约情况</div>
                <div name="breakOffReason" field="breakOffReason" width="110" allowSort="false">违约原因</div>
                <div name="breakOffTime" field="breakOffTime" width="80" allowSort="false"
                  renderer="onDateRenderer">违约时间</div>
                <div name="yearth" field="yearth" width="80" allowSort="false">招聘年份期数</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">
  mini.parse();
  var datagrid = mini.get("datagrid1");
</script>
<script type="text/javascript" src="${webRoot}/resources/js/campus/campusStuList.js"></script>
</html>