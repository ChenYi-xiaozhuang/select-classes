package testDB;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mybatis.mapper.UserMapper;
import cn.tedu.spring.entity.User;

public class TestAddUser {
	public static void main(String[] args) {
		//加载Spring配置文件，启动spring
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		System.out.println(ac);
		
		//获取usermapper接口文件对象
		UserMapper mapper=ac.getBean("userMapper",UserMapper.class);
		
		User user=new User();
		user.setName("huanghuang");
		user.setPassword("555");
		user.setAge(23);
		mapper.addUser(user);
		System.out.println(user);
		
	}

}
