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
	
	/*
	 * 在实际开发中，我们往往是通过Spring的@Cacheable来实现数据的缓存的，该注解在方法上表示该方法是支持缓存的，标记在类上表示这个类中的所有的方法都支持缓存，
	 * 对于一个支持缓存的方法，Spring会在其被调用后将其返回值缓存起来，以保证下次利用同样的参数来执行该方法时可以直接从缓存中获取结果，而不需要再次执行该方法。Spring在缓存方法的返回值时是以键值对进行缓存的，值就是方法的返回结果，
	 * @Cacheable可以指定三个属性，value、key和condition
	 * 			value属性：指定Cache名称，value属性是必须指定的，其表示当前方法的返回值是会被缓存在哪个Cache上的，对应Cache的名称。其可以是一个Cache也可以是多个Cache，当需要指定多个Cache时其是一个数组。
	 * 					如：@Cacheable("cache1")//Cache是发生在cache1上的        @Cacheable({"cache1", "cache2"})//Cache是发生在cache1和cache2上的
	 * 			  key属性：自定义key key属性是用来指定Spring缓存方法的返回结果时对应的key的。使用方法参数时我们可以直接使用“#参数名”或者“#p参数index”
	 * 					如：@Cacheable(value="users", key="#id")
	 * 		condition属性：指定发生的条件    有的时候我们可能并不希望缓存一个方法所有的返回结果。通过condition属性可以实现这一功能
	 * 					如：@Cacheable(value={"users"}, key="#user.id", condition="#user.id%2==0")
	 */
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
	 
	 /*
	  * 在支持spring cache的环境中，对于使用了@Cacheable标注的方法，Spring在每次执行前都会检查Cache中是否存在相同key的缓存元素，
	  * 如果存在的话就不再执行该方法，而是直接从缓存中获取结果进行返回，否则才会执行并将返回结果存入指定的缓存中，@CachePut也可以声明一个方法支持缓存功能。
	  * 与@Cacheable不同的是使用@CachePut标注的方法在执行前不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。
	  */
	 @CachePut("user") // 与Cacheable区别就是Cacheable先看缓存如果有，直接缓存换回，CachePut则是每次都会调用并且把返回值放到缓存
	 public User getUser2(Long userId){
		 System.out.println("查询数据库:userId:" + userId);
		 return userMap.get(userId);
	 }
	 
	 
	 /*
	  * @CacheEvict是用来标注在需要清除缓存元素的方法或类上的。当标记在一个类上的时候表示其中所有的方法的执行都会触发缓存的清除操作。
	  * @CacheEvict可以指定的属性有value、key、condition、allEntries和beforeInvocation。其中value、key和condition的语义与@Cacheable对应的属性类似。
	  * 即value表示清除操作是发生在哪些Cache上的（对应Cache的名称）；key表示需要清除的是哪个key，如未指定则会使用默认策略生成的key；condition表示清除操作发生的条件
	  */
	 @CacheEvict("user")
	 public void removeFromCache(Long userId){
		 return;
	 }
}
