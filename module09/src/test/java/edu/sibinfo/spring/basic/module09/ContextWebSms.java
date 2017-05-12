package edu.sibinfo.spring.basic.module09;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import edu.sibinfo.spring.basic.module09.service.impl.InternalSmsService;
import edu.sibinfo.spring.basic.module09.service.impl.WebSmsService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("webSms")
public class ContextWebSms {
    @Autowired
    private ApplicationContext ctx;
  
    @Test(expected=NoSuchBeanDefinitionException.class)
    public void contextLoads() {
        assertNotNull(ctx.getBean(WebSmsService.class));
        assertNull(ctx.getBean(InternalSmsService.class));
    }
}
