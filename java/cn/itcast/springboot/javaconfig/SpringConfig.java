/**
 * 
 */
package cn.itcast.springboot.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description
 * @Author jzy
 * @Date 2018年8月22日
 */
@Configuration   // 通过该注解表明该类是spring的一个配置，其实就相当于一个xml文件
@ComponentScan(basePackages = "cn.itcast.springboot.javaconfig")  // 配置扫描包
public class SpringConfig {

	@Bean  // 通过该注解来表明是一个Bean对象，相当于xml中的<bean>  来交由spring容器来管理（表明加入到容器中了）
	public UserDAO getUserDAO(){
		return new UserDAO();
	}
}
