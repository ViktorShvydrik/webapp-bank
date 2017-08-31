package com.belhard.webappbank.beans;

public class ClientBean {
	private int idClient;
	private String login;
	private String pass;
	private int status;
	private int access;
	private ClientInfBean inf;

	public ClientBean() {
		super();
	}

	public ClientBean(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
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

	public ClientInfBean getInf() {
		return inf;
	}

	public void setInf(ClientInfBean inf) {
		this.inf = inf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + access;
		result = prime * result + idClient;
		result = prime * result + ((inf == null) ? 0 : inf.hashCode());
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
		ClientBean other = (ClientBean) obj;
		if (access != other.access)
			return false;
		if (idClient != other.idClient)
			return false;
		if (inf == null) {
			if (other.inf != null)
				return false;
		} else if (!inf.equals(other.inf))
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
		return "ClientBean [idClient=" + idClient + ", login=" + login + ", pass=" + pass + ", status=" + status
				+ ", access=" + access + ", inf=" + inf + "]";
	}

}
