package edu.sibinfo.spring.basic.module02;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("edu.sibinfo.spring.basic")) {
			ClientService clientService = ctx.getBean(ClientService.class);
			clientService.register("Luke", "Ford", "+79239889568");
			clientService.register("John", "Smith", "+79132354312");
			clientService.register("Sam", "Bush", "+79239872348");
		}
	}

}
