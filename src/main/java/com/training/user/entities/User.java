package com.training.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="users")
@Slf4j
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private int id;

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name="account_number")
    @Size( max = 64)
    private String  accountNumber;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

//    @Column(name="password")
//    private String password;

    @Column(name="phone")
    private String phone;

    @Column(name="created_at")
    private LocalDateTime createdAt ;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        log.info("get current time {}", createdAt);
    }
}
