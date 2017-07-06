package com.belhard.webappbank.beans;

public class TransferBean {

	private int idTransfer;
	private  AccountBean fromAcc;
	private int money;
	private AccountBean toAcc;
	private String login;

	public TransferBean() {
		super();
	}

	public TransferBean(int fromAcc, int money, int toAcc, String login) {
		super();
		AccountBean accountBean = new AccountBean(fromAcc);
		this.fromAcc = accountBean;
		this.money = money;
		accountBean = new AccountBean(toAcc);
		this.toAcc = accountBean;
		this.login = login;
	}



	public int getIdTransfer() {
		return idTransfer;
	}

	public void setIdTransfer(int idTransfer) {
		this.idTransfer = idTransfer;
	}

	public AccountBean getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(AccountBean fromAcc) {
		this.fromAcc = fromAcc;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public AccountBean getToAcc() {
		return toAcc;
	}

	public void setToAcc(AccountBean toAcc) {
		this.toAcc = toAcc;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fromAcc == null) ? 0 : fromAcc.hashCode());
		result = prime * result + idTransfer;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + money;
		result = prime * result + ((toAcc == null) ? 0 : toAcc.hashCode());
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
		TransferBean other = (TransferBean) obj;
		if (fromAcc == null) {
			if (other.fromAcc != null)
				return false;
		} else if (!fromAcc.equals(other.fromAcc))
			return false;
		if (idTransfer != other.idTransfer)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (money != other.money)
			return false;
		if (toAcc == null) {
			if (other.toAcc != null)
				return false;
		} else if (!toAcc.equals(other.toAcc))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransferBean [idTransfer=" + idTransfer + ", fromAcc=" + fromAcc + ", money=" + money + ", toAcc="
				+ toAcc + ", login=" + login + "]";
	}
	
	

	
}
