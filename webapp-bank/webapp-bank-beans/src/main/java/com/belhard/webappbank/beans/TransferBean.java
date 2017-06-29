package com.belhard.webappbank.beans;

public class TransferBean {

	private int idTransfer;
	private int fromAcc;
	private int money;
	private int toAcc;

	public TransferBean() {
		super();
	}

	public int getIdTransfer() {
		return idTransfer;
	}

	public void setIdTransfer(int idTransfer) {
		this.idTransfer = idTransfer;
	}

	public int getFromAcc() {
		return fromAcc;
	}

	public void setFromAcc(int fromAcc) {
		this.fromAcc = fromAcc;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getToAcc() {
		return toAcc;
	}

	public void setToAcc(int toAcc) {
		this.toAcc = toAcc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fromAcc;
		result = prime * result + idTransfer;
		result = prime * result + money;
		result = prime * result + toAcc;
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
		if (fromAcc != other.fromAcc)
			return false;
		if (idTransfer != other.idTransfer)
			return false;
		if (money != other.money)
			return false;
		if (toAcc != other.toAcc)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransfersBean [idTransfer=" + idTransfer + ", fromAcc=" + fromAcc + ", money=" + money + ", toAcc="
				+ toAcc + "]";
	}

}
