package cn.tedu.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//拦截器，做登录验证
public class LoginInterceptor  implements HandlerInterceptor{
     
	//重写HandlerInterceptor中的三个方法
	//执行时间 运行在DispatcherServlet之后，在每个controller之前
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//从session获取看是否有user，如果有，代表已经登录了，否则没有登录
		HttpSession session = request.getSession();
		if(session.getAttribute("user")==null){
			//没有登录，则拦截，重定向到登录页面    
			response.sendRedirect("../user/login.do");  
			return false;
		}else{
			//登录过了，则放行
			return true;
		}
	}

	//执行时间： 在controller执行之后
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}
    //执行时间 ： 最后，也就是视图已经渲染出来
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

	
	
	

}
