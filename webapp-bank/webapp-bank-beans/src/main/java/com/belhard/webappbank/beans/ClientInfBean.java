package com.belhard.webappbank.beans;

public class ClientInfBean {
	
	private int idClient;
	private String name;
	private String secondName;
	private String email;
	private int countAccounts;
	
	
	public ClientInfBean() {
		super();
	}


	public int getIdClient() {
		return idClient;
	}


	public void setIdClient(int idClient) {
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


	public int getCountAccounts() {
		return countAccounts;
	}


	public void setCountAccounts(int countAccounts) {
		this.countAccounts = countAccounts;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countAccounts;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		ClientInfBean other = (ClientInfBean) obj;
		if (countAccounts != other.countAccounts)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
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
		return "ClientInfBean [idClient=" + idClient + ", name=" + name + ", secondName=" + secondName + ", email="
				+ email + ", countAccounts=" + countAccounts + "]";
	}
	


}
