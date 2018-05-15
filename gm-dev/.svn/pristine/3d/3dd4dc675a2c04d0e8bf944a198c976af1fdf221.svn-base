package org.amberframework.core.spring.service.impl;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:test-spring-context.xml"})
public class SpringPropertyResourceReaderTest {

  @Resource
  private SpringPropertyResourceReader springPropertyResourceReader;
  
  @Test
  public void testGetProperty() {
    String testStr = springPropertyResourceReader.getProperty("test.resource.reader.str");
    Assert.assertEquals("Spring-Property.Resource_Reader", testStr);
  }

}
