//自动加载行业类别数据
$("#searchIndustry").autocomplete(
		industries_autolist,
			{
            	minChars : 1,
				max : 500,
				width : 250,
				matchContains : true,
				closeOnClick : true,
				formatItem : function(m, o, j) {
					var n  ="";
					if($(".industry-middle").is(":hidden")){
						n = "<span onclick='chooseIndudtries(\""+m.name+"\",\"#currentlyIndustry\")'>" + m.name + "</span>";
					}else{
						var isChecked="";
						if($("#poc_"+m.id).attr("checked")=="checked"){
							isChecked = "checked";
						}
						n = "<input type='checkbox' "+isChecked+"  onclick='chooseCheckBoxIndudtries(\""+m.name+"\","+m.id+")'><span onclick='chooseItem(" + m.id + ',"'+ m.name + "\")'>" + m.name + "</span>";
					}
					return n;
				},
				formatMatch : function(m, n, j) {
					return m.code;
				},
				formatResult : function(j) {
					return "";
				}
		     }
).result(function(i, m, j) {
	$("#searchIndustry").val("");
	$("#").val(m.id);
})
		
	