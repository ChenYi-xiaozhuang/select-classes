package cn.tedu.mybatis.mapper;

import cn.tedu.spring.entity.User;

//设计抽象方法的接口文件
public interface UserMapper {
	//1.根据name查找该用户
	User findByName(String name);
	
	
	//2.将用户信息添加到user表中
	void addUser(User user);
	
	

}
