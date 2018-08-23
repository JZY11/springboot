/**
 * 
 */
package cn.itcast.springboot.demo;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName HelloApplication
 * @Description
 * @Author jzy
 * @Date 2018年8月22日
 */
@Controller
@SpringBootApplication
@Configuration
public class HelloApplication {

	@RequestMapping("hello")
	@ResponseBody     // 有这个注解的就会使用消息
	public String hello(){
		return "hello world";
	}
	
	/**
	 *springboot项目中自定义消息转化器，只需要在@Configuration的类中添加消息转化器的@Bean
	 *加入到spring容器，就会被springboot自动加入到容器中。
	 */
	@Bean
    public StringHttpMessageConverter stringHttpMessageConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("ISO-8859-1"));
        return converter;
    }
	
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
}
