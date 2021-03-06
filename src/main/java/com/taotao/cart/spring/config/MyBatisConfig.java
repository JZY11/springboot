/**
 * 
 */
package com.taotao.cart.spring.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @ClassName MyBatisConfig
 * @Description
 * @Author jzy
 * @Date 2018年8月27日
 */
@Configuration
public class MyBatisConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	@ConditionalOnMissingBean  // 该标签表示当容器里没有指定的Bean的情况下创建该对象
	public SqlSessionFactoryBean sqlSessionFactoryBean(){
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		
		// 设置数据源
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		// 设置mybatis的主配置文件
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource mybatisConfigXml  = resolver.getResource("classpath:mybatis/mybatis-config.xml");
		
		// 设置包别名
		sqlSessionFactoryBean.setTypeAliasesPackage("com.taotao.cart.pojo");
		return sqlSessionFactoryBean;
	}
}
