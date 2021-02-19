package cn.tedu.spring.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.spring.entity.ResponseResult;
import cn.tedu.spring.service.exception.NameAlreadyUseException;
import cn.tedu.spring.service.exception.PasswordNotMatchException;
import cn.tedu.spring.service.exception.ServiceException;
import cn.tedu.spring.service.exception.UserNotFoundException;

//所有控制器类的父类
public abstract class BaseController {

	//自定义方法，统一处理异常
	@ExceptionHandler
	@ResponseBody
	public ResponseResult handleException(ServiceException e){
//		定义responseResult对象用来封装给浏览器的响应结果
		ResponseResult rs= new ResponseResult();
		rs.setMessage(e.getMessage());
		if(e instanceof NameAlreadyUseException){
			rs.setState(-3);
		}else if(e instanceof UserNotFoundException){
			rs.setState(-1);
			
		}else if(e instanceof PasswordNotMatchException) {
			rs.setState(-2);
			
		}
		 return rs;
		 
		
	}
	

}
