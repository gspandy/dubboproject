package com.alibaba.dubbo.test;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

	public static void main(String[] args) {
		//String path = "G:\\MyEclipseWorkSpace\\itgo-parent\\dubbo-service\\target\\classes\\dubboconfig\\spring-dubbo-provider.xml";
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("classpath:dubboconfig/spring-dubbo-provider.xml");
        context.start();
 
        try {
        	System.out.println(111);
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 按任意键退出
	}
	
}
