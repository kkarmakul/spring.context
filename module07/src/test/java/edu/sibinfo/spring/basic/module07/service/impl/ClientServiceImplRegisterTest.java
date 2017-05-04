package edu.sibinfo.spring.basic.module07.service.impl;

import static org.junit.Assert.*;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import edu.sibinfo.spring.basic.module07.dao.ClientDao;
import edu.sibinfo.spring.basic.module07.domain.Client;
import edu.sibinfo.spring.basic.module07.service.SmsService;

@RunWith(Parameterized.class)
public class ClientServiceImplRegisterTest {

	private static final String FISRT_NAME = "Bob";
	private static final String FAMILY_NAME = "Jones";

	@Mock
	private ClientDao clientDao;
	@Mock
	private SmsService smsService;
	@Mock
	private MessageDigest encoder;

	@InjectMocks
	ClientServiceImpl service;

	@Parameterized.Parameter(0)
	public String firstName;
	@Parameterized.Parameter(1)
	public String familyName;

	@Parameterized.Parameters(name = "{index} {0} {1}")
	public static Collection<Object[]> init() {
		List<Object[]> result = new ArrayList<>();
		result.add(new Object[] { null, null });
		result.add(new Object[] { null, "" });
		result.add(new Object[] { null, FAMILY_NAME });
		result.add(new Object[] { "", null });
		result.add(new Object[] { "", "" });
		result.add(new Object[] { "", FAMILY_NAME });
		result.add(new Object[] { FISRT_NAME, null });
		result.add(new Object[] { FISRT_NAME, "" });
		result.add(new Object[] { FISRT_NAME, FAMILY_NAME });
		return result;
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testRegister() {
		String mobile = "237";

		Client client = service.register(firstName, familyName, mobile);

		if (firstName == null || firstName.isEmpty() || familyName == null || familyName.isEmpty()) {
			assertNull(client);

			Mockito.verify(clientDao, Mockito.never()).save(Matchers.any(Client.class));
			Mockito.verify(smsService, Mockito.never()).send(Matchers.anyString(), Matchers.anyString());
		} else {
			assertEquals(firstName, client.getFirstName());
			assertEquals(familyName, client.getFamilyName());
			assertEquals(mobile, client.getMobile());

			Mockito.verify(clientDao, Mockito.times(1)).save(client);
			Mockito.verify(clientDao).save(Matchers.any(Client.class));

			Mockito.verify(smsService).send(mobile, String.format("%s %s, you were registered", familyName, firstName));
			Mockito.verify(smsService).send(Matchers.eq(mobile), Matchers.anyString());
		}
	}
}
