package com.belhard.webappbank.entity;

public class ClientInf {
	
	private int idClient;
	private String name;
	private String secondName;
	private String email;
	private int accounts;
	
	
	
	
	public ClientInf() {
		
	}
	
	
	public ClientInf(int idClient) {
		super();
		this.idClient = idClient;
	}


	public ClientInf(int idClient, String name, int accounts) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.accounts = accounts;
	}





	public ClientInf(String name) {
		super();
		this.name = name;
	}


	public ClientInf(int idClient, String name) {
		super();
		this.idClient = idClient;
		this.name = name;
	}
	public ClientInf(String name, int accounts) {
		super();
		this.accounts = accounts;
		this.name = name;
	}
	
	

	public ClientInf(int idClient, String name, String email, int accounts) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.email = email;
		this.accounts = accounts;
	}


	public ClientInf(int idClient, String name, String secondName, String email, int accounts) {
		super();
		this.idClient = idClient;
		this.name = name;
		this.secondName = secondName;
		this.email = email;
		this.accounts = accounts;

	}

	


	

	public int getIdClient() {
		return idClient;
	}


	public void setId_client(int idClient) {
		this.idClient = idClient;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSecondName() {
		return secondName;
	}


	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getIdAccounts() {
		return accounts;
	}


	public void setIdAccounts(int accounts) {
		this.accounts = accounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + accounts;
		result = prime * result + idClient;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientInf other = (ClientInf) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (accounts != other.accounts)
			return false;
		if (idClient != other.idClient)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "ClientInf [idClient=" + idClient + ", name=" + name + ", secondName=" + secondName + ", email="
				+ email + ", accounts=" + accounts + "]";
	}





	
	
	
	

}
