package com.csot.gm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TempExportUtil {

  private static final Logger logger = LoggerFactory.getLogger(TempExportUtil.class);

  /**
   * 下载物料模板 下载物料模板
   * 
   * @param response
   * @return
   */
  public String downFcstTemp(HttpServletResponse response) {
    response.setCharacterEncoding("UTF-8");
    response.setContentType("multipart/form-data");
    try {
      response.setHeader("Content-Disposition",
          "attachment;fileName=" + new String("物料上传模板.xls".getBytes("gbk"), "iso-8859-1"));
    } catch (UnsupportedEncodingException e1) {
      logger.error("download file UnsupportedEncodingException", e1);
    }
    try {
      String filePath = getFilePath();
      InputStream inputStream = new FileInputStream(new File(filePath));
      OutputStream os = response.getOutputStream();
      byte[] byt = new byte[2048];
      int length;
      while ((length = inputStream.read(byt)) > 0) {
        os.write(byt, 0, length);
      }
      // 这里注意关闭。
      os.close();
      inputStream.close();
    } catch (FileNotFoundException e) {
      logger.error("download file FileNotFoundException:", e);
    } catch (IOException e) {
      logger.error("download file IOException:", e);
    }
    return null;
  }

  /**
   * 获取文件所在路劲 获取文件所在路劲
   * 
   * @return
   */
  public String getFilePath() {
    String filePath = null;
    try {
      String contextPath =
          Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
      filePath = contextPath
      // .replace(CLASS_RELATIVE_PATH_STR, "").replace(FILE_PATH_PREFIX_STR, "")
          + "excelTemplate/importPart.xls";
    } catch (URISyntaxException e) {
      logger.error(e.getMessage(), e);
    }
    return filePath;
  }
}
