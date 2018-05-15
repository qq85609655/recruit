<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" uri="/recruit-tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/webpage/common.jsp"%>
<title>面试流程</title>
<link rel="stylesheet" type="text/css"
  href="${webRoot}/resources/css/flow/recruitdemand/recruitDemandList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot }/resources/css/system/baseUserList.css" />
<link rel="stylesheet" type="text/css" href="${webRoot}/resources/css/importResume.css" />
</head>
<body onload="removeLoad();">
  <jsp:include page="/webpage/header.jsp"></jsp:include>
  <div class="co">
      <div class="position-path co-right-center">
       <span class="path-title">您的位置 :</span><a class="path-item a-decoration" href="${webRoot}/loginController/main">我的首页</a><em class="path-icon">&gt;&gt;</em><a class="path-item a-decoration">招聘流程</a><em class="path-icon">&gt;&gt;</em><span class="path-leaf">面试流程</span>
      </div>
      <div class="co-right-main co-right-center">
        <div class="main">
          <div class="position-import-main blue radius">
            <table class="position-import-tab1">
              <tr>
                <td>
                  <button class="posi-import-btn blue tab-up" id="task-button"
                    onclick="choseState('1',this)">
                    <span>已安排面试</span>
                  </button>
                  <button class="posi-import-btn blue " id="detail-button"
                    onclick="choseState('2',this)">
                    <span>未安排面试</span>
                  </button>
                </td>
              </tr>
            </table>
            <div class="account-content">
              <div class="account-search">
              <input id="isBook" type="hidden" name="isBook" value="1" />
             				  <table>
								  <tbody>
										<tr>
                       
											<td>
	                      <label>应聘者录入日期：</label>
												<input id="startDate" class="jobKey radius1 mini-datepicker"
													type="text" style="width: 100px" tabindex="7" value=""/> - 
												<input id="endDate" class="jobKey radius1 mini-datepicker" type="text"
													style="width: 100px" value="" tabindex="8"/>
												&nbsp;&nbsp;
												候选人:<input id="searchKey" class="jobKey input-l radius1" type="text" tabindex="2" maxlength="20" value="">
	                      &nbsp;&nbsp;
                        <label id="status_span">状态：</label><select id="interview_status">
                           <option value="">-请选择-</option>
                          <option value="0">正常</option>
                          <option value="1">取消</option>
                          <option value="2">淘汰</option>
                          <option value="9">草稿</option>
                        </select>
                      
                        
                        <td>
	                      &nbsp;&nbsp; &nbsp;&nbsp;<input id="btnSearchOK" class="search_btn radius1 btn" type="button" tabindex="11" value="搜索" name="btnSearchOK" onclick="search()" />
						</td>
                                            
										</tr>
									</tbody>
								</table>
              </div>
              <div id="loading"></div>
              <div class="blue radius">
                <div class="table-operate">
                                <input type="button" class="button radius btn" id="bookInterview" value="安排面试" onclick="bookInterview()" />
							    <input type="button" class="button radius btn" id="delBookInterview" value="取消面试" onclick="updateInterviewBook()" />
                                <input type="button" class="button radius btn" id="outBookInterview" value="淘汰" onclick="outInterviewBook()" />
                                <input type="button" class="button radius btn" id="editBookInterview" value="面试安排变更" onclick="editInterviewBook()" />
                                <input type="button" class="button radius btn" id="breakBookInterview" value="爽约" onclick="breakBookInterview()" />
                                <input type="button" class="button radius btn" id="estimateEdit" value="面试评估" onclick="estimateEdit()" />
                                <input type="button" class="button radius btn" id="unlocked" value="解锁" onclick="unlocked()" />
                                <input type="button" class="button radius btn" id="feedback" value="面试反馈" onclick="feedback()" />
                                <input type="button" class="button radius btn" id="sendEmail" value="发送简历" onclick="sentMessage()" />
                </div>
          <div id="datagrid1" class="mini-datagrid" url="/recruit/interviewBookController/queryInterviewBookListByPage?showPager=true"  showPager="true"
              idField="id" sizeList="[1,2,50,100]" pageSize="10" allowResize="false" ondrawcell="ondrawcell"  multiSelect="true" >
                <div property="columns">
                  <div type="checkcolumn" name="id" field="id"></div>
                  <div name="name" field="name" width="80" allowSort="true" >候选人</div>
                   <div name="lockStatus" field="lockStatus" width="80" align="center" headerAlign="center" allowSort="true" allowSort="false">锁定状态</div>    
                  <div name="cJobName" field="cJobName" width="80" align="center" headerAlign="center" allowSort="true" allowSort="false">职位名称</div>    
                  <div name="cOrgName" field="cOrgName" width="80" align="center" headerAlign="center" allowSort="false">应聘部门</div>                            
                  <div name="interviewers" field="interviewers" width="100"  allowSort="false" align="center" headerAlign="center">面试官</div>
                  <div name="interviewStatus" field="interviewStatus" width="60"  allowSort="false" align="center" headerAlign="center">状态</div>
                  <div name="cpStatus" field="cpStatus" width="60"  allowSort="false" align="center" headerAlign="center" renderer="onInterviewRenderer">候选人面试状态</div>
                  <div name="interviewAddress" field="interviewAddress" width="60"  allowSort="false" align="center" headerAlign="center">面试地点</div>
                  <div name="interviewTimes" field="interviewTimes" width="100" allowSort="true" align="center" headerAlign="center">面试时间</div>
                  <div name="content" field="content" width="100" allowSort="true" align="center" headerAlign="center">面试反馈</div>
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
  var webRoot = "${webRoot}";
  var temp = "${isBook}";
</script>
	<script type="text/javascript" src="${webRoot}/resources/js/flow/interview/interviewBookManage.js"></script>
</html>









