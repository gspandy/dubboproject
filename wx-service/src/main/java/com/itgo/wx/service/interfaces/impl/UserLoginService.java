package com.itgo.wx.service.interfaces.impl;

import java.util.Map;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.itgo.wx.web.resultcode.LoginCode;

public class UserLoginService<K> extends AbstractUserService<LoginCode, K>{

	@Override
	public LoginCode loginService(Map<String, String> params) {
		// TODO Auto-generated method stub
		if(before(params).ordinal() != LoginCode.LOGIN_PARAMTER_AUTH_SUCCESS.ordinal()){
			return LoginCode.LOGIN_PARAMTER_AUTH_FAIL;
		}
		boolean isSuccess = mrgSystemAuthentication.auth(params);
		return isSuccess? LoginCode.LOGIN_SUCCESS : LoginCode.LOGIN_FAIL;
	}
	
	@Override
	public final LoginCode before(Object obj) {
		// TODO Auto-generated method stub
		if(!(obj instanceof Map<?, ?>)){
			if(logger.isErrorEnabled()){
				logger.error("参数不是Map");
			}
			throw new IllegalArgumentException("参数错误");
		}
		
		@SuppressWarnings("unchecked")
		Map<String, String> params = (Map<String, String>)obj;
		if(logger.isInfoEnabled()){
			logger.info("参数："+params);
		}
		String username = params.get("username");
		if(StringUtils.isEmpty(username) || username.trim().length() == 0){
			if(logger.isErrorEnabled()){
				logger.error("username参数不存在！");
			}
			
			return LoginCode.LOGIN_NAME_NOT_EXIST;
		}
		String password = params.get("password");
		if(StringUtils.isEmpty(password) || password.trim().length() == 0){
			if(logger.isErrorEnabled()){
				logger.error("password参数不存在！");
			}
			
			return LoginCode.LOGIN_PASSWORD_NOT_EXIST;
		}
		//将明文加密
		String encoded = Hex.encodeHexString(DigestUtils.md5(password)).toUpperCase();
		if(logger.isInfoEnabled()){
			logger.info("password MD5加密后的密文："+encoded);
		}
		params.put("password", encoded);
		
		return LoginCode.LOGIN_PARAMTER_AUTH_SUCCESS;
	}

}
