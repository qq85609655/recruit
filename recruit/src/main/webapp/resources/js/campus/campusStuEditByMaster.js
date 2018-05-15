//设置编辑时候身份证号码为只读模式
if (null == idCard.value || "" == idCard.value) {
  idCard.setReadOnly(false);
} else {
  idCard.setReadOnly(true);
}
// 设置编辑时候职位族为只读模式
if (null == family.value || "" == family.value) {
  family.setReadOnly(false);
} else {
  family.setReadOnly(true);
}
// 设置编辑时候职位子类为只读模式
if (null == subClass.value || "" == subClass.value) {
  subClass.setReadOnly(false);
} else {
  subClass.setReadOnly(true);
}
// 设置编辑时姓名只读
if (null == nameTextBox.value || "" == nameTextBox.value) {
  nameTextBox.setReadOnly(false);
} else {
  nameTextBox.setReadOnly(true);
}
// 设置编辑时站点只读
if (null == site.value || "" == site.value) {
  site.setReadOnly(false);
} else {
  site.setReadOnly(true);
}
// 设置编辑时工作地点只读
if (null == workPlaceCombo.value || "" == workPlaceCombo.value) {
  workPlaceCombo.setReadOnly(false);
} else {
  workPlaceCombo.setReadOnly(true);
}

function onSiteChanged(e) {
  var siteText = site.getText();
  mini.get("siteName").setValue(siteText);

}
function onJobFamilyChanged(e) {
  var jobFamilyText = family.getText();
  mini.get("jobFamilyName").setValue(jobFamilyText);

}
function onWorkPlaceChanged(e) {
  var workPlaceText = workPlaceCombo.getText();
  mini.get("workingPlace").setValue(workPlaceText);
}
function onJobClassChanged(e) {
  var jobClassText = jobClassLookup.getText();
  mini.get("jobClass").setValue(jobClassText);

}
function onOrgChanged(e) {
  var orgText = org.getText();
  mini.get("organization").setValue(orgText);
}
function onWorkPlaceValidation(e) {
  var workPlaceText = workPlaceCombo.getText();
  if ("" == workPlaceText || null == workPlaceText) {
    e.isValid = false;
    e.errorText = "请选择工作地点";
  }
}
// 校验身份证号码位数为18
function onIDCardsValidation(e) {
  if (e.isValid) {
    var pattern = /\d*/;
    if (e.value.length < 18 || e.value.length > 18 || pattern.test(e.value) == false) {
      e.errorText = "必须输入18位数字";
      e.isValid = false;
    }
  }
}
// 校验一二面成绩是否为SABC
function onResultValidation(e) {
  if (e.isValid) {
    if (isSABC(e.value) == false) {
      e.errorText = "必须输入S、A、B或C";
      e.isValid = false;
    }
  }
}
// 判断输入的是否S、A、B或C
function isSABC(v) {
  var re = new RegExp("^[SABC\_]+$");
  if (re.test(v))
    return true;
  return false;
}
// 校验胜任力是否百分数
function onCompetencyValidation(e) {
  if (e.isValid) {
    if (isPresentNum(e.value) == false) {
      e.errorText = "必须输入含%的百分数";
      e.isValid = false;
    }
  }
}
// 判断输入的是否百分数
function isPresentNum(v) {
  var re = new RegExp(/^\d+\.{0,1}\d+%$/);
  if (re.test(v))
    return true;
  return false;
}
function onSearchClick() {
  grid.setUrl("campusPostController/datagrid");
  grid.load({
    postName : postName
  });
}

function onClearClick() {
  jobClassLookup.deselectAll();
}

function onOkClick() {
  var row = grid.getSelected();
  // 设置选中岗位类的时候，带出相应的岗位族和岗位子类
  if (row) {
    family.setValue(row.jobFamily);
    subClass.setValue(row.jobSubclass);
    jobClassLookup.hidePopup();
  } else {
    jobClassLookup.showPopup();
    mini.showTips({
      content : "请选择职位类",
      state : "danger",
      x : "center",
      y : "center",
      timeout : 2000
    });
  }
}

function onRowClick() {
  onOkClick();
}

function onlookupJobclassValidation(e) {
  var jobClassValue = jobClassLookup.getText();

  if ("" == jobClassValue || null == jobClassValue) {
    e.isValid = false;
    e.errorText = "请选择职位类";
  }
}

function onjobFamilyValidation(e) {
  var jobFamliyName = family.getText();

  if ("" == jobFamliyName || null == jobFamliyName) {
    e.isValid = false;
    e.errorText = "请选择职位族";
  }
}

function onOrganizationValidation(e) {
  var orgValue = org.getText();
  var workPlaceText = workPlaceCombo.getText();
  if ("" == orgValue || null == orgValue) {
    e.isValid = false;
    e.errorText = "请选择组织";
  } else {
    // 判断如果工作地点为深圳时，则组织对应只能为深圳华星和深圳半导体
    // 地点为武汉时，对应组织只能为武汉华星和武汉半导体
    // 地点为惠州时，对应组织只能为惠州模组
    if (workPlaceText == "深圳") {
      if (orgValue == "深圳华星" || orgValue == "深圳半导体") {
        e.isValid = true;
      } else {
        e.isValid = false;
        e.errorText = "请选择正确的组织";
      }
    }
    if (workPlaceText == "武汉") {
      if (orgValue == "武汉华星" || orgValue == "武汉半导体") {
        e.isValid = true;

      } else {
        e.isValid = false;
        e.errorText = "请选择正确的组织";
      }
    }
    if (workPlaceText == "惠州") {
      if (orgValue == "惠州模组") {
        e.isValid = true;
      } else {
        e.isValid = false;
        e.errorText = "请选择正确的组织";
      }
    }
  }
}

function onSiteValidation(e) {
  var siteValue = site.getValue();
  if ("" == siteValue || null == siteValue) {
    e.isValid = false;
    e.errorText = "请选择站点";
  }
}

function onSexValidation(e) {
  var sexValue = mini.get("sex").getValue();
  if ("" == sexValue || null == sexValue) {
    e.isValid = false;
    e.errorText = "请选择性别";
  }
}

function onEduValidation(e) {
  var eduValue = mini.get("education").getValue();
  if ("" == eduValue || null == eduValue) {
    e.isValid = false;
    e.errorText = "请选择最高学历";
  }
}
// 保存修改
function onOk(e) {
  var data = form.getData(true);// 获取表单多个控件的数据
  form.validate();
  if (form.isValid() == false) {
    return;
  } else {
    $.ajax({
      url : "/recruit/campusStudentController/save",
      type : "post",
      data : data,
      dataType : "json",
      success : function(data) {
        if (data.success) {
          alert("保存成功！");
          CloseWindow("close", form);
        } else {
          mini.alert("保存失败！" + data.msg);
        }
      }
    });
    // SaveData("/recruit/campusStudentController/save",
    // $("#mainForm").serialize());
  }

}

function onCancel(e) {
  CloseWindow("close", form);
}