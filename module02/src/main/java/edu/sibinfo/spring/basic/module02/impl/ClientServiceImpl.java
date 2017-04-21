package edu.sibinfo.spring.basic.module02.impl;

import edu.sibinfo.spring.basic.module02.Client;
import edu.sibinfo.spring.basic.module02.ClientDao;
import edu.sibinfo.spring.basic.module02.ClientService;
import edu.sibinfo.spring.basic.module02.SmsService;

public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;
	private SmsService smsService;

	public ClientServiceImpl(ClientDao clientDao, SmsService smsService) {
		super();
		this.clientDao = clientDao;
		this.smsService = smsService;
	}

	public void register(String firstName, String familyName, String phone) {
		clientDao.save(new Client(familyName, firstName, phone));
		smsService.send(phone, String.format("%s %s, you were registered", familyName, firstName));
	}
}
