


$(function(){
 
});



function subMit() {
  $.ajax({
    url : jsWebRoot + '/estimateController/estimateSave',
    type : 'POST', //GET
    async : true, //或false,是否异步
    data : $('#estimateForm').serialize(),
    dataType : 'json', //返回的数据格式：json/xml/html/script/jsonp/text
    success : function(data) {
      alert(data.msg);
      if(data.status == 200){
        window.opener=null;window.open('','_self');window.close();
      }
     
    }
})
}



  
  



