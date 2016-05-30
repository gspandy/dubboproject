package com.alibaba.dubbo.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.demo.DemoService;

public class Consumer {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		//String path = "G:/MyEclipseWorkSpace/itgo-parent/dubbo-service Maven Webapp/src/main/java/dubboconfig/";
		ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("classpath:dubboconfig/spring-dubbo-consume.xml");
        context.start();
 
        DemoService demoService = (DemoService)context.getBean("demoService"); // 获取远程服务代理
        String hello = demoService.sayHello("啊啊啊啊啊"); // 执行远程方法
 
        System.out.println( hello ); // 显示调用结果
        
	}
	
}
