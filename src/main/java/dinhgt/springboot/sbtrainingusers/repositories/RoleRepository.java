package dinhgt.springboot.sbtrainingusers.repositories;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dinhgt.springboot.sbtrainingusers.enums.ERole;
import dinhgt.springboot.sbtrainingusers.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	Optional<Role> findByRoleName(ERole name);
}
