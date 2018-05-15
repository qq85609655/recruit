<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@include file="/webpage/common.jsp"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <title id="resumeTitle">简历预揽</title>
    <link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/addResume.css"/>
    <style type="text/css">
    .grayBg,.nobd{
      display: block; 
}
    </style>
  </head>
  <body>
    <div class="backColor">
      <div>
	    <input id="hidResumeLanguage" name="hidResumeLanguage" type="hidden" value="" />
	    <div  id="resume_menu" style="display:none;">
	        <div class="clr"></div>
	      </div>
	    <div id="content" class="resumeContent" style="margin-top: 80px;">
	      <!-- 基本信息 -->
	      <h3 class="tit_blue">基本信息</h3>
	      <div class="resume_basicinfo same">
	        <div class="grayBg basicinfoShow" >
              <div class="avatar">
              </div>  
              <div class="basicinfoData" id="basicinfoData">
              </div> 
              <div class="clr"></div>
			</div>
	      </div>
	      <!-- 背景概要 -->
		  <h3  id="showSelfEvaluation" class="tit_blue nobd"> 背景概要</h3>
		  <div class="selfEvaluation same bd_c8e4f1 grayBg">
		    <div id="viewSelfEvaluation" class="pt8" style="display: none;" data-tip="pt8SelfEvaluation"></div>
		    <div id="SelfEvaluation" class=" work_exp ">
		      <div id="divEditSelfEvaluation" style="font-size: 14px;">
		           
		     </div>
		   </div>
		  </div>
	      <!-- 求职意向 -->
	      <h3  id="showCareerObject" class="tit_blue nobd">求职意向 </h3>
	      <div id="CareerObject" class="bd_c8e4f1 work_exp grayBg same" >
            <div style="display: none;" class="pt8" id="viewCareerObject" data-tip="pt8viewCareerObject"></div>
            <div style="font-size: 14px;" id="divEditCareerObject"></div>
	      </div>
	      
	      <!-- 工作经历 -->
	      <h3 style="" id="showWork" class="tit_blue nobd">工作经历  </h3>
          <div style="" id="workCon" class="grayBg bd_c8e4f1 work_exp same">
            <div class="workConData" id="workConData">
            
            </div>
            <div id="expFormWrap"></div>
         </div>
         
         <!-- 详细工作经历 -->
         <h3 style="" id="showWorkDetails" class="tit_blue nobd">详细工作经历 </h3>
         <div style="" id="workDetailsCon" class="bd_c8e4f1 work_exp grayBg same">
           <div id="viewExperienceDetail" class="pt8" style="display: none;" data-tip="pt8ExperienceDetail"></div>
             <div id="divEditExperienceDetail" style="font-size: 14px;"></div>
           </div>
           
           <!-- 项目经验 -->
           <h3 style="" id="showProjectExperience" class="tit_blue nobd">项目经验</h3>
           <div style="" id="ProjectExperience" class="bd_c8e4f1 work_exp grayBg same">
             <div id="viewProjectExperience" class="pt8" style="display: none;" data-tip="pt8ProjectExperience"></div>
               <div id="divEditProjectExperience" style="font-size: 14px;"></div>
             </div>
             
             <h3 style="" id="showEdu" class="tit_blue nobd">教育经历</h3>
             <div style="" id="eduCon" class="grayBg bd_c8e4f1 work_exp same">
               <div class="educationExperience" id="educationExperience"></div>
               <div id="eduFormWrap"></div>
             </div>
             
             <!--培训信息-->
             <h3 style="" id="showTrainingInfo" class="tit_blue nobd">培训信息 </h3>
             <div style="" id="TrainingInfo" class="bd_c8e4f1 work_exp grayBg same">
               <div id="viewTrainingInfo" class="pt8" style="display: none;"  data-tip="pt8TrainingInfo"></div>
               <div id="divEditTrainingInfo" style="font-size: 14px;"></div>
              </div>
                
              <!--语言 -->
              <h3 style="" id="showLang" class="tit_blue nobd">语言</h3>
              <div style="" id="langCon" class="bd_c8e4f1 work_exp grayBg same">
                <div class="languageList" id="languageList"></div>
                <div id="languageFormWrap"></div>
              </div>
              
              <!--语言描述  -->
              <h3 style="" id="showLanguageSkill" class="tit_blue nobd">语言描述</h3>
              <div style="" id="LanguageSkill" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewLanguageSkill" class="pt8" style="display: none;" data-tip="pt8LanguageSkill"></div>
                <div id="divEditLanguageSkill" style="font-size: 14px;"></div>
              </div>
              
              <!-- 证书信息 -->
              <h3 style="" id="showRewards" class="tit_blue nobd">奖励信息</h3>
              <div style="" id="Rewards" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewRewards" class="pt8" style="display: none;" data-tip="pt8Rewards"> </div>
                <div id="divEditRewards" style="font-size: 14px;">
                </div>
              </div>
              
              <!-- 技能 -->
              <h3 style="" id="showSkill" class="tit_blue nobd">技能 </h3>
              <div style="" id="skillCon" class="bd_c8e4f1 grayBg same">
                <table id="skillData"></table>
            </div>
            
            <!--其他技能信息  -->
            <h3 style="" id="showSkillText" class="tit_blue nobd">其他技能信息</h3>
            <div style="" id="SkillText" class="bd_c8e4f1 work_exp grayBg same">
              <div id="viewSkillText" class="pt8" style="display: none;" data-tip="pt8SkillText"></div>
                <div id="divEditSkillText" style="font-size: 14px;">
                </div>
              </div>
              
              <!-- 证书信息 -->
              <h3 style="" id="showCertification" class="tit_blue nobd">证书信息</h3>
              <div style="" id="Certification" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewCertification" class="pt8" style="display: none;" data-tip="pt8Certification"> </div>
                <div id="divEditCertification" style="font-size: 14px;">
                </div>
              </div>
              
              <!--爱好信息  -->
              <h3 style="" id="showHobbies" class="tit_blue nobd">爱好信息</h3>
              <div style="" id="Hobbies" class="bd_c8e4f1 work_exp grayBg same">
                <div id="viewHobbies" class="pt8" style="display: none;" data-tip="pt8Hobbies"></div>
                <div id="divEditHobbies" style="font-size: 14px;">
                </div>
              </div>
              <br><br>
           </div>
           
         <!--   <!-- 更多简历信息 -->
           <div class="moreOparte same bd_c8e4f1" style="display:none;">
             <h3 class="tit_blue"> 填写更多简历信息</h3>
             <div class=" work_exp ">
               <ul id="moreItems">
                 <li>+<a href="#showSelfEvaluation" id="showSelfEvaluationItem">背景概要</a></li>
                 <li>+<a href="#showCareerObject" id="showCareerObjectItem">求职意向</a></li>
                 <li>+<a href="#showWork" id="showWorkItem">工作经历</a></li>
                 <li>+<a href="#showWorkDetails" id="showWorkDetailsItem">详细工作经历</a></li>
                 <li>+<a href="#showProjectExperience" id="showProjectExperienceItem">项目经验</a></li>
                 <li>+<a href="#showEdu" id="showEduItem">教育经历</a></li>
                 <li>+<a href="#showTrainingInfo" id="showTrainingInfoItem">培训信息</a></li>
                 <li>+<a href="#showLang" id="showLangItem">语言</a></li>
                 <li>+<a href="#showLanguageSkill" id="showLanguageSkillItem">语言描述</a></li>
                 <li>+<a href="#showRewards" id="showRewardsItem">奖励信息</a></li>
                 <li>+<a href="#showSkill" id="showSkillItem">技能</a></li>
                 <li>+<a href="#showSkillText" id="showSkillTextItem">其他技能信息</a></li>
                 <li>+<a href="#showCertification" id="showCertificationItem">证书信息</a></li>
                 <li>+<a href="#showHobbies" id="showHobbiesItem">爱好信息</a></li>
               </ul>
             </div>
           </div>
           <br> 
           
           
       </div>
       <div style="text-align: center;"><input type="button"  value="关闭" class="menu_btn" id="close" onclick=" CloseWindow('close');"/></div>
</body>


<script type="text/javascript" src="${webRoot}/resources/js/resume/resumePreview.js"></script>
</html>