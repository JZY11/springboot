/**
 * 
 */
package com.youchitang.springboot.springbootcache.demo.startup;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Component;

import com.youchitang.springboot.springbootcache.demo.entity.User;

/**
 * @ClassName UserDao
 * @Description   模拟的业务对象
 * @Author jzy
 */
@Component
@EnableCaching		// spring boot提供了比较简单的缓存方案。只要使用 @EnableCaching即可完成简单的缓存功能。
public class UserDao {

	private Map<Long, User> userMap;
	
	@PostConstruct		//  被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次,PostConstruct在构造函数之后执行,init()方法之前执行。
	public void init(){
		// 模拟数据库
		userMap = new HashMap<Long, User>();
		userMap.put(1L,new User(1L, "telephone1"));
		userMap.put(2L,new User(1L, "telephone2"));
	}
	
	 @Cacheable("user")  // 
	 public User getUser(Long userId){
		 System.out.println("查询数据库:userId ->" + userId);
		 return userMap.get(userId);
	 }
	 
	 @Cacheable(value="nameCache",key="#name")
	 public User getUserByName(Long userId,String name){
		 System.out.println("查询数据库:userId ->" + userId);
		 return userMap.get(userId);
	 }
	 
	 @Cacheable("nameCache")
	 public User getUserByName(String name){
		 System.out.println("查询数据库:userName : " + name);
		 for(Long k : userMap.keySet()){
			 if (userMap.get(k).equals(name)) {
				return userMap.get(k);
			}
		 }
		 return null;
	 }
	 
	 @CachePut("user") // 与Cacheable区别就是Cacheable先看缓存如果有，直接缓存换回，CachePut则是每次都会调用并且把返回值放到缓存
	 public User getUser2(Long userId){
		 System.out.println("查询数据库:userId:" + userId);
		 return userMap.get(userId);
	 }
	 
	 
	 @CacheEvict("user")
	 public void removeFromCache(Long userId){
		 return;
	 }
}
