package cn.tedu.spring.entity;
//此类用来封装服务器端给浏览器端的相应数据


public class ResponseResult {
	private Integer state;//状态码
	private String message;//封装响应的消息
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ReponseResult [state=" + state + ", message=" + message + "]";
	}
	

	

}
