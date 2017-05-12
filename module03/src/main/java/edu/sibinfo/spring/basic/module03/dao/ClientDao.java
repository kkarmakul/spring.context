package edu.sibinfo.spring.basic.module03.dao;

import java.util.Collection;

import edu.sibinfo.spring.basic.module03.domain.Client;

public interface ClientDao {
	void save(Client client);

	Collection<Client> getAll();
}
