package com.belhard.webappbank.entity;

public class Clients {
	
	private int id_client;
	private String login;
	private String pass;
	private int status;
	private int access;
	
	
	public Clients (){
		
	}
	public Clients (int id_client){
		this.id_client = id_client;
	}
	
	public Clients (int id_client, String login, String pass, int status, int access){
		this.id_client = id_client;
		this. login = login;
		this.pass =pass;
		this.status = status;
		this.access = access;
		
	}
	
	
	public Clients(int id_client, String pass, int access) {
		super();
		this.id_client = id_client;
		this.pass = pass;
		this.access = access;
	}
	
	
	public Clients(int id_client, String login, String pass, int access) {
		super();
		this.id_client = id_client;
		this.login = login;
		this.pass = pass;
		this.access = access;
	}
	
	public Clients(String login, String pass, int access) {
		super();
		this.login = login;
		this.pass = pass;
		this.access = access;
	}
	public Clients(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + access;
		result = prime * result + id_client;
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
		if (id_client != other.id_client)
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
		return "Clients [id_client=" + id_client + ", login=" + login + ", pass=" + pass + ", status=" + status
				+ ", access=" + access + "]";
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
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
	
	

}
