package com.itgo.wx.utils;

import static org.junit.Assert.*;
import org.junit.Test;

import com.itgo.wx.web.resultcode.RegisterCode;

public class RegexpUtilsTest {

	@Test
	public void test() {
		String email = "375808041@qq.com";
		assertEquals(true, RegexpUtils.isEmail(email));
		
	}

}
