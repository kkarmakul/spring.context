package edu.sibinfo.spring.basic.module09;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import edu.sibinfo.spring.basic.module09.domain.Client;
import edu.sibinfo.spring.basic.module09.service.ClientService;

@SpringBootApplication
public class Module09Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(Module09Application.class, args);
		ClientService clientService = ctx.getBean(ClientService.class);
		clientService.register("Luke", "Ford", "+79239889568");
		Client johnSmith = clientService.register("John", "Smith", "+79132354312");
		clientService.setPassword(johnSmith, "ad6123s%");
		clientService.register("Sam", "Bush", "+79239872348");		
	}
}
