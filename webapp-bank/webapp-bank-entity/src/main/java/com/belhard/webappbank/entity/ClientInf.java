package com.belhard.webappbank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "clientInf")
public class ClientInf implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column (name = "id_Client")
	private int idClient;
	
	@Column (name = "name")
	private String name;
	
	@Column (name = "secondName")
	private String secondName;
	
	@Column (name = "email")
	private String email;
	
	@Column (name = "accounts")
	private int accounts;
	
	
	
	public ClientInf() {
		
	}

	

	public int getIdClient() {
		return idClient;
	}


	public void setIdСlient(int idClient) {
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


	public int getAccounts() {
		return accounts;
	}


	public void setAccounts(int accounts) {
		this.accounts = accounts;
	}


	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accounts;
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
		ClientInf other = (ClientInf) obj;
		if (accounts != other.accounts)
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
		return "ClientInf [idClient=" + idClient + ", name=" + name + ", secondName=" + secondName + ", email=" + email
				+ ", accounts=" + accounts + "]";
	}



	
	

}
