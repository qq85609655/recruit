package com.csot.gm.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PushbackInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.csot.gm.rawMaterial.model.FileEntity;

public class FileUtils {

  private FileUtils() {

  }

  private static final Logger logger = LoggerFactory.getLogger(FileUtils.class);

  /**
   * 从request中提取上传的文件列表
   * 
   * @param request 界面请求
   * @return 文件列表
   */
  public static List<FileEntity> getFilesFromRequest(HttpServletRequest request) {
    List<FileEntity> files = new ArrayList<FileEntity>();

    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
    try {
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
        InputStream inputstream = entity.getValue().getInputStream();
        if (!(inputstream.markSupported())) {
          inputstream = new PushbackInputStream(inputstream, 8);
        }

        String fileName = entity.getValue().getOriginalFilename();
        String prefix =
            fileName.lastIndexOf(".") >= 1 ? fileName.substring(fileName.lastIndexOf(".") + 1)
                : null;
        FileEntity file = new FileEntity();
        file.setInputStream(inputstream);
        file.setFileType(prefix);
        file.setFileName(fileName);
        files.add(file);
      }
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
    return files;
  }

  /**
   * 下载文件
   * 
   * @param response 界面响应
   * @param entity 需要绝对全路径
   * @throws IOException 异常
   */
  public static void setDownloadResponse(HttpServletResponse response, FileEntity entity)
      throws IOException {
    if (entity == null || response == null) {
      response.sendError(404, "File not found!");
      return;
    }

    File file = new File(entity.getFilePath());
    if (!file.exists()) {
      response.sendError(404, "File not found!");
      return;
    }

    response.reset(); // 非常重要
    response.setContentType("application/x-msdownload");
    response.setHeader(
        "Content-Disposition",
        "attachment; filename="
            + URLEncoder.encode(entity.getFileName(), "utf-8").replace("+", "%20"));
    OutputStream out = response.getOutputStream();
    BufferedInputStream bufr = new BufferedInputStream(new FileInputStream(file));
    byte[] buf = new byte[1024];
    int len = 0;
    while ((len = bufr.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    bufr.close();
    out.close();
  }


  public static void write(String path, String content) {
    try {
      OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path), "UTF-8");
      out.write(content);
      out.flush();
      out.close();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 删除指定路径的文件
   * 
   * @param path 路劲
   */
  public static void delete(String path) {
    File file = new File(path);
    if (file.exists()) {
      file.delete();
    }
  }

  /**
   * 删除指定目录下的多文件
   * 
   * @param path 路劲
   */
  public static void deleteAllFiles(String path) {
    File dirFile = new File(path);
    if (!dirFile.exists() || !dirFile.isDirectory()) {
      return;
    }
    File[] files = dirFile.listFiles();
    for (int i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        delete(files[i].getAbsolutePath());
      }
    }
  }

  /**
   * 读取指定路径下的文件内容（文件内容格式应是UTF-8）
   * @param filePath
   */
  public static void readTxt(String filePath) {
    try {
      File file = new File(filePath);
      if (file.isFile() && file.exists()) {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String lineTxt = null;
        while ((lineTxt = br.readLine()) != null) {
          System.out.println(lineTxt);
        }
        br.close();
      } else {
        System.out.println("文件不存在!");
      }
    } catch (Exception e) {
      System.out.println("文件读取错误!");
    }
  }
  
  /**
   * 拷贝文件
   */
  public static void copyFile(String fromPath, String destPath) {
    File oldfile = new File(fromPath);
    File newfile = new File(destPath);
    if (!oldfile.exists()) {
      throw new RuntimeException("文件不存在!");
    }
    if (newfile.exists()) {
      newfile.delete();
    } else if (!newfile.getParentFile().exists()) {
      newfile.getParentFile().mkdirs();
    }

    // int bytesum = 0;
    int byteread = 0;
    try { // 文件存在时
      InputStream inStream = new FileInputStream(fromPath); // 读入原文件
      FileOutputStream fs = new FileOutputStream(destPath);
      byte[] buffer = new byte[1024];
      while ((byteread = inStream.read(buffer)) != -1) {
        // bytesum += byteread; // 字节数 文件大小
        fs.write(buffer, 0, byteread);
      }
      fs.close();
      inStream.close();
    } catch (Exception e) {
      throw new RuntimeException("复制单个文件操作出错!");
    }
  }
  
}
