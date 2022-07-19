package dinhgt.springboot.sbtrainingusers.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingusers.controllers.AccountUpdateException;
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

	@Override
	public AccountDTO update(AccountDTO account, int id) {
		if (Integer.compare(account.getId(), id) > 0 || Integer.compare(account.getId(), id) < 0)
			throw new AccountUpdateException("Id not match!!");

		ValidateField.checkName(account.getFirtName());
		ValidateField.checkName(account.getLastName());
		ValidateField.checkEmail(account.getEmail());
		ValidateField.checkPhoneNumber(account.getPhone());
		account.setUpdateDate(LocalDateTime.now());

		Account acc = accountRepository.getReferenceById(account.getId());

		if (acc == null)
			throw new AccountUpdateException("Cannot find account!");

		acc.setEmail(account.getEmail());
		acc.setLastName(account.getLastName());
		acc.setFirtName(account.getFirtName());
		acc.setUpdateDate(account.getUpdateDate());
		acc.setPhone(account.getPhone());
		
		AccountDTO result = accountModelMapper.accountDTO(accountRepository.save(acc));
		
		return result;

	}

}
