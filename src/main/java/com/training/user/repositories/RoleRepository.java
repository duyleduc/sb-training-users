package com.training.user.repositories;

import com.training.user.entities.role.Role;
import com.training.user.entities.role.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(RoleName name);
}
