<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
	  <title>职位预览</title>
	  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/position/positionManage.css"/>
  	<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/position/positionInfo.css"/>
  </head>
  <body>
    <div class="position-info" >
      <div style="margin-left:100px; background-color: #FFFFFF;" >
        <div>
          <table class="position-info-tab1">
            <tr class="position-info-tr1" >
              <td class="position-info-td1" >
               <button class="button-up" id="position-info-button1" >职位信息</button>&nbsp;
               <button class="button-out" id="position-info-button2" >匹配问题</button>
              </td>
            </tr>
          </table>
        </div>
        <div class="position-info2">
	        <div class="position-info-baseInfo">
	          <table class="position-info-tab2">
	            <thead>
	              <tr>
	                <td width="33%" colspan="3">
	                  <strong>${positionManage.positionName }</strong>
	                </td>
	              </tr>
	            </thead>
	            <tbody>
	              <tr>
	                <td><span class="position-info-span">招聘专员:</span><span>&nbsp;&nbsp;${positionManage.recruiterName}</span></td>
	                <td><span class="position-info-span">其他招聘专员:</span><span>&nbsp;&nbsp;${positionManage.recruitPersonOther}</span></td>
	                <td><span class="position-info-span">更新时间:</span>&nbsp;&nbsp;<span><fmt:formatDate value="${positionManage.distributeDate}" pattern="yyyy-MM-dd"/></span></td>
	              </tr>
	              <tr>
	                <td><span class="position-info-span">用人部门主管:</span><span>&nbsp;&nbsp;${positionManage.departmentManager}</span></td>
	                <td><span class="position-info-span">简历接收邮箱:</span><span>&nbsp;&nbsp;${positionManage.receiveEmail}</span></td>
	                <td><span class="position-info-span">保密类型:</span><span>&nbsp;&nbsp;${positionManage.secrecy}</span></td>
	              </tr>
	              <tr>
	                <td><span class="position-info-span">需求人数:</span><span>&nbsp;&nbsp;${positionManage.demands}</span></td>
	                <td><span class="position-info-span">需求类型:</span><span>&nbsp;&nbsp;${positionManage.demandType}</span></td>
	                <td><span class="position-info-span">职位生效日期:</span><span>&nbsp;&nbsp;<fmt:formatDate value="${positionManage.effectiveDate}" pattern="yyyy-MM-dd"/></span></td>
	              </tr>
	              <tr>
	                <td><span class="position-info-span">期望到岗日期:</span><span>&nbsp;&nbsp;<fmt:formatDate value="${positionManage.expectDate}" pattern="yyyy-MM-dd"/></span></td>
	                <td><span class="position-info-span">是否是专车职位:</span><span>&nbsp;&nbsp;</span></td>
	                <td><span class="position-info-span"></span></td>
	              </tr>
	            </tbody>
	          </table>
	        </div>
	        
	        <div class="position-info-all">
	          <!-- 基本信息 -->
	          <div class="baseInfo-title"><strong>基本信息</strong></div>
	          <div class="baseInfo">
	            <table class="baseInfo-tab1">
	              <tr>
	                <td width="100px"><span>职位名称:</span></td>
	                <td width="300px"><span>${positionManage.positionName}</span></td>
	                <td width="100px"><span>职位编码:</span></td>
	                <td width="300px"><span>${positionManage.positionCode}</span></td>
	              </tr>
	              <tr>
	                <td><span>内部编码:</span></td>
	                <td><span>${positionManage.departmentCode}</span></td>
	                <td><span>部门:</span></td>
	                <td><span>${positionManage.departmentName}</span></td>
	              </tr>
	              <tr>
	                <td><span>招聘对象:</span></td>
	                <td><span>${positionManage.recruitObject}</span></td>
	                <td><span>工作地点:</span></td>
	                <td><span>${positionManage.workPlace}</span></td>
	              </tr>
	              <tr>
	                <td><span>职位类别:</span></td>
	                <td><span>${fn:split(positionManage.positionSimilar,':')[1]}</span></td>
	                <td><span>职能类别:</span></td>
	                <td><span>${positionManage.positionType}</span></td>
	              </tr><tr>
	                <td><span>职位级别:</span></td>
	                <td><span>${positionManage.positionLevel}</span></td>
	                <td><span>招聘人数:</span></td>
	                <td><span>${positionManage.recruitNumbers}</span></td>
	              </tr>
	              <tr>
	                <td><span>发布人:</span></td>
	                <td><span>${positionManage.publisherName}</span></td>
	                <td><span>月薪:</span></td>
	                <td><span>${positionManage.salary}</span></td>
	              </tr>
	              <tr>
	                <td><span>发布日期:</span></td>
	                <td><span><fmt:formatDate value="${positionManage.releaseDate}" pattern="yyyy-MM-dd"/></span></td>
	                <td><span>招聘类型:</span></td>
	                <td><span>${positionManage.recruitType}</span></td>
	              </tr>
	              <tr>
	                <td><span>截至日期:</span></td>
	                <td><span><fmt:formatDate value="${positionManage.expireDate}" pattern="yyyy-MM-dd"/></span></td>
	                <td><span>所属行业:</span></td>
	                <td><span>${positionManage.positionIndustry}</span></td>
	              </tr>
	            </table>
	          </div>
	          
	          <!-- 基本要求 -->
	          <div class="baseRequirement">
	            <div class="baseInfo-title"><strong>基本要求</strong></div>
	            <div class="baseRequirement-info">
	              <table class="baseRequirement-tab1">
	                <tr>
	                  <td width="100px"><span>年龄:</span></td>
	                  <td width="300px"><span>
		                  <c:choose>
		                    <c:when test="${positionManage.ageMin eq 0 && positionManage.ageMax eq 0}">不限</c:when>
	                      <c:when test="${positionManage.ageMin > 0 && positionManage.ageMax > 0}">${positionManage.ageMin}~${positionManage.ageMax}</c:when>
	                      <c:when test="${positionManage.ageMin eq 0 && positionManage.ageMax > 0}">${positionManage.ageMax}以下</c:when>
	                      <c:when test="${positionManage.ageMax eq 0 && positionManage.ageMin > 0}">${positionManage.ageMin}以上</c:when>
	                      <c:otherwise>""</c:otherwise>
		                  </c:choose>  
	                    </span>
	                  </td>
	                  <td width="100px"><span>工作年限:</span></td>
	                  <td width="300px">
	                    <span>
	                      <c:choose>
	                        <c:when test="${positionManage.workExperienceMin eq 0 && positionManage.workExperienceMax eq 0}">不限</c:when>
	                        <c:when test="${positionManage.workExperienceMin > 0 && positionManage.workExperienceMax > 0}">${positionManage.workExperienceMin}~${positionManage.workExperienceMax}</c:when>
	                        <c:when test="${positionManage.workExperienceMin eq 0 && positionManage.workExperienceMax > 0}">${positionManage.workExperienceMax}年以下</c:when>
	                        <c:when test="${positionManage.workExperienceMax eq 0 && positionManage.workExperienceMin > 0}">${positionManage.workExperienceMin}年以上</c:when>
	                        <c:otherwise>""</c:otherwise>
	                      </c:choose>  
	                    </span>
	                  </td>
	                </tr>
	                <tr>
	                  <td><span>英语等级:</span></td>
	                  <td><span>${positionManage.englishLevel}</span></td>
	                  <td><span>学历:</span></td>
	                  <td>
	                    <span>
	                      <c:choose>
	                        <c:when test="${positionManage.educationMin eq '不限' && positionManage.educationMax eq '不限'}">不限</c:when>
	                        <c:when test="${positionManage.educationMin eq '不限' && positionManage.educationMax ne '不限'}">${positionManage.educationMax}以下</c:when>
	                        <c:when test="${positionManage.educationMin ne '不限' && positionManage.educationMax eq '不限'}">${positionManage.educationMin}以上</c:when>
	                        <c:when test="${positionManage.educationMin ne '不限' && positionManage.educationMax ne '不限'}">${positionManage.educationMin}~${positionManage.educationMax}</c:when>
	                        <c:otherwise>""</c:otherwise>
	                      </c:choose>  
	                    </span>
	                  </td>
	                </tr>
	                  <tr>
	                  <td><span>性别:</span></td>
	                  <td><span>${positionManage.gender}</span></td>
	                  <td><span></span></td>
	                  <td></td>
	                </tr>
	              </table>
	            </div>
	          </div>
	          <div class="phone_no" id="validateChecked" style="display:none;">
                <div class="phone-info_tanchu">
                  <div class="tanchujiantou"></div>
                  <div class="tanchu_nr">请选择职位</div>                        
                </div>
              </div>
	          <!-- 职位描述 -->
	          <div class="positionDescribed">
	            <div class="baseInfo-title"><strong>职位描述</strong></div>
	            <div class="positionDescribed-info">
	              <div class="position-duty">
	                <br>
	                <span>${positionManage.positionDescription }</span>
	              </div>
	            </div>
	          </div>
	        </div>
	        <!-- 您可以进行的相关操作 -->
	        <div class="youCanDo">
	          <div class="positionIno-youCanDo">
	            <div class="youCanDo-td">
	              <span><b>您可以</b></span>
	            </div>
	          </div>
	          <ul>
	            <c:if test="${not empty u_position_distribute }">
	            <li><a href="${webRoot}/webpage/com/csot/position/positionDistribute.jsp?recruitPositionId=' + ${positionManage.recruitPositionId} + '">分发</a></li>
	            </c:if>
	            <li><a href="">刷新</a></li>
	            <c:if test="${not empty u_position_enablePosition }">
	            <li onclick="setPosition('${positionManage.recruitPositionId}','position-enable-win')"><a>启用</a></li>
	            </c:if>
	            <c:if test="${not empty u_position_updatePositionStatus }">
	            <li onclick="setPosition('${positionManage.recruitPositionId}','position-complete-win')"><a >完成招聘</a></li>
	            <li onclick="setPosition('${positionManage.recruitPositionId}','position-pause-win')"><a >暂停招聘</a></li>
	            </c:if>
	            <c:if test="${not empty u_position_delPosition }">
	            <li onclick="setPosition('${positionManage.recruitPositionId}','position-del-win')"><a >删除</a></li>
	            </c:if>
	            <c:if test="${not empty u_position_save }">
	            <li><a href="${webRoot}/position/positionEdit ?positionInfoEdit=${positionManage.recruitPositionId}">编辑</a></li>
	            </c:if>
	            <li><a href="">匹配设置</a></li>
	            <c:if test="${not empty u_position_setSecurity }">
	              <li onclick="setPosition('${positionManage.recruitPositionId}','position-security-win')"><a>保密设置</a></li>
	            </c:if>
	            <c:if test="${not empty u_position_againRelease }">
	              <li onclick="setPosition('${positionManage.recruitPositionId}','position-againRelease-win')"><a>重新发布</a></li>
	            </c:if>
	          </ul>
	      </div>
      </div>
      	<jsp:include page="/webpage/com/csot/publicPage/positionSet.jsp"></jsp:include>
    	</div>
   	</div>
   	<div class="position-info-bottom">
      <p class="position-info-statement">
        <span>关于华星光电</span>&nbsp;|&nbsp;<span>问题反馈</span>&nbsp;|&nbsp;<span>联系我们</span>
      </p>
      <br>
      <p>
        <span>Copyright© 2015 CSOT.Inc. All rights reserved.</span>
      </p>
    </div>
  </body>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionManage.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionInfo.js"></script>
  

  
</html>