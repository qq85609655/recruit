//列表中学历转换
var qualifications;        
function qualificationsRenderer(e) {
  for (var i = 0, l = qualifications.length; i < l; i++) {
      var g = qualifications[i];
      if (g.typeId == e.value) return g.typeName;
  }
  return "";
}

/*function qualificationsSelect(){
  var htmlStr = '<option value="">-请选择-</option>';
  for (var i = 0, l = qualifications.length; i < l; i++) {
    var g = qualifications[i];
    htmlStr +='<option value='+g.typeId+'>'+g.typeName+'</option>';
  }
  $("#select_qualifications").html(htmlStr);
}*/
$(function() {
  
    
    // = education
    $.ajax({
      url : basePath + "/datadictGroupTypeController/getDictsByCode/education",
      type : "post",
      async: false,
      dataType: "json",
      success : function(data) {
        qualifications = data.data ;
      }
    });
    
  
    var grid = mini.get("datagrid1");
    grid.load({
      isFeedBack:2});
    mini.parse();
    
    apply_post_name = mini.get("applyPostName"); // 申请岗位名称
   
});

//为数据添加超链接
function ondrawcell(e) {
  var row = e.row, column = e.column, field = e.field, value = e.value;
  // 超链接任务
  if(field =="name"){
    e.cellHtml = '<a id="name_' + row.id + '" href="' + basePath + "/candidateController/getResumeList/" + row.candidateId + '" target="_Blank" style="display:block;width:100px;height:20px;color:blue;" data-placement="right" >' + value + '</a>';
  }
}

function choseState(state, e) {
  $(".posi-import-btn").removeClass("tab-up");
  $(e).addClass("tab-up");
  if(state == 1 ){
    $("#isFeedBack").val(1);
    $("#recommend").hide();
    $("#ChangeRecommend").hide();
    $("#outRecommend").hide();
  }
  
  if(state == 2){
    $("#isFeedBack").val(2);
    $("#recommend").show();
    $("#ChangeRecommend").show();
    $("#outRecommend").show();
    
    
  }
  
  search();
}

function search() {
    var searchKey = $("#searchKey").val();
    var positionId = $("#positionId").val();
    var isFeedBack = $("#isFeedBack").val();
    var qualifications = $("#select_qualifications").val();
    var grid = mini.get("datagrid1");
    grid.load({positionId:positionId, 
      qualifications:qualifications,
      isFeedBack:isFeedBack,
        searchKey:searchKey});
}


//选择岗位
function choseJob() {
  // 模拟选中岗位
  // 获取选中值（岗位ID,岗位名称,部门ID,部门名称）
  // 模拟操作
  OpenDialog("/recruit/jobController/toSelectPage", "选择岗位", '', '680', '460', setJobData);
}

//选择岗位 回调函数
function setJobData(action, e) {
  if (action == "ok") {
    var iframe = e.getIFrameEl();
    var data = iframe.contentWindow.GetData();
    data = mini.clone(data);
    apply_post_name.setValue(data.cJobname);
    $("#positionId").val(data.cJobcode);
  }
}

//选择岗位
function changeJob() {

  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if(rows.length == 1){
    
    OpenDialog("/recruit/jobController/toChangePage?id="+rows[0].candidateRecommendId, "选择岗位", '', '680', '460', changeJobData);
  }else{
    mini.alert("请选择一条数据！")
  }


  
}

//选择岗位 回调函数
function changeJobData(action, e) {
  if(action != 'close'){
    mini.alert(action);
  }
  
}

function onKeyEnter(e) {
    search();
}

function onDateRenderer(e) {
  var value = e.value;
  if (value) return new Date(value).format("yyyy-MM-dd");
  return "";
}

function updateRecommend(status){
  var grid = mini.get("datagrid1");
  var rows = grid.getSelecteds();
  if(rows.length){
    var ids="";
    for(var i=0;i<rows.length;i++){
      ids+=rows[i].candidateRecommendId;
      if(i!=rows.length-1){
        ids+=",";
      }
    }
    $.ajax({
      url : basePath + "/candidateRecommendController/updateRecommend",
      type : "post",
      data:{status:status,
        ids:ids},
      dataType: "json",
      success : function(data) {
        mini.alert(data.msg);
        grid.reload();
      }
    });
  }else{
    mini.alert("请至少选择一条数据！")
  }

};

function clearAll(){
  $("#searchKey").val("");
  apply_post_name.setValue("");
  $("#positionId").val("");
};