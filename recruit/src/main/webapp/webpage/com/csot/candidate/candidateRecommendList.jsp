<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>推荐简历列表</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
      <div class="position-path co-right-center">
       <span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">招聘流程</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">推荐简历列表</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="main">
          <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                  <button class="posi-import-btn blue tab-up" id="task-button"
                    onclick="choseState('2',this)">
                    <span>未反馈的简历</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('1',this)">
                    <span>已反馈的简历</span>
                  </button>
                </td>
              </tr>
            </table>
            <div class="account-content">
              <div class="account-search">
              <input id="isFeedBack" type="hidden" name="isFeedBack" value="2" />
               <input id="positionId" type="hidden" name="positionId" value="" />
             				 <table>
								  <tbody>
										<tr>
											<td>
	                      <label >候选人：</label>
											
												<input id="searchKey" class="jobKey input-l radius1" type="text" tabindex="2" maxlength="20" value="">
	                      &nbsp;&nbsp;
                        <label>岗位：</label>
                      
                       <input name="applyPostName" id="applyPostName" class="mini-textbox"
              value="" required="true" readonly="readonly" /><label
              class="copy-posi" onclick="choseJob()"> <label class="font-icon icon-reply-all"
                title="选择岗位"></label>选择岗位
            </label>
                       
                        <td>
	                      &nbsp;&nbsp; &nbsp;&nbsp;<input id="btnSearchOK" class="search_btn radius1 btn" type="button" tabindex="11" value="搜索" name="btnSearchOK" onclick="search()" />
                        &nbsp;&nbsp; &nbsp;&nbsp;<input id="btnSearchClear" class="search_btn radius1 btn" type="button" tabindex="11" value="清除" name="btnSearchClear" onclick="clearAll()" />
						</td>
                                            
										</tr>
									</tbody>
								</table>
              </div>
              <div class="blue radius">
                <div class="table-operate">
                         <input type="button" class="button radius btn" id="recommend" value="安排面试" onclick="updateRecommend('1')"/>
                         <input type="button" class="button radius btn" id="ChangeRecommend" value="转向到其他岗位" onclick="changeJob()"/>
                         <input type="button" class="button radius btn" id="outRecommend" value="淘汰" onclick="updateRecommend('3')" />
                </div>
  <div id="datagrid1" class="mini-datagrid" url="/recruit/candidateRecommendController/queryCandidateRecommendListByPage?showPager=true"  showPager="true"
              idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false" multiSelect="true" ondrawcell="ondrawcell">
                <div property="columns">
                  <div type="checkcolumn" name="id" field="id"></div>
                            <!-- <div  width="80" name="positonId" field="positonId" allowSort="true" style="display:none;">职位ID</div>
                            <div name="candidateId" field="candidateId" width="80" allowSort="true" style="display:none;">候选人ID</div> -->
                  <div name="name" field="name" width="80" allowSort="true" >候选人</div>
                  <div name="sex" field="sex" width="80" align="center" headerAlign="center" renderer="onGenderRenderer">性别</div>    
                  <div name="age" field="age" width="80" align="center" headerAlign="center" allowSort="false">年龄</div>                            
                  <div name="interviewPositionName" field="interviewPositionName" width="100"  allowSort="false" align="center" headerAlign="center">应聘岗位</div>
                  <div name="commpany" field="commpany" width="60"  allowSort="false" align="center" headerAlign="center">最近就职公司</div>
                  <div name="curPositionName" field="curPositionName" width="60"  allowSort="false" align="center" headerAlign="center">当前职位</div>
                  <div name="qualifications" field="qualifications" width="100" headerAlign="center" align="center" allowSort="true" renderer="qualificationsRenderer">学历</div>
                  <div name="school" field="school" width="100" allowSort="true" align="center" headerAlign="center">毕业院校</div>
                  <div name="comment" field="comment" width="100" allowSort="true" align="center" headerAlign="center">推荐理由</div>
                  <div name="status" field="status" width="100" allowSort="true" align="center" headerAlign="center">状态</div>
                </div>
              </div>
            </div>
              </div>

            </div>
          </div>
        </div>
    </div>
  </div>
  <jsp:include page="/webpage/footer.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${webRoot}/resources/js/public/jquery.cookie.js"></script>
<script type="text/javascript">
  mini.parse();
  var grid = mini.get("datagrid1");
  grid.load();
</script>
	<script type="text/javascript" src="${webRoot}/resources/js/candidate/candidateRecommendList.js"></script>
</html>









