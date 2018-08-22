package cn.itcast.springboot.javaconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service   // 该注解就表示是一个加入到了spring容器中的一个bean   只有都是spring容器 中的bean才可以通过@Autowired互相注入
public class UserService {

    @Autowired
    //注入spring容器中的bean对象（也就是通过@Autowired该注解，将UserDAO对象注入进来）
    private UserDAO userDAO;

    public List<User> queryUserList() {
        // 调用userDAO中的方法进行查询
        return this.userDAO.queryUserList();
    }

}
