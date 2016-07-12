package com.itgo.wx.service.interfaces.impl;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import com.itgo.wx.utils.RegexpUtils;
import com.itgo.wx.web.resultcode.RegisterCode;

/**
 * 用户注册服务
 * @author mxsm
 * @param <K>
 *
 */
public class UserRegisterService<K> extends AbstractUserService<RegisterCode, K>{
	
	protected static final String REGISTER_SUCCESS = "1"; //注册成功
	
	@Override
	public RegisterCode registerService(Map<String, String> params) {
		// TODO Auto-generated method stub
		RegisterCode code = before(params);
		
		if(code.ordinal() != RegisterCode.AUTH_SUCCESS.ordinal()){
			return code;
		}
		String resutl = mrgSystemAuthentication.register(params);
		return REGISTER_SUCCESS.equals(resutl)?RegisterCode.REGISTER_SUCCESS:RegisterCode.REGISTER_FAIL;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public RegisterCode before(Object obj) {
		// TODO Auto-generated method stub
		
		if(!(obj instanceof Map<?, ?>)){
			if(logger.isErrorEnabled()){
				logger.error("参数不是Map");
			}
			throw new IllegalArgumentException("参数错误");
		}
		Map<String, String> params = (Map<String, String>)obj;
		if(logger.isInfoEnabled()){
			logger.info("注册提交的参数："+params);
		}
		
		String username = params.get("username");
		if(StringUtils.isEmpty(username) || username.trim().length() == 0){
			if(logger.isWarnEnabled()){
				logger.warn("username 参数不存在!");
			}
			return RegisterCode.USERNAME_NOT_EXSIT;

		}
		String email = params.get("email");
		if(StringUtils.isEmpty(email) || email.trim().length() == 0){
			if(logger.isWarnEnabled()){
				logger.warn("email 参数不存在!");
			}
			return RegisterCode.EMAIL_NOT_EXSIT;
		}
		if(!RegexpUtils.isEmail(email)){
			if(logger.isWarnEnabled()){
				logger.warn("email 格式错误!");
			}
			return RegisterCode.MEAIL_LAYOUT_ERROR;
		}
		String password = params.get("password");
		String confirmPassword = params.get("confirmPassword");
		if(!StringUtils.equals(password, confirmPassword)){
			if(logger.isWarnEnabled()){
				logger.warn("密码不一致!");
			}
			return RegisterCode.PASSWORD_NOT_FIT;
		}
		return RegisterCode.AUTH_SUCCESS;
	}
}
