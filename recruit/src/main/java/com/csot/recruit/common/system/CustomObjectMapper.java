package com.csot.recruit.common.system;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.codehaus.jackson.JsonGenerator;   
import org.codehaus.jackson.JsonProcessingException;   
import org.codehaus.jackson.map.JsonSerializer;   
import org.codehaus.jackson.map.ObjectMapper;   
import org.codehaus.jackson.map.SerializerProvider;   
import org.codehaus.jackson.map.ser.CustomSerializerFactory; 

/**
 * @description 解决Date类型返回到前端时，由json默认的时间戳格式为自定义的"yyyy-MM-dd HH:mm:ss"格式
 * @author 
 *
 */
@Component("customObjectMapper")
public class CustomObjectMapper extends ObjectMapper {
  public CustomObjectMapper() {  
    CustomSerializerFactory factory = new CustomSerializerFactory();  
    factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {  
      @Override  
      public void serialize(Date value, JsonGenerator jsonGenerator,  
        SerializerProvider provider) throws IOException, JsonProcessingException {  
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
          jsonGenerator.writeString(sdf.format(value));  
        }  
      });  
      this.setSerializerFactory(factory);  
    }  

}
