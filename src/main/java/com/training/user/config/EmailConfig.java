package com.training.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailConfig {
    @Bean
    public JavaMailSender getJavaMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("levantuthptngtu@gmail.com");
        mailSender.setPassword("xrwwondykzlwkdev");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

//    @Bean
//    public SimpleMailMessage emailTemplate()
//    {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo("locppham1531995@gmail.com");
//        message.setFrom("truongtuhcmus1710@gmail.com");
//        message.setText("FATAL - Application crash. Save your job !!");
//        return message;
//    }
}
