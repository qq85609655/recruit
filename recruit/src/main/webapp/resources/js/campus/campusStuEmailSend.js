//通过模板查询
function sendByTemplate() {
  if ("select" == type) {
    OpenDialog(webRoot + "/campusStudentController/sendByTemplate?ids=" + ids+ "&type=" + type, "按模板发送邮件", "", 750, 630);
  } else if ("all" == type) {
    OpenDialog(webRoot + "/campusStudentController/sendByTemplate?type=" + type, "按模板给所有学生发送",
        "", 750, 630);
  } else if ("some" == type) {
    OpenDialog(webRoot + "/campusStudentController/sendByTemplate?type=" + type,
        "按模板给资料未齐全学生发送", "", 750, 630);
  }

}

// 自定义发送邮件
function sendByDefinition() {

  if ("select" == type) {
    OpenDialog(webRoot + "/campusStudentController/sendByDefinition?ids=" + ids + "&type=" + type,
        "自定义发送邮件", "", 780, 660);
  } else if ("all" == type) {
    OpenDialog(webRoot + "/campusStudentController/sendByDefinition?type=" + type, "自定义所有学生发送", "",
        750, 660);
  } else if ("some" == type) {
    OpenDialog(webRoot + "/campusStudentController/sendByDefinition?type=" + type, "自定义给资料未齐全学生发送",
        "", 750, 660);
  }

}