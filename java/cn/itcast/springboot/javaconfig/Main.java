/**
 * 
 */
package cn.itcast.springboot.javaconfig;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName Main
 * @Description
 * @Author jzy
 * @Date 2018年8月22日
 */
public class Main {

	public static void main(String[] args) {
		// 通过java配置的方式来实例化Spring容器     通过new创建该对象的时候，所传的参数就是被标记为 configuration的对象（也就是将配置项传递给它）
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		// 在Spring容器中获取Bean对象
		UserService userService = context.getBean(UserService.class);
		
		// 调用对象中的方法
		List<User> list = userService.queryUserList();
		for (User user : list) {
			System.out.println(user.getUsername() +", " +user.getPassword() +", " + user.getAge());
		}
		
		// 销毁该spring容器
		context.destroy();
	}
}
