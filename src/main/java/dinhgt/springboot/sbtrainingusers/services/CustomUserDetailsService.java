package dinhgt.springboot.sbtrainingusers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dinhgt.springboot.sbtrainingusers.model.Account;
import dinhgt.springboot.sbtrainingusers.repositories.AccountRepository;
import dinhgt.springboot.sbtrainingusers.security.UserDetailsImpl;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmailAndIsActived(username, true).get();
		System.err.println(account.getEmail());
		return UserDetailsImpl.build(account);
	}

}
