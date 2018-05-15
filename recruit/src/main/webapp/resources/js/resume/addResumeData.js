 var provinces = [192, 193, 194, 195, 196, 197, 198, 199, 950,200, 201, 202, 203, 191, 190, 205, 206, 207, 208,204, 209, 210, 212, 213, 214, 211, 215, 216, 954,949, 217, 218, 219, 220,-99];
var foreignData = [45, 14887, 102, 50, 14886, 113, 74, 176, 177, 26, 111, 75, 14885, 32, 16, 172, 174, 166, 153, 175, 112, 9, 122, 61, 179, 129, 93, 27, 138, 106, 58, 47, 84,69, 2, 178, 68, 67, 28, 29, 72, 144, 126, 25, 104, 119, 18, 80, 188, 131, 5, 123, 109, 78, 14884, 143, 105, 14812, 10, 132, 147,71, 53, 173, 22, 65, 97, 7, 189, 182, 56, 130, 128, 124, 12, 101, 43, 33, 48, 159, 100, 165, 13, 57, 187, 38, 157, 151, 95, 81, 39, 160, 96,152, 108, 156, 92, 63, 52, 121, 107, 99, 87, 91, 31, 155, 55, 103, 181, 134, 62, 24, 110, 114, 168, 180, 49, 85, 90, 139, 169, 137, 8, 35, 125, 59, 66, 148, 20,14888, 163, 44, 127, 140, 133, 23, 34, 21, 98, 167, 88, 14, 3, 183, 184, 145, 146, 115, 70, 161, 54, 76, 64, 36, 120, 118, 142, 79, 6, 11, 46, 77, 135, 94, 19, 15, 158,170, 82, 37, 60, 141, 186, 51, 42, 171, 83, 17, 116, 164, 4, 136, 30, 40, 162, 117, 73, 86, 89]
var residency = {
		show:function(mark){
			var d = "<ul>";
			for(var i=0;i<provinces.length;i++){
				d+="<li class='hasChild' onclick=residency.chooseProvince("+provinces[i]+",'"+mark+"')>"+areas[provinces[i]].name+"</li>";
			}
			d+="</ul>";
			
			$("."+mark+"Content").html(d);
		},
		chooseProvince:function(provinceCode,mark){
			var d = "<dt> <dl>"+areas[provinceCode].name+"</dl>";
			if(provinceCode !=-99){
				var maindowntown = areas[provinceCode].children;
				for(var i = 0;i<maindowntown.length;i++){
					d+="<dd onclick=residency.chooseMaindowntown('"+areas[provinceCode].name+"."+maindowntown[i].name+"','"+mark+"') >"+maindowntown[i].name+"</dd>";
				}
			}else{
				for(var i=0;i<foreignData.length;i++){
					d+="<dd onclick=residency.chooseMaindowntown('"+areas[provinceCode].name+"."+foreignArray[foreignData[i]].name+"','"+mark+"') >"+foreignArray[foreignData[i]].name+"</dd>";
				}
			}
			d+="<div class='clearFloat'></div></dt>";
			$("."+mark+"ChildContent").html(d);
			$(".hasChild").live('click',function(){
				var lt = $(this).offset();
				var l = lt.left;
				var t = lt.top;
				if(mark=="location"){
					t=t-$("#locationOffset").offset().top+395;
				}
				$("."+mark+"ChildData").css({
					left:l-75,
					top:t-175
				})
			})
			
			$("."+mark+"ChildData").show();
		},
		chooseMaindowntown:function(maindowntown,mark){
			$("#"+mark+"Btn").val(maindowntown);
			$("#"+mark+"Hid").val(maindowntown);
			$("."+mark+"ChildData").hide();
			$("."+mark+"Data").hide();
			$("#"+mark+"Clear").show();
		}
}

var industry = {
		show:function(){
			var d = "<ul>";
			for(var i=0;i<indexArr.length;i++){
				d+="<li class='industryC' onmouseover=industry.chooseChild("+indexArr[i]+")>"+industries[indexArr[i]].name+"</li>";
			}
			d+="</ul>";
			$(".industryContent").html(d);
		},
        chooseChild:function(industryCode){
        	var d = "<ul><br>";
        	var childs = industries[industryCode].children;
        	for(var i=0;i<childs.length;i++){
        		d+="<li onclick=industry.chooseData('"+childs[i].name+"')>"+childs[i].name+"</li>";
        	}
        	d+="</ul>";
        	$(".industryChildContent").html(d);
        	$(".industryC").live('mouseover',function(){
        		var lt = $(this).offset();
				var l = lt.left;
				var t = lt.top;
				$(".industryChild").css({
					left:l-30,
					top:t-$("#locationOffset").offset().top+220
				})
        	})
        	$(".industryChildContent").show();
          	$(".industryChild").show();
        },
        chooseData:function(name){
        	$("#industryBtn").val(name);
        	$("#industryHid").val(name);
        	$(".industryBtn").hide();
        	$(".industryChild").hide();
        	$("#industryClear").show();
        }
        
}

var resumeData;
var resumeDataArr;
var resumeDataOperate = {
		show:function(mark){
			if(mark == "school"){
				resumeData = school;
				resumeDataArr = schoolArr;
			}else if(mark=="major"){
				resumeData = pro;
				resumeDataArr = professionalArr;
			}
			var d = "<ul>";
			for(var i=0;i<resumeDataArr.length;i++){
				d+="<li class='industryC' onclick=resumeDataOperate.chooseChild("+resumeDataArr[i]+",'"+mark+"')>"+resumeData[resumeDataArr[i]].name+"</li>";
			}
			d+="</ul>";
			$("."+mark+"Content").html(d);
		},
        chooseChild:function(code,mark){
        	var d = "<ul><br>";
        	var childs = resumeData[code].children;
        	for(var i=0;i<childs.length;i++){
        		d+="<li onclick=resumeDataOperate.chooseData('"+childs[i].Name+"','"+mark+"')>"+childs[i].Name+"</li>";
        	}
        	d+="</ul>";
        	$("."+mark+"ChildContent").html(d);
        	$(".industryC").live('click',function(){
        		var lt = $(this).offset();
				var l = lt.left;
				var t = lt.top;
				if(mark =="major"){
					t=t-$("#"+mark+"Offset").offset().top+335;
					l=l+70;
				}else{
					t=t-$("#"+mark+"Offset").offset().top+295;
				}
				
				$("."+mark+"ChildData").css({
					left:l-75,
					top:t-175
				})
        	})
          	$("."+mark+"ChildData").show();
        },
        chooseData:function(name,mark){
        	$("#"+mark+"Btn").val(name);
        	$("#"+mark+"Hid").val(name);
        	$("."+mark+"ChildData").hide();
        	$("."+mark+"Data").hide();
        	$("#"+mark+"Clear").show();
        }
}


