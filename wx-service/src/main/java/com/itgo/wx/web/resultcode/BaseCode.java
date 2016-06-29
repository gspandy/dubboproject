package com.itgo.wx.web.resultcode;

public enum BaseCode {

	SUCCESS("0000","成功"),
	FAIL("-1","失败"),
	ERROR("9999","系统错误");
	
	private String code;
	
	private String message;
	
	private BaseCode(String code, String message){
		
		this.code = code;
		this.message = message;
	}
	
	public String getCode(){
		return this.code;
	}
	
	public String getMessage(){
		
		return this.message;
	}
}
