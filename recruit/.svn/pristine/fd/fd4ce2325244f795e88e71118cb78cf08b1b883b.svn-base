package com.csot.recruit.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.csot.recruit.model.resume.ResumeTemplate;

public class ExcelReader {
	
	private POIFSFileSystem fs;
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFRow row;
    
    /**
     * 读取Excel表格表头的内容
     * @param InputStream
     * @return String 表头内容的数组
     */
    public String[] readExcelTitle(InputStream is) {
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }

	/**
     * 读取Excel数据内容
     * @param InputStream
     * @return Map 包含单元格数据内容的Map对象
     */
    public List<ResumeTemplate> readExcelContent(InputStream is) {
    	List<ResumeTemplate> list = new ArrayList<ResumeTemplate>();
    	ResumeTemplate resumeTemplate = null;
        String str = "";
        try {
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            if(null != row){
            	resumeTemplate = new ResumeTemplate();
            	resumeTemplate.setName(getCellFormatValue(row.getCell((short) 0)).trim());
            	resumeTemplate.setSex(getCellFormatValue(row.getCell((short) 1)).trim());
            	String age = getCellFormatValue(row.getCell((short) 2)).trim();
            	if(null != age && !age.equals("")){
            		if(age.contains(".")){
            			age = age.substring(0, age.length()-2);
            		}
            		resumeTemplate.setAge(Integer.valueOf(age));
            	}
            	resumeTemplate.setProvince(getCellFormatValue(row.getCell((short) 3)).trim());
            	resumeTemplate.setCity(getCellFormatValue(row.getCell((short) 4)).trim());
            	resumeTemplate.setAddress(getCellFormatValue(row.getCell((short) 5)).trim());
            	resumeTemplate.setTelphone(getCellFormatValue(row.getCell((short) 6)).trim());
            	resumeTemplate.setMobilePhone(getCellFormatValue(row.getCell((short) 7)).trim());
            	resumeTemplate.setNation(getCellFormatValue(row.getCell((short) 8)).trim());
            	resumeTemplate.setEmail(getCellFormatValue(row.getCell((short) 9)).trim());
            	String experience = getCellFormatValue(row.getCell((short) 10)).trim();
            	if(null != experience && !experience.equals("")){
            		if(experience.contains(".")){
            			experience = experience.substring(0, experience.length()-2);
            		}
            		resumeTemplate.setExperience(Integer.valueOf(experience));
            	}
            	resumeTemplate.setExpectedSalary(getCellFormatValue(row.getCell((short) 11)).trim());
            	resumeTemplate.setEducation(getCellFormatValue(row.getCell((short) 12)).trim());
            	resumeTemplate.setGraduationSchool(getCellFormatValue(row.getCell((short) 13)).trim());
            	resumeTemplate.setProfessional(getCellFormatValue(row.getCell((short) 14)).trim());
            	resumeTemplate.setCompany(getCellFormatValue(row.getCell((short) 15)).trim());
            	resumeTemplate.setCurrentSalary(getCellFormatValue(row.getCell((short) 16)).trim());
            	resumeTemplate.setCurrentPosition(getCellFormatValue(row.getCell((short) 17)).trim());
            	resumeTemplate.setChannel(getCellFormatValue(row.getCell((short) 18)).trim());
            	resumeTemplate.setResumeLanguage(getCellFormatValue(row.getCell((short) 19)).trim());
            	resumeTemplate.setRecommendEmail(getCellFormatValue(row.getCell((short) 20)).trim());
            	resumeTemplate.setRecommend(getCellFormatValue(row.getCell((short) 21)).trim());
            	resumeTemplate.setCardId(getCellFormatValue(row.getCell((short) 22)).trim());
            	resumeTemplate.setPosition(getCellFormatValue(row.getCell((short) 23)).trim());
            	list.add(resumeTemplate);
            }
        }
        return list;
    }

    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
            // 如果当前Cell的Type为NUMERIC
            case HSSFCell.CELL_TYPE_NUMERIC:
            case HSSFCell.CELL_TYPE_FORMULA: {
                // 判断当前的cell是否为Date
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    // 如果是Date类型则，转化为Data格式
                    
                    //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                    //cellvalue = cell.getDateCellValue().toLocaleString();
                    
                    //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                    Date date = cell.getDateCellValue();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    cellvalue = sdf.format(date);
                    
                }
                // 如果是纯数字
                else {
                    // 取得当前Cell的数值
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                }
                break;
            }
            // 如果当前Cell的Type为STRIN
            case HSSFCell.CELL_TYPE_STRING:
                // 取得当前的Cell字符串
                cellvalue = cell.getRichStringCellValue().getString();
                break;
            // 默认的Cell值
            default:
                cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }
}
