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
      var exceptionMessage = "";
      var responseJson = StringToJson(jqXHR.responseText);
      if (responseJson.exception) {
        exceptionMessage = responseJson.exception;
      } else {
        exceptionMessage = jqXHR.responseText;
      }
      if (callback) {
        var backData = {
          success : false,
          msg : exceptionMessage
        };
        callback.call(this, backData);
      } else {
        mini.alert(exceptionMessage);
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
 * 将传入字符串转化为JSON对象，如果无法转化，则返回原字符串.
 * 
 * @param jsonStr 传入的JSON格式字符串
 * @returns 返回JSON对象，出错返回原字符串
 */
function StringToJson(jsonStr) {
  try {
    var jsonObj = $.parseJSON(jsonStr);
    return jsonObj;
  } catch (ex) {
    return jsonStr;
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
        ondestroycallback.call(this, action);
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
    y : "bottom",
    timeout : 3000
  });
}