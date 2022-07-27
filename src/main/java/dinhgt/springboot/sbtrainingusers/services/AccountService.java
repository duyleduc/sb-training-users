package dinhgt.springboot.sbtrainingusers.services;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingusers.controllers.AccountRestException;
import dinhgt.springboot.sbtrainingusers.controllers.AccountUpdateException;
import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;
import dinhgt.springboot.sbtrainingusers.interfaces.IAccountService;
import dinhgt.springboot.sbtrainingusers.model.Account;
import dinhgt.springboot.sbtrainingusers.repositories.AccountRepository;
import dinhgt.springboot.sbtrainingusers.validates.ValidateField;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ModelMapper accountModelMapper;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private PasswordEncoder bPasswordEncoder;

	@Autowired
	private ValidateField validateField;

	@Override
	public AccountDTO create(AccountDTO account) {
		validateField.validateField(account);

		account.setCreatedDate(LocalDateTime.now());
		account.setActivated(false);
		account.setPassword(bPasswordEncoder.encode(account.getPassword()));

		boolean checkDupEmail = accountRepository.existsByEmail(account.getEmail());
		if (checkDupEmail)
			throw new AccountRestException("Email exits!");

		Account accountResult = accountRepository.save(accountModelMapper.map(account, Account.class));

		rabbitTemplate.convertAndSend("send_mail", "rabbitmq.*", account.getEmail());

		return accountModelMapper.map(accountResult, AccountDTO.class);
	}

	@Override
	public void getAllAccount() {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountDTO update(AccountDTO account, int id) {

		if (Integer.compare(account.getId(), id) > 0 || Integer.compare(account.getId(), id) < 0)
			throw new AccountUpdateException("Id not match!!");
		validateField.validateField(account);
		account.setUpdateDate(LocalDateTime.now());

		boolean emailExits = accountRepository.existsByEmail(account.getEmail());
		if (emailExits)
			throw new AccountUpdateException("Duplicate email!");

		Account acc = accountRepository.getReferenceById(account.getId());
		if (acc == null)
			throw new AccountUpdateException("Cannot find account!");
		if (!acc.isActived())
			throw new AccountUpdateException("Account not active!");

		customMapping(account, acc);
		AccountDTO result = accountModelMapper.map(accountRepository.save(acc), AccountDTO.class);

		return result;

	}

	public void customMapping(AccountDTO account, Account accountDAO) {
		if (account.getEmail() != null)
			accountDAO.setEmail(account.getEmail());
		if (account.getLastName() != null)
			accountDAO.setLastName(account.getLastName());
		if (account.getFirtName() != null)
			accountDAO.setFirtName(account.getFirtName());
		if (account.getUpdateDate() != null)
			accountDAO.setUpdateDate(account.getUpdateDate());
		if (account.getPhone() != null)
			accountDAO.setPhone(account.getPhone());
	}

	@Override
	public AccountDTO updateStatusAccount(AccountDTO account, int id) {
		Account acc = accountRepository.findByEmailAndIsActived(account.getEmail(), false).get();

		if (acc == null)
			throw new AccountUpdateException("Cannot find account!");

		if (!acc.getDeviceToken().equals(account.getDeviceToken()))
			throw new AccountUpdateException("OTP not match!");

		acc.setActived(true);
		acc.setUpdateDate(LocalDateTime.now());
		acc.setDeviceToken("");

		return accountModelMapper.map(accountRepository.save(acc), AccountDTO.class);
	}

	@Override
	public AccountDTO getByID(int id) {

		return accountModelMapper.map(accountRepository.findById(id).get(), AccountDTO.class);
	}

}
