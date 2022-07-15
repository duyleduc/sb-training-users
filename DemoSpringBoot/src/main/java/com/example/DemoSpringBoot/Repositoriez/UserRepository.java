package com.example.DemoSpringBoot.Repositoriez;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DemoSpringBoot.Beans.Users;

public interface UserRepository extends JpaRepository<Users, BigInteger> {
}
