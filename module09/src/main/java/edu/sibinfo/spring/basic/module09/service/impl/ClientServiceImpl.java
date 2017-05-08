package edu.sibinfo.spring.basic.module09.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module09.dao.ClientDao;
import edu.sibinfo.spring.basic.module09.domain.Client;
import edu.sibinfo.spring.basic.module09.service.ClientRegisteredEvent;
import edu.sibinfo.spring.basic.module09.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private MessageDigest encoder;
	@Autowired 
	private ApplicationEventPublisher publisher;

	public Client register(String firstName, String familyName, String phone) {
		Client client = new Client(familyName, firstName, phone);
		clientDao.save(client);
		publisher.publishEvent(new ClientRegisteredEvent(client));
		return client;
	}

	@Override
	public void setPassword(Client client, String password) {
		client.setPassword(encoder.digest(password.getBytes(StandardCharsets.UTF_8)));
		clientDao.save(client);		
	}
}
