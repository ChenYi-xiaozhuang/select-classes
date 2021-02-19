package cn.tedu.spring.service;

import cn.tedu.spring.entity.User;

public interface UserService {
	//定义处理的注册功能的业务层方法
	//业务层的参数是控制层传来的
	void reg(User user);
	
	User login(String name,String password);

	

}
