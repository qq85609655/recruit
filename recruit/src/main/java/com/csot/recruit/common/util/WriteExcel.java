package com.csot.recruit.common.util;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;


public class WriteExcel{
  
  public static boolean print(String path){ 
 if(path != null){
         ComThread.InitSTA(); 
         ActiveXComponent xl = new ActiveXComponent("Excel.Application"); 
          try { 
             // System.out.println("version=" + xl.getProperty("Version")); 
                //不打开文档 
                Dispatch.put(xl, "Visible", new Variant(false)); //new Variant(true)显示文档
                Dispatch workbooks = xl.getProperty("Workbooks").toDispatch(); 
                Dispatch excel=Dispatch.call(workbooks,"Open",path).toDispatch();               
                //设置边距
               // Dispatch.put(pageSetup,"LeftMargin",0);
               // Dispatch.put(pageSetup,"RightMargin",0);
               // Dispatch.put(pageSetup,"TopMargin",0);
              //  Dispatch.put(pageSetup,"BottomMargin",0);
                //开始打印 
                Dispatch.get(excel,"PrintOut"); 
                //增加以下三行代码解决文件无法删除bug
                Dispatch.call(excel, "save");
                Dispatch.call(excel,  "Close" ,  new  Variant(true)); 
                excel=null;


                return true;
             } catch (Exception e) { 
                 e.printStackTrace(); 
                 return false;
               } finally { 
                   //始终释放资源 
                  xl.invoke("Quit", new Variant[] {});
                  xl=null;
                  ComThread.Release();
                  } 
   }else {
      return false;
   }
    }  
   //test
   public static void main(String[] args){
    print("E:\\ccc.xlsx");
  }
}
