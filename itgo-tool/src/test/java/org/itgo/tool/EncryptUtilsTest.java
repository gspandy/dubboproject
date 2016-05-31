package org.itgo.tool;

import org.junit.Test;

public class EncryptUtilsTest {

	@Test
	public void test() {
		
		String a = EncryptUtils.encryptSHA1("aaaaaaaaaa");
		System.out.println(a);
		
	}

}
