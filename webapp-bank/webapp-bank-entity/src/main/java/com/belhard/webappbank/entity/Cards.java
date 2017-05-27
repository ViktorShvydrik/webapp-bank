package com.belhard.webappbank.entity;

public class Cards {
	
	private int id_card;
	private int id_account;
	private int number_card;
	private int status;
	
	
	
	
	
	
	
	public Cards(int id_account, int number_card, int status) {
		super();
		this.id_account = id_account;
		this.number_card = number_card;
		this.status = status;
	}
	public Cards(int id_card, int id_account, int number_card, int status) {
		super();
		this.id_card = id_card;
		this.id_account = id_account;
		this.number_card = number_card;
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_account;
		result = prime * result + id_card;
		result = prime * result + number_card;
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
		if (id_account != other.id_account)
			return false;
		if (id_card != other.id_card)
			return false;
		if (number_card != other.number_card)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cards [id_card=" + id_card + ", id_account=" + id_account + ", number_card=" + number_card + ", status="
				+ status + "]";
	}
	public int getId_card() {
		return id_card;
	}
	public void setId_card(int id_card) {
		this.id_card = id_card;
	}
	public int getId_account() {
		return id_account;
	}
	public void setId_account(int id_account) {
		this.id_account = id_account;
	}
	public int getNumber_card() {
		return number_card;
	}
	public void setNumber_card(int number_card) {
		this.number_card = number_card;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
	
}
