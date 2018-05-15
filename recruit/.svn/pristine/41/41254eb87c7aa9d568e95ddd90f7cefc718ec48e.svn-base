package com.csot.recruit.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;

import microsoft.exchange.webservices.data.ConflictResolutionMode;
import microsoft.exchange.webservices.data.EmailMessage;
import microsoft.exchange.webservices.data.EmailMessageSchema;
import microsoft.exchange.webservices.data.ExchangeCredentials;
import microsoft.exchange.webservices.data.ExchangeService;
import microsoft.exchange.webservices.data.ExchangeVersion;
import microsoft.exchange.webservices.data.FileAttachment;
import microsoft.exchange.webservices.data.FindItemsResults;
import microsoft.exchange.webservices.data.Item;
import microsoft.exchange.webservices.data.ItemView;
import microsoft.exchange.webservices.data.LogicalOperator;
import microsoft.exchange.webservices.data.SearchFilter;
import microsoft.exchange.webservices.data.ServiceLocalException;
import microsoft.exchange.webservices.data.WebCredentials;
import microsoft.exchange.webservices.data.WellKnownFolderName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.csot.recruit.model.nresume.EmailFile;
import com.csot.recruit.model.nresume.EmailItem;

public class ReadMailViaEWS {

  private static final Logger logger = LoggerFactory.getLogger(ReadMailViaEWS.class);

  /**
   * Message对象将存储我们实际发送的电子邮件信息，
   * Message对象被作为一个MimeMessage对象来创建并且需要知道应当选择哪一个JavaMail session。
   */
  private MimeMessage message;

  /**
   * Session类代表JavaMail中的一个邮件会话。
   * 每一个基于JavaMail的应用程序至少有一个Session（可以有任意多的Session）。
   * 
   * JavaMail需要Properties来创建一个session对象。 寻找"mail.smtp.host" 属性值就是发送邮件的主机
   * 寻找"mail.smtp.auth" 身份验证，目前免费邮件服务器都需要这一项
   */
  private Session session;

  /***
   * 邮件是既可以被发送也可以被受到。JavaMail使用了两个不同的类来完成这两个功能：Transport 和 Store。 Transport
   * 是用来发送信息的，而Store用来收信。对于这的教程我们只需要用到Transport对象。
   */
  private Transport transport;

  private String mailHost = "";
  private String sender_username = "";
  private String sender_password = "";

  private Properties properties = new Properties();

  public ReadMailViaEWS() {}

  /*
   * 初始化方法
   */
  public ReadMailViaEWS(boolean debug) {
      try {
          InputStream in = ReadMailViaEWS.class.getClassLoader().getResourceAsStream("constant.properties");
          properties.load(in);
          this.mailHost = properties.getProperty("mail.smtp.host");
          this.sender_username = properties.getProperty("mail.sender.username");
          this.sender_password = properties.getProperty("mail.sender.password");
      } catch (IOException e) {
          e.printStackTrace();
      }

      session = Session.getInstance(properties);
      session.setDebug(debug);// 开启后有调试信息
      message = new MimeMessage(session);
  }
  
  /***
   * 读取邮件附件
   * @param userName 用户名
   * @param password 密码
   * @param url 接收邮件服务器
   * @return
   * @throws Exception
   */
  public List<EmailItem> readMail(String userName, String password, String server, String basePath) throws Exception {
	List<EmailItem> emails = new ArrayList<EmailItem>();
	String filePath = "";
	String atpath = "";
	PropertiesUtil propertiesUtil = new PropertiesUtil();
	ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010);
	ExchangeCredentials credentials = new WebCredentials(userName,password, propertiesUtil.readProperty("domain"));
	String url = "https://" + server + "/EWS/Exchange.asmx";
	service.setUrl(new URI(url));
	//String add = propertiesUtil.readProperty("mailAddress");
	//service.autodiscoverUrl(propertiesUtil.readProperty("mailAddress"));
	service.setCredentials(credentials);
	ItemView view = new ItemView(10); 
	SearchFilter searchFilter = new SearchFilter.SearchFilterCollection(LogicalOperator.And, new SearchFilter.IsEqualTo(EmailMessageSchema.IsRead, false)); // 未读邮件 
	FindItemsResults<Item> findResults; 
	String siteKey = propertiesUtil.readProperty("recruitSiteKey");
	String siteKeys[] = siteKey.split(",");
	do { 
	  findResults = service.findItems(WellKnownFolderName.Inbox, searchFilter, view); // 收件箱
	  for (Item item : findResults.getItems()) {
	    String subject = item.getSubject().replaceAll("\\s*", ""); // 去掉空格
	    logger.info("getLastModifiedName" + subject);
	    if(isRecruitSiteEmail(subject.toLowerCase(),siteKeys)) { // 判断邮件是否是招聘网站发送过来的简历
	      EmailItem emailItem = new EmailItem();
	      List<EmailFile> attachments = new ArrayList<EmailFile>();
	      EmailMessage message = EmailMessage.bind(service,item.getId());
	      if (subject.contains("/")) { // 替换邮件主题中审请职位的'/',防止生成文件时误认为路径分隔符
	        subject = subject.replaceAll("/", " or ");
	      }
	      filePath = "email/" + subject + "/";
	      atpath = basePath + File.separator + filePath;
	      File pathFile = new File(atpath);
	      if (!pathFile.isDirectory()) {
	        pathFile.mkdirs();
	      }
	      FileUtils.save(atpath + File.separator + "resume.html", message.getBody().toString(), true);
	      if (message.getHasAttachments()) {
	        String fileName = "";
	        String pre ="";
	        String type = "";
	        String fileUrl = "";
	        for (int i = 0; i < message.getAttachments().getCount(); i++) {
	          FileAttachment fa = (FileAttachment) message.getAttachments().getPropertyAtIndex(i);
	          String attachContent = "";
	          fileName = fa.getName();
	          fileUrl = atpath + File.separator + fileName;
	          if(new File(fileUrl).exists()) {
	            pre = fileName.substring(0, fileName.lastIndexOf("."));
	            type = fileName.substring(fileName.lastIndexOf(".") + 1,fileName.length());
	            fileName = pre+ "_" + new Date().getTime() + "." + type;
	            fileUrl = atpath + File.separator + fileName;
	          }
	          fa.load(fileUrl);
	          attachContent = FileUtils.toBase64String(new File(fileUrl));
	          attachments.add(new EmailFile(fileName,attachContent));
	        }
	      }
	      //attachments.add(new EmailFile("resume_" + new Date().getTime() + ".html",FileUtils.toBase64String(message.getBody().toString()))); // 将内容也加到附件中去
	      
	      //message.setIsRead(true);
	      //message.update(ConflictResolutionMode.AlwaysOverwrite); // 将对邮件的改动提交到服务器 
	      emailItem.setSaveDir(filePath);
	      emailItem.setBody(message.getBody().toString());
	      emailItem.setFrom(message.getFrom().getAddress());
	      emailItem.setSubject(subject);
	      emailItem.setAttachments(attachments);
	      emails.add(emailItem);
	    }
	  }
	  view.setOffset(view.getOffset() + 10);
	}while (findResults.isMoreAvailable()); 
	return emails;
  }
  
  /**
   * 判断邮件主题中是否有招聘网站的关键字，以此过滤邮件
   * @param subject
   * @param keys
   * @return
   */
  public boolean isRecruitSiteEmail(String subject, String[] keys) {
    if(StringUtil.isEmpty(subject)) {
      return false;
    }
    boolean flag = false;
    for(String key : keys) {
      if(subject.indexOf(key) > -1) {
        flag = true;
        break;
      }
    }
    return flag;
  }

	/**
	 * 发送邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param sendHtml
	 *            邮件内容
	 * @param receiveUser
	 *            收件人地址
	 * @param filePath
	 *            附件
	 * @param resumeName
	 *            简历名称
	 */
	public String doSendHtmlEmail(String subject, String sendHtml,
			String receiveUser, String filePath, String[] resumeName) {
		String[] receiveUsers = receiveUser.split(";");
		String[] filePaths = filePath.split(",");
		try {
			// 发件人
			InternetAddress from = new InternetAddress(sender_username);
			message.setFrom(from);

			// 收件人
			InternetAddress[] to = new InternetAddress[receiveUsers.length];
			for (int i = 0; i < receiveUsers.length; i++) {
				to[i] = new InternetAddress(receiveUsers[i]);
			}
			message.setRecipients(Message.RecipientType.TO, to);

			// 邮件主题
			message.setSubject(subject);

			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();

			// 添加邮件正文
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(sendHtml, "text/html;charset=UTF-8");
			multipart.addBodyPart(contentPart);
			File sourceFile = null;
			File targetFile = null;
			// 添加附件的内容
			if (filePaths != null) {
				BodyPart attachmentBodyPart;
				DataSource source;
				for (int i = 0; i < filePaths.length; i++) {
					attachmentBodyPart = new MimeBodyPart();
					sourceFile = new File(filePaths[i]);
					if(!sourceFile.isFile() || !sourceFile.exists()){
						return "文件不存在";
					}
					targetFile = new File(sourceFile.getParent()
							+ File.separator + resumeName[i] + "简历.html");
					this.copyFile(sourceFile, targetFile);
					source = new FileDataSource(targetFile);
					attachmentBodyPart.setDataHandler(new DataHandler(source));
					// MimeUtility.encodeWord可以避免文件名乱码
					attachmentBodyPart.setFileName(MimeUtility
							.encodeWord(source.getName()));
					multipart.addBodyPart(attachmentBodyPart);
				}

			}

			// 将multipart对象放到message中
			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();

			transport = session.getTransport("smtp");
			// smtp验证，就是你用来发邮件的邮箱用户名密码
			transport.connect(mailHost, 25, sender_username, sender_password);
			// 发送
			transport.sendMessage(message, message.getAllRecipients());
			//删除复制的文件
			deleteFile(targetFile);
			System.out.println("send success!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
		return "";
	}

	public void copyFile(File sourceFile, File targetFile) {
		BufferedInputStream inBuff = null;
		BufferedOutputStream outBuff = null;
		try {
			// 新建文件输入流并对它进行缓冲
			inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

			// 新建文件输出流并对它进行缓冲
			outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

			// 缓冲数组
			byte[] b = new byte[1024 * 5];
			int len;
			while ((len = inBuff.read(b)) != -1) {
				outBuff.write(b, 0, len);
			}
			// 刷新此缓冲的输出流
			outBuff.flush();
		} catch (Exception e) {
			logger.error("读取文件异常"+e);
		} finally {
			// 关闭流
			if (inBuff != null)
				try {
					inBuff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (outBuff != null)
				try {
					outBuff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void deleteFile(File targetFile){
		if (targetFile.exists()) {
			// 判断是否为文件
			if (targetFile.isFile()) { // 为文件时调用删除文件方法
				if (targetFile.exists()) {
					targetFile.delete();
				}
			} // 不存在返回 false
		}
	}

}