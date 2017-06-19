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
@Table (name ="")
public class Transfers implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name ="id_transfers")
	private int idTransfers;
	
	@ManyToOne
	@JoinColumn(name = "id_accountCA")
	private Accounts accountCA;
	
	@Column(name = "money")
	private int money;
	
	@ManyToOne
	@JoinColumn(name = "id_accountCB")
	private Accounts accountCB;

	public Transfers() {
		super();
	}

	public int getIdTransfers() {
		return idTransfers;
	}

	public void setIdTransfers(int idTransfers) {
		this.idTransfers = idTransfers;
	}

	public Accounts getAccountCA() {
		return accountCA;
	}

	public void setAccountCA(Accounts accountCA) {
		this.accountCA = accountCA;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public Accounts getAccountCB() {
		return accountCB;
	}

	public void setAccountCB(Accounts accountCB) {
		this.accountCB = accountCB;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountCA == null) ? 0 : accountCA.hashCode());
		result = prime * result + ((accountCB == null) ? 0 : accountCB.hashCode());
		result = prime * result + idTransfers;
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
		Transfers other = (Transfers) obj;
		if (accountCA == null) {
			if (other.accountCA != null)
				return false;
		} else if (!accountCA.equals(other.accountCA))
			return false;
		if (accountCB == null) {
			if (other.accountCB != null)
				return false;
		} else if (!accountCB.equals(other.accountCB))
			return false;
		if (idTransfers != other.idTransfers)
			return false;
		if (money != other.money)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transfers [idTransfers=" + idTransfers + ", accountCA=" + accountCA + ", money=" + money
				+ ", accountCB=" + accountCB + "]";
	}
	

	
	
}
