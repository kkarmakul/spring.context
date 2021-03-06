package edu.sibinfo.spring.basic.module03;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sibinfo.spring.basic.module03.domain.Client;
import edu.sibinfo.spring.basic.module03.service.ClientService;

public class Application {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("edu.sibinfo.spring.basic")) {
			ClientService clientService = ctx.getBean(ClientService.class);
			clientService.register("Luke", "Ford", "+79239889568");
			Client johnSmith = clientService.register("John", "Smith", "+79132354312");
			clientService.setPassword(johnSmith, "ad6123s%");
			clientService.register("Sam", "Bush", "+79239872348");
			clientService.processMorning();
			clientService.processMorning();
			clientService.processMorning();
			clientService.processAll();
		}
	}

}
