package edu.sibinfo.spring.basic.module02;

public interface ClientService {
	Client register(String firstName, String familyName, String phone);

	void setPassword(Client client, String password);
}
