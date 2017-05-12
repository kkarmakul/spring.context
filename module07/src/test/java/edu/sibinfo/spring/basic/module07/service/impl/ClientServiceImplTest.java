package edu.sibinfo.spring.basic.module07.service.impl;

import static org.junit.Assert.*;

import java.security.MessageDigest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.AdditionalMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import edu.sibinfo.spring.basic.module07.dao.ClientDao;
import edu.sibinfo.spring.basic.module07.domain.Client;
import edu.sibinfo.spring.basic.module07.service.SmsService;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceImplTest {

	@Mock
	private ClientDao clientDao;
	@Mock
	private SmsService smsService;
	@Mock
	private MessageDigest encoder;

	@InjectMocks
	ClientServiceImpl service;
	
	@Test
	public void testSetPassword() {
		String password = "asdkl;f";
		Client client = new Client("A", "B", "C");
		
		byte[] passwordEncoded = {3,4};
		Mockito.when(encoder.digest(AdditionalMatchers.aryEq(password.getBytes())))
			.thenReturn(passwordEncoded);
		
		service.setPassword(client, password);
		
		assertArrayEquals(passwordEncoded, client.getPassword());
		
		Mockito.verify(encoder).digest(password.getBytes());
		Mockito.verify(clientDao).save(client);
	}

}
