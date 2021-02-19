<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

		<form id="form_reg">
			<fieldset>
				<legend>注册</legend>
				姓名：<input name="name" id="username"/> 
				<span id="name_error"></span><br>
				密码：<input name="password"/> <br>
				邮箱：<input name="mail"/> <br>
				年龄：<input name="age"/> <br>
				手机：<input name="phone"/> <br>
				<input type="button"  value="注册" onclick="doReg()"/>
			</fieldset>
		</form>
</body>

<script type="text/javascript" 
   src="${pageContext.request.contextPath}/jquery-3.3.1.min.js"></script>

<script type="text/javascript">
	function doReg(){
		//获取用户名输入框和密码输入框中的数据
		//1.给用户名和密码输入框加id
		//2.使用id选择器获取2个输入框中的值
		//var username = $("#username").val();
		//var password =$("#pwd").val();
		//3.将所有参数进行拼接   name=tom&pwd=123
	var data = $("#form_reg").serialize();
	
		$.ajax({
			"url":"toreg.do",     //向后台发送的请求路径
			"data":data,                   //向后台提交的数据
			"type":"POST",          //请求方式
			"dataType":"json",     // 后台返回的处理结果的数据格式
			"success":function(obj){  //参数obj就是后台响应的结果数据
				if(obj.state==1){
					//登录成功，重定向到主页面
					alert("注册成功");
					location.href="../user/login.do";
				}else if(obj.state==-3){
					//用户名不存在
					//alert(obj.message);
					$("#name_error").html(obj.message);
				}
			}
		})
		
	}
	</script>
</html>