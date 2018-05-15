package generator;

import generator.AmberCodeGeneratorTool.GeneratorMode;

public class SimpleTool {

  public static void main(String[] args) {
    String baseModulePackageStr = "org.amberframework.web.system";
    String tableNameStr = "T_SYS_USER";
    String subModulePackageStr = "";
    String objectNameStr = "BaseUser";

    { // 生成Original Mapper代码，同时生成默认的Service和Controller代码
      AmberCodeGeneratorTool simpleGeneratorTool = new AmberCodeGeneratorTool();
      simpleGeneratorTool.setBaseModulePackage(baseModulePackageStr);
      simpleGeneratorTool.setTableName(tableNameStr);
      simpleGeneratorTool.setSubModulePackage(subModulePackageStr);
      simpleGeneratorTool.setObjectName(objectNameStr);
      simpleGeneratorTool.setGeneratorMode(GeneratorMode.SIMPLE);

      simpleGeneratorTool.generator();
    }
  }

}
