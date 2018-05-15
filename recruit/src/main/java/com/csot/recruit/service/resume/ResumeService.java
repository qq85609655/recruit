package com.csot.recruit.service.resume;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csot.recruit.common.exception.BusinessException;
import com.csot.recruit.model.nresume.EmailResume;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.ResumeTemplate;
import com.csot.recruit.model.vo.ResumeApartVo;
import com.csot.recruit.model.vo.ResumeVo;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface ResumeService {
    MiniRtn2Grid<Resume> getGrid(MiniGridPageSort pageSort, String searchKey);

    Resume getByPrimaryKey(String primaryKey, HttpServletRequest request);

    void create(Resume resume);

    void updateSelective(Resume resume);

    void remove(String primaryKey);
    
    /**
     * 创建简历
     * @param resume 简历解析后的对象
     * @param fileDir 简历存放目录
     * @return
     */
    String createResume(com.csot.recruit.model.nresume.Resume resume, String fileDir);
    
    /**
     * 创建简历
     * @param resumeEmail 邮件解析后的简历对象
     * @param fileDir
     * @return
     */
    String createResume(EmailResume resumeEmail, String fileDir);
    
    /***
     * excel导入
     * @param resumeTemplate 导入对象
     * @throws Exception
     */
    String createResumeByExcel(ResumeTemplate resumeTemplate) throws Exception;
    
    /***
     * 根据职位名称查询职位是否存在
     * @param positionName 职位名称
     * @return
     */
    String queryPositionByName(String positionName);

    /**
     * 删除标签
     * @param resumeId
     * @param resumeTags
     * @param tagId
     */
    void deleTag(String resumeId, String resumeTags, String tagId);

    /**
     * 更新标签
     * @param resumeId
     * @param labels
     * @param deletes
     * @param adds
     */
    void updateTags(String resumeId, String labels, String deletes, String adds);
    
    /***
     * 根据简历id修改简历状态
     * @param resume
     * @return
     */
    int updateResumeById(Resume resume)throws Exception;
    
    /***
     * 根据导入的路径创建简历
     * @param resumeDirList 简历存放目录
     */
    void createResume(List<String> resumeDirList);
    
    /***
     * 发送简历到邮箱
     * @param resumeNames 简历姓名
     * @param resumeIds 简历id
     * @param txtSrEmail 邮箱地址
     * @param sendResumeTemp 邮件模板名称
     * @param postscript 邮件附言
     * @param name 用户名称
     * @param projectUrl 项目根目录
     */
    String transmitResume(String resumeNames, String resumeIds, String txtSrEmail,
    		String sendResumeTemp, String postscript, String name, String projectUrl) throws Exception;

    /**
     * 删除简历附件
     * @param fileName
     * @return
     */
    String deleAttachment(String resumeId, String fileName, String basePath);
    
    /**
     * 加为候选人
     * @param resumeIds 简历ids
     * @param channel 渠道
     * @return
     */
    String addToCandidate(String resumeIds, String channel,String positionId);

    /**
     * 添加简历评论
     * @param resumeId 简历id
     * @param content 内容
     * @return
     */
    String addResumeComment(String resumeId, String content, Integer privacy);
    
    /**
     * 下载简历
     * @param resumePath 简历的外部访问路径
     * @param resumeName 需要返回的简历文件名
     * @param res
     * @param req
     * @throws IOException
     */
    void downloadResume(String resumePath, String resumeName, HttpServletResponse res, HttpServletRequest req) throws IOException;  
    
    /**
     * 通过邮箱解析简历
     * @param userName
     * @param password
     * @param server
     * @param request
     */
    int parseResumeByEmail(String userName, String password, String server) throws BusinessException;

    List<ResumeApartVo> selectResumeListByCandidateId(String candidateId);
    
    ResumeVo getResumeVo(String resumeId);

    Resume getZhResume(String id, HttpServletRequest request);

    Resume getByPrimaryKey(String primaryKey);

    String outputStandardResume(String resumeId);
    
    
}