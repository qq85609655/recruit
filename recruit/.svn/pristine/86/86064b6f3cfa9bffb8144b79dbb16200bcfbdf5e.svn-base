package com.csot.recruit.common.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

/**
 * 文件操作工具类
 * 
 *
 */
public class FileUtils {
	private static final Logger logger = Logger.getLogger(FileUtils.class);
	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename) {
		return getExtend(filename, "");
	}

	/**
	 * 获取文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtend(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > 0) && (i < (filename.length() - 1))) {
				return (filename.substring(i+1)).toLowerCase();
			}
		}
		return defExt.toLowerCase();
	}

	/**
	 * 获取文件名称[不含后缀名]
	 * 
	 * @param
	 * @return String
	 */
	public static String getFilePrefix(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex).replaceAll("\\s*", "");
	}
	
	/**
	 * 获取文件名称[不含后缀名]
	 * 不去掉文件目录的空格
	 * @param
	 * @return String
	 */
	public static String getFilePrefix2(String fileName) {
		int splitIndex = fileName.lastIndexOf(".");
		return fileName.substring(0, splitIndex);
	}
	
	/**
	 * 文件复制
	 *方法摘要：这里一句话描述方法的用途
	 *@param
	 *@return void
	 */
	public static void copyFile(String inputFile,String outputFile) throws FileNotFoundException{
		File sFile = new File(inputFile);
		File tFile = new File(outputFile);
		FileInputStream fis = new FileInputStream(sFile);
		FileOutputStream fos = new FileOutputStream(tFile);
		int temp = 0;  
		byte[] buf = new byte[10240];
        try {  
        	while((temp = fis.read(buf))!=-1){   
        		fos.write(buf, 0, temp);   
            }   
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally{
            try {
            	fis.close();
            	fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        } 
	}
	/**
	 * 判断文件是否为图片<br>
	 * <br>
	 * 
	 * @param filename
	 *            文件名<br>
	 *            判断具体文件类型<br>
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isPicture(String filename) {
		// 文件名称为空的场合
		if (OConvertUtils.isEmpty(filename)) {
			// 返回不和合法
			return false;
		}
		// 获得文件后缀名
		//String tmpName = getExtend(filename);
		String tmpName = filename;
		// 声明图片后缀名数组
		String imgeArray[][] = { { "bmp", "0" }, { "dib", "1" },
				{ "gif", "2" }, { "jfif", "3" }, { "jpe", "4" },
				{ "jpeg", "5" }, { "jpg", "6" }, { "png", "7" },
				{ "tif", "8" }, { "tiff", "9" }, { "ico", "10" } };
		// 遍历名称数组
		for (int i = 0; i < imgeArray.length; i++) {
			// 判断单个类型文件的场合
			if (imgeArray[i][0].equals(tmpName.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断文件是否为DWG<br>
	 * <br>
	 * 
	 * @param filename
	 *            文件名<br>
	 *            判断具体文件类型<br>
	 * @return 检查后的结果<br>
	 * @throws Exception
	 */
	public static boolean isDwg(String filename) {
		// 文件名称为空的场合
		if (OConvertUtils.isEmpty(filename)) {
			// 返回不和合法
			return false;
		}
		// 获得文件后缀名
		String tmpName = getExtend(filename);
		// 声明图片后缀名数组
		if (tmpName.equals("dwg")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 删除指定的文件
	 * 
	 * @param strFileName
	 *            指定绝对路径的文件名
	 * @return 如果删除成功true否则false
	 */
	public static boolean delete(String strFileName) {
		File fileDelete = new File(strFileName);

		if (!fileDelete.exists() || !fileDelete.isFile()) {
		  logger.info("错误: " + strFileName + "不存在!");
			return false;
		}

		logger.info("--------成功删除文件---------"+strFileName);
		return fileDelete.delete();
	}
	
    /**
     * 转换文件大小
     * @param fileS
     * @return
     */
    public static String FormetFileSize(long fileS) {
      DecimalFormat df = new DecimalFormat("#.00");
      String fileSizeString = "";
      if (fileS < 1024) {
          fileSizeString = df.format((double) fileS) + "B";
      } else if (fileS < 1048576) {
          fileSizeString = df.format((double) fileS / 1024) + "K";
      } else if (fileS < 1073741824) {
          fileSizeString = df.format((double) fileS / 1048576) + "M";
      } else {
          fileSizeString = df.format((double) fileS / 1073741824) +"G";
      }
      return fileSizeString;
    }
    
    /** 
     * the traditional io way 
     *  
     * @param filename 
     * @return 
     * @throws IOException 
     */  
    public static byte[] toByteArray(File f) throws IOException {  
      if (!f.exists()) {  
        throw new FileNotFoundException();  
      }  
      ByteArrayOutputStream bos = new ByteArrayOutputStream((int) f.length());  
      BufferedInputStream in = null;  
      try {  
        in = new BufferedInputStream(new FileInputStream(f));  
        int buf_size = 1024;  
        byte[] buffer = new byte[buf_size];  
        int len = 0;  
        while (-1 != (len = in.read(buffer, 0, buf_size))) {  
          bos.write(buffer, 0, len);  
        }  
        return bos.toByteArray();  
      } catch (IOException e) {  
        logger.info(e.getMessage());
        throw e;  
      } finally {  
        try {  
          if (null != in) {
            in.close();  
          }
        } catch (IOException e) {  
          logger.info(e.getMessage());  
        }  
        bos.close();  
      }  
    }  

    public static String toBase64String(File f) throws IOException { 
      byte[] buffer = toByteArray(f);
      return Base64.encodeBase64String(buffer);
    }
    
    public static String toBase64String(byte[] content) throws IOException { 
      return Base64.encodeBase64String(content);
    }
    
    public static String toBase64String(String content) throws IOException { 
      return Base64.encodeBase64String(content.getBytes());
    }
    
    /**
     * 保存文件
     * @param url
     * @param content
     * @param cover 是否覆盖
     * @return  
     * @throws IOException
     */
    public static File save(String url, String content, boolean cover) throws IOException {
      File file = new File(url);
      if(file.exists() && !cover) {
        return file;
      }
      FileWriter fw = null;
      try {
        fw = new FileWriter(file);
        fw.write(content);
        fw.flush();
      } catch (IOException e) {
        logger.error(e.getMessage());
      }
      finally {
        if(null != fw) {
           fw.close();
        }
      }
      return file;
    }
}
