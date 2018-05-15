<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/webpage/common.jsp" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fun"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/candidate/candidatePersonalResume.css"/>
   
    <title>中文简历</title>
  </head>
  <body>
  <div class="resume-item resume-zh">
            <div class="co">
      <div class="resumeAttachmentWrap">
            <div id="resumeSourceAttachmentWrap-display">
              <span>简历附件：</span> <input type="button" id="resumeSourceUploadFileBtn" value=""
                class="uploadBtn"> <input type="hidden" id="hiddenRSC" value="9523864">
              <span><a
                href="http://pt.hirede.com/ResumeAttachment/PreviewAttachment?resumeId=9523864&amp;updatedDate=20170613112312"
                class="iconUnkown iconhtml" target="previewAttachment">简历原文</a>(48.46)KB</span> <span
                id="resumeSourceUploadedFile" class="resumeUploadedFileWrap"> <input
                id="hidUploadAttachmentUrl" name="hidUploadAttachmentUrl" type="hidden"
                value="/ResumeAttachment/UploadResumeAttachment">
    
              </span>
            </div>
          </div>

      <div class="co-title">基本信息</div>
              <div class="co-item">
               
                <div class="co-co">
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">姓名：</span><span id="" title="" class="value">${resume.name}&nbsp;</span>
                    </div>
                    <div class="co-td">
                      <span class="label">性别：</span><span id="" title="" class="value">${resume.sex}&nbsp;</span>
                    </div>
                  </div>
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">出生日期：</span><span id="resumeBirthday" class="value">${resume.birthdayStr}&nbsp;</span>
                    </div>
                    <div class="co-td">
                      <span class="label">居住地：</span><span id="currentLocation" title="" class="value">${resume.residence}&nbsp;</span>
                    </div>
                  </div>
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">工作年限：</span><span id="" title="" class="value">${resume.workExperience}年&nbsp;</span>
                    </div>
                    <div class="co-td">
                      <span class="label">婚姻状况：</span><span id="" title="" class="value">${resume.maritalStatus}&nbsp;</span>
                    </div>
                  </div>
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">手机号码：</span><span id="" title="" class="value">${resume.phone}&nbsp;</span>
                    </div>
                    <div class="co-td">
                      <span class="label">Email：</span><span id="" title="" class="value">${resume.email}&nbsp;</span>
                    </div>
                  </div>
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">联系地址：</span><span id="" title="${resume.address}" class="value">${resume.address}&nbsp;</span>
                    </div>
                  </div>
                </div>
              </div>
               <div class="co-title">求职意向</div>
              <div class="co-item zh-job-intension b-solid">
               
                <div class="co-co">
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">期望月薪：</span><span id="" title="" class="value">${resume.salaryExpect}&nbsp;</span>
                    </div>
                      <div class="co-td">
                        <c:if test="${resume.reportTime!=null}">
                          <span class="label">可到岗时间：</span><span id="" title="" class="value">${resume.reportTime}&nbsp;</span>
                        </c:if>
                      </div>
                  </div>
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">意向地区：</span><span id="" title="" class="value">${resume.workplaceExpect}&nbsp;</span>
                    </div>
                    <div class="co-td">
                      <c:if test="${resume.reportTime!=null}">
                        <span class="label">提供住房：</span><span id="" title="" class="value">${resume.provideHouse}&nbsp;</span>
                      </c:if>
                    </div>
                  </div>
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">意向行业：</span><span id="" title="" class="value">${resume.industryExpect}&nbsp;</span>
                    </div>
                    <div class="co-td"></div>
                  </div>
                  <div class="co-tr">
                    <div class="co-td">
                      <span class="label">意向岗位：</span><span id="" title="" class="value">${resume.postExpect}&nbsp;</span>
                    </div>
                  </div>
                </div>
              </div>
              <div class="co-title">工作经历</div>
              <div class="co-item zh-work-experience b-solid">
                
                <div class="co-co">
                  <c:forEach items="${resume.workExperienceList}" var="w" varStatus="status">
                    <c:choose>  
                      <c:when test="${status.last}">
                        <div class="co-co-item">
                      </c:when>
                      <c:otherwise>  
                        <div class="co-co-item b-dashed">
                      </c:otherwise>
                    </c:choose>
                      <div class="corp-job"><span>${w.companyName}</span>--<span>${w.positionName}</span></div>
                      <div class="corp-job-co">
                        <div class="co-tr">
                          <div class="co-td">
                            <span class="label">开始日期：</span><span class="value"><fmt:formatDate value="${w.jobStartDate}" pattern="yyyy年MM月"/></span>
                          </div>
                        </div>
                        <div class="co-tr">
                          <div class="co-td">
                            <span class="label">结束日期：</span><span class="value"><fmt:formatDate value="${w.jobEndDate}" pattern="yyyy年MM月"/></span>
                          </div>
                        </div>
                        <div class="co-tr">
                          <div class="co-td">
                            <span class="label">工作职责：</span><span class="value">(${w.workLength})</span>&nbsp;<span class="currency">${w.currency}</span><span class="value"><c:if test="${w.salary!=0}">${w.salary}</c:if></span>
                          </div>
                        </div>
                        <div class="job-duties font-black">${w.jobDuty}</div>
                      </div>
                    </div>
                  </c:forEach>
                </div>
              </div>
                <div class="co-title">教育经历</div>
              <div class="co-item zh-work-experience b-solid">
              
                <div class="co-co">
                  <c:forEach items="${resume.eduExperienceList}" var="e" varStatus="status">
                    <div class="co-tr">
                      <span class=""><fmt:formatDate value="${e.eduStartDate}" pattern="yyyy年MM月"/></span>-<span class=""><fmt:formatDate value="${e.eduEndDate}" pattern="yyyy年MM月"/></span>&nbsp;&nbsp;<span>${e.schoolName}</span>，<span>${e.major}</span>，<span>${e.education}</span>
                    </div>
                  </c:forEach>
                </div>
              </div>
              <c:if test="${resume.trainInfor!=null}">
                <div class="co-item zh-trainInfor b-solid">
                  <div class="co-title">培训信息</div>
                  <div class="co-co">${resume.trainInfor}</div>
                </div>
              </c:if>
              <c:if test="${resume.languageInfor!=null}">
                <div class="co-item zh-languageInfor b-solid">
                  <div class="co-title">语言信息</div>
                  <div class="co-co">${resume.languageInfor}</div>
                </div>
              </c:if>
              <c:if test="${resume.certificateInfor!=null}">
                <div class="co-item zh-certificateInfor b-solid">
                  <div class="co-title">证书信息</div>
                  <div class="co-co">${resume.certificateInfor}</div>
                </div>
              </c:if>
              <c:if test="${resume.awardInfor!=null}">
                <div class="co-item zh-awardInfor b-solid">
                  <div class="co-title">获奖信息</div>
                  <div class="co-co">${resume.awardInfor}</div>
                </div>
              </c:if>
              <c:if test="${resume.skillText!=null}">
                <div class="co-item zh-skillInfor b-solid">
                  <div class="co-title">其它技能信息</div>
                  <div class="co-co">${resume.skillText}</div>
                </div>
              </c:if>
              <c:if test="${resume.hobbyInfor!=null}">
                <div class="co-item zh-hobbyInfor b-solid">
                  <div class="co-title">获奖信息</div>
                  <div class="co-co">${resume.hobbyInfor}</div>
                </div>
              </c:if>
            </div>
  </body>

</html>