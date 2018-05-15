package org.ambertestframework.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class SpringTestContextConfig {

  @javax.annotation.Resource
  DataSource dataSource;

  /**
   * 读取properties的Bean.
   */
  @Bean(autowire = Autowire.BY_NAME)
  public PropertyPlaceholderConfigurer propertyPlaceHolderConfigurer() {
    PropertyPlaceholderConfigurer cfg = new PropertyPlaceholderConfigurer();
    Resource resource = new ClassPathResource("test-local-config.properties");
    cfg.setLocations(resource);
    return cfg;
  }

  /**
   * 用于在Java中获取propertyPlaceHolderConfigurer读取的properties的Bean.
   */
  @Bean(autowire = Autowire.BY_NAME)
  public SpringPropertyResourceReader springPropertyResourceReader() {
    return new SpringPropertyResourceReader(this.propertyPlaceHolderConfigurer());

  }

  /**
   * 生成Spring的sqlSessionFactory Bean
   */
  @Bean(autowire = Autowire.BY_NAME)
  public SqlSessionFactoryBean sqlSessionFactory() {
    try {
      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
      PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
      Resource configLocation = resolver.getResource("classpath:mybatis-config.xml");

      // 此处配置扫描MyBatis的Mapper.xml文件, classpath要带*, 不然找不到src/main/java下的xml
      Resource[] mapperLocations =
          resolver.getResources("classpath*:org/amberframework/**/oracle/**/*Mapper.xml");
      Resource[] comCsotLocations = resolver.getResources("classpath*:com/csot/**/oracle/**/*Mapper.xml");
      Resource[] hahaTestLocations = resolver.getResources("classpath*:haha/test/**/oracle/**/*Mapper.xml");

      List<Resource> mapperList =
          new ArrayList<Resource>(mapperLocations.length 
              + comCsotLocations.length 
              + hahaTestLocations.length);

      addArrayToList(mapperList, mapperLocations);
      addArrayToList(mapperList, comCsotLocations);
      addArrayToList(mapperList, hahaTestLocations);

      sqlSessionFactoryBean.setMapperLocations(mapperList.toArray(new Resource[0]));
      sqlSessionFactoryBean.setDataSource(dataSource);
      sqlSessionFactoryBean.setConfigLocation(configLocation);
      return sqlSessionFactoryBean;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private void addArrayToList(List<Resource> destList, Resource[] mapperLocations) {
    for (Resource location : mapperLocations) {
      destList.add(location);
    }
  }
}
