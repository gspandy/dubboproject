package com.itgo.wx.utils;

import java.util.Arrays;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.itgo.tool.EncryptUtils;

/**
 * 微信服务器URL校验工具
 * @author itgo
 *
 */

public class WxServerVerifyTool {

	public static final String 	SIGNATURE = "signature";
	public static final String 	TIMESTAMP = "timestamp";
	public static final String 	NONCE = "nonce";
	public static final String 	TOKEN = "token";
	
	protected static final Logger logger = LogManager.getLogger(WxServerVerifyTool.class);
	
	/**
	 * 校验微信服务器的有效性
	 * @param signature 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
	 * @param timestamp 时间戳
	 * @param nonce 随机数
	 * @param token 随机字符串
	 * @return 验证成功返回true 验证失败返回false
	 */
	public static boolean VerifyServer(String signature, String timestamp, String nonce, String token){
		
		logger.info("参数signature："+signature + " " +"参数timestamp："+timestamp + " " +"参数nonce："+nonce + " " +"参数token："+token);
		
		boolean flag = StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce) ||StringUtils.isEmpty(token);
		if(flag){
			return false;
		}
		//将token、timestamp、nonce三个参数进行字典序排序
		String[] arrys = new String[]{timestamp, nonce,token};
		Arrays.sort(arrys);
		StringBuffer st = new StringBuffer();
		
		for(int i = 0, j = arrys.length; i < j; ++i){
			st.append(arrys[i]);
		}
		logger.info("将token、timestamp、nonce三个参数进行字典序排序后组成的字符串："+st.toString());
		String encode = EncryptUtils.encryptSHA1(st.toString());
		
		logger.info("SHA1加密后的字符串："+encode);
		if(StringUtils.equals(signature, encode)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 校验微信服务器的有效性
	 * @param map key包含：signature, timestamp, nonce, token
	 * @return 验证成功返回true 验证失败返回false
	 */
	public static boolean VerifyServer(Map<String, String> map){
		
		logger.info("输入的参数："+map);
		
		if(MapUtils.isEmpty(map)){
			return false;
		}
		
		String signature = MapUtils.getString(map, SIGNATURE);
		String timestamp = MapUtils.getString(map, TIMESTAMP);
		String nonce = MapUtils.getString(map, NONCE);
		String token = MapUtils.getString(map, TOKEN); 
		
		//校验是否为null
		boolean flag = StringUtils.isEmpty(signature) || StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce) ||StringUtils.isEmpty(token);
		
		if(flag){
			return false;
		}
		return VerifyServer(signature, timestamp, nonce, token);
	}
	
	/**
	 * 校验微信服务器的有效性
	 * @param args 长度为4 分别为：signature, timestamp, nonce, echostr对应的值
	 * @return 验证成功返回true 验证失败返回false
	 */
	public static boolean VerifyServer(String ...args){
		
		logger.info("输入的参数："+Arrays.toString(args));
		if(args == null || args.length < 4){
			return false;
		}
		
		return VerifyServer(args[0], args[1], args[2], args[3]);
	}
	
}
