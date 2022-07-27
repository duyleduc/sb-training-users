package dinhgt.springboot.sbtrainingusers.interfaces;

import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;

public interface IAccountService {

	 AccountDTO create(AccountDTO account);
	
	 void getAllAccount();
	 
	 AccountDTO update(AccountDTO account, int id);
	 
	 AccountDTO updateStatusAccount(AccountDTO account, int id);
	 
	 AccountDTO getByID(int id);
	
}
