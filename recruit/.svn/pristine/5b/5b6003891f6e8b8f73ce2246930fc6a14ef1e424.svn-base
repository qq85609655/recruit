package com.csot.recruit.service.impl.interview;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;

import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.model.original.interview.EmergentContacts;
import com.csot.recruit.model.original.interview.FamilyMember;
import com.csot.recruit.model.original.interview.Illustrate;
import com.csot.recruit.model.original.interview.InterviewInfo;
import com.csot.recruit.model.original.interview.Language;
import com.csot.recruit.model.original.interview.Recommend;
import com.csot.recruit.model.original.interview.Reward;
import com.csot.recruit.model.resume.Certification;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.service.interview.EmergentContactsService;
import com.csot.recruit.service.interview.FamilyMemberService;
import com.csot.recruit.service.interview.IllustrateService;
import com.csot.recruit.service.interview.InterviewInfoService;
import com.csot.recruit.service.interview.InterviewPrintService;
import com.csot.recruit.service.interview.LanguageService;
import com.csot.recruit.service.interview.RecommendService;
import com.csot.recruit.service.interview.RewardService;
import com.csot.recruit.service.resume.CertificationService;
import com.csot.recruit.service.resume.EducationExperienceService;
import com.csot.recruit.service.resume.WorkExperienceService;
import com.google.common.base.Throwables;

@Service("interviewPrintService")
public class InterviewPrintServiceImpl implements InterviewPrintService {
    private static final Logger logger = LoggerFactory.getLogger(InterviewPrintServiceImpl.class);

    @Resource
    private InterviewInfoService interviewInfoService;
    
    @Resource
    private FamilyMemberService familyMemberService;
    
    @Resource
    private EmergentContactsService emergentContactsService;
    
    @Resource
    private EducationExperienceService educationExperienceService;
    
    @Resource
    private CertificationService certificationService;
    
    @Resource
    private LanguageService languageService;
    
    @Resource
    private WorkExperienceService workExperienceService;
    
    @Resource
    private RewardService rewardService;
    
    @Resource
    private RecommendService recommendService;
    
    @Resource
    private IllustrateService illustrateService;
    
    @Resource
    private SpringPropertyResourceReader springPropertyResourceReader;
    
    @Override
    public String dualZipPrint(String templatePath, String personCodes){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
      StringBuilder zipFilePath = new StringBuilder(rootPath);
      zipFilePath.append(File.separator).append(CommonConstant.TEMP_ZIP_DIR);
      //zip目录
      File dir = new File(zipFilePath.toString());
      if(!dir.exists()){
        dir.mkdir();
      }
      //zip文件
      zipFilePath.append(File.separator).append(sdf.format(new Date())).append(".zip");
      File zipFile = new File(zipFilePath.toString());
      FileOutputStream fous = null;
      //zip输出流
      ZipOutputStream zipOut = null;
      try{
        if(!zipFile.exists()){
          zipFile.createNewFile();
        }
        fous = new FileOutputStream(zipFile);
        //zip输出流
        zipOut = new ZipOutputStream(fous);
        zipFiles(personCodes,templatePath,zipOut,rootPath);
      }catch(IOException e){
        logger.error(e.getMessage(), e);
        throw Throwables.propagate(e);
      }finally{
        //关闭出流
        try {
          if(null != zipOut){
            zipOut.flush();
            zipOut.close();
          }
          if(null != fous){
            fous.close();
          }
        } catch (IOException e) {
          logger.error(e.getMessage(), e);
          throw Throwables.propagate(e);
        }
      }
      return zipFilePath.toString();
    }
    
    
    /**
     * 循环，将附件添加到压缩包
     * @throws IOException 
     * */
    public void zipFiles(String personCodes,String templatePath,ZipOutputStream zipOut,String rootPath){
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      FileInputStream fis = null;  
      BufferedInputStream bis = null; 
      byte[] bufs = new byte[1024*10];
      
      String[] personCodeArray=personCodes.split(",");
      for(String personCode : personCodeArray){
        InterviewInfo basicInfo = interviewInfoService.getByPersonCode(personCode);
        Workbook wb = getResumeWorkbook(templatePath, personCode);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        
        try {
          wb.write(os);
          byte[] content = os.toByteArray();
          InputStream is = new ByteArrayInputStream(content);
          //创建ZIP实体，并添加进压缩包
          ZipEntry zipEntry = new ZipEntry(basicInfo.getCnname()+sdf.format(new Date())+".xlsx");
          zipOut.putNextEntry(zipEntry);
          //读取待压缩的文件并写进压缩包里  
          bis = new BufferedInputStream(is, 1024*10);
          int read = 0;
          while((read=bis.read(bufs, 0, 1024*10)) != -1){  
            zipOut.write(bufs,0,read);
          }
        } catch (IOException e) {
          logger.error(e.getMessage(), e);
          throw Throwables.propagate(e);
        }finally{
          try{
            if(null != bis){
              //关闭输入流
              bis.close();
            }
            if(null != fis){
              //关闭输入流
              fis.close();
            }
          }catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw Throwables.propagate(e);
          }
        }
      }
    }
    
    @Override
    public Workbook getResumeWorkbook(String templatePath, String personCode) {
      Workbook work =null;
      try {
        InputStream in = new FileInputStream(templatePath + "/interviewPrintTemple.xlsx");
        work = new XSSFWorkbook(in);
        // 得到excel的第0张表
        Sheet sheet = work.getSheetAt(0);
        XSSFFont font1 = (XSSFFont)work.createFont();  
        font1.setFontName("宋体");  
        font1.setFontHeightInPoints((short) 12);//设置字体大小 
        XSSFFont font2 = (XSSFFont) work.createFont();
        font2.setFontName("宋体");  
        font2.setFontHeightInPoints((short) 8);//设置字体大小 
        XSSFFont font3 = (XSSFFont) work.createFont();
        font3.setFontName("Arial");  
        font3.setFontHeightInPoints((short) 8);//设置字体大小 
        //基本信息
        dualBaseInfo (personCode, sheet,work,font1,font2,font3);
        // 得到行，家庭成员
        dualFam(personCode, sheet,font1,font2,font3);
        // 得到行，紧急联系人
        dualEgm(personCode, sheet);
        // 得到行，教育及培训
        dualEdu(personCode, sheet);
        //资格证书
        dualCer(personCode, sheet);
        // 语言与计算机
        dualLan(personCode, sheet,font1,font2,font3);
        // 得到行，工作经历
        dualWork(personCode, sheet,font1,font2,font3);
        // 奖励及特长
        dualRew(personCode, sheet);
        // 得到行，推荐人员
        dualRec(personCode, sheet);
        //声明
        dualIll(personCode, sheet);
        // sheet.addMergedRegion(new CellRangeAddress(41, 41, 0, 9));//合并备注栏
    } catch (FileNotFoundException e) {
        logger.error("excel导出失败：文件路径错误"+e.getCause());
    } catch (IOException e) {
        System.out.println("文件输入流错误");
        logger.error("excel导出失败：文件路径错误"+e.getMessage());

        e.printStackTrace();
    }
      return work;
    }
    
    
    
    private void dualBaseInfo (String personCode, Sheet sheet,Workbook work,XSSFFont font1,XSSFFont font2,XSSFFont font3){
      
      InterviewInfo basicInfo = interviewInfoService.getByPersonCode(personCode);
      
      Row row = sheet.getRow(6);//
      Cell cell = row.getCell(2);
      cell.setCellValue(basicInfo.getCnname());
      cell = row.getCell(11);
      cell.setCellValue(basicInfo.getNationalityName());//国籍
      cell = row.getCell(17);
      cell.setCellValue(basicInfo.getNamepy());
      cell = row.getCell(33);
      cell.setCellValue(basicInfo.getEnname());
      cell = row.getCell(40);
      cell.setCellValue(basicInfo.getSexName()); // 性别

      // 得到行，并填充数据和表格样式
      row = sheet.getRow(8);//
      cell = row.getCell(2);
      cell.setCellValue(basicInfo.getNativePlace());
      
      
      if("1".equals(basicInfo.getMaritalStatus())){
        cell = row.getCell(12);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 单身" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,4,font2);
        cell.setCellValue(richString); // 婚姻状况
      }else if("2".equals(basicInfo.getMaritalStatus())){
        cell = row.getCell(16);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 已婚" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,4,font2);
        cell.setCellValue(richString); // 婚姻状况
      }else if("3".equals(basicInfo.getMaritalStatus())){
        cell = row.getCell(20);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 再婚" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,4,font2);
        cell.setCellValue(richString); // 婚姻状况
      }
      
      cell = row.getCell(25);
      cell.setCellValue(basicInfo.getResidence());
      cell = row.getCell(33);
      cell.setCellValue(basicInfo.getResidencePropertyName());//户口性质
      cell = row.getCell(40);
      cell.setCellValue(basicInfo.getNationName());//民族
   // 得到行，并填充数据和表格样式
      row = sheet.getRow(10);//
      cell = row.getCell(2);
      cell.setCellValue(basicInfo.getPoliticalName());//政治面貌
      cell = row.getCell(11);
      cell.setCellValue(basicInfo.getCertificateTypeName());//证件类型
      cell = row.getCell(17);
      cell.setCellValue(basicInfo.getCertificateNum());
      String birthday=basicInfo.getBirthdate();
      if(birthday!=null&&!"".equals(birthday)){
        cell = row.getCell(34);
        cell.setCellValue(birthday.substring(0, 4));
        cell = row.getCell(38);
        cell.setCellValue(birthday.substring(5, 7));
        cell = row.getCell(41);
        cell.setCellValue(birthday.substring(8, 9));
      }
      
   // 得到行，并填充数据和表格样式
      row = sheet.getRow(12);//
      cell = row.getCell(2);
      cell.setCellValue(basicInfo.getHighestEducationName());//最高学历
      cell = row.getCell(11);
      cell.setCellValue(basicInfo.getPhonenumber());
      cell = row.getCell(25);
      cell.setCellValue(basicInfo.getEmail());
   // 得到行，并填充数据和表格样式
      row = sheet.getRow(14);//
      cell = row.getCell(2);
      cell.setCellValue(basicInfo.getAddress());
      cell = row.getCell(33);
      cell.setCellValue(basicInfo.getPostcodes());
      String startWorkDate=basicInfo.getStartworkingdate();
      if(startWorkDate!=null&&!"".equals(startWorkDate)){
        cell = row.getCell(41);
        cell.setCellValue(startWorkDate.substring(0, 4));
        cell = row.getCell(45);
        cell.setCellValue(startWorkDate.substring(5, 7));
        cell = row.getCell(48);
        cell.setCellValue(startWorkDate.substring(8, 9));
      }
    
   // 得到行，并填充数据和表格样式
      row = sheet.getRow(16);//
      cell = row.getCell(2);
      cell.setCellValue(basicInfo.getPositionName());
      cell = row.getCell(15);
      cell.setCellValue(basicInfo.getArriveDate());
      cell = row.getCell(27);
      cell.setCellValue(basicInfo.getExpectedSalaryMonth());  
      cell = row.getCell(36);
      cell.setCellValue(basicInfo.getExpectedSalaryYear());
      cell = row.getCell(44);
      cell.setCellValue(basicInfo.getExpectedSalaryOther());
   // 得到行，并填充数据和表格样式
      row = sheet.getRow(19);//
      cell = row.getCell(2);
      if("1".equals(basicInfo.getRecruitmentApproach())){//网络
        cell = row.getCell(3);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 网络" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,4,font2);
        cell.setCellValue(richString); // 招聘渠道
      }else if("2".equals(basicInfo.getRecruitmentApproach())){//内部推荐
        cell = row.getCell(7);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 内部推荐（推荐人姓名:"+basicInfo.getRefereeName()+")" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,richString.length(),font2);
        cell.setCellValue(richString); // 招聘渠道
      }else if("3".equals(basicInfo.getRecruitmentApproach())){//中介机构
        cell = row.getCell(25);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 中介机构" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,6,font2);
        cell.setCellValue(richString); // 招聘渠道
      }else if("4".equals(basicInfo.getRecruitmentApproach())){//其他
        cell = row.getCell(31);
        XSSFRichTextString richString = new XSSFRichTextString( "□ 其他（"+basicInfo.getOtherWay()+"）" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,4,font2);
        cell.setCellValue(richString); // 招聘渠道
      }

      if("1".equals(basicInfo.getRelativesFlag())){//有亲属
        cell = row.getCell(41);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 有" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,3,font2);
        cell.setCellValue(richString); 
        XSSFCellStyle cellStyle = (XSSFCellStyle)work.createCellStyle();
        cellStyle.setFont(font2);
        cell = row.getCell(48);//亲属姓名
        cell.setCellValue(basicInfo.getRelativesName());
        cell.setCellStyle(cellStyle);
        cell = row.getCell(54);//亲属关系
        cell.setCellValue(basicInfo.getRelativesShip());
        cell.setCellStyle(cellStyle);
      }else if("2".equals(basicInfo.getRelativesFlag())){//无亲属
        row = sheet.getRow(18);//
        cell = row.getCell(41);
        XSSFRichTextString richString = new XSSFRichTextString( "☑ 没有" );
        richString.applyFont(0,1,font1);
        richString.applyFont(1,2,font3);
        richString.applyFont(2,4,font2);
        cell.setCellValue(richString);  
      }
      
    }
    
    public void dualFam(String personCode, Sheet sheet,XSSFFont font1,XSSFFont font2,XSSFFont font3){
      //家庭成员
      List<FamilyMember> fs = familyMemberService.queryByPersonCode(personCode);
      for(int i=0;i<fs.size()&&i<=5;i++){
        FamilyMember member=fs.get(i);
        Row row = sheet.getRow(24+2*i);//
        Cell cell = row.getCell(2);
        cell.setCellValue(member.getMenberName());
        cell = row.getCell(11);
        cell.setCellValue(member.getRelationName());
        cell = row.getCell(16);
        cell.setCellValue(member.getGenderName()); 
        if(member.getMenberBirthday()!=null&&"".equals(member.getMenberBirthday())){
          cell = row.getCell(20);
          cell.setCellValue(member.getMenberBirthday().substring(0, 4));
        }
        
        cell = row.getCell(26);
        cell.setCellValue(member.getMenberAddress());
        if("1".equals(member.getEmergentFlag())){//是否紧急联系人
          cell = row.getCell(52);
          XSSFRichTextString richString = new XSSFRichTextString( "☑ 是" );
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,3,font2);
          cell.setCellValue(richString); // 招聘渠道
        }
      }
    }
    
    public void dualEgm(String personCode, Sheet sheet){
      List<EmergentContacts> egms = emergentContactsService.queryByPersonCode(personCode);
      for(int i=0;i<egms.size()&&i<=1;i++){
        EmergentContacts ec=egms.get(i);
        Row row = sheet.getRow(37+2*i);//
        Cell cell = row.getCell(2);
        cell.setCellValue(ec.getEmergentName());
        cell = row.getCell(11);
        cell.setCellValue(ec.getRelationName());
        cell = row.getCell(16);
        cell.setCellValue(ec.getEmergentPhone());  
        cell = row.getCell(33);
        cell.setCellValue(ec.getEmergentAddress());
      }
    }
    
    public void dualEdu(String personCode, Sheet sheet){
      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
      List<EducationExperience> edus = educationExperienceService.queryByResumeId(personCode);
      for(int i=0;i<edus.size();i++){
        EducationExperience edu=edus.get(i);
        Row row = sheet.getRow(45+2*i);//          
        if(edu.getEduStartDate()!=null&&!"".equals(edu.getEduStartDate())){
          String startDate=format.format(edu.getEduStartDate());
          String endDate=format.format(edu.getEduEndDate());
          Cell cell = row.getCell(2);
          String start=startDate.substring(0, 4)+"年"+startDate.substring(5, 7)+"月"+startDate.substring(8, 10)+"日";
          String end=endDate.substring(0, 4)+"年"+endDate.substring(5, 7)+"月"+endDate.substring(8, 10)+"日";
          cell.setCellValue(start+"~ "+end);
        }

        Cell cell = row.getCell(17);
        cell.setCellValue(edu.getSchoolName()); 
        cell = row.getCell(28);
        cell.setCellValue(edu.getMajor());  
        cell = row.getCell(38);
        cell.setCellValue(edu.getEducationName());
        cell = row.getCell(43);
        if("1".equals(edu.getEduType())){//全日制
          cell.setCellValue("☑全日制；                                   □其它(自考/函授/成教等)");
        }else{//其他
          cell.setCellValue("□全日制；                                   ☑其它(自考/函授/成教等)");
        }
        
        cell = row.getCell(51);
        if("1".equals(edu.getCertificate())){//毕业证
          cell.setCellValue("☑毕业证；                                    □学位证");
        }else if("2".equals(edu.getCertificate())){//学位证
          cell.setCellValue("□毕业证；                                    ☑学位证");
        }else if("1,2".equals(edu.getCertificate())){//毕业证、学位证
          cell.setCellValue("☑毕业证；                                    ☑学位证");
        }
      }
    }
    
    public void dualCer(String personCode, Sheet sheet){
      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
      List<Certification> certifications = certificationService.queryByResumeId(personCode);
      for(int i=0;i<certifications.size();i++){
        Certification cer=certifications.get(i);
        Row row = sheet.getRow(53+2*i);//
        Cell cell = row.getCell(2);
        cell.setCellValue(cer.getTypeName()); 
        cell = row.getCell(10);
        cell.setCellValue(cer.getName());  
        String receivingdate=format.format(cer.getReceivingdate());
        cell = row.getCell(22);
        cell.setCellValue(receivingdate.substring(0, 4));
        cell = row.getCell(26);
        cell.setCellValue(receivingdate.substring(5, 7));
        cell = row.getCell(29);
        cell.setCellValue(receivingdate.substring(8, 10));
        cell = row.getCell(33);
        cell.setCellValue(cer.getNum());
        cell = row.getCell(43);
        cell.setCellValue(cer.getAuthorityOrg());
      }
    }
    
    
    public void dualLan(String personCode, Sheet sheet,XSSFFont font1,XSSFFont font2,XSSFFont font3){
      //计算机与语言
      List<Language> lans = languageService.queryByPersonCode(personCode);
      Cell cell = null;
      if(lans.size()>0){
        Language lan=lans.get(0);
        Row row = sheet.getRow(61);//
        if(lan.getOfficeFlag()!=null&&"1".equals(lan.getOfficeFlag())){
          cell = row.getCell(3);
          XSSFRichTextString richString = new XSSFRichTextString("☑ Office");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getOfficeSkilledLevel())){//精通
            cell = row.getCell(10);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getOfficeSkilledLevel())){//了解
            cell = row.getCell(14);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getOfficeSkilledLevel())){//一般
            cell = row.getCell(18);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(22);
          cell.setCellValue(lan.getOfficeDiploma());
        }                
        if(lan.getEnglishFlag()!=null&&"1".equals(lan.getEnglishFlag())){
          cell = row.getCell(34);
          XSSFRichTextString richString = new XSSFRichTextString("☑ 英语");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getEnglishSkilledLevel())){//精通
            cell = row.getCell(39);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getEnglishSkilledLevel())){//了解
            cell = row.getCell(43);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getEnglishSkilledLevel())){//一般
            cell = row.getCell(47);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(51);
          cell.setCellValue(lan.getEnglishDiploma());
        }        
        
        row = sheet.getRow(62);//
        if(lan.getSapFlag()!=null&&"1".equals(lan.getSapFlag())){
          cell = row.getCell(3);
          XSSFRichTextString richString = new XSSFRichTextString("☑ SAP/ERP");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getSapSkilledLevel())){//精通
            cell = row.getCell(10);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getSapSkilledLevel())){//了解
            cell = row.getCell(14);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getSapSkilledLevel())){//一般
            cell = row.getCell(18);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(22);
          cell.setCellValue(lan.getSapDiploma());
        }                
        if(lan.getKoreanFlag()!=null&&"1".equals(lan.getKoreanFlag())){
          cell = row.getCell(34);
          XSSFRichTextString richString = new XSSFRichTextString("☑ 韩语");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getKoreanSkilledLevel())){//精通
            cell = row.getCell(39);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getKoreanSkilledLevel())){//了解
            cell = row.getCell(43);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getKoreanSkilledLevel())){//一般
            cell = row.getCell(47);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(51);
          cell.setCellValue(lan.getKoreanDiploma());
        }        
        
        row = sheet.getRow(63);//
        if(lan.getVbaFlag()!=null&&"1".equals(lan.getVbaFlag())){
          cell = row.getCell(3);
          XSSFRichTextString richString = new XSSFRichTextString("☑ VBA/SQL");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getVbaSkilledLevel())){//精通
            cell = row.getCell(10);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getVbaSkilledLevel())){//了解
            cell = row.getCell(14);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getVbaSkilledLevel())){//一般
            cell = row.getCell(18);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(22);
          cell.setCellValue(lan.getVbaDiploma());
        }                
        if(lan.getJapaneseFlag()!=null&&"1".equals(lan.getJapaneseFlag())){
          cell = row.getCell(34);
          XSSFRichTextString richString = new XSSFRichTextString("☑ 日语");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getJapaneseSkilledLevel())){//精通
            cell = row.getCell(39);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getJapaneseSkilledLevel())){//了解
            cell = row.getCell(43);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getJapaneseSkilledLevel())){//一般
            cell = row.getCell(47);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(51);
          cell.setCellValue(lan.getJapaneseDiploma());
        }        
        
        row = sheet.getRow(64);//
        if(lan.getOtheritFlag()!=null&&"1".equals(lan.getOtheritFlag())){
          cell = row.getCell(3);
          XSSFRichTextString richString = new XSSFRichTextString("☑ 3D Max/ Pro/E");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getOtheritSkilledLevel())){//精通
            cell = row.getCell(10);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getOtheritSkilledLevel())){//了解
            cell = row.getCell(14);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getOtheritSkilledLevel())){//一般
            cell = row.getCell(18);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(22);
          cell.setCellValue(lan.getOtheritDiploma());
        }                
        if(lan.getOtherFlag()!=null&&"1".equals(lan.getOtherFlag())){
          cell = row.getCell(34);
          XSSFRichTextString richString = new XSSFRichTextString("☑ 普通话");
          richString.applyFont(0,1,font1);
          richString.applyFont(1,2,font3);
          richString.applyFont(2,richString.length(),font2);
          cell.setCellValue(richString); // 招聘渠道       
          if("1".equals(lan.getOtherSkilledLevel())){//精通
            cell = row.getCell(39);
            cell.setCellValue("☑ 精通");
          }else if("2".equals(lan.getOtherSkilledLevel())){//了解
            cell = row.getCell(43);
            cell.setCellValue("☑ 了解");
          }else if("3".equals(lan.getOtherSkilledLevel())){//一般
            cell = row.getCell(47);
            cell.setCellValue("☑ 一般");
          }          
          cell = row.getCell(51);
          cell.setCellValue(lan.getOtherDiploma());
        }        
        
        row = sheet.getRow(65);//暂时注释，表缺字段
//        if(lan.getOtheritFlag()!=null&&"1".equals(lan.getOtheritFlag())){
//          cell = row.getCell(3);
//          XSSFRichTextString richString = new XSSFRichTextString("☑ 3D Max/ Pro/E");
//          richString.applyFont(0,1,font1);
//          richString.applyFont(1,2,font3);
//          richString.applyFont(2,richString.length(),font2);
//          cell.setCellValue(richString); // 招聘渠道       
//          if("1".equals(lan.getOtheritSkilledLevel())){//精通
//            cell = row.getCell(10);
//            cell.setCellValue("☑ 精通");
//          }else if("2".equals(lan.getOtheritSkilledLevel())){//了解
//            cell = row.getCell(14);
//            cell.setCellValue("☑ 了解");
//          }else if("3".equals(lan.getOtheritSkilledLevel())){//一般
//            cell = row.getCell(18);
//            cell.setCellValue("☑ 一般");
//          }          
//          cell = row.getCell(22);
//          cell.setCellValue(lan.getOtheritDiploma());
//        }                
//        if(lan.getOtherFlag()!=null&&"1".equals(lan.getOtherFlag())){
//          cell = row.getCell(34);
//          XSSFRichTextString richString = new XSSFRichTextString("☑ 普通话");
//          richString.applyFont(0,1,font1);
//          richString.applyFont(1,2,font3);
//          richString.applyFont(2,richString.length(),font2);
//          cell.setCellValue(richString); // 招聘渠道       
//          if("1".equals(lan.getOtherSkilledLevel())){//精通
//            cell = row.getCell(39);
//            cell.setCellValue("☑ 精通");
//          }else if("2".equals(lan.getOtherSkilledLevel())){//了解
//            cell = row.getCell(43);
//            cell.setCellValue("☑ 了解");
//          }else if("3".equals(lan.getOtherSkilledLevel())){//一般
//            cell = row.getCell(47);
//            cell.setCellValue("☑ 一般");
//          }          
//          cell = row.getCell(51);
//          cell.setCellValue(lan.getOtherDiploma());
//        }        
      }
    }
    
    
    public void dualWork(String personCode, Sheet sheet,XSSFFont font1,XSSFFont font2,XSSFFont font3){
      //工作经历
      List<WorkExperience> works = workExperienceService.queryByResumeId(personCode);
      SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
      Row row = null;
      Cell cell = null;
      for(int i=0;i<works.size()&&i<=2;i++){
        WorkExperience workExperience=works.get(i);
        int x=70;//起止时间行
        int y=74;//工作职责行
        if(i==1){
          x=81;
          y=87;
        }else if(i==2){
          x=96;
          y=100;
        }
        row = sheet.getRow(x);//
        if(workExperience.getJobStartDate()!=null&&!"".equals(workExperience.getJobStartDate())){
          String startDate=format.format(workExperience.getJobStartDate());
          String endDate=format.format(workExperience.getJobEndDate());
          cell = row.getCell(2);
          String start=startDate.substring(0, 4)+"年"+startDate.substring(5, 7)+"月"+startDate.substring(8, 10)+"日";
          String end=endDate.substring(0, 4)+"年"+endDate.substring(5, 7)+"月"+endDate.substring(8, 10)+"日";
          cell.setCellValue(start+"~ "+end);
        }
             
        cell = row.getCell(18);
        cell.setCellValue(workExperience.getCompanyName());
        cell = row.getCell(41);
        cell.setCellValue(workExperience.getSalary());  
        row = sheet.getRow(x+2);//
        cell = row.getCell(2);
        cell.setCellValue(workExperience.getDepartment());
        cell = row.getCell(18);
        cell.setCellValue(workExperience.getPositionName());
        cell = row.getCell(30);
        cell.setCellValue(workExperience.getDebriefer()); 
        cell = row.getCell(41);
        cell.setCellValue(workExperience.getSubordinate()==null?"":workExperience.getSubordinate().toString()); 
        cell = row.getCell(49);
        cell.setCellValue(workExperience.getSeniority());
        
        row = sheet.getRow(y);//
        cell = row.getCell(2);
        cell.setCellValue(workExperience.getJobDuty());
        row = sheet.getRow(y+5);//
        cell = row.getCell(2);
        cell.setCellValue(workExperience.getLeaveReason());
        cell = row.getCell(30);
        cell.setCellValue(workExperience.getReterence());
        cell = row.getCell(41);
        cell.setCellValue(workExperience.getRelationship()); 
        cell = row.getCell(49);
        cell.setCellValue(workExperience.getReterencePhone()); 
      }
    }
    
    
    public void dualRew(String personCode, Sheet sheet){
      Row row = null;
      Cell cell = null;
      //奖励及特长
      List<Reward> rews = rewardService.queryByPersonCode(personCode);
      if(rews.size()>0){
        Reward rew=rews.get(0);
        row = sheet.getRow(121);//
        cell = row.getCell(2);
        cell.setCellValue(rew.getRewardName1());
        if(rew.getRewardDate1()!=null){
          cell = row.getCell(30);      
          cell.setCellValue(rew.getRewardDate1().substring(0, 4));
          cell = row.getCell(34);      
          cell.setCellValue(rew.getRewardDate1().substring(5, 7));
          cell = row.getCell(37);      
          cell.setCellValue(rew.getRewardDate1().substring(8, 10));
        }
        
        cell = row.getCell(41);
        cell.setCellValue(rew.getAuthorities1());  
        row = sheet.getRow(123);//
        cell = row.getCell(2);
        cell.setCellValue(rew.getRewardName2());
        if(rew.getRewardDate2()!=null){
          cell = row.getCell(30);      
          cell.setCellValue(rew.getRewardDate2().substring(0, 4));
          cell = row.getCell(34);      
          cell.setCellValue(rew.getRewardDate2().substring(5, 7));
          cell = row.getCell(37);      
          cell.setCellValue(rew.getRewardDate2().substring(8, 10));
        }
        cell = row.getCell(41);
        cell.setCellValue(rew.getAuthorities2());
        row = sheet.getRow(125);//
        cell = row.getCell(2);
        cell.setCellValue(rew.getRewardName3());
        if(rew.getRewardDate3()!=null){
          cell = row.getCell(30);      
          cell.setCellValue(rew.getRewardDate3().substring(0, 4));
          cell = row.getCell(34);      
          cell.setCellValue(rew.getRewardDate3().substring(5, 7));
          cell = row.getCell(37);      
          cell.setCellValue(rew.getRewardDate3().substring(8, 10));
        }
        cell = row.getCell(41);
        cell.setCellValue(rew.getAuthorities3()); 
        row = sheet.getRow(127);//
        cell = row.getCell(2);
        cell.setCellValue(rew.getHobby());
        cell = row.getCell(30);
        cell.setCellValue(rew.getSpeciality());
      } 
      
    }
    
    public void dualRec(String personCode, Sheet sheet){
      Row row = null;
      Cell cell = null;
      //推荐人
      List<Recommend> recs = recommendService.queryByPersonCode(personCode);
      for(int i=0;i<recs.size();i++){
        Recommend rec=recs.get(i);
        row = sheet.getRow(133+2*i);//
        cell = row.getCell(2);
        cell.setCellValue(rec.getRecommended());
        cell = row.getCell(11);
        cell.setCellValue(rec.getRecommendRelation());
        cell = row.getCell(19);
        cell.setCellValue(rec.getRecommendPosition());  
        cell = row.getCell(29);
        cell.setCellValue(rec.getRecommendPhone());
        cell = row.getCell(40);
        cell.setCellValue(rec.getRecommendAddress());
      }
    }
    
    public void dualIll(String personCode, Sheet sheet){
      Row row = null;
      Cell cell = null;
      //声明
      Illustrate ill = illustrateService.queryByPersonCode(personCode);
      row = sheet.getRow(142);//
      if("1".equals(ill.getInfectionFlag())){
        cell = row.getCell(45);
        cell.setCellValue("☑ 没有；  □ 有；");
      }else if("2".equals(ill.getInfectionFlag())){
        cell = row.getCell(45);
        cell.setCellValue("□ 没有；  ☑ 有；");
        row = sheet.getRow(143);//
        cell = row.getCell(2);
        cell.setCellValue(ill.getInfectionText()==null?"":ill.getInfectionText());
      }
      
      row = sheet.getRow(144);//
      if("1".equals(ill.getCriminalFlag())){
        cell = row.getCell(45);
        cell.setCellValue("☑ 没有；  □ 有；");
      }else if("2".equals(ill.getCriminalFlag())){
        cell = row.getCell(45);
        cell.setCellValue("□ 没有；  ☑ 有；");
        row = sheet.getRow(145);//
        cell = row.getCell(2);
        cell.setCellValue(ill.getCriminalText()==null?"":ill.getCriminalText());
      }
      row = sheet.getRow(146);//
      if("1".equals(ill.getEmployFlag())){
        cell = row.getCell(45);
        cell.setCellValue("☑ 没有；  □ 有；");
      }else if("2".equals(ill.getEmployFlag())){
        cell = row.getCell(45);
        cell.setCellValue("□ 没有；  ☑ 有；");
        row = sheet.getRow(147);//
        cell = row.getCell(2);
        cell.setCellValue(ill.getEmployText()==null?"":ill.getEmployText());
      }
      row = sheet.getRow(148);//
      if("1".equals(ill.getInvestigateFlag())){
        cell = row.getCell(45);
        cell.setCellValue("☑ 愿意；  □ 不愿意；");
      }else if("2".equals(ill.getInvestigateFlag())){
        cell = row.getCell(45);
        cell.setCellValue("□ 没有；  ☑ 有；");
        row = sheet.getRow(149);//
        cell = row.getCell(2);
        cell.setCellValue(ill.getInvestigateText()==null?"":ill.getInvestigateText());
      }
      row = sheet.getRow(150);//
      if("1".equals(ill.getBanFlag())){
        cell = row.getCell(45);
        cell.setCellValue("☑ 没有；  □ 有；");
      }else if("2".equals(ill.getInvestigateFlag())){
        cell = row.getCell(45);
        cell.setCellValue("□ 没有；  ☑ 有；");
        row = sheet.getRow(152);//
        String startDate=ill.getBanStartdate();
        String endDate=ill.getBanEnddate();
        if(startDate!=null&&endDate!=null){
          cell=row.getCell(5);
          cell.setCellValue("签订期限："+startDate.substring(0, 4)+"年"+startDate.substring(5, 7)+"月 至"+endDate.substring(0, 4)+"年"+endDate.substring(5, 7)+"月；  且补偿金金额："+ill.getPayment()+"万元。");
        }
      }
    }
    
}