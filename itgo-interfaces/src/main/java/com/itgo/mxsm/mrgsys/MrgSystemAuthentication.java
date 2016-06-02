package com.itgo.mxsm.mrgsys;

import java.util.Map;

import com.itgo.mxsm.Authentication;

public interface MrgSystemAuthentication extends Authentication {

	/**
	 * 管理系统用户登录认证
	 * @param name
	 * @param pwd
	 * @return 认证成功返回true 否则返回false
	 */
	boolean auth(String name, String pwd);
	
	/**
	 * 管理系统用户登录认证
	 * @param params
	 * @return 认证成功返回true 否则返回false
	 */
	boolean auth(Map<String, String> params);
}
