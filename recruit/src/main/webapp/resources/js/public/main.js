
$(document).delegate(".nav .item","click",function() {
	$(this).next().slideToggle("normal");
	$(this).find(".expand").toggleClass("icon-up-open-mini").toggleClass("icon-right-open-mini");
});

$(document).delegate(".nav a.leaf","click",function() {
	//$(".co-right-main").load($(this).attr("url"));
	var url = $(this).attr("url");
	if(url) {
		$(".nav a.selected").removeClass("selected");
		$(this).addClass("selected");
		window.location.href= basePath + url;
	}
});

$(function(){
  getItemTree();
})

function getItemTree(){
  var URL = basePath + '/sys/auth/menutree';
  $.ajax({
    url : URL,
    type : 'post',
    async : false,
    dataType : "json",
    cache : false,
    success : function(data) {
      createItems(data);
    }
  });
}

function createItems(dt){
  if(dt){
    var HTML = '';
    for(var i=0;i<dt.length;i++){
      HTML+='<li><a class="item"><span class="font-icon">'+dt[i]['icon']+'</span>'+dt[i]['menuName']+'<span class="font-icon expand icon-up-open-mini"></span></a>'
      if(dt[i]['children']){
        var dt2 = dt[i]['children'];
        if(dt2.length>0){
          HTML+='<div><ul>';
          for(var a=0;a<dt2.length;a++){
            var url1 = 'javascript:;';
            dt2[a]['url'] ? url1 = dt2[a]['url'] : url1 = url1;
            HTML+='<li><a class="leaf" url="'+url1+'">'+dt2[a]['menuName']+'</a>';
            HTML+='</li>';
          }
          HTML+='</ul></div>';
        }
      }
      HTML+='</li>';
    }
    $('#item_area').html(HTML);
  }
}