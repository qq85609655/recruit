package com.csot.recruit.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExportExcelUtil<T> {

	SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
	SimpleDateFormat formaty = new SimpleDateFormat("yyyy年MM月dd日");

	/**
	 * 这是一个通用的方法，利用了JAVA的反射机制，可以将放置在JAVA集合中并且符号一定条件的数据以EXCEL 的形式输出
	 * 
	 * @param title
	 *            表格标题名
	 * @param headersName
	 *            表格属性列名数组
	 * @param headersId
	 *            表格属性列名对应的字段
	 * @param dataset
	 *            需要显示的数据集合,集合中一定要放置符合javabean风格的类的对象
	 * @param out
	 *            与输出设备关联的流对象，可以将EXCEL文档导出到本地文件或者网络中
	 */
	@SuppressWarnings("unchecked")
	public void exportExcel(String title, String[] headersName,
			String[] headersId, List dtoList, HttpServletResponse response) {
		// 表头
		Map map = new HashMap();
		int key = 0;
		for (int i = 0; i < headersName.length; i++) {
			if (!headersName[i].equals("")) {
				map.put(key, headersName[i]);
				key++;
			}
		}
		// 字段
		Map zdMap = new HashMap();
		int value = 0;
		for (int i = 0; i < headersId.length; i++) {
			if (!headersId[i].equals("")) {
				zdMap.put(value, headersId[i]);
				value++;
			}
		}
		// 声明一个工作薄
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = null;
		// 如果数据超过一个sheet页的最大值则截取成多个list
		List subList = new ArrayList();
		//从配置文件拿到导出的每个sheet页的数据个数
		int sheetMaxNum = Integer.valueOf(new PropertiesUtil().readProperty("sheetMaxNum"));
		// 判断有多少个sheet页，根据sheet页的个数设置sheet页的名称
		int sheetNum = 0;
		for (int k = 0; k < dtoList.size(); k++) {
			if (k % sheetMaxNum == 0) {
				int fromIndex = k / sheetMaxNum * sheetMaxNum;
				int toIndex = (k / sheetMaxNum + 1) * sheetMaxNum;
				if (toIndex > dtoList.size()) {
					toIndex = dtoList.size();
				}
				subList = dtoList.subList(fromIndex, toIndex);
				if (sheetNum == 0) {
					sheet = wb.createSheet(title);
				} else {
					sheet = wb.createSheet(title + sheetNum);
				}
				sheetNum++;
				sheet.setDefaultColumnWidth((short) 15);
				// 生成一个样式
				HSSFCellStyle style = wb.createCellStyle();
				HSSFRow row = sheet.createRow(0);
				// 设置第一行单元格高度
				row.setHeight((short) (12.75 * 20 * 2));
				// 设置单元格内容居中显示
				style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				// 垂直居中
				style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				// 自动换行
				style.setWrapText(true);
				// 置单元格底部边框变粗
				style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
				// 设置单元格左边框变粗
				style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				// 置单元格右边框变粗
				style.setBorderRight(HSSFCellStyle.BORDER_THIN);
				// 置单元格头部边框变粗
				style.setBorderTop(HSSFCellStyle.BORDER_THIN);
				HSSFCell cell;
				Collection c = map.values();
				Iterator it = c.iterator();
				// 根据选择的字段生成表头
				short size = 0;
				while (it.hasNext()) {
					cell = row.createCell(size);
					cell.setCellValue(it.next().toString());
					cell.setCellStyle(style);
					size++;
				}
				// 字段
				Collection zdC = zdMap.values();
				int zdRow = 0;
				for (int j = 0; j < subList.size(); j++) {
					int zdCell = 0;
					zdRow++;
					row = sheet.createRow(zdRow);
					T l = (T) subList.get(j);
					// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
					Field[] fields = l.getClass().getDeclaredFields();
					for (short i = 0; i < fields.length; i++) {
						Field field = fields[i];
						String fieldName = field.getName();
						Iterator zdIt = zdC.iterator();
						while (zdIt.hasNext()) {
							String column = (String) zdIt.next();
							if (column.trim().equals(fieldName.trim())) {
								String getMethodName = "get"
										+ fieldName.substring(0, 1)
												.toUpperCase()
										+ fieldName.substring(1);
								Class tCls = l.getClass();
								try {
									Method getMethod = tCls.getMethod(
											getMethodName, new Class[] {});
									Object val = getMethod.invoke(l,
											new Object[] {});
									String textVal = null;
									if (val != null) {
										if (fields[i].getName().toString()
												.equals("effectiveDate")) {
											textVal = formaty.format(val);
										} else if (fields[i].getName()
												.toString()
												.equals("expectDate")) {
											textVal = formaty.format(val);
										} else if (fields[i].getName()
												.toString()
												.equals("distributeDate")) {
											textVal = formaty.format(val);
										} else if (fields[i].getName()
												.toString()
												.equals("modifyDate")) {
											textVal = formaty.format(val);
										} else if (fields[i].getName()
												.toString()
												.equals("expireDate")) {
											textVal = formaty.format(val);
										} else if (fields[i].getName()
												.toString()
												.equals("updateDate")) {
											textVal = formaty.format(val);
										} else {
											textVal = val.toString();
										}
									} else {
										textVal = null;
									}
									cell = row.createCell(zdCell);
									cell.setCellValue(textVal);
									cell.setCellStyle(style);
									zdCell++;
								} catch (SecurityException e) {
									e.printStackTrace();
								} catch (IllegalArgumentException e) {
									e.printStackTrace();
								} catch (NoSuchMethodException e) {
									e.printStackTrace();
								} catch (IllegalAccessException e) {
									e.printStackTrace();
								} catch (InvocationTargetException e) {
									e.printStackTrace();
								}
							}
						}

					}
				}
			}
		}

		try {

			ByteArrayOutputStream os = new ByteArrayOutputStream();
			// 将工作簿内容写入响应输出流
			wb.write(os);
			byte[] content = os.toByteArray();
			InputStream is = new ByteArrayInputStream(content);
			// 设置response参数，可以打开下载页面
			response.reset();
			response.setContentType("application/vnd.ms-excel;charset=utf-8");
			response.setHeader("Content-Disposition", "attachment;filename="
					+ new String((title + ".xls").getBytes(), "iso-8859-1"));
			ServletOutputStream out = response.getOutputStream();
			BufferedInputStream bis = null;
			BufferedOutputStream bos = null;
			try {
				bis = new BufferedInputStream(is);
				bos = new BufferedOutputStream(out);
				byte[] buff = new byte[2048];
				int bytesRead;
				// Simple read/write loop.
				while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
					bos.write(buff, 0, bytesRead);
				}
			} catch (final IOException e) {
				throw e;
			} finally {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
				if (os != null)
					// 将输出流对象关闭
					os.close();
			}

			/* JOptionPane.showMessageDialog(null, "导出成功!"); */
		} catch (FileNotFoundException e) {
			// JOptionPane.showMessageDialog(null, "导出失败!");
			e.printStackTrace();
		} catch (IOException e) {
			// JOptionPane.showMessageDialog(null, "导出失败!");
			e.printStackTrace();
		}
	}

}