package edu.sibinfo.spring.basic.module04.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module04.dao.ClientDao;
import edu.sibinfo.spring.basic.module04.domain.Client;
import edu.sibinfo.spring.basic.module04.service.ClientService;
import edu.sibinfo.spring.basic.module04.service.SmsService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private SmsService smsService;
	@Autowired
	private MessageDigest encoder;

	@PostConstruct
	public void init() {
		System.out.printf("Initialized with:%n ClientDAO: %s,%n SmsService: %s,%n Encoder: %s%n", clientDao, smsService, encoder);
	}
	
	public Client register(String firstName, String familyName, String phone) {
		Client client = new Client(familyName, firstName, phone);
		clientDao.save(client);
		smsService.send(phone, String.format("%s %s, you were registered", familyName, firstName));
		return client;
	}

	@Override
	public void setPassword(Client client, String password) {
		client.setPassword(encoder.digest(password.getBytes(StandardCharsets.UTF_8)));
		clientDao.save(client);		
	}
}
