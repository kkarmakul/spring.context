package edu.sibinfo.spring.basic.module01;

public class Client {
	private final String familyName;
	private final String firstName;
	private final String mobile;
	
	public Client(String familyName, String firstName, String mobile) {
		super();
		this.familyName = familyName;
		this.firstName = firstName;
		this.mobile = mobile;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [familyName=").append(familyName).append(", firstName=").append(firstName)
				.append(", mobile=").append(mobile).append("]");
		return builder.toString();
	}
	
	
}
