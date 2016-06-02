package com.itgo.mxsm;

import java.util.Map;

/**
 * 认证接口
 * @author itgo
 *
 */

public interface Authentication {

	/**
	 * 认证
	 * @param obj
	 * @return 认证成功返回true 失败返回false
	 */
	boolean auth(Object obj);
}
