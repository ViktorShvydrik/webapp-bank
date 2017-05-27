package com.belhard.webappbank.entity;

public class Accounts {

	
	private int id_account;
	
	private int status;
	private int account;
	private int money;
	private int cards;
	
	
	
	
	
	public Accounts(int status) {
		
		this.status = status;
	}

	public Accounts(int id_account, int status, int account, int money, int cards) {
		
		this.id_account = id_account;
		this.status = status;
		this.account = account;
		this.money = money;
		this.cards = cards;
	}
	
	public Accounts(int id_account, int status, int money, int cards) {
		super();
		this.id_account = id_account;
		this.status = status;
		this.money = money;
		this.cards = cards;
	}
	
	public Accounts(int status, int account) {
		
		this.status = status;
		this.account = account;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + cards;
		result = prime * result + id_account;
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
		if (id_account != other.id_account)
			return false;
		if (money != other.money)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	
	
	
	@Override
	public String toString() {
		return "Accounts [id_account=" + id_account + ", status=" + status + ", account=" + account + ", money=" + money
				+ ", cards=" + cards + "]";
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
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
	public void setCard(int cards) {
		this.cards = cards;
	}
	

}
