package com.belhard.webappbank.entity;

public class Transfers {

	private int id_transfers;
	private int id_client;
	private int money;
	private int id_account;
	
	public Transfers() {
	//NOOP		
	}
	
	
	public Transfers(int id_transfers) {
		
		this.id_transfers = id_transfers;
	}


	public Transfers(int id_client, int money, int id_account) {
		super();
		this.id_client = id_client;
		this.money = money;
		this.id_account = id_account;
	}


	public Transfers(int id_transfers, int id_client, int money, int id_account) {
		
		this.id_transfers = id_transfers;
		this.id_client = id_client;
		this.money = money;
		this.id_account = id_account;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_account;
		result = prime * result + id_client;
		result = prime * result + id_transfers;
		result = prime * result + money;
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
		Transfers other = (Transfers) obj;
		if (id_account != other.id_account)
			return false;
		if (id_client != other.id_client)
			return false;
		if (id_transfers != other.id_transfers)
			return false;
		if (money != other.money)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transfers [id_transfers=" + id_transfers + ", id_client=" + id_client + ", money=" + money
				+ ", id_account=" + id_account + "]";
	}
	public int getId_transfers() {
		return id_transfers;
	}
	public void setId_transfers(int id_transfers) {
		this.id_transfers = id_transfers;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	
	
	
}
