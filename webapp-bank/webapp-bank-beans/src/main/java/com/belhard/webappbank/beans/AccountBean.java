package com.belhard.webappbank.beans;

public class AccountBean {

	private int idAccount;
	private ClientBean client;
	private int status;
	private int account;
	private int money;
	private int countCards;

	public AccountBean() {
		super();
	}
	

	public AccountBean(int account) {
		super();
		this.account = account;
	}


	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public ClientBean getClient() {
		return client;
	}

	public void setClient(ClientBean client) {
		this.client = client;
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

	public int getCountCards() {
		return countCards;
	}

	public void setCountCards(int countCards) {
		this.countCards = countCards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + countCards;
		result = prime * result + idAccount;
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
		AccountBean other = (AccountBean) obj;
		if (account != other.account)
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (countCards != other.countCards)
			return false;
		if (idAccount != other.idAccount)
			return false;
		if (money != other.money)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountBean [idAccount=" + idAccount + ", client=" + client + ", status=" + status + ", account="
				+ account + ", money=" + money + ", countCards=" + countCards + "]";
	}

	


}
