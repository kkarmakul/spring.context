package edu.sibinfo.spring.basic.module09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import edu.sibinfo.spring.basic.common09.dao.ClientDao;
import edu.sibinfo.spring.basic.common09.domain.Client;
import edu.sibinfo.spring.basic.module09.service.ClientRegisteredEvent;
import edu.sibinfo.spring.basic.module09.service.ClientService;
import edu.sibinfo.spring.basic.module09.service.impl.InternalSmsService;
import edu.sibinfo.spring.basic.module09.service.impl.WebSmsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"default", "webSms"})
public class ClientServiceTest {
    @Autowired
    private ClientService service;
    @Autowired
    private ClientDao dao;
    @MockBean
    private InternalSmsService internalSmsService;
    @MockBean
    private WebSmsService webBasedSmsService;
    
    @Test
    public void clientRegisters() {
        Client client = service.register("A", "B", "7");
        Client realClient = dao.getById(client.getId());
        assertNotNull(realClient);
        assertEquals("A", realClient.getFirstName());
        assertEquals("B", realClient.getFamilyName());
        assertEquals("7", realClient.getMobile());
        
        ArgumentCaptor<ClientRegisteredEvent> captor = ArgumentCaptor.forClass(ClientRegisteredEvent.class); 
        verify(internalSmsService).sendRegistrationNotification(captor.capture());
        assertSame(realClient, captor.getValue().getClient());
        
        verify(webBasedSmsService).sendRegistrationNotification(captor.capture());
        assertSame(realClient, captor.getValue().getClient());        
    }
}
