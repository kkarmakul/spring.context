package edu.sibinfo.spring.basic.module02;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Application {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new GenericXmlApplicationContext(
				new ClassPathResource("app-context.xml"))) {
			ClientService clientService = ctx.getBean(ClientService.class);
			clientService.register("John", "Smith", "+79132354312");
			clientService.register("Sam", "Bush", "+79239872348");
		}
	}

}
