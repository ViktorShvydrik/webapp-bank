package com.belhard.webappbank.beans;

public class CardBean {

	private int idCard;
	private int account;
	private String login;
	private int numberCard;
	private int status;

	public CardBean() {
		super();
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getNumberCard() {
		return numberCard;
	}

	public void setNumberCard(int numberCard) {
		this.numberCard = numberCard;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + idCard;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + numberCard;
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
		CardBean other = (CardBean) obj;
		if (account != other.account)
			return false;
		if (idCard != other.idCard)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (numberCard != other.numberCard)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CardBean [idCard=" + idCard + ", account=" + account + ", login=" + login + ", numberCard=" + numberCard
				+ ", status=" + status + "]";
	}

}
