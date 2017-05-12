package edu.sibinfo.spring.basic.module09.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.common09.domain.Client;
import edu.sibinfo.spring.basic.module09.service.ClientRegisteredEvent;

@Service
@Profile("default")
public class InternalSmsService {
	private static final Logger log = LoggerFactory.getLogger(InternalSmsService.class);

	@EventListener
	public void sendRegistrationNotification(ClientRegisteredEvent event) {
		Client client  = event.getClient();
		log.debug("{} : \"{}, you were registered\"", 
				client.getMobile(), client.getFirstName());
	}
}
