<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="/webpage/common.jsp"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css" />
<link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/position/positionEdit.css" />
<title>职位发布</title>
</head>
<body onload="removeLoad();">
  <div class="">
    <div class="co-right">
      <div class="co-right-main co-right-center">
        <div class="con-title">职位发布</div>
        <div class="">
          <form id="editform" class="jobEdit-form">
            <div class="jobEdit-basic-infor blue radius">
              <table class="jobEdit-tab">
                <thead>
                  <tr class="jobEdit-tr">
                    <td colspan="2"><span><h4>职位基本信息</h4></span></td>
                  </tr>
                </thead>
                <tbody>
                  <tr class="jobEdit-tr">
                    <td class="jobEdit-td"><font class="marker-color">*</font> <font
                      class="font-title">申请岗位名称：</font></td>
                    <td><input type="hidden" id="positionName" name="positionName"
                      value="${positionMana.positionName}" class="jobEdit-name radius1"> <!-- <span
                      class="font-icon icon-reply-all copy-posi" title="从其他职位复制"></span>  --> <span
                      class="jobEdit-font-size">${positionMana.positionName}</span></td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">岗位ID：</font>
                    </td>
                    <td><span id="positionCode" class="jobEdit-font-size">${positionMana.positionCode}</span>
                    </td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">招聘对象：</font>
                    </td>
                    <td style="display: none;"><t:dictSelect type="checkbox"
                        field="recruitObject" domClass="recruit-object" typeGroupCode="recruit-obj"
                        defaultVal="" hasLabel="false"></t:dictSelect></td>
                    <td>${positionMana.recruitObject}</td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">招聘类别：</font>
                    </td>
                    <td><t:dictSelect type="checkbox" field="recruitType"
                        domClass="recruit-type" typeGroupCode="recruit-type" defaultVal=""
                        hasLabel="false"></t:dictSelect></td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">职能类别：</font>
                    </td>
                    <td style="display: none;"><t:dictSelect type="select" id="positionType"
                        field="position-type" typeGroupCode="position-type" defaultVal="0"
                        hasLabel="false"></t:dictSelect></td>
                    <td>${positionMana.positionType}</td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font><font class="font-title">职位级别：</font></td>
                    <c:if test="${recruitDemand.employeeType ne '0' }">
                      <td style="display: none;"><input id="positionLevel"
                        class="mini-combobox" name="positionLevel" cls="asLabel" readonly="readonly"
                        valueField="typeCode" textField="typeName" value="${post.positionLevel}"
                        url="/recruit/datadictGroupTypeController/getDictsByCode/rank_recruit_demand" />
                      </td>
                    </c:if>
                    <c:if test="${recruitDemand.employeeType eq '0' }">
                      <td style="display: none;"><input id="positionLevel"
                        class="mini-combobox" name="positionLevel" cls="asLabel" readonly="readonly"
                        valueField="typeCode" textField="typeName" value="${post.positionLevel}"
                        url="/recruit/datadictGroupTypeController/getDictsByCode/siterank_recruit_demand" />
                      </td>
                    </c:if>
                    <td>${positionMana.positionLevel}</td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">工作地区：</font>
                    </td>
                    <td style="display: none;"><t:dictSelect type="select" id="workPlace1"
                        field="workPlace" typeGroupCode="work-place" domClass="recruit-select"
                        defaultVal="0" hasLabel="false"></t:dictSelect> <!-- <input type="hidden" id="workPlace" name="workPlace" value="选择地区" class="recruit-choosebtn areaSelect radius"/> -->
                    </td>
                    <td>${positionMana.workPlace}</td>
                  </tr>
                  <%-- <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">公司：</font>
                    </td>
                    <td><t:dictSelect type="select" id="workPlace1" field="workPlace"
                        typeGroupCode="work-place" domClass="recruit-select" defaultVal="0"
                        hasLabel="false"></t:dictSelect> <!-- <input type="hidden" id="workPlace" name="workPlace" value="选择地区" class="recruit-choosebtn areaSelect radius"/> -->
                    </td>
                  </tr> --%>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">职位类别：</font></td>
                    <td style="display: none;"><input type="text" id="positionSimilar"
                      name="positionSimilar"
                      onclick="showAtPos('position-category-win','#positionSimilar',positionCategoryinit)"
                      value="选择/修改" class="recruit-choosebtn radius" /></td>
                    <td id="positionSimilarStr"></td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">招聘人数：</font>
                    </td>
                    <td style="display: none;"><input type="text" id="recruitNumbers"
                      name="recruitNumbers" value="${positionMana.recruitNumbers}"
                      class="jobEdit-num radius1"> &nbsp;&nbsp;<span
                      class="jobEdit-font-size"></span></td>
                    <td>${positionMana.recruitNumbers}</td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">有效期：</font>
                    </td>
                    <td style="display: none;"><t:dictSelect type="select" id="validaty"
                        field="validaty" typeGroupCode="validity" defaultVal="2" hasLabel="false"></t:dictSelect></td>
                    <td>${positionMana.validaty}</td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">提供月薪：</font>
                    </td>
                    <td style="display: none;"><t:dictSelect type="select" id="salary"
                        field="salary" domClass="recruit-select" typeGroupCode="salary"
                        defaultVal="0" hasLabel="false"></t:dictSelect> &nbsp;<span
                      class="jobEdit-font-size">(单位:元)</span></td>
                    <td>${positionMana.salary}</td>
                  </tr>

                  <%--  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">职位要求：</font>
                    </td>
                    <td><input type="text" id="positionRequire" name="positionRequire"
                      value="选择/修改" class="recruit-choosebtn radius"
                      onclick="showAtPos('position-requirement-win','#positionRequire')"></td>
                  </tr> --%>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">所属行业：</font>
                    </td>
                    <td style="display: none;"><t:dictSelect type="select"
                        id="positionIndustry" field="positionIndustry" domClass="recruit-select"
                        typeGroupCode="industry" defaultVal="0" hasLabel="false"></t:dictSelect></td>
                    <td>${positionMana.positionIndustry}</td>
                  </tr>

                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">发布的渠道：</font>
                    </td>
                    <td><input name="trench" class="mini-checkboxlist" id="trench"
                      onvaluechanged="checkRecruitType"
                      data="[{id: 1, text: '前程无忧网'}, {id: 2, text: '智联'}, {id: 3, text: '猎聘网'}, {id: 4, text: '中国人才热线'}
                      , {id: 5, text: '华星官网'}, {id: 6, text: '荐客'}]" /></td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td><font class="marker-color">*</font> <font class="font-title">网站发布岗位名称：</font>
                    </td>
                    <td><input type="text" name="websitePostName" id="websitePostName"
                      value="${positionMana.websitePostName}" class="jobEdit-text radius1"></input></td>
                  </tr>
                </tbody>
              </table>
              <table class="jobEdit-tab">
                <tr class="jobEdit-tr needHideWz">
                  <td><font class="marker-color">*</font> <font class="font-title">职位描述与要求（外招）
                      ：</font></td>
                  <td><span class="jobEdit-font-size">请输入2000字以内的职位描述与要求。(已输入 <font
                      class="word_count" style="font-size: 18px; font-family: Constantia, Georgia;"></font>
                      字)
                  </span></td>
                </tr>
                <%-- <tr class="jobEdit-tr">
                      <td><font class="font-title">专车职位:</font></td>
                      <td><input type="checkbox"><label>提供面试专车</label></td>
                    </tr> --%>
                <tr class="jobEdit-tr needHideWz" id="content_1_tr">
                  <td colspan="3">
                    <div>
                      <textarea id="content_1" id="positionDescription" name="positionDescription">
                      ${positionMana.positionDescription}
                      </textarea>
                    </div>
                  </td>
                </tr>
                <tr class="jobEdit-tr needHide">
                  <td><font class="marker-color">*</font> <font class="font-title">职位描述与要求（内招）2
                      ：</font></td>
                  <td><span class="jobEdit-font-size">请输入2000字以内的职位描述与要求。(已输入 <font
                      class="word_count2" style="font-size: 18px; font-family: Constantia, Georgia;"></font>
                      字)
                  </span></td>
                </tr>
                <tr class="jobEdit-tr needHide" id="content_2_tr">
                  <td colspan="3">
                    <div>
                      <textarea id="content_2" id="positionDescription2" name="positionDescription2">
                       ${positionMana.positionDescription2}</textarea>
                    </div>
                  </td>
                </tr>
              </table>
            </div>
            <div class="jobEdit-info  blue radius"></div>
            <div class="jobEdit-submit"></div>
          </form>
        </div>
      </div>
    </div>

    <div id="sublist"></div>
    <div id="countyList"></div>


    <!-- 选择职位类别 -->
    <div id="position-category-win" class="mini-window" style="width: 608px; display: none;"
      title="选择职位类别" showFooter="true">
      <div class="position-category-middle radius">
        <div class="position-category-middle-inner">
          <b>&nbsp;&nbsp;已选择职位</b>&nbsp;&nbsp;<span class="gray">最多选5个</span>&nbsp;&nbsp;<span
            class="position-category-prompt"></span>
        </div>
        <div class="choose-position-data"></div>
      </div>
      <div class="choose-position-category">
        <div class="choose-position-td radius">
          <span id="choose-position-span">浏览所有职位大类<span class="font-icon icon-down"></span></span>
        </div>
        <div class="choose-position-text">
          <input type="text" class="choose-position-input radius search-input"
            value="快速查找职位/中文/英文/拼音">
        </div>
      </div>
      <!-- 职位类别数据 -->
      <div class="position-category-pdata"></div>
      <div class="position-category-data"></div>
      <div property="footer" class="win-footer">
        <input type="button" class="win-footer-btn" value="确定"
          onclick="positionCategory.submitCategoryData()"> <input type="button"
          class="win-footer-btn" value="取消" onclick="hideWindow('position-category-win')">
      </div>
    </div>


  </div>
</body>
<script type="text/javascript">
  var demandId = "${recruitDemand.id}";
  var demandIdPostId = "${recruitDemand.applyPostId}";
  var postId = "${post.recruitPositionId}";
</script>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
<script type="text/javascript" charset="utf-8"
  src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor.js"></script>
<script type="text/javascript" src="${webRoot}/resources/js/position/positionEditUpdate.js?v=1"></script>
<script type="text/javascript" src="${webRoot}/resources/js/position/positionCategory.js"></script>
<html>