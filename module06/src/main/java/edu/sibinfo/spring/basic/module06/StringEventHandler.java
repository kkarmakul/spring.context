package edu.sibinfo.spring.basic.module06;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class StringEventHandler {
	@Async
	@EventListener
	public void handleEvent(String message) {
		System.out.printf("StringEventHandler.handleEvent(%s): %s%n",  Thread.currentThread().getName(), message);
	}
}
