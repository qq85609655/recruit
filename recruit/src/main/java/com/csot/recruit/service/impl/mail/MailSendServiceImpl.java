package com.csot.recruit.service.impl.mail;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.constant.MailConstants;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.vo.MessageForm;
import com.csot.recruit.service.attachment.AttachmentService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.template.TemplateService;

import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;

@Service("mailSendService")
public class MailSendServiceImpl implements MailSendService {
  private static final Logger logger = LoggerFactory.getLogger(MailSendServiceImpl.class);

  @Resource
  private TemplateService templateService;
  @Resource
  private JavaMailSender mailSender;
  @Resource
  private SpringPropertyResourceReader springPropertyResourceReader;
  @Resource
  private AttachmentService attachmentService;
  /** 公共附件保存目录 */
  public static final String COMMON_ATTACH_PATH = "commonAttach";

  @Override
  public void test() {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("csot_gpms@tcl.com");
    message.setTo("luojunfeng01@tcl.com");
    message.setSubject("SRM mail test");
    message.setText("SRM mail test");
    mailSender.send(message);
  }

  /**
   * 发送带附件的html格式邮件.
   * 
   * @param mailTo 邮件地址，可能是多个，用";"分隔
   * @param templateId 邮件模板的id
   * @param object 包含当前模板内容中所有指定属性的对象，与模板内容中所有指定属性相匹配
   */
  @Override
  @Async
  public void sendEmail(String mailTo, Template template, Object object) {
    String sendSwitch = springPropertyResourceReader.getProperty("mail.send.switch");
    if (!StringUtils.hasText(sendSwitch)) {
      sendEmailOnSwitch(mailTo, template, object);
    } else if (StringUtils.hasText(sendSwitch) && "on".equals(sendSwitch)) {
      sendEmailOnSwitch(mailTo, template, object);
    }

  }
  
  /**
   * 发送带附件的html格式邮件.
   * 
   * @param mailTo 邮件地址，可能是多个，用";"分隔
   * @param templateId 邮件模板的id
   * @param object 包含当前模板内容中所有指定属性的对象，与模板内容中所有指定属性相匹配
   */
  @Override
  @Async
  public void sendCommonEmail(String mailTo, Template template, Object object,List<Attachment> attachments) {
    String sendSwitch = springPropertyResourceReader.getProperty("mail.send.switch");
    if (!StringUtils.hasText(sendSwitch)) {
      comonSendEmail(mailTo, template, object,attachments);
    } else if (StringUtils.hasText(sendSwitch) && "on".equals(sendSwitch)) {
      comonSendEmail(mailTo, template, object,attachments);
    }

  }

  private void sendEmailOnSwitch(String mailTo, Template template, Object object) {
    MimeMessage msg = mailSender.createMimeMessage();
    MimeMessageHelper helper;
    try {
      String[] allAddress = null;
      if (mailTo.contains(";")) {
        // 对输入的多个邮件进行分号分割
        allAddress = mailTo.split(";");
        List<String> sendAddressList = new ArrayList<String>();
        for (int i = 0; i < allAddress.length; i++) {
          if (StringUtils.hasText(allAddress[i])) {
            sendAddressList.add(allAddress[i]);
          }
        }
        allAddress = new String[sendAddressList.size()];
        for (int i = 0; i < sendAddressList.size(); i++) {
          allAddress[i] = sendAddressList.get(i);
        }
      } else {
        allAddress = new String[1];
        allAddress[0] = mailTo;
      }
      helper = new MimeMessageHelper(msg, true, MailConstants.ENCODING);
      helper.setFrom(MailConstants.SERVERMAILADDRESS);
      helper.setTo(allAddress);
      Map<String, String> mailMap = getMailTemp(template, object);
      if (!mailMap.isEmpty()) {
        // 发送的邮件模版中的主题
        helper.setSubject(mailMap.get(MailConstants.MAILSUBJECT));
        helper.setText(mailMap.get(MailConstants.MAILCONTENT), true); // true表示text的内容为html
        // 添加邮件附件,通过模板id获取其相应的附件，将附件set到附件中。
        List<Attachment> attachments = new ArrayList<Attachment>();
        attachments = attachmentService.findAttachsByRelateId(template.getId());
        if (null != attachments) {
          String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
          String filePath = "";
          for (int i = 0; i < attachments.size(); i++) {
            filePath =
                rootPath + File.separator + COMMON_ATTACH_PATH + File.separator
                    + attachments.get(i).getSaveName();
            File file = new File(filePath);
            helper.addAttachment(attachments.get(i).getShowName(), file);
          }
        }

        mailSender.send(msg);
        logger.info("mail send success:" + mailTo + " DATE:"
            + new SimpleDateFormat("YYYY-MM-dd HH:MM:SS").format(new Date()));
      }
    } catch (MessagingException e) {
      logger.error(e.getMessage(), e);
    }
  }
  
  /**
   * 
   * @param mailTo
   * @param template
   * @param object
   * @param attachments
   */
  private void comonSendEmail(String mailTo, Template template, Object object,List<Attachment> attachments) {
    MimeMessage msg = mailSender.createMimeMessage();
    MimeMessageHelper helper;
    try {
      String[] allAddress = null;
      if (mailTo.contains(";")) {
        // 对输入的多个邮件进行分号分割
        allAddress = mailTo.split(";");
        List<String> sendAddressList = new ArrayList<String>();
        for (int i = 0; i < allAddress.length; i++) {
          if (StringUtils.hasText(allAddress[i])) {
            sendAddressList.add(allAddress[i]);
          }
        }
        allAddress = new String[sendAddressList.size()];
        for (int i = 0; i < sendAddressList.size(); i++) {
          allAddress[i] = sendAddressList.get(i);
        }
      } else {
        allAddress = new String[1];
        allAddress[0] = mailTo;
      }
      helper = new MimeMessageHelper(msg, true, MailConstants.ENCODING);
      helper.setFrom(MailConstants.SERVERMAILADDRESS);
      helper.setTo(allAddress);
      Map<String, String> mailMap = getMailTemp(template, object);
      if (!mailMap.isEmpty()) {
        // 发送的邮件模版中的主题
        helper.setSubject(mailMap.get(MailConstants.MAILSUBJECT));
        helper.setText(mailMap.get(MailConstants.MAILCONTENT), true); // true表示text的内容为html
      
        if (null != attachments) {
          String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
          String filePath = "";
          for (int i = 0; i < attachments.size(); i++) {
            filePath =
                rootPath + File.separator + COMMON_ATTACH_PATH + File.separator
                    + attachments.get(i).getSaveName();
            File file = new File(filePath);
            helper.addAttachment(attachments.get(i).getShowName(), file);
          }
        }

        mailSender.send(msg);
        logger.info("mail send success:" + mailTo + " DATE:"
            + new SimpleDateFormat("YYYY-MM-dd HH:MM:SS").format(new Date()));
      }
    } catch (MessagingException e) {
      logger.error(e.getMessage(), e);
    }
  }

  /**
   * 通过模板构造邮件内容，参数content将替换模板文件中的${content}标签.
   * 
   * @throws IOException 获取模版异常
   * @throws TemplateException 模版freemaker异常
   */
  private Map<String, String> getMailTemp(Template template, Object object) {

    Map<String, String> subjectContent = new HashMap<String, String>();
    if (null != template) {
      String contents = template.getContext();
      String content = "";
      if (StringUtils.isEmpty(contents)) {
        throw new NullPointerException("mail templete null error");
      } else {
        content = contents;
        // try {
        // content = new String(contents,MailConstants.ENCODING);
        // } catch (UnsupportedEncodingException e) {
        // logger.error("unsupport transfer to UTF-8:" + e);
        // }
      }
      // 先构造一个模版 然后从模版维护模版中查询出来内容
      Configuration subjectCfg = new Configuration();
      Configuration contentCfg = new Configuration();
      StringTemplateLoader contenLoader = new StringTemplateLoader();
      StringTemplateLoader subjectLoader = new StringTemplateLoader();

      contenLoader.putTemplate(MailConstants.MAILTEMPLATE, content);
      subjectLoader.putTemplate(MailConstants.MAILTEMPLATE, template.getSubject());
      contentCfg.setTemplateLoader(contenLoader);
      subjectCfg.setTemplateLoader(subjectLoader);
      freemarker.template.Template contenTemp;
      freemarker.template.Template subjectTemp;
      try {
        contenTemp = contentCfg.getTemplate(MailConstants.MAILTEMPLATE, MailConstants.ENCODING);
        subjectTemp = subjectCfg.getTemplate(MailConstants.MAILTEMPLATE, MailConstants.ENCODING);
        subjectContent.put(MailConstants.MAILCONTENT, setObject(contenTemp, object));
        subjectContent.put(MailConstants.MAILSUBJECT, setObject(subjectTemp, object));
      } catch (IOException e) {
        logger.error(e.getMessage(), e);
      }

    }
    return subjectContent;
  }

  /**
   * 把对象的值赋值到模版中生成新的邮件内容.
   * 
   * @Description: setObject方法.
   * @return String
   */
  private static String setObject(freemarker.template.Template temp, Object object) {
    Map<String, Object> map = new HashMap<String, Object>();
    // 解析模板并替换动态数据，最终content将替换模板文件中的${content}标签。
    // 默认在模版的freemaker标签中都为bussiness
    map.put("bussiness", object); // 注意动态数据的key和模板标签中指定的属性相匹配
    String htmlText = "";
    try {
      htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(temp, map);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    } catch (TemplateException e) {
      logger.error(e.getMessage(), e);
    }
    return htmlText;
  }

  @Override
  public void sendResumeMessage(String mailTo, Template template, String bzjlurl,String jlywurl,MessageForm messageForm) {
    
    MimeMessage msg = mailSender.createMimeMessage();
    MimeMessageHelper helper;
    try {
      String[] allAddress = null;
      if (mailTo.contains(";")) {
        // 对输入的多个邮件进行分号分割
        allAddress = mailTo.split(";");
        List<String> sendAddressList = new ArrayList<String>();
        for (int i = 0; i < allAddress.length; i++) {
          if (StringUtils.hasText(allAddress[i])) {
            sendAddressList.add(allAddress[i]);
          }
        }
        allAddress = new String[sendAddressList.size()];
        for (int i = 0; i < sendAddressList.size(); i++) {
          allAddress[i] = sendAddressList.get(i);
        }
      } else {
        allAddress = new String[1];
        allAddress[0] = mailTo;
      }
      
      helper = new MimeMessageHelper(msg, true, MailConstants.ENCODING);
      helper.setFrom(MailConstants.SERVERMAILADDRESS);
      helper.setTo(allAddress);
      Map<String, String> mailMap = getMailTemp(template, null);
      if (!mailMap.isEmpty()) {
        // 发送的邮件模版中的主题
        helper.setSubject(mailMap.get(MailConstants.MAILSUBJECT));
        helper.setText(mailMap.get(MailConstants.MAILCONTENT), true); // true表示text的内容为html
      
        List<Attachment> attachments = null ;
        if(StringUtil.isNotEmpty(messageForm.getAttchmentIds())){
          String[] attachIds = messageForm.getAttchmentIds().split(",");
          Attachment attachment = null;
          if(attachIds.length > 0){
            attachments = new ArrayList<Attachment>();
            for(String attachId : attachIds){
              attachment = new Attachment();
              attachment = attachmentService.getByPrimaryKey(attachId);
              attachments.add(attachment);
            }
          }
        }
        if (attachments != null&&attachments.size()>0) {
          String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
          String filePath = "";
          for (int i = 0; i < attachments.size(); i++) {
            filePath =
                rootPath + File.separator + COMMON_ATTACH_PATH + File.separator
                    + attachments.get(i).getSaveName();
            File file = new File(filePath);
            helper.addAttachment(attachments.get(i).getShowName(), file);
          }
        }
        
        if(StringUtil.isNotEmpty(bzjlurl)){
          File file = new File(bzjlurl);
          helper.addAttachment("标准简历.doc", file);
        }
        
        if(StringUtil.isNotEmpty(jlywurl)){
          File f = new File(springPropertyResourceReader.getProperty("recruit.resume.path")+jlywurl+"resume.html");
          helper.addAttachment("简历原文.html", f);
        }
        
        mailSender.send(msg);
        logger.info("mail send success:" + mailTo + " DATE:"
            + new SimpleDateFormat("YYYY-MM-dd HH:MM:SS").format(new Date()));
      }
    } catch (MessagingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
   
    
  }

}
