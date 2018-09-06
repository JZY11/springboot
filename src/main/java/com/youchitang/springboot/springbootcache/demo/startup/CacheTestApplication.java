/**
 * 
 */
package com.youchitang.springboot.springbootcache.demo.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName CacheTestApplication
 * @Description
 * @Author jzy
 */
@SpringBootApplication	// 程序启动类
public class CacheTestApplication implements CommandLineRunner{

	@Autowired
	private UserDao userDao;

	public static void main(String[] args) {
		new SpringApplication(CacheTestApplication.class).run(args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("第一次查询");
        System.out.println(userDao.getUser(1L));
        System.out.println("第二次查询");
        System.out.println(userDao.getUser(1L));
        userDao.removeFromCache(1L);// 移除缓存
        System.out.println("第三次查询");
        userDao.getUser(1L);// 没有缓存了

        System.out.println("--------");
        // 测试不同的key缓存
        userDao.getUserByName("telephone1");
        userDao.getUserByName(1L, "telephone1");// 指定了参数name 为key 此次读取缓存
	}
	
// 以下是测试结果：	发现能第二次查询拿了缓存，然后我们移除了，第三次又查数据库。然后我们还测试了指定不同参数为key的缓存   
	
	/**
	 * 第一次查询
	 * 查询数据库:userId ->1
	 * User@65da01f4
	 * 第二次查询
	 * User@65da01f4
	 * 
	 * 第三次查询
	 * 查询数据库:userId ->1
	 * 
	 * --------
	 * 查询数据库:userName : telephone1
	 */
}
