package com.csot.recruit.common.util;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.csot.recruit.controller.org.OrganazationController;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 *
 */
public class SendMailUtil {
	private static final Logger logger = LoggerFactory
			.getLogger(OrganazationController.class);
	// private static final String smtphost = "192.168.1.70";
	private static final String from = "csot.hr@tcl.com";
	private static final String fromName = "测试公司";
	private static final String charSet = "utf-8";
	private static final String username = "csot.hr";
	private static final String password = "csot.123";
	private static Map<String, String> hostMap = new HashMap<String, String>();
	
	private static FreeMarkerConfigurer freeMarker=null;
	 
	public static FreeMarkerConfigurer getFreeMarker() {
		return freeMarker;
	}

	public static void setFreeMarker(FreeMarkerConfigurer freeMarker) {
		SendMailUtil.freeMarker = freeMarker;
	}


	static {
		// 126
		hostMap.put("smtp.126", "smtp.126.com");
		// qq
		hostMap.put("smtp.qq", "smtp.qq.com");

		// 163
		hostMap.put("smtp.163", "smtp.163.com");

		// sina
		hostMap.put("smtp.sina", "smtp.sina.com.cn");

		// tom
		hostMap.put("smtp.tom", "smtp.tom.com");

		// 263
		hostMap.put("smtp.263", "smtp.263.net");

		// yahoo
		hostMap.put("smtp.yahoo", "smtp.mail.yahoo.com");

		// hotmail
		hostMap.put("smtp.hotmail", "smtp.live.com");

		// gmail
		hostMap.put("smtp.gmail", "smtp.gmail.com");
		hostMap.put("smtp.port.gmail", "465");
	}

	public static String getHost(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return hostMap.get(key);
		} else {
			throw new Exception("unSupportEmail");
		}
	}

	public static int getSmtpPort(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp.port." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return Integer.parseInt(hostMap.get(key));
		} else {
			return 25;
		}
	}

	/**
	 * 发送模板邮件
	 * 
	 * @param toMailAddr
	 *            收信人地址
	 * @param subject
	 *            email主题
	 * @param templatePath
	 *            模板地址
	 * @param map
	 *            模板map
	 *@param message
	 *            发送email信息
	 * @param filePath
	 *            文件地址
	 * @param resumeName
	 *            发送的简历名称   
	 * @param 用户名称
	 */
	public static String sendFtlMail(String toMailAddr, String subject,
			String templatePath, Map<String, Object> map,String message,
			String filePath, String[] resumeName, String name) {
		Template template = null;
//		Configuration freeMarkerConfig = null;
		PropertiesUtil propertiesUtil = new PropertiesUtil(
				"constant.properties");
		HtmlEmail hemail = new HtmlEmail();
		String[] filePaths = filePath.split(",");
		String [] toMailAddrs = toMailAddr.split(";");
		try {
			hemail.setHostName(propertiesUtil.readProperty("server"));
			hemail.setSmtpPort(getSmtpPort(propertiesUtil.readProperty("from")));
			hemail.setCharset(propertiesUtil.readProperty("charSet"));
			for (int i = 0; i < toMailAddrs.length; i++) {
				hemail.addTo(toMailAddrs[i]);
			}
			/*hemail.setFrom(email, propertiesUtil.readProperty("fromName"));
			String username = email.substring(0, email.lastIndexOf("@"));
			hemail.setAuthentication(username, password);*/
			String mailFrom = propertiesUtil.readProperty("mailFrom");
			String mailFromPwd = propertiesUtil.readProperty("mailFromPwd");
			hemail.setFrom(mailFrom, name);
			String username = mailFrom.substring(0, mailFrom.lastIndexOf("@"));
			hemail.setAuthentication(username, mailFromPwd);
			hemail.setSubject(subject);
			EmailAttachment attachment = new EmailAttachment();
			File file = null;
			for (int i = 0; i < filePaths.length; i++) {
				file = new File(filePaths[i]);
				if(file.isFile() && file.exists()){
					attachment.setPath(filePaths[i]);
					attachment.setDisposition(EmailAttachment.ATTACHMENT);
					attachment.setName(MimeUtility.encodeText(resumeName[i]+"简历.html"));
					hemail.attach(attachment);
				}
			}
//			获取模板
			template =
					freeMarker.getConfiguration().getTemplate(templatePath+".ftl",new
			Locale("Zh_cn"), "UTF-8");
//			模板内容转换为string
			String htmlText =
			 FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
			logger.info(htmlText);
//			hemail.setMsg(message);
			hemail.setHtmlMsg(htmlText);
			hemail.send();
			logger.info("email send success!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("email send error!");
			return "email send error!"+e;
		}
		return "";
	}

	/**
	 * 发送普通邮件
	 * 
	 * @param toMailAddr
	 *            收信人地址
	 * @param subject
	 *            email主题
	 * @param message
	 *            发送email信息
	 * @param filePath
	 *            文件地址
	 * @param resumeName
	 *            发送的简历名称           
	 */
	public static String sendCommonMail(String toMailAddr, String subject,
			String message, String filePath, String[] resumeName) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(
				"constant.properties");
		String[] filePaths = filePath.split(",");
		String [] toMailAddrs = toMailAddr.split(";");
		try {
            File file = null;
            EmailAttachment attachment = new EmailAttachment();
			for (int i = 0; i < filePaths.length; i++) {
				file = new File(filePaths[i]);
				if(!file.isFile() || !file.exists()){
					return "文件不存在";
				}
				attachment.setPath(filePaths[i]);
//				attachment.setURL(new URL("file:///"+filePaths[i]));  
	            attachment.setDisposition(EmailAttachment.ATTACHMENT);  
	            attachment.setDescription("Apache logo");  
	            attachment.setName(MimeUtility.encodeText(resumeName[i]+"简历.html"));
			}
            //Create the mail message  
            HtmlEmail htmlEmail = new HtmlEmail();  
            htmlEmail.setHostName(propertiesUtil.readProperty("server"));
            htmlEmail.setSmtpPort(getSmtpPort(propertiesUtil.readProperty("from")));
			htmlEmail.setCharset(propertiesUtil.readProperty("charSet"));
			for (int i = 0; i < toMailAddrs.length; i++) {
				htmlEmail.addTo(toMailAddrs[i]);
			}
			htmlEmail.setFrom(propertiesUtil.readProperty("from"), propertiesUtil.readProperty("fromName"));
			htmlEmail.setAuthentication(propertiesUtil.readProperty("username"), propertiesUtil.readProperty("password"));
			htmlEmail.setSubject(subject);
            htmlEmail.setMsg(message);   
            htmlEmail.attach(attachment);//附件 
            htmlEmail.send();//发送邮件  
			logger.info("email send success!");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("email send error!");
			return "email send error!"+e;
		}
		return "";
	}

	public static String getHtmlText(String templatePath,
			Map<String, Object> map) {
		Template template = null;
		String htmlText = "";
		try {
			Configuration freeMarkerConfig = null;
			freeMarkerConfig = new Configuration();
			freeMarkerConfig.setDirectoryForTemplateLoading(new File(
					getFilePath()));
			// 获取模板
			template = freeMarkerConfig.getTemplate(getFileName(templatePath),
					new Locale("Zh_cn"), "UTF-8");
			// 模板内容转换为string
			htmlText = FreeMarkerTemplateUtils.processTemplateIntoString(
					template, map);
			logger.info(htmlText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return htmlText;
	}

	private static String getFilePath() {
		String path = getAppPath(SendMailUtil.class);
		path = path + File.separator + "mailtemplate" + File.separator;
		path = path.replace("\\", "/");
		logger.info(path);
		return path;
	}

	private static String getFileName(String path) {
		path = path.replace("\\", "/");
		logger.info(path);
		return path.substring(path.lastIndexOf("/") + 1);
	}

	@SuppressWarnings("unchecked")
	public static String getAppPath(Class cls) {
		// 检查用户传入的参数是否为空
		if (cls == null)
			throw new java.lang.IllegalArgumentException("参数不能为空！");
		ClassLoader loader = cls.getClassLoader();
		// 获得类的全名，包括包名
		String clsName = cls.getName() + ".class";
		// 获得传入参数所在的包
		Package pack = cls.getPackage();
		String path = "";
		// 如果不是匿名包，将包名转化为路径
		if (pack != null) {
			String packName = pack.getName();
			// 此处简单判定是否是Java基础类库，防止用户传入JDK内置的类库
			if (packName.startsWith("java.") || packName.startsWith("javax."))
				throw new java.lang.IllegalArgumentException("不要传送系统类！");
			// 在类的名称中，去掉包名的部分，获得类的文件名
			clsName = clsName.substring(packName.length() + 1);
			// 判定包名是否是简单包名，如果是，则直接将包名转换为路径，
			if (packName.indexOf(".") < 0)
				path = packName + "/";
			else {// 否则按照包名的组成部分，将包名转换为路径
				int start = 0, end = 0;
				end = packName.indexOf(".");
				while (end != -1) {
					path = path + packName.substring(start, end) + "/";
					start = end + 1;
					end = packName.indexOf(".", start);
				}
				path = path + packName.substring(start) + "/";
			}
		}
		// 调用ClassLoader的getResource方法，传入包含路径信息的类文件名
		java.net.URL url = loader.getResource(path + clsName);
		// 从URL对象中获取路径信息
		String realPath = url.getPath();
		// 去掉路径信息中的协议名"file:"
		int pos = realPath.indexOf("file:");
		if (pos > -1)
			realPath = realPath.substring(pos + 5);
		// 去掉路径信息最后包含类文件信息的部分，得到类所在的路径
		pos = realPath.indexOf(path + clsName);
		realPath = realPath.substring(0, pos - 1);
		// 如果类文件被打包到JAR等文件中时，去掉对应的JAR等打包文件名
		if (realPath.endsWith("!"))
			realPath = realPath.substring(0, realPath.lastIndexOf("/"));
		/*------------------------------------------------------------ 
		 ClassLoader的getResource方法使用了utf-8对路径信息进行了编码，当路径 
		  中存在中文和空格时，他会对这些字符进行转换，这样，得到的往往不是我们想要 
		  的真实路径，在此，调用了URLDecoder的decode方法进行解码，以便得到原始的 
		  中文及空格路径 
		-------------------------------------------------------------*/
		try {
			realPath = java.net.URLDecoder.decode(realPath, "utf-8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		logger.info("realPath----->" + realPath);
		return realPath;
	}

	// private static File getFile(String path){
	// File file =
	// SendMail.class.getClassLoader().getResource("mailtemplate/test.ftl").getFile();
	// return file;
	// }
	//

	/*public static void main(String[] args) {
		// HtmlEmail hemail = new HtmlEmail();
		// try {
		// hemail.setHostName("smtp.exmail.qq.com");
		// hemail.setCharset("utf-8");
		// hemail.addTo("fly.1206@qq.com");
		// hemail.setFrom("zhoujunfeng@et-bank.com", "周俊峰");
		// hemail.setAuthentication("zhoujunfeng@et-bank.com", "31415926@aa");
		// hemail.setSubject("sendemail test!");
		// hemail.setMsg("<a href=\"http://www.google.cn\">谷歌</a><br/>");
		// hemail.send();
		// org.jeecgframework.core.util.LogUtil.info("email send true!");
		// } catch (Exception e) {
		// e.printStackTrace();
		// org.jeecgframework.core.util.LogUtil.info("email send error!");
		// }
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("subject", "测试标题");
		map.put("content", "测试 内容");
		String templatePath = "C:/workspace/recruit/src/main/webapp/resources/ftl/template.ftl";
		// sendFtlMail("zengrong@hosion.net", "sendemail test!",templatePath,
		// map);
		String filePath = "D:/attachment/email/(51job.com)申请贵公司PM高级工程师（深圳）－雷仕平/resume.html";
		String resumeName [] = {"雷仕平"};
		sendFtlMail("zengrong@hosion.net", "sendemail test!",templatePath,
				 map, "123456", filePath, resumeName);
//		sendFtlMail("zengrong@hosion.net;honglu@tcl.com", "sendemail test!", templatePath, map, "123456", filePath, resumeName);
//		sendCommonMail("zengrong@hosion.net;honglu@tcl.com", "sendemail test!", "123456",filePath, resumeName);

		// org.jeecgframework.core.util.LogUtil.info(getFileName("mailtemplate/test.ftl"));
	}*/
	

}