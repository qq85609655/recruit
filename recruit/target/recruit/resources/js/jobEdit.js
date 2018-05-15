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
