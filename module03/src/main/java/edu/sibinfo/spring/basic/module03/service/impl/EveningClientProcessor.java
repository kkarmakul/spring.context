package edu.sibinfo.spring.basic.module03.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import edu.sibinfo.spring.basic.module03.domain.Client;
import edu.sibinfo.spring.basic.module03.service.ClientProcessor;

@Component
@Order(value=2)
public class EveningClientProcessor implements ClientProcessor {

	@Override
	public void process(Client client) {
		System.out.printf("%s %s, good evening!%n", client.getFamilyName(), client.getFirstName());
	}

}
