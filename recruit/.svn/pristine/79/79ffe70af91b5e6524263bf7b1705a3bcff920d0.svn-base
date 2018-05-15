package com.csot.recruit.service.resume;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csot.recruit.model.resume.File;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.ResumeTemplate;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface FileService {
    /**
     * 获得标准文档管理中的所有文件
     * @return
     */
    List<File> getAllFile(HttpServletRequest request);
    
    /**
     * 将文件信息添加到数据库
     */
    int addFileToDb(File file,HttpServletRequest request);
    
    /**
     * 根据id获取文件名称
     * @param id
     * @return
     */
    String  getFileNameById(String id);
    
    /**
     * 下载文件
     * @param response
     * @param request
     * @param fileKey
     */
    String getLoadFile(HttpServletResponse response,HttpServletRequest request,String fileKey);
    
    /**
     * 删除文件
     * @param response
     * @param request
     * @param fileKey
     * @return
     */
    boolean deletFile(HttpServletResponse response,HttpServletRequest request,String fileKey);
    
    /**
     * 验证是否存在该文件名
     * @param fileNames
     * @return
     */
    boolean validateFileName(String fileName);
    
}