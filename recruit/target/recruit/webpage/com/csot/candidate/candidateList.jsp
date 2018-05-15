<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>候选人列表</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
  <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/resume/resumeRepository.css"/>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.css"/>
<style type="text/css">
.position-candidate-operate{
  width: 250px;
  height: 150px;
  background-color: white;
  position: absolute;
  border:1px solid #A9CCDE;
  z-index:200;
  display:none;
}
.position-candidate-right{
  margin-top:10px;
  float:right;
  width:90%;
  height:100%;
  margin-right:5px;
}
.mini-tree .mini-grid-rows-view {height: 100%;}
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
     <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">招聘流程</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">候选人列表</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="main">
          <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                  <button class="posi-import-btn blue tab-up" id="task-button"
                    onclick="choseState('1',this)">
                    <span>全部</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('2',this)">
                    <span>已关注</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('3',this)">
                   <span>未推荐</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('4',this)">
                    <span>已推荐已反馈</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('5',this)">
                    <span>已推荐未反馈</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('6',this)">
                    <span>已淘汰</span>
                  </button>
                </td>
              </tr>
            </table>
            <input id="state" type="hidden" name="state" value="1" />
            <div class="account-content">
              <div class="account-search">
                 <%--  <table class="tblQuery2">
              <tbody>
                 
                <tr>
                
                  <td><input emptyText="请输入姓名" style="width: 150px" class="mini-textbox"
                    id="key"></td>
                  <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                    class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                    <span style="color: red;">数据说明提示:(该列表的联合主键为"候选人id"+"岗位id"),招聘代表通过岗位id进行数据过滤</span>
                  </td>
                </tr>
              </tbody>
            </table> --%>
            <table class="tblQuery2">
              <tbody>
              <tr>
                <td><div class="mini-panel" title="更多查询" style="width: 820px; height: 220px;"
                    showCollapseButton="true" bodyStyle="padding:0;" expanded="false">
                    <table class="form-table" border="0" align="left"  style="border-collapse:separate; border-spacing:8px;">
                      <br>
                      <tr >
                        <td>&nbsp;&nbsp;&nbsp;姓名:</td>
                        <td><input type="text" name="name" id="name" class="jobEdit-text radius1"></input></td>
                        <td>&nbsp;&nbsp; &nbsp;简历标签:</td>
                        <td><input name="labelName" id="labelName" class="mini-textbox"
              value="" required="true" readonly="readonly" width="100px;"/><label
              class="copy-posi" onclick="addTag()"> <label class="font-icon icon-reply-all"
                title="选择岗位"></label>
            </label> <input id="labelids" type="hidden" name="labelids" value="" /></td>
                          <td>&nbsp;&nbsp;&nbsp;推荐面试官:</td>
                     <td> 
                        <input id="interviewerName" class="mini-buttonedit" onbuttonclick="onLinkmanButtonEdit"/></td> 
                          
                      </tr>
                      <tr>
                       <td>&nbsp;&nbsp;&nbsp;职位:</td>
                         <td><input name="applyPostName" id="applyPostName" class="mini-textbox"
              value="" required="true" readonly="readonly" width="120px;"/><label
              class="copy-posi" onclick="choseJob()"> <label class="font-icon icon-reply-all"
                title="选择岗位"></label>
            </label> <input id="positionId" type="hidden" name="positionId" value="" /></td>
                         <td>&nbsp;&nbsp;&nbsp;部门:</td>
                   <td>
                     <input id="orgCode" class="mini-treeselect" name="orgCode"
                        url="/recruit/organizationController/datagrid" multiSelect="false"
                        textField="cOrgname" valueField="cOrgcode" parentField="cOrgparentcode"
                        popupWidth="300" />
                   </td>
                    <td>&nbsp;&nbsp;&nbsp;招聘渠道:</td>
                   <td>
                  <input id="recruitSource" name="recruitSource" class="mini-treeselect"
                      value="${employCandidate.recruitSource}"
                      url="/recruit/resumeSourceController/datagrid" multiSelect="false"
                      textField="sourceName" valueField="id" parentField="parentId" />
                   </td>
                      </tr>
                        <tr>
                         <td>&nbsp;&nbsp;&nbsp;学历:</td>
                       <td><select class="resume-education" id="highestEducation" name="highestEducation"></select></td>
                       <td>&nbsp;&nbsp;&nbsp;性别:</td>
                       <td><select class="resume-select" style="height: 22px;" id="sex" name="sex">
					      					<option selected="selected" value="" >--请选择--</option>
					      					<option value="001-000">男</option>
					      					<option value="001-001">女</option>
					    					</select></td>
                       <td>&nbsp;&nbsp;&nbsp;年龄:</td>
                       <td><input type="text" style="width:60px;" id="lowerAge" name="lowerAge">-<input type="text" style="width:60px;" id="upperAge" name="upperAge"></td>
                      </tr>
                      
                      <tr>
                      <td>&nbsp;&nbsp;&nbsp;工作年限:</td>
                       <td><input type="text" style="width:60px;" id="lowerYear" name="lowerYear">-<input type="text" style="width:60px;" id="upperYear" name="upperYear"></td>
                       <td>&nbsp;&nbsp;&nbsp;毕业院校:</td>
                       <td><input type="button" class="choose_btn radius1 input-l graduation-school" onclick="openThisWin('school','school-category-win')" id="school" name="school" value="选择/修改" >&nbsp;<span class="remove" >清除</span>
                        <input type="hidden" id="school1" /></td>
                       <td>&nbsp;&nbsp;&nbsp;专业:</td>
                       <td><input type="button" class="choose_btn radius1 input-l resume-professional" onclick="openThisWin('professional','professional-category-win')" id="professional" name="professional" value="选择/修改"><span class="remove" >清除</span>
					    					<input type="hidden" id="professional1" ></td>
                      </tr>
                      
                         <tr>
                          <td>&nbsp;&nbsp;&nbsp;现居地:</td>
                       <td><input type="button" class="choose_btn radius1 input-l" value="选择/修改" id="currentryWorkplace" onclick="chooseArea('currentryWorkplace')" name="currentryWorkplace">&nbsp;<span class="remove" >清除</span>
                        <input type="hidden" id="currentryWorkplace1" /></td>
                         <td>&nbsp;&nbsp;&nbsp;当前职位:</td>
                       <td><input type="text" name="curPosition" id="curPosition" class="jobEdit-text radius1"></input></td>
                       <td>&nbsp;&nbsp;&nbsp;就职公司:</td>
                       <td><input type="text" name="company" id="company" class="jobEdit-text radius1"></input></td>
                      </tr>
                      <tr>
                        <td>&nbsp;&nbsp;&nbsp;测评得分:</td>
                       <td><input type="text" name="points" id="points" class="jobEdit-text radius1"></input></td>
                       <td>&nbsp;&nbsp;&nbsp;职位发布状态:</td>
                       <td>
                       <select class="resume-select" style="height: 22px;" id="positionStatus" name="positionStatus">
                          <option selected="selected" value="" >--请选择--</option>
                          <option value="00">候选人状态</option>
                          <option value="10">安排面试</option>
                          <option value="20">淘汰</option>
                          <option value="30">录入流程中</option>
                          <option value="40">已经入职</option>
                        </select></td>
                         <td>&nbsp;&nbsp;&nbsp;锁定状态:</td>
                       <td>
                       <select class="resume-select" style="height: 22px;" id="lockStatus" name="lockStatus">
                          <option selected="selected" value="" >--请选择--</option>
                          <option value="1">未锁定</option>
                          <option value="2">被他人锁定</option>
                          <option value="3">自己锁定</option>
                         
                        </select></td>
                      </tr>
                      <tr>
                        <td>&nbsp;&nbsp;&nbsp;投递日期:</td>
                     <td><input type="text" name="startTime"  id="startTime" showTime="true" format="yyyy-MM-dd H:mm:ss" class="jobEdit-text mini-datepicker"></input>
                    </input>
                     </td>
                     <td>到</td>
                     <td> <input type="text" name="endTime"  id="endTime" showTime="true" format="yyyy-MM-dd H:mm:ss" class="jobEdit-text mini-datepicker"></td> 
                     <td>&nbsp;&nbsp;&nbsp;简历来源:</td>
                        <td><input type="text" name="resumeOrigin" id="resumeOrigin" class="jobEdit-text radius1"></input></td>
                      </tr>
                     </table>
                     </td>
                     <td><div>
                    &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;
                    <input type="submit" value="搜索" tabindex="5" onenter="onKeyEnter"
                        class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                         
                    
                  </div><%-- </td>
                    <td><div>&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;<input type="submit" value="重置" tabindex="5"
                        class="search_btn" id="btnRe" onclick="clear()" name="btnRe"></div></td> --%>
                     </tr>
                    </table>
          
              </div>
              <div class="blue radius">
                <div class="table-operate">
               <input type="button" class="button radius btn" id="employ" value="录用申请" onclick="employ()" />
               <input type="button" class="button radius btn" id="bookInterview" value="安排面试" onclick="bookInterview()" />
               <input type="button" class="button radius btn" id="outbookInterview" value="淘汰" onclick="outbookInterview()"/>
               <input type="button" class="button radius btn" id="recover" value="恢复" onclick="recover()"/>
               <input type="button" class="button radius btn" id="unlocked" value="解锁" onclick="unlocked()" />
                <input type="button" class="button radius btn" id="changePositon" value="转向到其他岗位" onclick="changePositon()" />
                <input type="button" class="button radius btn" id="recommend" value="推荐给面试官" onclick="recommend()" />
                <input type="button" class="button radius btn" id="attention" value="关注" onclick="attention()" />
                <input type="button" class="button radius btn" id="cancelAttention" value="取消关注" onclick="cancelAttention()" />
                <input type="button" class="button radius btn" id="sendEmail" value="发送简历" onclick="sentMessage()" />
      <div class="orderAndShow">
            <input type="button" id="showSetLabel" value="显示设置" class="button radius btn">
            
                            <!-- 显示设置的jsp页面 -->
                  <div class="showPosition-choose">
                    <table class="showPosition-choose-tab">
                      <tr>
                        <td width="30px"><input type="checkbox" value="" checked="checked" disabled="disabled"></td>
                        <td width="120px"><span>姓名</span></td>
                        <td width="30px"><input type="checkbox" class="resume-check" id="lockUserNameSet" value="lockUserName" ></td>
                        <td width="190px"><span>锁定人</span></td>
                      </tr>
                      <tr>
                        <td><input type="checkbox" class="resume-check" id="lockUserAccountSet" value="lockUserAccount"></td>
                        <td><span>锁定账号</span></td>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="sexSet" value="sex"></td>
                        <td><span>性别</span></td>
                      </tr>
                      <tr>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="ageSet" value="age"></td>
                        <td><span>年龄</span></td>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="positionidSet" value="positionid"></td>
                        <td><span>应聘岗位</span></td>
                      </tr>
                      <tr>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="workExperienceSet" value="workExperience"></td>
                        <td><span>工作年限</span></td>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="currentCompanySet" value="currentCompany"></td>
                        <td><span>当前公司</span></td>
                      </tr>
                      <tr>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="educationSet" value="educationColumn"></td>
                        <td><span>当前职位</span></td>
                        <td><input type="checkbox" class="resume-check" id="highestEducationSet" value="highestEducation"></td>
                        <td><span>学历</span></td>
                      </tr>
                      <tr>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="feedbackStatusSet" value="feedbackStatus"></td>
                        <td><span>推荐状态</span></td>
                           <td><input type="checkbox" checked="checked" class="resume-check" id="recommandStatusSet" value="recommandStatus"></td>
                        <td><span>反馈状态</span></td>
                      </tr>
                      <tr>  
                           <td><input type="checkbox" checked="checked" class="resume-check" id="interviewerNameSet" value="interviewerName"></td>
                        <td><span>推荐面试官</span></td>
                        <td><input type="checkbox" class="resume-check" id="graduationSchoolSet" value="graduationSchool"></td>
                        <td><span>毕业学校</span></td>
                      </tr>
                      <tr>
                        <td><input type="checkbox"  class="resume-check" id="majorSet" value="major"></td>
                        <td><span>专业</span></td>
                        <td><input type="checkbox" checked="checked" class="resume-check" id="channelSet" value="channel"></td>
                        <td><span>来源</span></td>
                      </tr>
                      <tr>
                        <td><input type="checkbox" class="resume-check" id="phoneSet" value="phone"></td>
                        <td><span>电话</span></td>
                        <td><input type="checkbox" class="resume-check" id="emailSet" checked="checked" value="email"></td>
                        <td><span>邮箱</span></td>
                      </tr> 
                      <tr>
                       <td><input type="checkbox" class="resume-check" id="interviewStatusSet" value="interviewStatus"></td>
                        <td><span>候选人岗位状态</span></td>
                      </tr>
                    </table>
                  </div>
                </div>
                </div>
            </div>
            <div id="datagrid1" class="mini-datagrid"
              url="${ctx}/candidateController/datagrid?showPager=true" idField="id" showPager="true" multiSelect="true"
              sizeList="[10,20,50,100]" pageSize="15" allowResize="true" ondrawcell="ondrawcell" onbeforeload="loadShowSetData">
              <div property="columns">
                <div type="checkcolumn" width="15" name="id" field="id"></div>
                <div name="name" field="name" width="40">姓名</div>
                <div name="lockUserName" field="lockUserName" width="40">锁定人</div>
                <div name="lockUserAccount" field="lockUserAccount" width="40">锁定账号</div>
                <div name="sex" field="sex" width="30" renderer="onGenderRenderer">性别</div>
                <div name="age" field="age" width="30">年龄</div>
                <div name="positionid" field="positionid" width="60">应聘岗位</div>
                <div name="workExperience" field="workExperience" width="40" allowSort="false">工作年限</div>
                <div name="currentCompany" field="currentCompany" width="80" allowSort="false">当前公司</div>
                <div name="currentPosition" field="currentPosition" width="80" allowSort="false">当前职位</div>
                <div name="highestEducation" field="highestEducation" width="100" headerAlign="center" align="center" allowSort="true" renderer="qualificationsRenderer">学历</div>
                <div name="interviewStatus" field="interviewStatus" width="80" allowSort="false" renderer="onInterviewRenderer">候选人岗位状态</div>
                <div name="feedbackStatus" field="feedbackStatus" width="80" allowSort="false">推荐状态</div>
                <div name="recommandStatus" field="recommandStatus" width="80" allowSort="false" renderer="onRecommandRenderer">反馈状态</div>
                <div name="interviewerName" field="interviewerName" width="80" allowSort="false">推荐面试官</div>
                <div name="graduationSchool" field="graduationSchool" width="80" allowSort="false">毕业学校</div>
                <div name="major" field="major" width="80" allowSort="false">专业</div>
                <div name="channel" field="channel" width="60" allowSort="false">来源</div>
                <div name="phone" field="phone" width="60" allowSort="false">电话</div>
                 
                <div name="email" field="email" width="80" allowSort="false">邮箱</div>
               
              </div>
            </div>
             <!-- 选择专业类别 -->
    <div id="professional-category-win" class="mini-window" style="width: 608px; display: none;" title="选择专业类别" showFooter="true">
      <div class="professional-category-middle category-middle">
        <div class="professional-category-middle-inner middle-inner">
          <span><b>&nbsp;&nbsp;已选择专业</b>&nbsp;&nbsp;
          <span class="professional-gray gray">最多选5个</span>&nbsp;&nbsp;
          <span class="professional-category-prompt category-prompt"></span>
        </div>
        <div class="choose-professional-data category-data"></div>
      </div>
      <div class="choose-professional-category choose-category">
        <div class="choose-professional-tip choose-tip"><span  onclick="openData('professional')" style="color:blue">请选择专业</span></div>
        <!-- <div class="choose-professional-text"><input type="text" class="choose-professional-input"><input type="button" class="choose-professional-button" value="录入"></div> -->
        <div class="choose-professional-panel choose-panel"><span><b>&nbsp;&nbsp;请选择专业</b></span></div>
      </div>
      <div class="professional-category"><span style="font-size: 12px;color:red; "></span></div>
      <div >
        <div class="professional-category-data category-data"></div>
      </div>
      <div property="footer" class="win-footer">
        <input type="button" class="win-footer-btn" value="确定" onclick="submitCategoryData('professional')"></input>
        <input type="button" class="win-footer-btn" value="取消" onclick="hideCaegoryWindow('professional','professional-category-win')"></input>
      </div>
    </div>
    <!-- 主要专业的类别 -->
    <div class="professional-category-pdata category-data" onmouseover="cancelEvent();" onmouseout="closeDataPanel('professional');" style="display: none;">
      <ul>
        <li><a datavalue="1"> 管理科学与工程类</a></li>
        <li><a datavalue="2"> 工商管理类</a></li>
        <li><a datavalue="3"> 公共管理类</a></li>
        <li><a datavalue="4"> 图书档案学类</a></li>
        <li><a datavalue="5"> 电子信息类</a></li>
        <li><a datavalue="6"> 机械类</a></li>
        <li><a datavalue="7"> 仪器仪表类</a></li>
        <li><a datavalue="8"> 能源动力类</a></li>
        <li><a datavalue="9"> 材料类</a></li>
        <li><a datavalue="10"> 轻工纺织食品类</a></li>
        <li><a datavalue="11"> 土建类</a></li>
        <li><a datavalue="12"> 力学类</a></li>
        <li><a datavalue="13"> 环境科学与安全类</a></li>
        <li><a datavalue="14"> 制药工程类</a></li>
        <li><a datavalue="15"> 交通运输类</a></li>
        <li><a datavalue="16"> 航空航天类</a></li>
        <li><a datavalue="17"> 船舶与海洋工程类</a></li>
        <li><a datavalue="18"> 水利类</a></li>
        <li><a datavalue="19"> 测绘类</a></li>
        <li><a datavalue="20"> 公安技术类</a></li>
        <li><a datavalue="21"> 武器类</a></li>
        <li><a datavalue="22"> 数学类</a></li>
        <li><a datavalue="23"> 物理学类</a></li>
        <li><a datavalue="24"> 化学类</a></li>
        <li><a datavalue="25"> 生物类</a></li>
        <li><a datavalue="26"> 天文地质地理类</a></li>
        <li><a datavalue="27"> 经济学类</a></li>
        <li><a datavalue="28"> 语言文学类</a></li>
        <li><a datavalue="29"> 艺术类</a></li>
        <li><a datavalue="30"> 法学类</a></li>
        <li><a datavalue="31"> 哲学类</a></li>
        <li><a datavalue="32"> 教育学类</a></li>
        <li><a datavalue="33"> 医学类</a></li>
        <li><a datavalue="34"> 农业类</a></li>
        <li><a datavalue="35"> 历史学类</a></li>
        <li><a datavalue="36"> 军事类</a></li>
      </ul>
      <div class="choose-professional-panel2 choose-panel2"></div>
    </div> 
    
      <!--区域   -->
    <div id="popInner"  class="mini-window" style="width: 700px; display: none;" title="请选择区域 " showFooter="true">
      <div class="pop-main">
        <div class="main-city">
          <h4 class="title">
            主要城市
            <input type="text" id="areaSearch" class="search-input radius" value="市.区(拼音首字母/中文/英文)"></input>
            <input id="hidQuickAreaId" type="hidden" value="">
          </h4>
          <div id="mainCities">
            <ul class="MainCityList"></ul>
          </div>
        </div>
        <div class="pop-status city-list" id="cityList">
          <h4 class="title">全国各省</h4>
          <div id="allProv" class="allProv"></div>
        </div>
        <div property="footer" class="win-footer">
          <input type="button" class="win-footer-btn" value="取消" onclick="closeWin()"></input>
        </div>
      </div>
    </div>
    <div id="sublist"></div>
    <div id="countyList"></div>
    
      <!-- 选择学校 -->
    <div id="school-category-win" class="mini-window" style="width: 608px; display: none;" title="选择专业类别" showFooter="true">
      <div class="school-category-middle category-middle">
        <div class="school-category-middle-inner middle-inner">
          <span><b>&nbsp;&nbsp;已选择专业</b></span>&nbsp;&nbsp;
          <span class="school-gray gray">最多选5个</span>&nbsp;&nbsp;
          <span class="school-category-prompt category-prompt"></span>
        </div>
        <div class="choose-school-data category-data"></div>
      </div>
      <div class="choose-school-category choose-category">
        <div class="choose-school-tip choose-tip"><span onclick="openData('school')" style="color:blue">请选择学校</span></div>
        <!-- <div class="choose-professional-text"><input type="text" class="choose-professional-input"><input type="button" class="choose-professional-button" value="录入"></div> -->
        <div class="choose-school-panel choose-panel" ><span><b>&nbsp;&nbsp;请选择学校</b></span></div>
      </div>
      <div class="school-category"><span style="font-size: 12px;color:red; "></span></div>
      <div >
        <div class="school-category-data category-data"></div>
      </div>
      <div property="footer" class="win-footer">
        <input type="button" class="win-footer-btn" value="确定" onclick="submitCategoryData('school')"></input>
        <input type="button" class="win-footer-btn" value="取消" onclick="hideCaegoryWindow('school','school-category-win')"></input>
      </div>
    </div>
    <div class="school-category-pdata category-data"  onmouseover="cancelEvent();" onmouseout="closeDataPanel('school');">
      <div style="border-bottom: 1px dashed #DDDDDD;height: 30px;" >
        <span>按分组：</span>
      </div>
      <div>
        <ul>
          <li><a class="byGroup" datavalue="1">211工程大学</a></li>
          <li><a class="byGroup" datavalue="2">985工程大学</a></li>
        </ul>
      </div>
      <div style="border-bottom: 1px dashed #DDDDDD;height: 30px;">按省份：</div>
      <div>
        <ul>
          <li><a datavalue="3">湖南</a></li>
          <li><a datavalue="4">湖北</a></li>
          <li><a datavalue="5">安徽</a></li>
          <li><a datavalue="6">北京</a></li>
          <li><a datavalue="7">重庆</a></li>
          <li><a datavalue="8">福建</a></li>
          <li><a datavalue="9">甘肃</a></li>
          <li><a datavalue="10">广东</a></li>
          <li><a datavalue="11">广西</a></li>
          <li><a datavalue="12">贵州</a></li>
          <li><a datavalue="13">海南</a></li>
          <li><a datavalue="14">河北</a></li>
          <li><a datavalue="15">黑龙江</a></li>
          <li><a datavalue="16">河南</a></li>
          <li><a datavalue="17">内蒙古</a></li>
          <li><a datavalue="18">江苏</a></li>
          <li><a datavalue="19">江西</a></li>
          <li><a datavalue="20">吉林</a></li>
          <li><a datavalue="21">辽宁</a></li>
          <li><a datavalue="22">宁夏</a></li>
          <li><a datavalue="23">青海</a></li>
          <li><a datavalue="24">陕西</a></li>
          <li><a datavalue="25">山东</a></li>
          <li><a datavalue="26">上海</a></li>
          <li><a datavalue="27">山西</a></li>
          <li><a datavalue="28">四川</a></li>
          <li><a datavalue="29">天津</a></li>
          <li><a datavalue="30">西藏</a></li>
          <li><a datavalue="31">新疆</a></li>
          <li><a datavalue="32">云南</a></li>
          <li><a datavalue="33">浙江</a></li>
          <li><a datavalue="34">香港</a></li>
          <li><a datavalue="35">澳门</a></li>
          <li><a datavalue="36">台湾</a></li>
        </ul>
      </div>
      <div class="choose-school-panel2 choose-panel2"></div>
    </div> 
        
    
            
            <!-- 职位的分发,修改和预览 -->
    <div class="position-candidate-operate">
      <div class="position-candidate-right">
        <table class="position-operate-rtable">
          <tr>
            <td style="font-size:10px;">推荐人：<span id="userName"></span></td>
          </tr>
           <tr>
            <td style="font-size:10px;">推荐时间：</font><span id="createTime"></span></td>
          </tr>
          <tr>
            <td style="font-size:10px;">推荐理由：<span id="comments"></span></td>
          </tr>
          <tr>
            <td style="font-size:10px;"> 面试官：<span id="interviewerName"></span></td>
          </tr>
           <tr>
            <td style="font-size:10px;">反馈状态：<span id="status"></span></td>
          </tr>
          <tr id="jobName_tr">
            <td style="font-size:10px;">转岗岗位：<span id="jobName"></span></td>
          </tr>
           <tr>
            <td style="font-size:10px;">反馈时间：<span id="feedbackTime"></span></td>
          </tr>
        </table>
      </div>
    </div>
          </div>
              </div>
            </div>
          </div>
        </div>
    </div>
    </div>
    <jsp:include page="../flow/employ/tagSelect.jsp"/>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript">

var curName = '<shiro:principal type="java.lang.String"/>';
</script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
    <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/plugins/jquery-autocomplete/jquery.autocomplete.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/position/positionCategory.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/professionalCategory.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/tagSelect.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/industryAutoComplete.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/industryAuto.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/schoolData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/category.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript" src="${webRoot }/resources/js/candidate/candidateList.js"></script>
</html>









