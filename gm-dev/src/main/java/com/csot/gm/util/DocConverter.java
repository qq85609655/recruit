package com.csot.gm.util;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

/**
 * 文件转换类.
 * <p>
 * 原理：使用jacob将word\excel\ppt转换为pdf、然后用swftools转换为swf、浏览器安装flash player加载swf 不需要下载原文件，达到文件在线预览功能。
 * <p>
 * 要求：
 * <ul>
 * <li>服务器需要安装office（测试使用office2010）、swftools
 * <li>客户端需要安装flash player8以上插件，公司VDI环境基本都能支持
 * </ul>
 * 步骤：
 * <ul>
 * <li>1、将附件中的jacob.dll放在java安装目录的jdk/jre/bin目录下（如C:\Program Files (x86)\Java\jdk1.7.0_76\jre\bin）
 * <li>2、配置文件pom.xml 和local-config.properties 中的pdf2swf.tools.path 改为你的swftools 的安装路径
 * <li>3、jsp中引用FlexPaper插件的js
 * </ul>
 * 
 * @author liangjiyin
 *
 */
public class DocConverter {

  private static final Logger logger = LoggerFactory.getLogger(DocConverter.class);

  /**
   * 检测后缀名是否是ppt、doc、xls、txt，是否可以转换为pdf，然后转为swf
   * 
   * @param type 文件后缀名
   */
  public static boolean isPdfType(String type) {
    if (type == null) {
      return false;
    } else if (type.equalsIgnoreCase("doc") || type.equalsIgnoreCase("docx")
        || type.equalsIgnoreCase("ppt") || type.equalsIgnoreCase("pptx")
        || type.equalsIgnoreCase("xls") || type.equalsIgnoreCase("xlsx")
        || type.equalsIgnoreCase("pdf")) {
      return true;
    }
    return false;
  }

  /**
   * 用 swftools将pdf转成swf
   * 
   * @param pdfPath
   * @param swfPath
   */
  public static void pdf2swf(String pdfPath, String swfPath) throws Exception {

    Runtime r = Runtime.getRuntime();

    File pdfFile = new File(pdfPath);
    File swfFile = new File(swfPath);
    if (swfFile.exists()) {
      logger.info("****swf已经存在不需要转换****");
      return;
    }

    if (!pdfFile.exists()) {
      throw new RuntimeException("文件转码失败！");
    }

    String os = System.getProperty("os.name");
    
    if (os.toLowerCase().startsWith("win")) { // windows环境处理
      try {
        // 以下的参数：-G -s
        // poly2bitmap非常重要，特别是碰到office文件中文件特别大或者说图表特别多的情况，可能无法转为swf文件，加上这可以防止，
        // 具体参数请参考网上资料。由于这样会降低转换效率，所以最好在这里做个判断，若文件大于某个大小再加这两个参数，反之不用加，提高转换效率

        String pdf2swf_home = "D:/software/swftools/pdf2swf.exe";

        // System.out.println("转换好的文件" + pdf2swf_home + " " + pdfFile.getPath() + " -o "
        // + swfFile.getPath() + " -T 9 -G -f -s poly2bitmap");
        Process p =
            r.exec(pdf2swf_home + " " + pdfFile.getPath() + " -o " + swfFile.getPath()
                + " -s flashversion=9");
        p.waitFor();// 等线程执行完，否则会找不到swf
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    } else { // linux环境处理
      try {
        Process p = r.exec("pdf2swf " + pdfFile.getPath() + " -o " + swfFile.getPath() + " -T 9");
        p.waitFor();// 等线程执行完，否则会找不到swf
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    logger.info("****swf转换成功，文件输出：" + swfFile.getPath() + "****");
    pdfFile = null;
    swfFile = null;
  }



  private static final int xlsSavePDF = 0; // xls 转PDF 格式
  private static final int docSaveAsPDF = 17;// doc 转PDF 格式
  private static final int pptSaveAsPDF = 32;// ppt 转PDF 格式

  /**
   * 用jacob转换excel格式
   * 
   * @param docPath docPath
   * @param pdfPath pdfPath
   */
  public static void office2Pdf(String docPath, String pdfPath) throws Exception {

    File inputFile = new File(docPath);
    File outputFile = new File(pdfPath);
    if (!inputFile.exists()) {
      throw new RuntimeException("文件不存在！");
    }
    if (outputFile.exists()) {
      outputFile.delete();
    } else if (!outputFile.getParentFile().exists()) {
      outputFile.getParentFile().mkdirs();
    }
    inputFile = null;
    outputFile = null;

    if (docPath.endsWith("doc") || docPath.endsWith("docx")) {
      doc2Pdf(docPath, pdfPath);
    } else if (docPath.endsWith("ppt") || docPath.endsWith("pptx")) {
      ppt2Pdf(docPath, pdfPath);
    } else if (docPath.endsWith("xls") || docPath.endsWith("xlsx")) {
      xls2pdf(docPath, pdfPath);
    } else {
      throw new RuntimeException("文件转换失败！");
    }

    logger.info("转换文档到PDF " + pdfPath);
  }

  private static void xls2pdf(String docPath, String pdfPath) {
    ComThread.InitSTA();

    ActiveXComponent app = null;
    Dispatch excel = null;
    try {
      app = new ActiveXComponent("Excel.Application");
      app.setProperty("Visible", false);
      Dispatch excels = app.getProperty("Workbooks").toDispatch();
      excel = Dispatch.call(excels, "Open", docPath, false, true).toDispatch();
      Dispatch.call(excel, "ExportAsFixedFormat", xlsSavePDF, pdfPath);
    } catch (Exception e) {
      logger.error("Error:文档转换失败：" + e.getMessage(), e);
      throw new RuntimeException("Error:文档转换失败：" + e.getMessage());
    } finally {
      Dispatch.call(excel, "Close", false);
      if (app != null) {
        app.invoke("Quit");
      }
      ComThread.Release();
    }
  }

  public static void doc2Pdf(String docPath, String pdfPath) {
    ComThread.InitSTA();
    ActiveXComponent app = null;
    Dispatch doc = null;
    try {
      app = new ActiveXComponent("Word.Application");
      app.setProperty("Visible", new Variant(false));
      Dispatch docs = app.getProperty("Documents").toDispatch();
      System.out.println("打开文档..." + docPath);
      doc = Dispatch.call(docs, "Open", docPath, true,// ReadOnly
          true,// Untitled 指定文件是否有标题。
          false // WithWindow 指定文件是否可见。
          ).toDispatch();

      Dispatch.call(doc, "SaveAs", pdfPath, docSaveAsPDF);
    } catch (Exception e) {
      logger.error("Error:文档转换失败：" + e.getMessage(), e);
      throw new RuntimeException("Error:文档转换失败：" + e.getMessage());
    } finally {
      Dispatch.call(doc, "Close", false);
      if (app != null) {
        app.invoke("Quit", new Variant[] {});
      }
      // 如果没有这句话,winword.exe进程将不会关闭
      ComThread.Release();
    }
  }

  public static void ppt2Pdf(String docPath, String pdfPath) {
    ComThread.InitSTA();

    ActiveXComponent app = null;
    Dispatch doc = null;
    try {
      app = new ActiveXComponent("Powerpoint.Application");
      if (app.getProperty("Visible").toBoolean()) {
        app.setProperty("Visible", new Variant(false));
      }
      Dispatch presentations = app.getProperty("Presentations").toDispatch();
      System.out.println("打开文档" + docPath);
      doc = Dispatch.call(presentations,//
          "Open", docPath,// FileName
          true,// ReadOnly
          true,// Untitled 指定文件是否有标题。
          false // WithWindow 指定文件是否可见。
          ).toDispatch();

      Dispatch.call(doc, "SaveAs", pdfPath, pptSaveAsPDF);
    } catch (Exception e) {
      logger.error("Error:文档转换失败：" + e.getMessage(), e);
      throw new RuntimeException("Error:文档转换失败：" + e.getMessage());
    } finally {
      try {
        Dispatch.call(doc, "Close");
      } catch (Exception e) {
        logger.error("Error:ppt关闭失败：" + e.getMessage());
      } finally {
        if (app != null) {
          app.invoke("Quit");
        }
        ComThread.Release();
      }
    }
  }

}
