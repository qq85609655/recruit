/**
 * 基本通用JS方法.
 */

/**
 * AJAX post方式提交保存数据.
 * <p>
 * 如果没有回调函数，则默认调用CloseWindow.
 * </p>
 * 
 * @param url
 *            提交到的URL
 * @param data
 *            要提交的数据，JSON或serialize的表单数据
 * @param callback
 *            需要调用的回调函数，如果没有，则默认调用CloseWindow
 */
function SaveData(url, data, callback) {
  $.ajax({
    url : url,
    type : 'post',
    async : false,
    data : data,
    dataType : "json",
    cache : false,
    success : function(e) {
      if (callback) {
        callback.call(this, e);
      } else {
        if (e.success) {
          CloseWindow(e);
        } else {
          mini.alert(e.msg);
        }
      }
    },
    error : function(jqXHR, textStatus, errorThrown) {
      if (callback) {
        var backData = {
          success : false,
          msg : jqXHR.responseText
        };
        callback.call(this, backData);
      } else {
        mini.alert(jqXHR.responseText);
        CloseWindow();
      }
    }
  });
}

/**
 * 关闭mini.open的DialogWindow.
 * 
 * @param action
 *            关闭后的动作，如向上层传输提示文字等。如果等于“close”，会检查表单是否发生变更
 * @param form
 *            用于检查是否发生改变的表单对象，miniUI form对象
 */
function CloseWindow(action, form) {
  if (action == "close" && form != null && form.isChanged()) {
    if (confirm("数据被修改了，是否先保存？")) {
      return false;
    }
  }
  if (window.CloseOwnerWindow) {
    return window.CloseOwnerWindow(action);
  } else {
    if (action.msg) {
      alert(action.msg);
    }
    window.close();
  }
}

/**
 * 统一的错误文本直接显示方法，需要有对应ID的_error Label标签配合.
 * 
 * @param e
 *            传入的validate触发事件
 */
function ValidErrorText(e) {
  var id = e.sender.name + "_error";
  var el = document.getElementById(id);
  if (el) {
    el.innerHTML = e.errorText;
  }
}

/**
 * 创建mini.open对话框.
 * 
 * @param url
 *            对话框内容URL
 * @param title
 *            对话框标题
 * @param reloadObj
 *            对话框关闭后需要刷新的对象, null就什么都不刷新
 * @param width
 *            对话框宽度, 默认600px
 * @param height
 *            对话框高度, 默认360px
 * @param ondestroycallback
 *            销毁Dialog时调用的回调函数
 */
function OpenDialog(url, title, reloadObj, width, height, ondestroycallback) {
  var dialogWidth = width ? width : 600;
  var dialogHeight = height ? height : 360;
  mini.open({
    url : url,
    title : title,
    width : dialogWidth,
    height : dialogHeight,
    onload : function() {
    },
    ondestroy : function(action) {
      ShowActionTip(action);
      if (reloadObj) {
        reloadObj.reload();
      }
      if (ondestroycallback) {
        ondestroycallback.call(this, action,this);
      }
    }
  });
}

/**
 * 右下角弹出Tip提示框，具体样式内容根据传入action.
 * 
 * @param action
 *            传入要显示的内容和样式
 */
function ShowActionTip(action) {
  if (action.success != null) {
    if (action.success) {
      ShowSuccessTip(action.msg);
    } else {
      ShowFailureTip(action.msg);
    }
  }
}

/**
 * 右下角弹出成功Tip提示框.
 * 
 * @param message
 *            信息内容
 * @param title
 *            标题，不填默认为“成功”
 */
function ShowSuccessTip(message, title) {
  if (title) {
    ShowTips(title, message, "success");
  } else {
    ShowTips("成功", message, "success");
  }
}

/**
 * 右下角弹出失败Tip提示框.
 * 
 * @param message
 *            信息内容
 * @param title
 *            标题，不填默认为“失败”
 */
function ShowFailureTip(message, title) {
  if (title) {
    ShowTips(title, message, "danger");
  } else {
    ShowTips("失败", message, "danger");
  }
}

function ShowErrorTip(msg) {
	mini.showTips({
		content : "<span class='font-icon icon_error'></span><span class='success-text'>" + msg + "</span>",
		state : "danger",
		x : "center",
		y : "center",
		timeout : 3000
	});
}

/**
 * 右下角弹出普通信息Tip提示框.
 * 
 * @param message
 *            信息内容
 * @param title
 *            标题，不填默认为“提示”
 */
function ShowInfoTip(message, title) {
  if (title) {
    ShowTips(title, message, "info");
  } else {
    ShowTips("提示", message, "info");
  }
}

/**
 * 右下角弹出警告Tip提示框.
 * 
 * @param message
 *            信息内容
 * @param title
 *            标题，不填默认为“警告”
 */
function ShowWarnTip(message, title) {
  if (title) {
    ShowTips(title, message, "warning");
  } else {
    ShowTips("警告", message, "warning");
  }
}

/**
 * 右下角弹出Tip提示框，3秒后关闭.
 * 
 * @param title
 *            标题
 * @param message
 *            信息内容
 * @param state
 *            弹出框样式，success、danger、info、warning，空为default
 */
function ShowTips(title, message, state) {
  mini.showTips({
    content : "<div style=\"padding: 5px 10px;\"><b>" + title + "</b><p>"
        + message + "</p></div>",
    state : state,
    x : "right",
    y : "center",
    timeout : 3000
  });
}

//提示操作结果
function opResult(msg) {
	mini.showTips({
		content : "<span class='font-icon " + (msg.success ? "icon_ok" : "icon_error") + "'></span><span class='success-text'>" +  msg.msg + "</span>",
		state : msg.success ? "success" :"danger",
		x : "center",
		y : "center",
		timeout : msg.success ? 2000 : 1000*4
	});
}

//定义一个全局script的标记数组，用来标记是否某个script已经下载到本地 
var scriptsArray = new Array(); 
$.cachedScript = function (url, options) { 
	// 循环script标记数组
	for (var s in scriptsArray) { 
	// console.log(scriptsArray[s]);
			// 如果某个数组已经下载到了本地
			if (scriptsArray[s]==url) { 
				return { // 则返回一个对象字面量，其中的done之所以叫做done是为了与下面$.ajax中的done相对应
					done: function (method) { 
						if (typeof method == 'function'){ // 如果传入参数为一个方法
							method(); 
						} 
					} 
				}; 
			}
	}
}

function removeLoad() {
	$(".page-loading").hide();
}

/*function autoHeight() { //以通过css解决,现注释掉
	$(".co-left").height("auto");
	$(".co-left").height(document.body.scrollHeight - $(".head").height() - $(".footer").height() + 18);
}*/

//弹出window框
function showAtPos(id,cl,callback) { 
  var win = mini.get(id); 
  var lt = $(cl).offset();
  win.showAtPos(lt.left+60, lt.top-100); 
  callback&&callback();
}  

//关闭页面的弹框
function hideWindow(id,callback){
	var win = mini.get(id);
	callback&&callback();
	win.hide();
}

// 初始化有默认提示的查询框
function initInputSearch(input) {
	$(input).focus(function() {
		if ($.trim(this.value) == this.defaultValue) {
			this.value = "";
			$(this).addClass("input-in");
		}
	}).blur(function() {
		if ($.trim(this.value) == "") {
			this.value = this.defaultValue;
			$(this).removeClass("input-in");
		}
	});
}

// 转换文件 大小
function fileSize(long) {
    var size = "";
    if (long < 1024) {
    	size = long + "B";
    } else if (long < 1048576) {
    	size = Math.round(long/1024*100)/100 + "K";
    } else if (long < 1073741824) {
    	size = Math.round(long/1048576*100)/100 + "M";
    } else {
    	size = Math.round(long/1073741824*100)/100 +"G";
    }
    return size;
  }

// 对Date的扩展，将 Date 转化为指定格式的String    
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，    
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)    
// 例子：    
// (new Date()).format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423    
// (new Date()).format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18    
Date.prototype.format = function(fmt)   
{ //author: meizz    
  var o = {   
    "M+" : this.getMonth()+1,                 //月份    
    "d+" : this.getDate(),                    //日    
    "h+" : this.getHours(),                   //小时    
    "m+" : this.getMinutes(),                 //分    
    "s+" : this.getSeconds(),                 //秒    
    "q+" : Math.floor((this.getMonth()+3)/3), //季度    
    "S"  : this.getMilliseconds()             //毫秒    
  };   
  if(/(y+)/.test(fmt))   
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));   
  for(var k in o)   
    if(new RegExp("("+ k +")").test(fmt))   
  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));   
  return fmt;   
}  

// 判断数组中是否存在值为value的元素
Array.prototype.Exists = function(v) {
	var b = false;
	for(var i = 0; i < this.length; i++) {
		if(this[i] == v) {
			b = true;
			break;
		}
	}
	return b;
}

// 移除数组中值为value的元素
Array.prototype.removeV = function(v) {
	var i;
	for(i = 0; i < this.length; i++) {
		if(this[i] == v) {
			break;
		}
	}
	if(i < this.length) {
		this.splice(i,1);
	}
}

//列表中性别转换
var Genders = [{ id: '001-000', text: '男' }, { id: '001-001', text: '女'}];        
function onGenderRenderer(e) {
  for (var i = 0, l = Genders.length; i < l; i++) {
      var g = Genders[i];
      if (g.id == e.value) return g.text;
  }
  return "";
}
//追加时间
function dateAdd(date, strInterval, Number) { // 参数分别为日期对象，增加的类型，增加的数量
  var dtTmp = date;
  switch (strInterval) {
  case 'second':
  case 's':
    return new Date(Date.parse(dtTmp) + (1000 * Number));
  case 'minute':
  case 'n':
    return new Date(Date.parse(dtTmp) + (60000 * Number));
  case 'hour':
  case 'h':
    return new Date(Date.parse(dtTmp) + (3600000 * Number));
  case 'day':
  case 'd':
    return new Date(Date.parse(dtTmp) + (86400000 * Number));
  case 'week':
  case 'w':
    return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
  case 'month':
  case 'm':
    return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp
        .getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
  case 'year':
  case 'y':
    return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp
        .getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
  }
}
