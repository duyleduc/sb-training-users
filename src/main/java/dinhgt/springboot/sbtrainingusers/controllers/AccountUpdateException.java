package dinhgt.springboot.sbtrainingusers.controllers;

public class AccountUpdateException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountUpdateException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public AccountUpdateException(String message) {
		super(message);
	
	}

	public AccountUpdateException(Throwable cause) {
		super(cause);

	}

}
