package org.amberframework.core.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class CustomDateConverter implements Converter<String, Date> {

  private SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  public Date convert(String source) {
    if (StringUtils.isEmpty(source)) {
      return null;
    }

    try {
      if (source.indexOf(":") == -1 && source.length() == 10) {
        return dateFormat.parse(source);
      } else if (source.indexOf(":") >= 0 && source.length() == 19) {
        return datetimeFormat.parse(source);
      } else if (source.indexOf(":") >= 0 && source.length() == 21) {
        return datetimeFormat.parse(source.replace(".0", ""));
      } else {
        throw new IllegalArgumentException("Could not parse date, date format is error ");
      }
    } catch (ParseException ex) {
      IllegalArgumentException iae = new IllegalArgumentException("Could not parse date: " + ex.getMessage());
      iae.initCause(ex);
      throw iae;
    }
  }

}
