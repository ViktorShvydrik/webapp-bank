package com.belhard.webappbank.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "clients")
public class Clients implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_client")
	private int idClient;
	
	@Column (name = "login")
	private String login;
	
	@Column (name = "pass")
	private String pass;
	
	@Column (name = "status")
	private int status;
	
	@Column (name = "access")
	private int access;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name = "id_client")
	private ClientInf clientInf;
	
	public Clients (){
		
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
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

	public ClientInf getClientInf() {
		return clientInf;
	}

	public void setClientInf(ClientInf clientInf) {
		this.clientInf = clientInf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + access;
		result = prime * result + ((clientInf == null) ? 0 : clientInf.hashCode());
		result = prime * result + idClient;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
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
		Clients other = (Clients) obj;
		if (access != other.access)
			return false;
		if (clientInf == null) {
			if (other.clientInf != null)
				return false;
		} else if (!clientInf.equals(other.clientInf))
			return false;
		if (idClient != other.idClient)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clients [idClient=" + idClient + ", login=" + login + ", pass=" + pass + ", status=" + status
				+ ", access=" + access + ", clientInf=" + clientInf + "]";
	}

	

	
	

}
