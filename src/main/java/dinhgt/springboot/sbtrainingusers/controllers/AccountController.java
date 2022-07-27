package dinhgt.springboot.sbtrainingusers.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;
import dinhgt.springboot.sbtrainingusers.interfaces.IAccountService;
import dinhgt.springboot.sbtrainingusers.validates.AccountValidate;

@RestController
@RequestMapping("/api/v1/public/accounts")
public class AccountController {
	

	@Autowired
	private IAccountService accountService;

	@PostMapping()
	public AccountDTO createAccount(@Valid @RequestBody AccountDTO account) {

		AccountValidate.validateAccount(account);
		AccountDTO accountDTO = accountService.create(account);

		return accountDTO;

	}
	
	@GetMapping("/{id}")
	public AccountDTO getAccountByID(@PathVariable int id) {
		return accountService.getByID(id);
	}
	
	@PutMapping("/{id}")
//	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public AccountDTO updateAccount(@RequestBody AccountDTO account, @PathVariable int id) {
		AccountDTO accountDTO;
		if(account.getDeviceToken() == null) {
			accountDTO = accountService.update(account, id);
		}else {
			accountDTO = accountService.updateStatusAccount(account, id);
		}
		return accountDTO;

	}
}
