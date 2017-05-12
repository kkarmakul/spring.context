package edu.sibinfo.spring.basic.module03.service.impl;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.sibinfo.spring.basic.module03.domain.Client;
import edu.sibinfo.spring.basic.module03.service.ClientProcessor;

@Component(value="morningProcessor")
@Scope("prototype")
@Order(value=1)
public class MorningClientProcessor implements ClientProcessor {
	static AtomicInteger instanceCounter = new AtomicInteger(0);
	private final int instanceNumber;
	
	public MorningClientProcessor() {
		this.instanceNumber = instanceCounter.incrementAndGet();
	}

	@Override
	public void process(Client client) {
		System.out.printf("Good morning, %s %s! (from %d)%n", 
				client.getFamilyName(), client.getFirstName(), 
				instanceNumber);
	}

}
