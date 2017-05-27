package com.belhard.webappbank.entity;

public class Client_inf {
	
	private int id_client;
	private String name;
	private int id_account;
	private int del_status;
	
	
	
	
	public Client_inf() {
		
	}
	
	
	public Client_inf(int id_client) {
		super();
		this.id_client = id_client;
	}


	public Client_inf(int id_client, String name, int id_account) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.id_account = id_account;
	}


	public Client_inf(int id_client, int del_status) {
		super();
		this.id_client = id_client;
		this.del_status = del_status;
	}


	public Client_inf(String name) {
		super();
		this.name = name;
	}


	public Client_inf(int id_client, String name) {
		super();
		this.id_client = id_client;
		this.name = name;
	}
	public Client_inf(String name, int id_account) {
		super();
		this.id_account = id_account;
		this.name = name;
	}
	

	public Client_inf(int id_client, String name, int id_account, int del_status) {
		super();
		this.id_client = id_client;
		this.name = name;
		this.id_account = id_account;
		this.del_status = del_status;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + del_status;
		result = prime * result + id_account;
		result = prime * result + id_client;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client_inf other = (Client_inf) obj;
		if (del_status != other.del_status)
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
		return true;
	}


	@Override
	public String toString() {
		return "Client_inf [id_client=" + id_client + ", name=" + name + ", id_account=" + id_account + ", del_status="
				+ del_status + "]";
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
