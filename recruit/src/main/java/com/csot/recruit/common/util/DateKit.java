package com.csot.recruit.common.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>Title:时间工具类</p>
 * @author zhanglu
 * @date 2016年4月6日
 */
public class DateKit {
	
	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
	    protected SimpleDateFormat initialValue() {
		return new SimpleDateFormat("yyyy-MM-dd");
	    }
	};
	
	/** 时间格式 */
	private final static ThreadLocal<SimpleDateFormat> timeFormat = new ThreadLocal<SimpleDateFormat>(){
	    protected SimpleDateFormat initialValue() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    }
	};
	
	/** 日期格式 */
	private final static ThreadLocal<SimpleDateFormat> dayFormat = new ThreadLocal<SimpleDateFormat>(){
	    protected SimpleDateFormat initialValue() {
		return new SimpleDateFormat("MM月dd日 HH:mm");
	    }
	};
	
	/**
	 * 分钟格式
	 */
	private final static ThreadLocal<SimpleDateFormat> secondsFormat = new ThreadLocal<SimpleDateFormat>(){
	    protected SimpleDateFormat initialValue() {
		return new SimpleDateFormat("HH:mm");
	    }
	};
	
	
	/**  
	 * 获取当前时间:Date
	 */
	public static Date getDate(){
		return new Date();
	}
	
	/**  
	 * 获取当前时间:Calendar
	 */
	public static Calendar getCal(){
		return Calendar.getInstance();
	}

	/**  
	 * 日期转换为字符串:yyyy-MM-dd
	 */
	public static String dateToStr(Date date){
		if(date != null)
			return dateFormat.get().format(date);
		return null;
	}
	
	/**  
	 * 日期转换为字符串:MM月dd日 HH:mm
	 */
	public static String dayToStr(Date date){
		if(date != null)
			return dayFormat.get().format(date);
		return null;
	}
	
	/**  
	 * 时间转换为字符串:yyyy-MM-dd HH:mm:ss
	 */
	public static String timeToStr(Date date){
		if(date != null)
			return timeFormat.get().format(date);
		return null;
	}
	
	/**  
	 * 时间转换为字符串:HH:mm
	 */
	public static String secondsToStr(Date date){
		if(date != null)
			return secondsFormat.get().format(date);
		return null;
	}
	
	/**  
	 * 字符串转换为日期:yyyy-MM-dd
	 */
	public static Date strToDate(String str){
		Date date = null;
		try {
			date = dateFormat.get().parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**  
	 * 字符串转换为时间:yyyy-MM-dd HH:mm:ss
	 */
	public static Date strToTime(String str){
		Date date = null;
		try {
			date = timeFormat.get().parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**  
	 * 字符串转换为时间:HH:mm
	 */
	public static Date strToSeconds(String str){
		Date date = null;
		try {
			date = secondsFormat.get().parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	
	/**  
	 * 友好的方式显示时间
	 */
	public static String friendlyFormat(String str){
		Date date = strToTime(str);
		if(date == null)
			return ":)";
		Calendar now = getCal();
		String time = new SimpleDateFormat("HH:mm").format(date);
		
		// 第一种情况，日期在同一天
		String curDate = dateFormat.get().format(now.getTime());
		String paramDate = dateFormat.get().format(date);
		if(curDate.equals(paramDate)){
			int hour = (int) ((now.getTimeInMillis() - date.getTime()) / 3600000);
			if(hour > 0)
				return hour + "小时前";
			int minute = (int) ((now.getTimeInMillis() - date.getTime()) / 60000);
			if (minute < 2)
				return "刚刚";
			if (minute > 30)
				return "半个小时前";
			return minute + "分钟前";
		}
		
		// 第二种情况，不在同一天
		int days = (int) ((getBegin(getDate()).getTime() - getBegin(date).getTime()) / 86400000 );
		if(days == 1 )
			return "昨天 "+time;
		if(days == 2)
			return "前天 "+time;
		if(days <= 7)
			return days + "天前";
		return dateToStr(date);
	}
	
	/**  
	 * 返回日期的0点:2012-07-07 20:20:20 --> 2012-07-07 00:00:00
	 */
	public static Date getBegin(Date date){
		return strToTime(dateToStr(date)+" 00:00:00");
	}

	/**
	 * <p>Description:两个时间之间的天数</p>
	 * @author zl
	 * @date 2016年5月7日
	 */
	public static int getAge(Date birthDate) {

		if (birthDate == null)
			throw new RuntimeException("出生日期不能为null");

		int age = 0;

		Date now = new Date();

		SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
		SimpleDateFormat format_M = new SimpleDateFormat("MM");

		String birth_year = format_y.format(birthDate);
		String this_year = format_y.format(now);

		String birth_month = format_M.format(birthDate);
		String this_month = format_M.format(now);

		// 初步，估算
		age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);

		// 如果未到出生月份，则age - 1
		if (this_month.compareTo(birth_month) < 0)
			age -= 1;
		if (age < 0)
			age = 0;
		return age;
	}
	
	/**
	 * 处理esayui形如06/01/2016 12:48:30 转成 格式yyyy-MM-dd HH:mm:ss
	 * @param str
	 * @return
	 */
	public static String changeFormat(String str) {
			String day = str.substring(0, 2);
			String month = str.substring(3, 5);
			String year = str.substring(6, 10);
			String date = str.substring(11,str.length());
			//yyyy-MM-dd HH:mm:ss
			String nowStr = year + "-" + month + "-" + day + " "+ date ;
			System.out.println(nowStr);
			return nowStr ;
	}
	
	/**
	 * yyyy-MM-dd HH:mm:ss转Date
	 * @param str
	 * @return
	 */
	public static Date StringToDate (String str) throws Exception{
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
 	     Date d = df.parse(str); 
 	     return d ;
	}
	
	public static void main(String[] args) throws Exception {
		//System.err.println(friendlyFormat("2013-09-16 11:27:19"));
		
		// 时间加减法运算
	/*	Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(new Date());
		rightNow.add(Calendar.MONTH, 3);  // 日期加三个月
		Date newDate = rightNow.getTime();
		System.out.println("最后结果：" + DateKit.dateToStr(newDate));
		
		System.out.println("-----------------------");
		
		// 时间比较
		boolean flag = false;
		Date sdfDate = DateKit.strToDate("2016-08-18");
		if(sdfDate.getTime() > newDate.getTime()){
			flag = true;
		}
		
		System.out.println(flag);*/
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
 	     Date d = df.parse("2012-01-06 12:30:56");  
 	     System.out.println(d);
	}
	
	
}
