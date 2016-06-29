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
	
	/**
	 * 用户注册
	 * @param params 包涵用户的注册信息
	 * @return 0注册失败 , 1注册成功
	 */
	String register(Map<String, String> params);
	
	/**
	 * 来源数据类型为xml认证
	 * @param xml
	 * @return
	 */
	boolean authByXML(String xml);
	
	/**
	 * 来源数据类型为JSON认证
	 * @param xml
	 * @return
	 */
	boolean authByJSON(String xml);
}
