package com.csot.recruit.service.impl.resume;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
























import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.pojo.LoginClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.ConstantsConfigurer;
import com.csot.recruit.common.util.ContextHolderUtils;
import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.dao.resume.FileMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.service.position.RecruitPositionService;
import com.csot.recruit.service.resume.FileService;

@Service("FileService")
@Transactional
public class FileServiceImpl implements FileService {
    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Resource
    private CommonService com;
    
    @Resource
    private FileMapper fileMapper;
    
    @Resource
    RecruitPositionService recruitPositionService;
    

  @Override
  public List<com.csot.recruit.model.resume.File> getAllFile(HttpServletRequest request) {
    // TODO Auto-generated method stub
    List<com.csot.recruit.model.resume.File> file = fileMapper.getAllFile();
    if(file !=null && file.size()>0){
      String path = request.getContextPath();
      String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
      Map<String,Object> idName = recruitPositionService.getIdName();
      for(int i=0;i<file.size();i++){
        //获取当前的应用
        String filePath = basePath+"/resume/loadFile?fileKey="+file.get(i).getId();
        file.get(i).setFilePath(filePath);
        if(idName !=null && idName.size()>0){
          String uploader = file.get(i).getUploader();
          if(uploader !=null){
            Object name = idName.get(uploader);
            if(name !=null){
              file.get(i).setUploader(name.toString());
            }
          }
        }
      }
    }
    return file;
  }

  @Override
  public int addFileToDb(com.csot.recruit.model.resume.File file,HttpServletRequest request) {
    // TODO Auto-generated method stub
    int count = 0;
    if(file !=null){
      MultipartFile f = file.getFile();
      if(f != null){
        String fileNewName = file.getFileName();
        String fileOldName = f.getOriginalFilename();
        String type = fileOldName.substring(fileOldName.indexOf("."), fileOldName.length());
        String newName = fileNewName+type;
        String fileType = DatadictGroup.getTypeNameByTypeId(file.getFileType());
        file.setFileType(fileType);
        try {
         //读取配置文件的信息
          String filePath  = request.getServletContext().getRealPath("/resources/upload/standardDoc")+"/"+newName;
          File fi = new File(filePath);
          //写文件
          f.transferTo(fi);
          file.setId(UUID.randomUUID().toString().replace("-", ""));
          file.setFileName(file.getFileName()+type);
          LoginClient client = (LoginClient)request.getSession().getAttribute(LoginClient.CLIENT_SESSION_ATTR);
          if(client !=null){
            BaseUser baseUser = client.getUser();
            if(baseUser !=null){
              file.setUploader(baseUser.getId());
            }
          }
          file.setUploadTime(DataUtils.getDate());
          count = fileMapper.addFileToDb(file);
        } catch (IllegalStateException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }  
        
      }
   }
    return count;
  }

  @Override
  public String getFileNameById(String id) {
   
    return  fileMapper.getFileName(id);
  }

  @Override
  public String getLoadFile(HttpServletResponse response,HttpServletRequest request,String fileKey){
    //根据fileId获取文件的名
    String fileName = getFileNameById(fileKey);
    //获取文件的全路径
    if(fileName !=null && !"".equals(fileName)){
      String dataDirectory = request.getServletContext().getRealPath("/resources/upload/standardDoc");
      File file = new File(dataDirectory,fileName);
      load(file,response,fileName);
    }
    return null;
  }
  
  //下载文件
  private void load(File file,HttpServletResponse response,String fileName){
    if(file.exists()){
      try {
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso-8859-1"));
      } catch (UnsupportedEncodingException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
      response.setCharacterEncoding("utf-8");
      byte[] buffer = new byte[1024];
      FileInputStream fis = null;
      BufferedInputStream bis = null;
      try{
        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        OutputStream os = response.getOutputStream();
        int i = bis.read(buffer);
        while(i!=-1){
          os.write(buffer, 0, i);
          i=bis.read(buffer);
        }
        
      }catch(IOException ex){
        ex.printStackTrace();
      }finally{
        if(fis !=null ){
          try {
            fis.close();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        if(bis !=null){
          try {
            bis.close();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      }
    }
  }

  @Override
  public boolean deletFile(HttpServletResponse response, HttpServletRequest request, String fileKey) {
    boolean flag = false;
    //根据Id获取文件的名
    String fileName = getFileNameById(fileKey);
    if(fileName !=null && !"".equals(fileName)){
      //获取文件的真实路径
      String dataDirectory = request.getServletContext().getRealPath("/resources/upload/standardDoc");
      File file = new File(dataDirectory,fileName);
      //删除文件
      flag =  deleteStandardDoc(response,file);
      if(flag){
        deleteFileDb(fileKey);
      }
    }
    return flag;
  }
  
  //删除文件
  private boolean deleteStandardDoc(HttpServletResponse response,File file){
    if(file.isFile() && file.exists()){
      file.delete();
      return true;
    }
    return false;
  }
  
  //删除数据库中的file的记录
  private boolean deleteFileDb(String id){
    int count = fileMapper.deleteFileById(id);
    if(count >0){
      return true;
    }
    return false;
  }

  @Override
  public boolean validateFileName(String fileName) {
    boolean flag = false;
    int count = fileMapper.countRecordByFileName(fileName);
    if(count>0){
      flag = false;
    }else{
      flag = true;
    }
    return flag;
  }
  
}