package edu.sibinfo.spring.basic.module08.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import edu.sibinfo.spring.basic.module08.dao.ClientDao;
import edu.sibinfo.spring.basic.module08.domain.Client;

@Repository
public class ClientDaoImpl implements ClientDao {
	private AtomicLong lastId = new AtomicLong(0L); 
	private Map<Long, Client> clients = new HashMap<Long, Client>();
	
	public void save(Client client) {
		if (client.getId() == null) {
			client.setId(lastId.getAndIncrement());
			clients.put(client.getId(), client);
			System.out.printf("[%d] Added %s. Total: %d", getThreadId(), client, clients.size()).println();
		} else {
			System.out.printf("[%d] Saved %s. Total: %d", getThreadId(), client, clients.size()).println();
		}
	}

	private long getThreadId() {
		return Thread.currentThread().getId();
	}
}
