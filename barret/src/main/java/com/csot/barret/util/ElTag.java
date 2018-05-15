package com.csot.barret.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.springframework.util.StringUtils;

public class ElTag {

	private static DecimalFormat integerFormat = null;
	private static DecimalFormat integerFormat1 =new DecimalFormat("###,###,##0.000");
	private static String formatString = null;
	
	public static String toNumberString(Object obj, String format,
			String defaultNumber) {//有四舍五入
		if (StringUtils.isEmpty(obj)) {
			return defaultNumber;
		}
		if(formatString == null || !formatString.equals(format)){
			integerFormat = new DecimalFormat(format);
			formatString = format;
		}
		integerFormat.setRoundingMode(RoundingMode.HALF_UP);
		return integerFormat.format(Double.valueOf(obj.toString()));
	}
	
	public static String toFloat(Object obj){//没有四舍五入
		String number=integerFormat1.format(Double.valueOf(obj.toString()));
		return number;
	}

}