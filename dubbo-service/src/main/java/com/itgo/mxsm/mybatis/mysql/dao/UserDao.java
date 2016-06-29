package com.itgo.mxsm.mybatis.mysql.dao;

import java.util.Map;

/**
 * 用户接口
 * @author itgo
 *
 */

public interface UserDao {

	/**
	 * 添加用户
	 * @param params
	 * @return 返回用户Id
	 */
	int addUser(Map<String, String> params);
	
	/**
	 * 用户登录系统
	 * @param params
	 * @return 成功返回true 错误返回false
	 */
	boolean login(Map<String, String> params);
	
	/**
	 * 退出系统
	 * @param params
	 * @return
	 */
	boolean logout(Map<String, String> params);
	
}
