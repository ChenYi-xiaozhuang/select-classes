package testService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.mybatis.mapper.UserMapper;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.serviceimpl.UserServiceImpl;

public class TestReg {

	public static void main(String[] args) {
		//加载Spring配置文件，启动spring
				ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","applicationContext.xml");
				System.out.println(ac);
				UserServiceImpl service=ac.getBean("userServiceImpl", UserServiceImpl.class);
				
				//模拟数据
				User user=new User();
				user.setName("huanghuang");
				user.setPassword("234");
				service.reg(user);
				
				
	}

}
