package com.crud.tasks.service;


import com.crud.tasks.domian.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SimpleEmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(final Mail mail){
        LOGGER.info("Starting email preparation...");
        try {
            javaMailSender.send(createMaiMessage(mail));
            LOGGER.info("Email has been set.");
        }catch (MailException e){
            LOGGER.error("Failed to process email sending",e.getMessage(), e);

        }
    }

    private SimpleMailMessage createMaiMessage(final Mail mail){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());
        return mailMessage;
    }
}