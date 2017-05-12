package edu.sibinfo.spring.basic.module06.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module06.dao.ClientDao;
import edu.sibinfo.spring.basic.module06.domain.Client;
import edu.sibinfo.spring.basic.module06.service.ClientService;
import edu.sibinfo.spring.basic.module06.service.SmsService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private SmsService smsService;

	public Client register(String firstName, String familyName, String phone) {
		Client client = new Client(familyName, firstName, phone);
		clientDao.save(client);
		smsService.send(phone, String.format("%s %s, you were registered", familyName, firstName));
		return client;
	}
}
