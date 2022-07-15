package com.example.springrestapi.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 64)
    private String lastName;

    @Column(length = 64)
    private String email;

    @Column(length = 10)
    private String phone;

    @Column(length = 8)
    private String firstName;

    @CreatedDate
    private Instant createDate;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public User(String lastName, String email, String phone, String firstName) {
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.firstName = firstName;
        this.createDate = Instant.now();
    }

    public User() {

    }

}
