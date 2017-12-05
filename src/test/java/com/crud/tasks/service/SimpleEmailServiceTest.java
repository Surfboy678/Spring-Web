package com.crud.tasks.service;


import com.crud.tasks.domian.Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SimpleEmailServiceTest {
    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;


   /* @Test
    public void shouldSendEmail() {
        //Given
        Mail mail = new Mail("test@test.com", "Test", "test message",null);
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(mail.getMailTo());
        mailMessage.setText(mail.getMessage());
        mailMessage.setCc(mail.getToCc());
        mailMessage.setSubject(mail.getSubject());
        if(mail.getToCc() == null) {
            mailMessage.setCc(mail.getToCc());
        }

        //When
        simpleEmailService.send(mail);
        //Then
        verify(javaMailSender, times(1)).send(mailMessage);
        System.out.println(mail.getToCc());
    } */
}