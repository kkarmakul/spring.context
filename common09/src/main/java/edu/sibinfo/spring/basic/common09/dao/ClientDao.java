package edu.sibinfo.spring.basic.common09.dao;

import edu.sibinfo.spring.basic.common09.domain.Client;

public interface ClientDao {
	void save(Client client);

    Client getById(Long id);
}
