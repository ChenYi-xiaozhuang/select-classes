package cn.tedu.spring.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.mybatis.mapper.UserMapper;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.UserService;
import cn.tedu.spring.service.exception.NameAlreadyUseException;
import cn.tedu.spring.service.exception.PasswordNotMatchException;
import cn.tedu.spring.service.exception.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService{
	//注解获取导入数据库
	@Autowired
	private UserMapper mapper;
	
	public void reg(User user) {
		//调用数据库层的findByName方法查找该用户
		User u=mapper.findByName(user.getName());
		
		//判断该用户是否已被占用
		if(u==null) {
			//如果没有被占用，则调用数据库层的addUser方法
			mapper.addUser(user);
		}else {
			//如果被占用，则抛出“用户已被占用”异常
			throw new NameAlreadyUseException("用户名已被占用");
		}
		
		
		
		
		
	}
	
	

	public User login(String name,String password) {
		User u=mapper.findByName(name);
		
	
		if(u==null) {
			throw new UserNotFoundException("用户名不存在");
		}else {
			if(u.getPassword().equals(password)) {
				return u ;
			}else {
				throw new PasswordNotMatchException("密码不正确");
			}
		}
		
	}
}
