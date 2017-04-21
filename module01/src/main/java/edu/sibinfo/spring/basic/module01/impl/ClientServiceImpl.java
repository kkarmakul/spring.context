package edu.sibinfo.spring.basic.module01.impl;

import edu.sibinfo.spring.basic.module01.Client;
import edu.sibinfo.spring.basic.module01.ClientDao;
import edu.sibinfo.spring.basic.module01.ClientService;
import edu.sibinfo.spring.basic.module01.SmsService;

public class ClientServiceImpl implements ClientService {

	private ClientDao clientDao;
	private SmsService smsService;
	public void register(String firstName, String familyName, String phone) {
		clientDao.save(new Client(familyName, firstName, phone));
		smsService.send(phone, String.format("%s %s, you were registered", familyName, firstName));
	}

}
