/**
 * 
 */
package com.taotao.cart.spring.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MapperScannerConfig
 * @Description
 * @Author jzy
 * @Date 2018年8月27日
 */
@Configuration
@AutoConfigureAfter(MyBatisConfig.class)  // 保证在MyBatisConfig实例化之后再实例化该类
public class MapperScannerConfig {

	// mapper接口的扫描器
	@Bean
	public MapperScannerConfigurer  mapperScannerConfig(){
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.taotao.cart.mapper");
		return mapperScannerConfigurer;
	}
}
