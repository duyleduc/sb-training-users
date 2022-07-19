package com.training.user.entities.user;

import com.training.user.entities.role.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
@Table(name="users")
@Slf4j
public class User {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private int id;
    private static final long OTP_VALID_DURATION = 5 * 60 * 1000;

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

    @Column(name="password")
    private String password;

    @Column(name="phone")
    private String phone;

    @Column(name="created_at")
    private LocalDateTime createdAt ;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "account_number"),inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;

    @Column(name="otp")
    private String otp;

    @Column(name="otp_requested_time")
    private Date otpRequestedTime;

    @Column(name="mail_verification_status")
    private Boolean mailVerificationStatus ;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        log.info("get current time {}", createdAt);
    }
//    public boolean isOTPRequired() {
//        if (this.getOtp() == null) {
//            return false;
//        }
//
//        long currentTimeInMillis = System.currentTimeMillis();
//        long otpRequestedTimeInMillis = this.otpRequestedTime.getTime();
//
//        if (otpRequestedTimeInMillis + OTP_VALID_DURATION < currentTimeInMillis) {
//            // OTP expires
//            return false;
//        }
//
//        return true;
//    }
}
