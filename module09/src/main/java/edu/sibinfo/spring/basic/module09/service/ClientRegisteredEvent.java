package edu.sibinfo.spring.basic.module09.service;

import edu.sibinfo.spring.basic.common09.domain.Client;

public class ClientRegisteredEvent {
	private final Client client;

	public ClientRegisteredEvent(Client client) {
		super();
		this.client = client;
	}

	public Client getClient() {
		return client;
	}  
}
