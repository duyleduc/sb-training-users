package dinhgt.springboot.sbtrainingusers.mapper;

import org.mapstruct.Mapper;

import dinhgt.springboot.sbtrainingusers.dtos.AccountDTO;
import dinhgt.springboot.sbtrainingusers.model.Account;

@Mapper(componentModel = "spring")
public interface AccountModelMapper {	

	AccountDTO accountDTO(Account account);

	Account accountDAO(AccountDTO accountDTO);
}
