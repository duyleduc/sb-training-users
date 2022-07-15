package dinhgt.springboot.sbtrainingusers.controllers;

public class AccountRestException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountRestException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountRestException(String message) {
		super(message);
	
	}

	public AccountRestException(Throwable cause) {
		super(cause);

	}

	
	
}
