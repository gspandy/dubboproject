package com.alibaba.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.demo.DemoService;

public class DemoServiceImpl implements DemoService{

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		 ClassPathXmlApplicationContext a = null;
		 return "Hello " + name;
		
	}

}
