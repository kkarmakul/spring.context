package edu.sibinfo.spring.basic.module08.service;

import java.util.concurrent.Future;

import edu.sibinfo.spring.basic.module08.domain.Client;

public interface ClientService {
	Future<Client> register(String firstName, String familyName, String phone);

	void setPassword(Client client, String password);
}
