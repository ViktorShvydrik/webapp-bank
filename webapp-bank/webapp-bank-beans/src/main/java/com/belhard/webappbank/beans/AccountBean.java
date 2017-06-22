package com.belhard.webappbank.beans;

public class AccountBean {

	private int idAccount;
	private String Login;
	private int status;
	private int account;
	private int money;
	private int countCards;

	public AccountBean() {
		super();
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getLogin() {
		return Login;
	}

	public void setLogin(String login) {
		Login = login;
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
		result = prime * result + ((Login == null) ? 0 : Login.hashCode());
		result = prime * result + account;
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
		if (Login == null) {
			if (other.Login != null)
				return false;
		} else if (!Login.equals(other.Login))
			return false;
		if (account != other.account)
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
		return "AccountBean [idAccount=" + idAccount + ", Login=" + Login + ", status=" + status + ", account="
				+ account + ", money=" + money + ", countCards=" + countCards + "]";
	}

}
