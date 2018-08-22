/**
 * 
 */
package cn.itcast.springboot.javaconfig;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description
 * @Author jzy
 * @Date 2018年8月22日
 */

/**
 * 该类是为了模拟与数据库的交互  
 *  
 */
public class UserDAO {
	public List<User> queryUserList(){
		List<User> result = new ArrayList<User>();
		//模拟数据库的查询
		for (int i = 0; i < 10; i++) {
			User user = new User();
			user.setUsername("username_" + i);
			user.setPassword("password_" + i);
			user.setAge(i + 1);
            result.add(user);
		}
		return result;
	}
}
