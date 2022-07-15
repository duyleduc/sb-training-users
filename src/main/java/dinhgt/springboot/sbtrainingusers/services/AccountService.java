package dinhgt.springboot.sbtrainingusers.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;
import dinhgt.springboot.sbtrainingusers.interfaces.IAccountService;
import dinhgt.springboot.sbtrainingusers.mapper.AccountModelMapper;
import dinhgt.springboot.sbtrainingusers.model.Account;
import dinhgt.springboot.sbtrainingusers.repositories.AccountRepository;
import dinhgt.springboot.sbtrainingusers.validates.ValidateField;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private AccountModelMapper accountModelMapper;
	
	@Override
	public AccountDTO create(AccountDTO account) {

		ValidateField.checkName(account.getFirtName());
		ValidateField.checkName(account.getLastName());
		ValidateField.checkEmail(account.getEmail());
		ValidateField.checkPhoneNumber(account.getPhone());
		account.setCreatedDate(LocalDateTime.now());
		Account accountResult = accountRepository.save(accountModelMapper.accountDAO(account));
		return accountModelMapper.accountDTO(accountResult);

	}

	@Override
	public void getAllAccount() {
		// TODO Auto-generated method stub

	}

}
