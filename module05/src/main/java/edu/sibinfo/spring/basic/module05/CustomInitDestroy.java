package edu.sibinfo.spring.basic.module05;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CustomInitDestroy {
	
	@Autowired
	private ApplicationContext appContext;
	
	@PostConstruct
	public void init() {
		System.out.printf("CustomInitDestroy.init: %s%n", appContext);
	}

	@PreDestroy // Не работает, если @Scope("prototype")
	public void destroy() {
		System.out.printf("CustomInitDestroy.destroy()%n");
	}
}
