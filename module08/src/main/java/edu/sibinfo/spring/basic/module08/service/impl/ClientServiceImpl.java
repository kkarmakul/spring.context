package edu.sibinfo.spring.basic.module08.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module08.dao.ClientDao;
import edu.sibinfo.spring.basic.module08.domain.Client;
import edu.sibinfo.spring.basic.module08.service.ClientRegisteredEvent;
import edu.sibinfo.spring.basic.module08.service.ClientService;

@Service
@Async("serviceExecutor")
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private ApplicationEventPublisher publisher;
	@Autowired
	private MessageDigest encoder;

	@Override
	public Future<Client> register(String firstName, String familyName, String phone) {
		Client client = new Client(familyName, firstName, phone);
		clientDao.save(client);
		publisher.publishEvent(new ClientRegisteredEvent(client));
		return new AsyncResult<Client>(client);
	}

	@Override
	public void setPassword(Client client, String password) {
		client.setPassword(encoder.digest(
				password.getBytes(StandardCharsets.UTF_8)));
		clientDao.save(client);		
	}
	
	
}
