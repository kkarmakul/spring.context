package edu.sibinfo.spring.basic.module03.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module03.dao.ClientDao;
import edu.sibinfo.spring.basic.module03.domain.Client;
import edu.sibinfo.spring.basic.module03.service.ClientProcessor;
import edu.sibinfo.spring.basic.module03.service.ClientService;
import edu.sibinfo.spring.basic.module03.service.SmsService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private SmsService smsService;
	@Autowired
	private MessageDigest encoder;
	@Autowired
	private List<ClientProcessor> processors;

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

	@Override
	public void processAll() {
		Collection<Client> clients = clientDao.getAll();
		for (Client client : clients) {
			for (ClientProcessor processor : processors)
				processor.process(client);
		}
	}

	@Lookup(value="morningProcessor")
	public ClientProcessor getMorningProcessor() {
		return null; // Реализация сгенерируется автоматически 
	}
	
	@Override
	public void processMorning() {
		Collection<Client> clients = clientDao.getAll();
		ClientProcessor mProcessor = getMorningProcessor();
		for (Client client : clients) {
			mProcessor.process(client);
		}
	}		
}
