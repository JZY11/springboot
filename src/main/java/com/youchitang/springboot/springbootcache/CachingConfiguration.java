/**
 * 
 */
package com.youchitang.springboot.springbootcache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.ehcache.config.CacheConfiguration;

/**
 * @ClassName CachingConfiguration
 * @Description		下面是springboot不要Ehcache配置文件的注入方法
 * 很多时候系统的瓶颈都在一些比较复杂的IO操作，例如读取数据库，如果一些比较稳定的数据，一般的解决方案就是用缓存
 * spring boot 提供了比较简单的缓存方案。只要使用@EnableCaching即可以实现简单的缓存功能
 * @Author jzy
 */
@Configuration
@EnableCaching	
public class CachingConfiguration implements CachingConfigurer{
	
	
	@Bean(destroyMethod="shutdown")
	public net.sf.ehcache.CacheManager ehCacheManager(){
		CacheConfiguration cacheConfiguration  = new CacheConfiguration();
		cacheConfiguration.setName("demo");
		cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(1000);
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);
        return net.sf.ehcache.CacheManager.newInstance(config);
	}
	
	
	

	/* (non-Javadoc)
	 * @see org.springframework.cache.annotation.CachingConfigurer#cacheManager()
	 */
	@Bean
	@Override
	public CacheManager cacheManager() {
		return new EhCacheCacheManager(ehCacheManager());
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.annotation.CachingConfigurer#cacheResolver()
	 */
	@Override
	public CacheResolver cacheResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.annotation.CachingConfigurer#errorHandler()
	 */
	@Override
	public CacheErrorHandler errorHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.springframework.cache.annotation.CachingConfigurer#keyGenerator()
	 */
	@Bean
	@Override
	public KeyGenerator keyGenerator() {
		return new SimpleKeyGenerator();
	}

}
