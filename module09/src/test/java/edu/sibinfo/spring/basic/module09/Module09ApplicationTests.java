package edu.sibinfo.spring.basic.module09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.sibinfo.spring.basic.module09.dao.ClientDao;
import edu.sibinfo.spring.basic.module09.domain.Client;
import edu.sibinfo.spring.basic.module09.service.ClientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Module09ApplicationTests {
    @Autowired
    private ClientService service;
    @Autowired
    private ClientDao dao;
    
    @Test
    public void contextLoads() {
    }
    @Test
    public void clientRegisters() {
        Client client = service.register("A", "B", "7");
        Client realClient = dao.getById(client.getId());
        assertNotNull(realClient);
        assertEquals("A", realClient.getFirstName());
        assertEquals("B", realClient.getFamilyName());
        assertEquals("7", realClient.getMobile());
    }
}
