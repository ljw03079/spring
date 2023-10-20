package com.yedam.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		//컨테이너 : 특정시점에 클래스가 필요하면 bean을 불러옴
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		//컨테이너 내 bean : 싱글톤(프로젝트 내 유일)
		
		TV tv = (TV) ctx.getBean("tv");
		tv.on();
	}
}
