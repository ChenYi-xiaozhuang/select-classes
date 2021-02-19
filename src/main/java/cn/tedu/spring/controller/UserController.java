package cn.tedu.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.spring.entity.ResponseResult;
import cn.tedu.spring.entity.User;
import cn.tedu.spring.service.exception.NameAlreadyUseException;
import cn.tedu.spring.service.exception.PasswordNotMatchException;
import cn.tedu.spring.service.exception.UserNotFoundException;
import cn.tedu.spring.serviceimpl.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

@Autowired
private UserServiceImpl service;
	//自定义方法（控制器），处理reg.do请求，显示reg.jsp页面
	
	@RequestMapping("/reg.do")
	public String showReg() {
		return "reg";//reg.jsp
	}
	//自定义方法，处理login.do请求，显示登录页面login.jsp
	@RequestMapping("/login.do")
	
	public String showLogin() {
		return "login";//responserbody返回普通字符串，不能处理中文问题
	}
	
	
	//自定义方法，处理toreg.do请求
	@RequestMapping("/toreg.do")
    @ResponseBody
	public ResponseResult toreg(User user,ModelMap model,HttpSession session) {
		//1.获取页面中的参数
		System.out.println(user);
		ResponseResult rs=new ResponseResult();
		
		service.reg(user);
		/*
		 * 假如调用业务层的reg方法抛出了用户名被占用异常
		 * 则代码会跳转到BaseController中的处理异常的方法里进行异常处理
		 */
		rs.setState(1);
		return rs;
		//2.调用业务层处理注册逻辑
		//会有两种结果1.注册成功 void  2.抛出用户名被占用异常
//		try {
//			service.reg(user);
//			String name=user.getName();
//			session.setAttribute("user", name);
//			//代码走到这，代表注册成功，则重定向到登录页面
//			//return "redirect:login.do";
//			
//			rs.setState(1);
//			return rs;
//			
//		}catch(NameAlreadyUseException e){
//			//代码走到这，代表用户名被占用，则转发异常信息到error.jsp页面
//			//model.addAttribute("error",e.getMessage());
//			//return "error";
//			
//			rs.setState(-3);
//			rs.setMessage("用户名被占用");
//			return rs;
//		}
		
			
		}
	//自定义方法，处理tologin.do请求
	@RequestMapping("/tologin.do")
	@ResponseBody
	public ResponseResult tologin(String name,String password,ModelMap model,HttpSession session) {
		
		//定义resopnseResult对象，用它来封装响应结果
		ResponseResult rs=new ResponseResult();
		service.login(name, password);//此行出现异常，则会跳转至BaseController
		session.setAttribute("user", name);
		rs.setState(1);
		return rs;
//		try {
//			
//			service.login(name,password);
//			//将用户名绑定到session上
//			session.setAttribute("user", name);
//			//代码走到这，代表注册成功，则重定向到登录页面
////			return "redirect:../main/index.do";
//			
//			//登陆成功，则给浏览器响应状态码1
////			{"state":1}
//			//return "{\"state\":1}";
//			rs.setState(1);
//			return rs;
//		}catch(UserNotFoundException e){
//			//代码走到这，代表用户名被占用，则转发异常信息到error.jsp页面
////			model.addAttribute("error",e.getMessage());
////			return "error";
//			
//			//如果用户名不存在，则给浏览器响应状态码-1，及响应异常messa
//			//return "{\"state\":-1,\"msg\":\"用户名不存在\"}";
//			rs.setState(-1);
//			rs.setMessage("用户名不存在");
//			return rs;
//		}catch(PasswordNotMatchException e) {
////			model.addAttribute("error",e.getMessage());
////			return "error";
//			//如果登录时，密码错误，则给浏览器响应状态码-2，及响应一个异常message
//			//return "{\"state\":-2,\"msg\":\"密码错误\"}";
//			rs.setState(-2);
//			rs.setMessage("密码错误");
//			return rs;
//		}
		
	}

}
