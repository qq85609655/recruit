package com.csot.gm.materialManage.service.impl.document;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.csot.gm.materialManage.dao.extension.document.FileMapper;
import com.csot.gm.materialManage.service.document.FileService;
import com.csot.gm.rawMaterial.service.impl.ImportAndExportServiceImpl;
import com.csot.gm.util.DocConverter;
import com.csot.gm.util.FileUtils;

@Service("fileService")
public class FileServiceImpl implements FileService {
  private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);
  private static final String OFFICE2PDF_URL =
      "http://10.108.230.107:18080/office/convert/office2Pdf";

  @Resource
  private FileMapper fileMapper;
  @Resource
  private RestTemplate restTemplate;


  @Override
  public List<com.csot.gm.materialManage.model.extension.document.File> getFile(String fileName) {
    List<com.csot.gm.materialManage.model.extension.document.File> fileList =
        fileMapper.getAllFile();
    if (StringUtils.hasText(fileName)) {
      return fileMapper.getFileByName("%" + fileName + "%");
    }
    return fileList;
  }

  @Override
  public int addFileToDb(com.csot.gm.materialManage.model.extension.document.File file,
      String basePath) {
    int count = 0;
    if (file != null) {
      MultipartFile f = file.getFile();
      if (f != null) {
        String id = UUID.randomUUID().toString().replace("-", "");
        String fileOldName = f.getOriginalFilename();
        String type = fileOldName.substring(fileOldName.lastIndexOf("."), fileOldName.length());
        String fileNewName = id + type;
        try {
          File fileM = new File(basePath);
          if (!fileM.exists()) {
            fileM.mkdirs();
          }
          String filePath = basePath + File.separator + fileNewName;
          File fi = new File(filePath);
          // 写文件
          f.transferTo(fi);
          file.setId(id);
          file.setFileType(type);
          file.setFileName(fileOldName);
          file.setUploadTime(new Date());
          count = fileMapper.addFileToDb(file);
        } catch (IllegalStateException e) {
          logger.error(e.getMessage());
        } catch (IOException e) {
          logger.error(e.getMessage());
        }
      }
    }
    return count;
  }

  public File getLoadFile(String id) {
    com.csot.gm.materialManage.model.extension.document.File file = fileMapper.getFileById(id);
    File f = null;
    if (null != file) {
      String basePath =
          ImportAndExportServiceImpl.getSysUploadPath(File.separator + "uploadedExcel");
      String filePath = basePath + File.separator + file.getId() + file.getFileType();
      f = new File(filePath);
    }
    return f;
  }

  // 下载文件
  @Override
  public void load(HttpServletResponse response, String id) {
    File file = getLoadFile(id);
    if (file.exists()) {
      try {
        String fileName = fileMapper.getFileById(id).getFileName();
        response.reset();
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition",
            "attachment; filename=" + URLEncoder.encode(fileName, "utf-8").replace("+", "%20"));
      } catch (UnsupportedEncodingException e1) {
        logger.error(e1.getMessage());
      }
      byte[] buffer = new byte[1024];
      FileInputStream fis = null;
      BufferedInputStream bis = null;
      try {
        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        OutputStream os = response.getOutputStream();
        int i = bis.read(buffer);
        while (i != -1) {
          os.write(buffer, 0, i);
          i = bis.read(buffer);
        }
      } catch (IOException ex) {
        logger.error(ex.getMessage());
      } finally {
        if (fis != null) {
          try {
            fis.close();
          } catch (IOException e) {
            logger.error(e.getMessage());
          }
        }
        if (bis != null) {
          try {
            bis.close();
          } catch (IOException e) {
            logger.error(e.getMessage());
          }
        }
      }
    }
  }

  @Override
  public boolean deletFile(String fileKey) {
    boolean flag = false;
    File file = getLoadFile(fileKey);
    if (file != null) {
      // 删除文件
      flag = deleteStandardDoc(file);
      if (flag) {
        deleteFileDb(fileKey);
      }
    }
    return flag;
  }

  private boolean deleteStandardDoc(File file) {
    if (file.isFile() && file.exists()) {
      file.delete();
      return true;
    }
    return false;
  }

  // 删除数据库中的file的记录
  private boolean deleteFileDb(String id) {
    int count = fileMapper.deleteFileById(id);
    if (count > 0) {
      return true;
    }
    return false;
  }

  @Override
  public boolean validateFileName(String fileName) {
    boolean flag = false;
    int count = fileMapper.countRecordByFileName(fileName);
    if (count > 0) {
      flag = false;
    } else {
      flag = true;
    }
    return flag;
  }

  @Override
  public String getFileSwfUrl(String id) throws Exception {
    com.csot.gm.materialManage.model.extension.document.File file = fileMapper.getFileById(id);
    if (file == null) {
      throw new RuntimeException("该文件不存在！");
    }
    if (!DocConverter.isPdfType(file.getFileType().replace(".", ""))) {
      throw new RuntimeException("该文件不支持预览！");
    }
    String filePath = ImportAndExportServiceImpl.getSysUploadPath(File.separator + "uploadedExcel");
    File swfFile = new File(filePath + File.separator + file.getId() + ".swf");

    if (!swfFile.exists()) {
      String docPath = filePath + File.separator + file.getId() + file.getFileType();
      String pdfPath = filePath + File.separator + file.getId() + ".pdf";
      try {
        if (".pdf".equalsIgnoreCase(file.getFileType()) == false) {
          // 讲office文件转换成pdf文件
          // DocConverter.office2Pdf(docPath, pdfPath);
          office2pdf(docPath, pdfPath);
        }
        DocConverter.pdf2swf(pdfPath, swfFile.getPath());
        FileUtils.delete(pdfPath);// 将临时pdf文件删掉
      } catch (Exception e) {
        logger.error(e.getMessage());
        throw e;
      }
    } else {
      logger.info("文件转换：该文件已存在！" + swfFile.getPath());
    }
    // 通过tomcat的server.xml映射配置本地文件的绝对路径进行预览
    String swfUrl = "/uploadedExcel/" + file.getId() + ".swf";
    return swfUrl;
  }

  private void office2pdf(String officePath, String pdfPath) {

    OutputStream outputStream = null;
    try {
      FileSystemResource resource = new FileSystemResource(officePath);
      MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
      param.add("jarFile", resource);
      param.add("fileName", officePath); // 主要是根据文件名后缀来哦按段文件类型
      byte[] responseBytes = restTemplate.postForObject(OFFICE2PDF_URL, param, byte[].class);
      File pdfFile = new File(pdfPath);
      outputStream = new FileOutputStream(pdfFile);
      outputStream.write(responseBytes, 0, responseBytes.length);
    } catch (Exception ex) {
      try {
        throw ex;
      } catch (Exception e) {
        logger.error(e.getMessage());
      }
    } finally {
      if (null != outputStream) {
        try {
          outputStream.close();
        } catch (IOException e) {
          logger.error(e.getMessage());
        }
      }
    }
  }

}
