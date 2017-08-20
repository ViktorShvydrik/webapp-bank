package com.belhard.webappbank.service.Exception;

public class AccountsServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AccountsServiceException(){
	}
	
	public AccountsServiceException(String msg) {
		super(msg);
	}
	
	public AccountsServiceException(String msg, Throwable t) {
		super(msg, t);
	}

}
