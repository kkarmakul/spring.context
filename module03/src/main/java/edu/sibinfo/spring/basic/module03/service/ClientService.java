package edu.sibinfo.spring.basic.module03.service;

import edu.sibinfo.spring.basic.module03.domain.Client;

public interface ClientService {
	Client register(String firstName, String familyName, String phone);

	void setPassword(Client client, String password);
}
