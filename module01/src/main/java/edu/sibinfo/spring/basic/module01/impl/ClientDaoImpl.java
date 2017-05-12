package edu.sibinfo.spring.basic.module01.impl;

import java.util.ArrayList;
import java.util.List;

import edu.sibinfo.spring.basic.module01.Client;
import edu.sibinfo.spring.basic.module01.ClientDao;

public class ClientDaoImpl implements ClientDao {
	private List<Client> clients = new ArrayList<Client>();
	
	public void save(Client client) {
		clients.add(client);
		System.out.printf("Added %s. Total: %d", client, clients.size()).println();
	}

}
