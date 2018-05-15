<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<%@include file="/webpage/common.jsp"%>
<html>
  <head>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css"/>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/interview/editInterviewInfo.css"/>
    <title>面试信息预览</title>
  </head>
  <body onload="removeLoad();">
    <div class="co" style="padding-top: 50px;">
        <div class="co-right-main co-right-center">
          <div class="con-title">面试信息预览</div>
          <div class="main">
            <form id="editform" class="jobEdit-form">
                        <input type="hidden" id="id" name="id"  value="${basicInfo.id}">
                        <input type="hidden" id="personCode" name="personCode"  value="${basicInfo.personCode}">
                        <input type="hidden" id="recruiterNumber" name="recruiterNumber" value="${basicInfo.recruiterNumber}">
                        <input type="hidden" id="recruiterName" name="recruiterName" value="${basicInfo.recruiterName}">
              <div class="jobEdit-basic-infor blue radius">
                <table class="jobEdit-tab">
                  <thead>
                    <tr class="jobEdit-tr">
                      <td><span><h2>基本信息</h2></span></td>
                    </tr>
                  </thead>
                  <tbody>
                  <tr class="jobEdit-tr">
                    <td>&nbsp;&nbsp;&nbsp;国籍： ${ basicInfo.nationality }</td>
                    <td>中文名： ${ basicInfo.cnname }</td>
                    <td>姓名拼音：${ basicInfo.namepy }</td>
                    <td>英文名：${ basicInfo.enname }</td>
                  </tr>
                  <tr class="jobEdit-tr">
                    <td>&nbsp;&nbsp;&nbsp;性别：${ basicInfo.sex }</td>
                    <td>婚姻状况： ${ basicInfo.maritalStatus }</td>
                    <td>民族：${ basicInfo.nation }</td>
                    <td>政治面貌：${ basicInfo.politicalStatus }</td>
                  </tr>
                  <tr class="jobEdit-tr">
                  <td>&nbsp;&nbsp;&nbsp;籍贯（省&市）：${ basicInfo.nativePlace }</td>
                    <td>户口性质： ${ basicInfo.residenceProperty }</td>
                    <td>户口所在地：${ basicInfo.residence }</td>
                    <td>证件类型：${ basicInfo.certificateType }</td>
                  </tr>
                   <tr class="jobEdit-tr">
                      <td>&nbsp;&nbsp;&nbsp;证件号码：${ basicInfo.certificateNum }</td>
                      <td>证件名称：${ basicInfo.certificateName }</td>
                      <td>出生日期：${ basicInfo.birthdate }</td>                      
                      <td>最高学历：${ basicInfo.highestEducation }</td>                        
                   </tr>
                   <tr class="jobEdit-tr">
                     <td>&nbsp;&nbsp;&nbsp;手机号码：${ basicInfo.phonenumber }</td>
                     <td>电子邮箱：${ basicInfo.email }</td>
                     <td>通信地址： ${basicInfo.address }</td>                          
                     <td>邮编：${ basicInfo.postcodes }</td>                      
                   </tr>
                   <tr class="jobEdit-tr">
                    <td colspan="2">&nbsp;&nbsp;&nbsp;参加工作日期（没有可不填）：${ basicInfo.startworkingdate }</td>
                    <td>应聘职位：${ basicInfo.positionName}</td>
                    <td>可到岗时间：${ basicInfo.arriveDate }</td>
                   </tr>
                   <tr class="jobEdit-tr">
                     <td colspan="2">&nbsp;&nbsp;&nbsp;您从何处得知公司招聘信息：${ basicInfo.recruitmentApproach }</td>
                     <td>推荐人姓名： ${ basicInfo.refereeName }</td>        
                     <td>其他途径：${ basicInfo.otherWay }</td>                    
                   </tr>
                   <tr class="jobEdit-tr">
                     <td colspan="2">&nbsp;&nbsp;&nbsp;是否有亲属在【华星】工作，如有请列明：${ basicInfo.relativesFlag }</td>
                     <td>姓名：${ basicInfo.relativesName }</td>                       
                     <td>关系：${ basicInfo.relativesShip }</td>                     
                    </tr>
                    <tr class="jobEdit-tr">
                    <td colspan="3">&nbsp;&nbsp;&nbsp;期待待遇（税前）：
                                                                             月薪：&nbsp;${ basicInfo.expectedSalaryMonth }&nbsp;元；&nbsp;&nbsp;
                                                                             年薪：&nbsp;${ basicInfo.expectedSalaryYear }&nbsp;万元；&nbsp;&nbsp;
                                                                             其他：&nbsp;${ basicInfo.expectedSalaryOther }         
                     </td>
                   </tr>
                  </tbody>
                </table>
              </div>
              <div class="jobEdit-role  blue radius" style="height:200px;">
                <table class="jobEdit-tab">
                  <thead>
                    <tr class="jobEdit-tr">
                      <td><span><h2>家庭成员</h2></span></td>
                    </tr>
                  </thead>
                  <tbody>
                                     <tr class="jobEdit-tr">
                                      <td class="jobEdit-td" width="99%;">
                                      <div id="datagrid-family" class="mini-datagrid" style="width:96%;height: auto;" 
                                          data="${ fs }" idField="id" 
                                          allowResize="false" showPager="false" allowAlternating="true" pageSize="5" ondrawcell="ondrawcellfs"
                                          allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextRowCell="true" >
                                          <div property="columns">
                                              <div field="menberName" headerAlign="center" allowSort="false" width="150" >主要家庭成员（姓名）
                                                 <!--  <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" /> -->
                                              </div>
                                              <div field="familyRelation" headerAlign="center" allowSort="false" width="150" >关系(请选择)
                                              </div>
                                              <div field="menberGender" headerAlign="center" allowSort="false" width="150">性别(请选择)
                                              </div>
                                              <div name="menberBirthday" field="menberBirthday" width="100" allowSort="false" dateFormat="yyyy-MM-dd">出生日期(请选择)
                                                 <!--  <input property="editor" class="mini-datepicker" format="yyyy-MM-dd" style="width:100%;" allowInput="false"/> -->
                                              </div>
                                              <div field="menberAddress" width="120" headerAlign="center" allowSort="false">工作单位或居住地
                                                 <!--  <input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/> -->
                                              </div>
                                          </div>
                                      </div>
                                      </td>
                                      </tr>
                  </tbody>
                </table>
              </div>
              
                            <div class="jobEdit-role  blue radius" style="height:200px;">
                              <table class="jobEdit-tab">
                                <thead>
                                  <tr class="jobEdit-tr">
                                    <td><span><h2>紧急联系人</h2></span></td>
                                  </tr>
                                </thead>
                                <tbody>
                                   <tr class="jobEdit-tr">
                                    <td class="jobEdit-td" width="99%;">
                                    <div id="datagrid-emergent" class="mini-datagrid" style="width:96%;height: auto;"  data="${ egms}" ondrawcell="ondrawcellegms"
                                         idField="id" 
                                        allowResize="false" showPager="false" allowAlternating="true" pageSize="5"
                                        allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextRowCell="true" >
                                        <div property="columns">
                                            <div field="emergentName" headerAlign="center" allowSort="false" width="150" >紧急联系人（姓名）
                                                <!-- <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" /> -->
                                            </div>
                                            <div field="emergentRelation" headerAlign="center" allowSort="false" width="150">关系(请选择)
                                            </div> 
                                            <div field="emergentPhone" width="100" headerAlign="center" allowSort="false">电话号码
                                                <!-- <input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" /> -->
                                            </div>
                                            <div field="emergentAddress" width="120" headerAlign="center" allowSort="false">工作单位或居住地
                                                <!-- <input property="editor" class="mini-textarea" style="width:200px;" minWidth="200" minHeight="50"/> -->
                                            </div>
                                        </div>
                                    </div>
                                    </td>
                                    </tr>
                                </tbody>
                              </table>
                            </div>
              
              <div class="jobEdit-role  blue radius">
                <table class="jobEdit-tab">
                  <thead>
                    <tr class="jobEdit-tr">
                        <td>
                                            <span><h2>教育及培训（从最高学历开始）</h2></span></br>
                                          </td>
                    </tr>
                                    </thead>
                                    <tbody id="edutb">
                                    <c:forEach var="edu" items="${ edus }" varStatus="status">
                                        <c:set var="i" value="${status.count }"></c:set>  
                                        <tr class="jobEdit-tr" title="edutr${i}">
                                          <td class="jobEdit-td" width="99%;">
                                             <div class="baseInfoLable-l">
                                                <font class="font-title">起止日期：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                             ${ edu.startDate }~${ edu.endDate }

                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="font-title">学校：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                ${ edu.schoolName }
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="font-title">专业：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                ${ edu.major }
                                             </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="edutr${i}">
                                          <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                             <div class="baseInfoLable-l">
                                                <font class="font-title">学历：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                ${ edu.education }
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="font-title">性质：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                ${ edu.eduType }
                                             </div>
                                             <div class="baseInfoLable-r">
                                                <font class="font-title">取得证书：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                                 ${ edu.certificate }
                                             </div>
                                              <div class="baseInfoLable-r">
                                                <font class="font-title">国家代码：</font>
                                             </div>
                                             <div class="baseInfoInput">
                                               ${ edu.certNationality }
                                             </div>
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="edutr${i}">
                                          <td height="10px;"></td>
                                        </tr>
                                    </c:forEach>
                                  </tbody>
                          </table>
                          <table class="jobEdit-tab">
                            <tbody>        
                              <c:forEach var="certification" items="${ certifications }" begin="0" end="1" varStatus="status">
                                    <c:set var="i" value="${status.count }"></c:set> 
                                          <tr class="jobEdit-tr">
                                            <td class="jobEdit-td" width="99%;" style="border-top: 1px solid #AEBED7;">
                                               <div class="baseInfoLable-l" style="width: 120px;">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">资格证书类别：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  ${ certification.type }
                                               </div>
                                               <div class="baseInfoLable-r" style="width: 120px;">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">资格证书名称：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  ${ certification.name }
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">获得时间：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  ${ certification.recivingDateStr }
                                               </div>
                                            </td>
                                          </tr>
                                          <tr class="jobEdit-tr">
                                            <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">证书编号：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  ${ certification.num }
                                               </div>
                                               <div class="baseInfoLable-r">
                                                  <font class="marker-color">&nbsp;&nbsp;</font>
                                                  <font class="font-title">发证机构：</font>
                                               </div>
                                               <div class="baseInfoInput">
                                                  ${ certification.authorityOrg }
                                               </div>
                                            </td>
                                          </tr>
                                   </c:forEach>      
                  </tbody>
                </table>
              </div>
                            <div class="jobEdit-role  blue radius">
                              <table class="jobEdit-tab" border="1px solid #AEBED7;">
                                <thead>
                                    <span><h2>语言及计算机</h2></span>
                                    </thead>
                                    <tbody>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd-header">
                                              <font class="font-title">计算机技能</font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">掌握程度 </font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">证书名称 </font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">语言能力</font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">掌握程度</font>
                                          </td>
                                          <td class="infoTableTd-header">
                                              <font class="font-title">等级证书</font>
                                          </td>
                                        </tr>
                                        
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="officeFlag" name="officeFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="Office" value="${lans.officeFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                             ${lans.officeSkilledLevel}
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.officeDiploma}
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="englishFlag" name="englishFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="英语" value="${lans.englishFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                          <div>
                                            ${lans.englishSkilledLevel}
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.englishDiploma}
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="sapFlag" name="sapFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="SAP/ERP" value="${lans.sapFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.sapSkilledLevel}
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.sapDiploma}
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="koreanFlag" name="koreanFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="韩语" value="${lans.koreanFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                          <div>
                                            ${lans.koreanSkilledLevel}
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.koreanDiploma}
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="vbaFlag" name="vbaFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="VBA/SQL" value="${lans.vbaFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.vbaSkilledLevel}
                                          </td>
                                          <td class="infoTableTd">
                                            ${lans.vbaDiploma}
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="japaneseFlag" name="japaneseFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="日语" value="${lans.japaneseFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd">
                                          <div>
                                            ${lans.japaneseSkilledLevel}
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.japaneseDiploma}
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr">
                                          <td class="infoTableTd">
                                              <div id="otheritFlag" name="otheritFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="其他" value="${lans.otheritFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd-1">
                                             ${lans.otheritSkilledLevel}
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.otheritDiploma}
                                          </td>
                                          <td class="infoTableTd">
                                              <div id="otherFlag" name="otherFlag" class="mini-checkbox" readOnly="true" trueValue="1" falseValue="0" text="其他" value="${lans.otherFlag}" onvaluechanged="onValueChanged"></div>
                                          </td>
                                          <td class="infoTableTd-1">
                                          <div>
                                            ${lans.otherSkilledLevel}
                                          </div>
                                          </td>
                                          <td class="infoTableTd">
                                              ${lans.otherDiploma}
                                          </td>
                                        </tr>
                                </tbody>
                              </table>
                            </div>
                            
                            <div class="jobEdit-role  blue radius">
                              <table class="jobEdit-tab">
                                <thead>
                                    <span><h2>工作履历 (请从全日制毕业后第一份工作开始完整填写，此项将影响您的社会工龄计算，没有可不用填)</h2></span>
                                    </thead>
                                    <tbody id="worktb">
                                    <c:forEach var="work" items="${ works }" varStatus="status">
                                     <c:set var="i" value="${status.count }"></c:set>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td class="job-td1">
                                              <font class="font-title">起止时间：</font></br>
                                             ${ work.startDate } ~ 
                                             ${ work.endDate }
                                          </td>
                                          <td class="job-td" colspan="2">
                                              <font class="font-title">公司名称： </font></br>
                                              ${ work.companyName }
                                          </td>
                                          <td class="job-td" colspan="2">
                                              <font class="font-title">当前/最终薪水：</font>
                                              ${ work.salary }
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td class="job-td1">
                                              <font class="font-title">所在部门：</font></br>
                                              <${ work.department }
                                          </td>
                                          <td class="job-td2">
                                              <font class="font-title">当前/最终职位： </font></br>
                                              ${ work.positionName }
                                          </td>
                                          <td class="job-td2">
                                              <font class="font-title">汇报给：</font>
                                              ${ work.debriefer }
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">下属人数：</font>
                                              ${ work.subordinate }
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">服务年限：</font>
                                              ${ work.seniority }
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td class="job-td" colspan="5">
                                              <font class="font-title">主要工作职责：</font></br>
                                              ${ work.jobDuty }
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" style="border-bottom: 2px solid #AEBED7;" title="worktr${i}">
                                          <td class="job-td" colspan="2">
                                              <font class="font-title">离职原因：</font></br>
                                              ${ work.leaveReason }
                                          </td>
                                          <td class="job-td2">
                                              <font class="font-title">证明人：</font>
                                              ${ work.reterence }
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">关系：</font>
                                              ${ work.relationship }
                                          </td>
                                          <td class="job-td3">
                                              <font class="font-title">证明人电话：</font>
                                              ${ work.reterencePhone }
                                          </td>
                                        </tr>
                                        <tr class="jobEdit-tr" title="worktr${i}">
                                          <td height="10px;"></td>
                                        </tr>
                                        </c:forEach>
                                        
                                </tbody>
                              </table>
                            </div>
                            
                            <div class="jobEdit-role  blue radius">
                                <table class="jobEdit-tab">
                                  <thead>
                                    <tr class="jobEdit-tr">
                                      <td><span><h4>奖励及特长</h4></span></td>
                                    </tr>
                                  </thead>
                                  <tbody>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;">
                                           <div class="baseInfoLable-l">
                                              <font class="font-title">奖励名称：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              ${ rews.rewardName2 }
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">获得时间：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                             ${ rews.rewardDate2 }
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">颁发机构：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              ${ rews.authorities2 }
                                           </div>
                                        </td>
                                      </tr>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="baseInfoLable-l">
                                              <font class="font-title">奖励名称：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              ${ rews.rewardName3 }
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">获得时间：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              ${ rews.rewardDate3 }
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">颁发机构：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              ${ rews.authorities3 }
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="baseInfoLable-l">
                                              <font class="font-title">兴趣爱好：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                             ${ rews.hobby }
                                           </div>
                                           <div class="baseInfoLable-r">
                                              <font class="font-title">特长：</font>
                                           </div>
                                           <div class="baseInfoInput">
                                              ${ rews.speciality }
                                           </div>
                                        </td>
                                      </tr>
                                  </tbody>
                                </table>
                              </div>
                              
                              <div class="jobEdit-role  blue radius" style="height:200px;">
                              <table class="jobEdit-tab">
                                <thead>
                                  <tr class="jobEdit-tr">
                                    <td><span><h2>推荐信息（*【华星】非常认同和重视招聘中的人脉资源，请向我们推荐您的三名同事或朋友。）(点击表格进行编辑)</h2></span></td>
                                  </tr>
                                </thead>
                                <tbody>
                                   <tr class="jobEdit-tr">
                                    <td class="jobEdit-td" width="99%;">
                                    <div id="datagrid-recommended" class="mini-datagrid" style="width:96%;height: auto;"  data="${rec}"
                                         idField="id" 
                                        allowResize="false" showPager="false" allowAlternating="true" pageSize="5"
                                        allowCellEdit="true" allowCellSelect="true" multiSelect="true" editNextRowCell="true" >
                                        <div property="columns">
                                            <div field="recommended" headerAlign="center" allowSort="false" width="150" >被推荐人
                                            </div>
                                            <div field="recommendRelation" width="100" allowSort="false" >关系
                                            </div>
                                            <div field="recommendPosition" width="100" allowSort="false" >推荐职位
                                            </div>       
                                            <div field="recommendPhone" width="120" headerAlign="center" allowSort="false">电话号码
                                            </div>
                                            <div field="recommendAddress" width="120" headerAlign="center" allowSort="false">工作单位或居住地
                                            </div>
                                        </div>
                                    </div>
                                    </td>
                                    </tr>
                                </tbody>
                              </table>
                            </div>

              <div class="security-settings  blue radius">
                            <input type="hidden" id="infectionId" name="infectionId"  value="${ill.id}">
                <table class="security-tab">
                  <thead>
                    <tr class="jobEdit-tr">
                      <td class="jobEdit-td"><span>
                            <h2>声明</h2>
                      </span></td>
                    </tr>
                  </thead>
                  <tbody>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="font-title">您是否有家族遗传病史、传染病史或其它重大疾病史？如有请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                                    <c:if test="${ ill.infectionFlag ==1}">
                                                                                                                                                          没有
                                              </c:if> 
                                              <c:if test="${ ill.infectionFlag ==2}">
                                                                                                                                                          有
                                              </c:if>
                                           </div>
                                           <div class="illustrate-r">
                                              ${ ill.infectionText }
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="font-title">您是否有过刑事犯罪记录？如有请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                              <c:if test="${ ill.criminalFlag ==1}">
                                                                                                                                                          没有
                                              </c:if> 
                                              <c:if test="${ ill.criminalFlag ==2}">
                                                                                                                                                          有
                                              </c:if>
                                           </div>
                                           <div class="illustrate-r">
                                              ${ ill.criminalText }
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="font-title">您是否仍与其他雇主存在雇佣关系吗？如有请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                                  <c:if test="${ ill.employFlag ==1}">
                                                                                                                                                          没有
                                              </c:if> 
                                              <c:if test="${ ill.employFlag ==2}">
                                                                                                                                                          有
                                              </c:if>
                                           </div>
                                           <div class="illustrate-r">
                                             ${ ill.employText }
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-l">
                                              <font class="font-title">您是否愿意配合我司做背景调查？如不愿意的，请说明。</font>
                                           </div>
                                           <div class="illustrate-m">
                                                <c:if test="${ ill.investigateFlag ==1}">
                                                                                                                                                                   愿意                                                              
                                              </c:if> 
                                              <c:if test="${ ill.investigateFlag ==2}">
                                                                                                                                                          不愿意
                                              </c:if>
                                              
                                           </div>
                                           <div class="illustrate-r">
                                              ${ ill.investigateText }
                                           </div>
                                        </td>
                                      </tr>
                                      
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;">
                                           <div class="illustrate-l">
                                              <font class="font-title">您是否与其他单位签署了竞业禁止协议且尚在竞业限制期限内？</font>
                                           </div>
                                           <div class="illustrate-m">
                                                  <c:if test="${ ill.banFlag ==1}">
                                                                                                                                                          没有
                                              </c:if> 
                                              <c:if test="${ ill.banFlag ==2}">
                                                                                                                                                          有
                                              </c:if>
                                           </div>
                                        </td>
                                      </tr>
                                      <tr class="jobEdit-tr">
                                        <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;">
                                           <div class="illustrate-m">
                                              <font class="font-title">如有请补充以下信息：</font>
                                           </div>
                                           <div class="illustrate-l" style="width: 80%">
                                                                                                                                                签订期限：
                                           ${ ill.banStartdate }~ 
                                           ${ ill.banEnddate }
                                            &nbsp;&nbsp;且补偿金金额：${ ill.payment }&nbsp;万元
                                           </div>
                                        </td>
                                      </tr>
                  
                  </tbody>
                </table>
              </div>
          </div>
        </div>
    
    <!-- 选择招聘专员 -->
    <jsp:include page="/webpage/com/csot/publicPage/choosePerson.jsp"></jsp:include>
    </div>
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
  <script type="text/javascript">
  var Genders = [{ code: 1, text: '男' }, { code: 2, text: '女'}];
  var familyRelations = [{ code: 1, text: '父母' }, { code: 2, text: '配偶'}, { code: 3, text: '兄弟姐妹'}, { code: 4, text: '子女'}];
  var emergentRelations=[{ code: 1, text: '父母' }, { code: 2, text: '配偶'}, { code: 3, text: '兄弟姐妹'}, { code: 4, text: '朋友'}, { code: 5, text: '其他亲戚'}, { code: 6, text: '其他'}];
  function onfamilyRelationRenderer(e) {
    for (var i = 0, l = familyRelations.length; i < l; i++) {
        var g = familyRelations[i];
        if (g.id == e.value) return g.text;
    }
    return "";
  }
  
$(document).ready(function() {
  
  // 初始化mini ui
  mini.parse(); 
  var webRoot = "${webRoot}";
  var grid = mini.get("datagrid-family");
  var FamilyContacts = [{"menberName":""},{"menberName":""},{"menberName":""},{"menberName":""}];
  var emergentContact = [{"emergentName":""},{"emergentName":""}];
  var recommendedContact = [{"recommended":""},{"recommended":""},{"recommended":""}];

  if('${fs}'!=''){
    grid.setData(${fs});
  }else{
    grid.setData(FamilyContacts);
  }     
    grid.on("cellclick",function(e){ 
      var field=e.field;
       if( field=="emergentFlag" ){
         emergentEvent();
      }
    });
    
    var grid2 = mini.get("datagrid-emergent");
    if('${egms}'!=''){
      grid2.setData(${egms});
  }else{
    grid2.setData(emergentContact);
  } 
    
    var grid3 = mini.get("datagrid-recommended");
    if('${rec}'!=''){
      grid3.setData(${rec});
  }else{
    grid3.setData(recommendedContact);
  } 
    
    //为页面元素添加绑定事件
    bindingEvent();
    
    //工作经验
    var wks = "${works}";
    wkcount = 0;
    if(wks){
      wkcount = wks.split(",").length;
    }
    //教育经历
    var eds = "${edus}";
    educount = 0;
    if(eds){
      educount = eds.split(",").length;
    }
    //证书
    var certs = "${certifications}";
    cetcount = 0;
    if(certs){
      cetcount = certs.split(",").length;
    }
});

function addWorks(){
  var workArea = $("#worktb");
  wkcount++;
  var workHTML = '<tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td class="job-td1"> <font class="font-title">起止时间：</font></br> <input id="workstartdate'+wkcount+'" name="workstartdate" class="radius1 mini-datepicker" type="text" style="width: 100px" tabindex="7" /> ~ <input id="workenddate'+wkcount+'" name="workenddate" class="radius1 mini-datepicker"  type="text" style="width: 100px" tabindex="7" /> </td> <td class="job-td" colspan="2"> <font class="font-title">公司名称： </font></br> <input type="text" id="companyName'+wkcount+'" name="companyName" class="radius1"> </td> <td class="job-td" colspan="2"> <font class="font-title">当前/最终薪水：</font> <input type="text" id="finalSalary'+wkcount+'" name="salary" class="radius1"> </td></tr><tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td class="job-td1"> <font class="font-title">所在部门：</font></br> <input type="text" id="department'+wkcount+'" name="department" class="radius1"> </td> <td class="job-td2"> <font class="font-title">当前/最终职位： </font></br> <input type="text" id="finalPosition'+wkcount+'" name="positionName" class="radius1"> </td> <td class="job-td2"> <font class="font-title">汇报给：</font> <input type="text" id="reportTo'+wkcount+'" name="debriefer" class="radius1"> </td> <td class="job-td3"> <font class="font-title">下属人数：</font> <input type="text" id="subordinates'+wkcount+'" name="subordinate" value="0" class="radius1"> </td> <td class="job-td3"> <font class="font-title">服务年限：</font> <input type="text" id="seniority'+wkcount+'" name="seniority" class="radius1"> </td></tr><tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td class="job-td" colspan="5"> <font class="font-title">主要工作职责：</font></br> <input type="text" id="responsibilities'+wkcount+'" name="jobDuty" class="radius2"> </td></tr><tr class="jobEdit-tr" style="border-bottom: 2px solid #AEBED7;" title="worktr'+wkcount+'"> <td class="job-td" colspan="2"> <font class="font-title">离职原因：</font></br> <input type="text" id="leaveReason'+wkcount+'" name="leaveReason" class="radius2"> </td> <td class="job-td2"> <font class="font-title">证明人：</font> <input type="text" id="reterence'+wkcount+'" name="reterence" class="radius1"> </td> <td class="job-td3"> <font class="font-title">关系：</font> <input type="text" id="relationship'+wkcount+'" name="relationship" class="radius1"> </td> <td class="job-td3"> <font class="font-title">证明人电话：</font> <input type="text" id="reterencePhone'+wkcount+'" name="reterencePhone" value="${ work.reterencePhone }" class="radius1"> </td></tr><tr class="jobEdit-tr" title="worktr'+wkcount+'"> <td height="10px;"></td></tr>';
  workArea.append(workHTML);
  mini.parse();
}

function deleteWorks(){
  if(!wkcount || wkcount<=1){
    return;
  }
  var workArea = $("#worktb tr");
  workArea.remove("tr[title=worktr"+wkcount+"]");
  wkcount--;
}

function addEdus(){
  var eduArea = $("#edutb");
  educount++;
  var eduHTML = '<tr class="jobEdit-tr" title="edutr'+educount+'"> <td class="jobEdit-td" width="99%;"> <div class="baseInfoLable-l"> <font class="marker-color">*</font> <font class="font-title">起止日期：</font> </div> <div class="baseInfoInput"> <input id="eduStartDate'+educount+'" name="eduStartDate" class="radius1 mini-datepicker" type="text" style="width: 110px" tabindex="7"/> ~ <input id="eduEndDate'+educount+'" name="eduEndDate" class="radius1 mini-datepicker" type="text" style="width: 110px" tabindex="7"/> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">学校：</font> </div> <div class="baseInfoInput"> <input type="text" id="schoolName'+educount+'" name="schoolName" class="radius1"> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">专业：</font> </div> <div class="baseInfoInput"> <input type="text" id="major'+educount+'" name="major" class="radius1"> </div> </td></tr> <tr class="jobEdit-tr" title="edutr'+educount+'"> <td class="jobEdit-td" width="99%;" style="border-bottom: 1px solid #AEBED7;"> <div class="baseInfoLable-l"> <font class="marker-color">*</font> <font class="font-title">学历：</font> </div> <div class="baseInfoInput"> <t:dictSelect labelClass="interview" type="select" id="education'+educount+'" field="education" typeGroupCode="educational-background" defaultVal="${ edu.education }" hasLabel="false"></t:dictSelect> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">性质：</font> </div> <div class="baseInfoInput"> <t:dictSelect labelClass="interview" type="select" id="eduType'+educount+'" field="eduType" domClass="educationalType" typeGroupCode="educational-type" defaultVal="${ edu.eduType }" hasLabel="false"></t:dictSelect> </div> <div class="baseInfoLable-r"> <font class="marker-color">*</font> <font class="font-title">取得证书：</font> </div> <div class="baseInfoInput"> <t:dictSelect labelClass="interview" type="checkbox" id="certificate'+educount+'" field="certificate" domClass="certificate'+educount+'" typeGroupCode="get-certificate" defaultVal="${ edu.certificate }" hasLabel="false"></t:dictSelect> </div> </td></tr> <tr class="jobEdit-tr" title="edutr'+educount+'"> <td height="10px;"></td></tr>';
  eduArea.append(eduHTML);
  mini.parse();
}

function deleteEdus(){
  if(!educount || educount<=1){
    return;
  }
  var eduArea = $("#edutb tr");
  eduArea.remove("tr[title=edutr"+educount+"]");
  educount--;
}


function makePinyin(value) {
    var res = $.ajax({
      type:'post',        
      url:'${webRoot}/interviewInfoController/getPinyin',
      data: { str:value },
      async:false
    }).responseText;
    
    var resArr = res.split(',');
    if(resArr.length > 1) {
        $('#namepy').css('display','none');
      $('#namepychk').css('display','block');
      $('#namepychk').empty();
      var objSelect = document.getElementById("namepychk");
      for(var i=0; i<resArr.length; i++) {
          var new_opt = new Option(resArr[i], resArr[i]);      
          objSelect.options.add(new_opt);
      }
      $('#namepy').val(resArr[0]);
    } else {
      $('#namepy').val(res);
      $('#namepy').css('display','block');
      $('#namepychk').css('display','none');
    }
}

function makeNamePy() {
  var objSelect = document.getElementById("namepychk");
  $('#namepy').val(objSelect.options[objSelect.selectedIndex].text);
}


function ondrawcellfs(e) {
var row = e.row, column = e.column, field = e.field, value = e.value;
// 超链接任务
if (field == "familyRelation") {
  if(value == 1){
    e.cellHtml = '父母';
  }
  if(value == 2){
    e.cellHtml = '配偶';
  }
  if(value == 3){
    e.cellHtml = '兄弟姐妹';
  }
  if(value == 4){
    e.cellHtml = '子女';
  }
}
if (field == "menberGender") {
  if(value == 1){
    e.cellHtml = '男';
  }
  if(value == 2){
    e.cellHtml = '女';
  }
}


}


function ondrawcellegms(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  // 超链接任务
  if (field == "emergentRelation") {
    if(value == 1){
      e.cellHtml = '父母';
    }
    if(value == 2){
      e.cellHtml = '配偶';
    }
    if(value == 3){
      e.cellHtml = '兄弟姐妹';
    }
    if(value == 4){
      e.cellHtml = '子女';
    }
    if(value == 5){
      e.cellHtml = '其他亲戚';
    }
    if(value == 6){
      e.cellHtml = '其他';
    }
  }
  


  }

  </script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript"  charset="utf-8"  src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/interview/editInterviewInfo.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/department.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionCategory.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/pinyin.js"></script>
<html>
