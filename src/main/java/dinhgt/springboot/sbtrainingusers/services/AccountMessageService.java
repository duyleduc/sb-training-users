package dinhgt.springboot.sbtrainingusers.services;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingusers.model.Account;
import dinhgt.springboot.sbtrainingusers.repositories.AccountRepository;

@Service
public class AccountMessageService {
	@Autowired
	private AccountRepository accountRepository;

	@RabbitListener(queues = "request_update_account")
	public void updateAccount(Map<String, String> message) {
		
		String email = message.get("email");
		Account account = accountRepository.findByEmailAndIsActived(email, false).get();
		account.setDeviceToken(message.get("OTP"));
		account.setActived(false);
		
		accountRepository.save(account);
		
		
	}
}
