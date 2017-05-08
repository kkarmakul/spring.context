package edu.sibinfo.spring.basic.module09.dao;

import edu.sibinfo.spring.basic.module09.domain.Client;

public interface ClientDao {
	void save(Client client);

    Client getById(Long id);
}
