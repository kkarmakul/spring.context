package edu.sibinfo.spring.basic.module08.service.impl;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module08.domain.Client;
import edu.sibinfo.spring.basic.module08.service.ClientRegisteredEvent;

@Service
public class SmsServiceImpl {

	@Async
	@EventListener
	public void sendRegistrationNotification(ClientRegisteredEvent event) {
		Client client  = event.getClient();
		System.out.printf("[%d] %s : \"%s, you were registered\"", getThreadId(),  
				client.getMobile(), client.getFirstName()).println();;
	}
	
	private long getThreadId() {
		return Thread.currentThread().getId();
	}
}
