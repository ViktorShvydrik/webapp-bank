package com.belhard.webappbank.entity;


public class Accounts {

	
	private int idAccount;
	private int idClient;	
	private int status;
	private int account;
	private int money;
	private int cards;
	
	
	
	
	
	public Accounts() {
		super();
	}

	
	

	public Accounts(int idAccount, int idClient, int status, int account, int money, int cards) {
		super();
		this.idAccount = idAccount;
		this.idClient = idClient;
		this.status = status;
		this.account = account;
		this.money = money;
		this.cards = cards;
	}




	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setId_client(int idClient) {
		this.idClient = idClient;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getCards() {
		return cards;
	}

	public void setCards(int cards) {
		this.cards = cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + cards;
		result = prime * result + idAccount;
		result = prime * result + idClient;
		result = prime * result + money;
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
		Accounts other = (Accounts) obj;
		if (account != other.account)
			return false;
		if (cards != other.cards)
			return false;
		if (idAccount != other.idAccount)
			return false;
		if (idClient != other.idClient)
			return false;
		if (money != other.money)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Accounts [idAccount=" + idAccount + ", idClient=" + idClient + ", status=" + status + ", account="
				+ account + ", money=" + money + ", cards=" + cards + "]";
	}

	

}
