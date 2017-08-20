package com.belhard.webappbank.beans;

public class RefillBean {

	private int account;
	private int idAccount;
	private int money;
	private int direction;
	

	public RefillBean() {
		super();
	}

	public RefillBean(int idAccount, int money) {
		super();
		this.idAccount = idAccount;
		this.money = money;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + direction;
		result = prime * result + idAccount;
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
		RefillBean other = (RefillBean) obj;
		if (account != other.account)
			return false;
		if (direction != other.direction)
			return false;
		if (idAccount != other.idAccount)
			return false;
		if (money != other.money)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RefillBean [account=" + account + ", idAccount=" + idAccount + ", money=" + money + ", direction="
				+ direction + "]";
	}

	
}
