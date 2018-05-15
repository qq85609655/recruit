package com.csot.recruit.common.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PropertiesUtil {
  
  private static final Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
  
	private static String properiesName = "constant.properties";

	public PropertiesUtil() {}
	
	public PropertiesUtil(String fileName) {
	  properiesName = fileName;
	}
	
	public String readProperty(String key) {
		String value = "";
		InputStreamReader is = null;
		try {
//			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(
//					properiesName);
			is = new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(properiesName), "UTF-8");
			Properties p = new Properties();
			p.load(is);
			value = p.getProperty(key);
		} catch (IOException e) {
		  logger.error(e.getMessage(), e);
		} finally {
			try {
			  if(is!=null){
			    is.close();
			  }
			} catch (IOException e) {
			  logger.error(e.getMessage(), e);
			}
		}
		return value;
	}

	public Properties getProperties() {
		Properties p = new Properties();
		InputStream is = null;
		try {
			is = PropertiesUtil.class.getClassLoader().getResourceAsStream(properiesName);
			p.load(is);
		} catch (IOException e) {
		  logger.error(e.getMessage(), e);
		} finally {
			try {
			  if(is !=null){
			    is.close();
			  }
			} catch (IOException e) {
			  logger.error(e.getMessage(), e);
			}
		}
		return p;
	}

	public static boolean writeProperty(String key, String value) {
		InputStream is = null;
		OutputStream os = null;
		SafeProperties p = new SafeProperties();// 不用Properties,这个类会把注释和顺序都保留
		try {
			is = new FileInputStream(PropertiesUtil.class.getClassLoader().getResource(properiesName).getFile());
			p.load(is);
			os = new FileOutputStream(PropertiesUtil.class.getClassLoader().getResource(properiesName).getFile());
			p.setProperty(key, value);
			p.store(os, null);
			os.flush();
			os.close();
			return true;
		} catch (Exception e) {
		    logger.error(e.getMessage(), e);
		    return false;
		} finally {
			try {
				if (null != is)
					is.close();
				if (null != os)
					os.close();
			} catch (IOException e) {
			  logger.error(e.getMessage(), e);
			  return false;
			}
		}
	}
}
