package com.training.user.services;

import com.training.user.entities.user.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUserByAccountNumber(String accountNumber);
    List<User> getUsers();

    User updateUser(User user);

    String removeUser(String accountNumber);

    void generatedOTP(User user) throws UnsupportedEncodingException, MessagingException;
    void sendOTPEmail(User user,String OTP) throws UnsupportedEncodingException, MessagingException;
    void clearOTP(User user) ;

//    Boolean validateOtpCodeEmail();
}
