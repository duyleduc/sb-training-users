package com.training.user.repositories;

import com.training.user.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByAccountNumber(String accountNumber);

    @Query(value = "SELECT * FROM users u WHERE u.email = :email",nativeQuery = true)
    User findByEmail(@Param("email") String email);
}
