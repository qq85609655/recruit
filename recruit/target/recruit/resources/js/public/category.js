var dataCategory = {
		count:0,
		show:function(separate,object,datavalue){
			var d="";
			var arrayList = object[datavalue].children;
			var name = object[datavalue]["name"];
			for(var i=0;i<arrayList.length;i++){
				var p = arrayList[i]["Name"];
				var id = arrayList[i]["Id"];
				var isChecked="";
				if($("#poc_"+id).attr("checked")=="checked"){
					isChecked = "checked";
				}
				d += '<li class="hasChild" onclick="dataCategory.chooseCategory(' + id + ",'"+separate+"','"
				+ p + '\')" title="' + p + '">' +'<input type="checkbox" '+isChecked+' onclick="dataCategory.checkboxCategory(' + id + ",'"+ p + '\')" class=po_'+ id +'>'+ p +'</li>'
			}
			
		    $("."+separate+"-category").css("border-bottom","1px dashed #DDDDDD ");
			
			$("."+separate+"-category-pdata").hide();
			$(".choose-"+separate+"-panel").hide();
			$("."+separate+"-category-data").html(d);
			$("."+separate+"-category span").text(name);
		},
        chooseCategory:function(id,separate,p){
        	var d = "";
        	var c=".po_"+id;
        	if(dataCategory.count<5){
        		if($(c).attr("checked")){
        			$(c).attr("checked",false);
        			$("#po_"+id).remove();
        			dataCategory.count--;
        		}else{
        			$(c).attr("checked","checked");
        			d += '<li class="hasChild" value="'+id+'" id=po_'+ id +' onclick="dataCategory.removeCategory(' + id + ",'"
        				+ p + "','"+separate+'\')" title="' + p + '">' +'<input type="checkbox" id=poc_'+ id +' checked="checked" >'+ p +'</li>'
        			$(".choose-"+separate+"-data").append(d);
        			dataCategory.count++;
        		}
        	}else{
        		if($(c).attr("checked")){
        			$("."+separate+"-category-prompt").empty();
        			$(c).attr("checked",false);
        			$("#po_"+id).remove();
        			dataCategory.count--;
        		}else{
        			$(c).removeAttr("checked"); 
        			$("."+separate+"-category-prompt").html("<font color='red'>不能多于五个</font>");
        		}
        	}
        },
        checkboxCategory:function(id,p){
        	var c=".po_"+id;
        	if($(c).attr("checked")){
        		$(c).attr("checked",false);
        	}else{
        		$(c).attr("checked",true);
        	}
        },
        removeCategory:function(id,p,separate){
        	$("."+separate+"-category-prompt").empty();
        	$("#po_"+id).remove();
        	dataCategory.count--;
        	$(".po_"+id).attr("checked",false);
        }
}
