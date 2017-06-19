package com.belhard.webappbank.beans;

public class ClientAllInfBean {
	
	private ClientBean client;
	private int countAcc;
	private int totalMoney;
	private int countCards;
	
	
	public ClientAllInfBean() {
		super();
	}


	public ClientBean getClient() {
		return client;
	}


	public void setClient(ClientBean client) {
		this.client = client;
	}


	public int getCountAcc() {
		return countAcc;
	}


	public void setCountAcc(int countAcc) {
		this.countAcc = countAcc;
	}


	public int getTotalMoney() {
		return totalMoney;
	}


	public void setTotalMoney(int totalMoney) {
		this.totalMoney = totalMoney;
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
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + countAcc;
		result = prime * result + countCards;
		result = prime * result + totalMoney;
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
		ClientAllInfBean other = (ClientAllInfBean) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (countAcc != other.countAcc)
			return false;
		if (countCards != other.countCards)
			return false;
		if (totalMoney != other.totalMoney)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ClientAllInfBean [client=" + client + ", countAcc=" + countAcc + ", totalMoney=" + totalMoney
				+ ", countCards=" + countCards + "]";
	}


	
	

}
