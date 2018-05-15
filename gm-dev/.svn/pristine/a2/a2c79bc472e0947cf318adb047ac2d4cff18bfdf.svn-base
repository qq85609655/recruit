package org.amberframework.core.converter;

import java.util.Date;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CustomDateConverterTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testConvert() {
    CustomDateConverter cdc = new CustomDateConverter();
    {
      String sourceEmptyStr = "";
      String sourceNull = null;
      Assert.assertNull(cdc.convert(sourceEmptyStr));
      Assert.assertNull(cdc.convert(sourceNull));
    }

    {
      String sourceDateonly = "2015-08-07";
      Date dateOnly = new Date();
      dateOnly.setYear(2015 - 1900);
      dateOnly.setMonth(8 - 1);
      dateOnly.setDate(7);
      Date dateActual = cdc.convert(sourceDateonly);
      Assert.assertEquals(dateOnly.getYear(), dateActual.getYear());
      Assert.assertEquals(dateOnly.getMonth(), dateActual.getMonth());
      Assert.assertEquals(dateOnly.getDate(), dateActual.getDate());
    }

    {
      String sourceDateTime = "2015-08-07 15:50:33";
      Date dateOnly = new Date();
      dateOnly.setYear(2015 - 1900);
      dateOnly.setMonth(8 - 1);
      dateOnly.setDate(7);
      dateOnly.setHours(15);
      dateOnly.setMinutes(50);
      dateOnly.setSeconds(33);
      Date dateActual = cdc.convert(sourceDateTime);
      Assert.assertEquals(dateOnly.getYear(), dateActual.getYear());
      Assert.assertEquals(dateOnly.getMonth(), dateActual.getMonth());
      Assert.assertEquals(dateOnly.getDate(), dateActual.getDate());
      Assert.assertEquals(dateOnly.getHours(), dateActual.getHours());
      Assert.assertEquals(dateOnly.getMinutes(), dateActual.getMinutes());
      Assert.assertEquals(dateOnly.getSeconds(), dateActual.getSeconds());
    }

    {
      String sourceDateTime2 = "2015-08-07 19:25:59.0";
      Date dateOnly = new Date();
      dateOnly.setYear(2015 - 1900);
      dateOnly.setMonth(8 - 1);
      dateOnly.setDate(7);
      dateOnly.setHours(19);
      dateOnly.setMinutes(25);
      dateOnly.setSeconds(59);
      Date dateActual = cdc.convert(sourceDateTime2);
      Assert.assertEquals(dateOnly.getYear(), dateActual.getYear());
      Assert.assertEquals(dateOnly.getMonth(), dateActual.getMonth());
      Assert.assertEquals(dateOnly.getDate(), dateActual.getDate());
      Assert.assertEquals(dateOnly.getHours(), dateActual.getHours());
      Assert.assertEquals(dateOnly.getMinutes(), dateActual.getMinutes());
      Assert.assertEquals(dateOnly.getSeconds(), dateActual.getSeconds());
    }
  }

  @Test
  public void testConvertExpectedExceptionLength() {
    CustomDateConverter cdc = new CustomDateConverter();
    String sourceDateTime = "2015-08-07 19:25:59.012345";
    thrown.expect(IllegalArgumentException.class);
    cdc.convert(sourceDateTime);
  }

  @Test
  public void testConvertExpectedExceptionParse() {
    CustomDateConverter cdc = new CustomDateConverter();
    String sourceDateTime = "2015/08/07 19:25:59";
    thrown.expect(IllegalArgumentException.class);
    cdc.convert(sourceDateTime);
  }
}
