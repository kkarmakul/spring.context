package edu.sibinfo.spring.basic.module05;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sibinfo.spring.basic.module05.util.CommonUtil;

public class Application {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("edu.sibinfo.spring.basic")) {
			CustomInitDestroy bean1 = ctx.getBean(CustomInitDestroy.class);
			CustomInitDestroyIfc bean2 = ctx.getBean(CustomInitDestroyIfc.class);
			System.out.printf("Application.main: %s%n", bean1);
			CommonUtil.waitABit();
		}
	}

}
