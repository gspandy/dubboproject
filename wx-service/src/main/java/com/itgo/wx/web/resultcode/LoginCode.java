package com.itgo.wx.web.resultcode;

/**
 * 登录code
 * @author mxsm
 *
 */

public enum LoginCode {
	
	LOGIN_SUCCESS("0000","登录成功"),
	LOGIN_NAME_NOT_EXIST("0001","用户名为空"),
	LOGIN_PASSWORD_NOT_EXIST("0002","密码为空"),
	LOGIN_PARAMTER_AUTH_SUCCESS("0003","参数认证成功"),
	LOGIN_PARAMTER_AUTH_FAIL("0004","缺少参数"),
	LOGIN_FAIL("9999","登录失败"),
	;

	private String code;
	
	private String message;
	
	private LoginCode(String code, String message){
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
