var TagPage = {
  o : { // 可配置参数
    resumeId : null,
    selected : null,
    isUpdate : true,
    beforeClose : null
  },
  tags : null,
  init : function(options) {
    options && $.extend(this.o, options);
    this.eventBind();
    this.queryTagData();
  },
  eventBind : function() {
    var tThis = this;

    // 跳转标签管理
    $("#tagMana").click(function() {
      window.location.href = basePath + "/resume/commonlyUsedTag";
    });

    // 选择标签
    $(".tag-all").delegate(".tag-a", "click", function() {
      $(this).remove();
      $("#tagSelected").append($(this));
    });

    // 取消选中的标签
    $("#tagSelected").delegate(".tag-a", "click", function() {
      $(this).remove();
      $("#tag-co-" + $(this).attr("pid")).after($(this));
    });

    // 点击确定
    $("#confirmTagSelect").click(function() {
      tThis.confirm();
    });
  },
  setCandidateId : function(id){
    this.o.resumeId = id;
    this.queryTagData();
  },
  queryTagData : function() { // 查询所有标签数据并填充
    $.ajax({
      type : "post",
      url : basePath + "/category/queryAll",
      dataType : "json",
      success : function(msg) {
        TagPage.tags = msg.obj;
        TagPage.draw();
      },
      error : function() {
        alert("查询标签数据异常!");
      }
    });
  },
  draw : function() { // 生成标签
    var d = TagPage.tags;
    if (d && d.length > 0) {
      $("#tagVoid").hide();
      var str = [];
      var temp = "";
      var selects = new Array();
      if (TagPage.o.selected) {
        selects = TagPage.o.selected.split(",");
      }
      this.clear();
      for (var i = 0; i < d.length; i++) {
        str = $("<div class='tag-li'><span class='tag-co' id='tag-co-" + d[i].id + "'>" + d[i].name
            + " :</span></div>");
        if (!(d[i].labelList && d[i].labelList.length > 0)) {
          str.append("<span class='font-grey'>无</span>");
        } else {
          for (var j = 0; j < d[i].labelList.length; j++) {
            temp = $("<a class='tag-a radius' pid='" + d[i].labelList[j].categoryId + "' id='tag-"
                + d[i].labelList[j].id + "' name="+ d[i].labelList[j].name +"><span class='tag-a-add'></span>"
                + d[i].labelList[j].name + "</a>");
            $(temp)[0].data = d[i].labelList[j];
            if (selects.Exists(d[i].labelList[j].id)) {
              $("#tagSelected").append(temp);
            } else {
              str.append(temp);
            }
          }
        }
        $(".tag-all").append(str);
      }
    } else {
      $("#tagVoid").show();
    }
  },
  clear : function() { // 清空标签数据
    $(".tag-all .tag-li").remove();
    $("#tagSelected .tag-a").remove();
  },
  setSelect : function(selects) { // 设置已选中的标签
    this.o.selected = selects;
    this.draw();
  },
  getSelect : function() { // 返回当前选中的标签id字串
    var str = "";
    $("#tagSelected .tag-a").each(function() {
      var id = $(this).attr("id");
      str += id.substring("tag-".length, id.length) + ",";
    });
    return str.substring(0, str.length - 1);
  },
  getSelectTags : function() { // 返回当前选中的标签
    var i = 0, tags = [];
    $("#tagSelected .tag-a").each(function() {
      tags[i++] = $(this)[0].data;
    });
    return tags;
  },
  confirm : function() { // 点击确定调用的函数
    var cur = this.getSelect();
    if (this.o.selected != cur) {
      var arr1 = [];
      if (typeof (this.o.selected) != 'undefined' && this.o.selected != null) {
        arr1 = this.o.selected.split(",");
      }
      var arr2 = cur.split(","), arr3 = [], // 需要删除的
      arr4 = [], // 需要添加的
      n3 = 0, n4 = 0;
      for (var i = 0; i < arr1.length; i++) {
        if (!arr2.Exists(arr1[i])) {
          arr3[n3++] = arr1[i];
        }
      }
      for (var i = 0; i < arr2.length; i++) {
        if (!arr1.Exists(arr2[i])) {
          arr4[n4++] = arr2[i];
        }
      }
      if (arr3.length > 0 || arr4.length > 0) {
        if(this.o.isUpdate) {
          this.updateTagsAjax(cur, arr3.join(","), arr4.join(","));
        }
      }
    } else {
      // hideWindow('#tagSelectWin');
    }
    this.close();
  },
  updateTagsAjax : function(selects, dels, adds) { // 向后台发送更新标签请求
    var tThis = this;
    $.ajax({
      url : basePath + "/resume/addCandidateTagsBycid",
      type : "post",
      data : "resumeId=" + tThis.o.resumeId + "&labels=" + selects + "&deletes=" + dels + "&adds="
          + adds,
      dataType : "json",
      success : function(msg) {
        if (msg.success) {
          tThis.o.selected = selects;
          tThis.close();
          getBasicInfor();
          alert("标签更新成功!");
        } else {
          alert("标签更新失败!");
        }
      },
      error : function() {
        alert("标签更新异常!");
      }
    });
  },
  close : function() { // 关闭选择器
    this.o.beforeClose && this.o.beforeClose();
    hideWindow('#tagSelectWin');
  }
};
