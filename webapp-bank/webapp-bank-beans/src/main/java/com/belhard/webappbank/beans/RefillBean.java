package com.belhard.webappbank.beans;

public class RefillBean {
	
	private int idAccount;
	private int money;
	
	
	public RefillBean() {
		super();
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		if (idAccount != other.idAccount)
			return false;
		if (money != other.money)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Refill [idAccount=" + idAccount + ", money=" + money + "]";
	}
	
	
	


}
