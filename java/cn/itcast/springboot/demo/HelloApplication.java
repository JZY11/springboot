/**
 * 
 */
package cn.itcast.springboot.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
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
	@ResponseBody
	public String hello(){
		return "hello world";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}
}
