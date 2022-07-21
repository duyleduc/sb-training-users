package com.training.user.services;

import com.training.user.entities.user.User;
import com.training.user.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserRepository userRepository;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public User saveUser(User user) {
        log.info("saving new user {} {} {} {} to database",user.getFirstName(),user.getLastName(),user.getAccountNumber(),user.getCreatedAt());

        return userRepository.save(user);
    }

    @Override
    public User getUserByAccountNumber(String accountNumber) {
        log.info("Fetching user with Account Number {} ",accountNumber);

        User user = userRepository.findByAccountNumber(accountNumber);
        if(user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }

        return user;
    }


    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        log.info("update user {} {} to database",user.getFirstName(),user.getLastName());
        User UserDB = userRepository.findByAccountNumber(user.getAccountNumber());
        if(UserDB == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
            );
        }
        user.setCreatedAt(UserDB.getCreatedAt());
        user.setAccountNumber(UserDB.getAccountNumber());
        userRepository.save(user);
        return userRepository.findByAccountNumber(user.getAccountNumber());
    }

    @Override
    public String removeUser(String accountNumber) {
         log.info("remove user with Account Number {} ",accountNumber);

         User user = userRepository.findByAccountNumber(accountNumber);
         if(user == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
             );
        }

         userRepository.delete(user);
         return accountNumber;
    }

    @Override
    public void generatedOTP(User user) throws UnsupportedEncodingException, MessagingException  {
        String OTP = RandomString.make(8);

        user.setOtp(OTP);
        user.setOtpRequestedTime(new Date());

        userRepository.save(user);

        sendOTPEmail(user, OTP);
    }

    @Override
    public void sendOTPEmail(User user, String OTP) throws UnsupportedEncodingException, MessagingException{
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("levantuthptngtu@gmail.com", "Shopme Support");
        helper.setTo(user.getEmail());

        String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";

        String content = "<p>Hello " + user.getFirstName() + "</p>"
                + "<p>For security reason, you're required to use the following "
                + "One Time Password to login:</p>"
                + "<p><b>" + OTP + "</b></p>"
                + "<br>"
                + "<p>Note: this OTP is set to expire in 5 minutes.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }

    @Override
    public void clearOTP(User user) {
        user.setOtp(null);
        user.setOtpRequestedTime(null);
        userRepository.save(user);
    }



}
