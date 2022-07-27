package dinhgt.springboot.sbtrainingusers.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhgt.springboot.sbtrainingusers.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	Optional<Account> findByEmailAndIsActived(String email, boolean isActivated);

	Boolean existsByEmail(String email);
}
