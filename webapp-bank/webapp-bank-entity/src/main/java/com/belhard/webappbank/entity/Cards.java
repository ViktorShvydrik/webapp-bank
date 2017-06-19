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
@Table (name = "cards")
public class Cards implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "id_card")
	private int idCard;
	
	@ManyToOne
	@JoinColumn (name = "id_account")
	private Accounts account;
	
	@ManyToOne
	@JoinColumn (name = "id_client")
	private Clients client;
	
	@Column (name = "number_card")
	private int numberCard;
	
	@Column (name = "status")
	private int status;
	
	
	public Cards() {
		super();
	}
	

	public int getIdCard() {
		return idCard;
	}


	public void setIdCard(int idCard) {
		this.idCard = idCard;
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


	public Accounts getAccount() {
		return account;
	}


	public void setAccount(Accounts account) {
		this.account = account;
	}


	public Clients getClient() {
		return client;
	}


	public void setClient(Clients client) {
		this.client = client;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + idCard;
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
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (idCard != other.idCard)
			return false;
		if (numberCard != other.numberCard)
			return false;
		if (status != other.status)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Cards [idCard=" + idCard + ", account=" + account + ", client=" + client + ", numberCard=" + numberCard
				+ ", status=" + status + "]";
	}

	
	

	
}
