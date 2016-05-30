package com.alibaba.dubbo.demo.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		String path = "G:\\MyEclipseWorkSpace\\itgo-parent\\dubbo-service\\target\\classes\\dubboconfig\\spring-dubbo-provider.xml";
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("spring-dubbo-provider.xml");
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
