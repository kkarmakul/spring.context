package edu.sibinfo.spring.basic.common09;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import edu.sibinfo.spring.basic.common09.dao.ClientDao;
import edu.sibinfo.spring.basic.common09.domain.Client;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes={CommonConfiguration.class})
public class CommonConfigurationTests {

	@Autowired
	private ClientDao clientDao;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void daoWorks() {
		Client client = new Client("A", "B", "7");
		clientDao.save(client);
		Client loadedClient = clientDao.getById(client.getId());
		assertEquals("A", loadedClient.getFamilyName());
		assertEquals("B", loadedClient.getFirstName());
		assertEquals("7", loadedClient.getMobile());
	}
}
