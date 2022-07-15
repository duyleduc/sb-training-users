package com.example.springrestapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springrestapi.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}