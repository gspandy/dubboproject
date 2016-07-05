package com.itgo.wx.service.interfaces;

import java.util.Map;

import com.itgo.wx.web.resultcode.RegisterCode;

/**
 * 用户服务接口
 * @author mxsm
 *
 */

public interface UserService {

	/**
	 * 用户注册服务
	 * @param params
	 * @return 
	 */
	public RegisterCode registerService(Map<String, String> params);
	
}
