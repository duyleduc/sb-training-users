package dinhgt.springboot.sbtrainingusers.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;
import dinhgt.springboot.sbtrainingusers.interfaces.IAccountService;
import dinhgt.springboot.sbtrainingusers.validates.AccountValidate;

@RestController
@RequestMapping("/api")
public class AccountController {

//	@PostMapping("/send")
//	public void sendMessage(@RequestBody String string) {
//		rabbitTemplate.convertAndSend(ConfigReceiveMQ.EXCHANGE_NAME, ConfigReceiveMQ.ROUTING_KEY, string);
//	}

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	private IAccountService accountService;

	@PostMapping("/createAccount")
	public AccountDTO createAccount(@RequestBody AccountDTO account) {

		AccountValidate.validateAccount(account);
		AccountDTO accountDTO = accountService.create(account);
		
		return accountDTO;

	}
}
