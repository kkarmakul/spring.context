package edu.sibinfo.spring.basic.module02.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sibinfo.spring.basic.module02.Client;
import edu.sibinfo.spring.basic.module02.ClientDao;
import edu.sibinfo.spring.basic.module02.ClientService;
import edu.sibinfo.spring.basic.module02.SmsService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientDao clientDao;
	@Autowired
	private SmsService smsService;

	public void register(String firstName, String familyName, String phone) {
		clientDao.save(new Client(familyName, firstName, phone));
		smsService.send(phone, String.format("%s %s, you were registered", familyName, firstName));
	}
}
