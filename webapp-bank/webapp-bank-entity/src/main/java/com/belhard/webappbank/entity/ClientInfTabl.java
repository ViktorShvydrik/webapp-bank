package com.belhard.webappbank.entity;

public class ClientInfTabl {
	
	private int idClient;
	private String login;
	private String pass;
	private String name;
	private String secondName;
	private String email;
	private int idAccount;
	private int status;
	private int access;
	
	
	public ClientInfTabl() {
		super();
	}


	public ClientInfTabl(int idClient, String login, String pass, String name, String secondName, String email,
			int idAccount, int status, int access) {
		super();
		this.idClient = idClient;
		this.login = login;
		this.pass = pass;
		this.name = name;
		this.secondName = secondName;
		this.email = email;
		this.idAccount = idAccount;
		this.status = status;
		this.access = access;
	}


	public int getIdClient() {
		return idClient;
	}


	public void setId_client(int idClient) {
		this.idClient = idClient;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
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


	public int getIdAccount() {
		return idAccount;
	}


	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getAccess() {
		return access;
	}


	public void setAccess(int access) {
		this.access = access;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + access;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + idAccount;
		result = prime * result + idClient;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		result = prime * result + ((secondName == null) ? 0 : secondName.hashCode());
		result = prime * result + status;
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
		ClientInfTabl other = (ClientInfTabl) obj;
		if (access != other.access)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idAccount != other.idAccount)
			return false;
		if (idClient != other.idClient)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (secondName == null) {
			if (other.secondName != null)
				return false;
		} else if (!secondName.equals(other.secondName))
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ClientsInfTabl [idClient=" + idClient + ", login=" + login + ", pass=" + pass + ", name=" + name
				+ ", secondName=" + secondName + ", email=" + email + ", idAccount=" + idAccount + ", status="
				+ status + ", access=" + access + "]";
	}

	
}
