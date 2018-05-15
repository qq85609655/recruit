package com.csot.recruit.service.mail;

import java.util.List;

import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.model.vo.MessageForm;

public interface MailSendService {
  
  void test();
  
  void sendEmail(String mailTo, Template template,Object object);

  void sendCommonEmail(String mailTo, Template template, Object object, List<Attachment> attachments);

  void sendResumeMessage(String email, Template template, String bzjlurl,String jlywurl,MessageForm messageForm);
}