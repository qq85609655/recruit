<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<style type="text/css"> 


body { 
font: normal 11px auto "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
color: #4f6b72; 
background: #E6EAE9; 
} 

a { 
color: #c75f3e; 
} 

#mytable { 
width: 700px; 
padding: 0; 
margin: 0; 
} 

caption { 
padding: 0 0 5px 0; 
width: 700px; 
font: FONT-SIZE: 20px; TEXT-DECORATION: none; FONT-FAMILY: 微软雅黑;  FONT-WEIGHT: normal; COLOR: #0000ff; FONT-STYLE: normal; DISPLAY: inline;
text-align: center; 
} 

th { 
font:  11px "微软雅黑", Verdana, Arial, Helvetica, sans-serif; 
color: #4f6b72;
width:25%; 
border-right: 1px solid #C1DAD7; 
border-bottom: 1px solid #C1DAD7; 
border-top: 1px solid #C1DAD7; 
letter-spacing: 2px; 
text-transform: uppercase; 
text-align: center; 
padding: 6px 6px 6px 12px; 
background: #CAE8EA  no-repeat; 
} 

th.nobg { 
border-top: 0; 
border-left: 0; 
border-right: 1px solid #C1DAD7; 
background: none; 

} 

td { 
border-right: 1px solid #C1DAD7; 
border-bottom: 1px solid #C1DAD7; 
background: #fff; 
font-size:11px; 
padding: 6px 6px 6px 12px; 
color: #4f6b72; 
text-align: center;
} 


td.alt { 
background: #F5FAFA; 
color: #797268; 

} 

th.spec { 
border-left: 1px solid #C1DAD7; 
border-top: 0; 
background: #fff no-repeat; 
font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
} 

th.specalt { 
border-left: 1px solid #C1DAD7; 
border-top: 0; 
background: #f5fafa no-repeat; 
font: bold 10px "Trebuchet MS", Verdana, Arial, Helvetica, sans-serif; 
color: #797268; 
} 
/*---------for IE 5.x bug*/ 
html>body td{ font-size:11px;} 
body,td,th { 
font-family: 宋体, Arial; 
font-size: 12px; 
} 
</style> 
<html>
  <head>
    <%@include file="/webpage/common.jsp"%>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/public/jquery.validator.css"/>
    <link type="text/css" rel="stylesheet" href="${webRoot}/resources/css/flow/interview/estimateEdit.css"/>
    <script charset="utf-8" src="${webRoot}/resources/plugins/kindeditor-4.1.10/kindeditor-all.js"></script>
    <title>面试评估表</title>
  </head>
  <body onload="removeLoad();">
    <jsp:include page="/webpage/header.jsp"></jsp:include>
    <div class="co">
      <div class="co-right">
        <div class="position-path co-right-center">
          <span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">易聘</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">招聘流程</span><em class="path-icon">&gt;&gt;</em><span class="path-leaf">面试评估表</span>
        </div>
        <div class="co-right-main co-right-center">
          <div class="con-title">面试评估表</div>
          <div class="main">
          <form action="" id="estimateForm">
          <input id="id" type="hidden" name="id" value="${estimate.id}" />
          <input id="candidateId" type="hidden" name="candidateId" value="${estimate.candidateId}" />
          <input id="positionId" type="hidden" name="positionId" value="${estimate.positionId}" />
          <table id="mytable" cellspacing="0" align="center">
            <caption><h3>面试评估（职员）</h3></caption>
            <tr>
              <th scope="col" >评价维度</th>
              <th scope="col" >关键行为描述</th>
              <th scope="col" >HR评分</th>
              <th scope="col" >部门评分</th>
            </tr>
            <tr>
              <td scope="col">1.通用素质</td>
              <td class="row" colspan="3"></td>
            </tr>
            <tr>
              <td scope="col">系统思考</td>
              <td>从分析问题的全面性、深入性、把握关键三个维度考察  </td>
              <td scope="col"><input type="text" name="hrSysThink" value="${estimate.hrSysThink}" id="hrSysThink" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.sysThink}</td>
            </tr>
              <tr>
              <td scope="col">沟通协调</td>
              <td>运用信息传递、倾听，互动联络与双向沟通，建立有效关系，协同合作，共同完成预定的目标 </td>
              <td scope="col"><input type="text" name="hrCommunicate" value="${estimate.hrCommunicate}" id="hrCommunicate" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.communicate}</td>
            </tr>
              <tr>
              <td scope="col">学习力</td>
              <td>有学习的强烈意愿，善于学习，善于运用学习的成果</td>
              <td scope="col"><input type="text" name="hrStudy" value="${estimate.hrStudy }" id="hrStudy" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.study }</td>
            </tr>
              <tr>
              <td scope="col">团队合作</td>
              <td>主动担当，不推卸责任；补台，不拆台；有集体意识，愿意牺牲个人利益</td>
              <td scope="col"><input type="text" name="hrTeamWork" value="${estimate.hrTeamWork }" id="hrTeamWork" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.teamWork }</td>
            </tr>
              <tr>
              <td scope="col">创新拓展</td>
              <td>有敏锐的感受和探索能力；主动拓宽视野及思维方式；注重学习和实践，提升创新观念和技能 </td>
              <td scope="col"><input type="text" name="hrInnovate" value="${estimate.hrInnovate }" id="hrInnovate" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.innovate }</td>
            </tr>
            <tr>
              <td scope="col">2.专业知识和技能</td>
              <td class="row" colspan="3"></td>
            </tr>
            <tr>
              <td scope="col">专业知识</td>
              <td>与岗位职责相关知识掌握的宽度、深度、系统性 </td>
              <td scope="col"><input type="text" name="hrMajorKnowledge" value="${estimate.hrMajorKnowledge }" id="hrMajorKnowledge" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.majorKnowledge }</td>
            </tr>
            <tr>
              <td scope="col">专业技能</td>
              <td>用目标岗位的专业化的理念、方式、方法解决实际问题的能力 </td>
              <td scope="col"><input type="text" name="hrMajorSkill" value="${estimate.hrMajorSkill }" id="hrMajorSkill" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.majorSkill }</td>
            </tr>
            <tr>
              <td scope="col">专业经验</td>
              <td>与目标岗位的关联性，包括：年限、职级、工作内容的相似性等  </td>
              <td scope="col"><input type="text" name="hrMajorExp" value="${estimate.hrMajorExp }" id="hrMajorExp" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.majorExp }</td>
            </tr>
             <tr>
              <td scope="col">3.组织匹配性</td>
              <td class="row" colspan="3"></td>
            </tr>
                <tr>
              <td scope="col">人与岗位的匹配度</td>
              <td>个性特质与岗位的匹配度 </td>
              <td scope="col"><input type="text" name="hrPositionMatch" value="${estimate.hrPositionMatch }" id="hrPositionMatch" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.positionMatch }</td>
            </tr>
                <tr>
              <td scope="col">人与组织的匹配度</td>
              <td>个人价值观与组织价值观（如当责文化：主动承担，输出成果）的匹配程度   </td>
              <td scope="col"><input type="text" name="hrOrgMatch" value="${estimate.hrOrgMatch }" id="hrOrgMatch" class="jobEdit-text radius1"></input></td>
              <td scope="col">${estimate.orgMatch }</td>
            </tr>
                <tr>
              <td scope="col">合计评分</td>
              <td> </td>
              <td scope="col">${estimate.hrTotal }</td>
              <td scope="col"><input type="text" name="hrTotal" value="${estimate.total }" id="hrTotal" class="jobEdit-text radius1"></input></td>
            </tr>
               <tr>
              <td scope="col">评价结果</td>
              <td>S:优秀(90-100分) A:良好(80-89分) B:一般(60-79分) C:较差(40-59分) D:很差（0-39分） </td>
              <td scope="col">${estimate.hrResult }</td>
              <td scope="col"><input type="text" name="result" value="${estimate.result }" id="result" class="jobEdit-text radius1"></input></td>
            </tr>
             <tr>
              <td scope="col">4.总体评分</td>
              <td class="row" colspan="3"></td>
            </tr>
              <tr>
              <td scope="col">HR总体评分</td>
              <td colspan="3">${estimate.hrComment }</td>
            </tr>
             <tr>
              <td scope="col">用人部门总体评分</td>
              <td colspan="3"><input type="text" name="orgComment" value="${estimate.orgComment }" id="orgComment" class="jobEdit-text radius1"></input> </td>
            </tr>
            <tr>
              <td  colspan="4">  <a id="button1" class="mini-button" onclick="subMit()">保存</a></td>
            </tr>
          </table>
          </form>
        </div>
        </div>
        </div>
      </div> 
    <jsp:include page="/webpage/footer.jsp"></jsp:include>
  </body>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/jquery.validator.zh_cn.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/resume/ajaxfileupload.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaAutoCompleteData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/public/areaData.js"></script>
  <script type="text/javascript" src="${webRoot}/resources/js/flow/interview/estimateEdit.js"></script>
   <script type="text/javascript">
      mini.parse();
      var jsWebRoot = "${webRoot}";
    </script>
<html>
