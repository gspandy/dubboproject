package com.itgo.wx.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * 正则表达工具
 * @author mxsm
 *
 */

public class RegexpUtils {

	public static final String EMAIL_REG = "([\\w-_]+(?:\\.[\\w-_]+)*)@((?:[a-z0-9]+(?:-[a-zA-Z0-9]+)*)+\\.[a-z]{2,6})"; //"[0-9a-zA-Z]+@[0-9a-zA-Z]+\\.[0-9a-zA-Z]+";
	
	/**
	 * 判断传入的是否为电子邮件字符串
	 * @param email
	 * @return 是电子邮件字符串返回true 否则返回false
	 */
	public static boolean isEmail(String email){
		if(StringUtils.isEmpty(email) || email.trim().length() == 0){
			return false;
		}
		Pattern emailPattern = Pattern.compile(EMAIL_REG);
		Matcher matcher = emailPattern.matcher(email);
		
		return matcher.matches();

	}
	
}
