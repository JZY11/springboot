/**
 * 
 */
package cn.itcast.springboot.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MySrpingMVCConfig
 * @Description
 * @Author jzy
 * @Date 2018年8月23日
 */
@Configuration   // 声明这是一个配置
public class MySrpingMVCConfig extends WebMvcConfigurerAdapter{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor handlerInterceptor = new HandlerInterceptor() { // 接口：HandlerInterceptor  直接new这个接口的写法是：匿名实现类
			
			@Override
			public boolean preHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("自定义拦截器。。。。。。");
				return true;
			}
			
			@Override
			public void postHandle(HttpServletRequest request,
					HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterCompletion(HttpServletRequest request,
					HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
		};
		registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
		// 所有的请求都会进入到拦截器   然后打印："自定义拦截器。。。。。。"
	}
}
