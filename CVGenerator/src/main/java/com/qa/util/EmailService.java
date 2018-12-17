package com.qa.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    @Value("${mail.username}")
    private String emailFrom;

    public void sendEmail(String sendTo, String whoChanged) throws MessagingException {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(sendTo);
        email.setSubject("A tagged user has made a change");
        email.setFrom(emailFrom);
        email.setText("User " + whoChanged + " has made a change");
        javaMailSender.send(email);

    }

}
