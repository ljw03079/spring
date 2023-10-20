package com.yedam.app.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//restaurant 이름이 없으니 class로 bean을 불러옴. (bean : 싱클톤)
		Restaurant res = (Restaurant) ctx.getBean(Restaurant.class);
		res.open();
	}
}
