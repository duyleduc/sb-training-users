package dinhgt.springboot.sbtrainingusers.interfaces;

import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;

public interface IAccountService {

	public AccountDTO create(AccountDTO account);
	
	public void getAllAccount();
	
}
