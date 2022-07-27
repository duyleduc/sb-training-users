package dinhgt.springboot.sbtrainingusers.validates;

import dinhgt.springboot.sbtrainingusers.controllers.AccountRestException;
import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;

public class AccountValidate {

	public static void validateAccount(AccountDTO account) {

		if (account.getFirtName() == null) {
			throw new AccountRestException("Fristname cannot empty");
		} else if (account.getLastName() == null) {
			throw new AccountRestException("Lastname cannot empty!");
		} else if (account.getEmail() == null) {
			throw new AccountRestException("Email cannot empty!");
		} else if (account.getPhone() == null) {
			throw new AccountRestException("Phone cannot empty!");
		} else if (account.getPassword() == null) {
			throw new AccountRestException("Password cannot empty!");
		}
	}

}
