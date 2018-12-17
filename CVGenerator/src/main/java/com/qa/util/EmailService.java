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

    @Value("${endpoint.emailsubject}")
    private String emailSubject;

    @Value("${endpoint.textbody}")
    private String textBody;

    public void sendEmail(String sendTo, String whoChanged) throws MessagingException {

        SimpleMailMessage email = new SimpleMailMessage();

        email.setTo(sendTo);
        email.setSubject(emailSubject);
        email.setFrom(emailFrom);
        email.setText(whoChanged + " " +textBody);
        javaMailSender.send(email);

    }

}
