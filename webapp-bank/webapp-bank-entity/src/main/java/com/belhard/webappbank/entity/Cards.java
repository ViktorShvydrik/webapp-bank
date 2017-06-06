package com.belhard.webappbank.entity;

public class Cards {
	
	private int idCard;
	private int idAccount;
	private int idClient;
	private int numberCard;
	private int status;
	
	
	public Cards() {
		super();
	}
	
	


	public Cards(int idCard, int idAccount, int idClient, int numberCard, int status) {
		super();
		this.idCard = idCard;
		this.idAccount = idAccount;
		this.idClient = idClient;
		this.numberCard = numberCard;
		this.status = status;
	}




	public int getIdCard() {
		return idCard;
	}


	public void setIdCard(int idCard) {
		this.idCard = idCard;
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


	public void setIdClient(int idClient) {
		this.idClient = idClient;
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
		result = prime * result + idAccount;
		result = prime * result + idCard;
		result = prime * result + idClient;
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
		Cards other = (Cards) obj;
		if (idAccount != other.idAccount)
			return false;
		if (idCard != other.idCard)
			return false;
		if (idClient != other.idClient)
			return false;
		if (numberCard != other.numberCard)
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cards [idCard=" + idCard + ", idAccount=" + idAccount + ", idClient=" + idClient + ", numberCard="
				+ numberCard + ", status=" + status + "]";
	}
	
	
	
	

	
}
