package com.csot.recruit.common.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.common.exception.BusinessException;
import com.csot.recruit.controller.org.OrganazationController;
import com.csot.recruit.model.resume.ResumeUploadResult;

/**
 * 文件上传工具类
 * 
 */
public class UploadUtils {
  
  // 所有总大小20M
  private long totalSize = 1024*1024*20;
	
  // 最大文件大小4M
  private long maxSize = 1024*1024*4;
	
  // 定义允许上传的文件扩展名
  private Map<String, String> extMap = new HashMap<String, String>();
	
  // 文件保存目录相对路径
  private String basePath;
	
  // 文件的目录名
  private String dirName = "images";
	
  // 上传临时路径
  private static final String TEMP_PATH = "/temp";
	
  private String tempPath = basePath + TEMP_PATH;
	
  // 若不指定则文件名默认为 yyyyMMddHHmmss_xyz
  private String fileName;
	
  // 文件保存目录路径
  private String savePath;
	
  // 文件最终的url包括文件名
  private String fileUrl;
	
  // 当前保存的文件
  private File localFile;
	
  private static final Logger logger = LoggerFactory.getLogger(OrganazationController.class);
	
  public UploadUtils(String fileUploadUrl) {
	// 其中images,flashs,medias,files,对应文件夹名称,对应dirName
	// key文件夹名称
	// value该文件夹内可以上传文件的后缀名
	basePath = fileUploadUrl;
	extMap.put("images", "gif,jpg,jpeg,png,bmp");
	extMap.put("flashs", "swf,flv");
	extMap.put("medias", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
	extMap.put("files", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");
  }
  
  public UploadUtils(String basepath,String fileExt) {
    basePath = basepath;
    extMap.put("fileExt", fileExt);
  }

	/**
	 * 文件上传
	 * 
	 * @param request
	 * @return infos: info[0] 验证文件域返回错误信息; info[1] 上传文件错误信息 ; info[2] savePath; info[3] fileUrl.
	 */
	public String[] uploadFile(HttpServletRequest request) {
      savePath = basePath; // 文件保存目录路径
	  String[] infos = new String[4];
	  infos[0] = this.validateFields(request); // 验证
	  if (infos[0].equals("true")) {
	    Map<String, MultipartFile> map = this.getFields(request);
		for(MultipartFile file : map.values()) {
		  infos[1] = this.saveFile(file,null);
		}
	  }
      infos[2] = savePath;
      infos[3] = fileUrl;
      return infos;
	}
	
	/**
	 * 上传文件并解析
	 * @param type 上传类型
	 * @param request
	 * @return
	 */
	public ResumeUploadResult uploadFileForParse(String type, HttpServletRequest request) {
	  basePath = basePath + File.separator + type + File.separator; // 文件保存目录路径
	  savePath = basePath;
	  ResumeUploadResult rr = new ResumeUploadResult();
	  String validateResult = this.validateFields(request); // 验证
	  String saveDir = "";
	  String saveFileResult = "";
	  List<File> list = new ArrayList<File>();
	  if (validateResult.equals("true")) {
	    Map<String, MultipartFile> map = this.getFields(request);
	    for(MultipartFile file : map.values()) {
	      String flag = "";
	      String fileName = file.getOriginalFilename();
          String path = fileName.substring(0,fileName.lastIndexOf('.')).toLowerCase();
          String ftype = fileName.substring(fileName.lastIndexOf('.') + 1,fileName.length());
          savePath += path + File.separator;
	      File uploadDir = new File(savePath);
	      if (!uploadDir.isDirectory()) { // 检查目录
            uploadDir.mkdirs();
	      }
	      flag = this.saveFile(file,"resume." + ftype );
	      if(flag.equals("true")) { 
	        list.add(localFile);
	        saveDir += type + Constant.separator + path + Constant.separator + ",";
	        saveFileResult += flag + ",";
	      }
	    }
	  }
	  if(saveDir.length() > 0) {
	    saveDir = saveDir.substring(0, saveDir.length() - 1);
	  }
	  if(saveFileResult.length() > 0) {
	    saveFileResult = saveFileResult.substring(0, saveFileResult.length() - 1);
	  }
	  rr.setSaveFileResult(saveFileResult);
	  rr.setValidateResult(validateResult);
	  rr.setBasePath(basePath);
	  rr.setSaveDir(saveDir);
	  rr.setFileList(list);
	  return rr;
	}

	/**
	 * 上传验证,并初始化文件目录
	 * 
	 * @param request
	 */
	public String validateFields(HttpServletRequest request) {
		String errorInfo = "true";
		
		// 获取内容类型
		String contentType = request.getContentType();
		
		// 内容 大小
		int contentLength = request.getContentLength();
		
		File uploadDir = new File(savePath);
		if (contentType == null || !contentType.startsWith("multipart")) {
		    logger.info("请求不包含multipart/form-data流");
			errorInfo = "请求不包含multipart/form-data流";
		} else if (totalSize < contentLength) {
		    logger.info("上传文件总大小超出文件最大大小");
			errorInfo = "上传文件总大小超出文件最大大小[" + totalSize + "]";
		} else if (!ServletFileUpload.isMultipartContent(request)) {
			errorInfo = "请选择文件";
		} else if (!uploadDir.isDirectory()) {// 检查目录
	        uploadDir.mkdirs();
		} else if (!uploadDir.canWrite()) {
			errorInfo = "上传目录[" + savePath + "]没有写权限";
		} else {
			/*// 获取上传临时路径
			tempPath = request.getSession().getServletContext().getRealPath("/") + tempPath + "/";
			File file = new File(tempPath);
			if (!file.exists()) {
				file.mkdirs();
			}*/
		}
		return errorInfo;
	}

	/**
	 * 获取所有文件 
	 * @param request
	 * @return
	 */
	public Map<String, MultipartFile> getFields(HttpServletRequest request) {
	  Map<String, MultipartFile> map = new HashMap<String, MultipartFile>();
	  
	  //创建一个通用的多部分解析器  
      CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext()); 
      
      //判断 request 是否有文件上传,即多部分请求  
      if(multipartResolver.isMultipart(request)){  
        
          //转换成多部分request    
          MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request; 
          
          //取得request中的所有文件
          map = multiRequest.getFileMap();
      }
      return map;
	}
	
	/**
	 * 保存文件
	 *            
	 * @param file 要上传的文件域
	 * @param 新的文件名
	 * @return
	 */
	private String saveFile(MultipartFile file,String name) {
		String error = "true";
		if(file != null){  
          String fileName = file.getOriginalFilename();
          String fileType = fileName.substring((fileName.lastIndexOf('.')) + 1).toLowerCase();
          if(file.getSize() > this.maxSize) {
            error = "上传文件失败:上传文件大小超过限制";
          }
          else if(!checkExt(fileType)) { // 检查扩展名
            error = "上传文件失败:上传文件扩展名是不允许的扩展名。";
          }
          else {
            try {
              if(StringUtil.isNotEmpty(name)) {
                fileName = name; // 重新定义文件名
              }
              fileUrl = savePath + fileName;  //定义上传路径 
              logger.info("文件大小："+file.getSize() + " url: " + fileUrl);
              localFile = new File(fileUrl);  
              file.transferTo(localFile);
            }catch (IOException e) {
              logger.info("上传文件失败:" + e.getMessage());
              error = "上传文件失败！";
            } catch (Exception e) {
              logger.info("上传文件失败:" + e.getMessage());
              error = "上传文件失败:" + e.getMessage();
            }
          }
        }
		return error;
	}

	/**
	 * 检查扩展名
	 * @param fileExt 文件扩展名
	 * @return
	 */
	private boolean checkExt(String fileExt) {
	  boolean flag = false;
	  for(String value : extMap.values()) {
	     if (Arrays.<String> asList(value.split(",")).contains(fileExt)) {
	        flag = true;
	        break;
	     }
	  }
	  return flag;
	}
	
	/**
	 * 生成新文件保存文件内容 for content parse
	 * @param content
	 * @param url
	 * @return
	 */
	public File saveContent(String fileName, String content) {
	  if(StringUtils.isEmpty(fileName)) {
	    fileName = "resume.txt";
	  }
      File uploadDir = new File(basePath);
      uploadDir.mkdirs();
	  File file = new File(basePath + fileName);
	  FileWriter fw = null;  
	  try {
        fw = new FileWriter(file);
        fw.write(content);
        fw.close();
      } catch (IOException e) {
        logger.info(e.getMessage());
        throw new BusinessException(e.getMessage());
      } finally {
        try {
          if(null != fw) {
            fw.close();
          }
        } catch (IOException e) {
          logger.info(e.getMessage());
          throw new BusinessException(e.getMessage());
        }
      }
	  return file;
	}
	
  /** **********************get/set方法********************************* */

  public String getSavePath() {
	return savePath;
  }

  public long getMaxSize() {
	return maxSize;
  }

  public void setMaxSize(long maxSize) {
	this.maxSize = maxSize;
  }

  public Map<String, String> getExtMap() {
	return extMap;
  }

  public void setExtMap(Map<String, String> extMap) {
	this.extMap = extMap;
  }

  public String getBasePath() {
	return basePath;
  }

  public void setBasePath(String basePath) {
	this.basePath = basePath;
	tempPath = basePath + TEMP_PATH;
  }

  public String getDirName() {
	return dirName;
  }

  public void setDirName(String dirName) {
	this.dirName = dirName;
  }

  public String getTempPath() {
	return tempPath;
  }

  public void setTempPath(String tempPath) {
	this.tempPath = tempPath;
  }

  public String getFileUrl() {
	return fileUrl;
  }

  public String getFileName() {
	return fileName;
  }

  public void setFileName(String fileName) {
	this.fileName = fileName;
  }

  public File getLocalFile() {
    return localFile;
  }

  public void setLocalFile(File localFile) {
    this.localFile = localFile;
  }

  public long getTotalSize() {
    return totalSize;
  }

  public void setTotalSize(long totalSize) {
    this.totalSize = totalSize;
  }
}
