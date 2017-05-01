package edu.sibinfo.spring.basic.module06.service;

import edu.sibinfo.spring.basic.module06.domain.Client;

public interface ClientService {
	Client register(String firstName, String familyName, String phone);
}
