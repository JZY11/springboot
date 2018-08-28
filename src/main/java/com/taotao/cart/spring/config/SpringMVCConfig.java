/**
 * 
 */
package com.taotao.cart.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.taotao.cart.interceptors.UserLoginHandlerInterceptor;

/**
 * @ClassName SpringMVCConfig
 * @Description   mvc拦截器
 * @Author jzy
 * @Date 2018年8月27日
 */
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter{

	@Autowired
	private UserLoginHandlerInterceptor userLoginHandlerInterceptor;
	
//	@Autowired
//	private InterceptorRegistry registry;   两种写法，这是第一种
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) { // 参数的形式是第二种，其实都是一样的，本来InterceptorRegistry就在spring容器中
        // 判断用户是否登录的拦截器
        registry.addInterceptor(userLoginHandlerInterceptor).addPathPatterns("/cart/**");
    }

}
