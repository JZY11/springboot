/**
 * 
 */
package com.taotao.cart.spring.config;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.IdleConnectionEvictor;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

/**
 * @ClassName HttpclientSpringConfig
 * @Description  springboot 整合 HttpClient
 * @Author jzy
 * @Date 2018年8月27日
 */
@Configuration
@PropertySource(value = "classpath:httpclient.properties")
public class HttpclientSpringConfig {
	
	@Value("${http.maxTotal}")
	private Integer httpMaxTotal;
	
	@Value("${http.defaultMaxPerRoute}")
	private Integer httpDefaultMaxPerRoute;
	
	@Value("${http.connectTimeout}")
	private Integer httpConnectTimeout;
	
	@Value("${http.connectionRequestTimeout}")
	private Integer httpConnectionRequestTimeout;
	
	@Value("${http.socketTimeout}")
	private Integer httpSocketTimeout;
	
	@Value("${http.staleConnectionCheckEnabled}")
	private Boolean httpStaleConnectionCheckEnabled;
	
	@Autowired
	private PoolingHttpClientConnectionManager manager;
	
	@Bean
	public PoolingHttpClientConnectionManager poolingHttpClientConnectionManager(){
		PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
		// 设置最大连接数
		poolingHttpClientConnectionManager.setMaxTotal(httpMaxTotal);
		// 设置每个主机的最大并发数
		poolingHttpClientConnectionManager.setDefaultMaxPerRoute(httpDefaultMaxPerRoute);
		return poolingHttpClientConnectionManager;
	}
	
	// 定期关闭无效连接
	@Bean
	public IdleConnectionEvictor idleConnectionEvictor(){
		return new IdleConnectionEvictor(manager, httpConnectTimeout, null);
	}
	
	// 定义HttpClient对
	@Bean
	@Scope("prototype")  // 表示是多例不是单利
	public CloseableHttpClient closeableHttpClient(){
		return HttpClients.custom().setConnectionManager(this.manager).build();
	}
	
	// 请求配置
	@Bean
	public RequestConfig requestConfig() {
        return RequestConfig.custom().setConnectTimeout(httpConnectTimeout) // 创建连接的最长时间
                .setConnectionRequestTimeout(httpConnectionRequestTimeout) // 从连接池中获取到连接的最长时间
                .setSocketTimeout(httpSocketTimeout) // 数据传输的最长时间
                .setStaleConnectionCheckEnabled(httpStaleConnectionCheckEnabled) // 提交请求前测试连接是否可用
                .build();
    }
}
