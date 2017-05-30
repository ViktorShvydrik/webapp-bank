package com.belhard.webappbank.entity;

public class ClientInf {
	
	private int id_client;
	private String name;
	private String secondName;
	private String email;
	private int id_account;
	private int del_status;
	
	
	
	
	public ClientInf() {
		
	}
	
	
	public ClientInf(int id_client) {
		super();
		this.id_client = id_client;
	}


	public ClientInf(int id_client, String name, int id_account) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.id_account = id_account;
	}


	public ClientInf(int id_client, int del_status) {
		super();
		this.id_client = id_client;
		this.del_status = del_status;
	}


	public ClientInf(String name) {
		super();
		this.name = name;
	}


	public ClientInf(int id_client, String name) {
		super();
		this.id_client = id_client;
		this.name = name;
	}
	public ClientInf(String name, int id_account) {
		super();
		this.id_account = id_account;
		this.name = name;
	}
	

	public ClientInf(int id_client, String name, int id_account, int del_status) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.id_account = id_account;
		this.del_status = del_status;
	}
	
	

	public ClientInf(int id_client, String name, String email, int id_account, int del_status) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.email = email;
		this.id_account = id_account;
		this.del_status = del_status;
	}


	public ClientInf(int id_client, String name, String secondName, String email, int id_account, int del_status) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.secondName = secondName;
		this.email = email;
		this.id_account = id_account;
		this.del_status = del_status;
	}

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + del_status;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id_account;
		result = prime * result + id_client;
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
		if (del_status != other.del_status)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id_account != other.id_account)
			return false;
		if (id_client != other.id_client)
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
		return "ClientInf [id_client=" + id_client + ", name=" + name + ", secondName=" + secondName + ", email="
				+ email + ", id_account=" + id_account + ", del_status=" + del_status + "]";
	}


	public int getId_client() {
		return id_client;
	}


	public void setId_client(int id_client) {
		this.id_client = id_client;
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


	public int getId_account() {
		return id_account;
	}


	public void setId_account(int id_account) {
		this.id_account = id_account;
	}


	public int getDel_status() {
		return del_status;
	}


	public void setDel_status(int del_status) {
		this.del_status = del_status;
	}


	
	
	
	

}
