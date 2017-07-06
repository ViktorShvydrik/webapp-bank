package com.belhard.webappbank.service.Exception;

public class TransferException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TransferException(String msg) {
		super(msg);
	}
	
	public TransferException(String msg, Throwable t) {
		super(msg, t);
	}
}
