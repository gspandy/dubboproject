package org.itgo.tool;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;

/**
 * 加密工具
 * @author itgo
 *
 */

public class EncryptUtils {

	/**
	 * SHA1 加密
	 * @param st 需要加密的字符串
	 * @return 返回加密后的字符串 或者 null
	 */
	public static String encryptSHA1(String st){
		
		if (StringUtils.isEmpty(st) || st.trim().length() == 0) {
			return null;
		}

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(st.getBytes("UTF-8"));
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return (new String(buf)).toUpperCase();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
