package com.belhard.webappbank.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "accounts")
public class Accounts implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name ="id_account")
	private int idAccount;
	
	@ManyToOne
	@JoinColumn (name ="id_client")
	private Clients Client;	
	
	@Column (name = "status")
	private int status;
	
	@Column (name= "account")
	private int account;
	
	@Column (name ="money")
	private int money;
	
	@Column (name = "cards")
	private int cards;
	
	
	
	
	
	public Accounts() {
		super();
	}




	public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
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

	public Clients getClient() {
		return Client;
	}

	public void setClient(Clients client) {
		Client = client;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Client == null) ? 0 : Client.hashCode());
		result = prime * result + account;
		result = prime * result + cards;
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
		Accounts other = (Accounts) obj;
		if (Client == null) {
			if (other.Client != null)
				return false;
		} else if (!Client.equals(other.Client))
			return false;
		if (account != other.account)
			return false;
		if (cards != other.cards)
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
		return "Accounts [idAccount=" + idAccount + ", Client=" + Client + ", status=" + status + ", account=" + account
				+ ", money=" + money + ", cards=" + cards + "]";
	}

	

}
