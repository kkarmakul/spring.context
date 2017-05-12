package edu.sibinfo.spring.basic.module08.service.impl;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module08.domain.Client;
import edu.sibinfo.spring.basic.module08.service.ClientRegisteredEvent;
import edu.sibinfo.spring.basic.module08.util.Log;

@Service
public class SmsServiceImpl {

	@Async("eventExecutor")
	@EventListener
	public void clientRegisteredHandler(ClientRegisteredEvent event) {
		Client client = event.getClient();
		send(client.getMobile(), String.format("%s %s, you were registered",
				client.getFamilyName(), client.getFirstName()));
	}
	
	private void send(String mobile, String text) {
		Log.log("%s : \"%s\"", mobile, text);
	}
}
