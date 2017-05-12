package edu.sibinfo.spring.basic.module08.dao.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import edu.sibinfo.spring.basic.module08.dao.ClientDao;
import edu.sibinfo.spring.basic.module08.domain.Client;
import edu.sibinfo.spring.basic.module08.util.Log;

@Repository
public class ClientDaoImpl implements ClientDao {
	private AtomicLong lastId = new AtomicLong(0L); 
	private Map<Long, Client> clients = new ConcurrentHashMap<Long, Client>();
	
	public void save(Client client) {
		if (client.getId() == null) {
			client.setId(lastId.getAndIncrement());
			clients.put(client.getId(), client);
			Log.log("Added %s. Total: %d", client, clients.size());
		} else {
			Log.log("Saved %s. Total: %d", client, clients.size());
		}
	}

}
