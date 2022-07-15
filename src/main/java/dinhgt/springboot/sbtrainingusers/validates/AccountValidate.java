package dinhgt.springboot.sbtrainingusers.validates;


import dinhgt.springboot.sbtrainingusers.controllers.AccountRestException;
import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;

public class AccountValidate {

	public static void validateAccount(AccountDTO account) {
		
		if(account.getFirtName().isEmpty()) {
			throw new AccountRestException("Fristname cannot empty");
		}
		else if(account.getLastName().isEmpty()) {
			throw new AccountRestException("Lastname cannot empty!");
		}
		else if(account.getEmail().isEmpty()) {
			throw new AccountRestException("Email cannot empty!");
		}
		else if(account.getPhone().isEmpty()) {
			throw new AccountRestException("Email cannot empty!");
		}
	}
	
}
