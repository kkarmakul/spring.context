package edu.sibinfo.spring.basic.module06;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sibinfo.spring.basic.module06.service.ClientService;

public class Application {
	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("edu.sibinfo.spring.basic")) {
			ApplicationConfig applicationConfig = ctx.getBean(ApplicationConfig.class);
			System.out.printf("Application.main: JAVA_HOME: %s%n", applicationConfig.getJavaHome());
			System.out.printf("Application.main: OAuth URL: %s%n", applicationConfig.getOauthURL());

			ClientService clientService = ctx.getBean(ClientService.class);
			clientService.register("Luke", "Ford", "+79239889568");
			clientService.register("John", "Smith", "+79132354312");
			clientService.register("Sam", "Bush", "+79239872348");
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
