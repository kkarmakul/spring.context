package edu.sibinfo.spring.basic.module08;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.sibinfo.spring.basic.module08.domain.Client;
import edu.sibinfo.spring.basic.module08.service.ClientService;

public class Application {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		try (ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext("edu.sibinfo.spring.basic")) {
			ClientService clientService = ctx.getBean(ClientService.class);
			for (int i = 0; i < 20; ++i) {
				Future<Client> client = clientService.register("Luke " + i, "Ford", "+7923988956" + i);
				if (i % 7 == 0) {
					clientService.setPassword(client.get(), "ad6123s%" + i);				
				}
			}
		}
	}
}
