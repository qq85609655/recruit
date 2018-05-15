<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>公共人才库</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
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
</style>
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
     <div class="position-path co-right-center">
        <span class="path-title">您的位置 :</span><a class="path-item a-decoration"
          href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><span
          class="path-leaf">招聘流程</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">公共人才库</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="main">
          <div class="position-import-main blue radius">
            <div class="account-content">
              <div class="account-search">
                  <table class="tblQuery2">
              <tbody>
                 
                <tr>
                <input id="state" type="hidden" name="state" value="1" />
                  <td><input emptyText="请输入姓名" style="width: 150px" class="mini-textbox"
                    id="key"></td>
                  <td>&nbsp;&nbsp; <input type="submit" value="查询" tabindex="5"
                    class="search_btn" id="btnRefresh" onclick="search()" name="btnRefresh">
                    <span style="color: red;">数据说明提示:(该列表的联合主键为"候选人id"+"岗位id"),招聘代表通过岗位id进行数据过滤</span>
                  </td>
                </tr>
              </tbody>
            </table>
              </div>
              <div class="blue radius">
                <div class="table-operate">
               <input type="button" class="button radius btn" id="sendEmail" value="发送简历" onclick="sentMessage()" />
               <input type="button" class="button radius btn" id="addTag" value="添加标签" onclick="addTag()" />
               <input type="button" class="button radius btn" id="addCandidatePost" value="加为候选人" onclick="addCandidatePost()" />
               <a href="${ctx}/resume/addResume" target="_blank"><input type="button" class="button radius btn" id="addResume" value="简历录入"/></a>
            </div>
            <div id="datagrid1" class="mini-datagrid"
              url="${ctx}/candidateController/candidateDatagrid?showPager=true" idField="id" showPager="true" multiSelect="true"
              sizeList="[10,20,50,100]" pageSize="15" allowResize="true" ondrawcell="ondrawcell">
              <div property="columns">
                <div type="checkcolumn" width="15" name="id" field="id"></div>
                <div name="name" field="name" width="40">姓名</div>
                <div name="lockUserName" field="lockUserName" width="40">锁定人</div>
                <div name="lockUserAccount" field="lockUserAccount" width="40">锁定账号</div>
                <div name="sex" field="sex" width="30" renderer="onGenderRenderer">性别</div>
                <div name="age" field="age" width="30">年龄</div>
                <div name="jobNames" field="jobNames" width="150">应聘岗位</div>
                <div name="workExperience" field="workExperience" width="40" allowSort="false">工作年限</div>
                <div name="currentCompany" field="currentCompany" width="80" allowSort="false">当前公司</div>
                <div name="currentPosition" field="currentPosition" width="80" allowSort="false">当前职位</div>
                <div name="highestEducation" field="highestEducation" width="100" headerAlign="center" align="center" allowSort="true" renderer="qualificationsRenderer">学历</div>
                <div name="graduationSchool" field="graduationSchool" width="80" allowSort="false">毕业学校</div>
                <div name="major" field="major" width="80" allowSort="false">专业</div>
                <div name="channel" field="channel" width="60" allowSort="false">来源</div>
                <div name="phone" field="phone" width="60" allowSort="false">电话</div>
                 
                <div name="email" field="email" width="80" allowSort="false">邮箱</div>
               
              </div>
            </div>
            
            <!-- 职位的分发,修改和预览 -->
    <div class="position-candidate-operate">
      <div class="position-candidate-right">
        <table class="position-operate-rtable">
          <tr>
            <td style="font-size:10px;">：<span id="userName"></span></td>
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
    <jsp:include page="../flow/employ/tagSelect.jsp"/>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
<script type="text/javascript">
mini.parse();
var datagrid = mini.get("datagrid1");
datagrid.load();
var curName = '<shiro:principal type="java.lang.String"/>';
</script>
  <script type="text/javascript" src="${webRoot }/resources/js/candidate/candidateRepository.js"></script>
</html>








