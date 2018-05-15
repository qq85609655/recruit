<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<title>Insert title here</title>
<style>
html, body {
  overflow: hidden; /* overflow|overflow-x|overflow-y : visible|hidden|scroll|auto */
}
</style>
</head>
<body>

  <script type="text/javascript">
      mini.parse();
      
      var base = document.getElementsByTagName("base")[0].getAttribute("href"); //IE下base标签不兼容
      var uid = mini.get("uid").getValue();
      var partType = mini.get("partType").getValue();
      
      var gridBrand = mini.get("datagridBrand");
      var keyTextBrand = mini.get("keyTextBrand");
      var brandUp = mini.get("brandLookup");
      var gridSpec = mini.get("datagridSpec");
      var keyTextSpec = mini.get("keyTextSpec");
      var specUp = mini.get("specLookup");
      var gridClass = mini.get("datagridClass");
      var keyTextClass = mini.get("keyTextClass");
      var classUp = mini.get("classLookup");
      var gridPlant = mini.get("datagridPlant");
      var keyTextPlant = mini.get("keyTextPlant");
      var plantUp = mini.get("plantLookup");
      gridBrand.load();
      gridSpec.load();
      gridClass.load();
      gridPlant.load();

      function onOkClick(type) {
        var text = null
        if (type == "spec") {
          text = specUp.getText();
          if (text == null || text == "") {
            specUp.showPopup();
            mini.showTips({
              content : "请选择有效规格",
              state : "danger",
              x : "center",
              y : "center",
              timeout : 2000
            });
          } else {
            specUp.hidePopup();
          }
        } else if (type == "brand") {
          text = brandUp.getText();
          if (text == null || text == "") {
            brandUp.showPopup();
            mini.showTips({
              content : "请选择有效品牌",
              state : "danger",
              x : "center",
              y : "center",
              timeout : 2000
            });
          } else {
            brandUp.hidePopup();
          }
        } else if (type == "class") {
          text = classUp.getText();
          if (text == null || text == "") {
            classUp.showPopup();
            mini.showTips({
              content : "请选择有效设备类别",
              state : "danger",
              x : "center",
              y : "center",
              timeout : 2000
            });
          } else {
            classUp.hidePopup();
          }
        } else if (type == "plant") {
          text = plantUp.getText();
          if (text == null || text == "") {
            plantUp.showPopup();
            mini.showTips({
              content : "请选择有效设备厂商",
              state : "danger",
              x : "center",
              y : "center",
              timeout : 2000
            });
          } else {
            plantUp.hidePopup();
          }
        }

      }

      function onlookupSpecValidation(e) {
        var specText = specUp.getText();
        if (specText == null || specText == "") {
          e.isValid = false;
          e.errorText = "未选择有效规格值";
        }
      }

      function onlookupBrandValidation(e) {
        var brandText = brandUp.getText();
        if (brandText == null || brandText == "") {
          e.isValid = false;
          e.errorText = "未选择有效品牌值";
        }
      }

      function onlookupClassValidation(e) {
        var classText = classUp.getText();
        if (classText == null || classText == "") {
          e.isValid = false;
          e.errorText = "未选择有效设备类别";
        }
      }

      function onlookupPlantValidation(e) {
        var plantText = plantUp.getText();
        if (plantText == null || plantText == "") {
          e.isValid = false;
          e.errorText = "未选择有效设备厂商";
        }
      }

      function onClearClick(type) {
        if (type == "brand") {
          brandUp.deselectAll();
        } else if (type == "spec") {
          specUp.deselectAll();
        } else if (type == "class") {
          classUp.deselectAll();
        } else if (type == "plant") {
          plantUp.deselectAll();
        }
      }

      function onSearchClick(type) {
        if (type == "brand") {
          gridBrand.setUrl("enumValue/enumValuedatagrid");
          gridBrand.load({
            enumTypeId : '${brandEnumTypeId}',
            enumValue : keyTextBrand.value,
            sortField : "enumText",
            sortOrder : "asc",
            showPager : false
          });
        } else if (type == "spec") {
          gridSpec.setUrl("enumValue/enumValuedatagrid");
          gridSpec.load({
            enumTypeId : '${specEnumTypeId}',
            enumValue : keyTextSpec.value,
            sortField : "enumText",
            sortOrder : "asc",
            showPager : false
          });
        } else if (type == "class") {
          gridClass.setUrl("enumValue/enumValuedatagrid");
          gridClass.load({
            enumTypeId : '${deviceClassEnumTypeId}',
            enumValue : keyTextClass.value,
            sortField : "enumText",
            sortOrder : "asc",
            showPager : false
          });
        } else if (type == "plant") {
          gridPlant.setUrl("enumValue/enumValuedatagrid");
          gridPlant.load({
            enumTypeId : '${devicePlantEnumTypeId}',
            enumValue : keyTextPlant.value,
            sortField : "enumText",
            sortOrder : "asc",
            showPager : false
          });
        }
      }

      function onComboValidation(e) {
        if (this.text == "NA") {
          e.isValid = true;
        } else if (null == e.value || e.value == "") {
          //如果下拉框值为空时，则提示如下
          e.isValid = false;
          e.errorText = "请完成必选项下拉值选择";
        } else {
          //若有值且值不在下拉值中，则显示如下提示
          var items = this.findItems(e.value);
          if (!items || items.length == 0) {
            e.isValid = false;
            e.errorText = "[" + e.value + "]" + "不在下拉数据中";
          }
        }
      }

      function onRtn() {
        mini.confirm("确定放弃生成料号吗？", "警告", function(action) {
          if (action == "cancel")
            return;
          window.location.href = base + "rawMaterial/rawMaterial?uid=" + uid + "&partType="
              + partType;
        });

      }

      function submitForm() {
        var form = new mini.Form("form1");
        form.validate();
        if (form.isValid() == false) {
          var errorTexts = form.getErrorTexts();
          showErrorTexts(errorTexts);

          return;
        }

        var dd = $("#form1").serialize();

        $.ajax({
          url : "rawMaterial/checkProAndCreate",
          type : "post",
          async : false,
          data : dd,
          dataType : 'json', //数据格式为json
          success : function(data) {
            var partNoId = data.attributes.partNoId;
            var success = data.attributes.success;
            // 物料类型检查不通过
            if (success == "falseType" || success == "false") {
              showErrorTexts(data.attributes.message);
            } else if (success == "true") {
              window.location.href = base + "rawMaterial/createComplete";
            }
          },
          error : function(msg) {
            mini.alert(msg, "error", CloseWindow);
          }
        });
      }

      function showErrorTexts(errorTexts) {
        var win = window
            .open(
                '',
                "",
                'height=200,width=450,top=200,left=400,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no, titlebar=no');
        win.document.open('text/html', 'replace');
        win.document.write(errorTexts);
        win.document.close();
      }

      function windowTips(messageid) {
        mini.hideMessageBox(messageid);
      }
    </script>

</body>
</html>