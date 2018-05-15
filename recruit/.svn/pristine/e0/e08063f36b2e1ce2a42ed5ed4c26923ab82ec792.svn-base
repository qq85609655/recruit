<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/resources/context/jspBase.jsp"%>
<title>编辑学生信息</title>
<%@ include file="/resources/context/headResource.jsp"%>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>
  <div class="mini-fit">
    <form id="mainForm" class="mainform" AutoScroll="true" method="post">
      <input name="id" class="mini-hidden" value="${campusStudent.id}" />
      <h2>学生资料修改</h2>
      <table>
        <h3>职位信息</h3>
        <hr></hr>
        <tr>
          <td>站点</td>
          <td><input id="site" class="mini-combobox" style="width: 180px;" textField="siteName"
            name="siteId" valueField="siteId" value="${campusStudent.siteId}"
            url="/recruit/campusAddressbookController/getSiteName" onvalidation="onSiteValidation"
            onvaluechanged="onSiteChanged" /></td>
          <td><input id="siteName" name="siteName" class="mini-hidden"
            value="${campusStudent.siteName}" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;工作地点</td>
          <td>
        <%--   <input name="workingPlace" class="mini-textbox" required="true"
            value="${campusStudent.workingPlace}" style="width: 180px" allowInput="true"
            requiredErrorText="工作地点不能为空" /> --%>
            <input name="workingPlace" class="mini-combobox" id="workPlaceId" valueField="typeId"
            textField="typeName" style="width: 180px" onvalidation="onWorkPlaceValidation"
            value="${campusStudent.workingPlace}" onvaluechanged="onWorkPlaceChanged"
            url="/recruit/datadictGroupTypeController/getDictsByCode/campus_workPlace" />
            </td>
            <td><input id="workingPlace" name="workingPlace" class="mini-hidden"
            value="${campusStudent.workingPlace}" /></td>
        </tr>
        <tr>
          <td>职位族</td>
          <td><input name="jobFamily" class="mini-combobox" id="familyId" valueField="typeId"
            textField="typeName" style="width: 180px" onvalidation="onjobFamilyValidation"
            value="${campusStudent.jobFamily}" onvaluechanged="onJobFamilyChanged"
            <%-- text="${campusStudent.jobFamilyName}" --%>
            url="/recruit/datadictGroupTypeController/getDictsByCode/post_family" /></td>
          <td><input id="jobFamilyName" name="jobFamilyName" class="mini-hidden"
            value="${campusStudent.jobFamilyName}" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;岗位</td>
          <td><input id="jobClassLookup" class="mini-lookup" style="width: 180px;"
            textField="postName" name="postId" valueField="postId" emptyText="请选择岗位"
            popupWidth="auto" popup="#gridPanel" grid="#datagrid1"
            onvaluechanged="onJobClassChanged" value="${campusStudent.postId}"
            text="${campusStudent.postName}" onvalidation="onlookupJobclassValidation" /> <input
            id="jobClass" class="mini-hidden" name="postName" value="${campusStudent.postName}" />
            <div id="gridPanel" class="mini-panel" title="header" iconCls="icon-add"
              style="width: 350px; height: 250px;" showToolbar="true" showCloseButton="true"
              showHeader="false" bodyStyle="padding:0" borderStyle="border:0">
              <div property="toolbar" style="padding: 5px; padding-left: 8px; text-align: center;">
                <span>职位类：</span> <input id="keyText" class="mini-textbox" style="width: 100px;"
                  onenter="onSearchClick" /> <a class="mini-button" onclick="onSearchClick">查询</a>
                <a class="mini-button" onclick="onClearClick()">清除</a> <a class="mini-button"
                  onclick="onOkClick()">确定</a>
              </div>
              <div id="datagrid1" class="mini-datagrid" style="width: 100%; height: 100%;"
                borderStyle="border:0" showPageSize="false" showPageIndex="false" multiSelect="true"
                onrowdblclick="onRowClick" url="/recruit/campusPostController/datagrid">
                <div property="columns">
                  <div type="checkcolumn">序号</div>
                  <div field="postName" width="80" headerAlign="center" allowSort="true">职位类</div>
                  <div field="RESERVED_2" width="80" headerAlign="center" allowSort="true">职位族</div>
                  <div field="jobSubclass" width="80" headerAlign="center" allowSort="true">职位子类</div>
                </div>
              </div>
            </div></td>
        </tr>
        <tr>
          <td>职位子类</td>
          <td><input name="jobSubclass" class="mini-textbox" id="subClass"
            value="${campusStudent.jobSubclass}" style="width: 180px" allowInput="true" /></td>
        </tr>
      </table>
      <table>
        <h3>组织信息</h3>
        <hr></hr>
        <tr>
          <td>组织</td>
          <td><input name="orgId" class="mini-combobox" id="org" valueField="typeId"
            textField="typeName" style="width: 180px" onvalidation="onOrganizationValidation"
            value="${campusStudent.orgId}" onvaluechanged="onOrgChanged"
            url="/recruit/datadictGroupTypeController/getDictsByCode/campus_company" /></td>
          <input id="organization" class="mini-hidden" name="organization"
            value="${campusStudent.organization}" />
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;中心</td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="bigCenter" class="mini-textbox"
            required="true" value="${campusStudent.bigCenter}" style="width: 180px"
            allowInput="true" requiredErrorText="中心不能为空" /></td>
        </tr>
        <tr>
          <td>小中心/处</td>
          <td><input name="smallCenter" class="mini-textbox" required="true"
            value="${campusStudent.smallCenter}" style="width: 180px" allowInput="true"
            requiredErrorText="小中心/处不能为空" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;部门</td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input name="department" class="mini-textbox"
            required="true" value="${campusStudent.department}" style="width: 180px"
            allowInput="true" requiredErrorText="部门不能为空" /></td>
        </tr>
        <tr>
          <td>科室</td>
          <td><input name="offices" class="mini-textbox" required="true"
            value="${campusStudent.offices}" style="width: 180px" allowInput="true"
            requiredErrorText="科室不能为空" /></td>
        </tr>
      </table>
      <table>
        <h3>学生个人信息</h3>
        <hr></hr>
        <tr>
          <td>姓名</td>
          <td><input name="realname" id="nameId" class="mini-textbox" required="true"
            value="${campusStudent.realname}" style="width: 180px" allowInput="true"
            requiredErrorText="姓名不能为空" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别</td>
          <td>&nbsp;&nbsp;<input name="sex" id="sex" class="mini-combobox"
            value="${campusStudent.sex}" style="width: 180px"
            url="/recruit/resources/data/gender.txt" textField="text" valueField="id"
            onvalidation="onSexValidation" /></td>
        </tr>
        <tr>
          <td>最高学历</td>
          <td><input name="education" id="education" class="mini-combobox"
            value="${campusStudent.education}" style="width: 180px" textField="text" valueField="id"
            onvalidation="onEduValidation" url="/recruit/resources/data/education.txt" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学校</td>
          <td>&nbsp;&nbsp;<input name="school" class="mini-textbox" required="true"
            value="${campusStudent.school}" style="width: 180px" allowInput="true"
            requiredErrorText="学校不能为空" /></td>
        </tr>
        <tr>
          <td>专业</td>
          <td><input name="major" class="mini-textbox" required="true"
            value="${campusStudent.major}" style="width: 180px" allowInput="true"
            requiredErrorText="专业不能为空" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;籍贯</td>
          <td>&nbsp;&nbsp;<input name="nativePlace" class="mini-textbox" required="true"
            value="${campusStudent.nativePlace}" style="width: 180px" allowInput="true"
            requiredErrorText="籍贯不能为空" /></td>
        </tr>
        <tr>
          <td>手机号码</td>
          <td><input name="phoneNo" class="mini-textbox" required="true" vtype="minLength:11"
            vtype="maxLength:11" value="${campusStudent.phoneNo}" style="width: 180px"
            allowInput="true" requiredErrorText="手机号码不能为空" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;身份证号</td>
          <td>&nbsp;&nbsp;<input name="id" class="mini-textbox" required="true" id="idCard"
            value="${campusStudent.id}" style="width: 180px" requiredErrorText="身份证号不能为空"
            onvalidation="onIDCardsValidation" /></td>
        </tr>
        <tr>
          <td>邮箱</td>
          <td><input name="email" class="mini-textbox" required="true"
            value="${campusStudent.email}" vtype="email" style="width: 180px" allowInput="true"
            requiredErrorText="邮箱不能为空" /></td>
        </tr>
      </table>
      <table>
        <h3>面试及测评</h3>
        <hr></hr>
        <tr>
          <td>测评成绩</td>
          <td><input name="evaluation" class="mini-textbox" required="true"
            value="${campusStudent.evaluation}" style="width: 180px" allowInput="true"
            requiredErrorText="测评成绩不能为空" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;心理风险</td>
          <td><input name="moraleRisk" class="mini-textbox" required="true"
            value="${campusStudent.moraleRisk}" style="width: 180px" allowInput="true"
            requiredErrorText="心理风险不能为空" /></td>
        </tr>
        <tr>
          <td>胜任力成绩</td>
          <td><input name="competency" class="mini-textbox" required="true"
            value="${campusStudent.competency}" style="width: 180px" allowInput="true"
            requiredErrorText="胜任力成绩不能为空" onvalidation="onCompetencyValidation" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;一面得分</td>
          <td><input name="resultFirst" class="mini-textbox" required="true"
            value="${campusStudent.resultFirst}" style="width: 180px" allowInput="true"
            requiredErrorText="一面得分不能为空" onvalidation="onResultValidation" /></td>
        </tr>
        <tr>
          <td>二面得分</td>
          <td><input name="resultSecond" class="mini-textbox" required="true"
            value="${campusStudent.resultSecond}" style="width: 180px" allowInput="true"
            requiredErrorText="二面得分不能为空" onvalidation="onResultValidation" /></td>
        </tr>
      </table>
      <table>
        <h3>资料收取情况</h3>
        <hr></hr>
        <tr>
          <td>OFFER</td>
          <td><input id="radioButtom1" name="offer" class="mini-radiobuttonlist"
            value="${campusStudent.offer}" url="/recruit/resources/data/yesOrNo.txt"
            textField="text" valueField="id" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;三方
          </td>
          <td><input id="radioButtom2" name="trilateral" class="mini-radiobuttonlist"
            value="${campusStudent.trilateral }" url="/recruit/resources/data/yesOrNo.txt"
            textField="text" valueField="id" /></td>
        </tr>
        <tr>
          <td>成绩单</td>
          <td><input id="radioButtom3" name="transcript" class="mini-radiobuttonlist"
            value="${campusStudent.transcript }" url="/recruit/resources/data/yesOrNo.txt"
            textField="text" valueField="id" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;就业推荐表
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          <td><input id="radioButtom4" name="referenceForm" class="mini-radiobuttonlist"
            value="${campusStudent.referenceForm }" url="/recruit/resources/data/yesOrNo.txt"
            textField="text" valueField="id" /></td>
        </tr>
        <tr>
          <td>身份证复印件&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          <td><input id="radioButtom5" name="idcardCopy" class="mini-radiobuttonlist"
            value="${campusStudent.idcardCopy }" url="/recruit/resources/data/yesOrNo.txt"
            textField="text" valueField="id" /></td>
          <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;四六级成绩单
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          <td><input id="radioButtom6" name="cetTranscript" class="mini-radiobuttonlist"
            value="${campusStudent.cetTranscript }" url="/recruit/resources/data/yesOrNo.txt"
            textField="text" valueField="id" /></td>
        </tr>
        <tr>
          <td>照片&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
          <td><input id="radioButtom7" name="photo" class="mini-radiobuttonlist"
            value="${campusStudent.photo }" url="/recruit/resources/data/yesOrNo.txt"
            textField="text" valueField="id" /></td>
        </tr>

      </table>
    </form>
  </div>
  <div class="mini-toolbar dialogFooter">
    <a class="mini-button" style="width: 100px;" onclick="onOk()">提交</a> <span
      style="display: inline-block; width: 25px;"></span> <a class="mini-button"
      style="width: 100px;" onclick="onCancel()">取消</a>
  </div>
  <script type="text/javascript">
      mini.parse();
      var form = new mini.Form("#mainForm");
      var grid = mini.get("datagrid1");
      var postName = mini.get("keyText").value;
      var jobClassLookup = mini.get("jobClassLookup");
      var family = mini.get("familyId");
      var subClass = mini.get("subClass");
      var idCard = mini.get("idCard");
      var radioButtom = mini.get("radioButtom6");
      var org = mini.get("org");
      var site = mini.get("site");
      var workPlaceCombo = mini.get("workPlaceId");
      var nameTextBox = mini.get("nameId");

      grid.load();
    </script>
  <script type="text/javascript" src="${basePath}/resources/js/campus/campusStuEditByMaster.js"></script>
  <%@ include file="/resources/context/lazyResource.jsp"%>
</body>
</html>