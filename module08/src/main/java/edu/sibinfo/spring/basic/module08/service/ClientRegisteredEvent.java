package edu.sibinfo.spring.basic.module08.service;

import edu.sibinfo.spring.basic.module08.domain.Client;

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
