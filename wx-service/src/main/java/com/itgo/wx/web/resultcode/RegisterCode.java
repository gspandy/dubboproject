package com.itgo.wx.web.resultcode;

public enum RegisterCode {
	AUTH_SUCCESS("0001","验证成功"),
	REGISTER_SUCCESS("0000","注册成功"),
	REGISTER_FAIL("0001","注册失败"),
	USERNAME_NOT_EXSIT("0001","注册用户名必填"),
	EMAIL_NOT_EXSIT("0002","注册电子邮件必填"),
	MEAIL_LAYOUT_ERROR("0003","电子邮件格式错误"),
	PASSWORD_NOT_FIT("0004","密码不一致");
	
	private String code;
	
	private String message;
	
	private RegisterCode(String code, String message){
		this.code = code;
		this.message = message;
	}
	
	public String code(){
		return this.code;
	}
	
	public String message(){
		return this.message;
	}
}
